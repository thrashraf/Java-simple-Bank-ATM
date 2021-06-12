import java.util.Scanner;



class Account {

    String name ;
    double balance, deposit ,withdraw;

    int noAcc;
    public void createAccount(String  n, int no){

        this.name = n;
        this.noAcc = no;
      
    }

    public void deposit(double b , double d){

        this.balance = b;
        this.deposit = d;
        
        
    }

    public void withdraw(double b , double w){

        this.balance = b;
        this.withdraw = w;
        
        
    }
}

class Current extends Account {

    double balance;

    @Override
    public void deposit(double b , double d){

        this.balance = b;
        this.deposit = d;
       
        // this is override method
        balance = balance + deposit;
    }

    @Override
    public void withdraw(double b , double w){

        this.balance = b;
        this.withdraw = w;

        balance = balance - withdraw;
    }
    public void Display(){

        System.out.println("Your Name is : " + name);
        System.out.println("Your Account Number is : " + noAcc);
    }

    void displayCurrentBalance(){
        System.out.println("Your Current Balance is : RM" + balance);
    }
    
}

class Saving extends Account{

    double savingBalance;

    @Override
    public void deposit(double d , double b){

        this.balance = b;
        this.deposit = d;
       
        //this is override method
        balance = balance + deposit;
   }

   @Override
   public void withdraw(double b , double w){

    this.balance = b;
    this.withdraw = w;

    balance = balance - withdraw;
}

   public void Display(){

    System.out.println("Your Name is : " + name);
    System.out.println("Your Account Number is : " + noAcc);
}
   
   void displaySavingBalance(){
       
       System.out.println("Your Saving Balance is : RM" + balance);
   } 
  

    public static void main(String[] args) {
        
        Account account = new Account();
        Current current = new Current();
        Saving saving = new Saving();

        //this is how to auto generate random Account number
        int choice , Number = (int)(Math.random() * 900000000) + 1000000000;
        String name;
        double balance = 0 , deposit;
        boolean menu = !false;
     


        Scanner stdin = new Scanner(System.in);

        System.out.print("\033\143");
        System.out.println("\nPlease Create Account First");

        System.out.println("\nPlease Enter Your Name : ");
        name = stdin.nextLine();
        
        //this exception is when you try to insert < RM 100 , then you will receive an error. You need to insert more than RM 100.
        try{
        System.out.println("\nYou Must Deposit Atleast Rm 100.00");
        System.out.print("Please Enter Your First Deposit To Saving Account : ");
        
        deposit = stdin.nextDouble();
            while(deposit < 100){
                throw new Exception("Please Enter First Deposit More Than RM 100.00");
             
            }
        
        saving.createAccount(name , Number);
        current.createAccount(name , Number);
        saving.deposit(balance, deposit);
        }catch(Exception e ){
            System.out.println(e);
            System.exit(0);
        }

        
        do{

            System.out.print("\033\143");
            System.out.println("\n==================================================================="); 
            System.out.println("\n\t\t\tWelcome To Bank"); 
            System.out.println("\n===================================================================");
            current.Display();
            saving.displaySavingBalance();
            current.displayCurrentBalance();
            System.out.println("\n1) Display Account Detail");
            System.out.println("2) Current");
            System.out.println("3) Saving");
            System.out.println("\n99) Exit");
            
    
            System.out.println("Enter your choice...");
            choice = stdin.nextInt();

            switch (choice) {
            
                case 1:
                System.out.print("\033\143");
                saving.Display();
                saving.displaySavingBalance();
                current.displayCurrentBalance();
                System.exit(0);
                break;
                 
                case 2:
                System.out.println(" ");
                System.out.println("\n1) Deposit To Current");
                System.out.println("2) Withdraw Current Balance");
                System.out.println("\n Enter your choice...");
                choice = stdin.nextInt();

                //this exception is when you try to insert RM 100 you'll receive an error , you just need to insert number eg. 100 , 600
                try {
                if (choice == 1 ){

                    double depoBalance;
                    System.out.println("Enter amount of deposit");
                    deposit = Double.parseDouble(stdin.next());

                    current.deposit(balance , deposit);
                    // current.deposit();

                    break;
                }
                

                    if (choice == 2 ){

                        System.out.println("Enter amount of withdraw");
                        double with = Double.parseDouble(stdin.next());
                        
                        if(with > current.balance){
                           System.out.println("Error");
                            
                            
                        }else{
                            current.withdraw(current.balance, with);
                            
                            break;
                        
                        }
                    }
                    
                } catch (NumberFormatException e) {
                   
                    System.out.println(e);
                    System.exit(0);
                }
                
                        
                case 3:
                
                saving.displaySavingBalance();
                System.out.println("\n1) Deposit To Saving");
                System.out.println("2) Withdraw Saving Balance");
                System.out.println("\n Enter your choice...");
                choice = stdin.nextInt();

                //this exception is when you try to insert RM 100 you'll receive an error , you just need to insert number eg. 100 , 600
                try {
                if (choice == 1 ){

                    System.out.println("Enter amount of deposit");
                     deposit = Double.parseDouble(stdin.next());

                    saving.deposit(deposit , saving.balance);
            
                }
               
                if (choice == 2 ){

                    System.out.println("Enter amount of withdraw");
                    double withSaving = Double.parseDouble(stdin.next());
                    
                    if(withSaving > saving.balance){
                        System.out.println("Error");
                        
                    }else{
                        saving.withdraw(saving.balance, withSaving);
                        break;
                    }
                }

                }catch (NumberFormatException e) {
           
                System.out.println(e);
                System.exit(0);
                }
                
                break;

                case 99:
                System.exit(0);
                break;
            }
        } while (menu == true);

    }
}