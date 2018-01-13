package domain;

public class Book {
    private String bname;
    private String author;
    private double price;
    private String category;

    public Book() {
    }

    public String getBname() {
        return bname;
    }

    @Override
    public String toString() {
        return "domain.Book{" +
                "bname='" + bname + '\'' +
                ", author='" + author + '\'' +
                ", price='" + price + '\'' +
                ", category='" + category + '\'' +
                '}';
    }

    public void setBname(String bname) {
        this.bname = bname;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Book(String bname, String author, double price, String category) {

        this.bname = bname;
        this.author = author;
        this.price = price;
        this.category = category;
    }
}
