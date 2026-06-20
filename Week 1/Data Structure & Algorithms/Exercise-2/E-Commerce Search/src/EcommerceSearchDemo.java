public class EcommerceSearchDemo {

    public static void main(String[] args) {

        Product[] products = {
            new Product(101, "Laptop", "Electronics"),
            new Product(102, "Smartphone", "Electronics"),
            new Product(103, "Shoes", "Fashion"),
            new Product(104, "Watch", "Accessories"),
            new Product(105, "Headphones", "Electronics")
        };

        int targetId = 104;

        // Linear Search
        Product linearResult =
                LinearSearch.search(products, targetId);

        if (linearResult != null) {
            System.out.println("Linear Search Found:");
            System.out.println(linearResult);
        } else {
            System.out.println("Product not found.");
        }

        // Binary Search
        Product binaryResult =
                BinarySearch.search(products, targetId);

        if (binaryResult != null) {
            System.out.println("\nBinary Search Found:");
            System.out.println(binaryResult);
        } else {
            System.out.println("Product not found.");
        }
    }
}