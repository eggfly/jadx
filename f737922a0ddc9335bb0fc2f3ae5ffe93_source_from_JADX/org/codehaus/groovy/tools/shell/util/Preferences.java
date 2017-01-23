package org.codehaus.groovy.tools.shell.util;

import java.util.prefs.PreferenceChangeEvent;
import java.util.prefs.PreferenceChangeListener;
import org.codehaus.groovy.tools.shell.IO.Verbosity;

public class Preferences {
    private static final java.util.prefs.Preferences DW;
    public static Verbosity j6;

    static class 1 implements PreferenceChangeListener {
        1() {
        }

        public void preferenceChange(PreferenceChangeEvent preferenceChangeEvent) {
            if (preferenceChangeEvent.getKey().equals("verbosity")) {
                String newValue = preferenceChangeEvent.getNewValue();
                if (newValue == null) {
                    newValue = Verbosity.DW.v5;
                }
                try {
                    Preferences.j6 = Verbosity.j6(newValue);
                } catch (Exception e) {
                    preferenceChangeEvent.getNode().put(preferenceChangeEvent.getKey(), Preferences.j6.v5);
                }
            }
        }
    }

    static {
        DW = java.util.prefs.Preferences.userRoot().node("/org/codehaus/groovy/tools/shell");
        try {
            j6 = Verbosity.j6(DW.get("verbosity", Verbosity.DW.v5));
        } catch (IllegalArgumentException e) {
            j6 = Verbosity.DW;
            DW.remove("verbosity");
        }
        j6(new 1());
    }

    public static void j6(PreferenceChangeListener preferenceChangeListener) {
        DW.addPreferenceChangeListener(preferenceChangeListener);
    }
}
