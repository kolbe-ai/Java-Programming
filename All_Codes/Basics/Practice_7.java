//7. Create a Teacher class that stores a teacher’s name,ID and scores from three performance reviews, 
// then calculates the average and assigns a grade.

class Teacher1{
    String t_name;
    int t_id;
    float score1;
    float score2;
    float score3;
    float avg_score;
    Teacher1(String name, int id, float score1, float score2, float score3){
        this.t_name = name;
        this.t_id = id;
        this.score1 = score1;
        this.score2 = score2;
        this.score3 = score3;
    }
    void calc_score(){
        avg_score = (score1+score2+score3)/3;
    }
    void display(){
        System.out.printf("\n\nTeacher Details\nName: %s\nID: %d \nAverage score: %.2f",t_name,t_id,score1,score2,score3);
    }
}

public class Practice_7{
    public static void main(String[] args){
        Teacher1 t1 = new Teacher1("Raju",01,100,99,98);
        t1.calc_score();
        Teacher1 t2 = new Teacher1("Ravi",02,99,99,100);
        t2.calc_score();
        t1.display();
        t2.display();
    }
}