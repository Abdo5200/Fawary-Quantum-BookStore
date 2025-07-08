public class EBook extends Book {
    private double price;
    private FileType fileType;
    private static final double TAX = 0.1;

    public EBook(String isbn, String title, int yearOfPublish, String author, double price, FileType fileType) {
        super(isbn, title, yearOfPublish, author);
        if (price < 0)
            throw new RuntimeException("Price can not be negative");
        if (fileType == null)
            throw new RuntimeException("File type can not be null");
        this.price = price;
        this.fileType = fileType;
    }

    @Override
    public String getId() {
        return this.getISBN();
    }

    @Override
    public double buy(int quantity, String userEmail) {
        if (!Inventory.existInInventory(this.getISBN()))
            throw new RuntimeException("The book with the specified ISBN does not exist in the inventory");
        double amount = (this.price * quantity) * (1 + TAX);
        MailService.sendMail(this, userEmail);
        return amount;
    }

}
