package bullscows;

import java.util.Random;
import java.util.Scanner;

public class Main {
    static String getsecret(int len, String temp) {
        String secret = "";
        int i = 0;
        while (secret.length() < len) {
            try {
                char a = temp.charAt(i);
                if (i != 0 && a != '0' && !secret.contains(Character.toString(a)))
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
        System.out.println("Please, enter the secret code's length:");
       int len = scan.nextInt();
        String secret = "";
        if (len>10)
            System.out.printf("Error: can't generate a secret number with a length of %d because there aren't enough unique digits.",len);
        else {

            while(secret.length()!=len) {
                long pseudoRandomNumber = System.nanoTime();
                StringBuilder sb = new StringBuilder(String.valueOf(pseudoRandomNumber));
                sb=sb.reverse();
                String temp=String.format("%s",sb);
               // System.out.println(pseudoRandomNumber);

                secret = getsecret(len, temp);
            }


        }
        String intial_secret = secret;

        System.out.println("Okay, let's start a game!");
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
            secret = intial_secret;




        }
        System.out.println(secret);
        System.out.println("\nCongratulations! You guessed the secret code.");







    }

}
