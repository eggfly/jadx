package com.antutu.benchmark.platform.p052c;

/* renamed from: com.antutu.benchmark.platform.c.a */
class C1572a {
    static int f5461a;
    static int f5462b;
    public static int f5463c;
    private static int[] f5464d;
    private static int f5465e;
    private static int f5466f;

    static {
        f5461a = -99;
        f5462b = -99;
        f5464d = new int[]{9, 9};
        f5463c = 19;
    }

    private static void m6222a() {
        if (f5462b < f5461a) {
            f5464d[0] = f5465e;
            f5464d[1] = f5466f;
            f5462b = f5461a;
        }
    }

    static int[] m6223a(String[][] strArr, String str) {
        f5461a = -99;
        f5462b = -99;
        f5465e = 0;
        while (f5465e < f5463c) {
            f5466f = 0;
            while (f5466f < f5463c) {
                if (strArr[f5465e][f5466f] == null) {
                    C1572a.m6225c(strArr, str);
                    C1572a.m6226d(strArr, str);
                    C1572a.m6227e(strArr, str);
                    C1572a.m6228f(strArr, str);
                }
                f5466f++;
            }
            f5465e++;
        }
        return f5464d;
    }

    public static boolean m6224b(String[][] strArr, String str) {
        int i = 0;
        while (i < f5463c) {
            int i2 = 0;
            while (i2 < f5463c) {
                if (i + 4 < f5463c && i2 + 4 < f5463c && strArr[i][i2] == str && strArr[i + 1][i2 + 1] == str && strArr[i + 2][i2 + 2] == str && strArr[i + 3][i2 + 3] == str && strArr[i + 4][i2 + 4] == str) {
                    return true;
                }
                if (i + 4 < f5463c && strArr[i][i2] == str && strArr[i + 1][i2] == str && strArr[i + 2][i2] == str && strArr[i + 3][i2] == str && strArr[i + 4][i2] == str) {
                    return true;
                }
                if (i2 + 4 < f5463c && strArr[i][i2] == str && strArr[i][i2 + 1] == str && strArr[i][i2 + 2] == str && strArr[i][i2 + 3] == str && strArr[i][i2 + 4] == str) {
                    return true;
                }
                if (i + 4 < f5463c && i2 - 4 >= 0 && strArr[i][i2] == str && strArr[i + 1][i2 - 1] == str && strArr[i + 2][i2 - 2] == str && strArr[i + 3][i2 - 3] == str && strArr[i + 4][i2 - 4] == str) {
                    return true;
                }
                i2++;
            }
            i++;
        }
        return false;
    }

    private static void m6225c(String[][] strArr, String str) {
        if (f5466f + 1 < f5463c && strArr[f5465e][f5466f + 1] != null) {
            if (strArr[f5465e][f5466f + 1] == str) {
                f5461a = -2;
                C1572a.m6222a();
            } else {
                f5461a = -3;
                C1572a.m6222a();
            }
        }
        if (f5466f - 1 >= 0 && strArr[f5465e][f5466f - 1] != null) {
            if (strArr[f5465e][f5466f - 1] == str) {
                f5461a = -2;
                C1572a.m6222a();
            } else {
                f5461a = -3;
                C1572a.m6222a();
            }
        }
        if (f5465e + 1 < f5463c && strArr[f5465e + 1][f5466f] != null) {
            if (strArr[f5465e + 1][f5466f] == str) {
                f5461a = -2;
                C1572a.m6222a();
            } else {
                f5461a = -3;
                C1572a.m6222a();
            }
        }
        if (f5465e - 1 >= 0 && strArr[f5465e - 1][f5466f] != null) {
            if (strArr[f5465e - 1][f5466f] == str) {
                f5461a = -2;
                C1572a.m6222a();
            } else {
                f5461a = -3;
                C1572a.m6222a();
            }
        }
        if (f5465e - 1 >= 0 && f5466f - 1 >= 0 && strArr[f5465e - 1][f5466f - 1] != null) {
            if (strArr[f5465e - 1][f5466f - 1] == str) {
                f5461a = -2;
                C1572a.m6222a();
            } else {
                f5461a = -3;
                C1572a.m6222a();
            }
        }
        if (f5465e + 1 < f5463c && f5466f + 1 < f5463c && strArr[f5465e + 1][f5466f + 1] != null) {
            if (strArr[f5465e + 1][f5466f + 1] == str) {
                f5461a = -2;
                C1572a.m6222a();
            } else {
                f5461a = -3;
                C1572a.m6222a();
            }
        }
        if (f5465e - 1 >= 0 && f5466f + 1 < f5463c && strArr[f5465e - 1][f5466f + 1] != null) {
            if (strArr[f5465e - 1][f5466f + 1] == str) {
                f5461a = -2;
                C1572a.m6222a();
            } else {
                f5461a = -3;
                C1572a.m6222a();
            }
        }
        if (f5465e + 1 < f5463c && f5466f - 1 >= 0 && strArr[f5465e + 1][f5466f - 1] != null) {
            if (strArr[f5465e + 1][f5466f - 1] == str) {
                f5461a = -2;
                C1572a.m6222a();
                return;
            }
            f5461a = -3;
            C1572a.m6222a();
        }
    }

