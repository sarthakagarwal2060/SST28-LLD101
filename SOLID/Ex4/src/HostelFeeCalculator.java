import java.util.*;
public class HostelFeeCalculator {

    private final List<RoomPriceRule> roomRules;
    private final List<AddOnRule> addOnRules;
    private final FakeBookingRepo repo;
    private final ReceiptPrinterService printer;
    private final BookingIdGenerator idGen;

    public HostelFeeCalculator(
            List<RoomPriceRule> roomRules,
            List<AddOnRule> addOnRules,
            FakeBookingRepo repo, ReceiptPrinterService printer,
            BookingIdGenerator idGen) {
        this.roomRules = roomRules;
        this.addOnRules = addOnRules;
        this.repo = repo;
        this.printer = printer;
        this.idGen = idGen;
    }

    public void process(BookingRequest req) {

        double base = 0;

        for (RoomPriceRule r : roomRules) {
            if (r.supports(req.roomType)) {
                base = r.basePrice();
                break;
            }
        }

        double addOns = 0;

        for (AddOnRule a : addOnRules) {
            addOns += a.apply(req);
        }

        double total = base + addOns;

        Money monthly = new Money(total);
        Money deposit = new Money(5000);

        printer.print(req, monthly, deposit);
        String bookingId = idGen.next();

        repo.save(bookingId, req, monthly, deposit);
    }
}