//15. Develop a Banking System with Savings and Current accounts using method overriding.

class Bank_system{
    void bank_id(int id){
        System.out.println("Bank id is: "+id);
    }
}
class Savings extends Bank_system{
    void bank_id(int id){
        System.out.println("Bank id is: "+id);
    }
}
class Current extends Bank_system{
    void bank_id(int id){
        System.out.println("Bank id is: "+id);
    }
}

public class Practice_15{
    public static void main(String[] args){
        Savings s = new Savings();
        Current c = new Current();
        s.bank_id(101);
        c.bank_id(102);
    }
}