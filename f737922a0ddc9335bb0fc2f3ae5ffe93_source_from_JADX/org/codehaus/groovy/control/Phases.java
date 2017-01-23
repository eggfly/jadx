package org.codehaus.groovy.control;

public class Phases {
    public static String[] j6;

    static {
        j6 = new String[]{"startup", "initialization", "parsing", "conversion", "semantic analysis", "canonicalization", "instruction selection", "class generation", "output", "cleanup"};
    }
}
