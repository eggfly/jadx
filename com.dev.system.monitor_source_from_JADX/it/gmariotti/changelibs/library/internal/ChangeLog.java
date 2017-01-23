package it.gmariotti.changelibs.library.internal;

import java.util.Iterator;
import java.util.LinkedList;

public class ChangeLog {
    private boolean bulletedList;
    private LinkedList<ChangeLogRow> rows;

    public ChangeLog() {
        this.rows = new LinkedList();
    }

    public void addRow(ChangeLogRow row) {
        if (row != null) {
            if (this.rows == null) {
                this.rows = new LinkedList();
            }
            this.rows.add(row);
        }
    }

    public void clearAllRows() {
        this.rows = new LinkedList();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("bulletedList=" + this.bulletedList);
        sb.append("\n");
        if (this.rows != null) {
            Iterator it = this.rows.iterator();
            while (it.hasNext()) {
                ChangeLogRow row = (ChangeLogRow) it.next();
                sb.append("row=[");
                sb.append(row.toString());
                sb.append("]\n");
            }
        } else {
            sb.append("rows:none");
        }
        return sb.toString();
    }

    public boolean isBulletedList() {
        return this.bulletedList;
    }

    public void setBulletedList(boolean bulletedList) {
        this.bulletedList = bulletedList;
    }

    public LinkedList<ChangeLogRow> getRows() {
        return this.rows;
    }

    public void setRows(LinkedList<ChangeLogRow> rows) {
        this.rows = rows;
    }
}
