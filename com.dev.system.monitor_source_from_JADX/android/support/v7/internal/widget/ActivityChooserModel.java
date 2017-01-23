package android.support.v7.internal.widget;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.database.DataSetObservable;
import android.os.AsyncTask;
import android.os.Build.VERSION;
import android.text.TextUtils;
import android.util.Log;
import android.util.Xml;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.xmlpull.v1.XmlSerializer;

public class ActivityChooserModel extends DataSetObservable {
    private static final String ATTRIBUTE_ACTIVITY = "activity";
    private static final String ATTRIBUTE_TIME = "time";
    private static final String ATTRIBUTE_WEIGHT = "weight";
    private static final boolean DEBUG = false;
    private static final int DEFAULT_ACTIVITY_INFLATION = 5;
    private static final float DEFAULT_HISTORICAL_RECORD_WEIGHT = 1.0f;
    public static final String DEFAULT_HISTORY_FILE_NAME = "activity_choser_model_history.xml";
    public static final int DEFAULT_HISTORY_MAX_LENGTH = 50;
    private static final String HISTORY_FILE_EXTENSION = ".xml";
    private static final int INVALID_INDEX = -1;
    private static final String LOG_TAG;
    private static final String TAG_HISTORICAL_RECORD = "historical-record";
    private static final String TAG_HISTORICAL_RECORDS = "historical-records";
    private static final Map<String, ActivityChooserModel> sDataModelRegistry;
    private static final Object sRegistryLock;
    private final List<ActivityResolveInfo> mActivities;
    private OnChooseActivityListener mActivityChoserModelPolicy;
    private ActivitySorter mActivitySorter;
    private boolean mCanReadHistoricalData;
    private final Context mContext;
    private final List<HistoricalRecord> mHistoricalRecords;
    private boolean mHistoricalRecordsChanged;
    private final String mHistoryFileName;
    private int mHistoryMaxSize;
    private final Object mInstanceLock;
    private Intent mIntent;
    private boolean mReadShareHistoryCalled;
    private boolean mReloadActivities;

    public interface ActivityChooserModelClient {
        void setActivityChooserModel(ActivityChooserModel activityChooserModel);
    }

    public final class ActivityResolveInfo implements Comparable<ActivityResolveInfo> {
        public final ResolveInfo resolveInfo;
        public float weight;

        public ActivityResolveInfo(ResolveInfo resolveInfo) {
            this.resolveInfo = resolveInfo;
        }

        public int hashCode() {
            return Float.floatToIntBits(this.weight) + 31;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null) {
                return ActivityChooserModel.DEBUG;
            }
            if (getClass() != obj.getClass()) {
                return ActivityChooserModel.DEBUG;
            }
            if (Float.floatToIntBits(this.weight) != Float.floatToIntBits(((ActivityResolveInfo) obj).weight)) {
                return ActivityChooserModel.DEBUG;
            }
            return true;
        }

        public int compareTo(ActivityResolveInfo another) {
            return Float.floatToIntBits(another.weight) - Float.floatToIntBits(this.weight);
        }

