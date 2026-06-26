public class EcommerceSearchFunction {
    public static int binarySearch(String[] products, String target) {
        int left = 0;
        int right = products.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            int comparison = products[mid].compareToIgnoreCase(target);

            if (comparison == 0) {
                return mid;
            } else if (comparison < 0) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        String[] products = {"Headphones", "Keyboard", "Laptop", "Monitor", "Mouse"};

        int result = binarySearch(products, "Laptop");
        if (result != -1) {
            System.out.println("Found at index: " + result);
        } else {
            System.out.println("Product not found");
        }
    }
}
