package CashMachine;

public class PersonAccount {

    private static double Balance;
    private String FirstName;
    private String LastName;
    private int PIN;
    static int count_of_wrong_password = 0;

    public PersonAccount()
    {
        Balance = 1000;
        FirstName = "Wojtek";
        LastName = "Szymocha";
        PIN = 1111;
    }
    public PersonAccount(String FirstName, String LastName, double Balance, int PIN)
    {
        this.FirstName = FirstName;
        this.LastName = LastName;
        this.Balance = Balance;
        this.PIN = PIN;
    }

    public void setBalance(double Balance)
    {
        this.Balance = Balance;
    }
    public void setBalanceDeposit(double Balance, double depositToMachine)
    {
        this.Balance = Balance + depositToMachine;
    }
    public void setBalanceWithdraw(double Balance, double withdrawAmount)
    {
        this.Balance = Balance - withdrawAmount;
    }
    public void setFirstName(String FirstName)
    {
        this.FirstName = FirstName;
    }
    public void setLastName(String LastName)
    {
        this.LastName = LastName;
    }
    public void setPIN(int PIN)
    {
        this.PIN = PIN;
    }

    public static double getBalance()
    {
        return Balance;
    }
    public String getFirstName()
    {
        return FirstName;
    }
    public String getLastName()
    {
        return LastName;
    }
    public int getPIN()
    {
        return PIN;
    }
}
