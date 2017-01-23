package android.support.v4.content;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.Context;
import android.content.pm.ProviderInfo;
import android.content.res.XmlResourceParser;
import android.database.Cursor;
import android.database.MatrixCursor;
import android.net.Uri;
import android.os.Environment;
import android.os.ParcelFileDescriptor;
import android.text.TextUtils;
import android.webkit.MimeTypeMap;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;

public class FileProvider extends ContentProvider {
    private static final File DW;
    private static HashMap<String, a> FH;
    private static final String[] j6;
    private a Hw;

    interface a {
        File j6(Uri uri);
    }

    static class b implements a {
        private final HashMap<String, File> DW;
        private final String j6;

        public b(String str) {
            this.DW = new HashMap();
            this.j6 = str;
        }

        public void j6(String str, File file) {
            if (TextUtils.isEmpty(str)) {
                throw new IllegalArgumentException("Name must not be empty");
            }
            try {
                this.DW.put(str, file.getCanonicalFile());
            } catch (Throwable e) {
                throw new IllegalArgumentException("Failed to resolve canonical path for " + file, e);
            }
        }

        public File j6(Uri uri) {
            String encodedPath = uri.getEncodedPath();
            int indexOf = encodedPath.indexOf(47, 1);
            String decode = Uri.decode(encodedPath.substring(1, indexOf));
            String decode2 = Uri.decode(encodedPath.substring(indexOf + 1));
            File file = (File) this.DW.get(decode);
            if (file == null) {
                throw new IllegalArgumentException("Unable to find configured root for " + uri);
            }
            File file2 = new File(file, decode2);
            try {
                File canonicalFile = file2.getCanonicalFile();
                if (canonicalFile.getPath().startsWith(file.getPath())) {
                    return canonicalFile;
                }
                throw new SecurityException("Resolved path jumped beyond configured root");
            } catch (IOException e) {
                throw new IllegalArgumentException("Failed to resolve canonical path for " + file2);
            }
        }
    }

    static {
        j6 = new String[]{"_display_name", "_size"};
        DW = new File("/");
        FH = new HashMap();
    }

    public boolean onCreate() {
        return true;
    }

    public void attachInfo(Context context, ProviderInfo providerInfo) {
        super.attachInfo(context, providerInfo);
        if (providerInfo.exported) {
            throw new SecurityException("Provider must not be exported");
        } else if (providerInfo.grantUriPermissions) {
            this.Hw = j6(context, providerInfo.authority);
        } else {
            throw new SecurityException("Provider must grant uri permissions");
        }
    }

    public Cursor query(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        File j6 = this.Hw.j6(uri);
        if (strArr == null) {
            strArr = j6;
        }
        String[] strArr3 = new String[strArr.length];
        Object[] objArr = new Object[strArr.length];
        int length = strArr.length;
        int i = 0;
        int i2 = 0;
        while (i < length) {
            int i3;
            Object obj = strArr[i];
            if ("_display_name".equals(obj)) {
                strArr3[i2] = "_display_name";
                i3 = i2 + 1;
                objArr[i2] = j6.getName();
            } else if ("_size".equals(obj)) {
                strArr3[i2] = "_size";
                i3 = i2 + 1;
                objArr[i2] = Long.valueOf(j6.length());
            } else {
                i3 = i2;
            }
            i++;
            i2 = i3;
        }
        String[] j62 = j6(strArr3, i2);
        Object[] j63 = j6(objArr, i2);
        Cursor matrixCursor = new MatrixCursor(j62, 1);
        matrixCursor.addRow(j63);
        return matrixCursor;
    }

    public String getType(Uri uri) {
        File j6 = this.Hw.j6(uri);
        int lastIndexOf = j6.getName().lastIndexOf(46);
        if (lastIndexOf >= 0) {
            String mimeTypeFromExtension = MimeTypeMap.getSingleton().getMimeTypeFromExtension(j6.getName().substring(lastIndexOf + 1));
            if (mimeTypeFromExtension != null) {
                return mimeTypeFromExtension;
            }
        }
        return "application/octet-stream";
    }

