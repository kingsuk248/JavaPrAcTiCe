package design.patterns.structural.fascade;

import design.patterns.structural.fascade.HelperFascade.*;

public class FascadePatternTest {
    public static void main(String[] args) {
        HelperFascade.generateReport(DBType.MySql, ReportType.HTML, "employees");
        HelperFascade.generateReport(DBType.Oracle, ReportType.PDF, "salary");
    }
}
