public abstract class NotificationSender {

    protected final AuditLog audit;

    protected NotificationSender(AuditLog audit) {
        this.audit = audit;
    }

    // Template method (final = cannot be changed by subclasses)
    public final void send(Notification n) {

        if (n == null) {
            System.out.println("ERROR: invalid notification");
            audit.add("invalid");
            return;
        }

        doSend(n);
    }

    protected abstract void doSend(Notification n);
}