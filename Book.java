import java.time.LocalDate;

public abstract class Book implements Product {
    private int yearOfPublish;
    private String ISBN, title, author;

    public Book(String isbn, String title, int yearOfPublish, String author) {
        if (yearOfPublish > LocalDate.now().getYear())
            throw new RuntimeException("Year of publish can not be in the future");
        if (title.isBlank() || isbn.isBlank())
            throw new RuntimeException("Book title or ISBN have to contain letters");
        if (author.isBlank())
            throw new RuntimeException("Author have to contain letters");

        this.ISBN = isbn;
        this.title = title;
        this.yearOfPublish = yearOfPublish;
        this.author = author;
    }

    public boolean isOutDated() {
        return LocalDate.now().getYear() - getYearOfPublish() > 30;
    }

    public int getYearOfPublish() {
        return this.yearOfPublish;
    }

    public void setYearOfPublish(int yearOfPublish) {
        if (yearOfPublish > LocalDate.now().getYear())
            throw new RuntimeException("Year of publish can not be in the future");
        this.yearOfPublish = yearOfPublish;
    }

    public String getISBN() {
        return this.ISBN;
    }

    public String getTitle() {
        return this.title;
    }

    public String getAuthor() {
        return this.author;
    }
}
