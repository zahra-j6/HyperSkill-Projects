package tictactoe;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) {
        // write your code here
         Scanner scan = new Scanner(System.in);
        System.out.println("Enter cells:");
        String inp = scan.next();
        System.out.println("---------\n|"+" "+inp.charAt(0)+" "+inp.charAt(1)+" "+inp.charAt(2)+" |\n| "+inp.charAt(3)+" "+inp.charAt(4)+" "+inp.charAt(5)+" |\n| "+inp.charAt(6)+" "+inp.charAt(7)+" "+inp.charAt(8)+" |\n---------");
        String matrix[][]=new String[3][3];
        int i=0;
        for(int row=0;row<3;row++){
            for(int col=0;col<3;col++) {
                matrix[row][col] = String.valueOf(inp.charAt(i));
                i++;
            }

        }
        boolean correct_inp=false;
        int x=0,y=0;
        while(correct_inp!=true) {
            System.out.println("Enter the coordinates: ");
            try
            {
                BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
                String  lines = br.readLine();
                String[] strs = lines.trim().split("\\s+");
                x= Integer.parseInt(strs[0]);
                y= Integer.parseInt(strs[1]);

                if (x < 0 || x > 3 || y < 1 || y > 3)
                    System.out.println("Coordinates should be from 1 to 3!");
                else if (!matrix[x-1][y-1].equals("_"))
                    System.out.println("This cell is occupied! Choose another one!");
                else if (matrix[x-1 ][y-1].equals("_")) {
                    matrix[x-1][y-1] = "X";
                    correct_inp = true;
                }
                else
                    System.out.println("You should enter numbers!");




            } catch (Exception e){
                System.out.println("You should enter numbers!");
            }
                

        }
        System.out.println("---------");
        for(int row=0;row<3;row++){
            System.out.print("| ");
            for(int col=0;col<3;col++) {
                System.out.print(matrix[row][col]+" ");
            }
            System.out.print("|\n");

        }
        System.out.println("---------");



         }
     }



