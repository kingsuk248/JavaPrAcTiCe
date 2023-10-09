package design.patterns.structural.fascade;

import java.sql.Connection;

public class MySqlHelper {

    public static Connection getMySqlDBConnection() {
        System.out.println("MySql Connection");
        return null;
    }

    public void generateMySqlPdfReport(String tableName, Connection conn) {
        System.out.println("Generating MySql PDF report");
    }

    public void generateMySqlHtmlReport(String tableName, Connection conn) {
        System.out.println("Generating MySql Html report");
    }
}
