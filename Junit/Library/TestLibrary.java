import org.junit.Test;
import static org.junit.Assert.*;

public class TestLibrary {

    @Test
    public void testAddBook() {
        Library lib = new Library("Test");
        lib.addBook(new Book("ChainsawMan", "Fujimoto"));
        assertEquals(1, lib.getBooks().size());
    }

    @Test
    public void testBorrowBook() {
        Library lib = new Library("Test");
        lib.addBook(new Book("ChainsawMan", "Fujimoto"));
        Loan loan = lib.borrowBook("ChainsawMan", new Member("JaneDoe"));
        assertNotNull(loan);
    }

    @Test(expected = IllegalStateException.class)
    public void testBorrowBookNotAvailable() {
        Library lib = new Library("Test");
        lib.addBook(new Book("ChainsawMan", "Fujimoto"));
        lib.borrowBook("ChainsawMan", new Member("JaneDoe"));
        lib.borrowBook("ChainsawMan", new Member("Denji"));
    }

    @Test
    public void testReturnBook() {
        Library lib = new Library("Test");
        Book book = new Book("ChainsawMan", "Fujimoto");
        Member m = new Member("JaneDoe");
        lib.addBook(book);
        lib.borrowBook("ChainsawMan", m);
        lib.returnBook(book, m);
        assertFalse(book.isBorrowed());
    }

    @Test
    public void testGetAvailableBookCount() {
        Library lib = new Library("Test");
        lib.addBook(new Book("Book1", "A"));
        assertEquals(1, lib.getAvailableBookCount());
    }
}