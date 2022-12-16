package BuildClasses;

public class User {
    private int idUser;
    private String firstName;
    private String lastName;
    private String userName;
    private String password;
    private int role;
    private String rl;

    public User(int idUser, String firstName, String lastName, String userName, String password, int role) {
        this.idUser=idUser;
        this.firstName = firstName;
        this.lastName = lastName;
        this.userName = userName;
        this.password = password;
        this.role=role;
        if(role==1){
            rl="администратор";
        }
        else if(role==2){
            rl="заказчик";
        }
        else if(role==3){
            rl="снабженец";
        }
    }

    public int getIdUser() {
        return idUser;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }

    public int getRole() {
        return role;
    }

    public String getRl() {
        return rl;
    }
}
