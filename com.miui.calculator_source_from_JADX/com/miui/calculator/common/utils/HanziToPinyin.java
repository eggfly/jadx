package com.miui.calculator.common.utils;

import android.text.TextUtils;
import android.util.Log;
import java.text.Collator;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Locale;

public class HanziToPinyin {
    public static final char[] f1529a;
    public static final byte[][] f1530b;
    private static HashMap<Character, String[]> f1531c;
    private static HashMap<String, String[]> f1532d;
    private static HashMap<Character, String> f1533e;
    private static final Collator f1534f;
    private static HanziToPinyin f1535g;
    private static final char[] f1536i;
    private final boolean f1537h;

    public static class Token {
        public int f1525a;
        public String f1526b;
        public String f1527c;
        public String[] f1528d;

        public Token(int i, String str, String str2) {
            this.f1525a = i;
            this.f1526b = str;
            this.f1527c = str2;
        }
    }

    static {
        f1529a = new char[]{'\u5475', '\u54ce', '\u5b89', '\u80ae', '\u51f9', '\u516b', '\u6300', '\u6273', '\u90a6', '\u5305', '\u5351', '\u5954', '\u4f3b', '\u5c44', '\u8fb9', '\u6807', '\u618b', '\u90a0', '\u69df', '\u7676', '\u5cec', '\u5693', '\u5a47', '\u98e1', '\u4ed3', '\u64cd', '\u518a', '\u5d7e', '\u564c', '\u53c9', '\u9497', '\u8fbf', '\u4f25', '\u6284', '\u8f66', '\u62bb', '\u67fd', '\u5403', '\u5145', '\u62bd', '\u51fa', '\u6b3b', '\u63e3', '\u5ddd', '\u75ae', '\u5439', '\u6776', '\u9034', '\u75b5', '\u5306', '\u51d1', '\u7c97', '\u6c46', '\u5d14', '\u90a8', '\u6413', '\u5491', '\u5927', '\u75b8', '\u5f53', '\u5200', '\u6dc2', '\u5f97', '\u6265', '\u706f', '\u6c10', '\u55f2', '\u7538', '\u5201', '\u7239', '\u4ec3', '\u4e1f', '\u4e1c', '\u5517', '\u561f', '\u5073', '\u5806', '\u9413', '\u591a', '\u5a40', '\u8bf6', '\u5940', '\u97a5', '\u800c', '\u53d1', '\u5e06', '\u65b9', '\u98de', '\u5206', '\u4e30', '\u8985', '\u4ecf', '\u7d11', '\u4f15', '\u65ee', '\u8be5', '\u7518', '\u5188', '\u768b', '\u6208', '\u7d66', '\u6839', '\u5e9a', '\u5de5', '\u52fe', '\u4f30', '\u74dc', '\u7f6b', '\u5173', '\u5149', '\u5f52', '\u886e', '\u5459', '\u54c8', '\u54b3', '\u9878', '\u82c0', '\u84bf', '\u8bc3', '\u9ed2', '\u62eb', '\u4ea8', '\u5677', '\u543d', '\u9f41', '\u5322', '\u82b1', '\u6000', '\u72bf', '\u5ddf', '\u7070', '\u660f', '\u5419', '\u4e0c', '\u52a0', '\u620b', '\u6c5f', '\u827d', '\u9636', '\u5dfe', '\u52a4', '\u5182', '\u52fc', '\u530a', '\u5a1f', '\u5658', '\u519b', '\u5494', '\u5f00', '\u520a', '\u95f6', '\u5c3b', '\u533c', '\u524b', '\u80af', '\u962c', '\u7a7a', '\u62a0', '\u5233', '\u5938', '\u84af', '\u5bbd', '\u5321', '\u4e8f', '\u5764', '\u6269', '\u5783', '\u6765', '\u5170', '\u5577', '\u635e', '\u4ec2', '\u52d2', '\u5844', '\u5215', '\u5006', '\u5941', '\u826f', '\u64a9', '\u5217', '\u62ce', '\u3007', '\u6e9c', '\u9f99', '\u779c', '\u565c', '\u5a08', '\u7567', '\u62a1', '\u7f57', '\u5463', '\u5988', '\u973e', '\u5ada', '\u9099', '\u732b', '\u9ebc', '\u6c92', '\u95e8', '\u753f', '\u54aa', '\u7720', '\u55b5', '\u54a9', '\u6c11', '\u540d', '\u8c2c', '\u6478', '\u54de', '\u6bea', '\u62cf', '\u5b7b', '\u56e1', '\u56ca', '\u5b6c', '\u8bb7', '\u9981', '\u6041', '\u80fd', '\u59ae', '\u62c8', '\u5b22', '\u9e1f', '\u634f', '\u60a8', '\u5b81', '\u599e', '\u519c', '\u7fba', '\u5974', '\u597b', '\u8650', '\u632a', '\u5594', '\u8bb4', '\u8db4', '\u62cd', '\u7705', '\u4e53', '\u629b', '\u5478', '\u55b7', '\u5309', '\u4e15', '\u504f', '\u527d', '\u6c15', '\u59d8', '\u4e52', '\u948b', '\u5256', '\u4ec6', '\u4e03', '\u6390', '\u5343', '\u545b', '\u6084', '\u767f', '\u4fb5', '\u9751', '\u909b', '\u4e18', '\u66f2', '\u5f2e', '\u7f3a', '\u590b', '\u5465', '\u7a63', '\u5a06', '\u60f9', '\u4eba', '\u6254', '\u65e5', '\u8338', '\u53b9', '\u5982', '\u5827', '\u6875', '\u95f0', '\u82e5', '\u4ee8', '\u6be2', '\u4e09', '\u6852', '\u63bb', '\u8272', '\u68ee', '\u50e7', '\u6740', '\u7b5b', '\u5c71', '\u4f24', '\u5f30', '\u5962', '\u7533', '\u5347', '\u5c38', '\u53ce', '\u4e66', '\u5237', '\u6454', '\u95e9', '\u53cc', '\u8c01', '\u542e', '\u5981', '\u53b6', '\u5fea', '\u635c', '\u82cf', '\u72fb', '\u590a', '\u5b59', '\u5506', '\u4ed6', '\u82d4', '\u574d', '\u94f4', '\u5932', '\u5fd1', '\u71a5', '\u5254', '\u5929', '\u4f7b', '\u5e16', '\u5385', '\u56f2', '\u5077', '\u92c0', '\u6e4d', '\u63a8', '\u541e', '\u6258', '\u6316', '\u6b6a', '\u5f2f', '\u5c2a', '\u5371', '\u586d', '\u7fc1', '\u631d', '\u5140', '\u5915', '\u867e', '\u4eda', '\u4e61', '\u7071', '\u4e9b', '\u5fc3', '\u661f', '\u51f6', '\u4f11', '\u65f4', '\u8f69', '\u75b6', '\u52cb', '\u4e2b', '\u6079', '\u592e', '\u5e7a', '\u8036', '\u4e00', '\u6b2d', '\u5e94', '\u54df', '\u4f63', '\u4f18', '\u625c', '\u9e22', '\u66f0', '\u6655', '\u531d', '\u707d', '\u7ccc', '\u7242', '\u50ae', '\u5219', '\u8d3c', '\u600e', '\u5897', '\u5412', '\u635a', '\u6cbe', '\u5f20', '\u948a', '\u8707', '\u8d1e', '\u4e89', '\u4e4b', '\u4e2d', '\u5dde', '\u6731', '\u6293', '\u8de9', '\u4e13', '\u5986', '\u96b9', '\u5b92', '\u5353', '\u5b5c', '\u5b97', '\u90b9', '\u79df', '\u94bb', '\u539c', '\u5c0a', '\u6628'};
        f1530b = new byte[][]{new byte[]{(byte) 65, (byte) 0, (byte) 0, (byte) 0, (byte) 0, (byte) 0}, new byte[]{(byte) 65, (byte) 73, (byte) 0, (byte) 0, (byte) 0, (byte) 0}, new byte[]{(byte) 65, (byte) 78, (byte) 0, (byte) 0, (byte) 0, (byte) 0}, new byte[]{(byte) 65, (byte) 78, (byte) 71, (byte) 0, (byte) 0, (byte) 0}, new byte[]{(byte) 65, (byte) 79, (byte) 0, (byte) 0, (byte) 0, (byte) 0}, new byte[]{(byte) 66, (byte) 65, (byte) 0, (byte) 0, (byte) 0, (byte) 0}, new byte[]{(byte) 66, (byte) 65, (byte) 73, (byte) 0, (byte) 0, (byte) 0}, new byte[]{(byte) 66, (byte) 65, (byte) 78, (byte) 0, (byte) 0, (byte) 0}, new byte[]{(byte) 66, (byte) 65, (byte) 78, (byte) 71, (byte) 0, (byte) 0}, new byte[]{(byte) 66, (byte) 65, (byte) 79, (byte) 0, (byte) 0, (byte) 0}, new byte[]{(byte) 66, (byte) 69, (byte) 73, (byte) 0, (byte) 0, (byte) 0}, new byte[]{(byte) 66, (byte) 69, (byte) 78, (byte) 0, (byte) 0, (byte) 0}, new byte[]{(byte) 66, (byte) 69, (byte) 78, (byte) 71, (byte) 0, (byte) 0}, new byte[]{(byte) 66, (byte) 73, (byte) 0, (byte) 0, (byte) 0, (byte) 0}, new byte[]{(byte) 66, (byte) 73, (byte) 65, (byte) 78, (byte) 0, (byte) 0}, new byte[]{(byte) 66, (byte) 73, (byte) 65, (byte) 79, (byte) 0, (byte) 0}, new byte[]{(byte) 66, (byte) 73, (byte) 69, (byte) 0, (byte) 0, (byte) 0}, new byte[]{(byte) 66, (byte) 73, (byte) 78, (byte) 0, (byte) 0, (byte) 0}, new byte[]{(byte) 66, (byte) 73, (byte) 78, (byte) 71, (byte) 0, (byte) 0}, new byte[]{(byte) 66, (byte) 79, (byte) 0, (byte) 0, (byte) 0, (byte) 0}, new byte[]{(byte) 66, (byte) 85, (byte) 0, (byte) 0, (byte) 0, (byte) 0}, new byte[]{(byte) 67, (byte) 65, (byte) 0, (byte) 0, (byte) 0, (byte) 0}, new byte[]{(byte) 67, (byte) 65, (byte) 73, (byte) 0, (byte) 0, (byte) 0}, new byte[]{(byte) 67, (byte) 65, (byte) 78, (byte) 0, (byte) 0, (byte) 0}, new byte[]{(byte) 67, (byte) 65, (byte) 78, (byte) 71, (byte) 0, (byte) 0}, new byte[]{(byte) 67, (byte) 65, (byte) 79, (byte) 0, (byte) 0, (byte) 0}, new byte[]{(byte) 67, (byte) 69, (byte) 0, (byte) 0, (byte) 0, (byte) 0}, new byte[]{(byte) 67, (byte) 69, (byte) 78, (byte) 0, (byte) 0, (byte) 0}, new byte[]{(byte) 67, (byte) 69, (byte) 78, (byte) 71, (byte) 0, (byte) 0}, new byte[]{(byte) 67, (byte) 72, (byte) 65, (byte) 0, (byte) 0, (byte) 0}, new byte[]{(byte) 67, (byte) 72, (byte) 65, (byte) 73, (byte) 0, (byte) 0}, new byte[]{(byte) 67, (byte) 72, (byte) 65, (byte) 78, (byte) 0, (byte) 0}, new byte[]{(byte) 67, (byte) 72, (byte) 65, (byte) 78, (byte) 71, (byte) 0}, new byte[]{(byte) 67, (byte) 72, (byte) 65, (byte) 79, (byte) 0, (byte) 0}, new byte[]{(byte) 67, (byte) 72, (byte) 69, (byte) 0, (byte) 0, (byte) 0}, new byte[]{(byte) 67, (byte) 72, (byte) 69, (byte) 78, (byte) 0, (byte) 0}, new byte[]{(byte) 67, (byte) 72, (byte) 69, (byte) 78, (byte) 71, (byte) 0}, new byte[]{(byte) 67, (byte) 72, (byte) 73, (byte) 0, (byte) 0, (byte) 0}, new byte[]{(byte) 67, (byte) 72, (byte) 79, (byte) 78, (byte) 71, (byte) 0}, new byte[]{(byte) 67, (byte) 72, (byte) 79, (byte) 85, (byte) 0, (byte) 0}, new byte[]{(byte) 67, (byte) 72, (byte) 85, (byte) 0, (byte) 0, (byte) 0}, new byte[]{(byte) 67, (byte) 72, (byte) 85, (byte) 65, (byte) 0, (byte) 0}, new byte[]{(byte) 67, (byte) 72, (byte) 85, (byte) 65, (byte) 73, (byte) 0}, new byte[]{(byte) 67, (byte) 72, (byte) 85, (byte) 65, (byte) 78, (byte) 0}, new byte[]{(byte) 67, (byte) 72, (byte) 85, (byte) 65, (byte) 78, (byte) 71}, new byte[]{(byte) 67, (byte) 72, (byte) 85, (byte) 73, (byte) 0, (byte) 0}, new byte[]{(byte) 67, (byte) 72, (byte) 85, (byte) 78, (byte) 0, (byte) 0}, new byte[]{(byte) 67, (byte) 72, (byte) 85, (byte) 79, (byte) 0, (byte) 0}, new byte[]{(byte) 67, (byte) 73, (byte) 0, (byte) 0, (byte) 0, (byte) 0}, new byte[]{(byte) 67, (byte) 79, (byte) 78, (byte) 71, (byte) 0, (byte) 0}, new byte[]{(byte) 67, (byte) 79, (byte) 85, (byte) 0, (byte) 0, (byte) 0}, new byte[]{(byte) 67, (byte) 85, (byte) 0, (byte) 0, (byte) 0, (byte) 0}, new byte[]{(byte) 67, (byte) 85, (byte) 65, (byte) 78, (byte) 0, (byte) 0}, new byte[]{(byte) 67, (byte) 85, (byte) 73, (byte) 0, (byte) 0, (byte) 0}, new byte[]{(byte) 67, (byte) 85, (byte) 78, (byte) 0, (byte) 0, (byte) 0}, new byte[]{(byte) 67, (byte) 85, (byte) 79, (byte) 0, (byte) 0, (byte) 0}, new byte[]{(byte) 68, (byte) 65, (byte) 0, (byte) 0, (byte) 0, (byte) 0}, new byte[]{(byte) 68, (byte) 65, (byte) 73, (byte) 0, (byte) 0, (byte) 0}, new byte[]{(byte) 68, (byte) 65, (byte) 78, (byte) 0, (byte) 0, (byte) 0}, new byte[]{(byte) 68, (byte) 65, (byte) 78, (byte) 71, (byte) 0, (byte) 0}, new byte[]{(byte) 68, (byte) 65, (byte) 79, (byte) 0, (byte) 0, (byte) 0}, new byte[]{(byte) 68, (byte) 69, (byte) 0, (byte) 0, (byte) 0, (byte) 0}, new byte[]{(byte) 68, (byte) 69, (byte) 73, (byte) 0, (byte) 0, (byte) 0}, new byte[]{(byte) 68, (byte) 69, (byte) 78, (byte) 0, (byte) 0, (byte) 0}, new byte[]{(byte) 68, (byte) 69, (byte) 78, (byte) 71, (byte) 0, (byte) 0}, new byte[]{(byte) 68, (byte) 73, (byte) 0, (byte) 0, (byte) 0, (byte) 0}, new byte[]{(byte) 68, (byte) 73, (byte) 65, (byte) 0, (byte) 0, (byte) 0}, new byte[]{(byte) 68, (byte) 73, (byte) 65, (byte) 78, (byte) 0, (byte) 0}, new byte[]{(byte) 68, (byte) 73, (byte) 65, (byte) 79, (byte) 0, (byte) 0}, new byte[]{(byte) 68, (byte) 73, (byte) 69, (byte) 0, (byte) 0, (byte) 0}, new byte[]{(byte) 68, (byte) 73, (byte) 78, (byte) 71, (byte) 0, (byte) 0}, new byte[]{(byte) 68, (byte) 73, (byte) 85, (byte) 0, (byte) 0, (byte) 0}, new byte[]{(byte) 68, (byte) 79, (byte) 78, (byte) 71, (byte) 0, (byte) 0}, new byte[]{(byte) 68, (byte) 79, (byte) 85, (byte) 0, (byte) 0, (byte) 0}, new byte[]{(byte) 68, (byte) 85, (byte) 0, (byte) 0, (byte) 0, (byte) 0}, new byte[]{(byte) 68, (byte) 85, (byte) 65, (byte) 78, (byte) 0, (byte) 0}, new byte[]{(byte) 68, (byte) 85, (byte) 73, (byte) 0, (byte) 0, (byte) 0}, new byte[]{(byte) 68, (byte) 85, (byte) 78, (byte) 0, (byte) 0, (byte) 0}, new byte[]{(byte) 68, (byte) 85, (byte) 79, (byte) 0, (byte) 0, (byte) 0}, new byte[]{(byte) 69, (byte) 0, (byte) 0, (byte) 0, (byte) 0, (byte) 0}, new byte[]{(byte) 69, (byte) 73, (byte) 0, (byte) 0, (byte) 0, (byte) 0}, new byte[]{(byte) 69, (byte) 78, (byte) 0, (byte) 0, (byte) 0, (byte) 0}, new byte[]{(byte) 69, (byte) 78, (byte) 71, (byte) 0, (byte) 0, (byte) 0}, new byte[]{(byte) 69, (byte) 82, (byte) 0, (byte) 0, (byte) 0, (byte) 0}, new byte[]{(byte) 70, (byte) 65, (byte) 0, (byte) 0, (byte) 0, (byte) 0}, new byte[]{(byte) 70, (byte) 65, (byte) 78, (byte) 0, (byte) 0, (byte) 0}, new byte[]{(byte) 70, (byte) 65, (byte) 78, (byte) 71, (byte) 0, (byte) 0}, new byte[]{(byte) 70, (byte) 69, (byte) 73, (byte) 0, (byte) 0, (byte) 0}, new byte[]{(byte) 70, (byte) 69, (byte) 78, (byte) 0, (byte) 0, (byte) 0}, new byte[]{(byte) 70, (byte) 69, (byte) 78, (byte) 71, (byte) 0, (byte) 0}, new byte[]{(byte) 70, (byte) 73, (byte) 65, (byte) 79, (byte) 0, (byte) 0}, new byte[]{(byte) 70, (byte) 79, (byte) 0, (byte) 0, (byte) 0, (byte) 0}, new byte[]{(byte) 70, (byte) 79, (byte) 85, (byte) 0, (byte) 0, (byte) 0}, new byte[]{(byte) 70, (byte) 85, (byte) 0, (byte) 0, (byte) 0, (byte) 0}, new byte[]{(byte) 71, (byte) 65, (byte) 0, (byte) 0, (byte) 0, (byte) 0}, new byte[]{(byte) 71, (byte) 65, (byte) 73, (byte) 0, (byte) 0, (byte) 0}, new byte[]{(byte) 71, (byte) 65, (byte) 78, (byte) 0, (byte) 0, (byte) 0}, new byte[]{(byte) 71, (byte) 65, (byte) 78, (byte) 71, (byte) 0, (byte) 0}, new byte[]{(byte) 71, (byte) 65, (byte) 79, (byte) 0, (byte) 0, (byte) 0}, new byte[]{(byte) 71, (byte) 69, (byte) 0, (byte) 0, (byte) 0, (byte) 0}, new byte[]{(byte) 71, (byte) 69, (byte) 73, (byte) 0, (byte) 0, (byte) 0}, new byte[]{(byte) 71, (byte) 69, (byte) 78, (byte) 0, (byte) 0, (byte) 0}, new byte[]{(byte) 71, (byte) 69, (byte) 78, (byte) 71, (byte) 0, (byte) 0}, new byte[]{(byte) 71, (byte) 79, (byte) 78, (byte) 71, (byte) 0, (byte) 0}, new byte[]{(byte) 71, (byte) 79, (byte) 85, (byte) 0, (byte) 0, (byte) 0}, new byte[]{(byte) 71, (byte) 85, (byte) 0, (byte) 0, (byte) 0, (byte) 0}, new byte[]{(byte) 71, (byte) 85, (byte) 65, (byte) 0, (byte) 0, (byte) 0}, new byte[]{(byte) 71, (byte) 85, (byte) 65, (byte) 73, (byte) 0, (byte) 0}, new byte[]{(byte) 71, (byte) 85, (byte) 65, (byte) 78, (byte) 0, (byte) 0}, new byte[]{(byte) 71, (byte) 85, (byte) 65, (byte) 78, (byte) 71, (byte) 0}, new byte[]{(byte) 71, (byte) 85, (byte) 73, (byte) 0, (byte) 0, (byte) 0}, new byte[]{(byte) 71, (byte) 85, (byte) 78, (byte) 0, (byte) 0, (byte) 0}, new byte[]{(byte) 71, (byte) 85, (byte) 79, (byte) 0, (byte) 0, (byte) 0}, new byte[]{(byte) 72, (byte) 65, (byte) 0, (byte) 0, (byte) 0, (byte) 0}, new byte[]{(byte) 72, (byte) 65, (byte) 73, (byte) 0, (byte) 0, (byte) 0}, new byte[]{(byte) 72, (byte) 65, (byte) 78, (byte) 0, (byte) 0, (byte) 0}, new byte[]{(byte) 72, (byte) 65, (byte) 78, (byte) 71, (byte) 0, (byte) 0}, new byte[]{(byte) 72, (byte) 65, (byte) 79, (byte) 0, (byte) 0, (byte) 0}, new byte[]{(byte) 72, (byte) 69, (byte) 0, (byte) 0, (byte) 0, (byte) 0}, new byte[]{(byte) 72, (byte) 69, (byte) 73, (byte) 0, (byte) 0, (byte) 0}, new byte[]{(byte) 72, (byte) 69, (byte) 78, (byte) 0, (byte) 0, (byte) 0}, new byte[]{(byte) 72, (byte) 69, (byte) 78, (byte) 71, (byte) 0, (byte) 0}, new byte[]{(byte) 72, (byte) 77, (byte) 0, (byte) 0, (byte) 0, (byte) 0}, new byte[]{(byte) 72, (byte) 79, (byte) 78, (byte) 71, (byte) 0, (byte) 0}, new byte[]{(byte) 72, (byte) 79, (byte) 85, (byte) 0, (byte) 0, (byte) 0}, new byte[]{(byte) 72, (byte) 85, (byte) 0, (byte) 0, (byte) 0, (byte) 0}, new byte[]{(byte) 72, (byte) 85, (byte) 65, (byte) 0, (byte) 0, (byte) 0}, new byte[]{(byte) 72, (byte) 85, (byte) 65, (byte) 73, (byte) 0, (byte) 0}, new byte[]{(byte) 72, (byte) 85, (byte) 65, (byte) 78, (byte) 0, (byte) 0}, new byte[]{(byte) 72, (byte) 85, (byte) 65, (byte) 78, (byte) 71, (byte) 0}, new byte[]{(byte) 72, (byte) 85, (byte) 73, (byte) 0, (byte) 0, (byte) 0}, new byte[]{(byte) 72, (byte) 85, (byte) 78, (byte) 0, (byte) 0, (byte) 0}, new byte[]{(byte) 72, (byte) 85, (byte) 79, (byte) 0, (byte) 0, (byte) 0}, new byte[]{(byte) 74, (byte) 73, (byte) 0, (byte) 0, (byte) 0, (byte) 0}, new byte[]{(byte) 74, (byte) 73, (byte) 65, (byte) 0, (byte) 0, (byte) 0}, new byte[]{(byte) 74, (byte) 73, (byte) 65, (byte) 78, (byte) 0, (byte) 0}, new byte[]{(byte) 74, (byte) 73, (byte) 65, (byte) 78, (byte) 71, (byte) 0}, new byte[]{(byte) 74, (byte) 73, (byte) 65, (byte) 79, (byte) 0, (byte) 0}, new byte[]{(byte) 74, (byte) 73, (byte) 69, (byte) 0, (byte) 0, (byte) 0}, new byte[]{(byte) 74, (byte) 73, (byte) 78, (byte) 0, (byte) 0, (byte) 0}, new byte[]{(byte) 74, (byte) 73, (byte) 78, (byte) 71, (byte) 0, (byte) 0}, new byte[]{(byte) 74, (byte) 73, (byte) 79, (byte) 78, (byte) 71, (byte) 0}, new byte[]{(byte) 74, (byte) 73, (byte) 85, (byte) 0, (byte) 0, (byte) 0}, new byte[]{(byte) 74, (byte) 85, (byte) 0, (byte) 0, (byte) 0, (byte) 0}, new byte[]{(byte) 74, (byte) 85, (byte) 65, (byte) 78, (byte) 0, (byte) 0}, new byte[]{(byte) 74, (byte) 85, (byte) 69, (byte) 0, (byte) 0, (byte) 0}, new byte[]{(byte) 74, (byte) 85, (byte) 78, (byte) 0, (byte) 0, (byte) 0}, new byte[]{(byte) 75, (byte) 65, (byte) 0, (byte) 0, (byte) 0, (byte) 0}, new byte[]{(byte) 75, (byte) 65, (byte) 73, (byte) 0, (byte) 0, (byte) 0}, new byte[]{(byte) 75, (byte) 65, (byte) 78, (byte) 0, (byte) 0, (byte) 0}, new byte[]{(byte) 75, (byte) 65, (byte) 78, (byte) 71, (byte) 0, (byte) 0}, new byte[]{(byte) 75, (byte) 65, (byte) 79, (byte) 0, (byte) 0, (byte) 0}, new byte[]{(byte) 75, (byte) 69, (byte) 0, (byte) 0, (byte) 0, (byte) 0}, new byte[]{(byte) 75, (byte) 69, (byte) 73, (byte) 0, (byte) 0, (byte) 0}, new byte[]{(byte) 75, (byte) 69, (byte) 78, (byte) 0, (byte) 0, (byte) 0}, new byte[]{(byte) 75, (byte) 69, (byte) 78, (byte) 71, (byte) 0, (byte) 0}, new byte[]{(byte) 75, (byte) 79, (byte) 78, (byte) 71, (byte) 0, (byte) 0}, new byte[]{(byte) 75, (byte) 79, (byte) 85, (byte) 0, (byte) 0, (byte) 0}, new byte[]{(byte) 75, (byte) 85, (byte) 0, (byte) 0, (byte) 0, (byte) 0}, new byte[]{(byte) 75, (byte) 85, (byte) 65, (byte) 0, (byte) 0, (byte) 0}, new byte[]{(byte) 75, (byte) 85, (byte) 65, (byte) 73, (byte) 0, (byte) 0}, new byte[]{(byte) 75, (byte) 85, (byte) 65, (byte) 78, (byte) 0, (byte) 0}, new byte[]{(byte) 75, (byte) 85, (byte) 65, (byte) 78, (byte) 71, (byte) 0}, new byte[]{(byte) 75, (byte) 85, (byte) 73, (byte) 0, (byte) 0, (byte) 0}, new byte[]{(byte) 75, (byte) 85, (byte) 78, (byte) 0, (byte) 0, (byte) 0}, new byte[]{(byte) 75, (byte) 85, (byte) 79, (byte) 0, (byte) 0, (byte) 0}, new byte[]{(byte) 76, (byte) 65, (byte) 0, (byte) 0, (byte) 0, (byte) 0}, new byte[]{(byte) 76, (byte) 65, (byte) 73, (byte) 0, (byte) 0, (byte) 0}, new byte[]{(byte) 76, (byte) 65, (byte) 78, (byte) 0, (byte) 0, (byte) 0}, new byte[]{(byte) 76, (byte) 65, (byte) 78, (byte) 71, (byte) 0, (byte) 0}, new byte[]{(byte) 76, (byte) 65, (byte) 79, (byte) 0, (byte) 0, (byte) 0}, new byte[]{(byte) 76, (byte) 69, (byte) 0, (byte) 0, (byte) 0, (byte) 0}, new byte[]{(byte) 76, (byte) 69, (byte) 73, (byte) 0, (byte) 0, (byte) 0}, new byte[]{(byte) 76, (byte) 69, (byte) 78, (byte) 71, (byte) 0, (byte) 0}, new byte[]{(byte) 76, (byte) 73, (byte) 0, (byte) 0, (byte) 0, (byte) 0}, new byte[]{(byte) 76, (byte) 73, (byte) 65, (byte) 0, (byte) 0, (byte) 0}, new byte[]{(byte) 76, (byte) 73, (byte) 65, (byte) 78, (byte) 0, (byte) 0}, new byte[]{(byte) 76, (byte) 73, (byte) 65, (byte) 78, (byte) 71, (byte) 0}, new byte[]{(byte) 76, (byte) 73, (byte) 65, (byte) 79, (byte) 0, (byte) 0}, new byte[]{(byte) 76, (byte) 73, (byte) 69, (byte) 0, (byte) 0, (byte) 0}, new byte[]{(byte) 76, (byte) 73, (byte) 78, (byte) 0, (byte) 0, (byte) 0}, new byte[]{(byte) 76, (byte) 73, (byte) 78, (byte) 71, (byte) 0, (byte) 0}, new byte[]{(byte) 76, (byte) 73, (byte) 85, (byte) 0, (byte) 0, (byte) 0}, new byte[]{(byte) 76, (byte) 79, (byte) 78, (byte) 71, (byte) 0, (byte) 0}, new byte[]{(byte) 76, (byte) 79, (byte) 85, (byte) 0, (byte) 0, (byte) 0}, new byte[]{(byte) 76, (byte) 85, (byte) 0, (byte) 0, (byte) 0, (byte) 0}, new byte[]{(byte) 76, (byte) 85, (byte) 65, (byte) 78, (byte) 0, (byte) 0}, new byte[]{(byte) 76, (byte) 85, (byte) 69, (byte) 0, (byte) 0, (byte) 0}, new byte[]{(byte) 76, (byte) 85, (byte) 78, (byte) 0, (byte) 0, (byte) 0}, new byte[]{(byte) 76, (byte) 85, (byte) 79, (byte) 0, (byte) 0, (byte) 0}, new byte[]{(byte) 77, (byte) 0, (byte) 0, (byte) 0, (byte) 0, (byte) 0}, new byte[]{(byte) 77, (byte) 65, (byte) 0, (byte) 0, (byte) 0, (byte) 0}, new byte[]{(byte) 77, (byte) 65, (byte) 73, (byte) 0, (byte) 0, (byte) 0}, new byte[]{(byte) 77, (byte) 65, (byte) 78, (byte) 0, (byte) 0, (byte) 0}, new byte[]{(byte) 77, (byte) 65, (byte) 78, (byte) 71, (byte) 0, (byte) 0}, new byte[]{(byte) 77, (byte) 65, (byte) 79, (byte) 0, (byte) 0, (byte) 0}, new byte[]{(byte) 77, (byte) 69, (byte) 0, (byte) 0, (byte) 0, (byte) 0}, new byte[]{(byte) 77, (byte) 69, (byte) 73, (byte) 0, (byte) 0, (byte) 0}, new byte[]{(byte) 77, (byte) 69, (byte) 78, (byte) 0, (byte) 0, (byte) 0}, new byte[]{(byte) 77, (byte) 69, (byte) 78, (byte) 71, (byte) 0, (byte) 0}, new byte[]{(byte) 77, (byte) 73, (byte) 0, (byte) 0, (byte) 0, (byte) 0}, new byte[]{(byte) 77, (byte) 73, (byte) 65, (byte) 78, (byte) 0, (byte) 0}, new byte[]{(byte) 77, (byte) 73, (byte) 65, (byte) 79, (byte) 0, (byte) 0}, new byte[]{(byte) 77, (byte) 73, (byte) 69, (byte) 0, (byte) 0, (byte) 0}, new byte[]{(byte) 77, (byte) 73, (byte) 78, (byte) 0, (byte) 0, (byte) 0}, new byte[]{(byte) 77, (byte) 73, (byte) 78, (byte) 71, (byte) 0, (byte) 0}, new byte[]{(byte) 77, (byte) 73, (byte) 85, (byte) 0, (byte) 0, (byte) 0}, new byte[]{(byte) 77, (byte) 79, (byte) 0, (byte) 0, (byte) 0, (byte) 0}, new byte[]{(byte) 77, (byte) 79, (byte) 85, (byte) 0, (byte) 0, (byte) 0}, new byte[]{(byte) 77, (byte) 85, (byte) 0, (byte) 0, (byte) 0, (byte) 0}, new byte[]{(byte) 78, (byte) 65, (byte) 0, (byte) 0, (byte) 0, (byte) 0}, new byte[]{(byte) 78, (byte) 65, (byte) 73, (byte) 0, (byte) 0, (byte) 0}, new byte[]{(byte) 78, (byte) 65, (byte) 78, (byte) 0, (byte) 0, (byte) 0}, new byte[]{(byte) 78, (byte) 65, (byte) 78, (byte) 71, (byte) 0, (byte) 0}, new byte[]{(byte) 78, (byte) 65, (byte) 79, (byte) 0, (byte) 0, (byte) 0}, new byte[]{(byte) 78, (byte) 69, (byte) 0, (byte) 0, (byte) 0, (byte) 0}, new byte[]{(byte) 78, (byte) 69, (byte) 73, (byte) 0, (byte) 0, (byte) 0}, new byte[]{(byte) 78, (byte) 69, (byte) 78, (byte) 0, (byte) 0, (byte) 0}, new byte[]{(byte) 78, (byte) 69, (byte) 78, (byte) 71, (byte) 0, (byte) 0}, new byte[]{(byte) 78, (byte) 73, (byte) 0, (byte) 0, (byte) 0, (byte) 0}, new byte[]{(byte) 78, (byte) 73, (byte) 65, (byte) 78, (byte) 0, (byte) 0}, new byte[]{(byte) 78, (byte) 73, (byte) 65, (byte) 78, (byte) 71, (byte) 0}, new byte[]{(byte) 78, (byte) 73, (byte) 65, (byte) 79, (byte) 0, (byte) 0}, new byte[]{(byte) 78, (byte) 73, (byte) 69, (byte) 0, (byte) 0, (byte) 0}, new byte[]{(byte) 78, (byte) 73, (byte) 78, (byte) 0, (byte) 0, (byte) 0}, new byte[]{(byte) 78, (byte) 73, (byte) 78, (byte) 71, (byte) 0, (byte) 0}, new byte[]{(byte) 78, (byte) 73, (byte) 85, (byte) 0, (byte) 0, (byte) 0}, new byte[]{(byte) 78, (byte) 79, (byte) 78, (byte) 71, (byte) 0, (byte) 0}, new byte[]{(byte) 78, (byte) 79, (byte) 85, (byte) 0, (byte) 0, (byte) 0}, new byte[]{(byte) 78, (byte) 85, (byte) 0, (byte) 0, (byte) 0, (byte) 0}, new byte[]{(byte) 78, (byte) 85, (byte) 65, (byte) 78, (byte) 0, (byte) 0}, new byte[]{(byte) 78, (byte) 85, (byte) 69, (byte) 0, (byte) 0, (byte) 0}, new byte[]{(byte) 78, (byte) 85, (byte) 79, (byte) 0, (byte) 0, (byte) 0}, new byte[]{(byte) 79, (byte) 0, (byte) 0, (byte) 0, (byte) 0, (byte) 0}, new byte[]{(byte) 79, (byte) 85, (byte) 0, (byte) 0, (byte) 0, (byte) 0}, new byte[]{(byte) 80, (byte) 65, (byte) 0, (byte) 0, (byte) 0, (byte) 0}, new byte[]{(byte) 80, (byte) 65, (byte) 73, (byte) 0, (byte) 0, (byte) 0}, new byte[]{(byte) 80, (byte) 65, (byte) 78, (byte) 0, (byte) 0, (byte) 0}, new byte[]{(byte) 80, (byte) 65, (byte) 78, (byte) 71, (byte) 0, (byte) 0}, new byte[]{(byte) 80, (byte) 65, (byte) 79, (byte) 0, (byte) 0, (byte) 0}, new byte[]{(byte) 80, (byte) 69, (byte) 73, (byte) 0, (byte) 0, (byte) 0}, new byte[]{(byte) 80, (byte) 69, (byte) 78, (byte) 0, (byte) 0, (byte) 0}, new byte[]{(byte) 80, (byte) 69, (byte) 78, (byte) 71, (byte) 0, (byte) 0}, new byte[]{(byte) 80, (byte) 73, (byte) 0, (byte) 0, (byte) 0, (byte) 0}, new byte[]{(byte) 80, (byte) 73, (byte) 65, (byte) 78, (byte) 0, (byte) 0}, new byte[]{(byte) 80, (byte) 73, (byte) 65, (byte) 79, (byte) 0, (byte) 0}, new byte[]{(byte) 80, (byte) 73, (byte) 69, (byte) 0, (byte) 0, (byte) 0}, new byte[]{(byte) 80, (byte) 73, (byte) 78, (byte) 0, (byte) 0, (byte) 0}, new byte[]{(byte) 80, (byte) 73, (byte) 78, (byte) 71, (byte) 0, (byte) 0}, new byte[]{(byte) 80, (byte) 79, (byte) 0, (byte) 0, (byte) 0, (byte) 0}, new byte[]{(byte) 80, (byte) 79, (byte) 85, (byte) 0, (byte) 0, (byte) 0}, new byte[]{(byte) 80, (byte) 85, (byte) 0, (byte) 0, (byte) 0, (byte) 0}, new byte[]{(byte) 81, (byte) 73, (byte) 0, (byte) 0, (byte) 0, (byte) 0}, new byte[]{(byte) 81, (byte) 73, (byte) 65, (byte) 0, (byte) 0, (byte) 0}, new byte[]{(byte) 81, (byte) 73, (byte) 65, (byte) 78, (byte) 0, (byte) 0}, new byte[]{(byte) 81, (byte) 73, (byte) 65, (byte) 78, (byte) 71, (byte) 0}, new byte[]{(byte) 81, (byte) 73, (byte) 65, (byte) 79, (byte) 0, (byte) 0}, new byte[]{(byte) 81, (byte) 73, (byte) 69, (byte) 0, (byte) 0, (byte) 0}, new byte[]{(byte) 81, (byte) 73, (byte) 78, (byte) 0, (byte) 0, (byte) 0}, new byte[]{(byte) 81, (byte) 73, (byte) 78, (byte) 71, (byte) 0, (byte) 0}, new byte[]{(byte) 81, (byte) 73, (byte) 79, (byte) 78, (byte) 71, (byte) 0}, new byte[]{(byte) 81, (byte) 73, (byte) 85, (byte) 0, (byte) 0, (byte) 0}, new byte[]{(byte) 81, (byte) 85, (byte) 0, (byte) 0, (byte) 0, (byte) 0}, new byte[]{(byte) 81, (byte) 85, (byte) 65, (byte) 78, (byte) 0, (byte) 0}, new byte[]{(byte) 81, (byte) 85, (byte) 69, (byte) 0, (byte) 0, (byte) 0}, new byte[]{(byte) 81, (byte) 85, (byte) 78, (byte) 0, (byte) 0, (byte) 0}, new byte[]{(byte) 82, (byte) 65, (byte) 78, (byte) 0, (byte) 0, (byte) 0}, new byte[]{(byte) 82, (byte) 65, (byte) 78, (byte) 71, (byte) 0, (byte) 0}, new byte[]{(byte) 82, (byte) 65, (byte) 79, (byte) 0, (byte) 0, (byte) 0}, new byte[]{(byte) 82, (byte) 69, (byte) 0, (byte) 0, (byte) 0, (byte) 0}, new byte[]{(byte) 82, (byte) 69, (byte) 78, (byte) 0, (byte) 0, (byte) 0}, new byte[]{(byte) 82, (byte) 69, (byte) 78, (byte) 71, (byte) 0, (byte) 0}, new byte[]{(byte) 82, (byte) 73, (byte) 0, (byte) 0, (byte) 0, (byte) 0}, new byte[]{(byte) 82, (byte) 79, (byte) 78, (byte) 71, (byte) 0, (byte) 0}, new byte[]{(byte) 82, (byte) 79, (byte) 85, (byte) 0, (byte) 0, (byte) 0}, new byte[]{(byte) 82, (byte) 85, (byte) 0, (byte) 0, (byte) 0, (byte) 0}, new byte[]{(byte) 82, (byte) 85, (byte) 65, (byte) 78, (byte) 0, (byte) 0}, new byte[]{(byte) 82, (byte) 85, (byte) 73, (byte) 0, (byte) 0, (byte) 0}, new byte[]{(byte) 82, (byte) 85, (byte) 78, (byte) 0, (byte) 0, (byte) 0}, new byte[]{(byte) 82, (byte) 85, (byte) 79, (byte) 0, (byte) 0, (byte) 0}, new byte[]{(byte) 83, (byte) 65, (byte) 0, (byte) 0, (byte) 0, (byte) 0}, new byte[]{(byte) 83, (byte) 65, (byte) 73, (byte) 0, (byte) 0, (byte) 0}, new byte[]{(byte) 83, (byte) 65, (byte) 78, (byte) 0, (byte) 0, (byte) 0}, new byte[]{(byte) 83, (byte) 65, (byte) 78, (byte) 71, (byte) 0, (byte) 0}, new byte[]{(byte) 83, (byte) 65, (byte) 79, (byte) 0, (byte) 0, (byte) 0}, new byte[]{(byte) 83, (byte) 69, (byte) 0, (byte) 0, (byte) 0, (byte) 0}, new byte[]{(byte) 83, (byte) 69, (byte) 78, (byte) 0, (byte) 0, (byte) 0}, new byte[]{(byte) 83, (byte) 69, (byte) 78, (byte) 71, (byte) 0, (byte) 0}, new byte[]{(byte) 83, (byte) 72, (byte) 65, (byte) 0, (byte) 0, (byte) 0}, new byte[]{(byte) 83, (byte) 72, (byte) 65, (byte) 73, (byte) 0, (byte) 0}, new byte[]{(byte) 83, (byte) 72, (byte) 65, (byte) 78, (byte) 0, (byte) 0}, new byte[]{(byte) 83, (byte) 72, (byte) 65, (byte) 78, (byte) 71, (byte) 0}, new byte[]{(byte) 83, (byte) 72, (byte) 65, (byte) 79, (byte) 0, (byte) 0}, new byte[]{(byte) 83, (byte) 72, (byte) 69, (byte) 0, (byte) 0, (byte) 0}, new byte[]{(byte) 83, (byte) 72, (byte) 69, (byte) 78, (byte) 0, (byte) 0}, new byte[]{(byte) 83, (byte) 72, (byte) 69, (byte) 78, (byte) 71, (byte) 0}, new byte[]{(byte) 83, (byte) 72, (byte) 73, (byte) 0, (byte) 0, (byte) 0}, new byte[]{(byte) 83, (byte) 72, (byte) 79, (byte) 85, (byte) 0, (byte) 0}, new byte[]{(byte) 83, (byte) 72, (byte) 85, (byte) 0, (byte) 0, (byte) 0}, new byte[]{(byte) 83, (byte) 72, (byte) 85, (byte) 65, (byte) 0, (byte) 0}, new byte[]{(byte) 83, (byte) 72, (byte) 85, (byte) 65, (byte) 73, (byte) 0}, new byte[]{(byte) 83, (byte) 72, (byte) 85, (byte) 65, (byte) 78, (byte) 0}, new byte[]{(byte) 83, (byte) 72, (byte) 85, (byte) 65, (byte) 78, (byte) 71}, new byte[]{(byte) 83, (byte) 72, (byte) 85, (byte) 73, (byte) 0, (byte) 0}, new byte[]{(byte) 83, (byte) 72, (byte) 85, (byte) 78, (byte) 0, (byte) 0}, new byte[]{(byte) 83, (byte) 72, (byte) 85, (byte) 79, (byte) 0, (byte) 0}, new byte[]{(byte) 83, (byte) 73, (byte) 0, (byte) 0, (byte) 0, (byte) 0}, new byte[]{(byte) 83, (byte) 79, (byte) 78, (byte) 71, (byte) 0, (byte) 0}, new byte[]{(byte) 83, (byte) 79, (byte) 85, (byte) 0, (byte) 0, (byte) 0}, new byte[]{(byte) 83, (byte) 85, (byte) 0, (byte) 0, (byte) 0, (byte) 0}, new byte[]{(byte) 83, (byte) 85, (byte) 65, (byte) 78, (byte) 0, (byte) 0}, new byte[]{(byte) 83, (byte) 85, (byte) 73, (byte) 0, (byte) 0, (byte) 0}, new byte[]{(byte) 83, (byte) 85, (byte) 78, (byte) 0, (byte) 0, (byte) 0}, new byte[]{(byte) 83, (byte) 85, (byte) 79, (byte) 0, (byte) 0, (byte) 0}, new byte[]{(byte) 84, (byte) 65, (byte) 0, (byte) 0, (byte) 0, (byte) 0}, new byte[]{(byte) 84, (byte) 65, (byte) 73, (byte) 0, (byte) 0, (byte) 0}, new byte[]{(byte) 84, (byte) 65, (byte) 78, (byte) 0, (byte) 0, (byte) 0}, new byte[]{(byte) 84, (byte) 65, (byte) 78, (byte) 71, (byte) 0, (byte) 0}, new byte[]{(byte) 84, (byte) 65, (byte) 79, (byte) 0, (byte) 0, (byte) 0}, new byte[]{(byte) 84, (byte) 69, (byte) 0, (byte) 0, (byte) 0, (byte) 0}, new byte[]{(byte) 84, (byte) 69, (byte) 78, (byte) 71, (byte) 0, (byte) 0}, new byte[]{(byte) 84, (byte) 73, (byte) 0, (byte) 0, (byte) 0, (byte) 0}, new byte[]{(byte) 84, (byte) 73, (byte) 65, (byte) 78, (byte) 0, (byte) 0}, new byte[]{(byte) 84, (byte) 73, (byte) 65, (byte) 79, (byte) 0, (byte) 0}, new byte[]{(byte) 84, (byte) 73, (byte) 69, (byte) 0, (byte) 0, (byte) 0}, new byte[]{(byte) 84, (byte) 73, (byte) 78, (byte) 71, (byte) 0, (byte) 0}, new byte[]{(byte) 84, (byte) 79, (byte) 78, (byte) 71, (byte) 0, (byte) 0}, new byte[]{(byte) 84, (byte) 79, (byte) 85, (byte) 0, (byte) 0, (byte) 0}, new byte[]{(byte) 84, (byte) 85, (byte) 0, (byte) 0, (byte) 0, (byte) 0}, new byte[]{(byte) 84, (byte) 85, (byte) 65, (byte) 78, (byte) 0, (byte) 0}, new byte[]{(byte) 84, (byte) 85, (byte) 73, (byte) 0, (byte) 0, (byte) 0}, new byte[]{(byte) 84, (byte) 85, (byte) 78, (byte) 0, (byte) 0, (byte) 0}, new byte[]{(byte) 84, (byte) 85, (byte) 79, (byte) 0, (byte) 0, (byte) 0}, new byte[]{(byte) 87, (byte) 65, (byte) 0, (byte) 0, (byte) 0, (byte) 0}, new byte[]{(byte) 87, (byte) 65, (byte) 73, (byte) 0, (byte) 0, (byte) 0}, new byte[]{(byte) 87, (byte) 65, (byte) 78, (byte) 0, (byte) 0, (byte) 0}, new byte[]{(byte) 87, (byte) 65, (byte) 78, (byte) 71, (byte) 0, (byte) 0}, new byte[]{(byte) 87, (byte) 69, (byte) 73, (byte) 0, (byte) 0, (byte) 0}, new byte[]{(byte) 87, (byte) 69, (byte) 78, (byte) 0, (byte) 0, (byte) 0}, new byte[]{(byte) 87, (byte) 69, (byte) 78, (byte) 71, (byte) 0, (byte) 0}, new byte[]{(byte) 87, (byte) 79, (byte) 0, (byte) 0, (byte) 0, (byte) 0}, new byte[]{(byte) 87, (byte) 85, (byte) 0, (byte) 0, (byte) 0, (byte) 0}, new byte[]{(byte) 88, (byte) 73, (byte) 0, (byte) 0, (byte) 0, (byte) 0}, new byte[]{(byte) 88, (byte) 73, (byte) 65, (byte) 0, (byte) 0, (byte) 0}, new byte[]{(byte) 88, (byte) 73, (byte) 65, (byte) 78, (byte) 0, (byte) 0}, new byte[]{(byte) 88, (byte) 73, (byte) 65, (byte) 78, (byte) 71, (byte) 0}, new byte[]{(byte) 88, (byte) 73, (byte) 65, (byte) 79, (byte) 0, (byte) 0}, new byte[]{(byte) 88, (byte) 73, (byte) 69, (byte) 0, (byte) 0, (byte) 0}, new byte[]{(byte) 88, (byte) 73, (byte) 78, (byte) 0, (byte) 0, (byte) 0}, new byte[]{(byte) 88, (byte) 73, (byte) 78, (byte) 71, (byte) 0, (byte) 0}, new byte[]{(byte) 88, (byte) 73, (byte) 79, (byte) 78, (byte) 71, (byte) 0}, new byte[]{(byte) 88, (byte) 73, (byte) 85, (byte) 0, (byte) 0, (byte) 0}, new byte[]{(byte) 88, (byte) 85, (byte) 0, (byte) 0, (byte) 0, (byte) 0}, new byte[]{(byte) 88, (byte) 85, (byte) 65, (byte) 78, (byte) 0, (byte) 0}, new byte[]{(byte) 88, (byte) 85, (byte) 69, (byte) 0, (byte) 0, (byte) 0}, new byte[]{(byte) 88, (byte) 85, (byte) 78, (byte) 0, (byte) 0, (byte) 0}, new byte[]{(byte) 89, (byte) 65, (byte) 0, (byte) 0, (byte) 0, (byte) 0}, new byte[]{(byte) 89, (byte) 65, (byte) 78, (byte) 0, (byte) 0, (byte) 0}, new byte[]{(byte) 89, (byte) 65, (byte) 78, (byte) 71, (byte) 0, (byte) 0}, new byte[]{(byte) 89, (byte) 65, (byte) 79, (byte) 0, (byte) 0, (byte) 0}, new byte[]{(byte) 89, (byte) 69, (byte) 0, (byte) 0, (byte) 0, (byte) 0}, new byte[]{(byte) 89, (byte) 73, (byte) 0, (byte) 0, (byte) 0, (byte) 0}, new byte[]{(byte) 89, (byte) 73, (byte) 78, (byte) 0, (byte) 0, (byte) 0}, new byte[]{(byte) 89, (byte) 73, (byte) 78, (byte) 71, (byte) 0, (byte) 0}, new byte[]{(byte) 89, (byte) 79, (byte) 0, (byte) 0, (byte) 0, (byte) 0}, new byte[]{(byte) 89, (byte) 79, (byte) 78, (byte) 71, (byte) 0, (byte) 0}, new byte[]{(byte) 89, (byte) 79, (byte) 85, (byte) 0, (byte) 0, (byte) 0}, new byte[]{(byte) 89, (byte) 85, (byte) 0, (byte) 0, (byte) 0, (byte) 0}, new byte[]{(byte) 89, (byte) 85, (byte) 65, (byte) 78, (byte) 0, (byte) 0}, new byte[]{(byte) 89, (byte) 85, (byte) 69, (byte) 0, (byte) 0, (byte) 0}, new byte[]{(byte) 89, (byte) 85, (byte) 78, (byte) 0, (byte) 0, (byte) 0}, new byte[]{(byte) 90, (byte) 65, (byte) 0, (byte) 0, (byte) 0, (byte) 0}, new byte[]{(byte) 90, (byte) 65, (byte) 73, (byte) 0, (byte) 0, (byte) 0}, new byte[]{(byte) 90, (byte) 65, (byte) 78, (byte) 0, (byte) 0, (byte) 0}, new byte[]{(byte) 90, (byte) 65, (byte) 78, (byte) 71, (byte) 0, (byte) 0}, new byte[]{(byte) 90, (byte) 65, (byte) 79, (byte) 0, (byte) 0, (byte) 0}, new byte[]{(byte) 90, (byte) 69, (byte) 0, (byte) 0, (byte) 0, (byte) 0}, new byte[]{(byte) 90, (byte) 69, (byte) 73, (byte) 0, (byte) 0, (byte) 0}, new byte[]{(byte) 90, (byte) 69, (byte) 78, (byte) 0, (byte) 0, (byte) 0}, new byte[]{(byte) 90, (byte) 69, (byte) 78, (byte) 71, (byte) 0, (byte) 0}, new byte[]{(byte) 90, (byte) 72, (byte) 65, (byte) 0, (byte) 0, (byte) 0}, new byte[]{(byte) 90, (byte) 72, (byte) 65, (byte) 73, (byte) 0, (byte) 0}, new byte[]{(byte) 90, (byte) 72, (byte) 65, (byte) 78, (byte) 0, (byte) 0}, new byte[]{(byte) 90, (byte) 72, (byte) 65, (byte) 78, (byte) 71, (byte) 0}, new byte[]{(byte) 90, (byte) 72, (byte) 65, (byte) 79, (byte) 0, (byte) 0}, new byte[]{(byte) 90, (byte) 72, (byte) 69, (byte) 0, (byte) 0, (byte) 0}, new byte[]{(byte) 90, (byte) 72, (byte) 69, (byte) 78, (byte) 0, (byte) 0}, new byte[]{(byte) 90, (byte) 72, (byte) 69, (byte) 78, (byte) 71, (byte) 0}, new byte[]{(byte) 90, (byte) 72, (byte) 73, (byte) 0, (byte) 0, (byte) 0}, new byte[]{(byte) 90, (byte) 72, (byte) 79, (byte) 78, (byte) 71, (byte) 0}, new byte[]{(byte) 90, (byte) 72, (byte) 79, (byte) 85, (byte) 0, (byte) 0}, new byte[]{(byte) 90, (byte) 72, (byte) 85, (byte) 0, (byte) 0, (byte) 0}, new byte[]{(byte) 90, (byte) 72, (byte) 85, (byte) 65, (byte) 0, (byte) 0}, new byte[]{(byte) 90, (byte) 72, (byte) 85, (byte) 65, (byte) 73, (byte) 0}, new byte[]{(byte) 90, (byte) 72, (byte) 85, (byte) 65, (byte) 78, (byte) 0}, new byte[]{(byte) 90, (byte) 72, (byte) 85, (byte) 65, (byte) 78, (byte) 71}, new byte[]{(byte) 90, (byte) 72, (byte) 85, (byte) 73, (byte) 0, (byte) 0}, new byte[]{(byte) 90, (byte) 72, (byte) 85, (byte) 78, (byte) 0, (byte) 0}, new byte[]{(byte) 90, (byte) 72, (byte) 85, (byte) 79, (byte) 0, (byte) 0}, new byte[]{(byte) 90, (byte) 73, (byte) 0, (byte) 0, (byte) 0, (byte) 0}, new byte[]{(byte) 90, (byte) 79, (byte) 78, (byte) 71, (byte) 0, (byte) 0}, new byte[]{(byte) 90, (byte) 79, (byte) 85, (byte) 0, (byte) 0, (byte) 0}, new byte[]{(byte) 90, (byte) 85, (byte) 0, (byte) 0, (byte) 0, (byte) 0}, new byte[]{(byte) 90, (byte) 85, (byte) 65, (byte) 78, (byte) 0, (byte) 0}, new byte[]{(byte) 90, (byte) 85, (byte) 73, (byte) 0, (byte) 0, (byte) 0}, new byte[]{(byte) 90, (byte) 85, (byte) 78, (byte) 0, (byte) 0, (byte) 0}, new byte[]{(byte) 90, (byte) 85, (byte) 79, (byte) 0, (byte) 0, (byte) 0}};
        f1531c = new HashMap();
        f1532d = new HashMap();
        f1533e = new HashMap();
        f1534f = Collator.getInstance(Locale.CHINA);
        f1531c.put(Character.valueOf('\u963f'), new String[]{"A", "E"});
        f1531c.put(Character.valueOf('\u814c'), new String[]{"YAN", "A"});
        f1531c.put(Character.valueOf('\u62d7'), new String[]{"AO", "O", "NIU"});
        f1531c.put(Character.valueOf('\u6252'), new String[]{"PA", "BA"});
        f1531c.put(Character.valueOf('\u868c'), new String[]{"BANG", "BENG"});
        f1531c.put(Character.valueOf('\u8584'), new String[]{"BAO", "BO"});
        f1531c.put(Character.valueOf('\u5821'), new String[]{"BAO", "BU", "PU"});
        f1531c.put(Character.valueOf('\u66b4'), new String[]{"BAO", "PU"});
        f1531c.put(Character.valueOf('\u8d32'), new String[]{"BEN", "FEI", "BI"});
        f1531c.put(Character.valueOf('\u8d39'), new String[]{"FEI", "BI"});
        f1531c.put(Character.valueOf('\u81c2'), new String[]{"BI", "BEI"});
        f1531c.put(Character.valueOf('\u8f9f'), new String[]{"PI", "BI"});
        f1531c.put(Character.valueOf('\u8300'), new String[]{"FU", "BI"});
        f1531c.put(Character.valueOf('\u6241'), new String[]{"BIAN", "PIAN"});
        f1531c.put(Character.valueOf('\u4fbf'), new String[]{"BIAN", "PIAN"});
        f1531c.put(Character.valueOf('\u8180'), new String[]{"PANG", "BANG"});
        f1531c.put(Character.valueOf('\u78c5'), new String[]{"PANG", "BANG"});
        f1531c.put(Character.valueOf('\u9aa0'), new String[]{"BIAO", "PIAO"});
        f1531c.put(Character.valueOf('\u756a'), new String[]{"FAN", "PAN", "BO"});
        f1531c.put(Character.valueOf('\u5b5b'), new String[]{"BEI", "BO"});
        f1531c.put(Character.valueOf('\u5e9f'), new String[]{"FEI", "BO"});
        f1531c.put(Character.valueOf('\u5265'), new String[]{"BO", "BAO", "XUE"});
        f1531c.put(Character.valueOf('\u6cca'), new String[]{"BO", "PO", "BAN"});
        f1531c.put(Character.valueOf('\u4f2f'), new String[]{"BO", "BAI"});
        f1531c.put(Character.valueOf('\u535c'), new String[]{"BO", "BU"});
        f1531c.put(Character.valueOf('\u4f27'), new String[]{"CANG", "CHEN"});
        f1531c.put(Character.valueOf('\u85cf'), new String[]{"CANG", "ZANG"});
        f1531c.put(Character.valueOf('\u53c2'), new String[]{"CAN", "SHEN", "CEN"});
        f1531c.put(Character.valueOf('\u66fe'), new String[]{"CENG", "ZENG"});
        f1531c.put(Character.valueOf('\u564c'), new String[]{"CENG", "CHENG"});
        f1531c.put(Character.valueOf('\u5dee'), new String[]{"CHA", "CHAI"});
        f1531c.put(Character.valueOf('\u67e5'), new String[]{"CHA", "ZHA"});
        f1531c.put(Character.valueOf('\u7985'), new String[]{"CHAN", "SHAN"});
        f1531c.put(Character.valueOf('\u98a4'), new String[]{"CHAN", "ZHAN"});
        f1531c.put(Character.valueOf('\u5b71'), new String[]{"CHAN", "CAN"});
        f1531c.put(Character.valueOf('\u88f3'), new String[]{"SHANG", "CHANG"});
        f1531c.put(Character.valueOf('\u573a'), new String[]{"CHANG", "CHANG"});
        f1531c.put(Character.valueOf('\u6668'), new String[]{"CHEN", "CHANG", "ZE"});
        f1531c.put(Character.valueOf('\u957f'), new String[]{"CHANG", "ZHANG"});
        f1531c.put(Character.valueOf('\u5382'), new String[]{"CHANG", "AN", "HAN"});
        f1531c.put(Character.valueOf('\u5632'), new String[]{"CHAO", "ZHAO", "ZHA"});
        f1531c.put(Character.valueOf('\u8f66'), new String[]{"CHE", "JU"});
        f1531c.put(Character.valueOf('\u79f0'), new String[]{"CHENG", "CHEN"});
        f1531c.put(Character.valueOf('\u6f84'), new String[]{"CHENG", "DENG"});
        f1531c.put(Character.valueOf('\u94db'), new String[]{"DANG", "CHENG"});
        f1531c.put(Character.valueOf('\u4e58'), new String[]{"CHENG", "SHENG"});
        f1531c.put(Character.valueOf('\u671d'), new String[]{"CHAO", "ZHAO"});
        f1531c.put(Character.valueOf('\u9561'), new String[]{"XIN", "CHAN", "TAN"});
        f1531c.put(Character.valueOf('\u5319'), new String[]{"SHI", "CHI"});
        f1531c.put(Character.valueOf('\u90d7'), new String[]{"XI", "CHI"});
        f1531c.put(Character.valueOf('\u6cbb'), new String[]{"ZHI", "CHI"});
        f1531c.put(Character.valueOf('\u7633'), new String[]{"CHOU", "LU"});
        f1531c.put(Character.valueOf('\u4e11'), new String[]{"CHOU", "NIU"});
        f1531c.put(Character.valueOf('\u81ed'), new String[]{"CHOU", "XIU"});
        f1531c.put(Character.valueOf('\u91cd'), new String[]{"ZHONG", "CHONG"});
        f1531c.put(Character.valueOf('\u79cd'), new String[]{"ZHONG", "CHONG"});
        f1531c.put(Character.valueOf('\u755c'), new String[]{"CHU", "XU"});
        f1531c.put(Character.valueOf('\u9664'), new String[]{"CHU", "XU"});
        f1531c.put(Character.valueOf('\u4f20'), new String[]{"CHUAN", "ZHUAN"});
        f1531c.put(Character.valueOf('\u555c'), new String[]{"CHUO", "CHUAI"});
        f1531c.put(Character.valueOf('\u7ef0'), new String[]{"CHUO", "CHAO"});
        f1531c.put(Character.valueOf('\u891a'), new String[]{"ZHU", "CHU", "ZHE"});
        f1531c.put(Character.valueOf('\u690e'), new String[]{"ZHUI", "CHUI"});
        f1531c.put(Character.valueOf('\u6b21'), new String[]{"CI", "CHI", "QI"});
        f1531c.put(Character.valueOf('\u4f3a'), new String[]{"CI", "SI"});
        f1531c.put(Character.valueOf('\u5179'), new String[]{"ZI", "CI"});
        f1531c.put(Character.valueOf('\u679e'), new String[]{"CONG", "ZONG"});
        f1531c.put(Character.valueOf('\u6512'), new String[]{"CUAN", "ZAN"});
        f1531c.put(Character.valueOf('\u5352'), new String[]{"ZU", "CU"});
        f1531c.put(Character.valueOf('\u8870'), new String[]{"SHUAI", "CUI"});
        f1531c.put(Character.valueOf('\u64ae'), new String[]{"CUO", "ZUO"});
        f1531c.put(Character.valueOf('\u5927'), new String[]{"DA", "DAI"});
        f1531c.put(Character.valueOf('\u6c93'), new String[]{"TA", "DA"});
        f1531c.put(Character.valueOf('\u5355'), new String[]{"DAN", "CHAN", "SHAN"});
        f1531c.put(Character.valueOf('\u53e8'), new String[]{"DAO", "TAO"});
        f1531c.put(Character.valueOf('\u63d0'), new String[]{"TI", "DI"});
        f1531c.put(Character.valueOf('\u9046'), new String[]{"DI", "TI"});
        f1531c.put(Character.valueOf('\u7fdf'), new String[]{"DI", "ZHAI"});
        f1531c.put(Character.valueOf('\u5f97'), new String[]{"DE", "DEI"});
        f1531c.put(Character.valueOf('\u94bf'), new String[]{"DIAN", "TIAN"});
        f1531c.put(Character.valueOf('\u4f43'), new String[]{"DIAN", "TIAN"});
        f1531c.put(Character.valueOf('\u5200'), new String[]{"DAO", "DIAO"});
        f1531c.put(Character.valueOf('\u8c03'), new String[]{"DIAO", "TIAO"});
        f1531c.put(Character.valueOf('\u90fd'), new String[]{"DOU", "DU"});
        f1531c.put(Character.valueOf('\u5ea6'), new String[]{"DU", "DUO"});
        f1531c.put(Character.valueOf('\u56e4'), new String[]{"TUN", "DUN"});
        f1531c.put(Character.valueOf('\u5426'), new String[]{"FOU", "PI"});
        f1531c.put(Character.valueOf('\u812f'), new String[]{"PU", "FU"});
        f1531c.put(Character.valueOf('\u8f67'), new String[]{"YA", "ZHA", "GA"});
        f1531c.put(Character.valueOf('\u625b'), new String[]{"KANG", "GANG"});
        f1531c.put(Character.valueOf('\u76d6'), new String[]{"GAI", "GE"});
        f1531c.put(Character.valueOf('\u54af'), new String[]{"GE", "KA", "LO"});
        f1531c.put(Character.valueOf('\u9769'), new String[]{"GE", "JI"});
        f1531c.put(Character.valueOf('\u5408'), new String[]{"HE", "GE"});
        f1531c.put(Character.valueOf('\u7ed9'), new String[]{"GEI", "JI"});
        f1531c.put(Character.valueOf('\u9888'), new String[]{"JING", "GENG"});
        f1531c.put(Character.valueOf('\u7ea2'), new String[]{"HONG", "GONG"});
        f1531c.put(Character.valueOf('\u67b8'), new String[]{"GOU", "JU"});
        f1531c.put(Character.valueOf('\u5471'), new String[]{"GUA", "GU"});
        f1531c.put(Character.valueOf('\u8c37'), new String[]{"GU", "YU"});
        f1531c.put(Character.valueOf('\u866b'), new String[]{"CHONG", "GU"});
        f1531c.put(Character.valueOf('\u9e44'), new String[]{"HU", "GU"});
        f1531c.put(Character.valueOf('\u62ec'), new String[]{"KUO", "GUA"});
        f1531c.put(Character.valueOf('\u839e'), new String[]{"GUAN", "WAN"});
        f1531c.put(Character.valueOf('\u7eb6'), new String[]{"LUN", "GUAN"});
        f1531c.put(Character.valueOf('\u7085'), new String[]{"JIONG", "GUI"});
        f1531c.put(Character.valueOf('\u6867'), new String[]{"GUI", "HUI"});
        f1531c.put(Character.valueOf('\u7094'), new String[]{"QUE", "GUI"});
        f1531c.put(Character.valueOf('\u660b'), new String[]{"GUI", "JIONG"});
        f1531c.put(Character.valueOf('\u4f1a'), new String[]{"HUI", "KUAI", "GUI"});
        f1531c.put(Character.valueOf('\u82a5'), new String[]{"JIE", "GAI"});
        f1531c.put(Character.valueOf('\u867e'), new String[]{"XIA", "HA"});
        f1531c.put(Character.valueOf('\u8f69'), new String[]{"XUAN", "HAN"});
        f1531c.put(Character.valueOf('\u6496'), new String[]{"KAN", "HAN"});
        f1531c.put(Character.valueOf('\u54b3'), new String[]{"KE", "HAI"});
        f1531c.put(Character.valueOf('\u5df7'), new String[]{"XIANG", "HANG"});
        f1531c.put(Character.valueOf('\u542d'), new String[]{"KENG", "HANG"});
        f1531c.put(Character.valueOf('\u9ed8'), new String[]{"MO", "HE", "MEI"});
        f1531c.put(Character.valueOf('\u548c'), new String[]{"HE", "HU", "HUO"});
        f1531c.put(Character.valueOf('\u8c89'), new String[]{"HE", "HAO"});
        f1531c.put(Character.valueOf('\u9ed1'), new String[]{"HEI", "HE"});
        f1531c.put(Character.valueOf('\u8679'), new String[]{"HONG", "JIANG"});
        f1531c.put(Character.valueOf('\u90c7'), new String[]{"XUN", "HUAN"});
        f1531c.put(Character.valueOf('\u5bf0'), new String[]{"HUAN", "XIAN"});
        f1531c.put(Character.valueOf('\u5947'), new String[]{"QI", "JI"});
        f1531c.put(Character.valueOf('\u7f09'), new String[]{"JI", "QI"});
        f1531c.put(Character.valueOf('\u5048'), new String[]{"JIE", "JI"});
        f1531c.put(Character.valueOf('\u7cfb'), new String[]{"XI", "JI"});
        f1531c.put(Character.valueOf('\u7a3d'), new String[]{"JI", "QI"});
        f1531c.put(Character.valueOf('\u4e9f'), new String[]{"JI", "QI"});
        f1531c.put(Character.valueOf('\u8bd8'), new String[]{"JIE", "JI"});
        f1531c.put(Character.valueOf('\u8bb0'), new String[]{"JI", "JIE"});
        f1531c.put(Character.valueOf('\u5267'), new String[]{"JU", "JI"});
        f1531c.put(Character.valueOf('\u796d'), new String[]{"JI", "ZHA", "ZHAI"});
        f1531c.put(Character.valueOf('\u8304'), new String[]{"QIE", "JIA"});
        f1531c.put(Character.valueOf('\u56bc'), new String[]{"JIAO", "JUE"});
        f1531c.put(Character.valueOf('\u4fa5'), new String[]{"JIAO", "YAO"});
        f1531c.put(Character.valueOf('\u89d2'), new String[]{"JIAO", "JUE"});
        f1531c.put(Character.valueOf('\u811a'), new String[]{"JIAO", "JUE"});
        f1531c.put(Character.valueOf('\u527f'), new String[]{"JIAO", "CHAO"});
        f1531c.put(Character.valueOf('\u6821'), new String[]{"XIAO", "JIAO"});
        f1531c.put(Character.valueOf('\u7f34'), new String[]{"JIAO", "ZHUO"});
        f1531c.put(Character.valueOf('\u89c1'), new String[]{"JIAN", "XIAN"});
        f1531c.put(Character.valueOf('\u964d'), new String[]{"XIANG", "LONG", "JIANG"});
        f1531c.put(Character.valueOf('\u89e3'), new String[]{"JIE", "XIE"});
        f1531c.put(Character.valueOf('\u85c9'), new String[]{"JIE", "JI"});
        f1531c.put(Character.valueOf('\u77dc'), new String[]{"JIN", "QIN"});
        f1531c.put(Character.valueOf('\u52b2'), new String[]{"JIN", "JING"});
        f1531c.put(Character.valueOf('\u9f9f'), new String[]{"GUI", "QIU", "CI", "JUN"});
        f1531c.put(Character.valueOf('\u5480'), new String[]{"JU", "ZUI"});
        f1531c.put(Character.valueOf('\u741a'), new String[]{"JU", "QU"});
        f1531c.put(Character.valueOf('\u83cc'), new String[]{"JUN", "XUN"});
        f1531c.put(Character.valueOf('\u96bd'), new String[]{"JUN", "JUAN"});
        f1531c.put(Character.valueOf('\u5361'), new String[]{"KA", "QIA"});
        f1531c.put(Character.valueOf('\u770b'), new String[]{"KAN", "KAN"});
        f1531c.put(Character.valueOf('\u61a8'), new String[]{"HAN", "KAN"});
        f1531c.put(Character.valueOf('\u5777'), new String[]{"KE", "KE"});
        f1531c.put(Character.valueOf('\u58f3'), new String[]{"KE", "QIA"});
        f1531c.put(Character.valueOf('\u514b'), new String[]{"KE", "KEI"});
        f1531c.put(Character.valueOf('\u9760'), new String[]{"KAO", "KU"});
        f1531c.put(Character.valueOf('\u9697'), new String[]{"WEI", "KUI"});
        f1531c.put(Character.valueOf('\u9b3c'), new String[]{"GUI", "WEI", "KUI"});
        f1531c.put(Character.valueOf('\u8312'), new String[]{"KUANG", "GUAN", "YUAN"});
        f1531c.put(Character.valueOf('\u5587'), new String[]{"LA", "YAO"});
        f1531c.put(Character.valueOf('\u84dd'), new String[]{"LAN", "PIE"});
        f1531c.put(Character.valueOf('\u70d9'), new String[]{"LAO", "LUO", "PAO"});
        f1531c.put(Character.valueOf('\u96d2'), new String[]{"LUO", "LAO"});
        f1531c.put(Character.valueOf('\u808b'), new String[]{"LE", "LEI"});
        f1531c.put(Character.valueOf('\u4e50'), new String[]{"LE", "YUE"});
        f1531c.put(Character.valueOf('\u4e86'), new String[]{"LE", "LIAO"});
        f1531c.put(Character.valueOf('\u4fe9'), new String[]{"LIANG", "LIA"});
        f1531c.put(Character.valueOf('\u6f66'), new String[]{"LIAO", "LAO"});
        f1531c.put(Character.valueOf('\u788c'), new String[]{"LU", "ZHOU", "LIU"});
        f1531c.put(Character.valueOf('\u507b'), new String[]{"LOU", "LU"});
        f1531c.put(Character.valueOf('\u9732'), new String[]{"LU", "LOU"});
        f1531c.put(Character.valueOf('\u634b'), new String[]{"LU", "LUO"});
        f1531c.put(Character.valueOf('\u7eff'), new String[]{"LV", "LU"});
        f1531c.put(Character.valueOf('\u516d'), new String[]{"LIU", "LU"});
        f1531c.put(Character.valueOf('\u7edc'), new String[]{"LUO", "LAO"});
        f1531c.put(Character.valueOf('\u843d'), new String[]{"LUO", "LAO", "LA"});
        f1531c.put(Character.valueOf('\u62b9'), new String[]{"MA", "MO"});
        f1531c.put(Character.valueOf('\u8109'), new String[]{"MAI", "MO"});
        f1531c.put(Character.valueOf('\u57cb'), new String[]{"MAI", "MAN"});
        f1531c.put(Character.valueOf('\u8513'), new String[]{"MAN", "WAN"});
        f1531c.put(Character.valueOf('\u6c13'), new String[]{"MANG", "MENG"});
        f1531c.put(Character.valueOf('\u6ca1'), new String[]{"MEI", "MO"});
        f1531c.put(Character.valueOf('\u79d8'), new String[]{"MI", "BI"});
        f1531c.put(Character.valueOf('\u6ccc'), new String[]{"MI", "BI"});
        f1531c.put(Character.valueOf('\u4f74'), new String[]{"MI", "NAI", "NI"});
        f1531c.put(Character.valueOf('\u8c2c'), new String[]{"MIAO", "MIU"});
        f1531c.put(Character.valueOf('\u6a21'), new String[]{"MO", "MU"});
        f1531c.put(Character.valueOf('\u6469'), new String[]{"MO", "MA", "SA"});
        f1531c.put(Character.valueOf('\u6bcd'), new String[]{"MU", "WU"});
        f1531c.put(Character.valueOf('\u7f2a'), new String[]{"MIU", "MIAO", "MOU"});
        f1531c.put(Character.valueOf('\u5f04'), new String[]{"NONG", "LONG"});
        f1531c.put(Character.valueOf('\u96be'), new String[]{"NAN", "NING"});
        f1531c.put(Character.valueOf('\u759f'), new String[]{"NUE", "YAO"});
        f1531c.put(Character.valueOf('\u4e5c'), new String[]{"MIE", "NIE"});
        f1531c.put(Character.valueOf('\u5a1c'), new String[]{"NA", "NUO"});
        f1531c.put(Character.valueOf('\u533a'), new String[]{"QU", "OU"});
        f1531c.put(Character.valueOf('\u7e41'), new String[]{"FAN", "PO"});
        f1531c.put(Character.valueOf('\u8feb'), new String[]{"PO", "PAI"});
        f1531c.put(Character.valueOf('\u80d6'), new String[]{"PANG", "PAN"});
        f1531c.put(Character.valueOf('\u5228'), new String[]{"PAO", "BAO"});
        f1531c.put(Character.valueOf('\u70ae'), new String[]{"PAO", "BAO"});
        f1531c.put(Character.valueOf('\u9022'), new String[]{"FENG", "PANG"});
        f1531c.put(Character.valueOf('\u84ec'), new String[]{"PENG", "PANG"});
        f1531c.put(Character.valueOf('\u6734'), new String[]{"PU", "PO", "PIAO"});
        f1531c.put(Character.valueOf('\u7011'), new String[]{"PU", "BAO"});
        f1531c.put(Character.valueOf('\u66dd'), new String[]{"BAO", "PU"});
        f1531c.put(Character.valueOf('\u6816'), new String[]{"XI", "QI"});
        f1531c.put(Character.valueOf('\u8e4a'), new String[]{"XI", "QI"});
        f1531c.put(Character.valueOf('\u7a3d'), new String[]{"JI", "QI"});
        f1531c.put(Character.valueOf('\u8368'), new String[]{"XUN", "QIAN"});
        f1531c.put(Character.valueOf('\u79a4'), new String[]{"QIAN", "XUAN"});
        f1531c.put(Character.valueOf('\u5f3a'), new String[]{"QIANG", "JIANG"});
        f1531c.put(Character.valueOf('\u8d84'), new String[]{"QIE", "JU"});
        f1531c.put(Character.valueOf('\u4eb2'), new String[]{"QIN", "QING"});
        f1531c.put(Character.valueOf('\u96c0'), new String[]{"QUE", "QIAO"});
        f1531c.put(Character.valueOf('\u4ec7'), new String[]{"CHOU", "QIU"});
        f1531c.put(Character.valueOf('\u5708'), new String[]{"QUAN", "JUAN"});
        f1531c.put(Character.valueOf('\u8272'), new String[]{"SE", "SHAI"});
        f1531c.put(Character.valueOf('\u585e'), new String[]{"SAI", "SE"});
        f1531c.put(Character.valueOf('\u53a6'), new String[]{"XIA", "SHA"});
        f1531c.put(Character.valueOf('\u53ec'), new String[]{"ZHAO", "SHAO"});
        f1531c.put(Character.valueOf('\u6749'), new String[]{"SHAN", "SHA"});
        f1531c.put(Character.valueOf('\u6c64'), new String[]{"TANG", "SHANG"});
        f1531c.put(Character.valueOf('\u62fe'), new String[]{"SHI", "SHE"});
        f1531c.put(Character.valueOf('\u6298'), new String[]{"ZHE", "SHE"});
        f1531c.put(Character.valueOf('\u4ec0'), new String[]{"SHEN", "SHI"});
        f1531c.put(Character.valueOf('\u845a'), new String[]{"SHEN", "REN"});
        f1531c.put(Character.valueOf('\u8bc6'), new String[]{"SHI", "ZHI"});
        f1531c.put(Character.valueOf('\u4f3c'), new String[]{"SI", "SHI"});
        f1531c.put(Character.valueOf('\u5c5e'), new String[]{"SHU", "ZHU"});
        f1531c.put(Character.valueOf('\u719f'), new String[]{"SHU", "SHOU"});
        f1531c.put(Character.valueOf('\u8bf4'), new String[]{"SHUO", "SHUI"});
        f1531c.put(Character.valueOf('\u6570'), new String[]{"SHU", "SHUO"});
        f1531c.put(Character.valueOf('\u5fea'), new String[]{"SONG", "ZHONG"});
        f1531c.put(Character.valueOf('\u5bbf'), new String[]{"SU", "XIU"});
        f1531c.put(Character.valueOf('\u772d'), new String[]{"GUI", "XU", "SUI"});
        f1531c.put(Character.valueOf('\u6fb9'), new String[]{"DAN", "TAN"});
        f1531c.put(Character.valueOf('\u6c93'), new String[]{"TA", "DA"});
        f1531c.put(Character.valueOf('\u8983'), new String[]{"TAN", "QIN"});
        f1531c.put(Character.valueOf('\u8c03'), new String[]{"DIAO", "TIAO"});
        f1531c.put(Character.valueOf('\u892a'), new String[]{"TUI", "TUN"});
        f1531c.put(Character.valueOf('\u62d3'), new String[]{"TUO", "TA"});
        f1531c.put(Character.valueOf('\u5729'), new String[]{"WEI", "XU"});
        f1531c.put(Character.valueOf('\u59d4'), new String[]{"WEI", "QU"});
        f1531c.put(Character.valueOf('\u5c3e'), new String[]{"WEI", "YI"});
        f1531c.put(Character.valueOf('\u5c09'), new String[]{"WEI", "YU"});
        f1531c.put(Character.valueOf('\u9057'), new String[]{"YI", "WEI"});
        f1531c.put(Character.valueOf('\u4e4c'), new String[]{"WU", "LA"});
        f1531c.put(Character.valueOf('\u5413'), new String[]{"XIA", "HE"});
        f1531c.put(Character.valueOf('\u7ea4'), new String[]{"XIAN", "QIAN"});
        f1531c.put(Character.valueOf('\u884c'), new String[]{"XING", "HANG", "HENG"});
        f1531c.put(Character.valueOf('\u7701'), new String[]{"SHENG", "XING"});
        f1531c.put(Character.valueOf('\u524a'), new String[]{"XIAO", "XUE"});
        f1531c.put(Character.valueOf('\u8840'), new String[]{"XUE", "XIE"});
        f1531c.put(Character.valueOf('\u6bb7'), new String[]{"YIN", "YAN"});
        f1531c.put(Character.valueOf('\u54bd'), new String[]{"YAN", "YE"});
        f1531c.put(Character.valueOf('\u7ea6'), new String[]{"YUE", "YAO"});
        f1531c.put(Character.valueOf('\u94a5'), new String[]{"YAO", "YUE"});
        f1531c.put(Character.valueOf('\u53f6'), new String[]{"YE", "XIE"});
        f1531c.put(Character.valueOf('\u827e'), new String[]{"AI", "YI"});
        f1531c.put(Character.valueOf('\u71a8'), new String[]{"YUN", "YU"});
        f1531c.put(Character.valueOf('\u5401'), new String[]{"YU", "XU"});
        f1531c.put(Character.valueOf('\u5458'), new String[]{"YUAN", "YUN"});
        f1531c.put(Character.valueOf('\u8d20'), new String[]{"YUAN", "YUN"});
        f1531c.put(Character.valueOf('\u548b'), new String[]{"ZA", "ZE", "ZHA"});
        f1531c.put(Character.valueOf('\u62e9'), new String[]{"ZE", "ZHAI"});
        f1531c.put(Character.valueOf('\u624e'), new String[]{"ZHA", "ZA"});
        f1531c.put(Character.valueOf('\u8f67'), new String[]{"YA", "ZHA"});
        f1531c.put(Character.valueOf('\u7c98'), new String[]{"NIAN", "ZHAN"});
        f1531c.put(Character.valueOf('\u722a'), new String[]{"ZHUA", "ZHAO"});
        f1531c.put(Character.valueOf('\u7740'), new String[]{"ZHAO", "ZHUO"});
        f1531c.put(Character.valueOf('\u6b96'), new String[]{"ZHI", "SHI"});
        f1531c.put(Character.valueOf('\u8457'), new String[]{"ZHU", "ZHE", "ZHUO"});
        f1531c.put(Character.valueOf('\u5e62'), new String[]{"ZHUANG", "CHUANG"});
        f1531c.put(Character.valueOf('\u7efc'), new String[]{"ZONG", "ZENG"});
        f1531c.put(Character.valueOf('\u67de'), new String[]{"ZUO", "ZHA"});
        f1531c.put(Character.valueOf('\u4ed4'), new String[]{"ZI", "ZAI"});
        f1531c.put(Character.valueOf('\u4fde'), new String[]{"YU", "SHU"});
        f1531c.put(Character.valueOf('\u5185'), new String[]{"NEI"});
        f1531c.put(Character.valueOf('\u77bf'), new String[]{"QU"});
        f1531c.put(Character.valueOf('\u6765'), new String[]{"LAI"});
        f1531c.put(Character.valueOf('\u53c9'), new String[]{"CHA"});
        f1531c.put(Character.valueOf('\u5979'), new String[]{"TA"});
        f1531c.put(Character.valueOf('\u513f'), new String[]{"ER"});
        f1531c.put(Character.valueOf('\u6c88'), new String[]{"SHEN"});
        f1531c.put(Character.valueOf('\u8d3e'), new String[]{"JIA"});
        f1531c.put(Character.valueOf('\u6234'), new String[]{"DAI"});
        f1532d.put("\u5355\u4e8e", new String[]{"CHAN", "YU"});
        f1532d.put("\u957f\u5b59", new String[]{"ZHANG", "SUN"});
        f1532d.put("\u5b50\u8f66", new String[]{"ZI", "JU"});
        f1532d.put("\u4e07\u4fdf", new String[]{"MO", "QI"});
        f1532d.put("\u6fb9\u53f0", new String[]{"TAN", "TAI"});
        f1532d.put("\u5c09\u8fdf", new String[]{"YU", "CHI"});
        f1533e.put(Character.valueOf('\u4fde'), "YU");
        f1533e.put(Character.valueOf('\u8d3e'), "JIA");
        f1533e.put(Character.valueOf('\u6c88'), "SHEN");
        f1533e.put(Character.valueOf('\u535c'), "BU");
        f1533e.put(Character.valueOf('\u8584'), "BO");
        f1533e.put(Character.valueOf('\u5b5b'), "BO");
        f1533e.put(Character.valueOf('\u8d32'), "BEN");
        f1533e.put(Character.valueOf('\u8d39'), "FEI");
        f1533e.put(Character.valueOf('\u6cca'), "BAN");
        f1533e.put(Character.valueOf('\u8300'), "BI");
        f1533e.put(Character.valueOf('\u5e9f'), "BO");
        f1533e.put(Character.valueOf('\u756a'), "BO");
        f1533e.put(Character.valueOf('\u891a'), "CHU");
        f1533e.put(Character.valueOf('\u91cd'), "CHONG");
        f1533e.put(Character.valueOf('\u5382'), "HAN");
        f1533e.put(Character.valueOf('\u4f20'), "CHUAN");
        f1533e.put(Character.valueOf('\u53c2'), "CAN");
        f1533e.put(Character.valueOf('\u79cd'), "CHONG");
        f1533e.put(Character.valueOf('\u90d7'), "CHI");
        f1533e.put(Character.valueOf('\u9561'), "CHAN");
        f1533e.put(Character.valueOf('\u671d'), "CHAO");
        f1533e.put(Character.valueOf('\u6cbb'), "CHI");
        f1533e.put(Character.valueOf('\u555c'), "CHUAI");
        f1533e.put(Character.valueOf('\u8870'), "CUI");
        f1533e.put(Character.valueOf('\u6668'), "CHANG");
        f1533e.put(Character.valueOf('\u4e11'), "CHOU");
        f1533e.put(Character.valueOf('\u7633'), "CHOU");
        f1533e.put(Character.valueOf('\u957f'), "CHANG");
        f1533e.put(Character.valueOf('\u6b21'), "QI");
        f1533e.put(Character.valueOf('\u8f66'), "CHE");
        f1533e.put(Character.valueOf('\u7fdf'), "ZHAI");
        f1533e.put(Character.valueOf('\u4f43'), "DIAN");
        f1533e.put(Character.valueOf('\u5200'), "DIAO");
        f1533e.put(Character.valueOf('\u8c03'), "DIAO");
        f1533e.put(Character.valueOf('\u9046'), "DI");
        f1533e.put(Character.valueOf('\u76d6'), "GE");
        f1533e.put(Character.valueOf('\u7085'), "GUI");
        f1533e.put(Character.valueOf('\u866b'), "GU");
        f1533e.put(Character.valueOf('\u7094'), "GUI");
        f1533e.put(Character.valueOf('\u660b'), "GUI");
        f1533e.put(Character.valueOf('\u4f1a'), "GUI");
        f1533e.put(Character.valueOf('\u82a5'), "GAI");
        f1533e.put(Character.valueOf('\u8312'), "KUANG");
        f1533e.put(Character.valueOf('\u90c7'), "HUAN");
        f1533e.put(Character.valueOf('\u5df7'), "XIANG");
        f1533e.put(Character.valueOf('\u9ed1'), "HE");
        f1533e.put(Character.valueOf('\u8f69'), "HAN");
        f1533e.put(Character.valueOf('\u6496'), "HAN");
        f1533e.put(Character.valueOf('\u9ed8'), "HE");
        f1533e.put(Character.valueOf('\u89c1'), "JIAN");
        f1533e.put(Character.valueOf('\u964d'), "JIANG");
        f1533e.put(Character.valueOf('\u89d2'), "JIAO");
        f1533e.put(Character.valueOf('\u7f34'), "JIAO");
        f1533e.put(Character.valueOf('\u8bb0'), "JI");
        f1533e.put(Character.valueOf('\u741a'), "JU");
        f1533e.put(Character.valueOf('\u5267'), "JI");
        f1533e.put(Character.valueOf('\u96bd'), "JUAN");
        f1533e.put(Character.valueOf('\u9697'), "KUI");
        f1533e.put(Character.valueOf('\u9b3c'), "KUI");
        f1533e.put(Character.valueOf('\u61a8'), "KAN");
        f1533e.put(Character.valueOf('\u9760'), "KU");
        f1533e.put(Character.valueOf('\u4e50'), "YUE");
        f1533e.put(Character.valueOf('\u516d'), "LU");
        f1533e.put(Character.valueOf('\u5587'), "LA");
        f1533e.put(Character.valueOf('\u96d2'), "LUO");
        f1533e.put(Character.valueOf('\u4e86'), "LIAO");
        f1533e.put(Character.valueOf('\u7f2a'), "MIAO");
        f1533e.put(Character.valueOf('\u4f74'), "MI");
        f1533e.put(Character.valueOf('\u8c2c'), "MIAO");
        f1533e.put(Character.valueOf('\u4e5c'), "NIE");
        f1533e.put(Character.valueOf('\u96be'), "NING");
        f1533e.put(Character.valueOf('\u533a'), "OU");
        f1533e.put(Character.valueOf('\u9022'), "PANG");
        f1533e.put(Character.valueOf('\u84ec'), "PENG");
        f1533e.put(Character.valueOf('\u6734'), "PIAO");
        f1533e.put(Character.valueOf('\u7e41'), "PO");
        f1533e.put(Character.valueOf('\u4fbf'), "PIAN");
        f1533e.put(Character.valueOf('\u4ec7'), "QIU");
        f1533e.put(Character.valueOf('\u5361'), "QIA");
        f1533e.put(Character.valueOf('\u8983'), "TAN");
        f1533e.put(Character.valueOf('\u79a4'), "QIAN");
        f1533e.put(Character.valueOf('\u53ec'), "SHAO");
        f1533e.put(Character.valueOf('\u4ec0'), "SHI");
        f1533e.put(Character.valueOf('\u6298'), "SHE");
        f1533e.put(Character.valueOf('\u772d'), "SUI");
        f1533e.put(Character.valueOf('\u89e3'), "XIE");
        f1533e.put(Character.valueOf('\u7cfb'), "XI");
        f1533e.put(Character.valueOf('\u5df7'), "XIANG");
        f1533e.put(Character.valueOf('\u9664'), "XU");
        f1533e.put(Character.valueOf('\u5bf0'), "XIAN");
        f1533e.put(Character.valueOf('\u5458'), "YUAN");
        f1533e.put(Character.valueOf('\u8d20'), "YUAN");
        f1533e.put(Character.valueOf('\u66fe'), "ZENG");
        f1533e.put(Character.valueOf('\u67e5'), "ZHA");
        f1533e.put(Character.valueOf('\u4f20'), "CHUAN");
        f1533e.put(Character.valueOf('\u53ec'), "SHAO");
        f1533e.put(Character.valueOf('\u796d'), "ZHAI");
        f1536i = new char[]{'2', '2', '2', '3', '3', '3', '4', '4', '4', '5', '5', '5', '6', '6', '6', '7', '7', '7', '7', '8', '8', '8', '9', '9', '9', '9'};
    }

