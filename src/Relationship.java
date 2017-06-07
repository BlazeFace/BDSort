import java.util.ArrayList;

/**
 * Compares Values of 2 Individuals
 */
public class Relationship {
    private Kink first;
    private Kink second;
    private int[] compatibility = new int[13];
    private static String[] connectedTraits;
    public Relationship(Kink a,Kink b){
        first = a;
        second = b;
        connectedTraits = generateMatches();
        computeCompatibility();
    }
    public String[] generateMatches(){
     String[] temp = new String[13];
     temp[0] = "0,0";
     temp[1] = "1,3";
     temp[2] = "4,5";
     temp[3] = "6,20";
     temp[4] = "7,23";
     temp[5] = "9,18";
     temp[6] = "10,19";
     temp[7] = "11,11";
     temp[8] = "12,13";
     temp[9] = "14,15";
     temp[10] = "16,17";
     temp[11] = "21,21";
     temp[12] = "22,22";
     return temp;
    }

    public String toString(){
        String t = "";
        for(int k: compatibility){
            t += k + " ";
        }
        return t;
    }
    private static int getVal(Trait e){
        return e.getValue();
    }

    private int computeDistance(int prim, int sec) {
        ArrayList<Trait> e = first.vals;
        int a = 0, b = 0, c = 0, d = 0;
        if (e.get(prim).getValue() > e.get(sec).getValue()) {
            a = getVal(e.get(prim));
            b = getVal(e.get(sec));
        } else {
            a = getVal(e.get(sec));
            b = getVal(e.get(prim));
        }
        ArrayList<Trait> r = second.vals;
        if (r.get(prim).getValue() > r.get(sec).getValue()) {
            c = r.get(prim).getValue();
            d = r.get(sec).getValue();
        } else {
            c = r.get(sec).getValue();
            d = r.get(prim).getValue();
        }


        return Math.abs(c - a);
    }
    private void computeCompatibility(){
        for(int i = 0; i < connectedTraits.length; i++){
            compatibility[i] = computeDistance(firstN(connectedTraits[i]),secondN(connectedTraits[i]));
        }
    }
    private int firstN(String a){
        int h = Integer.parseInt(a.substring(0, a.indexOf(",")));
        System.out.print("|" + h + "| ");
        return  h;
    }
    private int secondN(String a){
        return Integer.parseInt(a.substring(a.indexOf(",")+1));
    }
}

