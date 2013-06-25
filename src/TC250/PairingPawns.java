package TC250;

public class PairingPawns {
    public int savedPawnCount(int[] start) {
        int sum = 0;
        for (int i = start.length - 1; i >= 0; i--) {
            sum = (sum+start[i])/2;
        }
        return sum;
    }
}
