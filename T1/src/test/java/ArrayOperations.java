
import java.util.Scanner;

public class ArrayOperations{

    // Method to create an array
    public static int[] createArray(int size) {
        return new int[size]; // Returns a new array of the given size
    }

    // Method to insert an element into the array at a specified index
    public static void insertElement(int[] array, int index, int value) {
        if (index >= 0 && index < array.length) {
            array[index] = value; // Insert the value at the specified index
        } else {
            System.out.println("Insertion Error: Index out of bounds");
        }
    }

    // Method to delete an element from the array (reset to default value)
    public static void deleteElement(int[] array, int index) {
        if (index >= 0 && index < array.length) {
            array[index] = 0; // Reset the value at the specified index to 0
        } else {
            System.out.println("Deletion Error: Index out of bounds");
        }
    }

    // Method to traverse and print all elements in the array
    public static void traverseArray(int[] array) {
        System.out.println("Array elements:");
        for (int i = 0; i < array.length; i++) {
            System.out.println("Element at index " + i + ": " + array[i]);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Dynamic creation of an array
        System.out.print("Enter the size of the array: ");
        int size = scanner.nextInt();
        int[] myArray = createArray(size);

        boolean continueOperations = true;

        while (continueOperations) {
            System.out.println("\nChoose an operation:");
            System.out.println("1. Insert an element");
            System.out.println("2. Delete an element");
            System.out.println("3. Traverse the array");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter index to insert: ");
                    int insertIndex = scanner.nextInt();
                    System.out.print("Enter value to insert: ");
                    int value = scanner.nextInt();
                    insertElement(myArray, insertIndex, value);
                    break;

                case 2:
                    System.out.print("Enter index to delete: ");
                    int deleteIndex = scanner.nextInt();
                    deleteElement(myArray, deleteIndex);
                    break;

                case 3:
                    traverseArray(myArray);
                    break;

                case 4:
                    continueOperations = false;
                    System.out.println("Exiting...");
                    break;

                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        }

        scanner.close();
    }
}
