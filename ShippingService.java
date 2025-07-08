public class ShippingService {
    public static void send(PaperBook book, int qty, String address) {
      System.out.printf("Shipping %d copies of \"%s\" to %s%n", qty, book.getTitle(), address);
    }
}