package design.patterns.structural.fascade;

import java.sql.Connection;

public class HelperFascade {

    public static void generateReport(DBType dbType, ReportType reportType, String tableName) {
        Connection connection = null;
        switch (dbType) {
            case MySql:
                connection = MySqlHelper.getMySqlDBConnection();
                MySqlHelper helper = new MySqlHelper();
                switch (reportType) {
                    case PDF:
                        helper.generateMySqlPdfReport(tableName, connection);
                        break;
                    case HTML:
                        helper.generateMySqlHtmlReport(tableName, connection);
                        break;
                }
                break;
            case Oracle:
                connection = OracleHelper.getOracleDBConnection();
                OracleHelper ohelper = new OracleHelper();
                switch (reportType) {
                    case PDF:
                        ohelper.generateOraclePdfReport(tableName, connection);
                        break;
                    case HTML:
                        ohelper.generateOracleHtmlReport(tableName, connection);
                        break;
                }
        }


    }

    public enum DBType {
        MySql, Oracle
    }

    public enum ReportType {
        PDF, HTML
    }
}
