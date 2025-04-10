package out;
import java.util.ArrayList;

public class Library {
    private ArrayList<Book> books;
    private ArrayList<User> users;

    public Library() {
        books = new ArrayList<>();
        users = new ArrayList<>();
    }

    public void addBook(Book book) {
        books.add(book);
        System.out.println("Book added: " + book.getTitle());
    }

    public void addUser(User user) {
        users.add(user);
        System.out.println("User added: " + user.getName());
    }

    public void borrowBook(String isbn, String userId) {
        Book book = findBook(isbn);
        User user = findUser(userId);

        if (book != null && user != null) {
            if (book.isAvailable() && user.getBorrowedBook() == null) {
                book.setAvailable(false);
                user.setBorrowedBook(book);
                System.out.println(user.getName() + " borrowed " + book.getTitle());
            } else {
                System.out.println("Book is not available or user already has a book");
            }
        } else {
            System.out.println("Book or User not found");
        }
    }

    public void returnBook(String userId) {
        User user = findUser(userId);
        if (user != null && user.getBorrowedBook() != null) {
            Book book = user.getBorrowedBook();
            book.setAvailable(true);
            user.setBorrowedBook(null);
            System.out.println("Book returned: " + book.getTitle());
        } else {
            System.out.println("User not found or no book to return");
        }
    }

    private Book findBook(String isbn) {
        for (Book book : books) {
            if (book.getIsbn().equals(isbn)) {
                return book;
            }
        }
        return null;
    }

    private User findUser(String userId) {
        for (User user : users) {
            if (user.getUserId().equals(userId)) {
                return user;
            }
        }
        return null;
    }

    public void displayBooks() {
        System.out.println("\nLibrary Books:");
        for (Book book : books) {
            System.out.println(book);
        }
    }

    public void displayUsers() {
        System.out.println("\nLibrary Users:");
        for (User user : users) {
            System.out.println(user);
        }
    }
}