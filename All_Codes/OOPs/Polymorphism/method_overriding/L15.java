//15. Develop a Banking System using method overriding.
class SBI{
    void interest(){
        System.out.println("Normal interest rate in SBI head office is: 7%");
    }
}


class SBI_ekm extends SBI{
    void interest(){
        System.out.println("Normal interest rate in SBI eranakulam is: 7.5%");
    }
}

class SBI_thr extends SBI{
    void interest(){
        System.out.println("Normal interest rate in SBI Thrissur is: 6.5%");
    }
}
public class L15{
    public static void main (String[] args){
        SBI s1 = new SBI();    //no polymorphism 
        s1.interest();
        SBI s2 = new SBI_ekm();   //polymorphism
        s2.interest();
        SBI s3 = new SBI_thr();   //polymorphism
        s3.interest();
    }
}