/**
 * Created by Nate Bensing on 5/23/2017.
 */
public class Main {
    public static void main(String[] args){
        Kink k = new Kink("Entry");
       // k.display();
        Kink f = new Kink("Entry2");
       // f.display();
        Relationship perf = new Relationship(k,f);
        System.out.print(perf);
    }
}