        public String toString() {
            StringBuilder builder = new StringBuilder();
            builder.append("[");
            builder.append("resolveInfo:").append(this.resolveInfo.toString());
            builder.append("; weight:").append(new BigDecimal((double) this.weight));
            builder.append("]");
            return builder.toString();
        }
    }

    public interface ActivitySorter {
        void sort(Intent intent, List<ActivityResolveInfo> list, List<HistoricalRecord> list2);
    }

    public static final class HistoricalRecord {
        public final ComponentName activity;
        public final long time;
        public final float weight;

        public HistoricalRecord(String activityName, long time, float weight) {
            this(ComponentName.unflattenFromString(activityName), time, weight);
        }

        public HistoricalRecord(ComponentName activityName, long time, float weight) {
            this.activity = activityName;
            this.time = time;
            this.weight = weight;
        }

        public int hashCode() {
            return (((((this.activity == null ? 0 : this.activity.hashCode()) + 31) * 31) + ((int) (this.time ^ (this.time >>> 32)))) * 31) + Float.floatToIntBits(this.weight);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null) {
                return ActivityChooserModel.DEBUG;
            }
            if (getClass() != obj.getClass()) {
                return ActivityChooserModel.DEBUG;
            }
            HistoricalRecord other = (HistoricalRecord) obj;
            if (this.activity == null) {
                if (other.activity != null) {
                    return ActivityChooserModel.DEBUG;
                }
            } else if (!this.activity.equals(other.activity)) {
                return ActivityChooserModel.DEBUG;
            }
            if (this.time != other.time) {
                return ActivityChooserModel.DEBUG;
            }
            if (Float.floatToIntBits(this.weight) != Float.floatToIntBits(other.weight)) {
                return ActivityChooserModel.DEBUG;
            }
            return true;
        }

        public String toString() {
            StringBuilder builder = new StringBuilder();
            builder.append("[");
            builder.append("; activity:").append(this.activity);
            builder.append("; time:").append(this.time);
            builder.append("; weight:").append(new BigDecimal((double) this.weight));
            builder.append("]");
            return builder.toString();
        }
    }

    public interface OnChooseActivityListener {
        boolean onChooseActivity(ActivityChooserModel activityChooserModel, Intent intent);
    }

    private final class PersistHistoryAsyncTask extends AsyncTask<Object, Void, Void> {
        private PersistHistoryAsyncTask() {
        }

        public Void doInBackground(Object... args) {
            List<HistoricalRecord> historicalRecords = args[0];
            String hostoryFileName = args[1];
            try {
                FileOutputStream fos = ActivityChooserModel.this.mContext.openFileOutput(hostoryFileName, 0);
                XmlSerializer serializer = Xml.newSerializer();
                try {
                    serializer.setOutput(fos, null);
                    serializer.startDocument("UTF-8", Boolean.valueOf(true));
                    serializer.startTag(null, ActivityChooserModel.TAG_HISTORICAL_RECORDS);
                    int recordCount = historicalRecords.size();
                    for (int i = 0; i < recordCount; i++) {
                        HistoricalRecord record = (HistoricalRecord) historicalRecords.remove(0);
                        serializer.startTag(null, ActivityChooserModel.TAG_HISTORICAL_RECORD);
                        serializer.attribute(null, ActivityChooserModel.ATTRIBUTE_ACTIVITY, record.activity.flattenToString());
                        serializer.attribute(null, ActivityChooserModel.ATTRIBUTE_TIME, String.valueOf(record.time));
                        serializer.attribute(null, ActivityChooserModel.ATTRIBUTE_WEIGHT, String.valueOf(record.weight));
                        serializer.endTag(null, ActivityChooserModel.TAG_HISTORICAL_RECORD);
                    }
                    serializer.endTag(null, ActivityChooserModel.TAG_HISTORICAL_RECORDS);
                    serializer.endDocument();
                    ActivityChooserModel.this.mCanReadHistoricalData = true;
                    if (fos != null) {
                        try {
                            fos.close();
                        } catch (IOException e) {
                        }
                    }
                } catch (IllegalArgumentException iae) {
                    Log.e(ActivityChooserModel.LOG_TAG, "Error writing historical recrod file: " + ActivityChooserModel.this.mHistoryFileName, iae);
                    ActivityChooserModel.this.mCanReadHistoricalData = true;
                    if (fos != null) {
                        try {
                            fos.close();
                        } catch (IOException e2) {
                        }
                    }
                } catch (IllegalStateException ise) {
                    Log.e(ActivityChooserModel.LOG_TAG, "Error writing historical recrod file: " + ActivityChooserModel.this.mHistoryFileName, ise);
                    ActivityChooserModel.this.mCanReadHistoricalData = true;
                    if (fos != null) {
                        try {
                            fos.close();
                        } catch (IOException e3) {
                        }
                    }
                } catch (IOException ioe) {
                    Log.e(ActivityChooserModel.LOG_TAG, "Error writing historical recrod file: " + ActivityChooserModel.this.mHistoryFileName, ioe);
                    ActivityChooserModel.this.mCanReadHistoricalData = true;
                    if (fos != null) {
                        try {
                            fos.close();
                        } catch (IOException e4) {
                        }
                    }
                } catch (Throwable th) {
                    ActivityChooserModel.this.mCanReadHistoricalData = true;
                    if (fos != null) {
                        try {
                            fos.close();
                        } catch (IOException e5) {
                        }
                    }
                }
                return null;
            } catch (FileNotFoundException fnfe) {
                Log.e(ActivityChooserModel.LOG_TAG, "Error writing historical recrod file: " + hostoryFileName, fnfe);
                return null;
            }
        }
    }

    private final class DefaultSorter implements ActivitySorter {
        private static final float WEIGHT_DECAY_COEFFICIENT = 0.95f;
        private final Map<String, ActivityResolveInfo> mPackageNameToActivityMap;

        private DefaultSorter() {
            this.mPackageNameToActivityMap = new HashMap();
        }

        public void sort(Intent intent, List<ActivityResolveInfo> activities, List<HistoricalRecord> historicalRecords) {
            int i;
            Map<String, ActivityResolveInfo> packageNameToActivityMap = this.mPackageNameToActivityMap;
            packageNameToActivityMap.clear();
            int activityCount = activities.size();
            for (i = 0; i < activityCount; i++) {
                ActivityResolveInfo activity = (ActivityResolveInfo) activities.get(i);
                activity.weight = 0.0f;
                packageNameToActivityMap.put(activity.resolveInfo.activityInfo.packageName, activity);
            }
            int lastShareIndex = historicalRecords.size() + ActivityChooserModel.INVALID_INDEX;
            float nextRecordWeight = ActivityChooserModel.DEFAULT_HISTORICAL_RECORD_WEIGHT;
            for (i = lastShareIndex; i >= 0; i += ActivityChooserModel.INVALID_INDEX) {
                HistoricalRecord historicalRecord = (HistoricalRecord) historicalRecords.get(i);
                activity = (ActivityResolveInfo) packageNameToActivityMap.get(historicalRecord.activity.getPackageName());
                if (activity != null) {
                    activity.weight += historicalRecord.weight * nextRecordWeight;
                    nextRecordWeight *= WEIGHT_DECAY_COEFFICIENT;
                }
            }
            Collections.sort(activities);
        }
    }

    static {
        LOG_TAG = ActivityChooserModel.class.getSimpleName();
        sRegistryLock = new Object();
        sDataModelRegistry = new HashMap();
    }

    public static ActivityChooserModel get(Context context, String historyFileName) {
        ActivityChooserModel dataModel;
        synchronized (sRegistryLock) {
            dataModel = (ActivityChooserModel) sDataModelRegistry.get(historyFileName);
            if (dataModel == null) {
                dataModel = new ActivityChooserModel(context, historyFileName);
                sDataModelRegistry.put(historyFileName, dataModel);
            }
        }
        return dataModel;
    }

    private ActivityChooserModel(Context context, String historyFileName) {
        this.mInstanceLock = new Object();
        this.mActivities = new ArrayList();
        this.mHistoricalRecords = new ArrayList();
        this.mActivitySorter = new DefaultSorter();
        this.mHistoryMaxSize = DEFAULT_HISTORY_MAX_LENGTH;
        this.mCanReadHistoricalData = true;
        this.mReadShareHistoryCalled = DEBUG;
        this.mHistoricalRecordsChanged = true;
        this.mReloadActivities = DEBUG;
        this.mContext = context.getApplicationContext();
        if (TextUtils.isEmpty(historyFileName) || historyFileName.endsWith(HISTORY_FILE_EXTENSION)) {
            this.mHistoryFileName = historyFileName;
        } else {
            this.mHistoryFileName = historyFileName + HISTORY_FILE_EXTENSION;
        }
    }

    public void setIntent(Intent intent) {
        synchronized (this.mInstanceLock) {
            if (this.mIntent == intent) {
                return;
            }
            this.mIntent = intent;
            this.mReloadActivities = true;
            ensureConsistentState();
        }
    }

    public Intent getIntent() {
        Intent intent;
        synchronized (this.mInstanceLock) {
            intent = this.mIntent;
        }
        return intent;
    }

    public int getActivityCount() {
        int size;
        synchronized (this.mInstanceLock) {
            ensureConsistentState();
            size = this.mActivities.size();
        }
        return size;
    }

    public ResolveInfo getActivity(int index) {
        ResolveInfo resolveInfo;
        synchronized (this.mInstanceLock) {
            ensureConsistentState();
            resolveInfo = ((ActivityResolveInfo) this.mActivities.get(index)).resolveInfo;
        }
        return resolveInfo;
    }

    public int getActivityIndex(ResolveInfo activity) {
        int i;
        synchronized (this.mInstanceLock) {
            ensureConsistentState();
            List<ActivityResolveInfo> activities = this.mActivities;
            int activityCount = activities.size();
            i = 0;
            while (i < activityCount) {
                if (((ActivityResolveInfo) activities.get(i)).resolveInfo == activity) {
                    break;
                }
                i++;
            }
            i = INVALID_INDEX;
        }
        return i;
    }

    public Intent chooseActivity(int index) {
        synchronized (this.mInstanceLock) {
            if (this.mIntent == null) {
                return null;
            }
            ensureConsistentState();
            ActivityResolveInfo chosenActivity = (ActivityResolveInfo) this.mActivities.get(index);
            ComponentName chosenName = new ComponentName(chosenActivity.resolveInfo.activityInfo.packageName, chosenActivity.resolveInfo.activityInfo.name);
            Intent choiceIntent = new Intent(this.mIntent);
            choiceIntent.setComponent(chosenName);
            if (this.mActivityChoserModelPolicy != null) {
                if (this.mActivityChoserModelPolicy.onChooseActivity(this, new Intent(choiceIntent))) {
                    return null;
                }
            }
            addHisoricalRecord(new HistoricalRecord(chosenName, System.currentTimeMillis(), (float) DEFAULT_HISTORICAL_RECORD_WEIGHT));
            return choiceIntent;
        }
    }

    public void setOnChooseActivityListener(OnChooseActivityListener listener) {
        synchronized (this.mInstanceLock) {
            this.mActivityChoserModelPolicy = listener;
        }
    }

    public ResolveInfo getDefaultActivity() {
        synchronized (this.mInstanceLock) {
            ensureConsistentState();
            if (this.mActivities.isEmpty()) {
                return null;
            }
            ResolveInfo resolveInfo = ((ActivityResolveInfo) this.mActivities.get(0)).resolveInfo;
            return resolveInfo;
        }
    }

    public void setDefaultActivity(int index) {
        synchronized (this.mInstanceLock) {
            float weight;
            ensureConsistentState();
            ActivityResolveInfo newDefaultActivity = (ActivityResolveInfo) this.mActivities.get(index);
            ActivityResolveInfo oldDefaultActivity = (ActivityResolveInfo) this.mActivities.get(0);
            if (oldDefaultActivity != null) {
                weight = (oldDefaultActivity.weight - newDefaultActivity.weight) + 5.0f;
            } else {
                weight = DEFAULT_HISTORICAL_RECORD_WEIGHT;
            }
            addHisoricalRecord(new HistoricalRecord(new ComponentName(newDefaultActivity.resolveInfo.activityInfo.packageName, newDefaultActivity.resolveInfo.activityInfo.name), System.currentTimeMillis(), weight));
        }
    }

    private void persistHistoricalDataIfNeeded() {
        if (!this.mReadShareHistoryCalled) {
            throw new IllegalStateException("No preceding call to #readHistoricalData");
        } else if (this.mHistoricalRecordsChanged) {
            this.mHistoricalRecordsChanged = DEBUG;
            if (!TextUtils.isEmpty(this.mHistoryFileName)) {
                if (VERSION.SDK_INT >= 11) {
                    executePersistHistoryAsyncTaskSDK11();
                } else {
                    executePersistHistoryAsyncTaskBase();
                }
            }
        }
    }

    private void executePersistHistoryAsyncTaskBase() {
        new PersistHistoryAsyncTask().execute(new Object[]{new ArrayList(this.mHistoricalRecords), this.mHistoryFileName});
    }

    private void executePersistHistoryAsyncTaskSDK11() {
        new PersistHistoryAsyncTask().executeOnExecutor(AsyncTask.SERIAL_EXECUTOR, new Object[]{new ArrayList(this.mHistoricalRecords), this.mHistoryFileName});
    }

    public void setActivitySorter(ActivitySorter activitySorter) {
        synchronized (this.mInstanceLock) {
            if (this.mActivitySorter == activitySorter) {
                return;
            }
            this.mActivitySorter = activitySorter;
            if (sortActivitiesIfNeeded()) {
                notifyChanged();
            }
        }
    }

    public void setHistoryMaxSize(int historyMaxSize) {
        synchronized (this.mInstanceLock) {
            if (this.mHistoryMaxSize == historyMaxSize) {
                return;
            }
            this.mHistoryMaxSize = historyMaxSize;
            pruneExcessiveHistoricalRecordsIfNeeded();
            if (sortActivitiesIfNeeded()) {
                notifyChanged();
            }
        }
    }

    public int getHistoryMaxSize() {
        int i;
        synchronized (this.mInstanceLock) {
            i = this.mHistoryMaxSize;
        }
        return i;
    }

    public int getHistorySize() {
        int size;
        synchronized (this.mInstanceLock) {
            ensureConsistentState();
            size = this.mHistoricalRecords.size();
        }
        return size;
    }

    private void ensureConsistentState() {
        boolean stateChanged = loadActivitiesIfNeeded() | readHistoricalDataIfNeeded();
        pruneExcessiveHistoricalRecordsIfNeeded();
        if (stateChanged) {
            sortActivitiesIfNeeded();
            notifyChanged();
        }
    }

    private boolean sortActivitiesIfNeeded() {
        if (this.mActivitySorter == null || this.mIntent == null || this.mActivities.isEmpty() || this.mHistoricalRecords.isEmpty()) {
            return DEBUG;
        }
        this.mActivitySorter.sort(this.mIntent, this.mActivities, Collections.unmodifiableList(this.mHistoricalRecords));
        return true;
    }

    private boolean loadActivitiesIfNeeded() {
        if (!this.mReloadActivities || this.mIntent == null) {
            return DEBUG;
        }
        this.mReloadActivities = DEBUG;
        this.mActivities.clear();
        List<ResolveInfo> resolveInfos = this.mContext.getPackageManager().queryIntentActivities(this.mIntent, 0);
        int resolveInfoCount = resolveInfos.size();
        for (int i = 0; i < resolveInfoCount; i++) {
            this.mActivities.add(new ActivityResolveInfo((ResolveInfo) resolveInfos.get(i)));
        }
        return true;
    }

    private boolean readHistoricalDataIfNeeded() {
        if (!this.mCanReadHistoricalData || !this.mHistoricalRecordsChanged || TextUtils.isEmpty(this.mHistoryFileName)) {
            return DEBUG;
        }
        this.mCanReadHistoricalData = DEBUG;
        this.mReadShareHistoryCalled = true;
        readHistoricalDataImpl();
        return true;
    }

    private boolean addHisoricalRecord(HistoricalRecord historicalRecord) {
        boolean added = this.mHistoricalRecords.add(historicalRecord);
        if (added) {
            this.mHistoricalRecordsChanged = true;
            pruneExcessiveHistoricalRecordsIfNeeded();
            persistHistoricalDataIfNeeded();
            sortActivitiesIfNeeded();
            notifyChanged();
        }
        return added;
    }

    private void pruneExcessiveHistoricalRecordsIfNeeded() {
        int pruneCount = this.mHistoricalRecords.size() - this.mHistoryMaxSize;
        if (pruneCount > 0) {
            this.mHistoricalRecordsChanged = true;
            for (int i = 0; i < pruneCount; i++) {
                HistoricalRecord historicalRecord = (HistoricalRecord) this.mHistoricalRecords.remove(0);
            }
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void readHistoricalDataImpl() {
        /*
        r18 = this;
        r3 = 0;
        r0 = r18;
        r15 = r0.mContext;	 Catch:{ FileNotFoundException -> 0x0023 }
        r0 = r18;
        r0 = r0.mHistoryFileName;	 Catch:{ FileNotFoundException -> 0x0023 }
        r16 = r0;
        r3 = r15.openFileInput(r16);	 Catch:{ FileNotFoundException -> 0x0023 }
        r8 = android.util.Xml.newPullParser();	 Catch:{ XmlPullParserException -> 0x0039, IOException -> 0x0092 }
        r15 = 0;
        r8.setInput(r3, r15);	 Catch:{ XmlPullParserException -> 0x0039, IOException -> 0x0092 }
        r12 = 0;
    L_0x0018:
        r15 = 1;
        if (r12 == r15) goto L_0x0025;
    L_0x001b:
        r15 = 2;
        if (r12 == r15) goto L_0x0025;
    L_0x001e:
        r12 = r8.next();	 Catch:{ XmlPullParserException -> 0x0039, IOException -> 0x0092 }
        goto L_0x0018;
    L_0x0023:
        r4 = move-exception;
    L_0x0024:
        return;
    L_0x0025:
        r15 = "historical-records";
        r16 = r8.getName();	 Catch:{ XmlPullParserException -> 0x0039, IOException -> 0x0092 }
        r15 = r15.equals(r16);	 Catch:{ XmlPullParserException -> 0x0039, IOException -> 0x0092 }
        if (r15 != 0) goto L_0x0062;
    L_0x0031:
        r15 = new org.xmlpull.v1.XmlPullParserException;	 Catch:{ XmlPullParserException -> 0x0039, IOException -> 0x0092 }
        r16 = "Share records file does not start with historical-records tag.";
        r15.<init>(r16);	 Catch:{ XmlPullParserException -> 0x0039, IOException -> 0x0092 }
        throw r15;	 Catch:{ XmlPullParserException -> 0x0039, IOException -> 0x0092 }
    L_0x0039:
        r14 = move-exception;
        r15 = LOG_TAG;	 Catch:{ all -> 0x00e9 }
        r16 = new java.lang.StringBuilder;	 Catch:{ all -> 0x00e9 }
        r16.<init>();	 Catch:{ all -> 0x00e9 }
        r17 = "Error reading historical recrod file: ";
        r16 = r16.append(r17);	 Catch:{ all -> 0x00e9 }
        r0 = r18;
        r0 = r0.mHistoryFileName;	 Catch:{ all -> 0x00e9 }
        r17 = r0;
        r16 = r16.append(r17);	 Catch:{ all -> 0x00e9 }
        r16 = r16.toString();	 Catch:{ all -> 0x00e9 }
        r0 = r16;
        android.util.Log.e(r15, r0, r14);	 Catch:{ all -> 0x00e9 }
        if (r3 == 0) goto L_0x0024;
    L_0x005c:
        r3.close();	 Catch:{ IOException -> 0x0060 }
        goto L_0x0024;
    L_0x0060:
        r15 = move-exception;
        goto L_0x0024;
    L_0x0062:
        r0 = r18;
        r5 = r0.mHistoricalRecords;	 Catch:{ XmlPullParserException -> 0x0039, IOException -> 0x0092 }
        r5.clear();	 Catch:{ XmlPullParserException -> 0x0039, IOException -> 0x0092 }
    L_0x0069:
        r12 = r8.next();	 Catch:{ XmlPullParserException -> 0x0039, IOException -> 0x0092 }
        r15 = 1;
        if (r12 != r15) goto L_0x0078;
    L_0x0070:
        if (r3 == 0) goto L_0x0024;
    L_0x0072:
        r3.close();	 Catch:{ IOException -> 0x0076 }
        goto L_0x0024;
    L_0x0076:
        r15 = move-exception;
        goto L_0x0024;
    L_0x0078:
        r15 = 3;
        if (r12 == r15) goto L_0x0069;
    L_0x007b:
        r15 = 4;
        if (r12 == r15) goto L_0x0069;
    L_0x007e:
        r7 = r8.getName();	 Catch:{ XmlPullParserException -> 0x0039, IOException -> 0x0092 }
        r15 = "historical-record";
        r15 = r15.equals(r7);	 Catch:{ XmlPullParserException -> 0x0039, IOException -> 0x0092 }
        if (r15 != 0) goto L_0x00bd;
    L_0x008a:
        r15 = new org.xmlpull.v1.XmlPullParserException;	 Catch:{ XmlPullParserException -> 0x0039, IOException -> 0x0092 }
        r16 = "Share records file not well-formed.";
        r15.<init>(r16);	 Catch:{ XmlPullParserException -> 0x0039, IOException -> 0x0092 }
        throw r15;	 Catch:{ XmlPullParserException -> 0x0039, IOException -> 0x0092 }
    L_0x0092:
        r6 = move-exception;
        r15 = LOG_TAG;	 Catch:{ all -> 0x00e9 }
        r16 = new java.lang.StringBuilder;	 Catch:{ all -> 0x00e9 }
        r16.<init>();	 Catch:{ all -> 0x00e9 }
        r17 = "Error reading historical recrod file: ";
        r16 = r16.append(r17);	 Catch:{ all -> 0x00e9 }
        r0 = r18;
        r0 = r0.mHistoryFileName;	 Catch:{ all -> 0x00e9 }
        r17 = r0;
        r16 = r16.append(r17);	 Catch:{ all -> 0x00e9 }
        r16 = r16.toString();	 Catch:{ all -> 0x00e9 }
        r0 = r16;
        android.util.Log.e(r15, r0, r6);	 Catch:{ all -> 0x00e9 }
        if (r3 == 0) goto L_0x0024;
    L_0x00b5:
        r3.close();	 Catch:{ IOException -> 0x00ba }
        goto L_0x0024;
    L_0x00ba:
        r15 = move-exception;
        goto L_0x0024;
    L_0x00bd:
        r15 = 0;
        r16 = "activity";
        r0 = r16;
        r2 = r8.getAttributeValue(r15, r0);	 Catch:{ XmlPullParserException -> 0x0039, IOException -> 0x0092 }
        r15 = 0;
        r16 = "time";
        r0 = r16;
        r15 = r8.getAttributeValue(r15, r0);	 Catch:{ XmlPullParserException -> 0x0039, IOException -> 0x0092 }
        r10 = java.lang.Long.parseLong(r15);	 Catch:{ XmlPullParserException -> 0x0039, IOException -> 0x0092 }
        r15 = 0;
        r16 = "weight";
        r0 = r16;
        r15 = r8.getAttributeValue(r15, r0);	 Catch:{ XmlPullParserException -> 0x0039, IOException -> 0x0092 }
        r13 = java.lang.Float.parseFloat(r15);	 Catch:{ XmlPullParserException -> 0x0039, IOException -> 0x0092 }
        r9 = new android.support.v7.internal.widget.ActivityChooserModel$HistoricalRecord;	 Catch:{ XmlPullParserException -> 0x0039, IOException -> 0x0092 }
        r9.<init>(r2, r10, r13);	 Catch:{ XmlPullParserException -> 0x0039, IOException -> 0x0092 }
        r5.add(r9);	 Catch:{ XmlPullParserException -> 0x0039, IOException -> 0x0092 }
        goto L_0x0069;
    L_0x00e9:
        r15 = move-exception;
        if (r3 == 0) goto L_0x00ef;
    L_0x00ec:
        r3.close();	 Catch:{ IOException -> 0x00f0 }
    L_0x00ef:
        throw r15;
    L_0x00f0:
        r16 = move-exception;
        goto L_0x00ef;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v7.internal.widget.ActivityChooserModel.readHistoricalDataImpl():void");
    }
}
