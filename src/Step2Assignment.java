import java.util.*;

public class Step2Assignment {

    // ======================= PROBLEM 2 =======================

    static class Client {
        String name;
        int riskScore;
        double accountBalance;

        Client(String name, int riskScore, double accountBalance) {
            this.name = name;
            this.riskScore = riskScore;
            this.accountBalance = accountBalance;
        }

        public String toString() {
            return name + ":" + riskScore;
        }
    }

    // Bubble Sort (ascending)
    public static void bubbleSortClients(Client[] arr) {
        int swaps = 0;

        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j].riskScore > arr[j + 1].riskScore) {
                    Client temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    swaps++;
                }
            }
        }

        System.out.println("Bubble (Ascending): " + Arrays.toString(arr));
        System.out.println("Swaps: " + swaps);
    }

    // Insertion Sort (descending + accountBalance)
    public static void insertionSortClients(Client[] arr) {

        for (int i = 1; i < arr.length; i++) {
            Client key = arr[i];
            int j = i - 1;

            while (j >= 0 && (arr[j].riskScore < key.riskScore ||
                    (arr[j].riskScore == key.riskScore &&
                            arr[j].accountBalance < key.accountBalance))) {

                arr[j + 1] = arr[j];
                j--;
            }

            arr[j + 1] = key;
        }

        System.out.println("Insertion (Descending): " + Arrays.toString(arr));
    }

    // Top clients
    public static void topClients(Client[] arr, int n) {
        System.out.print("Top " + n + " risks: ");

        for (int i = 0; i < Math.min(n, arr.length); i++) {
            System.out.print(arr[i].name + "(" + arr[i].riskScore + ") ");
        }

        System.out.println();
    }

    public static void main(String[] args) {

        System.out.println("===== Problem 2 =====");

        Client[] clients = {
                new Client("clientC", 80, 5000),
                new Client("clientA", 20, 7000),
                new Client("clientB", 50, 3000)
        };

        // Bubble Sort
        Client[] bubbleClients = clients.clone();
        bubbleSortClients(bubbleClients);

        // Insertion Sort
        Client[] insertionClients = clients.clone();
        insertionSortClients(insertionClients);

        // Top clients
        topClients(insertionClients, 3);
    }
}