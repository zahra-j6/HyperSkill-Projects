package machine;
import java.util.Scanner;
public class CoffeeMachine {
    public static void main(String[] args) {
        System.out.println("Starting to make a coffee\nGrinding coffee beans\nBoiling water\nMixing boiled water with crushed coffee beans\nPouring coffee into the cup\nPouring some milk into the cup\nCoffee is ready!");
        System.out.print("Write how many cups of coffee you will need: ");
        Scanner scan = new Scanner(System.in);
        int val = scan.nextInt();
        System.out.println("For "+val+" cups of coffee you will need:\n"+val*200+" ml of water\n"+val*50+" ml of milk\n"+val*15+" g of coffee beans");
    }
}
