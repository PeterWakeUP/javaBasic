import java.util.concurrent.Callable;

public class MyCallable<String> implements Callable<String> {

    @Override
    public String call() throws Exception {
        System.out.println("mycallable is running, name:" + Thread.currentThread().getName());
        String str = (String) "mycallable is running ok";
        return str;
    }
}