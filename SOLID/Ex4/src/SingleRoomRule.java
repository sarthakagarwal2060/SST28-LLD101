public class SingleRoomRule implements RoomPriceRule {

    public boolean supports(int t) {
        return t == LegacyRoomTypes.SINGLE;
    }

    public double basePrice() {
        return 14000.0;
    }
}