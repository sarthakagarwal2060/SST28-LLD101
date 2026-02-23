public class SmsSender extends NotificationSender {

    public SmsSender(AuditLog audit) {
        super(audit);
    }

    @Override
    protected void doSend(Notification n) {

        if (n.phone == null || n.body == null) {
            System.out.println("SMS ERROR: invalid notification");
            audit.add("sms error");
            return;
        }

        System.out.println(
                "SMS -> to=" + n.phone +
                        " body=" + n.body);

        audit.add("sms sent");
    }
}