import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.OptionalDouble;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.IntStream;

public class Main {

    public static void main(String[] args) {

        int Tnumsides = 3;
        int Qnumsides = 4;

        String polygonSides = "Q,3,4,3,4";
        String pattern = "(\\w),(\\d),(\\d),(\\d),?(\\d)?";

        Pattern r = Pattern.compile(pattern);
        Matcher m = r.matcher(polygonSides);

        try {
            Scanner input = new Scanner(Paths.get("./polygons.txt"));
            while (input.hasNextLine()) {

                polygonSides = input.nextLine();
                m = r.matcher(polygonSides);

                if (m.find()) {

                    // String[] Tri = { m.group(2) + m.group(3) + m.group(4) };
                    // String[] TriL1 = { m.group(2) };
                    // String[] TriL2 = { m.group(3) };
                    // String[] TriL3 = { m.group(4) };

                    int TL1 = Integer.parseInt(m.group(2));
                    int TL2 = Integer.parseInt(m.group(3));
                    int TL3 = Integer.parseInt(m.group(4));

                    // int AddedLengths = TL1 + TL2 + TL3;
                    // String[] Quad = { m.group(2) + m.group(3) + m.group(4) + m.group(5) };
                    int Tnumbers[] = { TL1, TL2, TL3 };

                    if (m.group(1).equals("T")) {

                        Triangle T = new Triangle(Tnumbers);

                        T.calcAngleSum(Tnumsides);
                        // System.out.println();
                        // System.out.println("average " + T.average);
                        T.display();
                        // T.average();

                        System.out.printf("Average Triangle Length: %.2f%n",
                                IntStream.of(Tnumbers).average().getAsDouble());
                    }

                    if (m.group(1).equals("Q")) {
                        int QL1 = Integer.parseInt(m.group(2));
                        int QL2 = Integer.parseInt(m.group(3));
                        int QL3 = Integer.parseInt(m.group(4));
                        int QL4 = Integer.parseInt(m.group(5));
                        int Qnumbers[] = { QL1, QL2, QL3, QL4 };

                        Quadrilateral Q = new Quadrilateral(Qnumbers);
                        Q.calcAngleSum(Qnumsides);

                        // Q.display();

                        System.out.printf("Average Quadrilateral Length: %.2f%n",
                                IntStream.of(Qnumbers).average().getAsDouble());
                    }

                } else {
                    System.out.println("NO MATCH");
                }
            }

        } catch (

        IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

}