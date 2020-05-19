import java.util.Scanner;

public class TestArrayMedian {

    public static void main(String[] args) {
        ArrayMedian arrayMedian = new ArrayMedian(10);

        Scanner scanner = new Scanner(System.in);
        String input;
        int number = 0;

        while (true) {

            input = scanner.nextLine();
            if (input.equals("exit")) break;
            try {
                number = Integer.parseInt(input);
            } catch (NumberFormatException e) {
                System.out.println("Wrong argument");
                continue;
            }
            arrayMedian.push(number);
            int median = (int) arrayMedian.getMedian();
            System.out.println("Median: " + median);
        }
        scanner.close();
    }
}
