public class TestList {
    public static void main(String[] args){
        StudentLinkedList list = new StudentLinkedList();
        list.insertAtEnd(new Student("225100908","Amakali","Finance",15));
        list.insertAtBeginning(new Student("225100909","John","Registration",10));
        list.insertAtPosition(new Student("225100910","Maria","ID Card",5),2);
        list.displayStudents();
        System.out.println("Search 225100908: " + list.searchStudent("225100908"));
        list.deleteStudent("225100909");
        list.displayStudents();
    }
}
