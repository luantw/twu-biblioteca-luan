package com.twu.biblioteca;
import java.io.*;
import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.hamcrest.CoreMatchers.*;

public class ExampleTest {

    private ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private ArrayList<Book> books = new ArrayList<Book>();

    @Before
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
    }

    @Before
    public void setBooks() {
        for (int i=1; i<=7; i++) {
            Book book = new Book();
            book.setTitle("Game of thrones vol " + i);
            book.setPublicationYear(1995 + i);
            book.setAuthor("George R R Martin");
            books.add(book);
        }
    }

    @Test
    public void test() {
        assertEquals(1, 1);
    }

    @Test
    public void testWelcomeMessage() {
        BibliotecaApp biblioteca = new BibliotecaApp();
        biblioteca.main(null);
        String welcomeMessage = "Welcome to Biblioteca. Your one-stop-shop for great books titles in Bangalore!\n";
        assertThat(outContent.toString(), is(equalTo(welcomeMessage)));
    }

    @Test
    public void testBook() {
        Book book = new Book();
        book.setTitle("Game of Thrones");
        String title = "Game of Thrones";

        assertThat(title, is(equalTo(book.getTitle())));
    }

    @Test
    public void sizeOfBooksList() {
        assertThat(7, is(equalTo(books.size())));
    }

    @Test
    public void listAllBooks() {
        for(int i=0; i<7; i++) {
            assertThat("Game of thrones vol " + (i + 1), is(equalTo(books.get(i).getTitle())));
        }
    }

    @Test
    public void testPublicationYearOfABook() {
        Book book = new Book();
        book.setTitle("Game of thrones vol 1");
        book.setPublicationYear(1996);

        assertThat(1996, is(equalTo(book.getPublicationYear())));
    }

    @Test
    public void getAuthorOfABook() {
        Book book = new Book();
        book.setAuthor("George R R Martin");

        assertThat("George R R Martin", is(equalTo(book.getAuthor())));
    }

    @Test
    public void listPublicationYearsAndAuthorsFromBooks() {
        for(int i=0; i<7; i++) {
            assertThat(1996 + i, is(equalTo(books.get(i).getPublicationYear())));
            assertThat("George R R Martin", is(equalTo(books.get(i).getAuthor())));
        }
    }
}
