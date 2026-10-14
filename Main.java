
import java.util.ArrayList;
import java.util.Scanner;

class Book {
    String title;
    String author;
    int id;
    boolean borrowed;

    public Book(String title, String author, int id) {
        this.title = title;
        this.author = author;
        this.id = id;
        this.borrowed = false;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        ArrayList<Book> books = new ArrayList<>();

        books.add(new Book("1984", "George Orwell", 1));
        books.add(new Book("Dune", "Frank Herbert", 2));

        int choice = -1;

        while (choice != 0) {
            System.out.println("\n=== Kutuphane Sistemi ===");
            System.out.println("1 - Kitaplari listele");
            System.out.println("2 - Kitap ekle");
            System.out.println("3 - Kitap odunc al");
            System.out.println("4 - Kitap iade et");
            System.out.println("5 - Kitap ara");
            System.out.println("0 - Cikis");
            System.out.print("Seciminiz: ");

            choice = input.nextInt();
            input.nextLine();

            if (choice == 1) {
                if (books.isEmpty()) {
                    System.out.println("Kutuphane bos.");
                } else {
                    for (Book book : books) {
                        System.out.println(
                            book.id + " - " + book.title
                            + " / " + book.author
                        );
                    }
                }

            } else if (choice == 2) {
                System.out.print("Kitap adi: ");
                String title = input.nextLine();

                System.out.print("Yazar: ");
                String author = input.nextLine();

                System.out.print("Kitap ID: ");
                int id = input.nextInt();
                input.nextLine();

                boolean found = false;

                for (Book book : books) {
                    if (book.id == id) {
                        found = true;
                        break;
                    }
                }

                if (found) {
                    System.out.println("Bu ID zaten kullaniliyor.");
                } else {
                    books.add(new Book(title, author, id));
                    System.out.println("Kitap basariyla eklendi.");
                }

            } else if (choice == 3) {
                System.out.print("Odunc almak istediginiz kitabin ID'si: ");
                int id = input.nextInt();
                input.nextLine();

                boolean found = false;

                for (Book book : books) {
                    if (book.id == id) {
                        found = true;

                        if (!book.borrowed) {
                            book.borrowed = true;
                            System.out.println("Kitap odunc verildi.");
                        } else {
                            System.out.println("Bu kitap zaten odunc verilmis.");
                        }

                        break;
                    }
                }

                if (!found) {
                    System.out.println("Kitap bulunamadi.");
                }

            } else if (choice == 4) {
                System.out.print("Iade edilecek kitabin ID'si: ");
                int id = input.nextInt();
                input.nextLine();

                boolean found = false;

                for (Book book : books) {
                    if (book.id == id) {
                        found = true;

                        if (book.borrowed) {
                            book.borrowed = false;
                            System.out.println("Kitap iade edildi.");
                        } else {
                            System.out.println("Bu kitap zaten musait.");
                        }

                        break;
                    }
                }

                if (!found) {
                    System.out.println("Kitap bulunamadi.");
                }

            } else if (choice == 5) {
                System.out.print("Kitap adi veya yazar: ");
                String search = input.nextLine().toLowerCase();

                boolean found = false;

                for (Book book : books) {
                    if (book.title.toLowerCase().contains(search)
                            || book.author.toLowerCase().contains(search)) {
                        System.out.println(
                            book.id + " - " + book.title
                            + " / " + book.author
                        );
                        found = true;
                    }
                }

                if (!found) {
                    System.out.println("Kitap bulunamadi.");
                }

            } else if (choice == 0) {
                System.out.println("Program kapatiliyor.");
            } else {
                System.out.println("Gecersiz secim.");
            }
        }

        input.close();
    }
}
