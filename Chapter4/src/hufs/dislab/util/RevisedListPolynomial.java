package hufs.dislab.util;

public class RevisedListPolynomial extends ListPolynomial {

    @Override
    public Polynomial add(Polynomial p) {
        RevisedListPolynomial p1 = this;
        RevisedListPolynomial p2 = (RevisedListPolynomial) p;
        Polynomial p3 = createPolynomial();

        DoubleLinkedList<Term>.ListNode t1 = p1.poly.head;
        DoubleLinkedList<Term>.ListNode t2 = p2.poly.head;

        while (t1 != null && t2 != null) {
            if (t1.data.exp < t2.data.exp) {
                p3.addTerm(t2.data.coef, t2.data.exp);
                t2 = t2.rlink;
            } else if (t1.data.exp == t2.data.exp) {
                double sum = t1.data.coef + t2.data.coef;
                if (sum != 0) {
                    p3.addTerm(sum, t1.data.exp);
                }
                t1 = t1.rlink;
                t2 = t2.rlink;
            } else {
                p3.addTerm(t1.data.coef, t1.data.exp);
                t1 = t1.rlink;
            }
        }

        for ( ; t1 != null; t1 = t1.rlink) {
            p3.addTerm(t1.data.coef, t1.data.exp);
        }

        for ( ; t2 != null; t2 = t2.rlink) {
            p3.addTerm(t2.data.coef, t2.data.exp);
        }

        return p3;
    }

    @Override
    public Polynomial createPolynomial() {
        return new RevisedListPolynomial();
    }
}
