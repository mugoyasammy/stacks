import java.util.Scanner;

public class PlateStack {
    int max;
    int[] plates;
    int top;

    public PlateStack(int size) {
        max = size;
        plates = new int[max];
        top = -1;
    }

    public void addPlate(int plateId) {
        if (top == max - 1) {
            System.out.println("Stack is full! Cannot add more plates.");
        } else {
            top++;
            plates[top] = plateId;
            System.out.println("Plate " + plateId + " added.");
        }
    }

    
    public void takePlate() {
        if (top == -1) {
            System.out.println("No plates to take!");
        } else {
            System.out.println("Plate " + plates[top] + " taken.");
            top--;
        }
    }

    
    public void showStack() {
        if (top == -1) {
            System.out.println("Stack is empty.");
        } else {
            System.out.print("Remaining Stack: [");
            for (int i = 0; i <= top; i++) {
                System.out.print(plates[i]);
                if (i < top) System.out.print(", ");
            }
            System.out.println("]");
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the maximum number of plates: ");
        int size = sc.nextInt();
        PlateStack stack = new PlateStack(size);

        while (true) {
            System.out.println("\nMenu:");
            System.out.println("1. Add Plate");
            System.out.println("2. Take Plate");
            System.out.println("3. Show Current Stack of Plates");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");

            int choice = sc.nextInt();
            switch (choice) {
                case 1:
                    System.out.print("Enter Plate ID: ");
                    int plateId = sc.nextInt();
                    stack.addPlate(plateId);
                    break;
                case 2:
                    stack.takePlate();
                    break;
                case 3:
                    stack.showStack();
                    break;
                case 4:
                    System.out.println("Exiting...");
                    sc.close();
                    return;
                default:
                    System.out.println("Invalid option. Try again.");
            }
        }
    }
}
