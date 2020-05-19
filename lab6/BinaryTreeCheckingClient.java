import lk2.Date_;
import lk5.BST;
import lk5.PeopleGenerator;

public class BinaryTreeCheckingClient {
    public static int MAX = 500;
    public static void main(String[] args) {
        isBst();
    }

    public static void isBst() {
        CustomBinaryTree<Date_, String> bt = new CustomBinaryTree<>();
        BST<Date_, String> bst = new BST<>();
        PeopleGenerator generator = new PeopleGenerator();

        // generate random data to tree
        for (int i = 0; i < MAX; i++) {
            Date_ date = new Date_();
            String person = generator.generatePerson();
            bt.put(date, person);
            bst.put(date, person);
        }

        System.out.println("class BST: " + isSorted(bst.keys()));
        System.out.println("class CustomBinaryTree: " + isSorted(bt.keys()));

        // add data to CustomBinaryTree to random place
        for (int i = 0; i < MAX; i++) {
            Date_ date = new Date_();
            String person = generator.generatePerson();
            bt.customPut(date, person);
        }
        System.out.println("class CustomBinaryTree after random put: " + isSorted(bt.keys()));
    }


    public static boolean isSorted(Iterable<Date_> a) {
        Date_ prevDate = null;
        for (Date_ currentDate: a) {
            if (prevDate == null) {
                prevDate = currentDate;
                continue;
            }
            if (prevDate.compareTo(currentDate) >= 0) {
                return false;
            }
            prevDate = currentDate;
        }
        return true;
    }
}
