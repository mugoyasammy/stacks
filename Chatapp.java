import java.util.Scanner;

public class Chatapp {
    int max;
    int top;
    String[] Friends;

    public Chatapp(int size) {
        top = -1;
        max = size;
        Friends = new String[max];
    }

    public void join_group(Scanner P) {
        String Name;
        while (true) {
            System.out.print("Please enter your name: ");
            Name = P.nextLine();
            if (!Name.isEmpty() && Name.matches("[a-zA-Z ]+")) {
                if (top == max - 1) {
                    System.out.println("Overflow: Stack full");
                    return;
                } else {
                    top += 1;
                    Friends[top] = Name;
                    System.out.println(Name + " joined the group.");
                    break;
                }
            } else {
                System.out.println("Invalid input. Name must contain only letters. Please re-enter.");
            }
        }
    }

    public void view_friends() {
        if (top == -1) {
            System.out.println("No friends have joined yet.");
        } else {
            System.out.println("Friends in the group:");
            for (int i = 0; i <= top; i++) {
                System.out.println("- " + Friends[i]);
            }
        }
    }

    public static void main(String[] args) {
        Scanner S = new Scanner(System.in);
        System.out.print("Enter how many friends you want to register: ");
        int size = S.nextInt();
        S.nextLine(); // consume newline

        Chatapp group = new Chatapp(size);

        int choice;
        do {
            System.out.println("\n=== Chat App Menu ===");
            System.out.println("1. Join group");
            System.out.println("2. View friends");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");
            choice = S.nextInt();
            S.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    group.join_group(S);
                    break;
                case 2:
                    group.view_friends();
                    break;
                case 3:
                    System.out.println("Exiting chat app...");
                    break;
                default:
                    System.out.println("Invalid choice. Try again.");
            }

        } while (choice != 3);

        S.close();
    }
}