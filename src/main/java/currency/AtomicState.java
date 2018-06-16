package currency;

/**
 * Created by Administrator on 6/16/2018.
 */
public class AtomicState {
    private Integer state = 0;

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public void print(String letter, int num) {
        int i = 0;
        while (i < 200) {

            if (this.getState() % 3 == num) {
                System.out.print(letter);
                this.setState(this.getState() + 1);
                i++;
            }
        }

    }
}
