package tictactoe;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        // write your code here
         Scanner scan = new Scanner(System.in);
         System.out.println("Enter cells:");
         String inp = scan.next();
         System.out.println("---------\n|"+" "+inp.charAt(0)+" "+inp.charAt(1)+" "+inp.charAt(2)+" |\n| "+inp.charAt(3)+" "+inp.charAt(4)+" "+inp.charAt(5)+" |\n| "+inp.charAt(6)+" "+inp.charAt(7)+" "+inp.charAt(8)+" |\n---------");
         
    }
}
