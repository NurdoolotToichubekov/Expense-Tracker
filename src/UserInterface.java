import java.util.Scanner;

public class UserInterface {
    private ExpenseManager expenseManager;
    private Scanner scanner;

    public UserInterface(ExpenseManager expenseManager) {
        this.expenseManager = expenseManager;
        this.scanner = new Scanner(System.in);
    }

    public void start() {
        while (true) {
            System.out.println("1. Add Expense");
            System.out.println("2. View Expenses");
            System.out.println("3. View Total Expenses");
            System.out.println("4. Exit");

            int choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (choice) {
                case 1 -> addExpense();
                case 2 -> expenseManager.viewExpenses();
                case 3 -> System.out.println("Total: $" + expenseManager.getTotalExpenses());
                case 4 -> {
                    System.out.println("Exiting...");
                    return;
                }
                default -> System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private void addExpense() {
        System.out.print("Enter category: ");
        String category = scanner.nextLine();

        System.out.print("Enter amount: ");
        double amount = scanner.nextDouble();

        System.out.print("Enter date (yyyy-mm-dd): ");
        scanner.nextLine(); // consume newline
        String date = scanner.nextLine();

        expenseManager.addExpense(new Expense(category, amount, date));
        System.out.println("Expense added successfully!");
    }
}
