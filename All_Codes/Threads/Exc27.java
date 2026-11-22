/*
Here is a classic, practical assignment question that tests the exact same concepts (threads, shared resources, race conditions, and synchronization) but uses a different real-world scenario.
Try to solve this one to solidify your understanding!

Practice Question: The Shared Bank ATM

Question: Write a Java program to simulate a shared Bank Account. The account starts with a balance of ₹5,000. Create 3 family member threads (e.g., Mom, Dad, Child) who all attempt to withdraw ₹2,000 from the same account at the exact same time via different ATMs.
1. Show what goes wrong (data corruption/negative balance) without using synchronized.
2. Fix it using synchronized so that the account balance never drops below zero and withdrawals are cleanly rejected when funds run out.

💡 Hints to help you write it:

• Create an Account class to hold the balance variable and a withdraw(int amount) method.
• Create a FamilyMember class that extends Thread and holds a reference to the shared Account.
• In your main method, make sure you create only one Account object instance and pass it to all three threads, just like you did with the ticket booking system.
Would you like to try writing the code for this ATM problem yourself first, or would you like me to show you the complete code solution so you can see how it works?

*/

import java.util.Scanner;
class Test extends Thread{
    public void run(){
        System.out.println("HellO :)");
    }
}
class Exc27{
    public static void main(String[] args){
        Test t1 = new Test();
        t1.start();
    }


}