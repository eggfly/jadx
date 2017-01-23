package org.codehaus.groovy.tools;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class LoaderConfiguration {
    private boolean DW;
    private final List<String> FH;
    private List<URL> j6;

    public LoaderConfiguration() {
        this.j6 = new ArrayList();
        this.FH = new ArrayList();
        this.DW = true;
    }
}
