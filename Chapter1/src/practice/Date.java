package practice;

public class Date {
    private int month;
    private int day;
    private int year;

    public Date() {
        month = 1;
        day = 1;
        year = 2003;
    }

    public Date(int month, int day, int year) {
        this.month = month;
        this.day = day;
        this.year = year;
    }

    public boolean equals(Object a) {
        if ( !(a instanceof Date) ) {
            return false;
        }

        Date d = (Date) a;
        return d.month == month && d.day == day &&
        d.year == year;
    }

    @Override
    public String toString() {
        return month + "/" + day + "/" + year;
    }
}
