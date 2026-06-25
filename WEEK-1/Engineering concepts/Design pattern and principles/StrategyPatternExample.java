public class StrategyPatternExample {
    interface PaymentStrategy {
        void pay(double amount);
    }

    static class CreditCardStrategy implements PaymentStrategy {
        public void pay(double amount) {
            System.out.println("Paid " + amount + " using Credit Card.");
        }
    }

    static class PayPalStrategy implements PaymentStrategy {
        public void pay(double amount) {
            System.out.println("Paid " + amount + " using PayPal.");
        }
    }

    static class PaymentContext {
        private PaymentStrategy strategy;

        public PaymentContext(PaymentStrategy strategy) {
            this.strategy = strategy;
        }

        public void setStrategy(PaymentStrategy strategy) {
            this.strategy = strategy;
        }

        public void executePayment(double amount) {
            strategy.pay(amount);
        }
    }

    public static void main(String[] args) {
        PaymentContext context = new PaymentContext(new CreditCardStrategy());
        context.executePayment(75.00);

        context.setStrategy(new PayPalStrategy());
        context.executePayment(42.50);
    }
}