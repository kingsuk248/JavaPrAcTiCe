package design.patterns.behavioral.template;

public class GlassHouse extends HouseTemplate{
    @Override
    public void buildPillars() {
        System.out.println("Building glass pillars ...");
    }

    @Override
    public void buildWalls() {
        System.out.println("Building glass walls ... ");
    }
}
