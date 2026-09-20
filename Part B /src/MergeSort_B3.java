public class MergeSort_B3 {
    static int comps=0;
    public static void main(String[] args){
        int[] arr={17,5,23,8,14,3,11,20,6,9};
        mergeSort(arr,0,arr.length-1);
        for(int v:arr) System.out.print(v+" ");
        System.out.println("\nComps="+comps);
    }
    static void mergeSort(int[] a,int l,int r){
        if(l>=r) return; int m=(l+r)/2;
        mergeSort(a,l,m); mergeSort(a,m+1,r); merge(a,l,m,r);
    }
    static void merge(int[] a,int l,int m,int r){
        int[] L=new int[m-l+1]; int[] R=new int[r-m];
        for(int i=0;i<L.length;i++) L[i]=a[l+i];
        for(int j=0;j<R.length;j++) R[j]=a[m+1+j];
        int i=0,j=0,k=l;
        while(i<L.length&&j<R.length){ comps++; if(L[i]<=R[j]) a[k++]=L[i++]; else a[k++]=R[j++]; }
        while(i<L.length) a[k++]=L[i++];
        while(j<R.length) a[k++]=R[j++];
    }
}
