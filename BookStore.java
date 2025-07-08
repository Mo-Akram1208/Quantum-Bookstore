import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BookStore{
    private final Map<String,Book> inventory = new HashMap<>();

    public void addBook(Book booky){
        if(inventory.containsKey(booky.getIsbn())) throw new IllegalArgumentException("Book with ISBN " + booky.getIsbn() + " already exists.");

        inventory.put(booky.getIsbn(), booky);
    }

    public List<Book> removeOutdated(int threshold){
        List<Book>listy = new ArrayList<>();
        for(Book b : new ArrayList<>(inventory.values())){
            if(b.isOutdated(threshold)){
                listy.add(b);
                inventory.remove(b.getIsbn());
            }
        }
        return listy;
    }
    public double buy(String isbn, int qty, String email, String address) {
        Book b = inventory.get(isbn);
        if (b == null) throw new BookNotFoundException(isbn);

        if (b instanceof PaperBook pb) {
            pb.reduceStock(qty);
            ShippingService.send(pb, qty, address);
            return pb.getPrice() * qty;

        } else if (b instanceof EBook eb) {
            if (qty != 1)
                throw new IllegalArgumentException("EBook purchases must have quantity = 1 ");
            MailService.send(eb, email);
            return eb.getPrice();

        } else if (b instanceof Showcase) {
            throw new UnsupportedOperationException("Cannot purchase showcase book: " + b.getTitle());

        } else {
            throw new UnsupportedOperationException("Unsupported book type: " + b.getClass().getSimpleName());
        }
    }

    // For demo/testing
    public void listInventory() {
        System.out.println("Current inventory:");
        for (Book b : inventory.values()) {
            System.out.println(" - " + b.getTitle() + " (" + b.getIsbn() + ")");
        }
    }
}
