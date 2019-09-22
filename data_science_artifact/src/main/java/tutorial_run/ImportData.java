package tutorial_run;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
// import java.sql.Connection;
// import java.sql.DriverManager;
// import java.sql.ResultSet;
// import java.sql.SQLException;
// import java.sql.Statement;

import tech.tablesaw.api.Table;

public class ImportData{

    public static void main(String[] args)throws IOException   {
        //Table data = LoadFromLocal("C:/Users/Lee/Documents/JavaProjects/Data/storedata-cleaned.csv");

        //Table localDataStructure = data.structure();
        //System.out.print(localDataStructure);

        Table dataFromURI = LoadFromAPI("https://raw.githubusercontent.com/jtablesaw/tablesaw/master/data/bush.csv");
        
        Table structure = dataFromURI.structure();

        // Table structure = FromDB("jdbc:mysql://google/store_data?cloudSqlInstance=store-data$socketFactory=com.google.cloud.sql.mysql.SocketFactory$useSSL-false$user=root&password=lee-only").structure();
         System.out.print(structure);
    }

    static Table LoadFromLocal(String path) throws IOException {
        Table data = Table.read().csv(path);
        return data; 
    }

    static Table LoadFromAPI(String path) throws IOException {
        Table data;
        try(InputStream input = new URL(path).openStream()) {
            data = Table.read().csv(input, "bush");
        }
        return data;
    }

    // static Table FromDB(String DBurl) throws IOException {
    //     //try to establish connection
    //     Connection conn = null;
    //     try {
    //         conn = DriverManager.getConnection(DBurl, "root", "lee-only");
    //     } catch (SQLException e) {
    //         e.printStackTrace();
    //     }

    //     Table DBdates = null;
    //     try (Statement myStatement = conn.createStatement()) {
    //         String sql = "SELECT * FROM dates";
    //         try (ResultSet results = myStatement.executeQuery(sql)) {
    //             DBdates = Table.read().db(results, "dates");
    //         }
    //     } catch (SQLException e) {
    //         e.printStackTrace();
    //     }

    //     return DBdates;
    // }

}