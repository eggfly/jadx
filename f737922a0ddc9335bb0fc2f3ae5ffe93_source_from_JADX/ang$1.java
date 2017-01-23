import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

class ang$1 implements ThreadFactory {
    private final ThreadFactory j6;

    ang$1() {
        this.j6 = Executors.defaultThreadFactory();
    }

    public Thread newThread(Runnable runnable) {
        Thread newThread = this.j6.newThread(runnable);
        newThread.setName("JGit-AlarmQueue");
        newThread.setDaemon(true);
        return newThread;
    }
}
