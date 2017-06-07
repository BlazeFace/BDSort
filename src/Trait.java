/**
 * Individual Trait
 */
public class Trait implements Comparable<Trait> {
    private String trait;
    private  int value;
    public Trait(String name, int val){
        this.trait = name;
        this.value = val;
    }

    public String getTrait(){return trait;}
    public int getValue(){return value;}
    public String toString(){
       return this.getTrait() + " " + this.getValue()+"%";

    }
@Override
    public int compareTo(Trait a){
       return  this.getTrait().compareTo(a.getTrait());
}



}
