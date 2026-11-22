//17. Implement runtime polymorphism in a Library Management System.
class LMS{
    void disp(){
        System.out.println("Library gives books");
    }
}

class Student extends LMS{
    void disp(){
        System.out.println("Student have permission till 5th floor");
    }
}

class Faculty extends LMS{
    void disp(){
        System.out.println("Faculty have permission till 6th floor");
    }
}


public class L17{
    public static void main(String[] args){
        LMS s = new Student();
        s.disp();
        LMS f = new Faculty();
        f.disp();
    }
}