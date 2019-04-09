public class Sync {

    public synchronized void talk(){
        System.out.println("jkl");
    }

    public void say(){
        System.out.println("jkl");
        synchronized (Sync.class){
            System.out.println("jkljjkl");
        }
    }
}
