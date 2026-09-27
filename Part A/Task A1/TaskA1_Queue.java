class Student {
    String studentNo;
    String name;
    String serviceType;
    int estTime;

    Student(String studentNo, String name, String serviceType, int estTime) {
        this.studentNo = studentNo;
        this.name = name;
        this.serviceType = serviceType;
        this.estTime = estTime;
    }

    public String toString() {
        return studentNo + " | " + name + " | " + serviceType + " | " + estTime + " min";
    }
}

class Node {
    Student data;
    Node next;

    Node(Student data) {
        this.data = data;
        this.next = null;
    }
}

class StudentQueue {
    private Node front;
    private Node rear;
    private int size;

    public StudentQueue() {
        front = null;
        rear = null;
        size = 0;
    }

    public void enqueue(Student s) {
        Node newNode = new Node(s);
        if (isEmpty()) {
            front = newNode;
            rear = newNode;
        } else {
            rear.next = newNode;
            rear = newNode;
        }
        size = size + 1;
        System.out.println("Enqueued: " + s.name);
    }

    public Student dequeue() {
        if (isEmpty()) {
            System.out.println("Queue is empty. No student to serve.");
            return null;
        }
        Student served = front.data;
        front = front.next;
        if (front == null) {   
            rear = null;
        }
        size = size - 1;
        return served;
    }

    public Student peek() {
        if (isEmpty()) {
            System.out.println("Queue is empty.");
            return null;
        }
        return front.data;
    }

    public boolean isEmpty() {
        return front == null;
    }

    public void displayQueue() {
        if (isEmpty()) {
            System.out.println("Waiting queue is empty.");
            return;
        }
        System.out.println("FRONT -> REAR");
        Node current = front;
        int position = 1;
        while (current != null) {
            System.out.println(position + ". " + current.data);
            current = current.next;
            position++;
        }
        System.out.println("Total waiting: " + size);
    }
}

public class TaskA1_Queue {
    public static void main(String[] args) {
        StudentQueue queue = new StudentQueue();

        System.out.println("=== Empty check ===");
        System.out.println("isEmpty(): " + queue.isEmpty());

        System.out.println("\n=== Six arrivals ===");
        queue.enqueue(new Student("221045678", "Maria", "Registration", 12));
        queue.enqueue(new Student("222034512", "Tomas", "Student Card", 5));
        queue.enqueue(new Student("223041876", "Ndapewa", "Fees", 8));
        queue.enqueue(new Student("221067341", "Simon", "Documents", 4));
        queue.enqueue(new Student("224011223", "Anna", "Academic Enquiry", 10));
        queue.enqueue(new Student("220098765", "David", "Fees", 6));

        System.out.println("\n=== Queue after arrivals ===");
        queue.displayQueue();

        System.out.println("\n=== Peek ===");
        System.out.println("Next to be served: " + queue.peek());

        System.out.println("\n=== Serving three students ===");
        for (int i = 1; i <= 3; i++) {
            Student s = queue.dequeue();
            System.out.println("Served #" + i + ": " + s);
        }

        System.out.println("\n=== Queue after serving ===");
        queue.displayQueue();

        System.out.println("\n=== Peek and isEmpty ===");
        System.out.println("Next to be served: " + queue.peek());
        System.out.println("isEmpty(): " + queue.isEmpty());
    } }
