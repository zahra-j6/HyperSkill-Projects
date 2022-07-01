package tictactoe;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Random;
import java.util.Scanner;

public class Main {

    static void print_matrix(String [][] matrix){

        System.out.println("---------");
        for(int row=0;row<3;row++){
            System.out.print("| ");
            for(int col=0;col<3;col++) {
                if(matrix[row][col]==null)
                    System.out.print("  ");
                else
                    System.out.print(matrix[row][col]+" ");
            }
            System.out.print("|\n");

        }
        System.out.println("---------");

    }
    static boolean check_winner(String [][] matrix, int X, int O){
        try {

            if (matrix[0][0]!=null && matrix[0][0].equals(matrix[0][1]) && matrix[0][0].equals(matrix[0][2])) {
                System.out.println(matrix[0][0] + " wins");
                return true;
            }
            if (matrix[1][0]!=null&& matrix[1][0].equals(matrix[1][1]) && matrix[1][0].equals(matrix[1][2])) {
                System.out.println(matrix[1][0] + " wins");
                return true;
            }
            if (matrix[2][0]!=null&& matrix[2][0].equals(matrix[2][1]) && matrix[2][0].equals(matrix[2][2])) {
                System.out.println(matrix[2][0] + " wins");
                return true;
            }

            // column wins
            if (matrix[0][0]!=null && matrix[0][0].equals(matrix[1][0]) && matrix[0][0].equals(matrix[2][0])) {
                System.out.println(matrix[0][0] + " wins");
                return true;
            }
            if (matrix[0][1]!=null && matrix[0][1].equals(matrix[1][1]) && matrix[0][1].equals(matrix[2][1])) {
                System.out.println(matrix[0][1] + " wins");
                return true;
            }
            if (matrix[2][2]!=null && matrix[0][2].equals(matrix[1][2]) && matrix[0][2].equals(matrix[2][2])) {
                System.out.println(matrix[2][2] + " wins");
                return true;
            }
            // diagnol wins
            if (matrix[0][0]!=null && matrix[0][0].equals(matrix[1][1]) && matrix[0][0].equals(matrix[2][2])) {
                System.out.println(matrix[0][0] + " wins");
                return true;
            } else if (matrix[1][1]!=null && matrix[0][2].equals(matrix[1][1]) && matrix[1][1].equals(matrix[2][0])) {
                System.out.println(matrix[1][1] + " wins");
                return true;
            }
            // Draw
            else if (X+O==9) {
                System.out.println("Draw");
                return true;
            }
            return false;
        }catch (Exception e) {
            return false;
        }

    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String input[]=new String[3];
        String param="";
        while (!param.equals("exit")){
            String matrix[][]=new String[3][3];
            int i=0, x=0,y=0, cnt=0,X=0,O=0, occ=0, player_move =0;
            boolean correct_inp=false;


            System.out.println("Input command:");
            input = scan.nextLine().split(" ");
            if (input[0].equals("exit") && input.length==1)
                param="exit";
            else if(input.length<3)
                System.out.println("Bad parameters!");
            else {
                // AI plays against AI or user plays against user
                if (input[1].equals(input[2])){
                    // AI plays against AI
                    if (input[1].equals("easy")) {
                        print_matrix(matrix);
                        System.out.println("Making move level \"easy\"");
                        while (correct_inp != true) {
                            Random random = new Random();
                            x = random.nextInt(3) + 1;
                            y = random.nextInt(3) + 1;

                            if (matrix[x - 1][y - 1] != null && !matrix[x - 1][y - 1].equals("_")) {
                                if (player_move % 2 == 1)
                                    System.out.println("This cell is occupied! Choose another one!");
                                occ++;
                                if (occ == 9) {
                                    System.out.println("Draw");
                                    correct_inp = true;
                                }
                            } else if (matrix[x - 1][y - 1] == null || matrix[x - 1][y - 1].equals("_")) {
                                if (X == 0 || X - O == 0) {
                                    matrix[x - 1][y - 1] = "X";
                                    X++;
                                } else {
                                    matrix[x - 1][y - 1] = "O";
                                    O++;
                                }
                                print_matrix(matrix);
                                System.out.println("Making move level \"easy\"");
                                cnt++;
                                if (cnt > 3)
                                        correct_inp = check_winner(matrix, X, O);

                            }
                        }

                    }

                    // user plays against user
                    else
                    {
                        print_matrix(matrix);
                        System.out.println("Making move level \"easy\"");
                        while(correct_inp!=true) {
                            System.out.println("Enter the coordinates: ");

                            try {
                                BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
                                String lines = br.readLine();
                                String[] strs = lines.trim().split("\\s+");
                                x = Integer.parseInt(strs[0]);
                                y = Integer.parseInt(strs[1]);
                            } catch (Exception e) {
                                System.out.println("You should enter numbers!");
                            }
                            if (x < 0 || x > 3 || y < 1 || y > 3)
                                System.out.println("Coordinates should be from 1 to 3!");
                            else if (matrix[x-1][y-1]!=null && !matrix[x-1][y-1].equals("_")) {
                                System.out.println("This cell is occupied! Choose another one!");
                                occ++;
                                if (occ == 9) {
                                    System.out.println("Draw");
                                    correct_inp=true;
                                }
                            }
                            else if (matrix[x-1][y-1]==null || matrix[x-1 ][y-1].equals("_")) {
                                if(X==0  || X-O==0) {
                                    matrix[x - 1][y - 1] = "X";
                                    X++;
                                    print_matrix(matrix);
                                    if (cnt > 3)
                                        correct_inp=check_winner(matrix,X,O);
                                    else
                                        System.out.println("Making move level \"easy\"");
                                }else{
                                    matrix[x-1][y-1]= "O";
                                    O++;
                                    print_matrix(matrix);
                                    if (cnt > 3)
                                        correct_inp=check_winner(matrix,X,O);
                                }
                                cnt++;
                                }
                            }
                        }
                    }
                // user plays against AI or AI plays against user
                else  {
                    print_matrix(matrix);
                    String chance ="";
                    System.out.println("Making move level \"easy\"");
                    int div=2;
                    if (input[1].equals("user")) {
                        div = 2;// user is player =0
                        player_move = 0;
                    }
                    else {
                        player_move =1;
                    }
                    while(correct_inp!=true) {

                        if (player_move%div==0) {
                            System.out.println("Enter the coordinates: ");

                            try {
                                BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
                                String lines = br.readLine();
                                String[] strs = lines.trim().split("\\s+");
                                x = Integer.parseInt(strs[0]);
                                y = Integer.parseInt(strs[1]);
                                chance ="user";
                            } catch (Exception e) {
                                System.out.println("You should enter numbers!");
                            }

                            }
                        else{
                            Random random = new Random();
                            x = random.nextInt(3)+1;
                            y = random.nextInt(3)+1;
                            chance="AI";
                            }

                        if (x < 0 || x > 3 || y < 1 || y > 3)
                            System.out.println("Coordinates should be from 1 to 3!");
                        else if (matrix[x-1][y-1]!=null && !matrix[x-1][y-1].equals("_")) {
                            if (chance.equals("user")) {
                                player_move--;
                                System.out.println("This cell is occupied! Choose another one!");
                            }
                            else
                                player_move--;
                            occ++;
                            if (occ == 9) {
                                System.out.println("Draw");
                                correct_inp=true;
                            }
                        }

                        else if (matrix[x-1][y-1]==null || matrix[x-1 ][y-1].equals("_")) {
                            if(X==0 || X-O==0) {
                                matrix[x - 1][y - 1] = "X";
                                X++;
                            }else{
                                matrix[x-1][y-1]= "O";
                                O++;
                            }
                            cnt++;

                            print_matrix(matrix);
                            if (cnt>3)
                                correct_inp=check_winner(matrix,X,O);
                            if (correct_inp!=true)
                                System.out.println("Making move level \"easy\"");


                        }
                        player_move++;
                    }
                }
            }
        }

    }
}
