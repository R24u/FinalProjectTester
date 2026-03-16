import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class TestMember {

    private Member member;
    private Book book;

    @Before
    public void setUp() {
        member = new Member("Alice");
        book = new Book("Clean Code", "Robert C. Martin");
    }

    @Test
    public void testMemberFlow() {
        assertEquals("Alice", member.getName());
        assertTrue(member.getBorrowedBooks().isEmpty());

        member.borrowBook(book);
        assertEquals(1, member.getBorrowedBooks().size());
        assertTrue(member.getBorrowedBooks().contains(book));
        assertTrue(book.isBorrowed()); 

        member.returnBook(book);
        assertTrue(member.getBorrowedBooks().isEmpty());
        assertFalse(book.isBorrowed()); 
    }


    @Test(expected = IllegalArgumentException.class)
    public void testConstructorInvalid() {
        new Member("");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testBorrowNullBook() {
        member.borrowBook(null);
    }
}