    protected HanziToPinyin(boolean z) {
        this.f1537h = z;
    }

    public static HanziToPinyin m2839a() {
        HanziToPinyin hanziToPinyin;
        int i = 0;
        synchronized (HanziToPinyin.class) {
            if (f1535g != null) {
                hanziToPinyin = f1535g;
            } else {
                Locale[] availableLocales = Collator.getAvailableLocales();
                while (i < availableLocales.length) {
                    if (availableLocales[i].equals(Locale.CHINA) || availableLocales[i].equals(Locale.CHINESE)) {
                        f1535g = new HanziToPinyin(true);
                        hanziToPinyin = f1535g;
                        break;
                    }
                    i++;
                }
                Log.w("HanziToPinyin", "There is no Chinese collator, HanziToPinyin is disabled");
                f1535g = new HanziToPinyin(false);
                hanziToPinyin = f1535g;
            }
        }
        return hanziToPinyin;
    }

    private Token m2838a(char c) {
        int i = 0;
        Token token = new Token();
        String ch = Character.toString(c);
        token.f1526b = ch;
        int i2 = -1;
        if (c < '\u0100') {
            token.f1525a = 1;
            token.f1527c = ch;
            return token;
        } else if (c < '\u3400') {
            token.f1525a = 3;
            token.f1527c = ch;
            return token;
        } else {
            String[] strArr = (String[]) f1531c.get(Character.valueOf(c));
            if (strArr != null) {
                token.f1525a = 2;
                token.f1528d = strArr;
                token.f1527c = token.f1528d[0];
                return token;
            }
            int compare = f1534f.compare(ch, "\u963f");
            if (compare < 0) {
                token.f1525a = 3;
                token.f1527c = ch;
                return token;
            }
            if (compare == 0) {
                token.f1525a = 2;
                i2 = 0;
            } else {
                compare = f1534f.compare(ch, "\u84d9");
                if (compare > 0) {
                    token.f1525a = 3;
                    token.f1527c = ch;
                    return token;
                } else if (compare == 0) {
                    token.f1525a = 2;
                    i2 = f1529a.length - 1;
                }
            }
            token.f1525a = 2;
            int i3;
            if (i2 < 0) {
                int i4 = i2;
                i2 = 0;
                i3 = compare;
                compare = f1529a.length - 1;
                int i5 = i3;
                while (i2 <= compare) {
                    i4 = (i2 + compare) / 2;
                    i5 = f1534f.compare(ch, Character.toString(f1529a[i4]));
                    if (i5 == 0) {
                        i2 = i5;
                        compare = i4;
                        break;
                    } else if (i5 > 0) {
                        i2 = i4 + 1;
                    } else {
                        compare = i4 - 1;
                    }
                }
                i2 = i5;
                compare = i4;
            } else {
                i3 = compare;
                compare = i2;
                i2 = i3;
            }
            if (i2 < 0) {
                compare--;
            }
            StringBuilder stringBuilder = new StringBuilder();
            while (i < f1530b[compare].length && f1530b[compare][i] != null) {
                stringBuilder.append((char) f1530b[compare][i]);
                i++;
            }
            token.f1527c = stringBuilder.toString();
            return token;
        }
    }

