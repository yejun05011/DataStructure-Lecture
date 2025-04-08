package Chapter4.src.hufs.dislab.util;

public class LinkedList<E> extends List<E> {

    public class ListNode {
        E data;
        ListNode link;
    }

    protected ListNode head;

    /**
     * 리스트의 맨 앞에 원소 x를 삽입
     */

    public void addFirst(E e) {
        ListNode newNode = new ListNode();
        newNode.data = e;
        newNode.link = head;
        head = newNode;
        length++;
    }

    /**
     * 리스트에서 p가 가리키는 노드 다음에 원소 x를 삽입
     * 알고리즘 4.1의 Java 구현
     */

    void insertNode(ListNode p, E e) {
        ListNode newNode = new ListNode();
        newNode.data = e;

        if (head == null) {
            head = newNode;
            // newNode.link = null;
        }

        else if (p == null) {
            newNode.link = head;
            head = newNode;
        }

        else {
            newNode.link = p.link;
            p.link = newNode;
        }

        length++;
    }

    /**
     * list의 끝에 원소 x를 삽입
     * 알고리즘 4.2의 Java 구현
     */

    public void addLast(E e) {
        ListNode newNode = new ListNode();
        newNode.data = e;
        // newNode.link = null;

        if (head == null) {
            head = newNode;
        }

        else {
            ListNode p = head;

            while (p.link != null) {
                p = p.link;
            }

            length++;
        }
    }

    @Override
    public boolean add(E element) {
        addLast(element);
        return true;
    }

    @Override
    public void add(int index, E element) {
        ListNode cur = head, prev = null;
        int i = 0;

        while (i < size() && cur != null) {
            if (i == index) {
                insertNode(prev, element);
                return;
            }

            i++;
            prev = cur;
            cur = cur.link;
        }

        throw new IndexOutOfBoundsException();
    }

    /**
     * 두 개의 리스트를 하나의 리스트로 연결
     * 알고리즘 4.5의 Java 구현
     */

    public LinkedList<E> addAll(LinkedList<E> list) {
        if (head == null) {
            head = list.head;
            length = list.length;
        }

        else if (list.head != null) {
            ListNode p = head;

            while (p.link != null) {
                p = p.link;
            }
            
            p.link = list.head;
            length += list.length;
        }

        return this;
    }

    /**
     * 단순 연결 리스트에서 원소 값이 x인 노드를 탐색
     * 알고리즘 4.6의 Java 구현
     */

    ListNode searchNode(E e) {
        for (ListNode p = head; p != null; p = p.link) {
            if (e.equals(p.data))
                return p;
        }

        return null;
    }

    /**
     * p가 가리키는 노드의 다음 노드를 삭제
     * 알고리즘 4.3의 Java 구현
     */

    void deleteNext(ListNode p) {
        if (head == null)
            throw new NullPointerException();
        if (p = null)
            head = head.link;
        else {
            ListNode q = p.link;

            if (q == null)
                return;
            p.link = q.link;
        }
        length--;
    }

    /**
     * 리스트의 원소를 역순으로 반환
     * 알고리즘 4.4의 Java 구현
     */

    public void reverse() {
        ListNode p = head;
        ListNode q = null;
        ListNode r = null;

        while (p != null) {
            r = q;
            q = p;
            p = p.link;
            q.link = r;
        }

        head = q;
    }

    /**
     * 리스트의 마지막 원소를 삭제
     * 알고리즘 4.2의 Java 구현
     */

    public void deleteLast() {
        ListNode prev, curr;

        if (head == null)
            return;

        if (head.link == null)
            head = null;
        
        else {
            prev = head;
            curr = head.link;

            while (curr.link != null) {
                prev = curr;
                curr = curr.link;
            }

            prev.link = null;
        }

        length--;
    }

    @Override
    public String toString() {
        StringBuffer str = new StringBuffer();
        ListNode p;
        str.append("(");
        p = head;

        while (p != null) {
            str.append(p.data);
            p = p.link;

            if (p != null)
                str.append(",")
        }

        str.append(")");
        return str.toString();
    }

    @Override
    public E remove(int index) {
        ListNode cur = head, prev = null;
        int i = 0;

        while (i < size() && cur != null) {
            if (i == index) {
                E e = cur.data;
                if (prev != null)
                    prev.link = cur.link;
                else
                    head = cur.link;
                length--;
                return e;
            }
            i++;
            prev = cur;
            cur = cur.link;
        }
        throw new IndexOutOfBoundsException();
    }

    @Override
    public boolean remove(Object o) {
        ListNode cur = head, prev = null;

        while (cur != null) {
            if (cur.data.equals(o)) {
                if (prev != null)
                    prev.link = cur.link;
                else
                    head = cur.link;
                length--;
                return true;
            }
            prev = cur;
            cur = cur.link;
        }
        return false;
    }

    @Override
    public E set(int index, E element) {
        ListNode cur = head;
        int i = 0;

        while (i < size() && cur != null) {
            if (i == index) {
                E e = cur.data;
                cur.data = element;
                return e;
            }
            i++;
            cur = cur.link;
        }
        throw new IndexOutOfBoundsException();
    }

    @Override
    public E get(int index) {
        ListNode cur = head;
        int i = 0;

        while (i < size() && cur != null) {
            if (i == index) {
                return cur.data;
            }
            i++;
            cur = cur.link;
        }
        throw new IndexOutOfBoundsException();
    }
}
