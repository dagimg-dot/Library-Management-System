import java.util.Scanner;
import java.util.ArrayList;


class BookIssue {
    private Member member;
    Book book_issued;
    private Date issue_date;
    private Date return_date;

    static ArrayList<BookIssue> IssuedBookList = new ArrayList<BookIssue>(0);

    public BookIssue() {

    }

    public BookIssue(Member member, Book book_issued, Date issue_date) {
        this.member = member;
        this.book_issued = book_issued;
        this.issue_date = new Date(issue_date);
    }

    public Date getIssue_date() {
        return this.issue_date;
    }

    public void setIssue_date(Date issue_date) {
        this.issue_date = issue_date;
    }

    public Date getReturn_date() {
        return this.return_date;
    }

    public void setReturn_date(Date issueDate) {

        int day = issue_date.getDay();
        int month = issue_date.getMonth();
        int year = issue_date.getYear();
        if (day > 28 && month == 12) {
            day = (day + 3) - 30;
            month = 1;
            year++;
        } else if (day > 28) {
            day = (day + 3) - 30;
            month++;
        } else
            day = day + 3;
        return_date = new Date(day, month, year);
    }

    public static Date issueDetails() {
        Scanner input = new Scanner(System.in);
        System.out.println("\n\t\t---- Issue Date Details ----\n");
        System.out.println("Enter Day: ");
        int day = input.nextInt();
        System.out.println("Enter Month: ");
        int month = input.nextInt();
        System.out.println("Enter Year: ");
        int year = input.nextInt();
        Date iDate = new Date(day, month, year);
        return iDate;

    }

    public static void issue_book_interface() {
        Scanner input = new Scanner(System.in);
        System.out.println("\n\t\t--------Book Issue Option--------\n");
        System.out.println("Enter the Book ID of the book you want to borrow: ");
        String issueBookID = input.nextLine();
        Book book1 = Book.searchBook(issueBookID);
        if (book1 != null) {
            if (book1.getQuantity() > 0) {
                System.out.println("Enter Member ID: ");
                String memberID1 = input.nextLine();
                Member member1 = Member.searchMember(memberID1);
                if (member1 != null) {
                    System.out.print(member1.getName() + " , Welcome once again !!\n");
                    Date stDate = issueDetails();
                    BookIssue BI = new BookIssue(member1, book1, stDate);
                    BI.setReturn_date(stDate);
                    BI.issue_book();
                    System.out.print("\n\t\tBook Issued Successfully, Happy Reading " +
                    member1.getName());
                } else {
                    Member M1 = new Member();
                    M1 = M1.memberForm(memberID1);
                    Date stDate = issueDetails();
                    BookIssue BI = new BookIssue(M1, book1, stDate);
                    BI.setReturn_date(stDate);
                    BI.issue_book();
                    System.out.print("\n\t\tBook Issued Successfully, Happy Reading " +
                            M1.getName());
                }
            } else
                System.out.print("\n-- Book not Available --");
        } else
            System.out.print("\n-- Book Not Found --");

    }

    public void issue_book() {
        Book.decreaseBookQuantity(this.book_issued);
        IssuedBookList.add(this);
        System.out.println("\n-- Book Issued Successfully --\n");
    }

    public void return_book() {
        Scanner input = new Scanner(System.in);
        System.out.println("\n\t\t--------Book Return Option--------\n");
        System.out.println("Enter the title of the book you want to return: ");
        String returnBookName = input.nextLine();
        System.out.println("Enter Your name, Please: ");
        String memberID1 = input.nextLine();
        boolean flag = false;
        for (int i = 0; i < IssuedBookList.size(); i++) {
            if (IssuedBookList.get(i).book_issued.getTitle().equalsIgnoreCase(returnBookName) &&
                    IssuedBookList.get(i).member.getMember_ID().equalsIgnoreCase(memberID1)) {
                flag = true;
                Book.increaseBookQuantity(IssuedBookList.get(i).book_issued);
                IssuedBookList.remove(i);
                System.out.println("\n-- Book Returned Successfully --\n");
            }
        }
        if (flag == false) {
            System.out.println("\n\t\t-- No Record Found --\n");
        }

    }

    public static void displayBooksIssued() {
        boolean flag = false;
        for (int i = 0; i < IssuedBookList.size(); i++) {
            flag = true;
            System.out.print("\n\nBook Name: " + IssuedBookList.get(i).book_issued.getTitle());
            System.out.println("\t\tBorrowed By: " + IssuedBookList.get(i).member.getName());
            System.out.print("Issued Date: ");
            IssuedBookList.get(i).issue_date.display();
            System.out.print("\t\tReturn Date: ");
            IssuedBookList.get(i).return_date.display();
            System.out.print("\n");
        }
        if (flag == false) {
            System.out.println("\n\t\t-- No Record Found --\n");
        }
    }

    public static void displayBooksAvailable() {
        System.out.print("\n\t\t---- Books Currently Available ----");
        boolean flag = false;
        for (int i = 0; i < Book.BookList.size(); i++) {
            if (Book.BookList.get(i).getQuantity() > 0) {
                flag = true;
                System.out.print("\nNo.: " + (i + 1) + "\t");
                System.out.print("\tBook ID: " + Book.BookList.get(i).getBook_ID() + "\t");
                System.out.print("\tBook name: " + Book.BookList.get(i).getTitle() + "\t");
                System.out.print("\tAuthor: " + Book.BookList.get(i).getAuthor() + "\t");
                System.out.print("\tGenre: " + Book.BookList.get(i).getGenre() + "\t");
                System.out.print("\tQuantity: " + Book.BookList.get(i).getQuantity());
            }
        }
        if (flag == false) {
            System.out.println("\n\t\t-- No Record Found --\n");
        }
    }

}
