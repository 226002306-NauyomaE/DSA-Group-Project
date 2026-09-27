public class SelectionSort {
    public static int comparisons = 0;
    public static int swaps = 0;
  
    public static void sort(int[] array) {
        int n = array.length;
        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < n; j++) {
              
                comparisons++;
                if (array[j] < array[minIndex]) {
                    // SET minIndex = j
                    minIndex = j;
                }
                
            }
         

            // IF minIndex != i THEN
            if (minIndex != i) {
                // SWAP array[i] WITH array[minIndex]
                int temp = array[i];
                array[i] = array[minIndex];
                array[minIndex] = temp;
                swaps++;
            }
          
            System.out.print("Pass " + (i + 1) + ": ");
            printArray(array);
        }
        
    }
   
    public static void printArray(int[] array) {
        System.out.print("[");
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i]);
            if (i < array.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("]");
    }

    public static void main(String[] args) {
      
        int[] array = {17, 5, 23, 8, 14, 3, 11, 20, 6, 9};

        System.out.println("=== Selection Sort - Part B1 ===");
        System.out.print("Original Array: ");
        printArray(array);
        System.out.println();
      
        sort(array);

        System.out.println();
        System.out.print("Final Sorted Array: ");
        printArray(array);
        System.out.println();
        System.out.println("Total Comparisons: " + comparisons);
        System.out.println("Total Swaps:       " + swaps);
    }
}
