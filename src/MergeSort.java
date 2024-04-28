import java.util.Arrays;

public class MergeSort {
    private static void merge(int[] arr, int left, int middle, int right) {
        int numb1 = middle - left + 1;
        int numb2 = right - middle;

        int[] L = Arrays.copyOfRange(arr, left, middle + 1);
        int[] R = Arrays.copyOfRange(arr, middle + 1, right + 1);

        int i = 0, j = 0, k = left;
        while (i < numb1 && j < numb2) {
            if (L[i] <= R[j]) {
                arr[k++] = L[i++];
            } else {
                arr[k++] = R[j++];
            }
        }

        while (i < numb1) {
            arr[k++] = L[i++];
        }

        while (j < numb2) {
            arr[k++] = R[j++];
        }
    }

    private static void sort(int arr[], int left, int right) {
        if (left < right) {
            int middle = (left + right) / 2;

            sort(arr, left, middle);

            sort(arr, middle + 1, right);

            merge(arr, left, middle, right);
        }
    }

    private static void printArray(int[] arr) {
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] arr = {100, 11, 999, -22, 10, 100, 1000, -209};

        System.out.println("Initial array :");
        printArray(arr);

        sort(arr, 0, arr.length-1);

        System.out.println("\nArray after merge sort : ");
        printArray(arr);
    }
}
