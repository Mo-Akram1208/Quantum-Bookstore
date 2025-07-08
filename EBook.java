import java.time.LocalDate;

public class EBook extends Book implements Emailable{
    public final String fileType; 

    public EBook(String isbn, String author, double Price, LocalDate publishDate, String Title ,String fileType) {
        super(isbn, author, Price, publishDate, Title);
        if (fileType == null || fileType.isBlank()) throw new IllegalArgumentException("File type must be provided");
        this.fileType=fileType;
    }

    @Override
    public String getFiletype() {
        // TODO Auto-generated method stub
        return this.fileType;
    }
}
