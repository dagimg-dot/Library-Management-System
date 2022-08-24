class Librarian implements Person {
    private String librarian_name = "dagim";
    private String password = "1235";

    public Librarian() {

    }

    Librarian(String name, String password) {
        this.librarian_name = name;
        this.password = password;
    }

    public String getLibrarian_name() {
        return this.librarian_name;
    }

    public void setLibrarian_name(String librarian_name) {
        this.librarian_name = librarian_name;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void displayBooks() {
        BookIssue.displayBooksIssued();
    }
}
