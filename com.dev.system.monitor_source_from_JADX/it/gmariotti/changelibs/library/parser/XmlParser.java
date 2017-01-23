package it.gmariotti.changelibs.library.parser;

import android.content.Context;
import android.util.Log;
import android.util.Xml;
import it.gmariotti.changelibs.library.Constants;
import it.gmariotti.changelibs.library.Util;
import it.gmariotti.changelibs.library.internal.ChangeLog;
import it.gmariotti.changelibs.library.internal.ChangeLogAdapter;
import it.gmariotti.changelibs.library.internal.ChangeLogException;
import it.gmariotti.changelibs.library.internal.ChangeLogRow;
import it.gmariotti.changelibs.library.internal.ChangeLogRowHeader;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

public class XmlParser extends BaseParser {
    private static final String ATTRIBUTE_BULLETEDLIST = "bulletedList";
    private static final String ATTRIBUTE_CHANGEDATE = "changeDate";
    private static final String ATTRIBUTE_CHANGETEXTTITLE = "changeTextTitle";
    private static final String ATTRIBUTE_VERSIONCODE = "versionCode";
    private static final String ATTRIBUTE_VERSIONNAME = "versionName";
    private static String TAG = null;
    private static final String TAG_CHANGELOG = "changelog";
    private static final String TAG_CHANGELOGBUG = "changelogbug";
    private static final String TAG_CHANGELOGIMPROVEMENT = "changelogimprovement";
    private static final String TAG_CHANGELOGTEXT = "changelogtext";
    private static final String TAG_CHANGELOGVERSION = "changelogversion";
    private static List<String> mChangeLogTags;
    protected ChangeLogAdapter mChangeLogAdapter;
    private int mChangeLogFileResourceId;
    private String mChangeLogFileResourceUrl;

    /* renamed from: it.gmariotti.changelibs.library.parser.XmlParser.1 */
    static class C02171 extends ArrayList<String> {
        C02171() {
            add(XmlParser.TAG_CHANGELOGBUG);
            add(XmlParser.TAG_CHANGELOGIMPROVEMENT);
            add(XmlParser.TAG_CHANGELOGTEXT);
        }
    }

    static {
        TAG = "XmlParser";
        mChangeLogTags = new C02171();
    }

    public XmlParser(Context context) {
        super(context);
        this.mChangeLogFileResourceId = Constants.mChangeLogFileResourceId;
        this.mChangeLogFileResourceUrl = null;
    }

    public XmlParser(Context context, int changeLogFileResourceId) {
        super(context);
        this.mChangeLogFileResourceId = Constants.mChangeLogFileResourceId;
        this.mChangeLogFileResourceUrl = null;
        this.mChangeLogFileResourceId = changeLogFileResourceId;
    }

    public XmlParser(Context context, String changeLogFileResourceUrl) {
        super(context);
        this.mChangeLogFileResourceId = Constants.mChangeLogFileResourceId;
        this.mChangeLogFileResourceUrl = null;
        this.mChangeLogFileResourceUrl = changeLogFileResourceUrl;
    }

    public ChangeLog readChangeLogFile() throws Exception {
        XmlPullParserException xpe;
        ChangeLog changeLog;
        IOException ioe;
        InputStream is = null;
        try {
            if (this.mChangeLogFileResourceUrl == null) {
                is = this.mContext.getResources().openRawResource(this.mChangeLogFileResourceId);
            } else if (Util.isConnected(this.mContext)) {
                is = new URL(this.mChangeLogFileResourceUrl).openStream();
            }
            if (is != null) {
                XmlPullParser parser = Xml.newPullParser();
                parser.setFeature("http://xmlpull.org/v1/doc/features.html#process-namespaces", false);
                parser.setInput(is, null);
                parser.nextTag();
                ChangeLog chg = new ChangeLog();
                try {
                    readChangeLogNode(parser, chg);
                    is.close();
                    return chg;
                } catch (XmlPullParserException e) {
                    xpe = e;
                    changeLog = chg;
                    Log.d(TAG, "XmlPullParseException while parsing changelog file", xpe);
                    throw xpe;
                } catch (IOException e2) {
                    ioe = e2;
                    changeLog = chg;
                    Log.d(TAG, "Error i/o with changelog.xml", ioe);
                    throw ioe;
                }
            }
            Log.d(TAG, "Changelog.xml not found");
            throw new ChangeLogException("Changelog.xml not found");
        } catch (XmlPullParserException e3) {
            xpe = e3;
            Log.d(TAG, "XmlPullParseException while parsing changelog file", xpe);
            throw xpe;
        } catch (IOException e4) {
            ioe = e4;
            Log.d(TAG, "Error i/o with changelog.xml", ioe);
            throw ioe;
        }
    }

