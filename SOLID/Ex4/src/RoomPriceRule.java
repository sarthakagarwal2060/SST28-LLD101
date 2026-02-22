public interface RoomPriceRule {

    boolean supports(int roomType);

    double basePrice();
}