package com.google.android.gms.internal;

import com.google.android.gms.ads.internal.util.client.b;
import org.json.JSONObject;

@eh
public class dk {
    private final boolean DW;
    private final boolean FH;
    private final boolean Hw;
    private final boolean j6;
    private final boolean v5;

    public static final class a {
        private boolean DW;
        private boolean FH;
        private boolean Hw;
        private boolean j6;
        private boolean v5;

        public a DW(boolean z) {
            this.DW = z;
            return this;
        }

        public a FH(boolean z) {
            this.FH = z;
            return this;
        }

        public a Hw(boolean z) {
            this.Hw = z;
            return this;
        }

        public a j6(boolean z) {
            this.j6 = z;
            return this;
        }

        public dk j6() {
            return new dk();
        }

        public a v5(boolean z) {
            this.v5 = z;
            return this;
        }
    }

    private dk(a aVar) {
        this.j6 = aVar.j6;
        this.DW = aVar.DW;
        this.FH = aVar.FH;
        this.Hw = aVar.Hw;
        this.v5 = aVar.v5;
    }

    public JSONObject j6() {
        try {
            return new JSONObject().put("sms", this.j6).put("tel", this.DW).put("calendar", this.FH).put("storePicture", this.Hw).put("inlineVideo", this.v5);
        } catch (Throwable e) {
            b.DW("Error occured while obtaining the MRAID capabilities.", e);
            return null;
        }
    }
}
