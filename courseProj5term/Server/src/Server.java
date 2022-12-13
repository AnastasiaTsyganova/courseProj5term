import between.Phone;
import java.io.*;
import java.net.ServerSocket;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Objects;

public class Server {
    private static int role=0;
    public static void main(String[] args) {
        try (ServerSocket server = new ServerSocket(8000);) {
            System.out.println("«апуск сервера");
            while (true) {
                Phone phone = new Phone(server);
                new Thread(() -> {
                    System.out.println(" лиент подключен");
                    while (true) {
                        int flag1 = -1;
                        System.out.println("main");
                        // String request = Phone.readLine();
                        String log = Phone.readLine();
                        String pas = Phone.readLine();
                        String rl = Phone.readLine();
                        role = Integer.parseInt(rl);
                        DatabaseHandler dbHandler = new DatabaseHandler();
                        int i = dbHandler.singInUser(role, log, pas);
                        int iduser = DatabaseHandler.id;
                        //System.out.println(log + "    " + pas + "     " + rl + "      " + iduser);
                        Phone.writeLine(String.valueOf(i));
                        //System.out.println(i);
                        String enter = Phone.readLine();
                        System.out.println("роль     "+role);
                        if (Objects.equals(enter, "вход")) {
                            System.out.println("vhod");
                            switch (role) {
                                case 1: {
                                    admMenu(flag1);
                                }break;
                                case 2: {
                                    userMenu(flag1, iduser);
                                }break;
                                case 3: {
                                    workerMenu(flag1);
                                }break;
                            }
                        }
                    }
                }).start();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static void admMenu(int flag1){
        while (flag1 != 0) {
            System.out.println("admin");
            String admButton = Phone.readLine();
            switch (admButton) {
                case "пользователи": {
                    userWork();
                    flag1=1;
                }break;
                case "поставщики": {

                }break;
                case "заказы": {

                }break;
                case "возврат": {
                    flag1 = 0;

                    System.out.println("admMenu возврат");

                }break;
            }
        }
    }

    private static void userWork() {
        int flag2 = -1;
        while (flag2 != 1) {
        System.out.println("users");
        String admUser = Phone.readLine();
            switch (admUser) {
                case "регистраци€": {
                    System.out.println("регистраци€");
                    String singUp = Phone.readLine();
                   // System.out.println("userWork регистраци€      " + singUp);
                    switch (singUp) {
                        case "добавление": {
                            System.out.println("userWork регистраци€ добавление");
                           // while (flag2 != 1) {
                                String nameUser = Phone.readLine();
                                System.out.println(nameUser);
                                String lastname = Phone.readLine();
                                System.out.println(lastname);
                                String login = Phone.readLine();
                                System.out.println(login);
                                String password = Phone.readLine();
                                System.out.println(password);
                                String roole = Phone.readLine();
                                System.out.println(roole);
                                System.out.println(nameUser+"    "+ lastname+"    "+ login+"    "+ password+"    "+ roole);
                                flag2 = DatabaseHandler.singUpUser(nameUser, lastname, login, password, roole);
                               // Phone.writeLine(Integer.toString(flag2));
                                Phone.writeLine(String.valueOf(flag2));
                            System.out.println(flag2);
                                if (flag2 == 1) {
                                    System.out.println("«апись добавлена");
                                } else
                                    System.out.println("ѕользователь с таким логином уже существует, ожидаетс€ повторный ввод");
                            //}
                        }
                        break;
                        case "возврат": {
                            System.out.println("userWork регистраци€ возврат");
                        }
                        break;
                    }
                }
                break;
                case "удаление": {

                }
                break;
                case "изменение": {

                }
                break;
                case "просмотр": {

                }
                break;
                case "возврат": {
                    flag2=1;
                    System.out.println("userWork возврат");
                }
                break;
            }
        }
    }

    private static void userMenu(int flag1, int iduser){
        while (flag1 != 0) {
            System.out.println("zakazchik");
            String usButton = Phone.readLine();
            if (Objects.equals(usButton, "добавить")) {
                usButton = Phone.readLine();
                if (Objects.equals(usButton, "добавить2")) {
                    String name = Phone.readLine();
                    System.out.println(name);
                    String num = Phone.readLine();
                    System.out.println(num);
                    int number = Integer.parseInt(num);
                    String SI = Phone.readLine();
                    System.out.println(SI);
                    String repeat = Phone.readLine();
                    System.out.println(repeat);
                    DatabaseHandler.addApplication(name, number, SI, repeat, iduser);
                    System.out.println("«апись добавлена");
                }
            } else if (Objects.equals(usButton, "показать")) {

            } else if (Objects.equals(usButton, "оценить")) {

            }
//                                else if (Objects.equals(usButton, "проверить")) {
//                                    int count=dbHandler.notice(iduser);
//                                    Phone.writeLine(String.valueOf(count));
//
//                                }
            else if (Objects.equals(usButton, "возврат")) {
                flag1 = 0;
                //System.out.println("return        " + role);
            }
        }
    }

    private static void workerMenu(int flag1) {
        while (flag1 != 0) {
            System.out.println("snabzhenets");
            String usButton = Phone.readLine();
            if (Objects.equals(usButton, "актуальные")) {

            } else if (Objects.equals(usButton, "обработанные")) {

            } else if (Objects.equals(usButton, "оценить")) {

            } else if (Objects.equals(usButton, "возврат")) {
                flag1 = 0;
               // System.out.println("return        " + role);
            }
        }
    }
}
