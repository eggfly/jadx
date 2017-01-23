package it.gmariotti.changelibs.library.parser;

import android.content.Context;
import it.gmariotti.changelibs.library.internal.ChangeLog;

public abstract class BaseParser {
    protected boolean bulletedList;
    protected Context mContext;

    public abstract ChangeLog readChangeLogFile() throws Exception;

    public BaseParser(Context context) {
        this.mContext = context;
    }
}
