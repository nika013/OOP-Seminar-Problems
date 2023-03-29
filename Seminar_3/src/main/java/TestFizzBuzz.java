import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TestFizzBuzz {
    @Test
    public void simpleTests() {
        FizzBuzz fb = new FizzBuzz();
        assertEquals("Fizz", fb.evaluate(3));
        assertEquals("Buzz", fb.evaluate(5));
        assertEquals("FizzBuzz", fb.evaluate(15));
    }

    @Test
    public void testContainsThree() {
        FizzBuzz fb = new FizzBuzz();
        assertEquals("Fizz", fb.evaluate(13));
        assertEquals("Fizz", fb.evaluate(310));
        assertEquals("Fizz", fb.evaluate(1037));
        assertEquals("17", fb.evaluate(17)); // not containS
    }

    @Test
    public void testDividesThree() {
        FizzBuzz fb = new FizzBuzz();
        assertEquals("Fizz", fb.evaluate(24)); // not contains and divides
        assertEquals("Fizz", fb.evaluate(132)); // contains and divides
        assertEquals("Fizz", fb.evaluate(462)); // not contains and divides
        assertEquals("17", fb.evaluate(17)); // neither valid case
    }

    @Test
    public void testOnFive() {
        FizzBuzz fb = new FizzBuzz();
        assertEquals("Fizz", fb.evaluate(130)); // contains 3 and is divide on 5
        assertEquals("Fizz", fb.evaluate(654)); // is divided on 3 and contains 5
        assertEquals("Buzz", fb.evaluate(151)); // contains not divides
        assertEquals("Buzz", fb.evaluate(250)); // contains and divides
        assertEquals("Buzz", fb.evaluate(100)); // not contains but divides
    }

    @Test
    public void TestOn15() {
        FizzBuzz fb = new FizzBuzz();
        assertEquals("FizzBuzz", fb.evaluate(150));
        assertEquals("FizzBuzz", fb.evaluate(23451));
        assertEquals("FizzBuzz", fb.evaluate(75));
    }

}
