package CashMachine;

import java.io.IOException;
import java.util.Scanner;

import static java.lang.Thread.sleep;

public class Machine {
    private static int MoneyInMachine;
    PersonAccount personAccounts;
    Transaction transaction;
    Machine()
    {
        MoneyInMachine = 10000;
    }
    public static int getMoneyInMachine()
    {
        return MoneyInMachine;
    }
    private void wrong_password() throws IOException, InterruptedException {
        System.out.println("Account lock, wrong pin was entered 3 times");
        System.out.println("Your card will be ejected...");
        System.out.println("Please Wait...");
        sleep(5000);
        personAccounts.count_of_wrong_password = 0;
        Work();
    }
    private void operation_of_cashMachine() throws IOException, InterruptedException {
        System.out.println("Please enter your PIN");
        Scanner input = new Scanner(System.in);

        int PINAccount = input.nextInt();

        if (PINAccount == personAccounts.getPIN()) {
            transaction = new Transaction(personAccounts);
            transaction.Menu();
        } else
        {
            System.out.println("Wrong PIN!!! Please try again!");
            personAccounts.count_of_wrong_password++;
            if(personAccounts.count_of_wrong_password == 3)
            {
                wrong_password();
            }else
            {
                operation_of_cashMachine();
            }

        }
    }
    public void Work() throws InterruptedException, IOException {
        personAccounts = new PersonAccount();
        System.out.println("***Put the card in the Cash Machine***");
        sleep(5000);

        operation_of_cashMachine();

    }
}
