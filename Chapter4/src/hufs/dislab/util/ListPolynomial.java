package hufs.dislab.util;

import java.util.NoSuchElementException;

public class ListPolynomial extends Polynomial {
    protected DoubleLinkedList<Term> poly;

    @Override
    public double coef(int exp) {
        DoubleLinkedList<Term>.ListNode p = poly.head;
        while (p != null) {
            if (p.data.exp == exp)
                return p.data.coef;
            p = p.rlink;
        }
        throw new NoSuchElementException();
    }

    @Override
    public int maxExp() {
        if (isZero())
            throw new IndexOutOfBoundsException();

        return poly.getFirst().exp;
    }

    @Override
    public Polynomial addTerm(double coef, int exp) {
        poly.addLast(new Term(coef, exp));
        return this;
    }

    @Override
    public Polynomial delTerm(int exp) {
        DoubleLinkedList<Term>.ListNode p = poly.head;
        while (p != null) {
            if (p.data.exp == exp) {
                poly.delete(p);
                return this;
            }
            p = p.rlink;
        }
        throw new NoSuchElementException();
    }

    @Override
    public Polynomial createPolynomial() {
        return new ListPolynomial();
    }

    @Override
    public String toString() {
        return terms.toString();
    }
}