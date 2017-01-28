public final class tp {
    public static int j6(byte[] bArr) {
        if (bArr.length != 8 || bArr[0] != 100 || bArr[1] != 101 || bArr[2] != 120 || bArr[3] != 10 || bArr[7] != null) {
            return -1;
        }
        String str = "" + ((char) bArr[4]) + ((char) bArr[5]) + ((char) bArr[6]);
        if (str.equals("036")) {
            return 14;
        }
        if (str.equals("035")) {
            return 13;
        }
        return -1;
    }

    public static String j6(int i) {
        String str;
        if (i >= 14) {
            str = "036";
        } else {
            str = "035";
        }
        return "dex\n" + str + "\u0000";
    }
}
