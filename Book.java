import java.time.LocalDate;

public abstract class Book{
    private final String isbn;
    // private int quantity;
    private final double Price;
    private final LocalDate publishDate;
    private final String Title;
    private final String author;

    public Book(String isbn, String author, double Price, LocalDate publishDate, String Title) {
        if (isbn == null || isbn.isBlank()) throw new IllegalArgumentException("ISBN must be provided");
        if (author == null || author.isBlank()) throw new IllegalArgumentException("Author must be provided");
        if (Price < 0) throw new IllegalArgumentException("Price must be non-negative");
        if (publishDate == null) throw new IllegalArgumentException("Publish date must be provided");
        if (Title == null || Title.isBlank()) throw new IllegalArgumentException("Title must be provided");
        
        this.isbn = isbn;
        this.author = author;
        this.Price = Price;
        this.publishDate = publishDate;
        this.Title = Title;
    }

    public String getAuthor() {
        return this.author;
    }

    public String getIsbn() {
        return this.isbn;
    }

    public double getPrice() {
        return this.Price;
    }

    public LocalDate getPublishDate() {
        return this.publishDate;
    }

    public String getTitle() {
        return this.Title;
    }

    public boolean isOutdated(int yearsInserted){
        int currentYear = java.time.LocalDate.now().getYear();
        return (currentYear - publishDate.getYear()) > yearsInserted;
    }

    // public abstract void Buy();
} 