public class AdapterPatternExample {
    interface PaymentGateway {
        void pay(double amount);
    }

    static class StripeGateway {
        public void makePayment(double amount) {
            System.out.println("Stripe payment processed: $" + amount);
        }
    }

    static class PayPalGateway {
        public void sendPayment(double amount) {
            System.out.println("PayPal payment processed: $" + amount);
        }
    }

    static class StripeAdapter implements PaymentGateway {
        private final StripeGateway stripe;

        public StripeAdapter(StripeGateway stripe) {
            this.stripe = stripe;
        }

        public void pay(double amount) {
            stripe.makePayment(amount);
        }
    }

    static class PayPalAdapter implements PaymentGateway {
        private final PayPalGateway payPal;

        public PayPalAdapter(PayPalGateway payPal) {
            this.payPal = payPal;
        }

        public void pay(double amount) {
            payPal.sendPayment(amount);
        }
    }

    public static void main(String[] args) {
        PaymentGateway stripe = new StripeAdapter(new StripeGateway());
        PaymentGateway paypal = new PayPalAdapter(new PayPalGateway());

        stripe.pay(125.00);
        paypal.pay(89.50);
    }
}