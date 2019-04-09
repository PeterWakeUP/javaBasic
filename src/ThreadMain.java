import java.sql.Time;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ThreadMain {


    public static void main(String[] args){
        /*new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("匿名内部类Thread（Runnable）");
            }
        }).start();*/

        /*MyThread myThread = new MyThread();
        myThread.start();
        myThread.run();*/


        /*MyRunnable myRunnable = new MyRunnable();
        myRunnable.run();
        new Thread(myRunnable).start();*/


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
