import java.util.*;

public class BookingIdGenerator {

    private final Random rand = new Random(1);

    public String next() {
        return "H-" + (7000 + rand.nextInt(1000));
    }
}