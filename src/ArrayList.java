import java.util.Iterator;

public class ArrayList<T> implements List<Integer> {

    private int size;
    private T items[];

    public ArrayList() {
        this.items = (T[]) new Object[10];
        this.size = 0;
    }

    private Object[] copy() {
        Object[] out = new Object[this.items.length + 10];
        System.arraycopy(this.items, 0, out, 0, this.items.length);
        return out;
    }

    @Override
    public void add(T item) {
        if (size + 1 > this.items.length) this.items = (T[]) copy();

        this.items[size++] = item;

    }

    @Override
    public void clear() {
        this.items = (T[]) new Object[10];
        this.size = 0;
    }

    @Override
    public boolean contains(T item) {
        for (T o : this.items) {
            if (o == item) return true;
        }
        return false;
    }

    @Override
    public T get(int i) {
        return this.items[i];
    }

    @Override
    public int indexOf(T item) {
        for (int i = 0; i < size; i++) if (this.items[i] == item) return i;

        return -1;
    }

    @Override
    public void removeAt(int i) {
        T[] temp = (T[]) new Object[size - i];
        int index = 0;
        for (int j = i+1; i < this.size; j++) temp[index++] = this.items[j];
        index = 0;
        for (int j = i; j < --this.size; j++) this.items[j] = temp[index++];

    }

    @Override
    public void set(int i, T item) {
        this.items[i] = item;
    }

    @Override
    public int size() {
        return this.size;
    }

    private class ArrayListIterator implements Iterator<T> {
        private int currentIndex = 0;

        @Override
        public boolean hasNext() {
            return currentIndex < size && items[currentIndex] != null;
        }

        @Override
        public T next() {
            return items[currentIndex++];
        }
    }

    @Override
    public Iterator<T> iterator() {
        return (Iterator<T>) new ArrayListIterator();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ArrayList that = (ArrayList)o;
        if (this.size != that.size) return false;
        for (int i = 0; i < size; i++) {
            if (!items[i].equals(that.items[i])) {
                return false;
            }
        }
        return true;
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder("[");
        for(int i = 0; i < size; i++) str.append(this.items[i]).append(", ");
        str.delete(str.length() - 2, str.length()).append("]");

        return str.toString();
    }
}
