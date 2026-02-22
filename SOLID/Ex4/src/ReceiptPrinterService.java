public class ReceiptPrinterService {

    public void print(BookingRequest req,
            Money monthly,
            Money deposit) {

        ReceiptPrinter.print(req, monthly, deposit);
    }
}