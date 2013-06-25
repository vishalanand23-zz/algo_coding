package TC500;

/**
 * Created with IntelliJ IDEA.
 * User: vishal
 * Date: 22/10/12
 * Time: 12:15 AM
 * To change this template use File | Settings | File Templates.
 */
public class FoxMakingDiceEasy {

    public static void main(String[] args) {
        System.out.println(new FoxMakingDiceEasy().theCount(50, 1));
    }

    public int theCount(int N, int K) {
        int sum = 0;
        if (K < 7) K = 7;
        while (true) {
            int numOfCombi = findCombi(N, K);
            int number = 2 * combination(numOfCombi, 3);
            if (number == 0) break;
            sum += number;
            K++;
        }
        return sum;
    }

    private int findCombi(int n, int k) {
        if (k > n) {
            if (k > n + n - 5) return 0;
            return ((k - 1) / 2) - (k - n) + 1;

        } else {
            return (k - 1) / 2;
        }
    }

    private int combination(int n, int k) {
        if (n < k) return 0;
        if (k > n / 2) k = n - k;
        int total = 1;
        for (int i = n - k + 1; i <= n; i++) total *= i;
        for (int i = k; i > 0; i--) total /= i;
        return total;
    }
}
