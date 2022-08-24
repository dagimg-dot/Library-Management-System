import java.util.Scanner;
import java.util.ArrayList;

class Member implements Person {
    private String member_ID;
    private String name;
    private String phone_no;
    private String email;
    private Address address;

    static ArrayList<Member> MemberList = new ArrayList<Member>(0);

    public Member() {

    }

    public Member(String member_ID, String name, String phone_no, String email, Address address) {
        this.member_ID = member_ID;
        this.name = name;
        this.phone_no = phone_no;
        this.email = email;
        this.address = address;
    }

    public String getMember_ID() {
        return this.member_ID;
    }

    public void setMember_ID(String member_ID) {
        this.member_ID = member_ID;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone_no() {
        return this.phone_no;
    }

    public void setPhone_no(String phone_no) {
        this.phone_no = phone_no;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Address getAddress() {
        return this.address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public static Member searchMember(String Member_ID) {
        Member searchedMember = null;
        for (int i = 0; i < MemberList.size(); i++) {
            if (MemberList.get(i).getMember_ID().equalsIgnoreCase(Member_ID)) {
                searchedMember = MemberList.get(i);
            }
        }
        return searchedMember;
    }

    public Member memberForm(String memberID) {
        Address A1 = new Address();
        System.out.print("\n\t\tWelcome, new user. Please fill the following form\n");
        Scanner input = new Scanner(System.in);
        System.out.print("\n\t\t+++ Form for new users +++\n");
        System.out.println("Enter Your Name: ");
        name = input.nextLine();
        System.out.println("Enter Your Phone number: ");
        phone_no = input.nextLine();
        System.out.println("Enter your Email: ");
        email = input.nextLine();
        System.out.println("Enter your Address: ");
        char member_type_check = memberID.charAt(3);
        if (member_type_check != 'S') {
            try {
                System.out.println("Enter the name of the Builing you stay in: ");
                String Bu_name = input.nextLine();
                A1.setBuilding_name(Bu_name);
                System.out.println("Enter your Dorm No.: ");
                int d_no = input.nextInt();
                A1.setDorm_no(d_no);
            } catch (Exception e) {
                System.out.print("Invalid Input !!");
            }
        } else {
            try {
                System.out.println("Enter the Block number of the Builing your office is found: ");
                int Bl_no = input.nextInt();
                A1.setBuilding_no(Bl_no);
                System.out.println("Enter your Office No.: ");
                int o_no = input.nextInt();
                A1.setOffice_no(o_no);
            } catch (Exception e) {
                System.out.print("Invalid Input !!");
            }
        }
        Member m1 = new Member(memberID, name, phone_no, email, A1);
        MemberList.add(m1);
        return m1;
    }

    public void displayBooks() {
        BookIssue.displayBooksAvailable();
    }

    public void displayMembersBorrowed() {
        boolean flag = false;
        System.out.print("\t\tInformation about Members Who Borrowed a Book \n");
        for (int i = 0; i < MemberList.size(); i++) {
            flag = true;
            System.out.print("\nNo.: " + (i + 1) + "\t");
            System.out.print("\tMember ID: " + MemberList.get(i).getMember_ID() + "\t");
            System.out.print("\tMember Name: " + MemberList.get(i).getName() + "\t");
            System.out.print("\tPhone No.: " + MemberList.get(i).getPhone_no() + "\t");
            System.out.print("\tEmail: " + MemberList.get(i).getEmail() + "\t");
            System.out.print("\nBook Name: " + BookIssue.IssuedBookList.get(i).book_issued.getTitle());
        }
        if (flag == false) {
            System.out.println("\n\t\t-- No Record Found --\n");
        }
        System.out.println("\n");
    }
}

