import java.util.Scanner;

public class TextEditor {
    int top;
    int max;
    String[] stack;

    public TextEditor(int size) {
        max = size;
        top = -1;
        stack = new String[max];
    }

    public void typeWord(String word) {
        if (top == max - 1) {
            System.out.println("Cannot type more words: Stack is full.");
        } else {
            stack[++top] = word;
            System.out.println("Typed: \"" + word + "\"");
        }
    }

    public void undo() {
        if (top == -1) {
            System.out.println("Nothing to undo.");
        } else {
            String undone = stack[top--];
            System.out.println("Action undone: \"" + undone + "\"");
        }
    }

    public void viewActions() {
        if (top == -1) {
            System.out.println("No actions performed yet.");
        } else {
            System.out.print("Current Stack: [");
            for (int i = 0; i <= top; i++) {
                System.out.print("\"" + stack[i] + "\"");
                if (i < top) System.out.print(", ");
            }
            System.out.println("]");
        }
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int size;

        while (true) {
            System.out.print("Enter the size of the stack: ");
            if (input.hasNextInt()) {
                size = input.nextInt();
                if (size > 0) {
                    break;
                } else {
                    System.out.println("Size must be greater than 0.");
                }
            } else {
                System.out.println("Invalid input. Please enter a number.");
                input.next(); 
            }
        }

        TextEditor editor = new TextEditor(size);
        int choice = 0;

        while (choice != 4) {
            System.out.println("\n=== Simple Text Editor ===");
            System.out.println("1. Type Word");
            System.out.println("2. Undo");
            System.out.println("3. View Actions");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");

            if (input.hasNextInt()) {
                choice = input.nextInt();
                input.nextLine(); 
                switch (choice) {
                    case 1:
                        System.out.print("Enter a word: ");
                        String word = input.nextLine();
                        editor.typeWord(word);
                        break;
                    case 2:
                        editor.undo();
                        break;
                    case 3:
                        editor.viewActions();
                        break;
                    case 4:
                        System.out.println("Exiting editor.");
                        break;
                    default:
                        System.out.println("Invalid choice. Try again.");
                }
            } else {
                System.out.println("Invalid input. Enter a number between 1 and 4.");
                input.next(); 
            }
        }
    }
}
