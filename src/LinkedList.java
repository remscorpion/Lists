import java.util.Iterator;

public class LinkedList<T> implements List<Integer> {
    class Node {
        T value;
        Node next;

        public Node(Object v) {
            this.value = (T) v;
            this.next = null;
        }

        public Node(Object v, Node n) {
            this.value = (T) v;
            this.next = n;
        }

        public boolean equals(Object v){
            return v == this.value;
        }
    }
    public Node head;
    public LinkedList() {
        this.head = null;
    }
    public LinkedList(Object v) {
        this.head = new Node(v);
    }
    @Override
    public void add(Integer item) {
        if (this.head == null) {
            this.head = new Node((T) item);
        } else {
            Node c = this.head;
            while (c != null){
                c = c.next;
            }

            c = new Node((T) item);
        }
    }

    @Override
    public void clear() {
        this.head = null;
    }

    @Override
    public boolean contains(Integer item) {
        Node c = this.head;
        while (c != null) {
            if (c.value == item) return true;

            c = c.next;
        }
        return false;
    }

    @Override
    public Integer get(int i) {
        Node c = this.head;
        int j = 0;
        while (j++ < i) c = c.next;

        return (Integer) c.value;
    }

    @Override
    public int indexOf(Integer item) {
        int i = 0;
        Node c = this.head;
        while (c != null) {
            if(c.value == item) return i;
            c = c.next;
        }
        return -1;
    }

    @Override
    public void removeAt(int i) {
        Node c = this.head;
        Node p = c;
        int j = 0;
        while (j++ <= i) {
            p = c;
            c = c.next;
        }
        p.next = c.next;

    }

    @Override
    public void set(int i, Integer item) {
        Node c = this.head;
        int j = 0;
        while (j++ <= i) c = c.next;
        c.value = (T) item;
    }

    @Override
    public int size() {
        if (this.head == null) return 0;
        int count = 0;
        Node c = this.head;
        while(c != null) {
            c = c.next;
            count++;
        }

        return count;
    }

    private class LinkedListIterator implements Iterator<T> {

        Node current = head;

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public T next() {
            Node n = current;
            current = current.next;
            return n.value;
        }
    }

    @Override
    public Iterator<Integer> iterator() {
        return (Iterator<Integer>) new LinkedListIterator();
    }
}
