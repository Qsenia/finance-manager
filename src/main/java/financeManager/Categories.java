package financeManager;

public class Categories {
    protected String title;
    protected String date;
    protected int sum;

    public Categories(String title, String date, int sum) {
        this.title = title;
        this.date = date;
        this.sum = sum;
    }

    public String getTitle() {
        return title;
    }

    public String getDate() {
        return date;
    }

    public int getSum() {
        return sum;
    }

    @Override
    public String toString() {
        return "Categories{" +
                "title='" + title + '\'' +
                ", date='" + date + '\'' +
                ", sum=" + sum +
                '}';
    }
}
