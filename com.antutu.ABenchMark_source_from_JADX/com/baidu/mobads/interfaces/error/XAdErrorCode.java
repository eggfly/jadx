package com.baidu.mobads.interfaces.error;

public enum XAdErrorCode {
    INTERFACE_USE_PROBLEM(1010001, "\u63a5\u53e3\u4f7f\u7528\u95ee\u9898"),
    WEBVIEW_LOAD_ERROR(1010002, "web\u8f7d\u5165\u5f02\u5e38"),
    VIEWKIT_PUT_PROBLEM(1010003, "\u63a7\u4ef6\u6446\u653e\u95ee\u9898"),
    VIEWKIT_TOO_SMALL(1010004, "\u63a7\u4ef6\u8fc7\u5c0f"),
    NETWORK_UNCONNECT(1020001, "\u7f51\u7edc\u8fde\u63a5\u95ee\u9898"),
    PERMISSION_PROBLEM(1030002, "\u6743\u9650\u8bbe\u7f6e\u95ee\u9898"),
    SETTINGS_ERROR(1030002, "\u8bbe\u7f6e\u95ee\u9898"),
    REQUEST_PARAM_ERROR(1040001, "\u8bf7\u6c42\u53c2\u6570\u95ee\u9898"),
    REQUEST_URL_TOO_LONG(1040002, "\u8bf7\u6c42\u4e32\u8fc7\u957f"),
    REQUEST_TIMEOUT(1040003, "\u8bf7\u6c42\u8d85\u65f6"),
    REQUEST_STATUS_CODE_ERROR(1040004, "\u72b6\u6001\u7801\u5f02\u5e38"),
    RESPONSE_PARSE_FAILED(3010001, "\u6e05\u5355\u89e3\u6790\u5931\u8d25"),
    RESPONSE_FIELD_LESS(3010002, "\u6e05\u5355\u7f3a\u5c11\u5b57\u6bb5"),
    RESPONSE_MTYPE_UNSUPPORT(3010003, "\u7269\u6599\u7c7b\u578b\u4e0d\u652f\u6301"),
    RESPONSE_ATYPE_UNSUPPORT(3010004, "\u8df3\u8f6c\u7c7b\u578b\u4e0d\u652f\u6301"),
    RESPONSE_HTML_ERROR(3010005, "\u5e7f\u544a\u670d\u52a1\u5668\u8fd4\u56de\u7684html\u5185\u5bb9\u9519\u8bef, AD-SDK\u65e0\u6cd5\u6e32\u67d3\u8be5\u5e7f\u544a"),
    FILTER_APP_INSTALLED(3020001, "\u63a8\u5e7f\u5e94\u7528\u5df2\u88ab\u5b89\u88c5"),
    FILTER_APP_UNINSTALLED(3020002, "\u63a8\u5e7f\u5e94\u7528\u672a\u88ab\u5b89\u88c5"),
    MCACHE_PREPARE_FAILED(3030001, "\u7f13\u5b58\u51c6\u5907\u5931\u8d25"),
    MCACHE_FETCH_FAILED(3030002, "\u7f13\u5b58\u7269\u6599\u5931\u8d25"),
    SHOW_STANDARD_UNFIT(3040001, "\u5e7f\u544a\u5c55\u73b0\u6807\u51c6\u4e0d\u8fbe\u6807"),
    SHOW_PROCESS_FAILED(3040002, "\u5e7f\u544a\u5c55\u73b0\u5931\u8d25"),
    CLICK_PARSE_FAILED(4010001, "\u70b9\u51fb\u4fe1\u606f\u89e3\u6790\u5931\u8d25"),
    CLICK_FIELD_LESS(4010002, "\u70b9\u51fb\u4fe1\u606f\u7f3a\u5931"),
    CLICK_FIELD_ERROR(4010003, "\u70b9\u51fb\u4fe1\u606f\u6709\u8bef"),
    CLICK_JUMP_FAILED(4010004, "\u70b9\u51fb\u8df3\u8f6c\u5931\u8d25"),
    LOADING_LP_ERROR(4020001, "\u6253\u5f00LP\u95ee\u9898"),
    LOADING_DL_ERROR(4020002, "\u4e0b\u8f7d\u5668\u95ee\u9898"),
    MONITOR_START_FAILED(4030001, "\u76d1\u63a7\u542f\u52a8\u5931\u8d25");
    
    public static final String ERROR_CODE_MESSAGE = "msg";
    private int f6911a;
    private String f6912b;

    private XAdErrorCode(int i, String str) {
        this.f6911a = i;
        this.f6912b = str;
    }

    public int getCode() {
        return this.f6911a;
    }

    public String getMessage() {
        return this.f6912b;
    }
}
