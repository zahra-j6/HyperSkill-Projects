package tictactoe;
import java.util.Scanner;
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
        // impossible
        int row=0, col=0;
        String winner="";
        // Draw
        int X=0,O=0,dash=0;
        for(i=0;i<3;i++){
            for(int j=0;j<3;j++){
                if(matrix[i][j].equals("X"))
                    X++;
                else if(matrix[i][j].equals("O"))
                    O++;
                else
                    dash++;
            }
        }

        // wins
            // row wins
            if (matrix[0][0].equals(matrix[0][1]) && matrix[0][0].equals(matrix[0][2])){
                winner=matrix[0][0];
                row++;}
            if (matrix[1][0].equals(matrix[1][1]) && matrix[1][0].equals(matrix[1][2])){
                winner=matrix[1][0];
                row++;}
            if (matrix[2][0].equals(matrix[2][1]) && matrix[2][0].equals(matrix[2][2])){
                winner=matrix[2][0];
                row++;}

            // column wins
            if (matrix[0][0].equals(matrix[1][0]) && matrix[0][0].equals(matrix[2][0])){
                winner=matrix[0][0];
                col++;}
            if (matrix[0][1].equals(matrix[1][1]) && matrix[0][1].equals(matrix[2][1])){
                    winner=matrix[0][1];
                col++;}
            if (matrix[0][2].equals(matrix[1][2]) && matrix[0][2].equals(matrix[2][2])){
                    winner=matrix[2][2];
                col++;}
            // diagnol wins
            if (matrix[0][0].equals(matrix[1][1]) && matrix[0][0].equals(matrix[2][2]))
                System.out.println(matrix[0][0]+" wins");
            else if (matrix[0][2].equals(matrix[1][1]) && matrix[1][1].equals(matrix[2][0]))
                System.out.println(matrix[1][1]+" wins");

            // draws
            else if (dash==0 && row==0 && col==0)
                System.out.println("Draw");

            // impossible
            else if (row==2 ||col==2 || Math.abs(X-O)>=2 )
                System.out.println("Impossible");
            // row or column wins
            else if(row!=col )
                System.out.println(winner+" wins");

        // game not finished
            else if(dash>1 && row==0&& col==0)
            System.out.println("Game not finished");




         }
     }



