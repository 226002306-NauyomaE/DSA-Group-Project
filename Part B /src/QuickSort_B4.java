public class QuickSort_B4 {
    public static void main(String[] args){
        int[] arr={17,5,23,8,14,3,11,20,6,9};
        quickSort(arr,0,arr.length-1);
        for(int v:arr) System.out.print(v+" ");
    }
    static void quickSort(int[] a,int low,int high){
        if(low>=high) return;
        int pivot=a[low]; int i=low+1,j=high;
        while(i<=j){
            while(i<=high&&a[i]<=pivot) i++;
            while(j>=low&&a[j]>pivot) j--;
            if(i<j){ int t=a[i]; a[i]=a[j]; a[j]=t; }
        }
        int t=a[low]; a[low]=a[j]; a[j]=t;
        quickSort(a,low,j-1); quickSort(a,j+1,high);
    }
                                        }