    private static void m6226d(String[][] strArr, String str) {
        if (f5466f + 2 < f5463c && strArr[f5465e][f5466f + 1] != null && strArr[f5465e][f5466f + 1] == strArr[f5465e][f5466f + 2]) {
            if (strArr[f5465e][f5466f + 1] == str) {
                f5461a = 0;
                C1572a.m6222a();
            } else {
                f5461a = -1;
                C1572a.m6222a();
            }
        }
        if (f5466f - 2 >= 0 && strArr[f5465e][f5466f - 1] != null && strArr[f5465e][f5466f - 1] == strArr[f5465e][f5466f - 2]) {
            if (strArr[f5465e][f5466f - 1] == str) {
                f5461a = 0;
                C1572a.m6222a();
            } else {
                f5461a = -1;
                C1572a.m6222a();
            }
        }
        if (f5465e + 2 < f5463c && strArr[f5465e + 1][f5466f] != null && strArr[f5465e + 1][f5466f] == strArr[f5465e + 2][f5466f]) {
            if (strArr[f5465e + 1][f5466f] == str) {
                f5461a = 0;
                C1572a.m6222a();
            } else {
                f5461a = -1;
                C1572a.m6222a();
            }
        }
        if (f5465e - 2 >= 0 && strArr[f5465e - 1][f5466f] != null && strArr[f5465e - 1][f5466f] == strArr[f5465e - 2][f5466f]) {
            if (strArr[f5465e - 1][f5466f] == str) {
                f5461a = 0;
                C1572a.m6222a();
            } else {
                f5461a = -1;
                C1572a.m6222a();
            }
        }
        if (f5465e - 2 >= 0 && f5466f - 2 >= 0 && strArr[f5465e - 1][f5466f - 1] != null && strArr[f5465e - 1][f5466f - 1] == strArr[f5465e - 2][f5466f - 2]) {
            if (strArr[f5465e][f5466f] == str) {
                f5461a = 0;
                C1572a.m6222a();
            } else {
                f5461a = -1;
                C1572a.m6222a();
            }
        }
        if (f5465e + 2 < f5463c && f5466f + 2 < f5463c && strArr[f5465e + 1][f5466f + 1] != null && strArr[f5465e + 1][f5466f + 1] == strArr[f5465e + 2][f5466f + 2]) {
            if (strArr[f5465e + 1][f5466f + 1] == str) {
                f5461a = 0;
                C1572a.m6222a();
            } else {
                f5461a = -1;
                C1572a.m6222a();
            }
        }
        if (f5465e - 2 >= 0 && f5466f + 2 < f5463c && strArr[f5465e - 1][f5466f + 1] != null && strArr[f5465e - 1][f5466f + 1] == strArr[f5465e - 2][f5466f + 2]) {
            if (strArr[f5465e - 1][f5466f + 1] == str) {
                f5461a = 0;
                C1572a.m6222a();
            } else {
                f5461a = -1;
                C1572a.m6222a();
            }
        }
        if (f5465e + 2 < f5463c && f5466f - 2 >= 0 && strArr[f5465e + 1][f5466f - 1] != null && strArr[f5465e + 1][f5466f - 1] == strArr[f5465e + 2][f5466f - 2]) {
            if (strArr[f5465e + 1][f5466f - 1] == str) {
                f5461a = 0;
                C1572a.m6222a();
            } else {
                f5461a = -1;
                C1572a.m6222a();
            }
        }
        if (f5466f + 1 < f5463c && f5466f - 1 >= 0 && strArr[f5465e][f5466f + 1] != null && strArr[f5465e][f5466f + 1] == strArr[f5465e][f5466f - 1]) {
            if (strArr[f5465e][f5466f + 1] == str) {
                f5461a = 0;
                C1572a.m6222a();
            } else {
                f5461a = -1;
                C1572a.m6222a();
            }
        }
        if (f5465e + 1 < f5463c && f5465e - 1 >= 0 && strArr[f5465e + 1][f5466f] != null && strArr[f5465e + 1][f5466f] == strArr[f5465e - 1][f5466f]) {
            if (strArr[f5465e + 1][f5466f] == str) {
                f5461a = 0;
                C1572a.m6222a();
            } else {
                f5461a = -1;
                C1572a.m6222a();
            }
        }
        if (f5465e - 1 >= 0 && f5466f - 1 >= 0 && f5465e + 1 < f5463c && f5466f + 1 < f5463c && strArr[f5465e - 1][f5466f - 1] != null && strArr[f5465e - 1][f5466f - 1] == strArr[f5465e + 1][f5466f + 1]) {
            if (strArr[f5465e - 1][f5466f - 1] == str) {
                f5461a = 0;
                C1572a.m6222a();
            } else {
                f5461a = -1;
                C1572a.m6222a();
            }
        }
        if (f5465e - 1 >= 0 && f5466f + 1 < f5463c && f5465e + 1 < f5463c && f5466f - 1 >= 0 && strArr[f5465e - 1][f5466f + 1] != null && strArr[f5465e - 1][f5466f + 1] == strArr[f5465e + 1][f5466f - 1]) {
            if (strArr[f5465e - 1][f5466f + 1] == str) {
                f5461a = 0;
                C1572a.m6222a();
                return;
            }
            f5461a = -1;
            C1572a.m6222a();
        }
    }

