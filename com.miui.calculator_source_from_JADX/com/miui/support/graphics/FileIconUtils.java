package com.miui.support.graphics;

import com.miui.support.C0234R;
import java.util.HashMap;

public class FileIconUtils {
    private static HashMap<String, Integer> f2012a;

    static {
        f2012a = new HashMap();
        m3490a(new String[]{"mp3"}, C0234R.drawable.file_icon_mp3);
        m3490a(new String[]{"wma"}, C0234R.drawable.file_icon_wma);
        m3490a(new String[]{"wav"}, C0234R.drawable.file_icon_wav);
        m3490a(new String[]{"mid"}, C0234R.drawable.file_icon_mid);
        m3490a(new String[]{"mp4", "wmv", "mpeg", "m4v", "3gp", "3g2", "3gpp2", "asf", "flv", "mkv", "vob", "ts", "f4v", "rm", "mov", "rmvb"}, C0234R.drawable.file_icon_video);
        m3490a(new String[]{"jpg", "jpeg", "gif", "png", "bmp", "wbmp"}, C0234R.drawable.file_icon_picture);
        m3490a(new String[]{"txt", "log", "ini", "lrc"}, C0234R.drawable.file_icon_txt);
        m3490a(new String[]{"doc", "docx"}, C0234R.drawable.file_icon_doc);
        m3490a(new String[]{"ppt", "pptx"}, C0234R.drawable.file_icon_ppt);
        m3490a(new String[]{"xls", "xlsx"}, C0234R.drawable.file_icon_xls);
        m3490a(new String[]{"wps"}, C0234R.drawable.file_icon_wps);
        m3490a(new String[]{"pps"}, C0234R.drawable.file_icon_pps);
        m3490a(new String[]{"et"}, C0234R.drawable.file_icon_et);
        m3490a(new String[]{"wpt"}, C0234R.drawable.file_icon_wpt);
        m3490a(new String[]{"ett"}, C0234R.drawable.file_icon_ett);
        m3490a(new String[]{"dps"}, C0234R.drawable.file_icon_dps);
        m3490a(new String[]{"dpt"}, C0234R.drawable.file_icon_dpt);
        m3490a(new String[]{"pdf"}, C0234R.drawable.file_icon_pdf);
        m3490a(new String[]{"zip"}, C0234R.drawable.file_icon_zip);
        m3490a(new String[]{"mtz"}, C0234R.drawable.file_icon_theme);
        m3490a(new String[]{"rar"}, C0234R.drawable.file_icon_rar);
        m3490a(new String[]{"apk"}, C0234R.drawable.file_icon_apk);
        m3490a(new String[]{"amr"}, C0234R.drawable.file_icon_amr);
        m3490a(new String[]{"vcf"}, C0234R.drawable.file_icon_vcf);
        m3490a(new String[]{"flac"}, C0234R.drawable.file_icon_flac);
        m3490a(new String[]{"aac"}, C0234R.drawable.file_icon_aac);
        m3490a(new String[]{"ape"}, C0234R.drawable.file_icon_ape);
        m3490a(new String[]{"m4a"}, C0234R.drawable.file_icon_m4a);
        m3490a(new String[]{"ogg"}, C0234R.drawable.file_icon_ogg);
        m3490a(new String[]{"audio"}, C0234R.drawable.file_icon_audio);
        m3490a(new String[]{"html"}, C0234R.drawable.file_icon_html);
        m3490a(new String[]{"xml"}, C0234R.drawable.file_icon_xml);
        m3490a(new String[]{"3gpp"}, C0234R.drawable.file_icon_3gpp);
    }

    protected FileIconUtils() {
        throw new InstantiationException("Cannot instantiate utility class");
    }

    private static void m3490a(String[] strArr, int i) {
        if (strArr != null) {
            for (String toLowerCase : strArr) {
                f2012a.put(toLowerCase.toLowerCase(), Integer.valueOf(i));
            }
        }
    }
}
