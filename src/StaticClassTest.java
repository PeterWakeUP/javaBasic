public class StaticClassTest {

    private static String jkl;

    private String str;

    static {
        System.out.println("StaticClassTest_static");
    }

    {
        System.out.println("StaticClassTest");
    }


    class Test{
        {
            System.out.println("草泥马");
        }

        public String ii;

        public String getIi() {
            return ii;
        }

        public void setIi(String ii) {
            this.ii = ii;
        }
    }


    //静态内部类是要调用的时候才加载的，就是和普通内部类不一样的，new时可以——new 主类.静态内部类（），当然这是在public下，private 是不行的
    public static class StaTest{

        public String i;

        static {
            System.out.println("staTest（）执行_static");
        }
        {
            System.out.println("staTest（）执行");
        }

        public String getI() {
            return i;
        }

        public void setI(String i) {
            this.i = i;
        }
    }


    public static void main(String[] args){
        System.out.println("main()");
        StaTest test1 = new StaticClassTest.StaTest();
        StaTest test2 = new StaticClassTest.StaTest();
        test1.setI("2");
        System.out.println(test1.getI());
        System.out.println(test2.getI());
        System.out.println("**********************");
        test2.setI("3");
        System.out.println(test1.getI());
        System.out.println(test2.getI());
        System.out.println("**********************");

        StaticClassTest test = new StaticClassTest();
    }
}