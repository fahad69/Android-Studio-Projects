package com.example.mylibrary;

import java.util.ArrayList;

public class util {

    private static ArrayList<book> all_books;

    private static ArrayList<book> current_books;

    private static ArrayList<book> want_to_read_books;

    private static ArrayList<book> already_read_books;

    private static int id = 0;

    public util() {
        if(all_books == null) {
            all_books = new ArrayList<>();
            initAllBooks();
        }
        if(current_books == null)
            current_books = new ArrayList<>();
        if(already_read_books == null)
            already_read_books = new ArrayList<>();
        if(want_to_read_books == null)
            want_to_read_books = new ArrayList<>();
    }

    private static void  initAllBooks()
    {

        String name = "";
        String author = "";
        String image_url = "";
        String description = "";
        int pages = 0;

        id++;
        name = "Pride and Prejudice";
        author = "Jane Austen";
        pages = 279;
        image_url = "https://i.gr-assets.com/images/S/compressed.photo.goodreads.com/books/1320399351l/1885.jpg";
        description = "Since its immediate success in 1813, Pride and Prejudice has remained one of the most popular novels in the English language. Jane Austen called this brilliant work \"her own darling child\" and its vivacious heroine, Elizabeth Bennet, \"as delightful a creature as ever appeared in print.";
        all_books.add(new book(id, name, author, pages, image_url, description));

        id++;
        name = "1984";
        author = "George Orwell";
        pages = 237;
        image_url = "https://i.gr-assets.com/images/S/compressed.photo.goodreads.com/books/1532714506l/40961427._SX318_.jpg";
        description = "Among the seminal texts of the 20th century, Nineteen Eighty-Four is a rare work that grows more haunting as its futuristic purgatory becomes more real. Published in 1949, the book offers political satirist George Orwell's nightmarish vision of a totalitarian, bureaucratic world and one poor stiff's attempt to find individuality.";
        all_books.add(new book(id, name, author, pages, image_url, description));

        id++;
        name = "To Kill a Mockingbird";
        author = "Harper Lee";
        pages = 324;
        image_url = "https://i.gr-assets.com/images/S/compressed.photo.goodreads.com/books/1553383690l/2657.jpg";
        description = "The unforgettable novel of a childhood in a sleepy Southern town and the crisis of conscience that rocked it, To Kill A Mockingbird became both an instant bestseller and a critical success when it was first published in 1960. It went on to win the Pulitzer Prize in 1961 and was later made into an Academy Award-winning film, also a classic.";
        all_books.add(new book(id, name, author, pages, image_url, description));

        id++;
        name = "The Great Gatsby";
        author = "F. Scott Fitzgerald";
        pages = 200;
        image_url = "https://i.gr-assets.com/images/S/compressed.photo.goodreads.com/books/1490528560l/4671._SY475_.jpg";
        description = "The Great Gatsby, F. Scott Fitzgerald's third book, stands as the supreme achievement of his career. This exemplary novel of the Jazz Age has been acclaimed by generations of readers";
        all_books.add(new book(id, name, author, pages, image_url, description));

        id++;
        name = "Great Expectations";
        author = "Charles Dickens";
        pages = 505;
        image_url = "https://i.gr-assets.com/images/S/compressed.photo.goodreads.com/books/1327920219l/2623.jpg";
        description = "'In what may be Dickens's best novel, humble, orphaned Pip is apprenticed to the dirty work of the forge but dares to dream of becoming a gentleman — and one day, under sudden and enigmatic circumstances, he finds himself in possession of \"great expectations.\" In this gripping tale of crime and guilt, revenge and reward";
        all_books.add(new book(id, name, author, pages, image_url, description));

        id++;
        name = "Little Women";
        author = "Louisa May Alcott";
        pages = 449;
        image_url = "https://i.gr-assets.com/images/S/compressed.photo.goodreads.com/books/1562690475l/1934._SY475_.jpg";
        description = "Generations of readers young and old, male and female, have fallen in love with the March sisters of Louisa May Alcott’s most popular and enduring novel, Little Women. Here are talented tomboy and author-to-be Jo, tragically frail Beth, beautiful Meg, and romantic, spoiled Amy, united in their devotion to each other";
        all_books.add(new book(id, name, author, pages, image_url, description));

        /*id++;
        name = "";
        author = "";
        pages = ;
        image_url = "";
        description = "";*/

    }

    public ArrayList<book> getAll_books() {
        return all_books;
    }

    public ArrayList<book> getCurrent_books() {
        return current_books;
    }

    public ArrayList<book> getWant_to_read_books() {
        return want_to_read_books;
    }

    public ArrayList<book> getAlready_read_books() {
        return already_read_books;
    }

    public boolean add_currently_reading_books(book b)
    {
        return current_books.add(b);
    }

    public boolean add_want_to_read_books(book b)
    {
        return want_to_read_books.add(b);
    }

    public boolean add_already_read_books(book b)
    {
        return already_read_books.add(b);
    }

    public boolean remove_currently_reading_books(book b)
    {
        return current_books.remove(b);
    }

    public boolean remove_want_to_read_books(book b)
    {
        return want_to_read_books.remove(b);
    }

    public boolean remove_already_read_books(book b)
    {
        return already_read_books.remove(b);
    }
}
