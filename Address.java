class Address {
    private String building_name;
    private int dorm_no;
    private int building_no;
    private int office_no;

    public Address() {

    }

    public Address(String building_name, int dorm_no, int building_no, int office_no) {
        this.building_name = building_name;
        this.dorm_no = dorm_no;
        this.building_no = building_no;
        this.office_no = office_no;
    }

    public Address(Address A) {
        this.building_name = A.building_name;
        this.dorm_no = A.dorm_no;
        this.building_no = A.building_no;
        this.office_no = A.office_no;
    }

    public String getBuilding_name() {
        return this.building_name;
    }

    public void setBuilding_name(String building_name) {
        this.building_name = building_name;
    }

    public int getDorm_no() {
        return this.dorm_no;
    }

    public void setDorm_no(int dorm_no) {
        this.dorm_no = dorm_no;
    }

    public int getBuilding_no() {
        return this.building_no;
    }

    public void setBuilding_no(int building_no) {
        this.building_no = building_no;
    }

    public int getOffice_no() {
        return this.office_no;
    }

    public void setOffice_no(int office_no) {
        this.office_no = office_no;
    }

}
