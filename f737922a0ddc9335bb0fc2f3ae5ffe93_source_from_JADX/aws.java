import java.io.File;
import java.lang.reflect.Method;

class aws extends awq {
    private static final Method DW;
    private static final Method FH;

    static {
        DW = j6(File.class, "canExecute", new Class[0]);
        FH = j6(File.class, "setExecutable", Boolean.TYPE);
    }

    static boolean gn() {
        return (DW == null || FH == null) ? false : true;
    }

    private static Method j6(Class<?> cls, String str, Class<?>... clsArr) {
        Method method = null;
        try {
            method = cls.getMethod(str, clsArr);
        } catch (SecurityException e) {
        } catch (NoSuchMethodException e2) {
        }
        return method;
    }

    aws() {
    }

    public boolean DW() {
        return true;
    }

    public boolean j6(File file) {
        try {
            return ((Boolean) DW.invoke(file, null)).booleanValue();
        } catch (Throwable e) {
            throw new Error(e);
        } catch (Throwable e2) {
            throw new Error(e2);
        } catch (Throwable e22) {
            throw new Error(e22);
        }
    }

    public boolean j6(File file, boolean z) {
        try {
            return ((Boolean) FH.invoke(file, new Object[]{Boolean.valueOf(z)})).booleanValue();
        } catch (Throwable e) {
            throw new Error(e);
        } catch (Throwable e2) {
            throw new Error(e2);
        } catch (Throwable e22) {
            throw new Error(e22);
        }
    }

    public boolean Hw() {
        return false;
    }
}
