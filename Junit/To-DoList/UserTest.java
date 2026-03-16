import org.junit.Test;
import static org.junit.Assert.;

public class UserTest {

    @Test(expected = IllegalArgumentException.class)
    public void nameEmptyTest() {
        new User();
    }

    @Test(expected = IllegalArgumentException.class)
    public void AddTaskIsNullTest() {
        User u = new User(JaneDoe);
        u.addTask(null);
    }

    @Test
    public void AddTaskAndRemoveTaskTest() {
        User u = new User(JaneDoe);
        u.addTask(new Task(Homework));
        u.addTask(new Task(Exam));

        assertEquals(2, u.getTasks().size());

        u.removeTask(homework);  ignoreCase
        assertEquals(1, u.getTasks().size());
        assertEquals(Exam, u.getTasks().get(0).getTitle());
    }
}
