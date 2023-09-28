import java.util.ArrayList;
import java.util.List;

public class Quadrilateral extends Polygon {

    private List<Integer> sideLengths;

    public Quadrilateral(int[] a) {

        sideLengths = new ArrayList<>();

        List<Integer> sideLengths = new ArrayList<>();

        for (int p : a) {

            sideLengths.add(p);
        }

    }

    public void display() {
        System.out.println(sideLengths);

    }

    int numSides = 4;
}
