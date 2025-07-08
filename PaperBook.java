import java.time.LocalDate;

public class PaperBook extends Book implements Shippable {
    private int quantity;

    public PaperBook(String isbn, String author, double Price, LocalDate publishDate, String Title ,int quantity) {
        super(isbn, author, Price, publishDate, Title);
        if(quantity < 0) throw new IllegalArgumentException("Stock must be positive");
        this.quantity=quantity;
    }
    public int getStock(){
        return this.quantity;
    }

    @Override 
    public boolean isAvailable() {
        // TODO Auto-generated method stub
        return (quantity==0 ? false : true);
    }

    @Override
    public void reduceStock(int qty) {
        // TODO Auto-generated method stub
        if(this.quantity < qty || qty <= 0) throw new IllegalArgumentException("Not enough coppies of " + this.getTitle());

        this.quantity-=qty;
    }
}
