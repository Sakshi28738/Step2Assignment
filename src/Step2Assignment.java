import java.util.*;

public class Step2Assignment {

    // ======================= PROBLEM 5 =======================

    // Linear Search (first occurrence)
    public static int linearSearchFirst(String[] arr, String target) {
        int comparisons = 0;

        for (int i = 0; i < arr.length; i++) {
            comparisons++;
            if (arr[i].equals(target)) {
                System.out.println("Linear First Occurrence Index: " + i);
                System.out.println("Comparisons: " + comparisons);
                return i;
            }
        }

        return -1;
    }

    // Linear Search (last occurrence)
    public static int linearSearchLast(String[] arr, String target) {
        int comparisons = 0;
        int index = -1;

        for (int i = 0; i < arr.length; i++) {
            comparisons++;
            if (arr[i].equals(target)) {
                index = i;
            }
        }

        System.out.println("Linear Last Occurrence Index: " + index);
        System.out.println("Comparisons: " + comparisons);
        return index;
    }

    // Binary Search (any occurrence)
    public static int binarySearch(String[] arr, String target) {
        int low = 0, high = arr.length - 1;
        int comparisons = 0;

        while (low <= high) {
            comparisons++;
            int mid = (low + high) / 2;

            if (arr[mid].equals(target)) {
                System.out.println("Binary Search Found at Index: " + mid);
                System.out.println("Comparisons: " + comparisons);
                return mid;
            } else if (arr[mid].compareTo(target) < 0) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return -1;
    }

    // Count occurrences (after binary search)
    public static int countOccurrences(String[] arr, String target) {
        int count = 0;

        for (String s : arr) {
            if (s.equals(target)) count++;
        }

        System.out.println("Total Occurrences: " + count);
        return count;
    }

    public static void main(String[] args) {

        System.out.println("===== Problem 5 =====");

        String[] logs = {"accB", "accA", "accB", "accC"};

        // Linear Search
        linearSearchFirst(logs, "accB");
        linearSearchLast(logs, "accB");

        // Sort for Binary Search
        Arrays.sort(logs);
        System.out.println("Sorted Logs: " + Arrays.toString(logs));

        // Binary Search
        binarySearch(logs, "accB");

        // Count occurrences
        countOccurrences(logs, "accB");
    }
}