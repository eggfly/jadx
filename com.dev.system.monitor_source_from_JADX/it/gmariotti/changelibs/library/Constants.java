package it.gmariotti.changelibs.library;

import it.gmariotti.changelibs.C0216R;

public class Constants {
    public static final int mChangeLogFileResourceId;
    public static final int mRowHeaderLayoutId;
    public static final int mRowLayoutId;
    public static final int mStringVersionHeader;

    static {
        mChangeLogFileResourceId = C0216R.raw.changelog;
        mRowLayoutId = C0216R.layout.changelogrow_layout;
        mRowHeaderLayoutId = C0216R.layout.changelogrowheader_layout;
        mStringVersionHeader = C0216R.string.changelog_header_version;
    }
}
