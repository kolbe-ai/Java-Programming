public class Helloworld {
    public static void main(String[] args){
        int n = args.length;
        if(n == 0){
            System.out.println("No name, Sorry stranger!");
        }else{
            System.out.println("Your name is "+args[0]+" \nGood seeing you "+args[0]+" brother!");
        }
    }
}
