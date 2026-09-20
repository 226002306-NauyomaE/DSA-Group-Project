public class StudentLinkedList {
    class Node {
        Student data;
        Node next;
        Node(Student data){ this.data=data; }
    }
    Node head;

    public void insertAtBeginning(Student s){
        Node newNode = new Node(s);
        newNode.next = head;
        head = newNode;
        System.out.println("Inserted at beginning: " + s.name);
    }

    public void insertAtEnd(Student s){
        Node newNode = new Node(s);
        if(head==null){ head=newNode; return; }
        Node curr=head;
        while(curr.next!=null) curr=curr.next;
        curr.next=newNode;
        System.out.println("Inserted at end: " + s.name);
    }

    public void insertAtPosition(Student s, int position){
        if(position<=1){ insertAtBeginning(s); return; }
        Node newNode = new Node(s);
        Node curr=head;
        for(int i=1; i<position-1 && curr!=null; i++) curr=curr.next;
        if(curr==null){ insertAtEnd(s); return; }
        newNode.next=curr.next;
        curr.next=newNode;
        System.out.println("Inserted at position "+position+": "+s.name);
    }

    public boolean deleteStudent(String studentNo){
        if(head==null) return false;
        if(head.data.studentNo.equals(studentNo)){
            head=head.next; System.out.println("Deleted: "+studentNo); return true;
        }
        Node curr=head;
        while(curr.next!=null && !curr.next.data.studentNo.equals(studentNo)) curr=curr.next;
        if(curr.next==null) return false;
        curr.next=curr.next.next;
        System.out.println("Deleted: "+studentNo);
        return true;
    }

    public Student searchStudent(String studentNo){
        Node curr=head;
        while(curr!=null){
            if(curr.data.studentNo.equals(studentNo)) return curr.data;
            curr=curr.next;
        }
        return null;
    }

    public void displayStudents(){
        if(head==null){ System.out.println("List empty"); return; }
        Node curr=head;
        System.out.println("\n--- Student Service Records ---");
        while(curr!=null){
            System.out.println(curr.data);
            curr=curr.next;
        }
        System.out.println("--------------------------------\n");
    
    }
