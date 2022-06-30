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
                if (i == 0 && a != '0' || !secret.contains(Character.toString(a)))
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
       int len = scan.nextInt();
        if (len>10)
            System.out.printf("Error: can't generate a secret number with a length of %d because there aren't enough unique digits.",len);
        else {
            String secret = "";
            while(secret.length()!=len) {
                long pseudoRandomNumber = System.nanoTime();
                String temp=String.format("%d",pseudoRandomNumber);
               // System.out.println(pseudoRandomNumber);

                secret = getsecret(len, temp);
            }

            System.out.printf("The random secret number is %s.",secret);
        }






    }

}
