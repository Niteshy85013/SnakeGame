import java.sql.*;
class JdbcConnection {
    Connection con;
    Statement st;
    int val;
    ResultSet rows;
    public JdbcConnection() {
        // register the driver class
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            // create the connection object
            con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/jdbc", "root", "Nitesh@123");
            if (con != null) {
                System.out.println("Database is connected successful");
            }
            //creating statement object
            st = con.createStatement();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public int insert(String query) {
        // execute query
        try {
            val= st.executeUpdate(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return val;
    }
    public  ResultSet select(String query){
        try {
            rows= st.executeQuery(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rows;
    }
    public static void main (String[]args){
        new JdbcConnection();
    }
}
