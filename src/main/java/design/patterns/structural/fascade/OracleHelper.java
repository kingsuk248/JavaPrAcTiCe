package design.patterns.structural.fascade;

import java.sql.Connection;

public class OracleHelper {

    public static Connection getOracleDBConnection() {
        System.out.println("Oracle Connection");
        return null;
    }

    public void generateOraclePdfReport(String tableName, Connection conn) {
        System.out.println("Generating Oracle PDF report");
    }

    public void generateOracleHtmlReport(String tableName, Connection conn) {
        System.out.println("Generating Oracle Html report");
    }
}
