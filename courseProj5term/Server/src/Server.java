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
            System.out.println("Запуск сервера");
            while (true) {
                Phone phone = new Phone(server);
                new Thread(() -> {
                    System.out.println("Клиент подключен");
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
                       // System.out.println("роль     "+role);
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
                case "регистрация": {
                    System.out.println("регистрация");
                    String singUp = Phone.readLine();
                    switch (singUp) {
                        case "добавление": {
                            System.out.println("userWork регистрация добавление");
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
                                    System.out.println("Запись добавлена");
                                } else
                                    System.out.println("Пользователь с таким логином уже существует, ожидается повторный ввод");
                            //}
                        }
                        break;
                        case "возврат": {
                            System.out.println("userWork регистрация возврат");
                        }
                        break;
                    }
                }
                break;
                case "удаление": {
                    System.out.println("удалить");
                    int i=0;
                    while(i!=1) {
                        String loginDel = Phone.readLine();
                        switch (loginDel) {
                            case "поиск": {
                                System.out.println("userWork удаление поиск");
                                String login = Phone.readLine();
                                System.out.println(login);
                                flag2 = DatabaseHandler.searchUser(login);
                                Phone.writeLine(String.valueOf(flag2));
                                System.out.println(flag2);
                                if (flag2 == 0) {
                                    System.out.println("Запись найдена");
                                } else
                                {System.out.println("Пользователь с таким логином не найден");
                                i=1;}
                                //}
                            }
                            break;
                            case "удаление": {
                                System.out.println("userWork удаление удаление");
                                String res = Phone.readLine();
                                int id = Integer.parseInt(res);
                                int res1 = DatabaseHandler.deleteUser(id);
                                Phone.writeLine(String.valueOf(res1));
                                System.out.println("удалено");
                                i=1;
                            }
                            break;
                            case "возврат": {
                                System.out.println("userWork удаление возврат");
                                i=1;
                            }
                            break;
                        }
                    }
                }
                break;
                case "изменение": {
                    System.out.println("изменить");
                    String what=Phone.readLine();
                    switch (what) {
                        case "фамилия": {
                            int n = 0;
                            while (n != 1) {
                                String button = Phone.readLine();
                                switch (button) {
                                    case "поиск": {
                                        System.out.println("userWork изменение поиск");
                                        String login = Phone.readLine();
                                        System.out.println(login);
                                        flag2 = DatabaseHandler.searchUser(login);
                                        Phone.writeLine(String.valueOf(flag2));
                                        System.out.println(flag2);
                                        if (flag2 == 0) {
                                            System.out.println("Запись найдена");
                                        } else {
                                            System.out.println("Пользователь с таким логином не найден");
                                            n = 1;
                                        }
                                        //}
                                    }
                                    break;
                                    case "изменение": {
                                        System.out.println("userWork изменение изменение");
                                        String lastname = Phone.readLine();
                                        String res = Phone.readLine();
                                        int id = Integer.parseInt(res);
                                        int res1 = DatabaseHandler.changeUserLastname(id, lastname);
                                        Phone.writeLine(String.valueOf(res1));
                                        System.out.println("изменено");
                                        n = 1;
                                    }
                                    break;
                                    case "возврат": {
                                        System.out.println("userWork изменение возврат");
                                        n = 1;
                                    }
                                    break;
                                }
                            }
                        } break;
                        case "пароль":{
                            int n = 0;
                            while (n != 1) {
                                String button = Phone.readLine();
                                switch (button) {
                                    case "поиск": {
                                        System.out.println("userWork изменение поиск");
                                        String login = Phone.readLine();
                                        System.out.println(login);
                                        flag2 = DatabaseHandler.searchUser(login);
                                        Phone.writeLine(String.valueOf(flag2));
                                        System.out.println(flag2);
                                        if (flag2 == 0) {
                                            System.out.println("Запись найдена");
                                        } else {
                                            System.out.println("Пользователь с таким логином не найден");
                                            n = 1;
                                        }
                                        //}
                                    }
                                    break;
                                    case "изменение": {
                                        System.out.println("userWork изменение изменение");
                                        String password = Phone.readLine();
                                        String res = Phone.readLine();
                                        int id = Integer.parseInt(res);
                                        int res1 = DatabaseHandler.changeUserPassword(id, password);
                                        Phone.writeLine(String.valueOf(res1));
                                        System.out.println("изменено");
                                        n = 1;
                                    }
                                    break;
                                    case "возврат": {
                                        System.out.println("userWork изменение возврат");
                                        n = 1;
                                    }
                                    break;
                                }
                            }
                        }break;
                    }
                }
                break;
                case "просмотр": {
                    int flag3=-1;
                    while (flag3!=0) {
                        String sw = Phone.readLine();
                        switch (sw) {
                            case "вывод": {
                                System.out.println("userWork просмотр вывод");
                                DatabaseHandler.showUser();
                            }
                            break;
                            case "возврат": {
                                System.out.println("userWork просмотр возврат");
                                flag3=0;
                            }
                        }
                    }
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
          //  System.out.println(flag1);
            System.out.println("zakazchik");
            String usButton = Phone.readLine();
            switch (usButton) {
                case "добавить": {
                    String addChoice = Phone.readLine();
                    switch (addChoice){
                        case "добавить": {
                            System.out.println("userMenu добавить добавить");
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
                            System.out.println("Запись добавлена");
                        } break;
                        case "возврат":{
                            System.out.println("userMenu добавить возврат");
                        } break;
                   }
                } break;
                case "показать": {
                    int flag3=-1;
                    while (flag3!=0) {
                        String showChoice = Phone.readLine();
                        switch (showChoice) {
                            case "вывод": {
                                System.out.println("userMenu показать вывод");
                                DatabaseHandler.showApplicationUser(iduser);
                            }
                            break;
                            case "возврат": {
                                System.out.println("userMenu показать возврат");
                                flag3=0;
                            }
                            break;
                        }
                    }
                }break;
                case "оценить": {

                }break;
//                                else if (Objects.equals(usButton, "проверить")) {
//                                    int count=dbHandler.notice(iduser);
//                                    Phone.writeLine(String.valueOf(count));
//
//                                }
                case "возврат": {
                    flag1 = 0;
                    System.out.println("userMenu возврат");
                    //System.out.println("return        " + role);
                }break;
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
