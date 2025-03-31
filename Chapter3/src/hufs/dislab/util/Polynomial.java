package Chapter3.src.hufs.dislab.util;

import java.util.NoSuchElementException;

public abstract class Polynomial {
    
    protected List<Term> terms;

    public boolean isZero() {
        return terms.isEmpty();
    }

    public double coef(int exp) {
        for (int i = 0; i < terms.size(); i++) {
            Term term = terms.get(i);

            if (term.exp == exp) {
                return term.coef;
            }
        }
        
        throw new NoSuchElementException();
    }

    public int maxExp() {
        if (isZero()) {
            throw new NoSuchElementException();
        }

        return terms.get(0).exp;
    }

    public Polynomial addTerm(double coef, int exp) {
        terms.add(new Term(coef, exp));
        return this;
    }

    public Polynomial delTerm(int exp) {
        for (int i = 0; i < terms.size(); i++) {
            if (terms.get(i).exp == exp) {
                terms.remove(i);
                return this;
            }
        }

        throw new NoSuchElementException();
    }

    /**
     * Factory method
     * 적절한 객체의 생성을 하위 클래스에게 맡기기 위한
     * 메소드
     * @return 새로운 다항식 객체
     */

    public abstract Polynomial createPolynomial();

    @Override
    public String toString() {
        return terms.toString();
    }

    public Polynomial add(Polynomial p) {
        Polynomial p1 = this;
        Polynomial p2 = p;
        Polynomial p3 = createPolynomial();
    

        while(!p1.isZero() && !p2.isZero()) {
            if (p1.maxExp() < p2.maxExp()) {
                p3.addTerm(p2.coef(p2.maxExp()), p2.maxExp());
                p2.delTerm(p2.maxExp());
            }

            else if (p1.maxExp() == p2.maxExp()) {
                double sum = p1.coef(p1.maxExp()) + p2.coef(p2.maxExp());
                if (sum != 0) {
                    p3.addTerm(sum, p1.maxExp());
                }

                p1.delTerm(p1.maxExp());
                p2.delTerm(p2.maxExp());
            }

            else {
                p3.addTerm(p1.coef(p1.maxExp()), p1.maxExp());
                p1.delTerm(p1.maxExp());
            }
        }

        while (!p1.isZero()) {
            p3.addTerm(p1.coef(p1.maxExp()), p1.maxExp());
            p1.delTerm(p1.maxExp());
        }

        while(!p.isZero()) {
            p3.addTerm(p2.coef(p2.maxExp()), p2.maxExp());
            p2.delTerm(p2.maxExp());
        }

        return p3;
    }
}