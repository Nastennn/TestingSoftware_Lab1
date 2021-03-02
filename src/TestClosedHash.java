import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TestClosedHash extends Assertions {

    ClosedHash closedHash = new ClosedHash();

    @BeforeEach
    public void beforeEach() throws Exception {
        closedHash.insert("existing-string-1");
        closedHash.insert("existing-string-2");
    }

    @Test
    public void insert_test_positive() throws Exception {
        String str = "new-string-1";
        closedHash.insert(str);
        String found = closedHash.find(str);
        Assertions.assertEquals(str, found);
    }

    @Test
    public void insert_test_negative() throws Exception {
        closedHash.clear();
        for (int i = 0; i < 29; i++) {
            closedHash.insert("existing-string-" + i);
        }
        String str = "new-string-1";
        Assertions.assertThrows(Exception.class, () -> {
            closedHash.insert(str);
        });
    }


    @Test
    public void delete_test_positive() {
        int expectedDeletedCount = 1;
        int actualDeletedCount = closedHash.delete("existing-string-1");
        Assertions.assertEquals(expectedDeletedCount, actualDeletedCount);
    }

    @Test
    public void delete_test_negative() {
        int expectedDeletedCount = 0;
        int actualDeletedCount = closedHash.delete("not-existing");
        Assertions.assertEquals(expectedDeletedCount, actualDeletedCount);
    }

    @Test
    public void find_test_positive() {
        String expected = "existing-string-2";
        String actual = closedHash.find("existing-string-2");
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void find_test_negative() {
        String actual = closedHash.find("not-existing");
        Assertions.assertNull(actual);
    }
}
