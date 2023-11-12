import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
abstract class Item {
    protected String title;
    protected String author;
    protected int year;
    protected boolean available;
public Item(String title, String author, int year) {
 this.title = title;
 this.author = author;
 this.year = year;
 this.available = true;
}
public abstract void checkOut();
public abstract void returnItem();
public abstract void displayDetails();

public String getTitle() {
        return title;
    }
public boolean isAvailable() {
        return available;
    }
public void setAvailable(boolean available) {
        this.available = available;
    }
}
// Book class as a subclass of Item
class Book extends Item {
    private String isbn;
public Book(String title, String author, int year, String isbn) {
 super(title, author, year);
  this.isbn = isbn;
    }

    @Override
  public void checkOut() {
  if (isAvailable()) {
    setAvailable(false);
  System.out.println("Book checked out successfully.");
        } else {
   System.out.println("Book is not available for checkout.");
        }
    }

  @Override
 public void returnItem() {
  setAvailable(true);
 System.out.println("Book returned successfully.");
    }

 @Override
 public void displayDetails() {
 System.out.println("Title: " + getTitle());
 System.out.println("Author: " + super.author);
 System.out.println("Year: " + super.year);
 System.out.println("ISBN: " + isbn);
 System.out.println("Available: " + (super.available ? "Yes" : "No"));
    }
}
// DVD class as a subclass of Item
class DVD extends Item {
    private String director;

    public DVD(String title, String director, int year) {
        super(title, "N/A", year);
        this.director = director;
    }
 @Override
 public void checkOut() {
 if (isAvailable()) {
 setAvailable(false);
 System.out.println("DVD checked out successfully.");
 } else {
 System.out.println("DVD is not available for checkout.");
 }
}
 @Override
 public void returnItem() {
 setAvailable(true);
 System.out.println("DVD returned successfully.");
    }
  @Override
 public void displayDetails() {
 System.out.println("Title: " + getTitle());
 System.out.println("Director: " + director);
 System.out.println("Year: " + super.year);
System.out.println("Available: " + (super. available ? "Yes" : "No"));
    }
}
public class LibraryManagementSystem {
public static void main(String[] args) {
 Scanner scanner = new Scanner(System.in);
List<Item> libraryItems = new ArrayList<>();
 while (true) {
  displayMenu();
 int choice = scanner.nextInt();
 scanner.nextLine(); // Consume the newline character
 
 switch (choice) {
 case 1:
 addBook(libraryItems, scanner);
 break;
 case 2:
 addDVD(libraryItems, scanner);
  break;
case 3:
displayAvailableItems(libraryItems);
 break;
 case 4:
 checkoutItem(libraryItems, scanner);
  break;
 case 5:
 returnItem(libraryItems, scanner);
 break;
 case 0:
System.out.println("Exiting the program.");
 scanner.close();
 System.exit(0);
 default:
System.out.println("Invalid choice. Please try again.");
 }
}
}
private static void displayMenu() {
System.out.println("Library Management System Menu:");
System.out.println("1. Add a book");
 System.out.println("2. Add a DVD");
 System.out.println("3. Display available items");
System.out.println("4. Check out item");
System.out.println("5. Return  item");
System.out.println("0. Exit");
System.out.print("Enter your choice: ");
}
private static void addBook(List<Item> libraryItems, Scanner scanner) {
System.out.print("Enter book title: ");
String title = scanner.nextLine();
System.out.print("Enter author: ");
String author = scanner.nextLine();
System.out.print("Enter  year: ");
int year = scanner.nextInt();
scanner.nextLine(); // Consume the newline character
 System.out.print("Enter ISBN: ");
String isbn = scanner.nextLine();
Item book = new Book(title, author, year, isbn);
libraryItems.add(book);
System.out.println("Book added to the library.");
}
private static void addDVD(List<Item> libraryItems, Scanner scanner) {
 System.out.print("Enter DVD title: ");
String title = scanner.nextLine();
System.out.print("Enter director: ");
String director = scanner.nextLine();
System.out.print("Enter release year: ");
int year = scanner.nextInt();
scanner.nextLine(); // Consume the newline character
Item dvd = new DVD(title, director, year);
libraryItems.add(dvd);
System.out.println("DVD added to the library.");
}
private static void displayAvailableItems(List<Item> libraryItems) {
System.out.println("Available items in the library:");
for (Item item : libraryItems) {
if (item.isAvailable()) {
item.displayDetails();
System.out.println();
}
}
}
private static void checkoutItem(List<Item> libraryItems, Scanner scanner) {
System.out.print("Enter the title of the item you want to check out: ");
String title = scanner.nextLine();
for (Item item : libraryItems) {
if (item.getTitle().equalsIgnoreCase(title)) {
item.checkOut();
return;
}
}
System.out.println("Item not found in the library.");
}
private static void returnItem(List<Item> libraryItems, Scanner scanner) {
System.out.print("Enter the title of the item you want to return: ");
String title = scanner.nextLine();
 for (Item item : libraryItems) {
 if (item.getTitle().equalsIgnoreCase(title)) {
item.returnItem();
return;
}
}   
 System.out.println("Item not found in the library.");
}
}

		
	
