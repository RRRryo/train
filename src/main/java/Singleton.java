/**
 * Created by Administrator on 6/13/2018.
 */
public enum Singleton {
    INSTANCE;

    //是我们要应用单例模式的资源，具体可以表现为网络连接，数据库连接，线程池等等
    private Object resource;

    Singleton() {
        //init method here
        System.out.println("init method");

    }

    public void job1() {
        System.out.print("do the job1");
    }

    public Object getResource() {
        return resource;
    }

    public static void main(String[] args) {
        Singleton.INSTANCE.job1();
    }
}
