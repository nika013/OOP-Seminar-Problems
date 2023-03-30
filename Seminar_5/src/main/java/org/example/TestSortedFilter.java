package org.example;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

public class TestSortedFilter {
    @Test
    public void testSimple() {
        SortedFilter f = new SortedFilter();
        assertEquals(0, f.size());
        f.add(5);
        f.add(1);
        f.add(13);
        assertEquals(true, f.isPresent(5));
        assertEquals(true, f.isPresent(1));
        assertEquals(true, f.isPresent(13));
        System.out.println(Arrays.toString(f.positions));
        f.remove(5);
        assertEquals(false, f.isPresent(5));
        assertEquals(2, f.size());
    }

}
