import java.util.Scanner;
import java.io.*;

public class Main {
    int flag = 0;

    public static void main(String[] args) {
        Main Menu = new Main();
        Menu = Menu.mainMenu(Menu);
        System.out.println("\n\t\tApplication has been shut down\n");
    }

    private Main mainMenu(Main Menu) {
        Scanner input = new Scanner(System.in);
        int option = 0;
        try {
            do {
                System.out.println("\t\t===========================================================================\n");
                System.out.println("\t\t\t\t           Library Management System\n");
                System.out.println("\t\t===========================================================================\n");
                System.out
                        .println("\t\t--------------------------------Main Menu------------------------------------\n");
                System.out.println("\t\t\tPress 1 if you are Librarian or 2 if you are a Member \n");
                System.out.println("\t1. Librarian \n");
                System.out.println("\t2. Member \n");
                System.out.println("\t3. Quit \n");
                System.out
                        .println("\t\t-----------------------------------------------------------------------------\n");
                option = input.nextInt();
                switch (option) {
                    case 1:
                        clearScreen();
                        flag = 1;
                        return Menu.LibrarianMenu(Menu);
                    case 2:
                        clearScreen();
                        flag = 0;
                        return Menu.MembersMenu(Menu);
                    case 3:
                        return Menu;
                    default:
                        clearScreen();
                        System.out.print("Wrong input, please try again !!\n");
                }
            } while (option != 3);
        } catch (Exception e) {
            System.out.print("Invalid Input !!");
        }
        return Menu;
    }

    private Main LibrarianMenu(Main Menu) {
        clearScreen();
        Scanner input = new Scanner(System.in);
        System.out.println("\t\t--------Librarian Menu--------\n");
        System.out.println("\t\tPlease Enter your name and password\n");
        Librarian Li = new Librarian();
        boolean flag = false;
        boolean login_check = false;
        while (!flag) {
            flag = true;
            Console console = System.console();
            String name = console.readLine("Name:");
            char[] password = console.readPassword("Password:");
            String pwd = new String(password);

            if (name.equals(Li.getLibrarian_name()) && pwd.equals(Li.getPassword())) {
                System.out.println("\t\t\tLogin Successful \n");
                login_check = true;
            } else {
                System.out.println("\t\t\tLogin Failed. Incorrect Name or Password. Please try again !!\n");
                flag = false;
            }
        }
        if (login_check == true) {
            int libMenu_option = 0;
            Book L = new Book();
            Member Me = new Member();
            try {
                do {
                    System.out.println("\t\tChoose what you want to do\n\n");
                    System.out.println("\t1. Add Book \n");
                    System.out.println("\t2. Delete Book\n");
                    System.out.println("\t3. Update Book Information\n");
                    System.out.println("\t4. Search Book\n");
                    System.out.println("\t5. Display All Books\n");
                    System.out.println("\t6. Display All Borrowed Books\n");
                    System.out.println("\t7. Display members who borrowed a book\n");
                    System.out.println("\t8. Back to Main Menu\n");
                    libMenu_option = input.nextInt();
                    switch (libMenu_option) {
                        case 1:
                            L.addBook();
                            break;
                        case 2:
                            L.deleteBook();
                            break;
                        case 3:
                            clearScreen();
                            return Menu.UpdateMenu(Menu);
                        case 4:
                            clearScreen();
                            return Menu.SearchMenu(Menu);
                        case 5:
                            Book.displayAllBooks();
                            break;
                        case 6:
                            Li.displayBooks();
                            break;
                        case 7:
                            Me.displayMembersBorrowed();
                            break;
                        case 8:
                            clearScreen();
                            return Menu.mainMenu(Menu);
                        default:
                            clearScreen();
                            System.out.println("Wrong input, please enter valid option");
                    }
                } while (libMenu_option != 9);
            } catch (Exception e) {
                System.out.print("Invalid Input !!");
            }
        }
        return Menu;
    }

