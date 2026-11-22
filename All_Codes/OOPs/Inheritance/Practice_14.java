//14. Implement multilevel inheritance using Person, Teacher and Principal.


class New_Person{
    String name;
    void set_name(String name){
        this.name = name;
    }
}
class New_Principle extends New_Person{
    void manage_school(){
        System.out.printf("Principle %s managed school \n",super.name);
    }
}
class New_Teacher extends New_Principle{
    void teaches(){
        System.out.println("Teacher teaches students");
    }
}

public class Practice_14{
    public static void main(String[] args){
        New_Person p = new New_Person();
        New_Principle pr = new New_Principle();
        pr.set_name("Ravi");
        pr.manage_school();
        New_Teacher tr = new New_Teacher();
        tr.teaches();
        
    }
}