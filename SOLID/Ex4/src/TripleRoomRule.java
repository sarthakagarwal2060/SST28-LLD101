public class TripleRoomRule implements RoomPriceRule {

    public boolean supports(int t) {
        return t == LegacyRoomTypes.TRIPLE;
    }

    public double basePrice() {
        return 12000.0;
    }
}