public class DemoBook extends Book {
    public DemoBook(String isbn, String title, int yearOfPublish, String author) {
        super(isbn, title, yearOfPublish, author);
    }

    @Override
    public double buy(int quantity, String contactInfo) {
        throw new RuntimeException("Demo books can not be bought");
    }

    @Override
    public String getId() {
        return this.getISBN();
    }
}
