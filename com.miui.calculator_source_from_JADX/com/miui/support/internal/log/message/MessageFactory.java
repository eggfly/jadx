package com.miui.support.internal.log.message;

import java.util.HashMap;

public class MessageFactory {
    private static HashMap<Class<?>, MessageCache<?>> f2532a;

    private static class MessageCache<T extends Message> {
    }

    static {
        f2532a = new HashMap();
    }
}
