package design.patterns.behavioral.visitor;

public interface ShoppingCartVisitor {
    int visit(Book book);
    int visit(Fruit fruit);
}
