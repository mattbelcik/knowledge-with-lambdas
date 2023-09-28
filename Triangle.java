import java.util.ArrayList;
import java.util.List;
import java.util.OptionalDouble;

public class Triangle extends Polygon {

    private List<Integer> sideLengths;

    public Triangle(int[] a) {

        sideLengths = new ArrayList<>();

        for (int p : a) {

            sideLengths.add(p);
        }

    }

    public double average() {

        return sideLengths.stream()
                .mapToInt(i -> i)
                .average().getAsDouble();
    }

    public int numSides = 3;

    public int getNumSides() {
        return numSides;
    }

    public void display() {
        System.out.println(sideLengths);

    }

    public void add(int c) {
        sideLengths.add(c);
    }

}
