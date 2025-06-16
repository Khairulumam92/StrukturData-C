
public class MergeSort {

    // Method utama untuk merge sort
    public static void mergeSort(int[] arr, int left, int right) {
        if (left < right) {
            // Temukan titik tengah untuk membagi array
            int mid = left + (right - left) / 2;

            // Rekursif sort untuk bagian kiri dan kanan
            mergeSort(arr, left, mid);
            mergeSort(arr, mid + 1, right);

            // Gabungkan kedua bagian yang sudah terurut
            merge(arr, left, mid, right);
        }
    }

    // Method untuk menggabungkan dua sub-array yang sudah terurut
    public static void merge(int[] arr, int left, int mid, int right) {
        // Hitung ukuran sub-array kiri dan kanan
        int n1 = mid - left + 1;
        int n2 = right - mid;

        // Buat array sementara
        int[] leftArray = new int[n1];
        int[] rightArray = new int[n2];

        // Salin data ke array sementara
        for (int i = 0; i < n1; i++) {
            leftArray[i] = arr[left + i];
        }
        for (int j = 0; j < n2; j++) {
            rightArray[j] = arr[mid + 1 + j];
        }

        // Index untuk array sementara dan array utama
        int i = 0, j = 0, k = left;

        // Gabungkan array sementara kembali ke arr
        while (i < n1 && j < n2) {
            if (leftArray[i] <= rightArray[j]) {
                arr[k] = leftArray[i];
                i++;
            } else {
                arr[k] = rightArray[j];
                j++;
            }
            k++;
        }

        // Salin elemen yang tersisa dari leftArray
        while (i < n1) {
            arr[k] = leftArray[i];
            i++;
            k++;
        }

        // Salin elemen yang tersisa dari rightArray
        while (j < n2) {
            arr[k] = rightArray[j];
            j++;
            k++;
        }
    }

    // Method untuk mencetak array
    public static void printArray(int[] arr) {
        for (int value : arr) {
            System.out.print(value + " ");
        }
        System.out.println();
    }

    // Method main untuk testing
    public static void main(String[] args) {
        int[] arr = {64, 34, 25, 12, 22, 11, 90};

        System.out.println("Array sebelum diurutkan:");
        printArray(arr);

        mergeSort(arr, 0, arr.length - 1);

        System.out.println("Array setelah diurutkan:");
        printArray(arr);
    }
}
