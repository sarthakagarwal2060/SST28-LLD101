public class MessAddonRule implements AddOnRule {

    public double apply(BookingRequest req) {

        return req.addOns.contains(AddOn.MESS)
                ? 1000.0
                : 0.0;
    }
}