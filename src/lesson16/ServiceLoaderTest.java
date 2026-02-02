package lesson16;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ServiceLoader;

public class ServiceLoaderTest {
    public static void main(String[] args) {
        try {
            ServiceLoader<Driver> loader = ServiceLoader.load(Driver.class);
            Driver driver = null;

            for (Driver d : loader) {
                System.err.println("Found: " + d.getClass().getName());
                if (d.acceptsURL("jdbc:postgresql://localhost:5432/postgres")) {
                    driver = d;
                    break;
                }
            }

            if (driver == null) {
                System.err.println("Driver not found");
                return;
            }

            DriverManager.registerDriver(driver);

            String url = "jdbc:postgresql://localhost:5432/postgresql";
            String user = "postgres";
            String password = "user";

            try (Connection conn = DriverManager.getConnection(url, user, password)) {
                System.out.println("Connected");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}