class Student extends Member {
    Address A = new Address();

    public void displayMemberAddress() {
        System.out.print("Building Name: " + A.getBuilding_name());
        System.out.print("Dorm No.: " + A.getDorm_no());
    }

}