public class InsertionSort_B2 {
    public static void main(String[] args){
        int[] arr = {17,5,23,8,14,3,11,20,6,9};
        int comps=0, shifts=0;
        for(int i=1;i<arr.length;i++){
            int key=arr[i]; int j=i-1;
            int passComps=0;
            while(j>=0){ passComps++; comps++; if(arr[j]>key){ arr[j+1]=arr[j]; shifts++; j--; } else break; }
            arr[j+1]=key;
            if(i<=3){ System.out.print("Pass "+i+" key="+key+" comps="+passComps+" shifts: "); print(arr); }
        }
    }
    static void print(int[] a){ for(int v:a) System.out.print(v+" "); System.out.println(); }
}
