package hufs.dislab.util;

import java.util.NoSuchElementException;

public abstract class List<E> {
    public abstract boolean add(E element);
    public abstract void add(int index, E element);
    public abstract E set(int index, E element);
    public abstract E get(int index);
    public abstract E remove(int index);
    public abstract boolean remove(Object o);

    public boolean isEmpty() {
        return size() == 0;
    }

    public int size() {
        return length;
    }

    public E getFirst() {
        if (isEmpty() == true) {
            throw new NoSuchElementException();
        }

        return get(0);
    }

    public E getLast() {
        if (isEmpty() == true) {
            throw new NoSuchElementException();
        }

        return get(size() - 1);
    }

    public void addFirst(E e) {
        add(0, e);
    }

    public void addLast(E e) {
        add(e);
    }

    public E removeFirst() {
        if (isEmpty() == true) {
            throw new NoSuchElementException();
        }

        return remove(0);
    }

    public E removeLast() {
        if (isEmpty() == true) {
            throw new NoSuchElementException();
        }

        return remove(size() - 1);
    }

    @Override
    public String toString() {
        StringBuffer str = new StringBuffer();
        str.append("(");
        
        for (int i = 0; i < size(); i++) {
            str.append(get(i));

            if (i < size() - 1) {
                str.append(",");
            }
        }

        str.append(")");
        return str.toString();
    }

    protected int length;
}