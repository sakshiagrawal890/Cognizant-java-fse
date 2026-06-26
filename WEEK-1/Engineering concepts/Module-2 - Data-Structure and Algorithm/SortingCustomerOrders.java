import java.util.Arrays;

public class SortingCustomerOrders {
    static class Order {
        int id;
        double totalPrice;

        Order(int id, double totalPrice) {
            this.id = id;
            this.totalPrice = totalPrice;
        }

        @Override
        public String toString() {
            return "Order " + id + " -> $" + totalPrice;
        }
    }

    public static void mergeSort(Order[] orders, int left, int right) {
        if (left < right) {
            int mid = left + (right - left) / 2;
            mergeSort(orders, left, mid);
            mergeSort(orders, mid + 1, right);
            merge(orders, left, mid, right);
        }
    }

    private static void merge(Order[] orders, int left, int mid, int right) {
        int n1 = mid - left + 1;
        int n2 = right - mid;

        Order[] leftArray = Arrays.copyOfRange(orders, left, mid + 1);
        Order[] rightArray = Arrays.copyOfRange(orders, mid + 1, right + 1);

        int i = 0, j = 0, k = left;
        while (i < n1 && j < n2) {
            if (leftArray[i].totalPrice <= rightArray[j].totalPrice) {
                orders[k++] = leftArray[i++];
            } else {
                orders[k++] = rightArray[j++];
            }
        }

        while (i < n1) {
            orders[k++] = leftArray[i++];
        }

        while (j < n2) {
            orders[k++] = rightArray[j++];
        }
    }

    public static void main(String[] args) {
        Order[] orders = {
                new Order(101, 250.75),
                new Order(102, 90.50),
                new Order(103, 320.00),
                new Order(104, 150.25)
        };

        mergeSort(orders, 0, orders.length - 1);

        System.out.println("Sorted orders by total price:");
        for (Order order : orders) {
            System.out.println(order);
        }
    }
}
