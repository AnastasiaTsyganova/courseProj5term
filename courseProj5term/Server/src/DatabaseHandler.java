import between.Phone;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
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

    public static void addApplication(String name, int number, String SI, String repeat, int iduser){//добавление заказа
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
//уведомление не работает
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

    public static int searchUser(String userLogin){
       // User user=new User();
        int flag=-1;
        int idUser;
        String nameUser;
        String lastnameUser;
        String loginUser;
        String passwordUser;
        int roleUser;
        String insert = "SELECT * FROM users WHERE login='"+userLogin+"'";
        try {
            PreparedStatement prSt = getDbConnection().prepareStatement(insert);
            ResultSet rs =  prSt.executeQuery();
            if(rs.next()){
                System.out.println(rs.getString("login"));
                idUser=rs.getInt(Const.USERS_ID);
                Phone.writeLine(String.valueOf(idUser));
                nameUser=rs.getString(Const.USERS_FIRSTNAME);
                Phone.writeLine(nameUser);
                lastnameUser=rs.getString(Const.USERS_LASTNAME);
                Phone.writeLine(lastnameUser);
                loginUser=rs.getString(Const.USERS_USERNAME);
                Phone.writeLine(loginUser);
                passwordUser=rs.getString(Const.USERS_PASSWORD);
                Phone.writeLine(passwordUser);
                roleUser=rs.getInt(Const.USERS_ROLE);
                Phone.writeLine(String.valueOf(roleUser));
                System.out.println(idUser + nameUser + lastnameUser + loginUser + passwordUser + roleUser);
                flag=0;
            }
        } catch (SQLException | ClassNotFoundException e)
        {
            e.printStackTrace();
        }
//        int res=2;
//        if(flag==0) {
//           // res = deleteUser(user); //1 - окей, 0/2 - не окей
//        }
        return flag;
    }

    public static int deleteUser(int id){
        //String name="";
        String insert = "DELETE FROM " + Const.USER_TABLE + " WHERE idusers='"+id+"'";
        try {
            PreparedStatement prSt = getDbConnection().prepareStatement(insert);
            if(prSt.executeUpdate(insert)!=0){
                return 1; //всё ок
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return 0; //не ок
    }

    public static void showUser(){
        List <User> listUser=new ArrayList<>();
        String insert = "SELECT * FROM users";
        try {
            PreparedStatement prSt = getDbConnection().prepareStatement(insert);
            ResultSet rs =  prSt.executeQuery();
            int count=0;
            while(rs.next()){
                count++;
                int id=rs.getInt("idusers");
                String name=rs.getString("firstname");
                String lastname=rs.getString("lastname");
                String login=rs.getString("login");
                String password=rs.getString("password");
                int role= rs.getInt("role");
                User user=new User(id, name, lastname, login, password, role);
                listUser.add(user);
              //  System.out.println(rs.getInt("idusers"));
            }
            Phone.writeLine(String.valueOf(count));
           // System.out.println(count);
            for(int n=0;n<count;n++){
                User user = listUser.get(n);
                int id = user.getIdUser();
                Phone.writeLine(String.valueOf(id));
                String name=user.getFirstName();
                Phone.writeLine(name);
                String lastname=user.getLastName();
                Phone.writeLine(lastname);
                String login=user.getUserName();
                Phone.writeLine(login);
                String password=user.getPassword();
                Phone.writeLine(password);
                int role= user.getRole();
                Phone.writeLine(String.valueOf(role));
            }
        } catch (SQLException | ClassNotFoundException e)
        {
            e.printStackTrace();
        }
    }

    public static int changeUserLastname(int id, String lastName){
        System.out.println(id + lastName);
        String insert = "UPDATE " + Const.USER_TABLE + " SET " +Const.USERS_LASTNAME+"='"+ lastName+ "' WHERE idusers='"+id+"'";
        try {
            PreparedStatement prSt = getDbConnection().prepareStatement(insert);
            if(prSt.executeUpdate(insert)!=0){
                return 1; //всё ок
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return 0; //не ок
    }

    public static int changeUserPassword(int id, String password){
        System.out.println(id + password);
        String insert = "UPDATE " + Const.USER_TABLE + " SET " +Const.USERS_PASSWORD+"='"+ password+ "' WHERE idusers='"+id+"'";
        try {
            PreparedStatement prSt = getDbConnection().prepareStatement(insert);
            if(prSt.executeUpdate(insert)!=0){
                return 1; //всё ок
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return 0; //не ок
    }

    public static void showApplicationUser(int iduser){
        List <Application> listApp=new ArrayList<>();
        String insert = "SELECT * FROM application";
        try {
            PreparedStatement prSt = getDbConnection().prepareStatement(insert);
            ResultSet rs =  prSt.executeQuery();
            int count=0;
           // System.out.println(iduser + "      "+rs.getInt("iduser"));
            while(rs.next()){
                if(iduser== rs.getInt("iduser")) {
                    count++;
                    int id = rs.getInt("id");
                    String name = rs.getString("name");
                    int number = rs.getInt("number");
                    String SI = rs.getString("SI");
                    String repeat = rs.getString("replay");
                    int status = rs.getInt("status");
                    int idUser = rs.getInt("iduser");
                    int idWorker=rs.getInt("idworker");
                    int idSupplier=rs.getInt("idsupplier");
                    Application app = new Application(id, name, number, SI, repeat, status, idUser, idWorker, idSupplier);
                    listApp.add(app);
                    //  System.out.println(rs.getInt("idusers"));
                }
            }
          //  Phone.writeLine(String.valueOf(count));
            System.out.println(count);
            for(int n=0;n<count;n++){
                Application app = listApp.get(n);
                int id = app.getIdApp();
                Phone.writeLine(String.valueOf(id));
                String name=app.getName();
                Phone.writeLine(name);
                int number=app.getNumber();
                Phone.writeLine(String.valueOf(number));
                String SI=app.getSI();
                Phone.writeLine(SI);
                String replay=app.getReplay();
                Phone.writeLine(replay);
                int status= app.getStatus();
                Phone.writeLine(String.valueOf(status));
                int idUser= app.getIdUser();
                Phone.writeLine(String.valueOf(idUser));
                int idWorker= app.getIdWorker();
                Phone.writeLine(String.valueOf(idWorker));
                int idSupplier= app.getIdSupplier();
                Phone.writeLine(String.valueOf(idSupplier));
            }
        } catch (SQLException | ClassNotFoundException e)
        {
            e.printStackTrace();
        }
    }
}
