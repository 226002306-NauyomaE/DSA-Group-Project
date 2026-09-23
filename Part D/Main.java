import java.util.Scanner;

public class Main {

    // --- 1. STUDENT DATA ---
    static class Student {
        String no, name, type;
        int time;
        Student(String n, String na, String t, int tm) { no=n; name=na; type=t; time=tm; }
        void show() { System.out.println("  " + no + " | " + name + " | " + type + " | " + time + " mins"); }
    }

    // --- 2. LINKED LIST NODE (For Service Records) ---
    static class Node {
        Student data; Node next;
        Node(Student s) { data = s; next = null; }
    }

    // --- 3. GLOBAL VARIABLES ---
    static Student[] queue = new Student[100]; // Queue using an array
    static int front = 0, rear = 0, queueSize = 0;

    static Node head = null; // Linked List head

    static int[] times = new int[500]; // Array for statistics
    static int servedCount = 0;
    
    // Global counter for sorting comparisons
    static int comparisons = 0; 

    static Scanner sc = new Scanner(System.in);

    // --- 4. MAIN MENU ---
    public static void main(String[] args) {
        while (true) {
            System.out.println("\n===== CAMPUS SERVICE CENTRE =====");
            System.out.println("1. Add student to queue");
            System.out.println("2. Serve next student");
            System.out.println("3. Display waiting students");
            System.out.println("4. Add service record");
            System.out.println("5. Display service records");
            System.out.println("6. Search record");
            System.out.println("7. Remove record");
            System.out.println("8. Daily statistics");
            System.out.println("9. Sort service times");
            System.out.println("10. Run sorting experiment");
            System.out.println("11. Exit");
            System.out.print("Choice: ");

            int choice;
            try { choice = Integer.parseInt(sc.nextLine()); } 
            catch (Exception e) { System.out.println("Invalid."); continue; }

            if (choice == 1) addToQueue();
            else if (choice == 2) serveStudent();
            else if (choice == 3) showQueue();
            else if (choice == 4) addRecord();
            else if (choice == 5) showRecords();
            else if (choice == 6) searchRecord();
            else if (choice == 7) deleteRecord();
            else if (choice == 8) showStatistics();
            else if (choice == 9) sortTimes();
            else if (choice == 10) runExperiment();
            else if (choice == 11) { System.out.println("Goodbye!"); break; }
            else System.out.println("Invalid option.");
        }
    }

    // --- OPTION 1: Add to Queue ---
    static void addToQueue() {
        System.out.print("Student No: "); String no = sc.nextLine();
        System.out.print("Name: ");       String name = sc.nextLine();
        System.out.print("Service: ");    String type = sc.nextLine();
        System.out.print("Time (mins): "); int time = Integer.parseInt(sc.nextLine());

        queue[rear] = new Student(no, name, type, time);
        rear++; queueSize++;
        System.out.println("Added to queue.");
    }

    // --- OPTION 2: Serve Student ---
    static void serveStudent() {
        if (queueSize == 0) { System.out.println("Queue empty."); return; }
        Student s = queue[front];
        front++; queueSize--;
        times[servedCount++] = s.time; // Save time for statistics
        System.out.println("Served: " + s.name);
    }

    // --- OPTION 3: Display Queue ---
    static void showQueue() {
        if (queueSize == 0) { System.out.println("Queue empty."); return; }
        for (int i = front; i < rear; i++) queue[i].show();
    }

    // --- OPTION 4: Add Service Record (Linked List) ---
    static void addRecord() {
        System.out.print("Student No: "); String no = sc.nextLine();
        System.out.print("Name: ");       String name = sc.nextLine();
        System.out.print("Service: ");    String type = sc.nextLine();
        System.out.print("Time (mins): "); int time = Integer.parseInt(sc.nextLine());

        Node newNode = new Node(new Student(no, name, type, time));
        if (head == null) head = newNode;
        else {
            Node cur = head;
            while (cur.next != null) cur = cur.next;
            cur.next = newNode;
        }
        System.out.println("Record added.");
    }

    // --- OPTION 5: Display Records ---
    static void showRecords() {
        if (head == null) { System.out.println("No records."); return; }
        Node cur = head;
        while (cur != null) { cur.data.show(); cur = cur.next; }
    }

    // --- OPTION 6: Search Record ---
    static void searchRecord() {
        System.out.print("Student No to search: "); String no = sc.nextLine();
        Node cur = head;
        while (cur != null) {
            if (cur.data.no.equals(no)) { System.out.println("Found:"); cur.data.show(); return; }
            cur = cur.next;
        }
        System.out.println("Not found.");
    }

    // --- OPTION 7: Delete Record ---
    static void deleteRecord() {
        System.out.print("Student No to remove: "); String no = sc.nextLine();
        if (head == null) { System.out.println("Not found."); return; }
        if (head.data.no.equals(no)) { head = head.next; System.out.println("Removed."); return; }
        Node cur = head;
        while (cur.next != null) {
            if (cur.next.data.no.equals(no)) { cur.next = cur.next.next; System.out.println("Removed."); return; }
            cur = cur.next;
        }
        System.out.println("Not found.");
    }

