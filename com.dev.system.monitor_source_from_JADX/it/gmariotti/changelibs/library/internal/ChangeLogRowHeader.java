package it.gmariotti.changelibs.library.internal;

public class ChangeLogRowHeader extends ChangeLogRow {
    public ChangeLogRowHeader() {
        setHeader(true);
        setBulletedList(false);
        setChangeTextTitle(null);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("header=" + this.header);
        sb.append(",");
        sb.append("versionName=" + this.versionName);
        sb.append(",");
        sb.append("changeDate=" + this.changeDate);
        return sb.toString();
    }
}
