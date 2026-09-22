public class PartC_Experiment {

    static int comparisons = 0;

    public static void main(String[] args) {

        System.out.println("-------------------------------------------------------------------------");
        System.out.printf("%-15s %-10s %-15s %-15s\n", "Algorithm", "Size", "Comparisons", "Time (ns)");
        System.out.println("-------------------------------------------------------------------------");

        int[] sizes = {20, 50, 100, 500};

        // Run the main experiment
        for (int size : sizes) {
            int[] original = generateRandomArray(size);
            testAllSorts(original, size);
        }

        // Run the almost-sorted test
        System.out.println("\n=== ALMOST-SORTED ARRAY TEST (Size 100) ===");
        int size = 100;
        int[] almostSorted = new int[size];
        
        // Generate sorted array
        for (int i = 0; i < size; i++) almostSorted[i] = i;
        
        // Shuffle 5 elements
        for (int k = 0; k < 5; k++) {
            int idx1 = (int) (Math.random() * size);
            int idx2 = (int) (Math.random() * size);
            int temp = almostSorted[idx1];
            almostSorted[idx1] = almostSorted[idx2];
            almostSorted[idx2] = temp;
        }
        
        testAllSorts(almostSorted, size);
    }

    static void testAllSorts(int[] original, int size) {
        // Selection Sort
        int[] a1 = copyArray(original);
        long start1 = System.nanoTime();
        selectionSort(a1);
        long end1 = System.nanoTime();
        System.out.printf("%-15s %-10d %-15d %-15d\n", "Selection Sort", size, comparisons, (end1 - start1));

        // Insertion Sort
        int[] a2 = copyArray(original);
        long start2 = System.nanoTime();
        insertionSort(a2);
        long end2 = System.nanoTime();
        System.out.printf("%-15s %-10d %-15d %-15d\n", "Insertion Sort", size, comparisons, (end2 - start2));

        // Merge Sort
        int[] a3 = copyArray(original);
        long start3 = System.nanoTime();
        comparisons = 0;
        mergeSort(a3, 0, size - 1);
        long end3 = System.nanoTime();
        System.out.printf("%-15s %-10d %-15d %-15d\n", "Merge Sort", size, comparisons, (end3 - start3));

        // Quick Sort
        int[] a4 = copyArray(original);
        long start4 = System.nanoTime();
        comparisons = 0;
        quickSort(a4, 0, size - 1);
        long end4 = System.nanoTime();
        System.out.printf("%-15s %-10d %-15d %-15d\n", "Quick Sort", size, comparisons, (end4 - start4));

        System.out.println("-------------------------------------------------------------------------");
    }

    static void selectionSort(int[] arr) {
        comparisons = 0;
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < n; j++) {
                comparisons++;
                if (arr[j] < arr[minIndex]) minIndex = j;
            }
            if (minIndex != i) {
                int temp = arr[i]; arr[i] = arr[minIndex]; arr[minIndex] = temp;
            }
        }
    }

    static void insertionSort(int[] arr) {
        comparisons = 0;
        int n = arr.length;
        for (int i = 1; i < n; i++) {
            int key = arr[i];
            int j = i - 1;
            while (j >= 0) {
                comparisons++;
                if (arr[j] > key) {
                    arr[j + 1] = arr[j];
                    j--;
                } else break;
            }
            arr[j + 1] = key;
        }
    }

    static void mergeSort(int[] arr, int left, int right) {
        if (left < right) {
            int mid = (left + right) / 2;
            mergeSort(arr, left, mid);
            mergeSort(arr, mid + 1, right);
            merge(arr, left, mid, right);
        }
    }

    static void merge(int[] arr, int left, int mid, int right) {
        int n1 = mid - left + 1, n2 = right - mid;
        int[] L = new int[n1], R = new int[n2];

        for (int i = 0; i < n1; i++) L[i] = arr[left + i];
        for (int i = 0; i < n2; i++) R[i] = arr[mid + 1 + i];

        int i = 0, j = 0, k = left;
        while (i < n1 && j < n2) {
            comparisons++;
            if (L[i] <= R[j]) arr[k++] = L[i++];
            else              arr[k++] = R[j++];
        }
        while (i < n1) arr[k++] = L[i++];
        while (j < n2) arr[k++] = R[j++];
    }

    static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int pivotIndex = partition(arr, low, high);
            quickSort(arr, low, pivotIndex - 1);
            quickSort(arr, pivotIndex + 1, high);
        }
    }

    static int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = low - 1;
        for (int j = low; j < high; j++) {
            comparisons++;
            if (arr[j] <= pivot) {
                i++;
                int temp = arr[i]; arr[i] = arr[j]; arr[j] = temp;
            }
        }
        int temp = arr[i + 1]; arr[i + 1] = arr[high]; arr[high] = temp;
        return i + 1;
    }

    static int[] generateRandomArray(int size) {
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) arr[i] = (int) (Math.random() * 1000);
        return arr;
    }

    static int[] copyArray(int[] src) {
        int[] copy = new int[src.length];
        for (int i = 0; i < src.length; i++) copy[i] = src[i];
        return copy;
    }
}
