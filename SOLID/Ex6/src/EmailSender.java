public class EmailSender extends NotificationSender {

    public EmailSender(AuditLog audit) {
        super(audit);
    }

    @Override
    protected void doSend(Notification n) {

        if (n.email == null || n.body == null) {
            System.out.println("EMAIL ERROR: invalid notification");
            audit.add("email error");
            return;
        }

        // No truncation → preserve meaning
        System.out.println(
                "EMAIL -> to=" + n.email +
                        " subject=" + n.subject +
                        " body=" + n.body);

        audit.add("email sent");
    }
}