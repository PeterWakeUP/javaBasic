/**
 * 单例模式，静态内部类
 */
public class SingleStaticIn {

    private SingleStaticIn(){}

    public static class In{
        public final static SingleStaticIn instance = new SingleStaticIn();
    }

    public static SingleStaticIn getInStance(){
        return In.instance;
    }
}
