import java.sql.*;
import java.util.Objects;

public class DatabaseHandler extends Config{
    public static int id;
    static Connection dbConnection;

    public static Connection getDbConnection()
            throws ClassNotFoundException, SQLException{
        String connectionString="jdbc:mysql://" + dbHost + ":" + dbPort + "/" + dbName;
        Class.forName("com.mysql.cj.jdbc.Driver");
        dbConnection = DriverManager.getConnection(connectionString, dbUser, dbPass);
        return dbConnection;
    }

    public static int singUpUser(String firstName, String lastName, String userName, String password, String roole) { //регистрация
        int role=0, flag=-1;
        if(Objects.equals(roole, "Администратор")){
            role=1;
        } else if (Objects.equals(roole, "Закзчик")) {
            role=2;
        } else if (Objects.equals(roole, "Снабженец")) {
            role=3;
        }
        String insert = "SELECT * FROM users WHERE login='"+userName+"'";
        try {
            PreparedStatement prSt = getDbConnection().prepareStatement(insert);
            ResultSet rs =  prSt.executeQuery();
            if(rs.next()){
                System.out.println(rs.getString("login"));
                   flag=0;
            }
        } catch (SQLException | ClassNotFoundException e)
        {
            e.printStackTrace();
        }
        if(flag!=0) {
            insert = "insert into " + Const.USER_TABLE + "(" + Const.USERS_FIRSTNAME + "," + Const.USERS_LASTNAME +
                    "," + Const.USERS_USERNAME + "," + Const.USERS_PASSWORD + "," + Const.USERS_ROLE + ")" +
                    "VALUES('" + firstName + "','" + lastName + "','" + userName + "','" + password + "'," + role + ")";
            try {
                PreparedStatement prSt = getDbConnection().prepareStatement(insert);
                prSt.executeUpdate(insert);
                flag = 1;
            } catch (SQLException | ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
        return flag;
    }

    public int singInUser(int role, String log, String pas) //вход
    {
        int flag=-1;
        try {
            String insert = "SELECT * FROM users WHERE login='"+log+"' AND password='"+pas+"' AND role="+role;
            //System.out.println(log + "    " + pas + "     " + role);
            PreparedStatement prSt = getDbConnection().prepareStatement(insert);
            ResultSet rs =  prSt.executeQuery();
            if(rs.next()){
            flag = 0; //ретурн всё окей
            id = rs.getInt(Const.USERS_ID);}
            else {
            flag=1;
            }
        } catch (SQLException | ClassNotFoundException e)
        {
            e.printStackTrace();
        }
        return flag;
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
        } catch (SQLException | ClassNotFoundException e)
        {
            e.printStackTrace();
        }
    }

//    public ResultSet getUser(User user) {
//        ResultSet resSet = null;
//        String select = "SELECT * FROM " + Const.USER_TABLE +
//                " WHERE " + Const.USERS_USERNAME + "=? AND" +
//                Const.USERS_PASSWORD + "=?";
//        try {
//            PreparedStatement prSt = getDbConnection().prepareStatement(select);
//            prSt.setString(1, user.getUserName());
//            prSt.setString(2, user.getPassword());
//            resSet = prSt.executeQuery();
//
//        } catch (SQLException | ClassNotFoundException e) {
//            e.printStackTrace();
//        }
//        return resSet;
//    }

    public static void addApplication(String name, int number, String SI, String repeat, int iduser){
        int status=1, idworker=0;
        String insert ="insert into " + Const.APPLICATION_TABLE + "("+Const.APP_NAME+","+Const.APP_NUM+
                ","+Const.APP_SI+","+Const.APP_REPEAT+","+Const.APP_STATUS+","+Const.APP_IDUSER+","+Const.APP_IDWORKER+")" +
                "VALUES('"+name+"',"+number+",'"+SI+"','"+repeat+"',"+status+","+iduser+","+idworker+" )";
        try {
            PreparedStatement prSt = DatabaseHandler.getDbConnection().prepareStatement(insert);
            prSt.executeUpdate(insert);
        } catch (SQLException | ClassNotFoundException e)
        {
            e.printStackTrace();
        }
    }

    public int notice(int iduser)  {
        int count=0, flag=0;
        try {
            String select = "SELECT * FROM " + Const.APPLICATION_TABLE +
                    " WHERE " + Const.APP_IDUSER + "=" + iduser+" AND "+Const.APP_STATUS+"=1";
            PreparedStatement prSt = getDbConnection().prepareStatement(select);
            ResultSet rs = prSt.executeQuery();
            if (rs.next()) {
                flag++;
                count++;
               // id = rs.getInt(Const.USERS_ID);
            } else {
                flag++;
            }
            return count;
        }catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
