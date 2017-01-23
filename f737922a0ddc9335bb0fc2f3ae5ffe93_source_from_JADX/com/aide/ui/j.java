package com.aide.ui;

public class j {
    public static int j6(String str) {
        Object obj = "";
        if (str.contains(".")) {
            obj = str.substring(str.lastIndexOf(46) + 1).toLowerCase();
        }
        if ("java".equals(obj)) {
            return R.drawable.file_type_java;
        }
        if ("xml".equals(obj)) {
            return R.drawable.file_type_xml;
        }
        if ("cpp".equals(obj)) {
            return R.drawable.file_type_cpp;
        }
        if ("c".equals(obj)) {
            return R.drawable.file_type_c;
        }
        if ("css".equals(obj)) {
            return R.drawable.file_type_css;
        }
        if ("h".equals(obj)) {
            return R.drawable.file_type_h;
        }
        if ("hpp".equals(obj)) {
            return R.drawable.file_type_h;
        }
        if ("html".equals(obj)) {
            return R.drawable.file_type_html;
        }
        if ("js".equals(obj)) {
            return R.drawable.file_type_js;
        }
        if ("txt".equals(obj)) {
            return R.drawable.file_type_txt;
        }
        if ("gradle".equals(obj)) {
            return R.drawable.project_properties;
        }
        return R.drawable.file_type_unknown;
    }
}
