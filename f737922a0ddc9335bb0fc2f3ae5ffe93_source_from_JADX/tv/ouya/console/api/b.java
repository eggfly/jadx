package tv.ouya.console.api;

import android.util.Log;
import android.util.SparseArray;
import android.util.SparseBooleanArray;
import java.util.Vector;
import org.json.JSONArray;
import org.json.JSONObject;

class b {
    private static final String j6;
    private final String DW;
    private Vector<String> FH;
    private SparseArray<e> Hw;
    private e v5;

    private class a {
        public int DW;
        public boolean FH;
        final /* synthetic */ b Hw;
        public int j6;

        private a(b bVar) {
            this.Hw = bVar;
            this.j6 = -1;
            this.DW = -1;
            this.FH = false;
        }
    }

    class b {
        public int DW;
        final /* synthetic */ b FH;
        public int j6;

        b(b bVar) {
            this.FH = bVar;
            this.j6 = 0;
            this.DW = 0;
        }
    }

    class c {
        public int DW;
        public SparseBooleanArray FH;
        final /* synthetic */ b Hw;
        public int j6;

        c(b bVar) {
            this.Hw = bVar;
            this.j6 = 0;
            this.DW = 0;
            this.FH = new SparseBooleanArray();
        }
    }

    class d {
        public float DW;
        public float FH;
        public int Hw;
        public int j6;
        final /* synthetic */ b v5;

        d(b bVar) {
            this.v5 = bVar;
            this.j6 = 0;
            this.DW = 0.0f;
            this.FH = 0.0f;
            this.Hw = 0;
        }
    }

    class e {
        public SparseBooleanArray DW;
        public Vector<b> FH;
        public SparseArray<c> Hw;
        final /* synthetic */ b Zo;
        public SparseArray<a> j6;
        public Vector<d> v5;

        e(b bVar) {
            this.Zo = bVar;
            this.j6 = new SparseArray();
            this.DW = new SparseBooleanArray();
            this.FH = new Vector();
            this.Hw = new SparseArray();
            this.v5 = new Vector();
        }
    }

    b() {
        this.DW = "NOT_FOUND";
        this.FH = new Vector();
        this.Hw = new SparseArray();
        this.v5 = null;
    }

    static {
        j6 = b.class.getSimpleName();
    }

    private String DW(int i) {
        if (i < 0 || i >= this.FH.size()) {
            return "NOT_FOUND";
        }
        return (String) this.FH.get(i);
    }

    int j6(String str) {
        if (!this.FH.contains(str)) {
            this.FH.add(str);
        }
        return this.FH.indexOf(str);
    }

    public e j6(int i) {
        if (this.Hw.get(i) != null) {
            return (e) this.Hw.get(i);
        }
        if (this.v5 != null) {
            int size = this.v5.j6.size();
            for (int i2 = 0; i2 < size; i2++) {
                Log.i(j6, "Using controller fallback=" + DW(((a) this.v5.j6.valueAt(i2)).j6));
            }
        }
        return this.v5;
    }

    public c j6(e eVar, int i) {
        if (eVar == null || eVar.Hw.get(i) == null) {
            return null;
        }
        return (c) eVar.Hw.get(i);
    }

    public void DW(String str) {
        if (str != null) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                if (jSONObject.has("controller")) {
                    JSONArray jSONArray = jSONObject.getJSONArray("controller");
                    for (int i = 0; i < jSONArray.length(); i++) {
                        int i2;
                        JSONObject jSONObject2;
                        e eVar = new e(this);
                        JSONObject jSONObject3 = jSONArray.getJSONObject(i);
                        JSONArray jSONArray2 = jSONObject3.getJSONArray("alias");
                        for (i2 = 0; i2 < jSONArray2.length(); i2++) {
                            JSONObject jSONObject4 = jSONArray2.getJSONObject(i2);
                            a aVar = new a();
                            aVar.j6 = j6(jSONObject4.getString("name"));
                            aVar.DW = j6(jSONObject4.getString("friendly_name"));
                            if (jSONObject4.has("fallback")) {
                                aVar.FH = jSONObject4.getBoolean("fallback");
                            }
                            eVar.j6.put(aVar.j6, aVar);
                            this.Hw.put(aVar.j6, eVar);
                            if (aVar.FH) {
                                this.v5 = eVar;
                            }
                        }
                        if (jSONObject3.has("axis_exclude_source")) {
                            jSONArray2 = jSONObject3.getJSONArray("axis_exclude_source");
                            for (i2 = 0; i2 < jSONArray2.length(); i2++) {
                                eVar.DW.append(jSONArray2.getInt(i2), true);
                            }
                        }
                        if (jSONObject3.has("axis_remap")) {
                            jSONArray2 = jSONObject3.getJSONArray("axis_remap");
                            for (i2 = 0; i2 < jSONArray2.length(); i2++) {
                                b bVar = new b(this);
                                jSONObject2 = jSONArray2.getJSONObject(i2);
                                bVar.j6 = jSONObject2.getInt("source_axis");
                                bVar.DW = jSONObject2.getInt("destination_axis");
                                eVar.FH.add(bVar);
                            }
                        }
                        if (jSONObject3.has("button_is_axis")) {
                            jSONArray2 = jSONObject3.getJSONArray("button_is_axis");
                            for (i2 = 0; i2 < jSONArray2.length(); i2++) {
                                d dVar = new d(this);
                                jSONObject2 = jSONArray2.getJSONObject(i2);
                                dVar.j6 = jSONObject2.getInt("source_axis");
                                dVar.DW = (float) jSONObject2.getDouble("action_down_max");
                                dVar.FH = (float) jSONObject2.getDouble("action_down_min");
                                dVar.Hw = jSONObject2.getInt("destination_keycode");
                                eVar.v5.add(dVar);
                            }
                        }
                        if (jSONObject3.has("button")) {
                            jSONArray2 = jSONObject3.getJSONArray("button");
                            for (int i3 = 0; i3 < jSONArray2.length(); i3++) {
                                c cVar = new c(this);
                                jSONObject = jSONArray2.getJSONObject(i3);
                                cVar.j6 = jSONObject.getInt("source_keycode");
                                int i4 = jSONObject.getInt("destination_keycode");
                                if (jSONObject.has("exclude_source")) {
                                    JSONArray jSONArray3 = jSONObject.getJSONArray("exclude_source");
                                    for (i2 = 0; i2 < jSONArray3.length(); i2++) {
                                        cVar.FH.append(jSONArray3.getInt(i2), true);
                                    }
                                }
                                cVar.DW = i4;
                                eVar.Hw.put(cVar.j6, cVar);
                            }
                        }
                    }
                }
            } catch (Throwable e) {
                Log.e(j6, "Failed to load input json: ", e);
            }
        }
    }
}