    protected void readChangeLogNode(XmlPullParser parser, ChangeLog changeLog) throws Exception {
        if (parser != null && changeLog != null) {
            parser.require(2, null, TAG_CHANGELOG);
            String bulletedList = parser.getAttributeValue(null, ATTRIBUTE_BULLETEDLIST);
            if (bulletedList == null || bulletedList.equals("true")) {
                changeLog.setBulletedList(true);
                this.bulletedList = true;
            } else {
                changeLog.setBulletedList(false);
                this.bulletedList = false;
            }
            while (parser.next() != 3) {
                if (parser.getEventType() == 2 && parser.getName().equals(TAG_CHANGELOGVERSION)) {
                    readChangeLogVersionNode(parser, changeLog);
                }
            }
        }
    }

    protected void readChangeLogVersionNode(XmlPullParser parser, ChangeLog changeLog) throws Exception {
        if (parser != null) {
            parser.require(2, null, TAG_CHANGELOGVERSION);
            String versionName = parser.getAttributeValue(null, ATTRIBUTE_VERSIONNAME);
            String versionCodeStr = parser.getAttributeValue(null, ATTRIBUTE_VERSIONCODE);
            int versionCode = 0;
            if (versionCodeStr != null) {
                try {
                    versionCode = Integer.parseInt(versionCodeStr);
                } catch (NumberFormatException e) {
                    Log.w(TAG, "Error while parsing versionCode.It must be a numeric value. Check you file.");
                }
            }
            String changeDate = parser.getAttributeValue(null, ATTRIBUTE_CHANGEDATE);
            if (versionName == null) {
                throw new ChangeLogException("VersionName required in changeLogVersion node");
            }
            ChangeLogRowHeader row = new ChangeLogRowHeader();
            row.setVersionName(versionName);
            row.setChangeDate(changeDate);
            changeLog.addRow(row);
            while (parser.next() != 3) {
                if (parser.getEventType() == 2) {
                    if (mChangeLogTags.contains(parser.getName())) {
                        readChangeLogRowNode(parser, changeLog, versionName, versionCode);
                    }
                }
            }
        }
    }

    private void readChangeLogRowNode(XmlPullParser parser, ChangeLog changeLog, String versionName, int versionCode) throws Exception {
        int i = 1;
        if (parser != null) {
            String tag = parser.getName();
            ChangeLogRow row = new ChangeLogRow();
            row.setVersionName(versionName);
            row.setVersionCode(versionCode);
            String changeLogTextTitle = parser.getAttributeValue(null, ATTRIBUTE_CHANGETEXTTITLE);
            if (changeLogTextTitle != null) {
                row.setChangeTextTitle(changeLogTextTitle);
            }
            String bulletedList = parser.getAttributeValue(null, ATTRIBUTE_BULLETEDLIST);
            if (bulletedList == null) {
                row.setBulletedList(this.bulletedList);
            } else if (bulletedList.equals("true")) {
                row.setBulletedList(true);
            } else {
                row.setBulletedList(false);
            }
            if (parser.next() == 4) {
                String changeLogText = parser.getText();
                if (changeLogText == null) {
                    throw new ChangeLogException("ChangeLogText required in changeLogText node");
                }
                row.parseChangeText(changeLogText);
                if (!tag.equalsIgnoreCase(TAG_CHANGELOGBUG)) {
                    i = tag.equalsIgnoreCase(TAG_CHANGELOGIMPROVEMENT) ? 2 : 0;
                }
                row.setType(i);
                parser.nextTag();
            }
            changeLog.addRow(row);
        }
    }

    public void setChangeLogAdapter(ChangeLogAdapter changeLogAdapter) {
        this.mChangeLogAdapter = changeLogAdapter;
    }
}
