import java.nio.channels.spi.SelectorProvider;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Integer> recursos = new ArrayList<>();
        
        HiloConsumidor hc = new HiloConsumidor(recursos);
        HiloProveedor hp = new HiloProveedor(recursos);

        hc.start();
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        hp.start();
    }
}
