package CashMachine;

import java.io.IOException;
import java.util.Scanner;

import static java.lang.Thread.sleep;

public class Transaction {
    PersonAccount personAccount;
    public Transaction()
    {

    }
    public Transaction( PersonAccount personAccount)
    {
        this.personAccount = personAccount;
    }

    public void withdraw() throws InterruptedException, IOException {
        Scanner input = new Scanner(System.in);
        int withdrawSelection = 0;
        System.out.println("Withdraw money:");
        System.out.println("1 - 10zł");
        System.out.println("2 - 20zł");
        System.out.println("3 - 50zł");
        System.out.println("4 - 100zł");
        System.out.println("5 - Your amount");
        System.out.println("6 - Back to main menu");
        System.out.print("Choice: ");
        withdrawSelection =input.nextInt();

        switch (withdrawSelection)
        {
            case 1:
                checkAmount(10);
                Menu();
                break;
            case 2:
                checkAmount(20);
                Menu();
                break;
            case 3:
                checkAmount(50);
                Menu();
                break;
            case 4:
                checkAmount(100);
                Menu();
                break;
            case 5:
                System.out.println("Specify the amount to be paid.");
                int ownMoney = input.nextInt();
                checkAmount(ownMoney);
                Menu();
                break;
            case 6:
                Menu();
                break;
            default:
                System.out.println("Invalid choice.");
                withdraw();
        }
    }

    private void checkAmount(int withdrawAmount)
    //run the check activation exception
    {
        if(personAccount.getBalance() -withdrawAmount < 0)
        {
            System.out.println("\n***ERROR!!! Insufficient funds in you accout***");
        }
        else
        {
            personAccount.setBalanceWithdraw(personAccount.getBalance(), withdrawAmount);

            System.out.println("\n***Please take your money now...***");
        }
    }
    public void CheckBalance() throws InterruptedException, IOException {
        System.out.println("Your balance is "+ PersonAccount.getBalance() +" zł\n");
        //System.out.println("Please wait ...");
        sleep(5000);
        Menu();
    }

    public  void deposit() throws InterruptedException, IOException {
        Scanner input = new Scanner(System.in);
        int depositToMachine;
        System.out.println("Deposit");
        System.out.println("How much do you want to deposit in your account");
        depositToMachine = input.nextInt();
        System.out.println("\n***Please insert your money now...***");

        personAccount.setBalanceDeposit(personAccount.getBalance(),depositToMachine);
        sleep(5000);
        Menu();


    }
    public void Menu() throws InterruptedException, IOException {
        Scanner input = new Scanner(System.in);
        int withdrawSelection = 0;
        System.out.println("Cash Machine");
        System.out.println(" ");
        System.out.println("1 - Withdraw money:");
        System.out.println("2 - Deposit money");
        System.out.println("3 - Your balans");
        System.out.println("4 - Logout");
        System.out.println("Choice: ");

        withdrawSelection =input.nextInt();
        switch (withdrawSelection)
        {
            case 1:
                withdraw();

                break;
            case 2:
                deposit();

                break;
            case 3:
                CheckBalance();

                break;
            case 4:
                System.out.println("Your card will be ejected...");
                System.out.println("Please Wait...");
                sleep(5000);
                Machine machine = new Machine();
                machine.Work();
                break;

            default:
                System.out.println("Invalid choice.");
                Menu();
        }
    }
}
