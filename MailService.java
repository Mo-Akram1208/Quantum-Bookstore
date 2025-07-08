public class MailService {
    public static void send(EBook ebook, String email) {
      System.out.printf("Emailing \"%s\" (%s) to %s%n", ebook.getTitle(), ebook.getFiletype(), email);
    }
}