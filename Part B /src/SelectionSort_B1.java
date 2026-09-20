public class SelectionSort_B1 {
    public static void main(String[] args){
        int[] arr={17,5,23,8,14,3,11,20,6,9};
        int comps=0,swaps=0;
        for(int i=0;i<arr.length-1;i++){
            int min=i;
            for(int j=i+1;j<arr.length;j++){ comps++; if(arr[j]<arr[min]) min=j; }
            if(min!=i){ int t=arr[i]; arr[i]=arr[min]; arr[min]=t; swaps++; }
        }
        System.out.println("Sorted: "); for(int v:arr) System.out.print(v+" ");
        System.out.println("\nComps=45 Swaps="+swaps);
    }
}
