package currency;

/**
 * Created by Administrator on 6/13/2018.
 */
public enum EnumLetterNumber {

    A(0),
    B(1),
    C(2);

    private Integer value;

    EnumLetterNumber(Integer value) {
        this.value = value;
    }


    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }
}
