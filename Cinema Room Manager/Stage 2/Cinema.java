package cinema;
import java.util.Scanner;
public class Cinema {

    public static void main(String[] args) {
        // Write your code here
        System.out.println("Cinema:");
        System.out.println("  1 2 3 4 5 6 7 8");
        for( int i = 1 ;i< 8 ;i++){
            System.out.println(i + " S S S S S S S S");
            
        }
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter the number of rows:");
        int rows = scan.nextInt() ;
        System.out.println("Enter the number of seats in each row:");
        int seats  = scan.nextInt() ;
        int total = rows * seats;
        if(total < 61)
            System.out.println("Total income:\n$"+total*10);
        else{
            int first_half = rows / 2;
            int second_half = (rows / 2 )+ (rows % 2);
            total = ( first_half *seats* 10 )+ (second_half *seats* 8);
            System.out.println("Total income:\n$"+ total);
        }
    }
}
