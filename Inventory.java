import java.util.*;

public class Inventory {
    private static Map<String, Product> books;

    public Inventory() {
        books = new HashMap<>();
    }

    public void add(Product product) {
        books.put(product.getId(), product);
    }

    public List<Book> removeAndGetOutdatedBooks() {
        List<Book> outDated = new ArrayList<>();
        List<String> idsToRemove = new ArrayList<>();
        for (Product product : books.values()) {
            if (product instanceof Book) {
                Book book = (Book) product;
                if (book.isOutDated()) {
                    outDated.add(book);
                    idsToRemove.add(book.getISBN());
                }
            }
        }
        for (String id : idsToRemove) {
            books.remove(id);
        }
        return outDated;
    }

    public static boolean existInInventory(String id) {
        return books.containsKey(id);
    }

    public List<Product> getBooks() {
        return new ArrayList<>(books.values());
    }
}
