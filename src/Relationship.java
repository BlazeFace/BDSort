import java.util.ArrayList;

/**
 * Created by Nate Bensing on 5/30/2017.
 */
public class Relationship {
    private Kink first;
    private Kink second;
    private int compatibility;
    public Relationship(Kink a,Kink b){
        first = a;
        second = b;
        compatibility = compute(1,3);
    }
    public String toString(){
        return ""+compatibility;
    }
    private int compute(int prim, int sec){
        ArrayList<Trait> e = first.vals;
        int a = 0, b = 0, c = 0, d= 0;
        if( e.get(prim).getValue() > e.get(sec).getValue() ) {
             a = e.get(prim).getValue();
             b = e.get(sec).getValue();
        }
        else {
            a = e.get(sec).getValue();
            b = e.get(prim).getValue();
        }
        ArrayList<Trait> r = second.vals;
        if( r.get(prim).getValue() > r.get(sec).getValue() ) {
            c = r.get(prim).getValue();
            d = r.get(sec).getValue();
        }
        else {
            c = r.get(sec).getValue();
            d = r.get(prim).getValue();
        }

    if(Math.abs(c-a) < 30) return 1;

    else return 0;
    }
}

