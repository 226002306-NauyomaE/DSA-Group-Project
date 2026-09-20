public class Student {
    String studentNo, name, serviceType; int serviceTime;
    public Student(String n, String na, String s, int t){
        studentNo=n; name=na; serviceType=s; serviceTime=t;
    }
    public String toString(){ return studentNo+" - "+name+" - "+serviceType+" ("+serviceTime+"min)"; }
}