    // --- OPTION 8: Daily Statistics (Manual) ---
    static void showStatistics() {
        if (servedCount == 0) { System.out.println("No students served."); return; }
        int total=0, max=times[0], min=times[0], over10=0;
        for (int i=0; i<servedCount; i++) {
            total += times[i];
            if (times[i] > max) max = times[i];
            if (times[i] < min) min = times[i];
            if (times[i] > 10) over10++;
        }
        System.out.println("Total served: " + servedCount);
        System.out.println("Total time:   " + total);
        System.out.println("Average:      " + ((double)total/servedCount));
        System.out.println("Max time:     " + max);
        System.out.println("Min time:     " + min);
        System.out.println("Over 10 mins: " + over10);
    }

    // --- OPTION 9: Sort Times ---
    static void sortTimes() {
        if (servedCount == 0) { System.out.println("Nothing to sort."); return; }
        int[] copy = new int[servedCount];
        for (int i=0; i<servedCount; i++) copy[i] = times[i];

        System.out.println("1.Selection 2.Insertion 3.Merge 4.Quick");
        System.out.print("Algorithm: "); int alg = Integer.parseInt(sc.nextLine());

        if (alg == 1) selectionSort(copy);
        else if (alg == 2) insertionSort(copy);
        else if (alg == 3) mergeSort(copy, 0, copy.length-1);
        else if (alg == 4) quickSort(copy, 0, copy.length-1);

        System.out.print("Sorted: ");
        for (int x : copy) System.out.print(x + " ");
        System.out.println();
    }

    // --- OPTION 10: Run Experiment---
    static void runExperiment() {
        int[] sizes = {20, 50, 100, 500};
        System.out.printf("%-15s %-10s %-15s %-15s\n", "Algorithm", "Size", "Comparisons", "Time (ns)");
        for (int size : sizes) {
            int[] arr = new int[size];
            for (int i=0; i<size; i++) arr[i] = (int)(Math.random()*1000);

            int[] a1=copy(arr), a2=copy(arr), a3=copy(arr), a4=copy(arr);

            // Selection Sort
            long t1=System.nanoTime(); 
            selectionSort(a1); 
            t1=System.nanoTime()-t1;
            int c1 = comparisons; // Capture count

            // Insertion Sort
            long t2=System.nanoTime(); 
            insertionSort(a2); 
            t2=System.nanoTime()-t2;
            int c2 = comparisons; // Capture count

            // Merge Sort
            comparisons = 0; // Reset before Merge Sort
            long t3=System.nanoTime(); 
            mergeSort(a3,0,a3.length-1); 
            t3=System.nanoTime()-t3;
            int c3 = comparisons; // Capture count

            // Quick Sort
            comparisons = 0; // Reset before Quick Sort
            long t4=System.nanoTime(); 
            quickSort(a4,0,a4.length-1); 
            t4=System.nanoTime()-t4;
            int c4 = comparisons; // Capture count

            System.out.printf("%-15s %-10d %-15d %-15d\n", "Selection Sort", size, c1, t1);
            System.out.printf("%-15s %-10d %-15d %-15d\n", "Insertion Sort", size, c2, t2);
            System.out.printf("%-15s %-10d %-15d %-15d\n", "Merge Sort", size, c3, t3);
            System.out.printf("%-15s %-10d %-15d %-15d\n", "Quick Sort", size, c4, t4);
        }
    }

    // --- SORTING HELPER METHODS ---
    static void selectionSort(int[] a) {
        comparisons = 0;
        for (int i=0; i<a.length-1; i++) {
            int min=i;
            for (int j=i+1; j<a.length; j++) {
                comparisons++;
                if (a[j]<a[min]) min=j;
            }
            int t=a[i]; a[i]=a[min]; a[min]=t;
        }
    }
    
    static void insertionSort(int[] a) {
        comparisons = 0;
        for (int i=1; i<a.length; i++) {
            int key=a[i], j=i-1;
            while (j>=0) {
                comparisons++;
                if (a[j]>key) { a[j+1]=a[j]; j--; }
                else break;
            }
            a[j+1]=key;
        }
    }
    
    static void mergeSort(int[] a, int l, int r) {
        if (l>=r) return;
        int m=(l+r)/2;
        mergeSort(a,l,m); mergeSort(a,m+1,r);
        int[] temp=new int[r-l+1]; int i=l, j=m+1, k=0;
        while (i<=m && j<=r) {
            comparisons++;
            temp[k++] = (a[i]<=a[j]) ? a[i++] : a[j++];
        }
        while (i<=m) temp[k++]=a[i++];
        while (j<=r) temp[k++]=a[j++];
        for (int x=0; x<temp.length; x++) a[l+x]=temp[x];
    }
    
    static void quickSort(int[] a, int low, int high) {
        if (low>=high) return;
        int pivot=a[high], i=low-1;
        for (int j=low; j<high; j++) {
            comparisons++;
            if (a[j]<=pivot) { i++; int t=a[i]; a[i]=a[j]; a[j]=t; }
        }
        int t=a[i+1]; a[i+1]=a[high]; a[high]=t;
        quickSort(a,low,i); quickSort(a,i+2,high);
    }
    
    static int[] copy(int[] src) {
        int[] c = new int[src.length];
        for (int i=0; i<src.length; i++) c[i]=src[i];
        return c;
    }
}
