package groovyjarjarantlr.preprocessor;

import groovyjarjarantlr.collections.impl.IndexedVector;
import java.util.Enumeration;

public class Hierarchy {
    public static String j6(IndexedVector indexedVector) {
        String stringBuffer = new StringBuffer().append("options {").append(System.getProperty("line.separator")).toString();
        Enumeration j6 = indexedVector.j6();
        while (j6.hasMoreElements()) {
            stringBuffer = new StringBuffer().append(stringBuffer).append((Option) j6.nextElement()).append(System.getProperty("line.separator")).toString();
        }
        return new StringBuffer().append(stringBuffer).append("}").append(System.getProperty("line.separator")).append(System.getProperty("line.separator")).toString();
    }
}
