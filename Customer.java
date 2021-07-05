package DBBLBANK;

import java.util.Random;
import java.util.Scanner;

public class Customer {
    private String fullName;
    private int mobile;
    private String email;
    private int balance;
    private long accountNo;
    private int DbblSetPin;
    private int yourPin;
    private int OpeningYear;
    Scanner input = new Scanner(System.in);

    public Customer(String fullName, int mobile, String email,

                    long accountNo,int DbblSetPin,int OpeningYear) {
        this.fullName = fullName;
        this.mobile = mobile;
        this.email = email;
        this.accountNo = accountNo;
        this.DbblSetPin = DbblSetPin;
        this.OpeningYear = OpeningYear;
        this.balance =0;


    }


    public void ATM() {
        System.out.println("Are you Withdraw you balance: Y | N");
        String value = input.nextLine();
        switch (value){
            case "Y":
                showDisplay();
                break;
            case "N":
                System.out.println("No");
                break;
        }


    }

public  void showDisplay(){
        int count=0;
    while (count <1) {
        System.out.println("Enter you pin");
        int myPin = input.nextInt();
        if(myPin==DbblSetPin){
            int cal = count+1;
            System.out.println("You login you account: "+cal);
            System.out.println("Hey "+fullName+" Choose The Option \n1. " +
                    "Balance Check\n2. Pin Change\n3. Withdraw Fund\n4. " +
                    "Deposit Fund\n5. Exit");
             count++;
            int choosePoint = input.nextInt();
            switch (choosePoint){
                case 1:
                    System.out.println("Balance is "+ balance);
                    System.out.println("1.Exit");
                    int per = input.nextInt();
                    if(per==1){
                        break;
                    }
                case 2:
                    PinChange();
                    break;
                case 3:
                    withdrawFund();
                    break;
                case 4:
                  depositFund();
                    break;
                case 5:
                    break;

            }
        }else{
            System.out.println("Pin is Incorrect");
             showDisplay();
        }
    }
}


public void PinChange(){
    System.out.println("Enter your Account Opening Year: ");
    int getYear = input.nextInt();
    if(getYear == OpeningYear){
        System.out.println("Enter your mobile number: ");
        int mobileNum = input.nextInt();
        if(mobile==mobileNum){
            System.out.println("Please choose 4 Digit pin: ");
            int pinSet = input.nextInt();
            setDbblSetPin(pinSet);
            System.out.println("Successfully Change you pin: "+DbblSetPin);
        }
    }else{
        System.out.println("Sorry, you put wrong Year\nTry Again");
        showDisplay();
    }
}

public void withdrawFund(){

        if(balance ==0 ){
            System.out.println("Your balance is "+balance+" Deposit First");
            depositFund();
        }else if(balance< 500){
            System.out.println("balance must be 500 BDT But you balance is "+balance+" Please Deposit Fund");
          depositFund();
        }else if(balance >= 500){
            System.out.println("Enter the Amount you have withdraw: ");
            int amount = input.nextInt();
            withdrawAmount(amount);

            System.out.println("Withdraw Successfully, Your Account Balance " +
                    "is: "+balance+" BDT");
        }

}


public void depositFund(){
    System.out.println("Please Enter Deposit of Amount: ");
    int dpAmount = input.nextInt();

     dpBdt(dpAmount);

    System.out.println("Deposit Successfully, your Balance " +
            "is: "+balance);
}
    public int dpBdt(int bdt){
        if(bdt <=0 ){
            System.out.println("Amount can't be Negative Value");
        }
        return balance += bdt;
    }

    private int setDbblSetPin(int pindbbl){
        return  DbblSetPin = pindbbl;
    }
    public int getDbblSetPin(){
        return DbblSetPin;
    }
    public int withdrawAmount(int amount){
        return this.balance -= amount;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }
}





