import java.sql.Time;
import java.util.concurrent.*;

public class ThreadMain {


    public static void main(String[] args){
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("匿名内部类Thread（Runnable）");
            }
        }).start();

        System.out.println("**********************************************************************");

        MyThread myThread = new MyThread();
        myThread.start();
        myThread.run();

        System.out.println("**********************************************************************");

        MyRunnable myRunnable = new MyRunnable();
        new Thread(myRunnable).start();
        myRunnable.run();

        System.out.println("**********************************************************************");

        MyCallable myCallable = new MyCallable();
        FutureTask<String> oneTask = new FutureTask<String>(myCallable);
        new Thread(oneTask).start();

        ExecutorService fixedThreadPool = Executors.newFixedThreadPool(3);

        //submit方法有多重参数版本，及支持callable也能够支持runnable接口类型.
        Future<String> future = fixedThreadPool.submit(myCallable);

        future.isDone(); //return true,false 无阻塞
        try {
            String str = future.get(); // return 返回值，阻塞直到该线程运行结束
            System.out.println(str);
        } catch (InterruptedException e1) {
            e1.printStackTrace();
        } catch (ExecutionException e1) {
            e1.printStackTrace();
        }finally {
            fixedThreadPool.shutdown();
        }

        System.out.println("**********************************************************************");


        ExecutorService cachedThreadPool = Executors.newCachedThreadPool();
        for(int i=0; i<10; i++){
            int index = i;
            /*Runnable runnable = new Runnable() {
                @Override
                public void run() {
                    System.out.println("index:" + index);
                }
            };*/
            MyRunnable runnable =  new MyRunnable();
            cachedThreadPool.execute(runnable);
        }

        //cachedThreadPool.shutdownNow();  //忽略等待队列，试图停止正在执行的任务

        cachedThreadPool.shutdown();   //等提交的等待队列和正在执行的任务执行完，停止

        try{
            //等所有已提交的任务（包括正在跑的和队列中等待的）执行完；
            //或者 等超时时间到了（timeout 和 TimeUnit设定的时间）；
            //或者 线程被中断，抛出InterruptedException
            cachedThreadPool.awaitTermination(2, TimeUnit.MINUTES);
        }catch (Exception e){
            e.printStackTrace();
        }

    }

}
