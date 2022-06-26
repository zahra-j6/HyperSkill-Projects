package machine;
import java.util.Scanner;
public class CoffeeMachine {
    private static void basic_info(int water, int milk, int beans, int cups, int money) {
        System.out.println("The coffee machine has:\n" +water+
                " ml of water\n" +milk+
                " ml of milk\n" +beans+
                " g of coffee beans\n" +cups+
                " disposable cups\n$" +money+
                " of money");
    }
    
    public static void main(String[] args) {
         Scanner scan = new Scanner(System.in);
       /* System.out.println("Starting to make a coffee\nGrinding coffee beans\nBoiling water\nMixing boiled water with crushed coffee beans\nPouring coffee into the cup\nPouring some milk into the cup\nCoffee is ready!");
        System.out.print("Write how many cups of coffee you will need: ");
        
        int val = scan.nextInt();
        System.out.println("For "+val+" cups of coffee you will need:\n"+val*200+" ml of water\n"+val*50+" ml of milk\n"+val*15+" g of coffee beans");
        */
        int water =400, milk =540, beans=120, cups=9, money=550;
        basic_info(water, milk, beans, cups, money);


        System.out.println();
        System.out.println("Write action (buy, fill, take): ");
        String inp=scan.nextLine();
        switch (inp) {
            case "buy":
                System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino: ");
                int choice = scan.nextInt();
                if(choice == 1) {
                    water-=250;
                    beans-=16;
                    money+=4;
                    cups--;
                    basic_info(water,milk,beans,cups,money);

                } else if (choice == 2) {
                    water-=350;
                    milk-=75;
                    beans-=20;
                    money+=7;
                    cups--;
                    basic_info(water,milk,beans,cups,money);
                } else {
                    water-=200;
                    milk-=100;
                    beans-=12;
                    money+=6;
                    cups--;
                    basic_info(water,milk,beans,cups,money);
                }
                break;
            case "fill":
                System.out.println("Write how many ml of water you want to add:");
                water=water+scan.nextInt();
                System.out.println("Write how many ml of milk you want to add:");
                milk=milk+ scan.nextInt();
                System.out.println("Write how many grams of coffee beans you want to add: ");
                beans+=scan.nextInt();
                System.out.println("Write how many disposable cups of coffee you want to add: ");
                cups+=scan.nextInt();
                basic_info(water,milk,beans,cups,money);
                break;
            case "take":
                System.out.println("I gave you $"+money+"\n");
                money=0;
                basic_info(water,milk,beans,cups,money);
                break;
        }







    }


}
