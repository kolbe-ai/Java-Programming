//13. Design Animal, Dog, Cat and Bird classes using inheritance.
class New_Animal{
    void make_sound(){
        System.out.println("Animal making sound!");
    }
}
class New_dog extends New_Animal{
    void make_sound(){
        System.out.println("Buff buff buff!");
    }
}
class New_cat extends New_Animal{
    void make_sound(){
        System.out.println("Meoww Meoww Meooww!");
    }
}
class New_bird extends New_Animal{
    void make_sound(){
        System.out.println("Chew Chew Chew !!");
    }
}

public class Practice_13{
    public static void main(String[] args){
        New_dog dog = new New_dog();
        New_cat cat = new New_cat();
        New_bird bird = new New_bird();
        dog.make_sound();
        cat.make_sound();
        bird.make_sound();        
    }
}