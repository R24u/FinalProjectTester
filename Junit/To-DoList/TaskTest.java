import org.junit.Test;
import static org.junit.Assert.*;

public class TaskTest {

    @Test(expected = IllegalArgumentException.class)
    public void TaskNullTest() {
        new Task(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void titleTaskTest() {
        new Task("   ");
    }

    @Test
    public void TaskIsDone() {
        Task t = new Task("HomeWork");
        assertFalse(t.isDone());

        t.markDone();
        assertTrue(t.isDone());

        t.markUndone();
        assertFalse(t.isDone());
    }
}
