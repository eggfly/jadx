package org.javia.arity.miui;

class TestFormat {
    static FormatCase[] f5008a;
    static SizeCase[] f5009b;

    TestFormat() {
    }

    static {
        f5008a = new FormatCase[]{new FormatCase(0, 0.1d, "0.1"), new FormatCase(0, 0.12d, "0.12"), new FormatCase(0, 0.001d, "0.001"), new FormatCase(0, 0.0012d, "0.0012"), new FormatCase(0, 1.0E-7d, "1E-7"), new FormatCase(0, 1.2E-7d, "1.2E-7"), new FormatCase(0, 0.123456789012345d, "0.123456789012345"), new FormatCase(0, 0.0d, "0"), new FormatCase(0, 1.0d, "1"), new FormatCase(0, 12.0d, "12"), new FormatCase(0, 1.23456789E9d, "1234567890"), new FormatCase(0, 1.0E9d, "1000000000"), new FormatCase(0, 1.23456789012345d, "1.23456789012345"), new FormatCase(0, 12345.6789012345d, "12345.6789012345"), new FormatCase(0, 1.23456789012345E9d, "1234567890.12345"), new FormatCase(0, 1.23456789012345E14d, "1.23456789012345E14"), new FormatCase(0, 1.0E14d, "1E14"), new FormatCase(0, 1.2E14d, "1.2E14"), new FormatCase(0, 1.00000000000001E14d, "1.00000000000001E14"), new FormatCase(2, 0.1d, "0.1"), new FormatCase(2, 1.2E-7d, "1.2E-7"), new FormatCase(2, 0.123456789012345d, "0.12345678901235"), new FormatCase(2, 0.0d, "0"), new FormatCase(2, 1.23456789012345d, "1.2345678901235"), new FormatCase(3, 1.23456789012345d, "1.234567890123"), new FormatCase(0, 12345.6789012345d, "12345.6789012345"), new FormatCase(2, 1.23456789012345E9d, "1234567890.1235"), new FormatCase(3, 1.23456789012345E14d, "1.234567890123E14"), new FormatCase(2, 1.00000000000001E14d, "1E14"), new FormatCase(0, 1.2345678901234568E16d, "1.2345678901234568E16"), new FormatCase(2, 1.2345678901234568E16d, "1.2345678901235E16"), new FormatCase(0, 1.0E17d, "1E17"), new FormatCase(0, 1.0E16d, "1E16"), new FormatCase(0, 9.99999999999999E14d, "9.99999999999999E14"), new FormatCase(2, 9.99999999999999E14d, "1E15"), new FormatCase(2, 9.99999999999994E14d, "9.9999999999999E14"), new FormatCase(2, MoreMath.m6736f(1.00002d), "0.000028853612282487"), new FormatCase(0, 4.0E-4d, "0.0004"), new FormatCase(0, 1.0E30d, "1E30")};
        f5009b = new SizeCase[]{new SizeCase(9, "1111111110", "1.11111E9"), new SizeCase(10, "1111111110", "1111111110"), new SizeCase(10, "11111111110", "1.11111E10"), new SizeCase(10, "12.11111E9", "12.11111E9"), new SizeCase(9, "12.34567E9", "12.3456E9"), new SizeCase(9, "12345678E3", "1.2345E10"), new SizeCase(9, "-12345678E3", "-1.234E10"), new SizeCase(9, "-0.00000007", "-0.000000"), new SizeCase(5, "-1.23E123", "-1.23E123"), new SizeCase(5, "-1.2E123", "-1.2E123"), new SizeCase(5, "-1E123", "-1E123"), new SizeCase(2, "-1", "-1"), new SizeCase(1, "-1", "-1"), new SizeCase(1, "-0.02", "-0.02"), new SizeCase(1, "0.02", "0")};
    }
}
