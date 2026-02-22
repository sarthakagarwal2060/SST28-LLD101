public class GymAddonRule implements AddOnRule {

    public double apply(BookingRequest req) {

        return req.addOns.contains(AddOn.GYM)
                ? 300.0
                : 0.0;
    }
}