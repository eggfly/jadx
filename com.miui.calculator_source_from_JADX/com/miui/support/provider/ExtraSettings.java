package com.miui.support.provider;

public class ExtraSettings {

    public static class Secure {
        protected Secure() {
            throw new InstantiationException("Cannot instantiate utility class");
        }
    }

    public static class System {
        protected System() {
            throw new InstantiationException("Cannot instantiate utility class");
        }
    }

    protected ExtraSettings() {
        throw new InstantiationException("Cannot instantiate utility class");
    }
}
