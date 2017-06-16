import java.util.ArrayList;

/**
 * Compares Values of 2 Individuals
 */
public class Relationship {
    // n == number of traits
    private int n = 14;
    private Kink first;
    private Kink second;
    private int[] compatibility = new int[n];
    private static String[] connectedTraits;
    private Trait[] finalResults = new Trait[n];
    public Relationship(Kink a,Kink b){
        first = a;
        second = b;
        connectedTraits = generateMatches();
        computeCompatibility();
        finalResults = finalComp();
        returnResults();
    }
    //These are the hard coded pairs used to compare traits, numbers are the position of the traits in alphabetic order
    public String[] generateMatches(){
     String[] temp = new String[n];
     temp[0] = "0,0";
     temp[1] = "1,3";
     temp[2] = "2,2";
     temp[3] = "4,5";
     temp[4] = "6,20";
     temp[5] = "7,23";
     temp[6] = "9,18";
     temp[7] = "10,19";
     temp[8] = "11,11";
     temp[9] = "12,13";
     temp[10] = "14,15";
     temp[11] = "16,17";
     temp[12] = "21,21";
     temp[13] = "22,22";
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

    private int computeDistance(int sec, int prim) {
        ArrayList<Trait> e = first.vals;
        int a, c;
        if (e.get(prim).getValue() > e.get(sec).getValue()) {
            a = getVal(e.get(prim));
        } else {
            a = getVal(e.get(sec));
        }
        ArrayList<Trait> r = second.vals;
        if (r.get(prim).getValue() > r.get(sec).getValue()) {
            c = r.get(prim).getValue();
        } else {
            c = r.get(sec).getValue();
        }
        return Math.abs(c - a);
    }
    private void computeCompatibility(){
        for(int i = 0; i < connectedTraits.length; i++){
            compatibility[i] = computeDistance(firstN(connectedTraits[i]),secondN(connectedTraits[i]));
            System.out.print(" " + compatibility[i] + " ");
        }
    }
    private int firstN(String a){
       return Integer.parseInt(a.substring(0, a.indexOf(",")));

    }
    private int secondN(String a){
        return Integer.parseInt(a.substring(a.indexOf(",")+1));
    }
    private Trait[] finalComp(){
        for(int i = 0; i < n; i++){
            finalResults[i] = new Trait(Kink.types.get(i), compatibility[i]);
        }
        return finalResults;
    }
    private void returnResults(){
        int n = finalResults.length;
        Trait temp;
        for(int i=0; i < n; i++){
            for(int j=1; j < (n-i); j++){
                if(finalResults[j-1].getValue() > finalResults[j].getValue()){
                    //swap elements
                    temp = finalResults[j-1];
                    finalResults[j-1] = finalResults[j];
                    finalResults[j] = temp;
                }

            }
        }
    System.out.print("Your Most Compatable Trait is" + finalResults[12]);
    }
}


