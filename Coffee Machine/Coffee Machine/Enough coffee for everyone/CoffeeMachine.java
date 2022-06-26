package machine;
import java.util.Scanner;
public class CoffeeMachine {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
       /* System.out.println("Starting to make a coffee\nGrinding coffee beans\nBoiling water\nMixing boiled water with crushed coffee beans\nPouring coffee into the cup\nPouring some milk into the cup\nCoffee is ready!");
        System.out.print("Write how many cups of coffee you will need: ");
        
        int val = scan.nextInt();
        System.out.println("For "+val+" cups of coffee you will need:\n"+val*200+" ml of water\n"+val*50+" ml of milk\n"+val*15+" g of coffee beans");
        */
        
        System.out.println("Write how many ml of water the coffee machine has: ");
        int water = scan.nextInt();
        System.out.println("Write how many ml of milk the coffee machine has: ");
        int milk = scan.nextInt();
        System.out.println("Write how many grams of coffee beans the coffee machine has: ");
        int beans = scan.nextInt();
        System.out.println("Write how many cups of coffee you will need: ");
        int cups = scan.nextInt();
        int amt_of_coffee = water+milk+beans; 
        int amt_of_coffee_needed = 265 * cups; 
        int rem_water = water / 200;
        int rem_milk = milk / 50;
        int rem_beans = beans / 15;
        int min = Math.min(rem_water,rem_milk);
        min = Math.min(min , rem_beans);
        
        if (amt_of_coffee < amt_of_coffee_needed) {
            System.out.println("No, I can make only "+min+" cup(s) of coffee");
        }
        else if (amt_of_coffee > amt_of_coffee_needed &&  amt_of_coffee - amt_of_coffee_needed >0) {
           
            
            int rem_cups = min - cups;
            if(rem_cups > 0)
                System.out.println("Yes, I can make that amount of coffee (and even "+rem_cups+" more than that)");
            else
                System.out.println("Yes, I can make that amount of coffee ");

            
            
        }
        else
            System.out.println("Yes, I can make that amount of coffee ");
        
    }
}
