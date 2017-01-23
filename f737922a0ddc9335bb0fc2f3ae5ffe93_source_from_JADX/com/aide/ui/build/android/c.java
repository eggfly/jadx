package com.aide.ui.build.android;

import java.io.File;
import java.io.FileWriter;

public class c {
    public static void j6(File file, String str, boolean z) {
        FileWriter fileWriter = new FileWriter(file);
        try {
            fileWriter.write("/** Automatically generated file. DO NOT MODIFY */\npackage $0;\n\npublic final class BuildConfig {\n    public final static boolean DEBUG = $1;\n}".replace("$0", str).replace("$1", Boolean.toString(!z)));
        } finally {
            fileWriter.close();
        }
    }
}
