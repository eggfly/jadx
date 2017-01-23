package com.miui.support.net;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Properties;

public class MimeUtils {
    private static final Map<String, String> f3393a;
    private static final Map<String, String> f3394b;

    static {
        f3393a = new HashMap();
        f3394b = new HashMap();
        m5086a("application/andrew-inset", "ez");
        m5086a("application/dsptype", "tsp");
        m5086a("application/futuresplash", "spl");
        m5086a("application/hta", "hta");
        m5086a("application/mac-binhex40", "hqx");
        m5086a("application/mac-compactpro", "cpt");
        m5086a("application/mathematica", "nb");
        m5086a("application/msaccess", "mdb");
        m5086a("application/oda", "oda");
        m5086a("application/ogg", "ogg");
        m5086a("application/pdf", "pdf");
        m5086a("application/pgp-keys", "key");
        m5086a("application/pgp-signature", "pgp");
        m5086a("application/pics-rules", "prf");
        m5086a("application/rar", "rar");
        m5086a("application/rdf+xml", "rdf");
        m5086a("application/rss+xml", "rss");
        m5086a("application/zip", "zip");
        m5086a("application/vnd.android.package-archive", "apk");
        m5086a("application/vnd.cinderella", "cdy");
        m5086a("application/vnd.ms-pki.stl", "stl");
        m5086a("application/vnd.oasis.opendocument.database", "odb");
        m5086a("application/vnd.oasis.opendocument.formula", "odf");
        m5086a("application/vnd.oasis.opendocument.graphics", "odg");
        m5086a("application/vnd.oasis.opendocument.graphics-template", "otg");
        m5086a("application/vnd.oasis.opendocument.image", "odi");
        m5086a("application/vnd.oasis.opendocument.spreadsheet", "ods");
        m5086a("application/vnd.oasis.opendocument.spreadsheet-template", "ots");
        m5086a("application/vnd.oasis.opendocument.text", "odt");
        m5086a("application/vnd.oasis.opendocument.text-master", "odm");
        m5086a("application/vnd.oasis.opendocument.text-template", "ott");
        m5086a("application/vnd.oasis.opendocument.text-web", "oth");
        m5086a("application/vnd.google-earth.kml+xml", "kml");
        m5086a("application/vnd.google-earth.kmz", "kmz");
        m5086a("application/msword", "doc");
        m5086a("application/msword", "dot");
        m5086a("application/vnd.openxmlformats-officedocument.wordprocessingml.document", "docx");
        m5086a("application/vnd.openxmlformats-officedocument.wordprocessingml.template", "dotx");
        m5086a("application/vnd.ms-excel", "xls");
        m5086a("application/vnd.ms-excel", "xlt");
        m5086a("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet", "xlsx");
        m5086a("application/vnd.openxmlformats-officedocument.spreadsheetml.template", "xltx");
        m5086a("application/vnd.ms-powerpoint", "ppt");
        m5086a("application/vnd.ms-powerpoint", "pot");
        m5086a("application/vnd.ms-powerpoint", "pps");
        m5086a("application/vnd.openxmlformats-officedocument.presentationml.presentation", "pptx");
        m5086a("application/vnd.openxmlformats-officedocument.presentationml.template", "potx");
        m5086a("application/vnd.openxmlformats-officedocument.presentationml.slideshow", "ppsx");
        m5086a("application/vnd.rim.cod", "cod");
        m5086a("application/vnd.smaf", "mmf");
        m5086a("application/vnd.stardivision.calc", "sdc");
        m5086a("application/vnd.stardivision.draw", "sda");
        m5086a("application/vnd.stardivision.impress", "sdd");
        m5086a("application/vnd.stardivision.impress", "sdp");
        m5086a("application/vnd.stardivision.math", "smf");
        m5086a("application/vnd.stardivision.writer", "sdw");
        m5086a("application/vnd.stardivision.writer", "vor");
        m5086a("application/vnd.stardivision.writer-global", "sgl");
        m5086a("application/vnd.sun.xml.calc", "sxc");
        m5086a("application/vnd.sun.xml.calc.template", "stc");
        m5086a("application/vnd.sun.xml.draw", "sxd");
        m5086a("application/vnd.sun.xml.draw.template", "std");
        m5086a("application/vnd.sun.xml.impress", "sxi");
        m5086a("application/vnd.sun.xml.impress.template", "sti");
        m5086a("application/vnd.sun.xml.math", "sxm");
        m5086a("application/vnd.sun.xml.writer", "sxw");
        m5086a("application/vnd.sun.xml.writer.global", "sxg");
        m5086a("application/vnd.sun.xml.writer.template", "stw");
        m5086a("application/vnd.visio", "vsd");
        m5086a("application/x-abiword", "abw");
        m5086a("application/x-apple-diskimage", "dmg");
        m5086a("application/x-bcpio", "bcpio");
        m5086a("application/x-bittorrent", "torrent");
        m5086a("application/x-cdf", "cdf");
        m5086a("application/x-cdlink", "vcd");
        m5086a("application/x-chess-pgn", "pgn");
        m5086a("application/x-cpio", "cpio");
        m5086a("application/x-debian-package", "deb");
        m5086a("application/x-debian-package", "udeb");
        m5086a("application/x-director", "dcr");
        m5086a("application/x-director", "dir");
        m5086a("application/x-director", "dxr");
        m5086a("application/x-dms", "dms");
        m5086a("application/x-doom", "wad");
        m5086a("application/x-dvi", "dvi");
        m5086a("application/x-flac", "flac");
        m5086a("application/x-font", "pfa");
        m5086a("application/x-font", "pfb");
        m5086a("application/x-font", "gsf");
        m5086a("application/x-font", "pcf");
        m5086a("application/x-font", "pcf.Z");
        m5086a("application/x-freemind", "mm");
        m5086a("application/x-futuresplash", "spl");
        m5086a("application/x-gnumeric", "gnumeric");
        m5086a("application/x-go-sgf", "sgf");
        m5086a("application/x-graphing-calculator", "gcf");
        m5086a("application/x-gtar", "gtar");
        m5086a("application/x-gtar", "tgz");
        m5086a("application/x-gtar", "taz");
        m5086a("application/x-hdf", "hdf");
        m5086a("application/x-ica", "ica");
        m5086a("application/x-internet-signup", "ins");
        m5086a("application/x-internet-signup", "isp");
        m5086a("application/x-iphone", "iii");
        m5086a("application/x-iso9660-image", "iso");
        m5086a("application/x-jmol", "jmz");
        m5086a("application/x-kchart", "chrt");
        m5086a("application/x-killustrator", "kil");
        m5086a("application/x-koan", "skp");
        m5086a("application/x-koan", "skd");
        m5086a("application/x-koan", "skt");
        m5086a("application/x-koan", "skm");
        m5086a("application/x-kpresenter", "kpr");
        m5086a("application/x-kpresenter", "kpt");
        m5086a("application/x-kspread", "ksp");
        m5086a("application/x-kword", "kwd");
        m5086a("application/x-kword", "kwt");
        m5086a("application/x-latex", "latex");
        m5086a("application/x-lha", "lha");
        m5086a("application/x-lzh", "lzh");
        m5086a("application/x-lzx", "lzx");
        m5086a("application/x-maker", "frm");
        m5086a("application/x-maker", "maker");
        m5086a("application/x-maker", "frame");
        m5086a("application/x-maker", "fb");
        m5086a("application/x-maker", "book");
        m5086a("application/x-maker", "fbdoc");
        m5086a("application/x-mif", "mif");
        m5086a("application/x-ms-wmd", "wmd");
        m5086a("application/x-ms-wmz", "wmz");
        m5086a("application/x-msi", "msi");
        m5086a("application/x-ns-proxy-autoconfig", "pac");
        m5086a("application/x-nwc", "nwc");
        m5086a("application/x-object", "o");
        m5086a("application/x-oz-application", "oza");
        m5086a("application/x-pkcs12", "p12");
        m5086a("application/x-pkcs12", "pfx");
        m5086a("application/x-pkcs7-certreqresp", "p7r");
        m5086a("application/x-pkcs7-crl", "crl");
        m5086a("application/x-quicktimeplayer", "qtl");
        m5086a("application/x-shar", "shar");
        m5086a("application/x-shockwave-flash", "swf");
        m5086a("application/x-stuffit", "sit");
        m5086a("application/x-sv4cpio", "sv4cpio");
        m5086a("application/x-sv4crc", "sv4crc");
        m5086a("application/x-tar", "tar");
        m5086a("application/x-texinfo", "texinfo");
        m5086a("application/x-texinfo", "texi");
        m5086a("application/x-troff", "t");
        m5086a("application/x-troff", "roff");
        m5086a("application/x-troff-man", "man");
        m5086a("application/x-ustar", "ustar");
        m5086a("application/x-wais-source", "src");
        m5086a("application/x-wingz", "wz");
        m5086a("application/x-webarchive", "webarchive");
        m5086a("application/x-webarchive-xml", "webarchivexml");
        m5086a("application/x-x509-ca-cert", "crt");
        m5086a("application/x-x509-user-cert", "crt");
        m5086a("application/x-xcf", "xcf");
        m5086a("application/x-xfig", "fig");
        m5086a("application/xhtml+xml", "xhtml");
        m5086a("audio/3gpp", "3gpp");
        m5086a("audio/amr", "amr");
        m5086a("audio/basic", "snd");
        m5086a("audio/midi", "mid");
        m5086a("audio/midi", "midi");
        m5086a("audio/midi", "kar");
        m5086a("audio/midi", "xmf");
        m5086a("audio/mobile-xmf", "mxmf");
        m5086a("audio/mpeg", "mpga");
        m5086a("audio/mpeg", "mpega");
        m5086a("audio/mpeg", "mp2");
        m5086a("audio/mpeg", "mp3");
        m5086a("audio/mpeg", "m4a");
        m5086a("audio/mpegurl", "m3u");
        m5086a("audio/prs.sid", "sid");
        m5086a("audio/x-aiff", "aif");
        m5086a("audio/x-aiff", "aiff");
        m5086a("audio/x-aiff", "aifc");
        m5086a("audio/x-gsm", "gsm");
        m5086a("audio/x-mpegurl", "m3u");
        m5086a("audio/x-ms-wma", "wma");
        m5086a("audio/x-ms-wax", "wax");
        m5086a("audio/x-pn-realaudio", "ra");
        m5086a("audio/x-pn-realaudio", "rm");
        m5086a("audio/x-pn-realaudio", "ram");
        m5086a("audio/x-realaudio", "ra");
        m5086a("audio/x-scpls", "pls");
        m5086a("audio/x-sd2", "sd2");
        m5086a("audio/x-wav", "wav");
        m5086a("image/bmp", "bmp");
        m5086a("image/gif", "gif");
        m5086a("image/ico", "cur");
        m5086a("image/ico", "ico");
        m5086a("image/ief", "ief");
        m5086a("image/jpeg", "jpeg");
        m5086a("image/jpeg", "jpg");
        m5086a("image/jpeg", "jpe");
        m5086a("image/pcx", "pcx");
        m5086a("image/png", "png");
        m5086a("image/svg+xml", "svg");
        m5086a("image/svg+xml", "svgz");
        m5086a("image/tiff", "tiff");
        m5086a("image/tiff", "tif");
        m5086a("image/vnd.djvu", "djvu");
        m5086a("image/vnd.djvu", "djv");
        m5086a("image/vnd.wap.wbmp", "wbmp");
        m5086a("image/x-cmu-raster", "ras");
        m5086a("image/x-coreldraw", "cdr");
        m5086a("image/x-coreldrawpattern", "pat");
        m5086a("image/x-coreldrawtemplate", "cdt");
        m5086a("image/x-corelphotopaint", "cpt");
        m5086a("image/x-icon", "ico");
        m5086a("image/x-jg", "art");
        m5086a("image/x-jng", "jng");
        m5086a("image/x-ms-bmp", "bmp");
        m5086a("image/x-photoshop", "psd");
        m5086a("image/x-portable-anymap", "pnm");
        m5086a("image/x-portable-bitmap", "pbm");
        m5086a("image/x-portable-graymap", "pgm");
        m5086a("image/x-portable-pixmap", "ppm");
        m5086a("image/x-rgb", "rgb");
        m5086a("image/x-xbitmap", "xbm");
        m5086a("image/x-xpixmap", "xpm");
        m5086a("image/x-xwindowdump", "xwd");
        m5086a("model/iges", "igs");
        m5086a("model/iges", "iges");
        m5086a("model/mesh", "msh");
        m5086a("model/mesh", "mesh");
        m5086a("model/mesh", "silo");
        m5086a("text/calendar", "ics");
        m5086a("text/calendar", "icz");
        m5086a("text/comma-separated-values", "csv");
        m5086a("text/css", "css");
        m5086a("text/html", "htm");
        m5086a("text/html", "html");
        m5086a("text/h323", "323");
        m5086a("text/iuls", "uls");
        m5086a("text/mathml", "mml");
        m5086a("text/plain", "txt");
        m5086a("text/plain", "asc");
        m5086a("text/plain", "text");
        m5086a("text/plain", "diff");
        m5086a("text/plain", "po");
        m5086a("text/richtext", "rtx");
        m5086a("text/rtf", "rtf");
        m5086a("text/texmacs", "ts");
        m5086a("text/text", "phps");
        m5086a("text/tab-separated-values", "tsv");
        m5086a("text/xml", "xml");
        m5086a("text/x-bibtex", "bib");
        m5086a("text/x-boo", "boo");
        m5086a("text/x-c++hdr", "h++");
        m5086a("text/x-c++hdr", "hpp");
        m5086a("text/x-c++hdr", "hxx");
        m5086a("text/x-c++hdr", "hh");
        m5086a("text/x-c++src", "c++");
        m5086a("text/x-c++src", "cpp");
        m5086a("text/x-c++src", "cxx");
        m5086a("text/x-chdr", "h");
        m5086a("text/x-component", "htc");
        m5086a("text/x-csh", "csh");
        m5086a("text/x-csrc", "c");
        m5086a("text/x-dsrc", "d");
        m5086a("text/x-haskell", "hs");
        m5086a("text/x-java", "java");
        m5086a("text/x-literate-haskell", "lhs");
        m5086a("text/x-moc", "moc");
        m5086a("text/x-pascal", "p");
        m5086a("text/x-pascal", "pas");
        m5086a("text/x-pcs-gcd", "gcd");
        m5086a("text/x-setext", "etx");
        m5086a("text/x-tcl", "tcl");
        m5086a("text/x-tex", "tex");
        m5086a("text/x-tex", "ltx");
        m5086a("text/x-tex", "sty");
        m5086a("text/x-tex", "cls");
        m5086a("text/x-vcalendar", "vcs");
        m5086a("text/x-vcard", "vcf");
        m5086a("video/3gpp", "3gpp");
        m5086a("video/3gpp", "3gp");
        m5086a("video/3gpp", "3g2");
        m5086a("video/dl", "dl");
        m5086a("video/dv", "dif");
        m5086a("video/dv", "dv");
        m5086a("video/fli", "fli");
        m5086a("video/m4v", "m4v");
        m5086a("video/mpeg", "mpeg");
        m5086a("video/mpeg", "mpg");
        m5086a("video/mpeg", "mpe");
        m5086a("video/mp4", "mp4");
        m5086a("video/mpeg", "VOB");
        m5086a("video/quicktime", "qt");
        m5086a("video/quicktime", "mov");
        m5086a("video/vnd.mpegurl", "mxu");
        m5086a("video/x-la-asf", "lsf");
        m5086a("video/x-la-asf", "lsx");
        m5086a("video/x-mng", "mng");
        m5086a("video/x-ms-asf", "asf");
        m5086a("video/x-ms-asf", "asx");
        m5086a("video/x-ms-wm", "wm");
        m5086a("video/x-ms-wmv", "wmv");
        m5086a("video/x-ms-wmx", "wmx");
        m5086a("video/x-ms-wvx", "wvx");
        m5086a("video/x-msvideo", "avi");
        m5086a("video/x-sgi-movie", "movie");
        m5086a("x-conference/x-cooltalk", "ice");
        m5086a("x-epoc/x-sisx-app", "sisx");
        m5087b();
    }

    protected MimeUtils() {
        throw new InstantiationException("Cannot instantiate utility class");
    }

    private static void m5086a(String str, String str2) {
        if (!f3393a.containsKey(str)) {
            f3393a.put(str, str2);
        }
        f3394b.put(str2, str);
    }

    private static InputStream m5085a() {
        File file;
        String property = System.getProperty("content.types.user.table");
        if (property != null) {
            file = new File(property);
            if (file.exists()) {
                try {
                    return new FileInputStream(file);
                } catch (IOException e) {
                }
            }
        }
        file = new File(System.getProperty("java.home"), "lib" + File.separator + "content-types.properties");
        if (file.exists()) {
            try {
                return new FileInputStream(file);
            } catch (IOException e2) {
            }
        }
        return null;
    }

    private static void m5087b() {
        InputStream a = m5085a();
        if (a != null) {
            try {
                Properties properties = new Properties();
                properties.load(a);
                for (Entry entry : properties.entrySet()) {
                    m5086a((String) entry.getValue(), (String) entry.getKey());
                }
                a.close();
            } catch (IOException e) {
            } catch (Throwable th) {
                a.close();
            }
        }
    }
}
