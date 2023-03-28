package org.example;

import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;

import java.lang.reflect.Executable;
import java.util.Optional;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

public class MyStackTest {
    public MyStack<Integer> intSt = new MyStack<>();
    public MyStack<String> strSt = new MyStack<>();
    @Test
    public void intTests() {
        intSt.push(1);
        intSt.push(2);
        intSt.push(3);
        assertEquals(Optional.of(3), Optional.ofNullable(intSt.pop()));
        assertEquals(Optional.of(2), Optional.ofNullable(intSt.pop()));
        intSt.push(-1);
        intSt.push(-1);
        assertEquals(Optional.of(-1), Optional.ofNullable(intSt.pop()));
    }
    @Test
    public void strTests() {
        strSt.push("1");
        strSt.push("2");
        strSt.push("Hello");
        strSt.push("World");
        strSt.push("Hi there");
        assertEquals("Hi there", strSt.pop());
        assertEquals("World", strSt.pop());
        strSt.push("Hi");
        assertEquals("Hi", strSt.pop());
        assertEquals("Hello", strSt.pop());
    }
    @Test
    public void sizeTest() {
        intSt.push(1);
        intSt.push(-1);
        intSt.push(100);
        intSt.push(10);
        assertEquals(4, intSt.size());
        intSt.pop();
        assertEquals(3, intSt.size());
        intSt.push(0);
        assertEquals(4, intSt.size());
    }
    @Test
    public void emptyStack() {
        assertThrows(ArrayIndexOutOfBoundsException.class, () -> {
            MyStack<Character> stack = new MyStack<>();
            stack.pop();
        });
    }
}
