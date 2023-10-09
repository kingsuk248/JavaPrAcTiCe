package design.patterns.behavioral.strategy;

public class ShoppingCartTest {
    public static void main(String[] args) {
        ShoppingCart shoppingCart = new ShoppingCart();
        Item item1 = new Item("Item 1", 1234);
        Item item2 = new Item("Item 2", 2468);
        shoppingCart.addItem(item1);
        shoppingCart.addItem(item2);

        shoppingCart.pay(new PaypalStrategy("john.doe@example.com", "a@hjka^&addnd"));
        shoppingCart.pay(new CreditCardStrategy("John Doe", "3465 4568 8797  8190", "345", "12/30"));
    }
}
