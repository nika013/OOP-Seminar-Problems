import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class TestPair {
    @Test
    public void simpleTest() {
        Pair<Integer, Integer> p = new Pair<>(5, 10);
        assertEquals(5, (int)p.getFirst());
        assertEquals(10, (int)p.getSecond());
        p.setFirst(13);
        p.setSecond(90);
        assertEquals(13, (int)p.getFirst());
        assertEquals(90, (int)p.getSecond());
    }

    @Test
    public void testDifferentTypes() {
        Pair<Integer, Character> p = new Pair<>(3, 'A');
        assertEquals(3, (int)p.getFirst());
        assertEquals('A', (char)p.getSecond());
        p.setFirst(13);
        p.setSecond('b');
        assertEquals(13, (int)p.getFirst());
        assertEquals('b', (char)p.getSecond());
    }

    @Test
    public void testCompare() {
        Pair<Integer, Character> p1 = new Pair<>(10, 'A');
        Pair<Integer, Character> p2 = new Pair<>(10, 'B');
        assertEquals(false, p1.equals(p2));
        assertEquals(true, p1.equals(p1));
        p2.setSecond('A');
        assertEquals(true, p2.equals(p1));
        ArrayList<String> arr = new ArrayList<>();
        assertEquals(false, p1.equals(arr));
    }
}
