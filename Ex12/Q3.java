import java.io.*;
import java.util.*;

class User implements Serializable {
    private String name, loginId, password, aadhar, phone;

    public User(String n, String l, String p, String a, String ph) {
        name = n; loginId = l; password = p; aadhar = a; phone = ph;
    }

    public String getLoginId() { return loginId; }
    public void setPhone(String p) { phone = p; }

    public String toString() {
        return name + " " + loginId + " " + phone;
    }
}

public class Q3 {

    static final String FILE = "users.dat";

    public static void main(String[] args) {
        Console con = System.console();
        if (con == null) {
            System.out.println("Run in command prompt");
            return;
        }

        while (true) {
            System.out.println("\n1.Add 2.Display 3.Search 4.Update 5.Delete 6.Exit");
            int ch = Integer.parseInt(con.readLine());

            switch (ch) {
                case 1:
                    String name = con.readLine("Name: ");
                    String login = con.readLine("Login: ");
                    char[] passArr = con.readPassword("Password: ");
                    String pass = new String(passArr);
                    String aadhar = con.readLine("Aadhar(12): ");
                    String phone = con.readLine("Phone(10): ");

                    if (aadhar.length() != 12 || phone.length() != 10) {
                        System.out.println("Invalid input");
                        break;
                    }

                    User u = new User(name, login, pass, aadhar, phone);

                    try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE, true))) {
                        oos.writeObject(u);
                    } catch (IOException e) {}
                    break;

                case 2:
                    try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FILE))) {
                        while (true) {
                            System.out.println((User) ois.readObject());
                        }
                    } catch (EOFException e) {
                    } catch (Exception e) {}
                    break;

                case 3:
                    String search = con.readLine("Login: ");
                    try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FILE))) {
                        while (true) {
                            User user = (User) ois.readObject();
                            if (user.getLoginId().equals(search))
                                System.out.println(user);
                        }
                    } catch (EOFException e) {
                    } catch (Exception e) {}
                    break;

                case 4:
                case 5:
                    String key = con.readLine("Login: ");
                    ArrayList<User> list = new ArrayList<>();

                    try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FILE))) {
                        while (true) {
                            list.add((User) ois.readObject());
                        }
                    } catch (EOFException e) {} catch (Exception e) {}

                    for (User user : list) {
                        if (user.getLoginId().equals(key)) {
                            if (ch == 4) {
                                String newPhone = con.readLine("New Phone: ");
                                user.setPhone(newPhone);
                            } else {
                                list.remove(user);
                                break;
                            }
                        }
                    }

                    try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE))) {
                        for (User user : list) oos.writeObject(user);
                    } catch (IOException e) {}
                    break;

                case 6:
                    return;
            }
        }
    }
}