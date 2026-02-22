public class LaundryAddonRule implements AddOnRule {

    public double apply(BookingRequest req) {

        return req.addOns.contains(AddOn.LAUNDRY)
                ? 500.0
                : 0.0;
    }
}