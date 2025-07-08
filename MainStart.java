public class MainStart {
    public static void main(String[] args) {
        PaperBook HeadFirstJava = new PaperBook("ABC", "Head First Java", 2003, "Ahmed", 100, 79.99);
        EBook AtomicHabits = new EBook("AHG", "Atomic Habits", 2010, "Mohamed", 99.99, FileType.PDF);
        DemoBook DesignPatternDemo = new DemoBook("PSA", "Design Patterns", 1960, "Abdo");
        Inventory inventory = new Inventory();
        inventory.add(AtomicHabits);
        inventory.add(HeadFirstJava);
        inventory.add(DesignPatternDemo);
        System.out.println(inventory.getBooks());
        System.out.println(inventory.removeAndGetOutdatedBooks());
        System.out.println(inventory.getBooks());
        HeadFirstJava.buy(100, "123 Main St, Anytown, USA");
        System.out.println(inventory.getBooks());

    }
}
