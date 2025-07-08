public class PaperBook extends Book {
    private int stock;
    private double price;
    private static final double TAX = 0.1;

    public PaperBook(String isbn, String title, int yearOfPublish, String author, int stock, double price) {
        super(isbn, title, yearOfPublish, author);
        if (stock <= 0)
            throw new RuntimeException("Stock can not be less than or equal zero");
        if (price < 0)
            throw new RuntimeException("Price can not be negative");
        this.stock = stock;
        this.price = price;
    }

    public int getStock() {
        return this.stock;
    }

    public void reduceStock(int quantity) {
        if (quantity > getStock())
            throw new RuntimeException("the requested quantity can not be bigger than the stock");
        this.stock -= quantity;
    }

    @Override
    public String getId() {
        return this.getISBN();
    }

    @Override
    public double buy(int quantity, String userAddress) {
        if (!Inventory.existInInventory(this.getISBN()))
            throw new RuntimeException("The book with the specified ISBN does not exist in the inventory");
        reduceStock(quantity);
        double amount = (this.price * quantity) * (1 + TAX);
        ShippingService.ship(this, userAddress);
        return amount;
    }
}