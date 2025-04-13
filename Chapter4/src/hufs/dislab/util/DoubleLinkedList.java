package hufs.dislab.util;

import java.lang.reflect.InaccessibleObjectException;
import java.util.NoSuchElementException;

public class DoubleLinkedList<E> extends List<E> {

    /**
     * 이중 연결 리스트에서 노드를 표현하기 위한 클래스이다.
     * 이 노드를 생성하면 기본적으로 모든 변수는 null이 된다.
     * Java에서는 변수의 값을 null로 설정하지 않아도 기본적으로 null이 된다.
     */

    public class ListNode {
        E data;
        ListNode rlink;
        ListNode llink;
    }

    protected ListNode head = null;
    protected ListNode tail = null;

    /**
     * @param p 삭제하고자 하는 노드
     * 노드 p를 삭제한다
     */

    public void delete(ListNode p) {
        if (p == null)
            throw new NullPointerException();

        if (p.llink != null)
            p.llink.rlink = p.rlink;

        else
            head = head.rlink;

        if (p.rlink != null)
            p.rlink.llink = p.llink;

        else
            tail = tail.llink;

        length--;
    }

    @Override
    public E remove(int index) {
        ListNode p = head;
        for(int i = 0; i < size(); i++) {
            if (i == index) {
                E oldElement = p.data;
                delete(p);
                return oldElement;
            }
            p = p.rlink;
        }
        throw new IndexOutOfBoundsException();
    }

    @Override
    public boolean remove(Object o) {
        ListNode p = head;
        for (int i = 0; i < size(); i++) {
            if (p.data.equals(o)) {
                delete(p);
                return true;
            }
            p = p.rlink;
        }
        return false;
    }

    @Override
    public E removeFirst() {
        if (length == 0)
            throw new NoSuchElementException();

        E data = head.data;

        if (length == 1)
            head = tail = null;
        
        else {
            head = head.rlink;
            head.llink = null;
        }
        length--;
        return data;
    }

    @Override
    public E removeLast() {
        if (length == 0)
            throw new NoSuchElementException();

        E data = tail.data;

        if (length == 1)
            head = tail = null;
        
            else {
                tail = tail.llink;
                tail.rlink = null;
            }

            length--;
            return data;
    }

    /**
     * @param p 이 노드 뒤에 삽입
     * @param q 삽입할 노드
     * 노드 p 뒤에 노드 q를 삽입한다.
     */

    public void insert(ListNode p, ListNode q) {
        if (q == null)
            throw new NullPointerException();

        q.llink = p;

        if (p == null) {    // 제일 앞에 삽입
            q.rlink = head;
            if (head != null)
                head.llink = q;
            head = q;
        }

        else {
            q.rlink = p.rlink;
            
            if (p.rlink != null)
                p.rlink.llink = q;
            else
                tail = q;
            
            p.rlink = q;
        }
        length++;
    }

    @Override
    public void add(int index, E element) {
        if (index < 0 || index > size())
            throw new IndexOutOfBoundsException();

        ListNode newNode = new ListNode();
        newNode.data = element;

        ListNode curr = head;
        ListNode prev = null;

        for (int i = 0; i < size(); i++) {
            if (i == index)
                break;
            
            prev = curr;
            curr = curr.rlink;
        }
        insert(prev, newNode);
    }

    @Override
    public void addFirst(E e) {
        ListNode newNode = new ListNode();
        newNode.data = e;
        newNode.rlink = head;
        newNode.llink = null;

        if (head == null)
            head = tail = newNode;
        length++;
    }

    public void addLast(E e) {
        ListNode newNode = new ListNode();
        newNode.data = e;
        newNode.rlink = null;
        newNode.llink = tail;

        if (tail == null)
            head = tail = newNode;
        length++;
    }

    @Override
    public boolean add(E element) {
        addLast(element);
        return true;
    }

    @Override
    public E set(int index, E element) {
        if (index < 0 || index > size())
            throw new IndexOutOfBoundsException();
        ListNode p = head;
        for (int i = 0; i < size(); i++) {
            if (i == index)
                break;
            p = p.rlink;
        }

        E oldElement = p.data;
        p.data = element;
        return oldElement;
    }

    @Override
    public E get(int index) {
        ListNode p = head;
        for (int i = 0; i < size(); i++) {
            if (i == index)
                return p.data;
            p = p.rlink;
        }
        throw new IndexOutOfBoundsException();
    }

    @Override
    public E getFirst() {
        if (head == null)
            throw new NoSuchElementException();
        return head.data;
        
    }

    @Override
    public E getLast() {
        if (tail == null) 
            throw new NoSuchElementException();
        return tail.data;
        
    }
}