    private Main MembersMenu(Main Menu) {
        clearScreen();
        Scanner input = new Scanner(System.in);
        Member Me = new Member();
        System.out.println("\t\t--------Members Menu--------\n");
        int memMenu_option = 0;
        try {
            do {
                System.out.println("\n\n\t\tChoose what you want to do\n\n");
                System.out.println("\t1. Issue Book\n");
                System.out.println("\t2. Return Book\n");
                System.out.println("\t3. Search Book\n");
                System.out.println("\t4. Display All Books\n");
                System.out.println("\t5. Display Available Books\n");
                System.out.println("\t6. Back to Main Menu\n");
                BookIssue bi = new BookIssue();
                memMenu_option = input.nextInt();
                switch (memMenu_option) {
                    case 1:
                        BookIssue.issue_book_interface();
                        break;
                    case 2:
                        bi.return_book();
                        break;
                    case 3:
                        clearScreen();
                        return Menu.SearchMenu(Menu);
                    case 4:
                        Book.displayAllBooks();
                        break;
                    case 5:
                        Me.displayBooks();
                        break;
                    case 6:
                        clearScreen();
                        return Menu.mainMenu(Menu);
                    default:
                        clearScreen();
                        System.out.println("Wrong input, please enter valid option");
                }
            } while (memMenu_option != 6);
        } catch (Exception e) {
            System.out.print("Invalid Input !!");
        }
        return Menu;
    }

    private Main SearchMenu(Main Menu) {
        clearScreen();
        Book S = new Book();
        Scanner input = new Scanner(System.in);
        System.out.println("\t\t--------Search Menu--------\n");
        int s_option = 0, case_check;
        try {
            do {
                System.out.println("\n\t\tChoose what you want to do\n\n");
                System.out.println("\t1. Search by Title\n");
                System.out.println("\t2. Search by Book ID\n");
                System.out.println("\t3. Search by Author\n");
                System.out.println("\t4. Search by Genre\n");
                System.out.println("\t5. Back to Previous Menu\n");
                System.out.println("\t6. Back to Main Menu\n");
                s_option = input.nextInt();
                switch (s_option) {
                    case 1:
                        System.out.println("Enter the title of the Book you want to search");
                        case_check = 1;
                        S.searchBook(case_check);
                        break;
                    case 2:
                        System.out.println("Enter the Book ID of the Book you want to search");
                        case_check = 2;
                        S.searchBook(case_check);
                        break;
                    case 3:
                        System.out.println("Enter the Author of the Book you want to search");
                        case_check = 3;
                        S.searchBook(case_check);
                        break;
                    case 4:
                        System.out.println("Enter the Genre of the Book you want to search");
                        case_check = 4;
                        S.searchBook(case_check);
                        break;
                    case 5:
                        clearScreen();
                        if (flag == 0)
                            return MembersMenu(Menu);
                        else
                            return LibrarianMenu(Menu);
                    case 6:
                        clearScreen();
                        return Menu.mainMenu(Menu);
                    default:
                        clearScreen();
                        System.out.println("Wrong input, please enter valid option");
                }
            } while (s_option != 6);
        } catch (Exception e) {
            System.out.print("Invalid Input !!");
        }
        return Menu;
    }

    private Main UpdateMenu(Main Menu) {
        clearScreen();
        Book S = new Book();
        Scanner input = new Scanner(System.in);
        System.out.println("\t\t--------Information Update Menu--------\n");
        System.out.print("Which attribute do you want to update\n");
        int s_option = 0, case_check;
        try {
            do {
                System.out.println("\n\t\tChoose what you want to update\n\n");
                System.out.println("\t1. Title\n");
                System.out.println("\t2. Book ID\n");
                System.out.println("\t3. Author\n");
                System.out.println("\t4. Genre\n");
                System.out.println("\t5. Quantity\n");
                System.out.println("\t6. Back to Librarian Menu\n");
                System.out.println("\t7. Back to Main Menu\n");
                s_option = input.nextInt();
                switch (s_option) {
                    case 1:
                        case_check = 1;
                        S.updateBook(case_check);
                        break;
                    case 2:
                        case_check = 2;
                        S.updateBook(case_check);
                        break;
                    case 3:
                        case_check = 3;
                        S.updateBook(case_check);
                        break;
                    case 4:
                        case_check = 4;
                        S.updateBook(case_check);
                        break;
                    case 5:
                        case_check = 5;
                        S.updateBook(case_check);
                        break;
                    case 6:
                        clearScreen();
                        return LibrarianMenu(Menu);
                    case 7:
                        clearScreen();
                        return Menu.mainMenu(Menu);
                    default:
                        clearScreen();
                        System.out.println("Wrong input, please enter valid option");
                }
            } while (s_option != 7);
        } catch (Exception e) {
            System.out.print("Invalid Input !!");
        }
        return Menu;
    }

    public static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

}
