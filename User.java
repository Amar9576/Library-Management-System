package out;
public class User {
    private String name;
    private String userId;
    private Book borrowedBook;

    public User(String name, String userId) {
        this.name = name;
        this.userId = userId;
        this.borrowedBook = null;
    }

    // Getters and Setters
    public String getName() { return name; }
    public String getUserId() { return userId; }
    public Book getBorrowedBook() { return borrowedBook; }
    public void setBorrowedBook(Book borrowedBook) { this.borrowedBook = borrowedBook; }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", userId='" + userId + '\'' +
                ", borrowedBook=" + (borrowedBook != null ? borrowedBook.getTitle() : "None") +
                '}';

    
 }
  }
    
