package design.patterns.creational.prototype;

public class TechStackApp {
    public static void main(String[] args) throws CloneNotSupportedException {
        TechStack techStack1 = new TechStack();
        techStack1.loadTechStack();
        TechStack techStack2 = (TechStack) techStack1.clone();
        TechStack techStack3 = (TechStack) techStack1.clone();
        techStack2.getTechList().add("AWS");
        techStack3.getTechList().remove("SQL");
        techStack2.getTechList().add("Cassandra");

        System.out.println(techStack1.getTechList());
        System.out.println(techStack2.getTechList());
        System.out.println(techStack3.getTechList());
    }
}
