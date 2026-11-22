//27. Manage movies using a Vector.

import java.util.*;
public class Practice_27{
    public static void main(String[] args){
        Vector <String> movies = new Vector<>();
        movies.add("Spider-man");
        movies.add("Iron-man");
        movies.add("Captain-America");
        movies.add("Black-panter");
        System.out.println("\n\nList of movies is: "+movies);

        System.out.println("\nRemoving Captain-America");
        movies.remove("Captain-America");

        System.out.print("\nIs captain-america: ");
        System.out.print(movies.contains("Captain-America"));
    }
}