    private static void m6227e(String[][] strArr, String str) {
        if (f5466f + 3 < f5463c && strArr[f5465e][f5466f + 1] != null && strArr[f5465e][f5466f + 1] == strArr[f5465e][f5466f + 2] && strArr[f5465e][f5466f + 2] == strArr[f5465e][f5466f + 3]) {
            if (strArr[f5465e][f5466f + 1] == str) {
                f5461a = 2;
                C1572a.m6222a();
            } else if (f5466f + 4 < f5463c && strArr[f5465e][f5466f + 4] == null) {
                f5461a = 1;
                C1572a.m6222a();
            }
        }
        if (f5466f - 3 >= 0 && strArr[f5465e][f5466f - 1] != null && strArr[f5465e][f5466f - 1] == strArr[f5465e][f5466f - 2] && strArr[f5465e][f5466f - 2] == strArr[f5465e][f5466f - 3]) {
            if (strArr[f5465e][f5466f - 1] == str) {
                f5461a = 2;
                C1572a.m6222a();
            } else if (f5466f - 4 >= 0 && strArr[f5465e][f5466f - 4] == null) {
                f5461a = -5;
                C1572a.m6222a();
            }
        }
        if (f5465e + 3 < f5463c && strArr[f5465e + 1][f5466f] != null && strArr[f5465e + 1][f5466f] == strArr[f5465e + 2][f5466f] && strArr[f5465e + 2][f5466f] == strArr[f5465e + 3][f5466f]) {
            if (strArr[f5465e + 1][f5466f] == str) {
                f5461a = 2;
                C1572a.m6222a();
            } else if (f5465e + 4 < f5463c && strArr[f5465e + 4][f5466f] == null) {
                f5461a = 1;
                C1572a.m6222a();
            }
        }
        if (f5465e - 3 >= 0 && strArr[f5465e - 1][f5466f] != null && strArr[f5465e - 1][f5466f] == strArr[f5465e - 2][f5466f] && strArr[f5465e - 2][f5466f] == strArr[f5465e - 3][f5466f]) {
            if (strArr[f5465e - 1][f5466f] == str) {
                f5461a = 2;
                C1572a.m6222a();
            } else if (f5465e - 4 >= 0 && strArr[f5465e - 4][f5466f] == null) {
                f5461a = 1;
                C1572a.m6222a();
            }
        }
        if (f5465e - 3 >= 0 && f5466f - 3 >= 0 && strArr[f5465e - 1][f5466f - 1] != null && strArr[f5465e - 1][f5466f - 1] == strArr[f5465e - 2][f5466f - 2] && strArr[f5465e - 2][f5466f - 2] == strArr[f5465e - 3][f5466f - 3]) {
            if (strArr[f5465e - 1][f5466f - 1] == str) {
                f5461a = 2;
                C1572a.m6222a();
            } else if (f5465e - 4 >= 0 && f5466f - 4 >= 0 && strArr[f5465e - 4][f5466f - 4] == null) {
                f5461a = 1;
                C1572a.m6222a();
            }
        }
        if (f5465e + 3 < f5463c && f5466f + 3 < f5463c && strArr[f5465e + 1][f5466f + 1] != null && strArr[f5465e + 1][f5466f + 1] == strArr[f5465e + 2][f5466f + 2] && strArr[f5465e + 2][f5466f + 2] == strArr[f5465e + 3][f5466f + 3]) {
            if (strArr[f5465e + 1][f5466f + 1] == str) {
                f5461a = 2;
                C1572a.m6222a();
            } else if (f5465e + 4 >= 0 && f5466f + 4 >= 0 && strArr[f5465e + 4][f5466f + 4] == null) {
                f5461a = 1;
                C1572a.m6222a();
            }
        }
        if (f5465e - 3 >= 0 && f5466f + 3 < f5463c && strArr[f5465e - 1][f5466f + 1] != null && strArr[f5465e - 1][f5466f + 1] == strArr[f5465e - 2][f5466f + 2] && strArr[f5465e - 2][f5466f + 2] == strArr[f5465e - 3][f5466f + 3]) {
            if (strArr[f5465e - 1][f5466f + 1] == str) {
                f5461a = 2;
                C1572a.m6222a();
            } else if (f5465e - 4 >= 0 && f5466f + 4 < f5463c && strArr[f5465e - 4][f5466f + 4] == null) {
                f5461a = 1;
                C1572a.m6222a();
            }
        }
        if (f5465e + 3 < f5463c && f5466f - 3 >= 0 && strArr[f5465e + 1][f5466f - 1] != null && strArr[f5465e + 1][f5466f - 1] == strArr[f5465e + 2][f5466f - 2] && strArr[f5465e + 2][f5466f - 2] == strArr[f5465e + 3][f5466f - 3]) {
            if (strArr[f5465e + 1][f5466f - 1] == str) {
                f5461a = 2;
                C1572a.m6222a();
            } else if (f5465e + 4 < f5463c && f5466f - 4 >= 0 && strArr[f5465e + 4][f5466f - 4] == null) {
                f5461a = 1;
                C1572a.m6222a();
            }
        }
        if (f5466f + 2 < f5463c && f5466f - 1 >= 0 && strArr[f5465e][f5466f + 1] != null && strArr[f5465e][f5466f + 1] == strArr[f5465e][f5466f + 2] && strArr[f5465e][f5466f + 1] == strArr[f5465e][f5466f - 1]) {
            if (strArr[f5465e][f5466f + 1] == str) {
                f5461a = 2;
                C1572a.m6222a();
            } else if (f5466f + 3 < f5463c && strArr[f5465e][f5466f + 3] == null) {
                f5461a = 1;
                C1572a.m6222a();
            }
        }
        if (f5466f - 2 >= 0 && f5466f + 1 < f5463c && strArr[f5465e][f5466f - 1] != null && strArr[f5465e][f5466f - 1] == strArr[f5465e][f5466f - 2] && strArr[f5465e][f5466f - 1] == strArr[f5465e][f5466f + 1]) {
            if (strArr[f5465e][f5466f - 1] == str) {
                f5461a = 2;
                C1572a.m6222a();
            } else if (f5466f - 3 >= 0 && strArr[f5465e][f5466f - 3] == null) {
                f5461a = 1;
                C1572a.m6222a();
            }
        }
        if (f5465e + 2 < f5463c && f5465e - 1 >= 0 && strArr[f5465e + 1][f5466f] != null && strArr[f5465e + 1][f5466f] == strArr[f5465e + 2][f5466f] && strArr[f5465e + 1][f5466f] == strArr[f5465e - 1][f5466f]) {
            if (strArr[f5465e + 1][f5466f] == str) {
                f5461a = 2;
                C1572a.m6222a();
            } else if (f5465e + 3 < f5463c && strArr[f5465e + 3][f5466f] == null) {
                f5461a = 1;
                C1572a.m6222a();
            }
        }
        if (f5465e - 2 >= 0 && f5465e + 1 < f5463c && strArr[f5465e - 1][f5466f] != null && strArr[f5465e - 1][f5466f] == strArr[f5465e - 2][f5466f] && strArr[f5465e - 1][f5466f] == strArr[f5465e + 1][f5466f]) {
            if (strArr[f5465e - 1][f5466f] == str) {
                f5461a = 2;
                C1572a.m6222a();
            } else if (f5465e - 3 >= 0 && strArr[f5465e - 3][f5466f] == null) {
                f5461a = 1;
                C1572a.m6222a();
            }
        }
        if (f5465e - 2 >= 0 && f5466f - 2 >= 0 && f5465e + 1 < f5463c && f5466f + 1 < f5463c && strArr[f5465e - 1][f5466f - 1] != null && strArr[f5465e - 1][f5466f - 1] == strArr[f5465e - 2][f5466f - 2] && strArr[f5465e - 1][f5466f - 1] == strArr[f5465e + 1][f5466f + 1]) {
            if (strArr[f5465e - 1][f5466f - 1] == str) {
                f5461a = 2;
                C1572a.m6222a();
            } else if (f5466f - 3 >= 0 && f5465e - 3 >= 0 && strArr[f5465e - 3][f5466f - 3] == null) {
                f5461a = 1;
                C1572a.m6222a();
            }
        }
        if (f5465e + 2 < f5463c && f5466f + 2 < f5463c && f5465e - 1 >= 0 && f5466f - 1 >= 0 && strArr[f5465e + 1][f5466f + 1] != null && strArr[f5465e + 1][f5466f + 1] == strArr[f5465e + 2][f5466f + 2] && strArr[f5465e + 1][f5466f + 1] == strArr[f5465e - 1][f5466f - 1]) {
            if (strArr[f5465e + 1][f5466f + 1] == str) {
                f5461a = 2;
                C1572a.m6222a();
            } else if (f5466f + 3 < f5463c && f5465e + 3 < f5463c && strArr[f5465e + 3][f5466f + 3] == null) {
                f5461a = 1;
                C1572a.m6222a();
            }
        }
        if (f5465e - 2 >= 0 && f5466f + 2 < f5463c && f5465e + 1 < f5463c && f5466f - 1 >= 0 && strArr[f5465e - 1][f5466f + 1] != null && strArr[f5465e - 1][f5466f + 1] == strArr[f5465e - 2][f5466f + 2] && strArr[f5465e - 1][f5466f + 1] == strArr[f5465e + 1][f5466f - 1]) {
            if (strArr[f5465e - 1][f5466f + 1] == str) {
                f5461a = 2;
                C1572a.m6222a();
            } else if (f5466f + 3 < f5463c && f5465e - 3 >= 0 && strArr[f5465e - 3][f5466f + 3] == null) {
                f5461a = 1;
                C1572a.m6222a();
            }
        }
        if (f5465e + 2 < f5463c && f5466f - 2 >= 0 && f5465e - 1 >= 0 && f5466f + 1 < f5463c && strArr[f5465e + 1][f5466f - 1] != null && strArr[f5465e + 1][f5466f - 1] == strArr[f5465e + 2][f5466f - 2] && strArr[f5465e + 1][f5466f - 1] == strArr[f5465e - 1][f5466f + 1]) {
            if (strArr[f5465e + 1][f5466f - 1] == str) {
                f5461a = 2;
                C1572a.m6222a();
            } else if (f5466f - 3 >= 0 && f5465e + 3 < f5463c && strArr[f5465e + 3][f5466f - 3] == null) {
                f5461a = 1;
                C1572a.m6222a();
            }
        }
    }

