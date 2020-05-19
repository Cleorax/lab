
public class RopeLength {
    public static void main(String[] args) {
        int[] ropes = {4, 3, 2, 6};
        joinRopes(ropes);
    }

    public static void joinRopes(int[] ropes) {
        int sumCosts = 0;

        System.out.println("Количество веревок: " + ropes.length);
        for (int num: ropes) {
            System.out.print(num + " ");
        }
        System.out.println();
        System.out.println("----------");
        CustomMinPQueue mpq = new CustomMinPQueue(ropes.length);

        int cost;
        for (int num: ropes) {
            mpq.insert(num);
        }
        while ((cost = mpq.sumLeastElements()) != 0) {
            sumCosts += cost;
        }
        System.out.println("Минимальная стоимость: " + sumCosts);
    }
}
