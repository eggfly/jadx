package com.aide.ui.activities;

import android.app.ActionBar;
import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.ArrayAdapter;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import com.aide.common.m;
import com.aide.engine.FileHighlightings;
import com.aide.ui.R;
import com.aide.ui.ThemedActionbarActivity;
import com.aide.ui.e;
import com.aide.ui.j;
import com.aide.ui.scm.DiffView;
import com.aide.ui.scm.GitStatus;
import com.aide.ui.scm.ModifiedFile;
import com.aide.ui.scm.ModifiedFileListEntry;
import com.aide.ui.scm.b.c;
import com.aide.ui.scm.b.d;
import com.aide.ui.views.CodeEditTextScrollView;
import com.aide.ui.views.SplitView;
import java.io.File;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import nu;
import pl$c;
import qh;

public class CommitActivity extends ThemedActionbarActivity implements pl$c {
    private BitSet DW;
    private List<ModifiedFile> FH;
    private Map<ModifiedFile, String> Hw;
    private b Zo;
    private int j6;
    private String v5;

    class 1 implements OnItemClickListener {
        final /* synthetic */ CommitActivity DW;
        final /* synthetic */ ListView j6;

        1(CommitActivity commitActivity, ListView listView) {
            this.DW = commitActivity;
            this.j6 = listView;
        }

        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            this.j6.requestFocus();
            this.DW.j6(i);
        }
    }

    class 2 implements OnItemLongClickListener {
        final /* synthetic */ CommitActivity DW;
        final /* synthetic */ ListView j6;

        2(CommitActivity commitActivity, ListView listView) {
            this.DW = commitActivity;
            this.j6 = listView;
        }

        public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j) {
            this.j6.requestFocus();
            ((ModifiedFileListEntry) view).j6();
            return true;
        }
    }

    class 3 implements Runnable {
        final /* synthetic */ CommitActivity j6;

        3(CommitActivity commitActivity) {
            this.j6 = commitActivity;
        }

        public void run() {
            List j6 = this.j6.Hw();
            e.ei().j6(this.j6.v5, j6, new a(this.j6, j6));
        }
    }

    class 4 implements d<String> {
        final /* synthetic */ CommitActivity DW;
        final /* synthetic */ ModifiedFile j6;

        4(CommitActivity commitActivity, ModifiedFile modifiedFile) {
            this.DW = commitActivity;
            this.j6 = modifiedFile;
        }

        public void j6() {
        }

        public void j6(String str) {
            this.DW.Hw.put(this.j6, str);
            ModifiedFile Hw = this.DW.Zo();
            if (Hw != null && Hw == this.j6) {
                DiffView j6 = this.DW.j6();
                if (!qh.DW(str)) {
                    j6.j6(str, this.j6.j6, this.j6.j6);
                } else if (this.j6.FH() || this.j6.Hw()) {
                    j6.setInformationalContent("Removed binary file");
                } else {
                    j6.setInformationalContent("Binary files differ");
                }
            }
        }

        public void DW() {
        }
    }

    class 5 implements Runnable {
        final /* synthetic */ CommitActivity DW;
        final /* synthetic */ String j6;

        5(CommitActivity commitActivity, String str) {
            this.DW = commitActivity;
            this.j6 = str;
        }

        public void run() {
            List j6 = this.DW.Hw();
            e.ei().j6(this.DW.v5, j6, this.j6, new a(this.DW, j6));
        }
    }

    private class a implements c {
        private List<ModifiedFile> DW;
        final /* synthetic */ CommitActivity j6;

        public a(CommitActivity commitActivity, List<ModifiedFile> list) {
            this.j6 = commitActivity;
            this.DW = list;
        }

        public void j6(Void voidR) {
            HashSet hashSet = new HashSet();
            List arrayList = new ArrayList();
            for (ModifiedFile modifiedFile : this.DW) {
                hashSet.add(modifiedFile.j6);
            }
            for (ModifiedFile modifiedFile2 : this.j6.FH) {
                if (!hashSet.contains(modifiedFile2.j6)) {
                    arrayList.add(modifiedFile2);
                }
            }
            if (arrayList.isEmpty()) {
                this.j6.finish();
                return;
            }
            this.j6.FH = arrayList;
            this.j6.FH();
        }

        public void j6() {
        }

        public void DW() {
        }
    }

    private class b extends ArrayAdapter<ModifiedFile> {
        final /* synthetic */ CommitActivity j6;

        class 1 implements OnCheckedChangeListener {
            final /* synthetic */ b DW;
            final /* synthetic */ int j6;

            1(b bVar, int i) {
                this.DW = bVar;
                this.j6 = i;
            }

            public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                this.DW.j6.DW.set(this.j6, z);
            }
        }

        public b(CommitActivity commitActivity, Context context, List<ModifiedFile> list) {
            this.j6 = commitActivity;
            super(context, R.c.commitbrowser_modifiedfile_entry, list);
        }

        public View getView(int i, View view, ViewGroup viewGroup) {
            boolean z = false;
            if (((ModifiedFileListEntry) view) != null) {
                throw new IllegalStateException();
            }
            ModifiedFileListEntry modifiedFileListEntry = (ModifiedFileListEntry) LayoutInflater.from(getContext()).inflate(R.c.commitbrowser_modifiedfile_entry, viewGroup, false);
            modifiedFileListEntry.setOnCheckedChangeListener(new 1(this, i));
            modifiedFileListEntry.setChecked(this.j6.DW.get(i));
            if (i == this.j6.j6) {
                z = true;
            }
            modifiedFileListEntry.setSelectedForDiff(z);
            ModifiedFile modifiedFile = (ModifiedFile) getItem(i);
            ImageView imageView = (ImageView) modifiedFileListEntry.findViewById(R.b.modifiedFileImage);
            if (modifiedFile.DW() || modifiedFile.v5()) {
                imageView.setImageResource(R.drawable.file_modfieid);
            } else if (modifiedFile.j6() || modifiedFile.Zo()) {
                imageView.setImageResource(R.drawable.file_new);
            } else if (modifiedFile.FH() || modifiedFile.Hw()) {
                imageView.setImageResource(R.drawable.file_removed);
            } else if (modifiedFile.VH()) {
                imageView.setImageResource(R.drawable.file_conflict);
            }
            TextView textView = (TextView) modifiedFileListEntry.findViewById(R.b.modifiedFileName);
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(new File(modifiedFile.j6).getName());
            stringBuilder.append(" (");
            stringBuilder.append(modifiedFile.gn());
            stringBuilder.append(")");
            textView.setText(stringBuilder.toString());
            return modifiedFileListEntry;
        }

        public int getItemViewType(int i) {
            return -1;
        }
    }

    public CommitActivity() {
        this.Hw = new HashMap();
    }

    public static void j6(Activity activity, GitStatus gitStatus, String str) {
        Intent intent = new Intent(activity, CommitActivity.class);
        intent.putExtra("GITSTATUS", gitStatus);
        intent.putExtra("GITBRANCH", str);
        activity.startActivity(intent);
    }

    protected void onStart() {
        super.onStart();
        com.aide.analytics.a.j6((Activity) this, "Commit");
    }

    protected void onStop() {
        super.onStop();
        com.aide.analytics.a.DW(this, "Commit");
    }

    protected void onResume() {
        super.onResume();
        e.j6((Activity) this);
    }

    protected void onPause() {
        super.onPause();
        e.DW((Activity) this);
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.d.commit_options_menu, menu);
        return true;
    }

    protected Dialog onCreateDialog(int i, Bundle bundle) {
        return m.j6((Activity) this, i);
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.c.commitbrowser);
        com.aide.common.d.j6(findViewById(R.b.commitFrame));
        ActionBar actionBar = getActionBar();
        if (actionBar != null) {
            String stringExtra = getIntent().getStringExtra("GITBRANCH");
            if (stringExtra.startsWith("refs/heads/")) {
                stringExtra = stringExtra.substring("refs/heads/".length());
            } else if (stringExtra.startsWith("refs/")) {
                stringExtra = stringExtra.substring("refs/".length());
            }
            actionBar.setSubtitle("Branch '" + stringExtra + "'");
        }
        SplitView splitView = (SplitView) findViewById(R.b.commitSplitView);
        splitView.openSplit(splitView.splitHorizontalByDefault(), false);
        splitView.setSwipeEnabled(true);
        GitStatus gitStatus = (GitStatus) getIntent().getExtras().getParcelable("GITSTATUS");
        this.v5 = gitStatus.j6;
        ListView v5 = v5();
        v5.setChoiceMode(1);
        v5.setOnItemClickListener(new 1(this, v5));
        v5.setOnItemLongClickListener(new 2(this, v5));
        e.j3().j6((pl$c) this);
        this.FH = gitStatus.DW;
        FH();
    }

    private void FH() {
        ListView v5 = v5();
        this.Zo = new b(this, this, this.FH);
        this.j6 = -1;
        v5.setAdapter(this.Zo);
        this.DW = new BitSet();
        this.DW.set(0, this.FH.size());
        j6(0);
    }

    protected void onDestroy() {
        super.onDestroy();
        e.j3().DW((pl$c) this);
        for (String file : this.Hw.values()) {
            new File(file).delete();
        }
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        switch (menuItem.getItemId()) {
            case R.b.commitMenuCommit /*2131558673*/:
                if (!e.Mr().DW(e.tp(), "git_commit")) {
                    return true;
                }
                m.j6((Activity) this, new nu());
                return true;
            case R.b.commitMenuDiscard /*2131558674*/:
                m.DW(this, "Git discard", "Really discard the selected changes?", new 3(this), null);
                return true;
            default:
                return super.onOptionsItemSelected(menuItem);
        }
    }

    private List<ModifiedFile> Hw() {
        List<ModifiedFile> arrayList = new ArrayList();
        ListView v5 = v5();
        for (int i = 0; i < v5.getCount(); i++) {
            if (this.DW.get(i)) {
                arrayList.add((ModifiedFile) v5.getItemAtPosition(i));
            }
        }
        return arrayList;
    }

    private ListView v5() {
        return (ListView) findViewById(R.b.modifiedFilesList);
    }

    private void j6(int i) {
        ListView v5 = v5();
        this.j6 = i;
        this.Zo.notifyDataSetChanged();
        ModifiedFile modifiedFile = (ModifiedFile) v5.getItemAtPosition(i);
        j6(modifiedFile);
        DW().scrollTo(0, 0);
        View headerView = DW().getHeaderView();
        ((TextView) headerView.findViewById(R.b.commitHeaderFileName)).setText(qh.Zo(modifiedFile.j6));
        ((TextView) headerView.findViewById(R.b.commitHeaderDirectoryName)).setText(qh.v5(modifiedFile.j6));
        ((ImageView) headerView.findViewById(R.b.commitHeaderFileIcon)).setImageResource(j.j6(modifiedFile.j6));
    }

    private ModifiedFile Zo() {
        if (this.j6 < 0) {
            return null;
        }
        return (ModifiedFile) v5().getItemAtPosition(this.j6);
    }

    private void j6(ModifiedFile modifiedFile) {
        DiffView j6 = j6();
        j6.j6();
        if (modifiedFile.Hw() || modifiedFile.FH() || !qh.DW(modifiedFile.j6)) {
            if (modifiedFile.j6() || modifiedFile.Zo()) {
                j6.j6(null, modifiedFile.j6, modifiedFile.j6);
            } else if (!this.Hw.containsKey(modifiedFile)) {
                j6.DW();
                e.ei().j6(modifiedFile.j6, new 4(this, modifiedFile));
            } else if (!qh.DW((String) this.Hw.get(modifiedFile))) {
                j6.j6((String) this.Hw.get(modifiedFile), modifiedFile.j6, modifiedFile.j6);
            } else if (modifiedFile.FH() || modifiedFile.Hw()) {
                j6.setInformationalContent("Removed binary file");
            } else {
                j6.setInformationalContent("Modified binary file");
            }
        } else if (modifiedFile.j6() || modifiedFile.Zo()) {
            j6.setInformationalContent("New binary file");
        } else {
            j6.setInformationalContent("Binary files differ");
        }
    }

    public DiffView j6() {
        return (DiffView) findViewById(R.b.commitDiffView);
    }

    public CodeEditTextScrollView DW() {
        return (CodeEditTextScrollView) findViewById(R.b.commitDifferencesScrollView);
    }

    public void j6(FileHighlightings fileHighlightings) {
        j6().j6(fileHighlightings);
    }

    public void j6(String str) {
        e.j6(new 5(this, str));
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        if (i == 1194684) {
            e.cn().j6(intent);
        }
    }
}
