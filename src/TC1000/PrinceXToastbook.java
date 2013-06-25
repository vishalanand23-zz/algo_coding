package TC1000;

public class PrinceXToastbook {

    private static long[] facts = new long[51];

    public double eat(int[] prerequisite) {
        int[] numPrereq = new int[prerequisite.length];
        for (int i = 0; i < prerequisite.length; i++) {
            int count = 1;
            int index = i;
            while (count <= prerequisite.length) {
                index = prerequisite[index];
                if (index == -1) {
                    numPrereq[i] = count;
                    break;
                }
                count++;
            }
            if(count > prerequisite.length) numPrereq[i] = -1;
        }
        double sum = 0L;
        for (int i : numPrereq) {
            if (i == -1) continue;
            double fact = fact(i);
            double v = 1.0 / fact;
            sum += v;
        }
        return sum;
    }

    private long fact(int n) {
        if (n == 1) {
            facts[1] = 1;
            return 1;
        }
        if (facts[n] != 0) return facts[n];
        return n * fact(n - 1);
    }
}
