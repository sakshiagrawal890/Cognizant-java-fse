import java.util.ArrayList;
import java.util.List;

public class ObserverPatternExample {
    interface Subject {
        void registerObserver(Observer observer);
        void removeObserver(Observer observer);
        void notifyObservers();
    }

    interface Observer {
        void update(double price);
    }

    static class StockMarket implements Subject {
        private final List<Observer> observers = new ArrayList<>();
        private double stockPrice;

        public void setStockPrice(double stockPrice) {
            this.stockPrice = stockPrice;
            notifyObservers();
        }

        public void registerObserver(Observer observer) {
            observers.add(observer);
        }

        public void removeObserver(Observer observer) {
            observers.remove(observer);
        }

        public void notifyObservers() {
            for (Observer observer : observers) {
                observer.update(stockPrice);
            }
        }
    }

    static class Investor implements Observer {
        private final String name;

        public Investor(String name) {
            this.name = name;
        }

        public void update(double price) {
            System.out.println(name + " received stock price update: " + price);
        }
    }

    public static void main(String[] args) {
        StockMarket market = new StockMarket();
        Investor investorA = new Investor("Investor A");
        Investor investorB = new Investor("Investor B");

        market.registerObserver(investorA);
        market.registerObserver(investorB);

        market.setStockPrice(150.75);
        market.setStockPrice(155.20);
    }
}