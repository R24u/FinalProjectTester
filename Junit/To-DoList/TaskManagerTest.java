import org.junit.Test;
import static org.junit.Assert.*;

public class TaskManagerTest {

    @Test(expected = IllegalArgumentException.class)
    public void addUserIsNullTest() {
        TaskManager tm = new TaskManager();
        tm.addUser(null);
    }

    @Test
    public void findUserAndUsernotFoundNullTest() {
        TaskManager tm = new TaskManager();
        tm.addUser(new User("JaneDoe"));

        assertNotNull(tm.findUser("JaneDoe")); // ignoreCase
        assertNull(tm.findUser("JohnDoe"));      // not found
    }
}
