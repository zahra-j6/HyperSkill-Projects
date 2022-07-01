package bullscows;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Main {
    static String getsecret(int len, String temp) {
        String secret = "";
        int i = 0;
        while (secret.length() < len) {
            try {
                char a = temp.charAt(i);
                if (i == 0)
                { if(a != '0' && !secret.contains(Character.toString(a)))
                    secret += a;
                }
                else if ( !secret.contains(Character.toString(a)))
                    secret += a;
                i++;
            } catch (Exception e) {
                return secret;
            }
        }
        return secret;

    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Input the length of the secret code:");
        String length = scan.nextLine();
        int len = 0;
        try{
            len = Integer.parseInt(length);
        } catch (Exception e){
            System.out.printf("\nError: \"%s\" isn't a valid number.",length);
            System.exit(0);
        }
        System.out.println("Input the number of possible symbols in the code:");
        int symlen = scan.nextInt();

        // Or the number of possible symbols is less than the length of the code?
        if(len>symlen || len==0)
        {
            System.out.printf("\nError: it's not possible to generate a code with a length of %d with %d unique symbols.",len,symlen);
            System.exit(0);
        }
        if(symlen>36){
            System.out.println("Error: maximum number of possible symbols in the code is 36 (0-9, a-z).");
            System.exit(0);
        }

        String secret = "", stmt="" ;
        String alphanumeric = "abcdefghijklmnopqrstuvwxyz";
        symlen-=10;
        char alpha =' ';
        if (symlen>0)
            alpha = alphanumeric.charAt(symlen-1);

        if (len>36)
            System.out.printf("Error: can't generate a secret number with a length of %d because there aren't enough unique digits.",len);
        else {

            ArrayList<String> index = new ArrayList<>();

            if (symlen < 1){
                while(secret.length()!=len) {
                    Random random = new Random();
                    int randomNum = random.nextInt((9 - 0) + 1) + 0;
                    if (!index.contains(String.valueOf(randomNum))) {
                        secret += String.valueOf(randomNum);
                        stmt += "*";
                        index.add(String.valueOf(randomNum));
                    }

                }
            } else {
                while (secret.length() != len) {
                    Random random = new Random();
                    int randomNum = random.nextInt((9 - 0) + 1) + 0;

                    if (secret.length() % 2 == 0 ) {

                        if (!index.contains(String.valueOf(randomNum))) {
                            secret += String.valueOf(randomNum);
                            stmt += "*";
                            index.add(String.valueOf(randomNum));
                        }

                    } else  {
                        int r = random.nextInt(symlen);
                        char val = alphanumeric.charAt(r);
                        if (!index.contains(String.valueOf(val))) {
                            secret += val;
                            if ((int) alpha < (int) val)
                                alpha = val;
                            index.add(String.valueOf(val));
                        }

                    }
                    stmt += "*";

                }
            }



        }

        if (symlen < 1)
            System.out.printf("\nThe secret is prepared: %s (0-9).",stmt);
        else
            System.out.printf("\nThe secret is prepared: %s (0-9, a-%s).",stmt,alpha);
        System.out.println("\nOkay, let's start a game!");
        boolean won=false;
        int turn=1;
        while (won !=true){
            System.out.printf("\nTurn %d:",turn);
            String digit = scan.next();
            int cows=0,bull=0;
            int i=0;
            while (i<len){
                if(secret.equals(digit)) {
                    bull = len;
                    won=true;
                    break;
                }
                else {
                    char a = digit.charAt(i);
                    if (secret.contains(Character.toString(a)) && secret.indexOf(a) == i) {
                        bull++;
                    }
                    else if (secret.contains(Character.toString(a))) {
                        cows++;
                    }

                }
                i++;
            }
            turn++;
            if(cows==0 && bull ==0)
                System.out.println("Grade: None.");
            else if(cows>0 && bull==0)
                System.out.printf("\nGrade: %d cow(s).",cows);
            else if( cows==0 && bull>0)
                System.out.printf("\nGrade: %d bull(s).",bull);
            else
                System.out.printf("\nGrade: %d bull(s) and %d cow(s).",bull,cows);





        }
        System.out.println(secret);
        System.out.println("\nCongratulations! You guessed the secret code.");







    }

}
