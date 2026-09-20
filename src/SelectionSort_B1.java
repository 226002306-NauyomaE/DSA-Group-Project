public class SelectionSort_B1 {
    public static void main(String[] args){
        int[] arr = {17,5,23,8,14,3,11,20,6,9};
        int comps=0, swaps=0;
        for(int i=0;i<arr.length-1;i++){
            int min=i;
            for(int j=i+1;j<arr.length;j++){ comps++; if(arr[j]<arr[min]) min=j; }
            if(min!=i){ int t=arr[i]; arr[i]=arr[min]; arr[min]=t; swaps++; }
            if(i<3){ System.out.print("Pass "+(i+1)+": "); print(arr); System.out.println(" comps="+comps+" swaps="+swaps); }
        }
        System.out.println("Final sorted: "); print(arr);
        System.out.println("Total comps=45 swaps="+swaps);
    }
    static void print(int[] a){ for(int v:a) System.out.print(v+" "); System.out.println(); }
          }
