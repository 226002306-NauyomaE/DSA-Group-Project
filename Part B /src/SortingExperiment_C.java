import java.util.Random;
public class SortingExperiment_C {
    public static void main(String[] args){
        int[] sizes={20,50,100,500};
        System.out.println("Algorithm | Size | Comparisons | Time(ns)");
        for(int n:sizes){
            int[] base=new int[n]; Random r=new Random(); for(int i=0;i<n;i++) base[i]=r.nextInt(1000);
            run("Selection",n,base.clone()); run("Insertion",n,base.clone());
            run("Merge",n,base.clone()); run("Quick",n,base.clone());
        }
    }
    static void run(String name,int n,int[] a){
        long s=System.nanoTime(); long c=0;
        if(name.equals("Selection")) c=sel(a); else if(name.equals("Insertion")) c=ins(a);
        else if(name.equals("Merge")){ long[] cc=new long[1]; mSort(a,0,a.length-1,cc); c=cc[0]; }
        else{ long[] cc=new long[1]; qSort(a,0,a.length-1,cc); c=cc[0]; }
        long e=System.nanoTime();
        System.out.println(name+" | "+n+" | "+c+" | "+(e-s));
    }
    static long sel(int[] a){ long c=0; for(int i=0;i<a.length-1;i++){ int min=i; for(int j=i+1;j<a.length;j++){ c++; if(a[j]<a[min]) min=j; } int t=a[i]; a[i]=a[min]; a[min]=t; } return c; }
    static long ins(int[] a){ long c=0; for(int i=1;i<a.length;i++){ int k=a[i],j=i-1; while(j>=0){ c++; if(a[j]>k){ a[j+1]=a[j]; j--; } else break; } a[j+1]=k; } return c; }
    static void mSort(int[] a,int l,int r,long[] c){ if(l>=r) return; int m=(l+r)/2; mSort(a,l,m,c); mSort(a,m+1,r,c); int[] L=new int[m-l+1]; int[] R=new int[r-m]; for(int i=0;i<L.length;i++) L[i]=a[l+i]; for(int j=0;j<R.length;j++) R[j]=a[m+1+j]; int i=0,j=0,k=l; while(i<L.length&&j<R.length){ c[0]++; if(L[i]<=R[j]) a[k++]=L[i++]; else a[k++]=R[j++]; } while(i<L.length) a[k++]=L[i++]; while(j<R.length) a[k++]=R[j++]; }
    static void qSort(int[] a,int lo,int hi,long[] c){ if(lo>=hi) return; int p=a[lo],i=lo+1,j=hi; while(i<=j){ while(i<=hi){ c[0]++; if(a[i]<=p) i++; else break; } while(j>=lo){ c[0]++; if(a[j]>p) j--; else break; } if(i<j){ int t=a[i]; a[i]=a[j]; a[j]=t; } } int t=a[lo]; a[lo]=a[j]; a[j]=t; qSort(a,lo,j-1,c); qSort(a,j+1,hi,c); }
                      }
