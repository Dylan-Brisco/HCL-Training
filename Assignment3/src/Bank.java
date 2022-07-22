public class Bank {
    public double deposit(double amount, double balance) {
        balance += amount;
        return balance;
    }

    public double withdrawl(double amount, double balance) {
        if(balance >= amount) {
            balance -= amount;
            return balance;
        }
        return 0;
    }
    public static void main(String[] args) {
        Bank b = new Bank();
        System.out.println(b.deposit(75.30, 4342.40));
        System.out.println(b.withdrawl(554.04, 3234.20));
        System.out.println(b.withdrawl(233.9, 43.22));
    }
}
