package bullscows;

import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
       Scanner scan = new Scanner(System.in);
       String digit = scan.next();
//       int random = (int) Math.random();
//       random=(random*9000)+1000;
        Random rand = new Random();
        int randomNum = rand.nextInt((9999 - 1000) + 1) + 1000;
        String id = String.format("%d", randomNum).trim();
        int cows=0,bull=0;
        int i=0;
        while (i<4){
            if(id.equals(digit))
                bull=4;
            else {
                char a = digit.charAt(i);
                if (id.contains(Character.toString(a)) && id.indexOf(a) == i) {
                    bull++;
                    id=id.replace(Character.toString(a),"");
                }
                else if (id.contains(Character.toString(a))) {
                    cows++;
                    id=id.replace(Character.toString(a),"");
                }

            }
            i++;
        }
        if(cows>0 && bull==0)
            System.out.printf("Grade: %d cow(s). The secret code is %d.",cows,randomNum);
        else if( cows==0 && bull>0)
            System.out.printf("Grade: %d bull(s). The secret code is %d.",bull,randomNum);
        else
            System.out.printf("Grade: %d bull(s) and %d cow(s). The secret code is %d.",bull,cows,randomNum);







    }
}
