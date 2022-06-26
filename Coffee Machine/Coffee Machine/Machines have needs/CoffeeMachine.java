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
        int water =400, milk =540, beans=120, cups=9, money=550, prev_water=water, prev_milk=milk,prev_beans=beans, prev_money=money;
        //basic_info(water, milk, beans, cups, money);


        System.out.println();
        String inp="";
        while(!inp.equals("exit")) {
            System.out.println("Write action (buy, fill, take,remaining,exit): ");
            inp=scan.next();
            switch (inp) {
                case "buy":
                    System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu: ");
                    String choice = scan.next();
                    if (choice.equals("1")) {
                        prev_beans = beans;
                        prev_milk = milk;
                        prev_water = water;
                        prev_money=money;
                        water -= 250;
                        beans -= 16;
                        money += 4;
                        cups--;
                        //    basic_info(water,milk,beans,cups,money);

                    } else if (choice.equals("2")) {
                        prev_beans = beans;
                        prev_milk = milk;
                        prev_water = water;
                        prev_money=money;
                        water -= 350;
                        milk -= 75;
                        beans -= 20;
                        money += 7;
                        cups--;
                        //basic_info(water, milk, beans, cups, money);
                    } else  if (choice.equals("3")) {
                        prev_beans = beans;
                        prev_milk = milk;
                        prev_water = water;
                        prev_money=money;
                        water -= 200;
                        milk -= 100;
                        beans -= 12;
                        money += 6;
                        cups--;
                        //   basic_info(water,milk,beans,cups,money);
                    } else {
                        break;
                    }
                    if (water < 0 || milk < 0 || beans < 0) {
                        if (water < 0)
                            System.out.println("Sorry, not enough water!");
                        else if (milk < 0)
                            System.out.println("Sorry, not enough milk!");
                        else
                            System.out.println("Sorry, not enough beans!");
                        water = prev_water;
                        beans = prev_beans;
                        milk = prev_milk;
                        prev_money=money;
                        cups++;
                    } else
                        System.out.println("I have enough resources, making you a coffee!");
                    break;
                case "fill":
                    System.out.println("Write how many ml of water you want to add:");
                    water = water + scan.nextInt();
                    System.out.println("Write how many ml of milk you want to add:");
                    milk = milk + scan.nextInt();
                    System.out.println("Write how many grams of coffee beans you want to add: ");
                    beans += scan.nextInt();
                    System.out.println("Write how many disposable cups of coffee you want to add: ");
                    cups += scan.nextInt();
                    // basic_info(water,milk,beans,cups,money);
                    break;
                case "take":
                    System.out.println("I gave you $" + money + "\n");
                    money = 0;

                    break;

                case "exit":
                    System.exit(0);
                    break;
                case "remaining":
                    basic_info(water, milk, beans, cups, money);
                    break;

            }

        }





    }


}
