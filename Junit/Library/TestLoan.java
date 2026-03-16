import org.junit.Test;
import static org.junit.Assert.*;

public class TestLoan {

    @Test
    public void testInfo() {
        Book book = new Book("ChainsawMan", "Fujimoto");
        Member member = new Member("JaneDoe");
        Loan loan = new Loan(book, member);
        
        assertEquals(book, loan.getBook());
        assertEquals(member, loan.getMember());
        assertNotNull(loan.getBorrowDate());
        assertNull(loan.getReturnDate());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testNullBook() {
        new Loan(null, new Member("JaneDoe"));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testNullMember() {
        new Loan(new Book("ChainsawMan", "Fujimoto"), null);
    }

    @Test
    public void testReturnBook() {
        Book book = new Book("ChainsawMan", "Fujimoto");
        Member member = new Member("JaneDoe");
        member.borrowBook(book);
        Loan loan = new Loan(book, member);
        
        loan.returnBook();
        assertNotNull(loan.getReturnDate());
        assertFalse(book.isBorrowed());
    }
}