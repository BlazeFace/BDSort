import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 * Numerical Repersentation of test results
 */
public class Kink {
    public ArrayList<Trait> vals = new ArrayList<>();
    public static ArrayList<String> types = new ArrayList<>();
    public int threshold;
    public Kink(String filename) {
        try (BufferedReader filein = new BufferedReader(new FileReader(filename))) {
            String line = filein.readLine();
            while (line != null) {
                line = filein.readLine();
                int val = Integer.parseInt(line.substring(0, line.indexOf("%")));
                String trait = line.substring(line.indexOf("%") + 1);
                vals.add(new Trait(trait, val));
            }
            filein.close();
        } catch (Exception e) {
            System.out.print("No lines to read");
        }
        this.buildType(filename);
        Collections.sort(vals);
        Collections.sort(types);
        this.threshold = compAvg();
    }

    private int compAvg() {
        int sum = 0;
        for(Trait a: vals){
           sum += a.getValue();
        }
        return sum/vals.size();
    }

    public void display() {
        for (int i = 0; i < vals.size(); i++) {
            System.out.print(vals.get(i));
        }
        System.out.print(" Your Average Value is "+threshold);
    }
    public ArrayList returnCont(){
        return vals;
    }
    private void buildType(String filename) {

        try (BufferedReader filein = new BufferedReader(new FileReader(filename))) {
            String line = filein.readLine();
            while (line != null) {
                line = filein.readLine();
                line = line.substring(line.indexOf("%") + 1);
                types.add(line);
            }
            filein.close();
        } catch (Exception e) {
            System.out.print("");
        }
    }
}

