package cinema;
import java.util.Scanner;
public class Cinema {

    public static void main(String[] args) {
        // Write your code here
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter the number of rows:");
        int rows = scan.nextInt() ;
        System.out.println("Enter the number of seats in each row:");
        int seats  = scan.nextInt() ;

        String matrix[][]=new String[rows][seats];
        int row_number=-1, seat=-1, inp=-1, cnt=0,first_half=0,second_half=0, current_income=0;
        double per=0.00f;
        int total = rows * seats*10;
        if (total > 600) {
             first_half = rows / 2;
             second_half = (rows / 2 )+ (rows % 2);
             total = ( first_half *seats* 10 )+ (second_half *seats* 8);
        }

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < seats; j++) {
                matrix[i][j] = "S";
            }
        }
        while(inp!=0) {

        System.out.println("\n1. Show the seats\n" +
                "2. Buy a ticket\n" +
                "3. Statistics\n" +
                "0. Exit");
         inp=scan.nextInt();
            switch (inp) {
                case 1:
                    if (row_number == -1) {
                        System.out.println();
                        System.out.println("Cinema:");
                        System.out.print("  1 ");
                        for (int i = 2; i <= seats; i++)
                            System.out.print(i + " ");

                        System.out.println();
                        for (int i = 0; i < rows; i++) {
                            System.out.print(i + 1 + " ");
                            for (int j = 0; j < seats; j++) {
                                System.out.print("S ");
                                matrix[i][j]="S";
                            }
                            System.out.println();
                        }
                    } else {
                        System.out.println();
                        System.out.println("Cinema:");
                        System.out.print("  1 ");
                        for (int i = 2; i <= seats; i++)
                            System.out.print(i + " ");
                        System.out.println();

                        for (int i = 0; i < matrix.length; i++) {
                            System.out.print(i + 1 + " ");
                            for (int j = 0; j < matrix[i].length; j++) {
                                if (i + 1 == row_number && j + 1 == seat) {
                                    matrix[i][j]="B";
                                    System.out.print("B ");
                                }
                                else
                                    System.out.print(matrix[i][j]+" ");
                            }
                            System.out.println();
                        }
                    }
                    break;
                case 2:
                    cnt++;



                    System.out.println();
                    System.out.println("Enter a row number:");
                    row_number = scan.nextInt();
                    System.out.println("Enter a seat number in that row:");
                    seat = scan.nextInt();

                    while (row_number>=rows+1 || seat>=seats+1 ||  matrix[row_number-1][seat-1]!=null && (matrix[row_number-1][seat-1].equals("B"))) {
                        if(row_number>=rows+1 || seat>=seats+1)
                            System.out.println("Wrong input!");
                        else
                            System.out.println("That ticket has already been purchased!");
                        System.out.println("Enter a row number:");
                        row_number = scan.nextInt();
                        System.out.println("Enter a seat number in that row:");
                        seat = scan.nextInt();
                    }


                    System.out.println();
                    matrix[row_number-1][seat-1]="B";
                    if (total < 610) {
                        //  System.out.println("Total income:\n$"+total*10);
                        System.out.println("Ticket price: $10");
                        current_income=current_income+10;

                    } else {
                        if (first_half < row_number) {
                            System.out.println("Ticket price: $8");
                            current_income+=8;
                        }
                        else {
                            System.out.println("Ticket price: $10");
                            current_income+=10;
                        }

                    }
                    break;
                case 3:
                    System.out.println("Number of purchased tickets: " +cnt);
                     per=(double)(double)(100.0 * cnt) / (double)(rows * seats);
                    System.out.printf("Percentage: %1.2f%%",per);
                    System.out.println("\nCurrent income: $"+current_income );
                    System.out.println("Total income: $"+total);
                    break;
                case 0:
                    return;

            }


        }



    }
}
