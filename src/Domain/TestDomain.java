package Domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TestDomain extends Assertions {

    Person p1;
    Person p2;
    Horse h1;
    Horse h2;

    @BeforeEach
    public void beforeEach() {
        p1 = new Person("Person1", 25);
        p2 = new Person("Person2", 17);
        h1 = new Horse(HorseType.WILD);
        h2 = new Horse(HorseType.WILD);
    }

    @Test
    public void test_sitting_positive() {
        p1.sit();
        Assertions.assertTrue(p1.is_sitting);
    }

    @Test
    public void test_sitting_default() {
        Assertions.assertFalse(p2.is_sitting);
    }

    @Test
    public void test_jumping_positive() {
        p1.jump();
        Assertions.assertTrue(p1.is_jumping);
    }

    @Test
    public void test_jumping_default() {
        Assertions.assertFalse(p2.is_jumping);
    }


    @Test
    public void test_seeing_positive() {
        p1.see();
        Assertions.assertTrue(p1.is_seeing);
    }

    @Test
    public void test_seeing_default() {
        Assertions.assertFalse(p2.is_seeing);
    }

    @Test
    public void test_age_positive() {
        Assertions.assertTrue(p1.grown_up);
    }

    @Test
    public void test_age_default() {
        Assertions.assertFalse(p2.grown_up);
    }

    @Test
    public void test_horse_is_loaded_positive() {
        Shipment shipment = new Shipment("сено", true);
        h1.load_horse(shipment);
        Assertions.assertTrue(h1.is_loaded);
    }

    @Test
    public void test_horse_is_loaded_default() {
        Assertions.assertFalse(h2.is_loaded);
    }

    @Test
    public void test_horse_is_driving_positive() {
        h1.drive();
        Assertions.assertTrue(h1.is_driving);
    }

    @Test
    public void test_horse_is_driving_default() {
        Assertions.assertFalse(h2.is_driving);
    }

    @Test
    public void test_person_emotional_state_worried() {
        p1.worry();
        Assertions.assertEquals(EmotionalStatus.WORRIED, p1.status);
    }

    @Test
    public void test_person_emotional_state_calm() {
        p1.calmDown();
        Assertions.assertEquals(EmotionalStatus.CALM, p1.status);
    }

    @Test
    public void test_person_emotional_state_default() {
        Assertions.assertEquals(EmotionalStatus.CALM, p2.status);
    }

    @Test
    public void test_person_size_positive() {
        Size[] sizes = {Size.HUGE, Size.MEDIUM, Size.SMALL};

        for (Size size : sizes) {
            p1.setSize(size);
            Assertions.assertEquals(size, p1.size);
        }
    }

    @Test
    public void test_person_size_default() {
        Assertions.assertNotEquals(Size.HUGE, p2.size);
    }

    @Test
    public void test_check_horse_type_domestic() {
        Horse horse = new Horse(HorseType.DOMESTIC);
        String actual = horse.check_horse_type();
        String expected = "Домашняя";
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void test_check_horse_type_wild() {
        Horse horse = new Horse(HorseType.WILD);
        String actual = horse.check_horse_type();
        String expected = "Дикая";
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void test_check_size_huge() {
        p1.setSize(Size.HUGE);
        String actual = p1.check_size();
        String expected = "огромный";
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void test_check_size_medium() {
        p1.setSize(Size.MEDIUM);
        String actual = p1.check_size();
        String expected = "средний";
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void test_check_size_small() {
        p1.setSize(Size.SMALL);
        String actual = p1.check_size();
        String expected = "малнький";
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void test_check_status_worried() {
        p1.worry();
        String actual = p1.check_status();
        String expected = "с беспокойством";
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void test_check_status_calm() {
        p1.calmDown();
        String actual = p1.check_status();
        String expected = "спокойно";
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void test_analyze_age_grownup() {
        String actual = p1.analyze_age(p1.age);
        String expected = "взрослый";
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void test_analyze_age_child() {
        String actual = p2.analyze_age(p2.age);
        String expected = "ребенок";
        Assertions.assertEquals(expected, actual);
    }

}
