package factory;

/**
 * Created by a542901 on 14/06/2018.
 */
public class FactoryB implements Factory {

    @Override
    public Tv produceTV() {
        return new Sony();
    }

    @Override
    public Car produceCar() {
        return new BMW();
    }

    public static void main(String[] args) {
        Factory factory = new FactoryA();
        factory.produceCar();
        factory.produceTV();
    }
}
