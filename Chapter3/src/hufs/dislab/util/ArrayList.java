package Chapter3.src.hufs.dislab.util;

public class ArrayList<E> extends List<E> {
    
    public ArrayList(int initialCapacity) {
        a = new Object[initialCapacity];
    }

    @Override
    public boolean add(E element) {
        if (length >= a.length) {
            throw new IndexOutOfBoundsException();
        }

        a[length++] = element;
        return true;
    }

    @Override
    public void add(int index, E element) {
        if (index < 0 || index > size() || index >= a.length) {
            throw new IndexOutOfBoundsException();
        }

        for (int i = size() - 1; i >= index; i--) {
            a[i + 1] = a[i];
        }

        a[index] = element;
        length++;
    }

    @Override
    @SuppressWarnings("unchecked")
    public E set(int index, E element) {
        if (index < 0 || index >= size()) {
            throw new IndexOutOfBoundsException();
        }

        E oldElement = (E)a[index];
        a[index] = element;
        return oldElement;
    }

    @Override
    @SuppressWarnings("unchecked")
    public E get (int index) {
        if (index < 0 || index >= size()) {
            throw new IndexOutOfBoundsException();
        }

        return (E)(a[index]);
    }

    @Override
    @SuppressWarnings("unchecked")
    public E remove(int index) {
        if (index < 0 || index >= size()) {
            throw new IndexOutOfBoundsException();
        }

        E oldElement = (E)a[index];

        for (int i = index; i < size() - 1; i++) {
            a[i] = a[i + 1];
        }

        length--;
        return oldElement;
    }

    @Override
    @SuppressWarnings("unchecked")
    public boolean remove(Object o) {
        for (int i = 0; i < size(); i++) {
            if (get(i).equals(o)) {
                remove(i);
                return true;
            }
        }

        return false;
    }
    
    private Object[] a;
}