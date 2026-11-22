//17. Implement runtime polymorphism in a Library Management System where Teacher and Guest members have different borrowing limits.

class Library_Management{
    int limit = 10;
    void borrow_limit(){
        System.out.println("Borrow Limit of the Normal user is: "+limit);
    }
}
class Teacher_ extends Library_Management{
    int limit = 12;
    void borrow_limit(){
        System.out.println("Borrow limit of the teachers is: "+limit);
    }
}
class Guest extends Library_Management{
    int limit = 5;
    void borrow_limit(){
        System.out.println("Borrow limit of the guest is: "+limit);
    }
}
public class Practice_17{
    public static void main(String[] args){
        Library_Management l = new Library_Management();
        l = new Teacher_();
        l.borrow_limit();
        l = new Guest();
        l.borrow_limit();
    }
}