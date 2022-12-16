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


    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String passwordName) {
        this.password = password;
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public int getRole() {
        return role;
    }

    public void setRole(int role) {
        this.role = role;
    }
}
