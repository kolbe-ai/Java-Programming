//8.Create a Book class with overloaded constructors.

class Book_1{
    int id;
    String title;
    String date = "";
    Book_1(int id, String title){
        this.id = id;
        this.title = title;
    }
    Book_1(int id, String title, String data){
        this.id = id;
        this.title = title;
        this.date = date;
    }
    void display(){
        if (date == ""){
            System.out.printf("\n\nBook ID: %d\nBook Title: %s\n",id,title);
            return;
        }
        System.out.printf("\n\nBook ID: %d\nBook Title: %s\nBook Date: %s\n",id,title,date);
    }
}

public class Practice_8{
    public static void main(String[] args){
        Book_1 b1 = new Book_1(101,"Harry Potter");
        Book_1 b2 = new Book_1(102,"Jungle Book","11-02-2000");
        b1.display();
        b2.display();
    }
}