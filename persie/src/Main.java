public class Main {
    public static void main(String[] args) throws InsufficientBalanceException {
        PersonalAccount pa = new PersonalAccount(250000, "Ibraimova Aizirek");
        pa.deposit(5000);
        pa.deposit(10000);
        pa.withdraw(3000);
        pa.withdraw(14000);
        System.out.println(pa.getBalance());
        pa.printTransactionHistory();

    }
}