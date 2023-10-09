package design.patterns.creational.prototype;

import java.util.ArrayList;
import java.util.List;

public class TechStack implements Cloneable {

    private final List<String> techList;

    public List<String> getTechList() {
        return techList;
    }

    public TechStack() {
        this.techList = new ArrayList<>();
    }

    public TechStack(List<String> techList) {
        this.techList = techList;
    }

    public void loadTechStack() {
        this.techList.add("Java");
        this.techList.add("Spark");
        this.techList.add("Kafka");
        this.techList.add("SQL");
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        List<String> clonedStack = new ArrayList<>();
        clonedStack.addAll(techList);
        return new TechStack(clonedStack);
    }
}
