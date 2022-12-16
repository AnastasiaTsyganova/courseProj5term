public class Application {
    private int idApp;
    private String name;
    private int number;
    private String SI;
    private String replay;
    private int status;
    private int idUser;
    private int idWorker;
    private int idSupplier;

    private String st;

    public Application(int idApp, String name, int number, String SI, String replay, int status, int idUser, int idWorker, int idSupplier) {
        this.idApp=idApp;
        this.name = name;
        this.number = number;
        this.SI = SI;
        this.replay = replay;
        this.status=status;
        if(status==1){
            st="заказано";
        }
        else if(status==2){
            st="обработано";
        }
        else if(status==3){
            st="просмотрено";
        }
        this.idUser=idUser;
        this.idWorker=idWorker;
        this.idSupplier=idSupplier;
    }

    public int getIdApp() {
        return idApp;
    }

    public String getName() {
        return name;
    }

    public int getNumber() {
        return number;
    }

    public String getSI() {
        return SI;
    }

    public String getReplay() {
        return replay;
    }

    public int getStatus() {
        return status;
    }

    public int getIdUser() {
        return idUser;
    }

    public String getSt() {
        return st;
    }

    public int getIdWorker() {
        return idWorker;
    }

    public int getIdSupplier() {
        return idSupplier;
    }
}
