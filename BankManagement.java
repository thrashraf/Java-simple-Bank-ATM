import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


class BankManagement {

    public static String name;
    public static int noAcc  ;
    public static double balance;

    void Display(){

        System.out.println("Your Account Name is : " + name);
        System.out.println("Your Account Number is : " + noAcc);
        System.out.println("Your Account Balance is : " + balance);

    }

    public static void main(String[] args) throws IOException {

        String str;
        int choice , confirmationAcc;
        double newBalance , with;

        boolean menu = !true;

        BankManagement dis = new BankManagement();
        DepositeAmount depo = new DepositeAmount();
        withdrawMoney wit = new withdrawMoney();
        

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

        do {    

            System.out.println("\n==================================================================="); 
            System.out.println("\n\t\t\tWelcome To Bank"); 
            System.out.println("\n===================================================================");
            dis.Display();
            System.out.println("\n1) Display Account Detail");
            System.out.println("2) Make Deposite");
            System.out.println("3) Withdraw Money");
            System.out.println("\n99) Exit");
            
    
            System.out.println("Enter your choice...");
            str = stdin.readLine();
            choice = Integer.parseInt(str);

            switch (choice) {
                case 1:
            
                dis.Display();
                System.out.println("\nPress 0 to back into Menu : ");
                str = stdin.readLine();
                menu = Boolean.parseBoolean(str);
                    
                break;

                case 2:

                System.out.println("Enter amount of deposit");
                str = stdin.readLine();
                newBalance = Double.parseDouble(str);

                balance = depo.Deposit(balance ,newBalance);

                System.out.println("\nPress 0 to back into Menu : ");
                str = stdin.readLine();
                menu = Boolean.parseBoolean(str);

                break;

                case 3:

                System.out.println("Enter Your Accout Number");
                str = stdin.readLine();
                confirmationAcc = Integer.parseInt(str);

                if (confirmationAcc == noAcc){

                    System.out.println("Enter amount you want to withdarw : ");
                    str = stdin.readLine();
                    with = Double.parseDouble(str);

                    wit.Withdraw(balance,with);


                } else {

                    System.out.println("Your Account number is invalid.");
                }
                
                break;

            
            }


        } while (menu == false);

    
    }


}

class DepositeAmount {

    static double newbalance;

    BankManagement dis = new BankManagement();

    double Deposit(double depoBalance , double DepositeAmount){

        newbalance = dis.balance + DepositeAmount;

        System.out.println("Account Name : " + dis.name);
        System.out.println("Account Number : " + dis.noAcc);
        System.out.println("Your New Balance is : RM" + newbalance);

        dis.balance = newbalance;
        return newbalance;
    }


}


class withdrawMoney {

    static double finalBalance;
    BankManagement dis = new BankManagement();
    DepositeAmount depo = new DepositeAmount();

    double Withdraw(double withdrawBalance , double withdrawAmount){

        if (withdrawAmount > dis.balance){

            System.out.println("Your money is not enough ,Please enter a valid amount.");
        } 
        else{
        finalBalance = dis.balance - withdrawAmount;
        
        System.out.println("Account Name : " + dis.name);
        System.out.println("Account Number : " + dis.noAcc);
        System.out.println("Your New Balance is : RM" + finalBalance);

        dis.balance = finalBalance;

        }

        return finalBalance;
    }


}