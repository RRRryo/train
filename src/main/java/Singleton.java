/**
 * Created by Administrator on 6/13/2018.
 */
public enum Singleton {
    INSTANCE;

    public void job1() {
        System.out.print("do the job1");
    }

    public static void main(String[] args) {
        Singleton.INSTANCE.job1();
    }
}
