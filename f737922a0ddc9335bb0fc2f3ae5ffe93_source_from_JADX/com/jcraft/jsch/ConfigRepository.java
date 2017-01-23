package com.jcraft.jsch;

public interface ConfigRepository {
    public static final ConfigRepository DW;
    public static final Config j6;

    public interface Config {
        String DW();

        String[] DW(String str);

        int FH();

        String j6();

        String j6(String str);
    }

    class 1 implements Config {
        1() {
        }

        public String j6() {
            return null;
        }

        public String DW() {
            return null;
        }

        public int FH() {
            return -1;
        }

        public String j6(String str) {
            return null;
        }

        public String[] DW(String str) {
            return null;
        }
    }

    class 2 implements ConfigRepository {
        2() {
        }

        public Config j6(String str) {
            return j6;
        }
    }

    Config j6(String str);

    static {
        j6 = new 1();
        DW = new 2();
    }
}
