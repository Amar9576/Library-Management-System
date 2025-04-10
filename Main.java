package out;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Library library = new Library();
        Scanner scanner = new Scanner(System.in);

        // Sample data
        library.addBook(new Book("The Great Gatsby", "F. Scott Fitzgerald", "ISBN001"));
        library.addBook(new Book("1984", "George Orwell", "ISBN002"));
        library.addUser(new User("John Doe", "U001"));
        library.addUser(new User("Jane Smith", "U002"));

        while (true) {
            System.out.println("\n=== Library Management System ===");
            System.out.println("1. Display all books");
            System.out.println("2. Display all users");
            System.out.println("3. Borrow a book");
            System.out.println("4. Return a book");
            System.out.println("5. Add new book");
            System.out.println("6. Add new user");
            System.out.println("7. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    library.displayBooks();
                    break;
                case 2:
                    library.displayUsers();
                    break;
                case 3:
                    System.out.print("Enter ISBN: ");
                    String isbn = scanner.nextLine();
                    System.out.print("Enter User ID: ");
                    String userId = scanner.nextLine();
                    library.borrowBook(isbn, userId);
                    break;
                case 4:
                    System.out.print("Enter User ID: ");
                    String returnUserId = scanner.nextLine();
                    library.returnBook(returnUserId);
                    break;
                case 5:
                    System.out.print("Enter title: ");
                    String title = scanner.nextLine();
                    System.out.print("Enter author: ");
                    String author = scanner.nextLine();
                    System.out.print("Enter ISBN: ");
                    String newIsbn = scanner.nextLine();
                    library.addBook(new Book(title, author, newIsbn));
                    break;
                case 6:
                    System.out.print("Enter name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter User ID: ");
                    String newUserId = scanner.nextLine();
                    library.addUser(new User(name, newUserId));
                    break;
                case 7:
                    System.out.println("Exiting...");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Invalid choice");
            }
        }
    }
}