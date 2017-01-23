package org.codehaus.groovy.tools;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public abstract class Utilities {
    private static String DW;
    private static final Set<String> j6;

    static {
        j6 = new HashSet(Arrays.asList("abstract assert boolean break byte case catch char class const continue default do double else enum extends final finally float for goto if implements import instanceof int interface long native new package private protected public short static strictfp super switch synchronized this throw throws transient try void volatile while true false null".split(" ")));
        DW = System.getProperty("line.separator", "\n");
    }
}
