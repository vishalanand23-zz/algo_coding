package TC500;

public class TheNumbersWithLuckyLastDigit {
    public int find(int n) {
        switch (n % 10) {
            case 0:
                if (n == 0 || n == 10) return -1;
                else return 5;
            case 1:
                if (n == 1) return -1;
                else return 2;
            case 2:
                if (n == 2) return -1;
                else return 3;
            case 3:
                if (n == 3 || n == 13) return -1;
                else return 5;
            case 4:
                return 1;
            case 5:
                if (n == 5) return -1;
                else return 3;
            case 6:
                if (n == 6) return -1;
                else return 4;
            case 7:
                return 1;
            case 8:
                return 2;
            case 9:
                if (n == 9) return -1;
                else return 4;
        }
        return -1;
    }
}
