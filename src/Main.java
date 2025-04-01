import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static List<User> users = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int choice;
        do {
            System.out.println("1. Sign Up  2. Sign In  3. Exit");
            choice = sc.nextInt();
            sc.nextLine();
            if (choice == 1) {
                System.out.print("Enter First Name: ");
                String first = sc.next();
                System.out.print("Enter Last Name: ");
                String last = sc.next();
                String username = "@" + first + last;
                System.out.print("Enter Password: ");
                String password = sc.next();
                users.add(new User(username, password));
                System.out.println("Account created successfully!");
                System.out.print("Username: "+username+"\n"+"Password: "+password+"\n");
            } else if (choice == 2) {
                System.out.print("Username: ");
                String u = sc.next();
                System.out.print("Password: ");
                String p = sc.next();
                boolean found = false;
                for (User user : users) {
                    if (user.username.equals(u) && user.password.equals(p)) {
                        user.login();
                        Util.clearConsole();
                        break;
                    }
                }
                if (!found) {
                    System.out.println("Wrong credentials!");
                    Util.clearConsole();
                }
            }
        } while (choice != 3);
        sc.close();
    }
}