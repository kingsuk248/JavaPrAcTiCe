package design.patterns.behavioral.template;

public class HousingClient {
    public static void main(String[] args) {
        HouseTemplate house = new GlassHouse();
        house.buildHouse();
        System.out.println("***********");
        house = new WoodenHouse();
        house.buildHouse();
    }
}
