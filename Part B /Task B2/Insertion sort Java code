class Main {
    public static void main(String[] args) {
        int array [] = {17,5,23,8,14,3,11,20,6,9};
        int comparisons = 0;
        int shifts = 0;

        for(int i = 1; i < 10; i++){
            int temp = array[i];
            int j = i - 1;

            while(j >= 0){
                comparisons++;
                if(array[j] > temp){
                    array [j + 1] = array[j];
                    shifts++;
                    j =j -1;
                
                } else {
                    break;
                
                }
            }
              array[j + 1]  = temp;
            
        }
        System.out.print("Sorted array : ");
        for(int num : array){
            System.out.print(num + " ");
        }
        System.out.println("\nTotal Comparisons: " + comparisons);
        System.out.println("Total Shifts: " + shifts);
    }
}
