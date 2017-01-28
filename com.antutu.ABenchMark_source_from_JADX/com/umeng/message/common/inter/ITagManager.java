package com.umeng.message.common.inter;

import com.umeng.message.MsgConstant;
import java.util.List;
import org.json.JSONObject;

public interface ITagManager {
    public static final String FAIL = "fail";
    public static final String SUCCESS = "ok";

    public static class Result {
        public String errors;
        public String jsonString;
        public int remain;
        public String status;

        public Result(JSONObject jSONObject) {
            this.status = jSONObject.optString(MsgConstant.KEY_SUCCESS, ITagManager.FAIL);
            this.remain = jSONObject.optInt("remain", 0);
            this.errors = jSONObject.optString("errors");
            this.jsonString = jSONObject.toString();
        }

        public String toString() {
            return this.jsonString;
        }
    }

    Result add(JSONObject jSONObject, boolean z, String... strArr);

    Result delete(JSONObject jSONObject, boolean z, String... strArr);

    List<String> list(JSONObject jSONObject, boolean z);

    Result reset(JSONObject jSONObject, boolean z);

    Result update(JSONObject jSONObject, boolean z, String... strArr);
}
