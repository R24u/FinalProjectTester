import org.junit.Test;
import org.junit.Before;
import static org.junit.Assert.*;

public class TestBook {

    private Book book;

    @Before
    public void setUp() {
        book = new Book("ChainsawMan", "Fujimoto");
    }

    @Test
    public void testGetBook() {
        assertEquals("ChainsawMan", book.getTitle());
        assertEquals("Fujimoto", book.getAuthor());
        assertFalse("New book should not be borrowed", book.isBorrowed());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testTitleNull() {
        new Book(null, "Author");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testConstructorEmptyTitle() {
        new Book("   ", "Author");
    }

    @Test
    public void testBorrow() {
        book.borrow();
    }

    @Test(expected = IllegalStateException.class)
    public void TestRepeatBorrow() {
        book.borrow(); 
        book.borrow(); 
    }
    @Test
    public void testReturnBook() {
        book.borrow(); 
        book.returnBook(); 
    }
}