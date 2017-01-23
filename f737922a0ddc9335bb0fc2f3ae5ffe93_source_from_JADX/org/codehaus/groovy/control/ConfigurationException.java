package org.codehaus.groovy.control;

import org.codehaus.groovy.GroovyExceptionInterface;

public class ConfigurationException extends RuntimeException implements GroovyExceptionInterface {
    protected Exception j6;

    public Throwable getCause() {
        return this.j6;
    }
}
