public class Main {
    public static void main(String[] args) {
        ExpenseManager expenseManager = new ExpenseManager();
        UserInterface ui = new UserInterface(expenseManager);
        ui.start();
    }
}