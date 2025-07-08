public class MainStart {
    public static void main(String[] args) {
        Inventory inventory = new Inventory();

        // Add books
        PaperBook paperBook = new PaperBook("123", "Java Basics", 2010, "Alice", 10, 50.0);
        EBook eBook = new EBook("456", "AI for All", 2015, "Bob", 30.0, FileType.PDF);
        DemoBook demoBook = new DemoBook("789", "Sample Book", 1960, "Carol");

        inventory.add(paperBook);
        inventory.add(eBook);
        inventory.add(demoBook);

        // Buy PaperBook
        try {
            double paid = paperBook.buy(2, "123 Main St");
            System.out.printf("Bought 2 PaperBooks, paid: %.2f\n", paid);
        } catch (Exception e) {
            System.out.println("Error buying PaperBook: " + e.getMessage());
        }

        // Buy EBook
        try {
            double paid = eBook.buy(1, "user@email.com");
            System.out.printf("Bought 1 EBook, paid: %.2f\n", paid);
        } catch (Exception e) {
            System.out.println("Error buying EBook: " + e.getMessage());
        }

        // Try to buy DemoBook
        try {
            demoBook.buy(1, "irrelevant");
        } catch (Exception e) {
            System.out.println("Error buying DemoBook (expected): " + e.getMessage());
        }

        // Remove outdated books
        System.out.println("Outdated books removed:");
        for (Book b : inventory.removeAndGetOutdatedBooks()) {
            System.out.println("Removed: " + b.getTitle() + " (" + b.getYearOfPublish() + ")");
        }
    }
}
