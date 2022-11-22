import java.sql.*;

public class DatabaseHandler extends Config{
    Connection dbConnection;

    public Connection getDbConnection()
            throws ClassNotFoundException, SQLException{
        String connectionString="jdbc:mysql://" + dbHost + ":" + dbPort + "/" + dbName;
        Class.forName("com.mysql.cj.jdbc.Driver");
        dbConnection = DriverManager.getConnection(connectionString, dbUser, dbPass);
        return dbConnection;
    }

    public void singUpUser(String firstName, String lastName, String userName, String password) { //регистрация
        String insert ="insert into " + Const.USER_TABLE + "("+Const.USERS_FIRSTNAME+","+Const.USERS_LASTNAME+
                ","+Const.USERS_USERNAME+","+Const.USERS_PASSWORD+")" +"VALUES('"+firstName+"','"+lastName+"','"+userName+"','"+password+"')";
        try {
            PreparedStatement prSt = getDbConnection().prepareStatement(insert);
            prSt.executeUpdate(insert);
        } catch (SQLException e)
        {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public int singInUser(int role, String log, String pas) //вход
    {
        String insert = "SELECT * FROM users";
        int flag=-1;
        try {
            PreparedStatement prSt = getDbConnection().prepareStatement(insert);
            ResultSet rs =  prSt.executeQuery();
            while(rs.next()){
                int role1=rs.getInt(Const.USERS_ROLE);
                if(role1==role)
                {
                    String login=rs.getString(Const.USERS_USERNAME);
                    String password=rs.getString(Const.USERS_PASSWORD);
                    if(log==login && pas==password) flag=0; //ретурн всё окей
                    else flag=1; //ретурн ошибка ввода
                }
            }
        } catch (SQLException e)
        {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }finally {
        return flag;
        }
    }

    //получение данных из бд
    public void printFromDb(int role){
        String insert = "SELECT * FROM users";

        try {
            PreparedStatement prSt = getDbConnection().prepareStatement(insert);
            ResultSet rs =  prSt.executeQuery();
            if(rs.next()){
                System.out.println(rs.getInt("idusers"));
            }
        } catch (SQLException e)
        {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
