package design.patterns.behavioral.template;

public abstract class HouseTemplate {

    // Template method declared 'final' so that subclass cannot override the order of execution
    public final void buildHouse() {
        buildFoundation();
        buildPillars();
        buildWalls();
        buildWindows();
        System.out.println("House has been built !");
    }

    private void buildFoundation() {
        System.out.println("Building foundation ...");
    }

    public abstract void buildPillars();

    public abstract void buildWalls();

    private void buildWindows() {
        System.out.println("Building windows ...");
    }
}
