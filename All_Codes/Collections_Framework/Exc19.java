/*
Create an ArrayList<Student> (id, name, marks). Add 5 students, then: 
sort by marks (descending), remove the student with the lowest marks, and print the topper. 
Use a Comparator.
*/

import java.util.ArrayList;

class Student{
    int id;
    String name;
    float marks;
    Student(int id, String name, float marks){
        this.id = id;
        this.name = name;
        this.marks = marks;
    }
    void display(){
        System.out.printf("\nID: %d\nName: %s \nMarks: %.2f\n",id,name,marks);
    }
}

class Exc19{
    public static void main(String[] args){
        ArrayList <Student> student = new ArrayList<>();
        student.add(new Student(1,"Rahul",96));
        student.add(new Student(2,"Jacob",97));
        student.add(new Student(3,"Rajiv",98));
        student.add(new Student(4,"Henry",99));
        student.add(new Student(5,"Janvir",100));

        System.out.println("All students are: ");
        //removing and displaying student above mark
        for(int i = 0 ; i< student.size() ; i++){
            if (student.get(i).marks <98){
                student.remove(i);
            }
            student.get(i).display();
        }

    }
}