public class InsertionSort_B2 {
    public static void main(String[] args){
        int[] arr={17,5,23,8,14,3,11,20,6,9};
        int comps=0,shifts=0;
        for(int i=1;i<arr.length;i++){
            int key=arr[i]; int j=i-1;
            while(j>=0){ comps++; if(arr[j]>key){ arr[j+1]=arr[j]; shifts++; j--; } else break; }
            arr[j+1]=key;
        }
        System.out.print("Sorted: "); for(int v:arr) System.out.print(v+" ");
        System.out.println("\nComps="+comps+" Shifts="+shifts);
    }
}
