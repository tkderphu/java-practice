package concurrent.concurrent_map;

import java.util.Map;

public class Runner implements Runnable{

    private Map<String, String> map;

    public Runner(Map<String, String> map) {
        this.map = map;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread() + ": " +map.get("hello"));
    }
}
