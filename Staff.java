class Staff extends Member {
    Address A = new Address();

    public void displayMemberAddress() {
        System.out.print("Building No.: " + A.getBuilding_no());
        System.out.print("Office No.: " + A.getOffice_no());
    }

}
