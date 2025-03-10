package asynchronize.testandset;

public class Lock {
    private boolean lock;

    public Lock(Boolean lock) {
        this.lock = lock;
    }

    public void setLock(boolean lock) {
        this.lock = lock;
    }

    public boolean isLock() {
        return lock;
    }
}
