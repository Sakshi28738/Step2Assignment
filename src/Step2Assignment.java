import java.util.*;

public class Step2Assignment {

    // ======================= PROBLEM 6 =======================

    // Linear Search (unsorted)
    public static void linearSearch(int[] arr, int target) {
        int comparisons = 0;
        boolean found = false;

        for (int i = 0; i < arr.length; i++) {
            comparisons++;
            if (arr[i] == target) {
                System.out.println("Linear: Found at index " + i);
                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println("Linear: Not found");
        }

        System.out.println("Comparisons: " + comparisons);
    }

    // Binary Search Floor & Ceiling
    public static void binarySearchFloorCeil(int[] arr, int target) {
        int low = 0, high = arr.length - 1;
        int floor = -1, ceil = -1;
        int comparisons = 0;

        while (low <= high) {
            comparisons++;
            int mid = (low + high) / 2;

            if (arr[mid] == target) {
                floor = ceil = arr[mid];
                break;
            } else if (arr[mid] < target) {
                floor = arr[mid];
                low = mid + 1;
            } else {
                ceil = arr[mid];
                high = mid - 1;
            }
        }

        System.out.println("Binary Floor: " + floor);
        System.out.println("Binary Ceiling: " + ceil);
        System.out.println("Comparisons: " + comparisons);
    }

    // Find insertion position (lower bound)
    public static int findInsertionPoint(int[] arr, int target) {
        int low = 0, high = arr.length;

        while (low < high) {
            int mid = (low + high) / 2;

            if (arr[mid] < target) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }

        return low;
    }

    public static void main(String[] args) {

        System.out.println("===== Problem 6 =====");

        int[] unsorted = {50, 10, 100, 25};
        int[] sorted = {10, 25, 50, 100};

        int target = 30;

        // Linear Search (unsorted)
        linearSearch(unsorted, target);

        // Binary Search Floor & Ceiling
        binarySearchFloorCeil(sorted, target);

        // Insertion Point
        int pos = findInsertionPoint(sorted, target);
        System.out.println("Insertion Position: " + pos);
    }
}