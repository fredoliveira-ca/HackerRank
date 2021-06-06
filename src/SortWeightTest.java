import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SortWeightTest {

    @Test
    void BasicTests() {
        System.out.println("** Basic Tests **");
        assertEquals("2000 103 123 4444 99", SortWeight.sortWeight("103 123 4444 99 2000"));
        assertEquals("11 11 2000 10003 22 123 1234000 44444444 9999", SortWeight.sortWeight("2000 10003 1234000 44444444 9999 11 11 22 123"));
    }

    @Test
    void testFromExample() {
        assertEquals("100 180 90 56 65 74 68 86 99", SortWeight.sortWeight("56 65 74 100 99 68 86 180 90"));
    }

    @Test
    void shouldBeEmptyWhenListIsEmpty() {
        assertEquals("", SortWeight.sortWeight(""));
    }
}