import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BankManagement {

    public static String name;
    public static int noAcc  ;
    public static double balance = 0 , newBalance = 0 , finalDepoBalance , width , depoBalance;
    
    
    void displayAccount(){

        System.out.println("Your Account Name is : " + name);
        System.out.println("Your Account Number is : " + noAcc);
        System.out.println("Your Account Balance is : " + balance);

    }

    double Deposite(double depositeAmount){

         return depositeAmount = balance + depositeAmount;
    }

    double withdrawMoney( double withdrawAmount){

         return withdrawAmount = balance - withdrawAmount ;
    }

    public static void main(String[] args) throws IOException{

        
        int choice;
        String str;
    
        boolean menu = !true;

        BankManagement bank = new BankManagement();
        
        InputStreamReader Instream = new InputStreamReader(System.in);
        BufferedReader stdin = new BufferedReader(Instream);


        System.out.println("\nPlease Create Account First");
        System.out.println("\nPlease Enter Your Name : ");
        name = stdin.readLine();

        System.out.println("Enter Your First Deposit : ");
        str = stdin.readLine();
        balance = Double.parseDouble(str);
        

        // this is how to generate any number to be an account number
        noAcc = (int)(Math.random() * 900000000) + 1000000000;

        // this is how to clearscreen in java
        System.out.print("\033[H\033[2J");  
        System.out.flush(); 
    
        do {    

        System.out.println("\n==================================================================="); 
        System.out.println("\n\t\t\tWelcome To Bank"); 
        System.out.println("\n===================================================================");
        bank.displayAccount();
        System.out.println("\n1) Display Account Detail");
        System.out.println("2) Make Deposite");
        System.out.println("3) Withdraw Money");
        System.out.println("\n99) Exit");
        

        System.out.println("Enter your choice...");
        str = stdin.readLine();
        choice = Integer.parseInt(str);

            switch(choice){

                case 1 :
                        bank.displayAccount();
                        System.out.println("\nPress 0 to back into Menu : ");
                        str = stdin.readLine();
                        menu = Boolean.parseBoolean(str);
                break;

    
                case 2 :
                        System.out.println("Enter amount of deposit");
                        str = stdin.readLine();
                        newBalance = Double.parseDouble(str);

                        depoBalance = bank.Deposite(newBalance);
                        
                        System.out.println("Account Name : " + name);
                        System.out.println("Account Number : " + noAcc);
                        System.out.println("Your New Balance is : RM" + depoBalance );

                        balance = depoBalance;

                        System.out.println("\nPress 0 to back into Menu : ");
                        str = stdin.readLine();
                        menu = Boolean.parseBoolean(str);
                break;

    
                case 3 :
                        System.out.println("Enter Your Accout Number");
                        str = stdin.readLine();
                        int confirmationAcc = Integer.parseInt(str);
            
                        if (confirmationAcc == noAcc){
            
                            System.out.println("Enter amount you want to withdarw : ");
                            str = stdin.readLine();
                            width = Double.parseDouble(str);

                                if (width > balance){

                                    System.out.println("Please Enter Correct Amount");
                                } else {

                                
                                finalDepoBalance = bank.withdrawMoney(width);
                                System.out.println("Account Name : " + name);
                                System.out.println("Account Number : " + noAcc);
                                System.out.println("Your New Balance is : RM" + finalDepoBalance );

                                balance = finalDepoBalance;
                                }
            
                        } else {

                            System.out.println("Your Account number is invalid.");
                        }

                        System.out.println("\nPress 0 to back into Menu : ");
                        str = stdin.readLine();
                        menu = Boolean.parseBoolean(str);
                break;


                case 99 :
                        System.out.println("\nThank You For Using Our Service!");

                        System.exit(0);
                break;          
        } 
            
    }   while (menu == false);

    }

}