    private ArrayList<Token> m2841c(String str) {
        int i = 0;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        ArrayList<Token> arrayList = new ArrayList();
        if (str.length() >= 2) {
            String substring = str.substring(0, 2);
            String[] strArr = (String[]) f1532d.get(substring);
            if (strArr != null) {
                while (i < strArr.length) {
                    Token token = new Token();
                    token.f1525a = 2;
                    token.f1526b = String.valueOf(substring.charAt(i));
                    token.f1527c = strArr[i];
                    arrayList.add(token);
                    i++;
                }
                return arrayList;
            }
        }
        Character valueOf = Character.valueOf(str.charAt(0));
        String str2 = (String) f1533e.get(valueOf);
        if (str2 == null) {
            return null;
        }
        token = new Token();
        token.f1525a = 2;
        token.f1526b = valueOf.toString();
        token.f1527c = str2;
        arrayList.add(token);
        return arrayList;
    }

    public ArrayList<Token> m2842a(String str) {
        return m2843a(str, true, true);
    }

    public ArrayList<Token> m2843a(String str, boolean z, boolean z2) {
        ArrayList<Token> arrayList = new ArrayList();
        if (!this.f1537h || TextUtils.isEmpty(str)) {
            return arrayList;
        }
        int i = 0;
        if (!z2) {
            Object c = m2841c(str);
            if (c != null && c.size() > 0) {
                arrayList.addAll(c);
                i = c.size();
            }
        }
        int length = str.length();
        StringBuilder stringBuilder = new StringBuilder();
        i = 1;
        for (int i2 = i; i2 < length; i2++) {
            char charAt = str.charAt(i2);
            if (charAt == ' ') {
                if (stringBuilder.length() > 0) {
                    m2840a(stringBuilder, (ArrayList) arrayList, i);
                }
                if (!z) {
                    String valueOf = String.valueOf(' ');
                    arrayList.add(new Token(3, valueOf, valueOf));
                }
                i = 3;
            } else if (charAt < '\u0100') {
                if (i != 1 && stringBuilder.length() > 0) {
                    m2840a(stringBuilder, (ArrayList) arrayList, i);
                }
                stringBuilder.append(charAt);
                i = 1;
            } else if (charAt < '\u3400') {
                if (i != 3 && stringBuilder.length() > 0) {
                    m2840a(stringBuilder, (ArrayList) arrayList, i);
                }
                stringBuilder.append(charAt);
                i = 3;
            } else {
                Token a = m2838a(charAt);
                if (a.f1525a == 2) {
                    if (stringBuilder.length() > 0) {
                        m2840a(stringBuilder, (ArrayList) arrayList, i);
                    }
                    arrayList.add(a);
                    i = 2;
                } else {
                    if (i != a.f1525a && stringBuilder.length() > 0) {
                        m2840a(stringBuilder, (ArrayList) arrayList, i);
                    }
                    i = a.f1525a;
                    stringBuilder.append(charAt);
                }
            }
        }
        if (stringBuilder.length() > 0) {
            m2840a(stringBuilder, (ArrayList) arrayList, i);
        }
        return arrayList;
    }

    private void m2840a(StringBuilder stringBuilder, ArrayList<Token> arrayList, int i) {
        String stringBuilder2 = stringBuilder.toString();
        arrayList.add(new Token(i, stringBuilder2, stringBuilder2));
        stringBuilder.setLength(0);
    }

    public String m2844b(String str) {
        ArrayList a = m2842a(str);
        if (a == null) {
            return null;
        }
        Iterator it = a.iterator();
        String str2 = null;
        while (it.hasNext()) {
            str2 = str2 + ((Token) it.next()).f1527c;
        }
        return str2;
    }
}
