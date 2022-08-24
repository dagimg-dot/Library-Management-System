class Date {
    private int month;
    private int day;
    private int year;

    public Date() {
        this.day = 1;
        this.month = 1;
        this.year = 2022;
    }

    public Date(int day, int month, int year) {
        this.year = year;
        this.month = checkMonth(month);
        this.day = checkDay(day);
    }

    public Date(Date d) {
        this.day = d.day;
        this.month = d.month;
        this.year = d.year;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = checkDay(day);
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = checkMonth(month);
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int checkMonth(int testMonth) {
        if (testMonth > 0 && testMonth <= 12) {
            return testMonth;
        } else {
            return 1;
        }
    }

    public int checkDay(int testDay) {
        int[] daysMonth = { 0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
        if (testDay > 0 && testDay <= daysMonth[this.month]) {
            return testDay;
        }

        if ((this.month == 2 && testDay == 29)
                && ((this.year % 400 == 0) || (this.year % 4 == 0 && this.year % 100 != 0))) {
            return testDay;
        } else {
            return 1;
        }
    }

    public String toString() {
        return String.format("%d,%d,%d", month, day, year);
    }

    public void display() {
        System.out.print(this.day + " / " + this.month + " / " + this.year);
    }
}

