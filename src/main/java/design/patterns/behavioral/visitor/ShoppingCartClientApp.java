package design.patterns.behavioral.visitor;

public class ShoppingCartClientApp {
    public static void main(String[] args) {
        ItemElement[] items = new ItemElement[]{
          new Book(20, "The So and So"),
                new Book(100, "Bla in Bla and Bla"),
                new Fruit(10, 2, "Banana"),
                new Fruit(50, 3, "Apple"),
        };
        int total = calculatePrice(items);
    }

    private static int calculatePrice(ItemElement[] items) {
        ShoppingCartVisitor visitor = new ShoppingCartVisitorImpl();
        int sum = 0;
        for (ItemElement item : items) {
            sum = sum + item.accept(visitor);
        }
        return sum;
    }
}
