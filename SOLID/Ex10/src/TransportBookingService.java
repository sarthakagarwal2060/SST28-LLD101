public class TransportBookingService {
    // DIP violation: direct concretes
    private final DistanceService distance;
    private final DriverService driverAllocator;
    private final PaymentService payment;
    private final PricingPolicy pricing;

    public TransportBookingService(
            DistanceService distance,
            DriverService driverAllocator,
            PaymentService payment,
            PricingPolicy pricing) {

        this.distance = distance;
        this.driverAllocator = driverAllocator;
        this.payment = payment;
        this.pricing = pricing;
    }
    public void book(TripRequest req) {

        double km = distance.km(req.from, req.to);
        System.out.println("DistanceKm=" + km);

        String driver = driverAllocator.allocate(req.studentId);
        System.out.println("Driver=" + driver);

        double fare = pricing.fare(km);

        String txn = payment.charge(req.studentId, fare);
        System.out.println("Payment=PAID txn=" + txn);

        BookingReceipt r = new BookingReceipt("R-501", fare);
        System.out.println("RECEIPT: " + r.id + " | fare=" + String.format("%.2f", r.fare));
    }
}
