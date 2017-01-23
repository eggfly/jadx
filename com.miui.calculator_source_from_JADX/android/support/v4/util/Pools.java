package android.support.v4.util;

public final class Pools {

    public interface Pool<T> {
    }

    public static class SimplePool<T> implements Pool<T> {
    }

    public static class SynchronizedPool<T> extends SimplePool<T> {
    }

    private Pools() {
    }
}
