import java.util.*;

public class Demo04 {
    public static void main(String[] args) {
        System.out.println("=== Hostel Fee Calculator ===");
        BookingRequest req = new BookingRequest(LegacyRoomTypes.DOUBLE, List.of(AddOn.LAUNDRY, AddOn.MESS));
        List<RoomPriceRule> roomRules = List.of(
                new SingleRoomRule(),
                new DoubleRoomRule(),
                new TripleRoomRule(),
                new DeluxeRoomRule());

        List<AddOnRule> addOnRules = List.of(
                new MessAddonRule(),
                new LaundryAddonRule(),
                new GymAddonRule());

        HostelFeeCalculator calc = new HostelFeeCalculator(roomRules, addOnRules, new FakeBookingRepo(),
                new ReceiptPrinterService(), new BookingIdGenerator());
        // HostelFeeCalculator calc = new HostelFeeCalculator(new FakeBookingRepo());
        calc.process(req);
    }
}