    private static void m6228f(String[][] strArr, String str) {
        if (f5466f + 4 < f5463c && strArr[f5465e][f5466f + 1] != null && strArr[f5465e][f5466f + 1] == strArr[f5465e][f5466f + 2] && strArr[f5465e][f5466f + 2] == strArr[f5465e][f5466f + 3] && strArr[f5465e][f5466f + 3] == strArr[f5465e][f5466f + 4]) {
            if (strArr[f5465e][f5466f + 1] == str) {
                f5461a = 4;
                C1572a.m6222a();
            } else {
                f5461a = 3;
                C1572a.m6222a();
            }
        }
        if (f5466f - 4 >= 0 && strArr[f5465e][f5466f - 1] != null && strArr[f5465e][f5466f - 1] == strArr[f5465e][f5466f - 2] && strArr[f5465e][f5466f - 2] == strArr[f5465e][f5466f - 3] && strArr[f5465e][f5466f - 3] == strArr[f5465e][f5466f - 4]) {
            if (strArr[f5465e][f5466f - 1] == str) {
                f5461a = 4;
                C1572a.m6222a();
            } else {
                f5461a = 3;
                C1572a.m6222a();
            }
        }
        if (f5465e + 4 < f5463c && strArr[f5465e + 1][f5466f] != null && strArr[f5465e + 1][f5466f] == strArr[f5465e + 2][f5466f] && strArr[f5465e + 2][f5466f] == strArr[f5465e + 3][f5466f] && strArr[f5465e + 3][f5466f] == strArr[f5465e + 4][f5466f]) {
            if (strArr[f5465e + 1][f5466f] == str) {
                f5461a = 4;
                C1572a.m6222a();
            } else {
                f5461a = 3;
                C1572a.m6222a();
            }
        }
        if (f5465e - 4 >= 0 && strArr[f5465e - 1][f5466f] != null && strArr[f5465e - 1][f5466f] == strArr[f5465e - 2][f5466f] && strArr[f5465e - 2][f5466f] == strArr[f5465e - 3][f5466f] && strArr[f5465e - 3][f5466f] == strArr[f5465e - 4][f5466f]) {
            if (strArr[f5465e - 1][f5466f] == str) {
                f5461a = 4;
                C1572a.m6222a();
            } else {
                f5461a = 3;
                C1572a.m6222a();
            }
        }
        if (f5465e - 4 >= 0 && f5466f - 4 >= 0 && strArr[f5465e - 1][f5466f - 1] != null && strArr[f5465e - 1][f5466f - 1] == strArr[f5465e - 2][f5466f - 2] && strArr[f5465e - 2][f5466f - 2] == strArr[f5465e - 3][f5466f - 3] && strArr[f5465e - 3][f5466f - 3] == strArr[f5465e - 4][f5466f - 4]) {
            if (strArr[f5465e - 1][f5466f - 1] == str) {
                f5461a = 4;
                C1572a.m6222a();
            } else {
                f5461a = 3;
                C1572a.m6222a();
            }
        }
        if (f5465e + 4 < f5463c && f5466f + 4 < f5463c && strArr[f5465e + 1][f5466f + 1] != null && strArr[f5465e + 1][f5466f + 1] == strArr[f5465e + 2][f5466f + 2] && strArr[f5465e + 2][f5466f + 2] == strArr[f5465e + 3][f5466f + 3] && strArr[f5465e + 3][f5466f + 3] == strArr[f5465e + 4][f5466f + 4]) {
            if (strArr[f5465e + 1][f5466f + 1] == str) {
                f5461a = 4;
                C1572a.m6222a();
            } else {
                f5461a = 3;
                C1572a.m6222a();
            }
        }
        if (f5465e - 4 >= 0 && f5466f + 4 < f5463c && strArr[f5465e - 1][f5466f + 1] != null && strArr[f5465e - 1][f5466f + 1] == strArr[f5465e - 2][f5466f + 2] && strArr[f5465e - 2][f5466f + 2] == strArr[f5465e - 3][f5466f + 3] && strArr[f5465e - 3][f5466f + 3] == strArr[f5465e - 4][f5466f + 4]) {
            if (strArr[f5465e - 1][f5466f + 1] == str) {
                f5461a = 4;
                C1572a.m6222a();
            } else {
                f5461a = 3;
                C1572a.m6222a();
            }
        }
        if (f5465e + 4 < f5463c && f5466f - 4 >= 0 && strArr[f5465e + 1][f5466f - 1] != null && strArr[f5465e + 1][f5466f - 1] == strArr[f5465e + 2][f5466f - 2] && strArr[f5465e + 2][f5466f - 2] == strArr[f5465e + 3][f5466f - 3] && strArr[f5465e + 3][f5466f - 3] == strArr[f5465e + 4][f5466f - 4]) {
            if (strArr[f5465e + 1][f5466f - 1] == str) {
                f5461a = 4;
                C1572a.m6222a();
            } else {
                f5461a = 3;
                C1572a.m6222a();
            }
        }
        if (f5466f + 3 < f5463c && f5466f - 1 >= 0 && strArr[f5465e][f5466f - 1] != null && strArr[f5465e][f5466f - 1] == strArr[f5465e][f5466f + 1] && strArr[f5465e][f5466f - 1] == strArr[f5465e][f5466f + 2] && strArr[f5465e][f5466f - 1] == strArr[f5465e][f5466f + 3]) {
            if (strArr[f5465e][f5466f - 1] == str) {
                f5461a = 4;
                C1572a.m6222a();
            } else {
                f5461a = 3;
                C1572a.m6222a();
            }
        }
        if (f5466f - 3 >= 0 && f5466f + 1 < f5463c && strArr[f5465e][f5466f - 1] != null && strArr[f5465e][f5466f - 1] == strArr[f5465e][f5466f - 2] && strArr[f5465e][f5466f - 1] == strArr[f5465e][f5466f - 3] && strArr[f5465e][f5466f - 1] == strArr[f5465e][f5466f + 1]) {
            if (strArr[f5465e][f5466f - 1] == str) {
                f5461a = 4;
                C1572a.m6222a();
            } else {
                f5461a = 3;
                C1572a.m6222a();
            }
        }
        if (f5465e + 3 < f5463c && f5465e - 1 >= 0 && strArr[f5465e + 1][f5466f] != null && strArr[f5465e + 1][f5466f] == strArr[f5465e + 2][f5466f] && strArr[f5465e + 1][f5466f] == strArr[f5465e + 3][f5466f] && strArr[f5465e + 1][f5466f] == strArr[f5465e - 1][f5466f]) {
            if (strArr[f5465e + 1][f5466f] == str) {
                f5461a = 4;
                C1572a.m6222a();
            } else {
                f5461a = 3;
                C1572a.m6222a();
            }
        }
        if (f5465e - 3 >= 0 && f5465e + 1 < f5463c && strArr[f5465e - 1][f5466f] != null && strArr[f5465e - 1][f5466f] == strArr[f5465e - 2][f5466f] && strArr[f5465e - 1][f5466f] == strArr[f5465e - 3][f5466f] && strArr[f5465e - 1][f5466f] == strArr[f5465e + 1][f5466f]) {
            if (strArr[f5465e - 1][f5466f] == str) {
                f5461a = 4;
                C1572a.m6222a();
            } else {
                f5461a = 3;
                C1572a.m6222a();
            }
        }
        if (f5465e - 3 >= 0 && f5466f - 3 >= 0 && f5465e + 1 < f5463c && f5466f + 1 < f5463c && strArr[f5465e - 1][f5466f - 1] != null && strArr[f5465e - 1][f5466f - 1] == strArr[f5465e - 2][f5466f - 2] && strArr[f5465e - 1][f5466f - 1] == strArr[f5465e - 3][f5466f - 3] && strArr[f5465e - 1][f5466f - 1] == strArr[f5465e + 1][f5466f + 1]) {
            if (strArr[f5465e - 1][f5466f - 1] == str) {
                f5461a = 4;
                C1572a.m6222a();
            } else {
                f5461a = 3;
                C1572a.m6222a();
            }
        }
        if (f5465e + 3 < f5463c && f5466f + 3 < f5463c && f5466f - 1 >= 0 && f5465e - 1 >= 0 && strArr[f5465e + 1][f5466f + 1] != null && strArr[f5465e + 1][f5466f + 1] == strArr[f5465e + 2][f5466f + 2] && strArr[f5465e + 1][f5466f + 1] == strArr[f5465e + 3][f5466f + 3] && strArr[f5465e + 1][f5466f + 1] == strArr[f5465e - 1][f5466f - 1]) {
            if (strArr[f5465e + 1][f5466f + 1] == str) {
                f5461a = 4;
                C1572a.m6222a();
            } else {
                f5461a = 3;
                C1572a.m6222a();
            }
        }
        if (f5465e - 3 >= 0 && f5466f + 3 < f5463c && f5466f - 1 >= 0 && f5465e + 1 < f5463c && strArr[f5465e - 1][f5466f + 1] != null && strArr[f5465e - 1][f5466f + 1] == strArr[f5465e - 2][f5466f + 2] && strArr[f5465e - 1][f5466f + 1] == strArr[f5465e - 3][f5466f + 3] && strArr[f5465e - 1][f5466f + 1] == strArr[f5465e + 1][f5466f - 1]) {
            if (strArr[f5465e - 1][f5466f + 1] == str) {
                f5461a = 4;
                C1572a.m6222a();
            } else {
                f5461a = 3;
                C1572a.m6222a();
            }
        }
        if (f5465e + 3 < f5463c && f5466f - 3 >= 0 && f5465e - 1 >= 0 && f5466f + 1 < f5463c && strArr[f5465e + 1][f5466f - 1] != null && strArr[f5465e + 1][f5466f - 1] == strArr[f5465e + 2][f5466f - 2] && strArr[f5465e + 1][f5466f - 1] == strArr[f5465e + 3][f5466f - 3] && strArr[f5465e + 1][f5466f - 1] == strArr[f5465e - 1][f5466f + 1]) {
            if (strArr[f5465e + 1][f5466f - 1] == str) {
                f5461a = 4;
                C1572a.m6222a();
            } else {
                f5461a = 3;
                C1572a.m6222a();
            }
        }
        if (f5466f + 2 < f5463c && f5466f - 2 >= 0 && strArr[f5465e][f5466f - 1] != null && strArr[f5465e][f5466f - 1] == strArr[f5465e][f5466f + 1] && strArr[f5465e][f5466f - 1] == strArr[f5465e][f5466f + 2] && strArr[f5465e][f5466f - 1] == strArr[f5465e][f5466f - 2]) {
            if (strArr[f5465e][f5466f - 1] == str) {
                f5461a = 4;
                C1572a.m6222a();
            } else {
                f5461a = 3;
                C1572a.m6222a();
            }
        }
        if (f5465e + 2 < f5463c && f5465e - 2 >= 0 && strArr[f5465e + 1][f5466f] != null && strArr[f5465e + 1][f5466f] == strArr[f5465e + 2][f5466f] && strArr[f5465e + 1][f5466f] == strArr[f5465e - 2][f5466f] && strArr[f5465e + 1][f5466f] == strArr[f5465e - 1][f5466f]) {
            if (strArr[f5465e + 1][f5466f] == str) {
                f5461a = 4;
                C1572a.m6222a();
            } else {
                f5461a = 3;
                C1572a.m6222a();
            }
        }
        if (f5465e - 2 >= 0 && f5466f - 2 >= 0 && f5465e + 2 < f5463c && f5466f + 2 < f5463c && strArr[f5465e - 1][f5466f - 1] != null && strArr[f5465e - 1][f5466f - 1] == strArr[f5465e - 2][f5466f - 2] && strArr[f5465e - 1][f5466f - 1] == strArr[f5465e + 2][f5466f + 2] && strArr[f5465e - 1][f5466f - 1] == strArr[f5465e + 1][f5466f + 1]) {
            if (strArr[f5465e - 1][f5466f - 1] == str) {
                f5461a = 4;
                C1572a.m6222a();
            } else {
                f5461a = 3;
                C1572a.m6222a();
            }
        }
        if (f5465e - 2 >= 0 && f5466f + 2 < f5463c && f5466f - 2 >= 0 && f5465e + 2 < f5463c && strArr[f5465e - 1][f5466f + 1] != null && strArr[f5465e - 1][f5466f + 1] == strArr[f5465e - 2][f5466f + 2] && strArr[f5465e - 1][f5466f + 1] == strArr[f5465e + 2][f5466f - 2] && strArr[f5465e - 1][f5466f + 1] == strArr[f5465e + 1][f5466f - 1]) {
            if (strArr[f5465e - 1][f5466f + 1] == str) {
                f5461a = 4;
                C1572a.m6222a();
                return;
            }
            f5461a = 3;
            C1572a.m6222a();
        }
    }
}
