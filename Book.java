import java.util.Scanner;
import java.util.ArrayList;

class Book {
    private String title;
    private String book_ID;
    private int quantity;
    private String author;
    private String genre;

    static ArrayList<Book> BookList = new ArrayList<Book>(0);

    public Book() {

    }

    public Book(String title, String book_ID, int quantity, String author, String genre) {
        this.title = title;
        this.book_ID = book_ID;
        this.quantity = quantity;
        this.author = author;
        this.genre = genre;
    }

    public Book(Book B) {
        this.title = B.title;
        this.book_ID = B.book_ID;
        this.quantity = B.quantity;
        this.author = B.author;
        this.genre = B.genre;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBook_ID() {
        return this.book_ID;
    }

    public void setBook_ID(String book_ID) {
        this.book_ID = book_ID;
    }

    public int getQuantity() {
        return this.quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getAuthor() {
        return this.author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getGenre() {
        return this.genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public void display() {
        Main.clearScreen();
        System.out.println("\t\t---Book Details---");
        System.out.println("\tNo.: " + (BookList.size() + 1));
        System.out.println("\tBook Name: " + this.title);
        System.out.println("\tBook ID: " + this.book_ID);
        System.out.println("\tAuthor Name: " + this.author);
        System.out.println("\tGenre : " + this.genre);
        System.out.println("\tAvailable Books: " + this.quantity);
    }

    public static void displayAllBooks() {
        boolean flag = false;
        System.out.print("\t\tAll Books in the Library \n");
        for (int i = 0; i < BookList.size(); i++) {
            flag = true;
            System.out.print("\nNo.: " + (i + 1) + "\t");
            System.out.print("\tBook ID: " + BookList.get(i).getBook_ID() + "\t");
            System.out.print("\tBook name: " + BookList.get(i).getTitle() + "\t");
            System.out.print("\tAuthor: " + BookList.get(i).getAuthor() + "\t");
            System.out.print("\tGenre: " + BookList.get(i).getGenre() + "\t");
            System.out.print("\tQuantity: " + BookList.get(i).getQuantity());
        }
        if (flag == false) {
            System.out.println("\n\t\t-- No Record Found --\n");
        }
        System.out.println("\n");
    }

    public static void displayBooks(int n) {
        System.out.print("\nNo.: " + (n + 1) + "\t");
        System.out.print("\tBook ID: " + BookList.get(n).getBook_ID() + "\t");
        System.out.print("\tBook name: " + BookList.get(n).getTitle() + "\t");
        System.out.print("\tAuthor: " + BookList.get(n).getAuthor() + "\t");
        System.out.print("\tGenre: " + BookList.get(n).getGenre() + "\t");
        System.out.print("\tQuantity: " + BookList.get(n).getQuantity());

    }

    public void addBook() {
        Scanner input = new Scanner(System.in);
        System.out.print("\t\t+++ Menu for Adding Book +++\n");
        System.out.println("Enter Book Name: ");
        title = input.nextLine();
        System.out.println("Enter Book ID: ");
        book_ID = input.nextLine();
        System.out.println("Enter Author Name: ");
        author = input.nextLine();
        System.out.println("Enter Genre: ");
        genre = input.nextLine();
        try {
            System.out.println("Enter Quantity(int): ");
            quantity = input.nextInt();

            Book b1 = new Book(title, book_ID, quantity, author, genre);
            b1.display();
            BookList.add(b1);
            System.out.println("\n-- Book Added Successflly --\n");
        } catch (Exception e) {
            System.out.print("Invalid Input !!");
        }
    }

    public void deleteBook() {
        Scanner input = new Scanner(System.in);
        System.out.println("\t\t--- Book Deletion ---\n");
        System.out.println("Enter the Book Name to delete: ");
        title = input.nextLine();

        boolean flag = false;
        for (int i = 0; i < BookList.size(); i++) {
            if (BookList.get(i).getTitle().equalsIgnoreCase(title)) {
                BookList.remove(i);
                flag = true;
                System.out.println("\n-- Book Deleted Successfully --\n");
            }
        }
        if (flag == false)
            System.out.println("\n-- Book Not Found --\n");

    }

    public void searchBook(int case_check) {
        Scanner input = new Scanner(System.in);
        String att = input.nextLine();
        boolean avail = false;
        if (case_check == 1) {
            for (int i = 0; i < BookList.size(); i++) {
                if (BookList.get(i).getTitle().equalsIgnoreCase(att) || BookList.get(i).getTitle().contains(att)) {
                    displayBooks(i);
                    avail = true;
                }
            }
            if (avail == false)
                System.out.println("\n-- Book Not Found --\n");

        } else if (case_check == 2) {
            for (int i = 0; i < BookList.size(); i++) {
                if (BookList.get(i).getBook_ID().equalsIgnoreCase(att)
                        || BookList.get(i).getBook_ID().contains(att)) {
                    displayBooks(i);
                    avail = true;
                }
            }
            if (avail == false)
                System.out.println("\n-- Book Not Found --\n");

        } else if (case_check == 3) {
            for (int i = 0; i < BookList.size(); i++) {
                if (BookList.get(i).getAuthor().equalsIgnoreCase(att)
                        || BookList.get(i).getAuthor().contains(att)) {
                    displayBooks(i);
                    avail = true;
                }
            }
            if (avail == false)
                System.out.println("\n-- Book Not Found --\n");

        } else if (case_check == 4) {
            for (int i = 0; i < BookList.size(); i++) {
                if (BookList.get(i).getGenre().equalsIgnoreCase(att) || BookList.get(i).getGenre().contains(att)) {
                    displayBooks(i);
                    avail = true;
                }
            }
            if (avail == false)
                System.out.println("\n-- Book Not Found --\n");
        }

    }

    public static Book searchBook(String BookID) {
        Book searchedBook = null;
        for (int i = 0; i < BookList.size(); i++) {
            if (BookList.get(i).getBook_ID().equalsIgnoreCase(BookID)) {
                searchedBook = BookList.get(i);
            }
        }
        return searchedBook;
    }

    public void updateBook(int case_check) {
        Scanner input = new Scanner(System.in);
        String attribute;
        int quantity;
        System.out.print("Enter the position of the book you want to update: ");
        int pos = input.nextInt();
        int index = pos - 1;
        while (pos > BookList.size()) {
            System.out.print("The number of books available is less than waht you entered, please try again\n");
            pos = input.nextInt();
        }
        if (case_check == 1) {
            System.out.println("Enter the new title of the Book");
            attribute = input.nextLine();
            BookList.get(index).setTitle(attribute);
            System.out.print("\t\tTitle updated successfully!!\n");
            displayBooks(index);
        } else if (case_check == 2) {
            System.out.println("Enter the new Book ID of the Book");
            attribute = input.nextLine();
            BookList.get(index).setBook_ID(attribute);
            System.out.print("\t\tBook ID updated successfully!!\n");
            displayBooks(index);
        } else if (case_check == 3) {
            System.out.println("Enter the new Author of the Book");
            attribute = input.nextLine();
            BookList.get(index).setAuthor(attribute);
            System.out.print("\t\tAuthor updated successfully!!\n");
            displayBooks(index);
        } else if (case_check == 4) {
            System.out.println("Enter the new Genre of the Book");
            attribute = input.nextLine();
            BookList.get(index).setGenre(attribute);
            System.out.print("\t\tGenre updated successfully!!\n");
            displayBooks(index);
        } else if (case_check == 5) {
            System.out.println("Enter the new Quantity of the Book");
            quantity = input.nextInt();
            BookList.get(index).setQuantity(quantity);
            System.out.print("\t\tQuantity updated successfully!!\n");
            displayBooks(index);
        }

    }

    public static void increaseBookQuantity(Book b) {
        for (int i = 0; i < BookList.size(); i++) {
            if (BookList.get(i).getTitle().equalsIgnoreCase(b.getTitle())) {
                BookList.get(i).setQuantity(BookList.get(i).getQuantity() + 1);
            }
        }
    }

    public static void decreaseBookQuantity(Book b) {
        for (int i = 0; i < BookList.size(); i++) {
            if (BookList.get(i).getTitle().equalsIgnoreCase(b.getTitle())) {
                BookList.get(i).setQuantity(BookList.get(i).getQuantity() - 1);
            }
        }
    }

}
