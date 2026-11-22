
// Create a Student class and calculate grades.
import java.util.Scanner;
class Student{
    Scanner sc = new Scanner(System.in);
    String name;
    int rollno;
    float mark;
    char grade;
    void read(){
        System.out.print("Enter the student name: ");
        name = sc.nextLine();
        System.out.print("Enter the student rollno: ");
        rollno = sc.nextInt();
        System.out.print("Enter the student mark: ");
        mark = sc.nextFloat();
        if(mark>=90){
            grade = 'A';
        }else if(mark>=80){
            grade = 'B';
        }else if(mark>=70){
            grade = 'C';
        }else if(mark>=60){
            grade = 'D';
        }else if(mark>=50){
            grade = 'E';
        }else{
            grade = 'F';
        }
    }
    void display(){
        System.out.printf("\nStudent\nName: %s \nRollno: %d \nMark: %f \nGrade: %c\n\n",name,rollno,mark,grade);
    }
}

public class L7{
    public static void main(String[] args){
        Student s1 = new Student();
        s1.read();
        s1.display();
        Student s2 = new Student();
        s2.read();
        s2.display();
        Student s3 = new Student();
        s3.read();
        s3.display();
        Student s4 = new Student();
        s4.read();
        s4.display();
    }
}