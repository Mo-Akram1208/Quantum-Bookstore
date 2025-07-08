import java.time.LocalDate;
import java.util.List;


public class QuantumBookstoreFullTest {
    public static void main(String[] args) {
        BookStore store = new BookStore();

        // 1. Add books
        store.addBook(new PaperBook("ISBN001", "Alice Author", 15.0, LocalDate.of(2010,1,1), "Paper Adventures", 3));
        store.addBook(new EBook("ISBN002", "Bob Writer",   9.99, LocalDate.of(2020,5,15), "Digital Tales", "pdf"));
        store.addBook(new Showcase("ISBN003", "Carol Curator", 0.0, LocalDate.of(2000,7,7), "Ancient Showcase"));    
        
        // 2. Remove outdated (>20 years)
        List<Book> outdated = store.removeOutdated(20);
        System.out.println("Removed outdated:");
        outdated.forEach(b -> System.out.println(" * " + b.getTitle()));

        // 3. Buy tests
        System.out.println("\n-- Purchase tests --");
        double paperCost = store.buy("ISBN001", 2, null, "123 Main St");
        double ebookCost = store.buy("ISBN002", 1, "test@example.com", null);
        System.out.printf("Costs: paper=$%.2f, ebook=$%.2f%n", paperCost, ebookCost);

        // 4. Error scenarios
        System.out.println("\n-- Error tests --");
        try { store.buy("ISBN001", 10, null, "123 Main St"); } catch (Exception e) { System.out.println(e.getMessage()); }
        try { store.buy("ISBN002", 2, "test@example.com", null); } catch (Exception e) { System.out.println(e.getMessage()); }
        try { store.buy("ISBN004", 1, null, null); } catch (Exception e) { System.out.println(e.getMessage()); }
        try { store.buy("ISBN003", 1, null, null); } catch (Exception e) { System.out.println(e.getMessage()); }

        // Final inventory state
        System.out.println("\nFinal inventory:");
        store.listInventory();
    }
}