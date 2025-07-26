package day3;

import java.util.ArrayList;
import java.util.Scanner;

public class LibraryManager {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        ArrayList<Book> library = new ArrayList<>();

        while(true){
            System.out.println("\n====== Library Menu ======");
            System.out.println("1. Add a book");
            System.out.println("2. Show all books");
            System.out.println("3. Search by title");
            System.out.println("4. Exit");
            System.out.println("Choose an option(1-4): ");

             String choice = scanner.nextLine();

             switch(choice){
                 case "1":
                     System.out.print("Enter book title: ");
                     String title = scanner.nextLine();

                     System.out.print("Enter author: ");
                     String author = scanner.nextLine();

                     System.out.print("Enter price: ");
                     String priceStr = scanner.nextLine();
                     try{
                         double price = Double.parseDouble(priceStr);
                         Book book = new Book(title, author, price);
                         library.add(book);
                         System.out.println("Book added successfully!");
                     }catch(NumberFormatException e ){
                         System.out.println("Invalid price. Please try again.");
                     }
                     break;

                 case "2":
                     if(library.isEmpty()){
                         System.out.println("No books in the library.");
                     }else{
                         System.out.println("\nBooks in library:");
                         for (Book b : library){
                             System.out.println(b);
                         }
                     }

                     break;

                 case "3":
                     System.out.print("Enter title to search: ");
                     String keyword = scanner.nextLine();
                     boolean found = false;
                     for (Book b: library){
                         if(b.title.toLowerCase().contains(keyword.toLowerCase())){
                             System.out.println(b);
                             found = true;
                         }
                     }

                     if(!found){
                         System.out.println("No matching book found.");
                     }
                     break;

                 case "4":
                     System.out.println("Exiting Library Manager. Bye!");
                     scanner.close();
                     return;

                 default:
                     System.out.println("Invalid choice, try anagin.");
             }
        }
    }
}
