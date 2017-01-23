package org.codehaus.groovy.control;

import java.util.HashSet;
import java.util.Set;

public class Janitor implements HasCleanup {
    private final Set j6;

    public Janitor() {
        this.j6 = new HashSet();
    }
}
