package day3;

public class Book {
    String title;
    String author;
    double price;

    public Book(String title, String author, double price){
        this.title = title;
        this.author = author;
        this.price = price;
    }

    @Override
    public String toString(){
        return "《 " + title + "》 by " + author + ", #¥" + price;
    }
}
