package TC500;

public class FactoVisors {

    public int getNum(int[] divisors, int[] factors) {
        long hcf = factors[0];
        long lcm = 1;
        for (int divisor : divisors) {
            long lcm1 = getLcm(lcm, divisor);
            if (lcm1 < lcm) return 0;
            lcm = lcm1;
        }
        for (int multiple : factors) {
            hcf = getHcf(hcf, multiple);
        }
        long num = hcf / lcm;
        if (num == 0 || hcf % lcm != 0) return 0;
        if (num == 1) return 1;
        if (isPrime(num)) return 2;
        int sum = 1;
        for (int i = 2; i <= num; i++) {
            int temp = 1;
            if (num == 1) break;
            while (num % i == 0) {
                num = num / i;
                temp++;
            }
            sum *= temp;
        }
        return sum;
    }

    private boolean isPrime(long num) {
        for (int i = 2; i < Math.sqrt(num) + 2; i++) {
            if (num % i == 0) return false;
        }
        return true;
    }

    private long getHcf(long a, long b) {
        if (b == 0) return a;
        if (a == 0) return b;
        if (a < b) return getHcf(a, b % a);
        return getHcf(b, a % b);
    }

    private long getLcm(long a, long b) {
        return a * b / getHcf(a, b);
    }
}
