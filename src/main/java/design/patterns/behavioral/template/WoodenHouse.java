package design.patterns.behavioral.template;

public class WoodenHouse extends HouseTemplate {
    @Override
    public void buildPillars() {
        System.out.println("Building wooden pillars ...");
    }

    @Override
    public void buildWalls() {
        System.out.println("Building wooden walls ... ");
    }
}
