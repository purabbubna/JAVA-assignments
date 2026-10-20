import java.util.Scanner;

public class atm {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        
        int balance = 10000;
        try{
            System.out.println("Enter withdrawal amount: ");
            int withdraw = sc.nextInt();

            if(withdraw<=0){
                throw new Exception("Withdrawal amount should be more than 0");
            }
            if(balance<withdraw){
                throw new Exception("Withdrawal amount cant be more than balance");
            }
            balance = balance - withdraw;
            System.out.printf("Remaining balance: %d", balance);
        }
        catch(Exception e){
            System.out.println("Invalid withdrawal." + e.getMessage());
        }
        finally{
            System.out.println("\nExecuted.");
        }
    }    
}
