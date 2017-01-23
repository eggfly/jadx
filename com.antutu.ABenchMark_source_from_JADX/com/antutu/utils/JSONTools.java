package com.antutu.utils;

import android.annotation.SuppressLint;
import android.os.Environment;
import android.text.TextUtils;
import com.xiaomi.pushsdk.BuildConfig;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@SuppressLint({"SimpleDateFormat"})
public class JSONTools {
    private static final boolean DEBUG = false;
    public static final String JSON_PATH;
    public static final String MEDALS = "all_medals";
    public static final String SCORES_LEVEL = "scores_level";
    public static final String TAG = "com.antutu.Utility.JSONTools";

    static {
        JSON_PATH = Environment.getExternalStorageDirectory().getPath() + "/.antutu/benchmark/json/";
    }

    public static final boolean getBooleanValue(JSONObject jSONObject, String str) {
        return getBooleanValue(jSONObject, str, DEBUG);
    }

    public static final boolean getBooleanValue(JSONObject jSONObject, String str, boolean z) {
        try {
            z = jSONObject.getBoolean(str);
        } catch (JSONException e) {
        }
        return z;
    }

    public static final double getDoubleValue(JSONObject jSONObject, String str) {
        return getDoubleValue(jSONObject, str, 0.0d);
    }

    public static final double getDoubleValue(JSONObject jSONObject, String str, double d) {
        try {
            d = jSONObject.getDouble(str);
        } catch (JSONException e) {
        }
        return d;
    }

    public static final int getIntValue(JSONObject jSONObject, String str) {
        return getIntValue(jSONObject, str, 0);
    }

    public static final int getIntValue(JSONObject jSONObject, String str, int i) {
        try {
            i = jSONObject.getInt(str);
        } catch (JSONException e) {
        }
        return i;
    }

    public static final JSONArray getJsonArrayValue(JSONObject jSONObject, String str) {
        try {
            return jSONObject.getJSONArray(str);
        } catch (JSONException e) {
            return null;
        }
    }

    public static final String[] getJsonKeys(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        MLog.m6874v(TAG, "json getkeys whole json = " + jSONObject);
        JSONArray names = jSONObject.names();
        int length = names.length();
        String[] strArr = new String[length];
        for (int i = 0; i < length; i++) {
            try {
                strArr[i] = names.getString(i);
            } catch (JSONException e) {
            }
        }
        return strArr;
    }

    public static final JSONObject getJsonObjValue(JSONObject jSONObject, String str) {
        try {
            return jSONObject.getJSONObject(str);
        } catch (JSONException e) {
            return null;
        }
    }

    public static final JSONArray getJsonObject(String str) {
        if (str == null) {
            throw new NullPointerException();
        }
        try {
            return new JSONArray(str);
        } catch (JSONException e) {
            return null;
        }
    }

    public static final JSONObject getJsonObject(JSONArray jSONArray, int i) {
        try {
            return jSONArray.getJSONObject(i);
        } catch (JSONException e) {
            return null;
        }
    }

    public static final long getLongValue(JSONObject jSONObject, String str) {
        return getLongValue(jSONObject, str, 0);
    }

    public static final long getLongValue(JSONObject jSONObject, String str, long j) {
        try {
            j = jSONObject.getLong(str);
        } catch (JSONException e) {
        }
        return j;
    }

    public static final String getStringValue(JSONObject jSONObject, String str) {
        return getStringValue(jSONObject, str, null);
    }

    public static final String getStringValue(JSONObject jSONObject, String str, String str2) {
        try {
            str2 = jSONObject.getString(str);
        } catch (JSONException e) {
        }
        return str2;
    }

    public static final JSONObject parserJsonObject(String str) {
        if (str == null) {
            throw new NullPointerException();
        }
        try {
            return new JSONObject(str);
        } catch (JSONException e) {
            return null;
        }
    }

    public static String readJson(String str) {
        BufferedReader bufferedReader;
        String str2;
        Throwable th;
        String str3 = BuildConfig.FLAVOR;
        try {
            bufferedReader = new BufferedReader(new FileReader(JSON_PATH + str + ".json"));
            str2 = str3;
            while (true) {
                try {
                    str3 = bufferedReader.readLine();
                    if (str3 == null) {
                        break;
                    }
                    str2 = str2 + str3;
                } catch (FileNotFoundException e) {
                } catch (IOException e2) {
                } catch (Throwable th2) {
                    th = th2;
                }
            }
            if (bufferedReader != null) {
                try {
                    bufferedReader.close();
                } catch (IOException e3) {
                }
            }
        } catch (FileNotFoundException e4) {
            bufferedReader = null;
            str2 = str3;
            if (bufferedReader != null) {
                try {
                    bufferedReader.close();
                } catch (IOException e5) {
                }
            }
            return str2;
        } catch (IOException e6) {
            bufferedReader = null;
            str2 = str3;
            if (bufferedReader != null) {
                try {
                    bufferedReader.close();
                } catch (IOException e7) {
                }
            }
            return str2;
        } catch (Throwable th3) {
            Throwable th4 = th3;
            bufferedReader = null;
            th = th4;
            if (bufferedReader != null) {
                try {
                    bufferedReader.close();
                } catch (IOException e8) {
                }
            }
            throw th;
        }
        return str2;
    }

    public static void writeJson(String str, String str2) {
        if (!TextUtils.isEmpty(str2)) {
            try {
                File file = new File(JSON_PATH);
                if (!file.exists()) {
                    file.mkdirs();
                }
                FileOutputStream fileOutputStream = new FileOutputStream(JSON_PATH + str + ".json");
                fileOutputStream.write(str2.getBytes());
                fileOutputStream.flush();
                fileOutputStream.close();
            } catch (FileNotFoundException e) {
            } catch (IOException e2) {
            }
        }
    }
}
