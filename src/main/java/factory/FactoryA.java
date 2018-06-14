package factory;

/**
 * Created by a542901 on 14/06/2018.
 */
public class FactoryA implements Factory {
    @Override
    public Tv produceTV() {
        return new LeTv();
    }

    @Override
    public Car produceCar() {
        return new Audi();
    }
}
