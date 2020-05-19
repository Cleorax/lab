import java.util.Scanner;

public class Client {
    public static void main(String[] args) {
        Scanner scan = new Scanner("a a b c c b b d a e");
        scan.useDelimiter(" ");

        ComparableString[] cs = new ComparableString[10];
        for (int i = 0; i < cs.length && scan.hasNext(); i++) {
            cs[i] = new ComparableString(scan.next());
        }

        HashSort hs = new HashSort(1000);
        hs.sort(cs);
        System.out.println("Result:");
        for (ComparableString s: cs) {
            System.out.println(s);
        }
    }
}
