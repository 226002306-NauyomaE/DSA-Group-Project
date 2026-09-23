// Online Java Compiler (Editor)

import java.util.Arrays;
class Main {
    public static void main(String[] args) {
     int[] inputSizes = {20, 50, 100, 500};
        
     long startTime;
     long endTime;
        
     long selectionTime;
     int selectionComp;

     long insertionTime;
     int insertionComp;

     int mergeComp;
     long mergeTime;

     long quickTime;
        
    System.out.println("Size\tSComp\tSTime\tIComp\tITime\tMComp\tMTime\tQComp\tQTime");
        
     for(int i=0; i<inputSizes.length; i++){
      int size = inputSizes[i];
      int[] originalArray = new int[size];

     for(int j=0; j<size; j++){
     originalArray[j] = (int)(Math.random() *1000) + 1;
    }
    int[] selectionArray = originalArray.clone();
    int[] insertionArray = originalArray.clone();
    int[] mergeArray = originalArray.clone();
    int[] quickArray = originalArray.clone();

    startTime = System.nanoTime();
    selectionComp = selectionSort(selectionArray);
    endTime =System.nanoTime();
    selectionTime = endTime - startTime;
    
    startTime = System.nanoTime();
    insertionComp = insertionSort(insertionArray);
    endTime = System.nanoTime();
    insertionTime = endTime - startTime;

    startTime = System.nanoTime();
    mergeComp = mergeSort(mergeArray, 0, size-1);
    endTime = System.nanoTime();
    mergeTime = endTime - startTime;

    quickComp = 0;
    startTime = System.nanoTime();   
    quickComp = quickSort(quickArray, 0, size-1);
    endTime = System.nanoTime();
    quickTime = endTime - startTime;

System.out.println(size + "\t" + selectionComp + "\t"  + selectionTime + "\t"   + insertionComp + "\t"   + insertionTime + "\t"    + mergeComp + "\t"   + mergeTime + "\t"   + quickComp + "\t"   + quickTime);
 
  if(size==100){
      int[] testSortArray = originalArray.clone();
      Arrays.sort(testSortArray);
      int temp;

    temp = testSortArray[0];
    testSortArray[0] =testSortArray[1];
    testSortArray[1] = temp;

    temp = testSortArray[10];
    testSortArray[10] = testSortArray[11];
    testSortArray[11] = temp;

    temp = testSortArray[20];
    testSortArray[20] = testSortArray[21];
    testSortArray[21] = temp;

    temp = testSortArray[30];
    testSortArray[30] =testSortArray [31];
    testSortArray[31] = temp;

    temp = testSortArray[40];
    testSortArray[40] = testSortArray[41];
    testSortArray [41] = temp;

    int[] selectionTest = testSortArray.clone();
    int[] insertionTest = testSortArray.clone();
    int[] mergeTest = testSortArray.clone();
    int[] quickTest =testSortArray .clone();

    startTime = System.nanoTime();
    selectionComp = selectionSort(selectionTest);
    endTime = System.nanoTime();
    selectionTime = endTime - startTime;

    startTime = System.nanoTime();
    insertionComp = insertionSort(insertionTest);
    endTime = System.nanoTime();
    insertionTime = endTime - startTime;

    startTime = System.nanoTime();
    mergeComp = mergeSort(mergeTest, 0, 99);
    endTime = System.nanoTime();
    mergeTime = endTime - startTime;

    startTime = System.nanoTime();
    quickComp = quickSort(quickTest, 0, 99);
    endTime = System.nanoTime();
    quickTime = endTime - startTime;

              System.out.println();
System.out.println("========================================");
System.out.println("ADDITIONAL TEST: ALMOST-SORTED ARRAY");
System.out.println("Input Size: 100");
System.out.println("========================================");

System.out.println();
System.out.println("Selection Sort");
System.out.println("Comparisons: " + selectionComp);
System.out.println("Execution Time (ns): " + selectionTime);

System.out.println();
System.out.println("Insertion Sort");
System.out.println("Comparisons: " + insertionComp);
System.out.println("Execution Time (ns): " + insertionTime);

System.out.println();
System.out.println("Merge Sort");
System.out.println("Comparisons: " + mergeComp);
System.out.println("Execution Time (ns): " + mergeTime);

System.out.println();
System.out.println("Quick Sort");
System.out.println("Comparisons: " + quickComp);
System.out.println("Execution Time (ns): " + quickTime);

System.out.println();
System.out.println("========================================");
  }
 }

    }
public static int selectionSort(int[] selectionArray){
        int selectionComp = 0;
        int minIndex;
        int temp;

    for(int i=0; i<selectionArray.length-1; i++){
     minIndex = i;

    for(int j=i+1; j<selectionArray.length; j++){
        selectionComp++;
    
        if(selectionArray[j] < selectionArray[minIndex]){
             minIndex = j;
        }    
    }
    temp = selectionArray[i];
    selectionArray[i] = selectionArray[minIndex];
    selectionArray[minIndex] = temp;
    }
   return selectionComp;
}
public static int insertionSort(int[] insertionArray){
    int insertionComp = 0;
    int temp1;
    int j;

    for(int i=1; i<insertionArray.length; i++){
     temp1 = insertionArray[i];
     j = i-1;

    while(j >= 0){
     insertionComp++;

    if(insertionArray[j] >temp1){
      insertionArray[j + 1] = insertionArray[j];
      j = j - 1;  
    }
      else{
          break;
      }
  }
    insertionArray[j + 1] = temp1;
    }
  return insertionComp;
    }
public static int mergeSort(int[] mergeArray, int left, int right){
    int mergeComp = 0;

     if(left < right){
     int mid = (left + right)/2;
     mergeComp += mergeSort(mergeArray, left, mid);
     mergeComp += mergeSort(mergeArray, mid + 1, right);
     mergeComp += merge(mergeArray, left, mid, right);
    }
  return mergeComp;
 }
public static int merge(int[] mergeArray, int left, int mid, int right){
  int mergeComp = 0;
  int i = left;
  int j = mid + 1;
  int k = 0;
  int tempArray[] = new int[right - left + 1];

  while(i <= mid && j<= right){
      mergeComp++;

  if(mergeArray[i] <= mergeArray[j]){
    tempArray[k] = mergeArray[i];
    i++;
  }
 else{
      tempArray[k] = mergeArray[j];
      j++;
      }
    k++;
  }
    while(i <= mid){
      tempArray[k] = mergeArray[i];
      i++;
      k++;
    }
    while(j <= right){
      tempArray[k] = mergeArray[j];
      j++;
      k++;
    }
 for(i=left; i<=right; i++){
    mergeArray[i] = tempArray[i-left];
    }
  return mergeComp;
}

static int quickComp = 0;
public static int quickSort(int[] quickArray, int left, int right){
   if(left < right){
   int pivotIndex = PARTITION(quickArray, left, right);

   quickSort(quickArray, left, pivotIndex - 1);
   quickSort(quickArray, pivotIndex + 1, right);
 }
 return quickComp;
}

public static int PARTITION(int[] quickArray, int left, int right){
    int pivot = quickArray[right];
    int i = left - 1;
    int j = left;
    int temp;
  
  while(j < right){
  quickComp = quickComp + 1;
    if(quickArray[j] <= pivot){
      i++;
    temp = quickArray[i];
    quickArray[i] = quickArray[j];
    quickArray[j] = temp;
        }
      j++;
}
   temp = quickArray[i + 1];
   quickArray[i + 1] = quickArray[right];
   quickArray[right] = temp;

   return i + 1;
 } 
} 
