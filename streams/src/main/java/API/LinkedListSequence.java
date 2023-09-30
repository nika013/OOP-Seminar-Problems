package API;

import java.util.Iterator;

public class LinkedListSequence<T> extends Sequence<T> {
    private Node head;
    private Node tail;
    private class Node {
        private T value;
        private Node next;
        public Node(T value) {
            this.value = value;
            next = null;
        }
    }

    public LinkedListSequence() {
        head = null;
        tail = null;
    }

    public LinkedListSequence<T> add(T elem) {
        Node node = new Node(elem);
        if (head == null) {
            head = node;
            tail = node;
            head.next = tail;
        } else {
            tail.next = node;
            tail = tail.next;
            tail.next = null;
        }
        return this;
    }

    private class Iter implements Iterator<T> {
        private Node current;
        public Iter() {
            current = head;
        }

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public T next() {
            T value = current.value;
            current = current.next;
            return value;
        }
    }

    @Override
    public Iterator iterator() {
        return new Iter();
    }
}
