
public class LockSingleInstance {

    private LockSingleInstance() {}

    private static LockSingleInstance instance;

    public static LockSingleInstance getInstanceWithoutLock() {
        if (instance == null) {
            return new LockSingleInstance();
        }

        return instance;
    }

    public static synchronized LockSingleInstance getInstanceWithMethodLock() {
        if (instance == null) {
            return new LockSingleInstance();
        }

        return instance;
    }

    public LockSingleInstance getInstanceWithoutDoubleLock() {

        if (instance == null) {
            synchronized (LockSingleInstance.class) {
                if (instance == null) {
                    return new LockSingleInstance();
                }
            }
        }

        return instance;
    }


}