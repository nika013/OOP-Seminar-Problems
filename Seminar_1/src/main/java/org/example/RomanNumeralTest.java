package org.example;

import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class RomanNumeralTest {

    @Test
    public void simpleArabicTest() {
        RomanNumeral rm = new RomanNumeral(1);
        assertEquals(1, rm.toInt());

        rm = new RomanNumeral(4);
        assertEquals(4, rm.toInt());

        rm = new RomanNumeral(9);
        assertEquals(9, rm.toInt());
    }

    @Test
    public void simpleRomanTests() {
        RomanNumeral rm = new RomanNumeral("I");
        assertEquals("I", rm.toString());
        rm = new RomanNumeral("III");
        assertEquals("III", rm.toString());

        rm = new RomanNumeral("IV");
        assertEquals("IV", rm.toString());

        rm = new RomanNumeral("X");
        assertEquals("X", rm.toString());

        rm = new RomanNumeral("IX");
        assertEquals("IX", rm.toString());
    }
    @Test
    public void arabToRoman() {
        RomanNumeral rm = new RomanNumeral(9);
        assertEquals("IX", rm.toString());
        assertEquals(9, rm.toInt());

        rm = new RomanNumeral(90);
        assertEquals("XC", rm.toString());
        assertEquals(90, rm.toInt());

        rm = new RomanNumeral(499);
        assertEquals("CDXCIX", rm.toString());
        assertEquals(499, rm.toInt());

        rm = new RomanNumeral(27);
        assertEquals("XXVII", rm.toString());
        assertEquals(27, rm.toInt());

        rm = new RomanNumeral(3999);
        assertEquals("MMMCMXCIX", rm.toString());
        assertEquals(3999, rm.toInt());

        rm = new RomanNumeral(990);
        assertEquals("CMXC", rm.toString());
        assertEquals(990, rm.toInt());

        rm = new RomanNumeral(444);
        assertEquals("CDXLIV", rm.toString());
        assertEquals(444, rm.toInt());
    }

    @Test
    public void romanToArab() {
        RomanNumeral rm = new RomanNumeral("IV");
        assertEquals("IV", rm.toString());
        assertEquals(4, rm.toInt());

        rm = new RomanNumeral("V");
        assertEquals("V", rm.toString());
        assertEquals(5, rm.toInt());

        rm = new RomanNumeral("XIX");
        assertEquals("XIX", rm.toString());
        assertEquals(19, rm.toInt());

        rm = new RomanNumeral("CDXLIV");
        assertEquals("CDXLIV", rm.toString());
        assertEquals(444, rm.toInt());

        rm = new RomanNumeral("XXXIV");
        assertEquals("XXXIV", rm.toString());
        assertEquals(34, rm.toInt());

        rm = new RomanNumeral("MMMCMXCIX");
        assertEquals("MMMCMXCIX", rm.toString());
        assertEquals(3999, rm.toInt());
    }

    @Test
    public void invalidTest() {
        try {
            RomanNumeral rm = new RomanNumeral("KKK");
        } catch (NumberFormatException e) {
            System.out.println(e.toString() + " Default value wokrs!");
        }
    }

}
