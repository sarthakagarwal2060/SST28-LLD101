public class DeluxeRoomRule implements RoomPriceRule {

    public boolean supports(int t) {
        return true;
    }

    public double basePrice() {
        return 16000.0;
    }
}