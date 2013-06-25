package TC250;

import java.util.Arrays;

public class TheJackpotDivTwo {
    public int[] find(int[] money, int jackpot) {
        Arrays.sort(money);
        int oldTemp = 0;
        int temp = 0;
        int i;
        for (i = 1; i < money.length; i++) {
            if (money[i] > money[i - 1]) {
                oldTemp = temp;
                temp += (money[i] - money[i - 1]) * i;
                if (temp > jackpot) {
                    break;
                }
            }
        }
        if (i == money.length) oldTemp = temp;
        temp = jackpot - oldTemp;
        int div = money[i - 1] + temp / i;
        int mod = temp % i;
        for (int k = 0; k < i; k++) {
            if (k < i - mod) money[k] = div;
            else money[k] = div + 1;
        }
        return money;
    }
}
