public class DoubleRoomRule implements RoomPriceRule {

    public boolean supports(int t) {
        return t == LegacyRoomTypes.DOUBLE;
    }

    public double basePrice() {
        return 15000.0;
    }
}