    public Uri insert(Uri uri, ContentValues contentValues) {
        throw new UnsupportedOperationException("No external inserts");
    }

    public int update(Uri uri, ContentValues contentValues, String str, String[] strArr) {
        throw new UnsupportedOperationException("No external updates");
    }

    public int delete(Uri uri, String str, String[] strArr) {
        return this.Hw.j6(uri).delete() ? 1 : 0;
    }

    public ParcelFileDescriptor openFile(Uri uri, String str) {
        return ParcelFileDescriptor.open(this.Hw.j6(uri), j6(str));
    }

    private static a j6(Context context, String str) {
        a aVar;
        synchronized (FH) {
            aVar = (a) FH.get(str);
            if (aVar == null) {
                try {
                    aVar = DW(context, str);
                    FH.put(str, aVar);
                } catch (Throwable e) {
                    throw new IllegalArgumentException("Failed to parse android.support.FILE_PROVIDER_PATHS meta-data", e);
                } catch (Throwable e2) {
                    throw new IllegalArgumentException("Failed to parse android.support.FILE_PROVIDER_PATHS meta-data", e2);
                }
            }
        }
        return aVar;
    }

    private static a DW(Context context, String str) {
        a bVar = new b(str);
        XmlResourceParser loadXmlMetaData = context.getPackageManager().resolveContentProvider(str, 128).loadXmlMetaData(context.getPackageManager(), "android.support.FILE_PROVIDER_PATHS");
        if (loadXmlMetaData == null) {
            throw new IllegalArgumentException("Missing android.support.FILE_PROVIDER_PATHS meta-data");
        }
        while (true) {
            int next = loadXmlMetaData.next();
            if (next == 1) {
                return bVar;
            }
            if (next == 2) {
                File j6;
                String name = loadXmlMetaData.getName();
                String attributeValue = loadXmlMetaData.getAttributeValue(null, "name");
                String attributeValue2 = loadXmlMetaData.getAttributeValue(null, "path");
                if ("root-path".equals(name)) {
                    j6 = j6(DW, attributeValue2);
                } else if ("files-path".equals(name)) {
                    j6 = j6(context.getFilesDir(), attributeValue2);
                } else if ("cache-path".equals(name)) {
                    j6 = j6(context.getCacheDir(), attributeValue2);
                } else if ("external-path".equals(name)) {
                    j6 = j6(Environment.getExternalStorageDirectory(), attributeValue2);
                } else {
                    j6 = null;
                }
                if (j6 != null) {
                    bVar.j6(attributeValue, j6);
                }
            }
        }
    }

    private static int j6(String str) {
        if ("r".equals(str)) {
            return 268435456;
        }
        if ("w".equals(str) || "wt".equals(str)) {
            return 738197504;
        }
        if ("wa".equals(str)) {
            return 704643072;
        }
        if ("rw".equals(str)) {
            return 939524096;
        }
        if ("rwt".equals(str)) {
            return 1006632960;
        }
        throw new IllegalArgumentException("Invalid mode: " + str);
    }

    private static File j6(File file, String... strArr) {
        int length = strArr.length;
        int i = 0;
        File file2 = file;
        while (i < length) {
            File file3;
            String str = strArr[i];
            if (str != null) {
                file3 = new File(file2, str);
            } else {
                file3 = file2;
            }
            i++;
            file2 = file3;
        }
        return file2;
    }

    private static String[] j6(String[] strArr, int i) {
        Object obj = new String[i];
        System.arraycopy(strArr, 0, obj, 0, i);
        return obj;
    }

    private static Object[] j6(Object[] objArr, int i) {
        Object obj = new Object[i];
        System.arraycopy(objArr, 0, obj, 0, i);
        return obj;
    }
}
