import java.util.Iterator;

public class LinkedList<T> implements List<Integer> {
    class Node {
        T value;
        Node next;

        public Node(T v) {
            this.value = v;
            this.next = null;
        }

        public boolean equals(Object v){
            return v == this.value;
        }

        @Override
        public String toString() {
            return this.value + "";
        }
    }
    public Node head;

    public LinkedList() {
        this.head = null;
    }

    public LinkedList(T v) {
        this.head = new Node(v);
    }

    @Override
    public void add(T item) {
        if (this.head == null) {
            this.head = new Node(item);
        } else {
            Node c = this.head;
            while (c != null){
                c = c.next;
            }

            c = new Node(item);
        }
    }

    @Override
    public void clear() {
        this.head = null;
    }

    @Override
    public boolean contains(T item) {
        Node c = this.head;
        while (c != null) {
            if (c.value == item) return true;

            c = c.next;
        }
        return false;
    }

    @Override
    public T get(int i) {
        Node c = this.head;
        int j = 0;
        while (j++ < i) c = c.next;

        return c.value;
    }

    @Override
    public int indexOf(T item) {
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
    public void set(int i, T item) {
        Node c = this.head;
        int j = 0;
        while (j++ <= i) c = c.next;
        c.value = item;
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
    public String toString() {
        StringBuilder str = new StringBuilder("[");
        Node c = this.head;
        while(c != null) {
            str.append(c).append(", ");
            c = c.next;
        }
        str.delete(str.length() - 2, str.length()).append("]");

        return str.toString();
    }

    @Override
    public Iterator<Integer> iterator() {
        return (Iterator<Integer>) new LinkedListIterator();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LinkedList that = (LinkedList)o;
        Node thisNode = this.head;
        Node thatNode = that.head;
        while (thisNode != null && thatNode != null) {
            if (!thisNode.value.equals(thatNode.value)) {
                return false;
            }
            thisNode = thisNode.next;
            thatNode = thatNode.next;
        }
        if (thisNode == thatNode) return true;
        else                      return false;
    }

}
