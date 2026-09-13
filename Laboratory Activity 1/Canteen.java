import java.util.Scanner;

public class Canteen {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        boolean ordering = true;
        int totalQuantity = 0;
        double overalltotal = 0.0;
        double finalamount = 0.0;
        double totalDiscount = 0.0;

        System.out.println("========== MENU ==========");
        System.out.println("1.Sisig Silog    -$85.00");
        System.out.println("2.Beef Pares     -$75.00");
        System.out.println("3.Fried Chicken  -$99.00");
        System.out.println("4.Tapsilog       -$95.00");
        System.out.println("5.ChaoFan        -$100.00\n");

        
        while(ordering){
            double price = 0.0;
            double discount = 0.0;
            double orderTotal = 0.0;
            double subtotal = 0.0;
            
            System.out.print("Enter item number: ");
            int itemnumber = scanner.nextInt();
            System.out.print("Enter quantity: ");
            int quantity = scanner.nextInt();

            //use if statement to check if the item number and quantity are valid 
            //if the item input is 6 it will automatically go to the else and print out "Do you want to order again? (Y/N): "
            if (itemnumber >= 1 && itemnumber <= 5 && quantity >= 1 && quantity <= 10){
                
                System.out.print("Are you a student? (Y/N): ");
                char studentinput = scanner.next().toUpperCase().charAt(0);

                switch (itemnumber) {
                    case 1: price = 85.00;
                        break;
                    case 2: price = 75.00;
                        break;
                    case 3: price = 99.00;
                        break;
                    case 4: price = 95.00;
                        break;
                    case 5: price = 100.00;
                        break;
                }
                subtotal = price * quantity;
                totalQuantity += quantity;
                
                if (studentinput == 'Y'){
                    if(subtotal > 500){
                        discount = subtotal * 0.15;
                    }
                    else{
                        discount = subtotal * 0.10;
                    }
                } else if (subtotal > 500){
                    discount = subtotal * 0.05;
                } else {
                    discount = 0.00;
                }
                orderTotal = subtotal - discount;

                System.out.printf("\nSubtotal: $%.2f\n", subtotal);
                System.out.printf("Discount: $%.2f\n", discount);
                System.out.printf("Order Total: $%.2f\n\n", orderTotal);

            } else {
                System.out.println("\nInvalid order! Please enter a valid item and quantity.\n");
            }
            overalltotal += subtotal;
            finalamount += orderTotal;
            totalDiscount += discount;

            System.out.print("Do you want to order again? (Y/N): ");    
            char Orderagain = scanner.next().toUpperCase().charAt(0);
            System.out.println();
            if (Orderagain == 'N'){
                ordering = false;
            }
        }
   
        System.out.println("===== ORDER SUMMARY =====");
        System.out.println("Total Items: " + totalQuantity);
        System.out.printf("Total before discount: $%.2f\n", overalltotal);
        System.out.printf("Total discount: $%.2f\n", totalDiscount);
        System.out.printf("Final amount: $%.2f\n", finalamount);
        System.out.print("Thank you for ordering!");
        scanner.close();
    }
}
