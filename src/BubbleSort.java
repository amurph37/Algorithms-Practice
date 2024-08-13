public class BubbleSort {

    // Method to perform Bubble Sort
    public static void bubbleSort(int[] arr, int n) {
        int i, j;
        for (i = 0; i < n - 1; i++) { // Loop for each pass
            for (j = 0; j < n - i - 1; j++) { // Loop to compare adjacent elements
                if (arr[j] > arr[j + 1]) { // Compare and swap if necessary
                    // Swap arr[j] and arr[j+1]
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

    // Method to print the array
    public static void printArray(int[] arr) {
        for (int i : arr) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    // Main method to test the Bubble Sort
    public static void main(String[] args) {
        int[] arr = {3, 5, 3, 9, 7};
        int n = arr.length;

        System.out.println("Original array:");
        printArray(arr);

        bubbleSort(arr, n);

        System.out.println("Sorted array:");
        printArray(arr);
    }
}
