public class DecoratorPatternExample {
    interface Notification {
        void send(String message);
    }

    static class EmailNotification implements Notification {
        public void send(String message) {
            System.out.println("Email: " + message);
        }
    }

    static class NotificationDecorator implements Notification {
        protected final Notification wrapped;

        public NotificationDecorator(Notification wrapped) {
            this.wrapped = wrapped;
        }

        public void send(String message) {
            wrapped.send(message);
        }
    }

    static class SmsDecorator extends NotificationDecorator {
        public SmsDecorator(Notification wrapped) {
            super(wrapped);
        }

        @Override
        public void send(String message) {
            super.send(message);
            System.out.println("SMS: " + message);
        }
    }

    static class PushNotificationDecorator extends NotificationDecorator {
        public PushNotificationDecorator(Notification wrapped) {
            super(wrapped);
        }

        @Override
        public void send(String message) {
            super.send(message);
            System.out.println("Push notification: " + message);
        }
    }

    public static void main(String[] args) {
        Notification notification = new EmailNotification();
        Notification smsAndEmail = new SmsDecorator(notification);
        Notification fullNotifier = new PushNotificationDecorator(smsAndEmail);

        fullNotifier.send("Your order has shipped.");
    }
}