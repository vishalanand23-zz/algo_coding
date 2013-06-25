package TC250;


public class PlatypusPaternity {

    public int maxFamily(String[] femaleCompatibility, String[] maleCompatibility, String[] siblingGroups) {
        int[] siblingSizes = new int[siblingGroups.length];
        for (int i = 0; i < siblingGroups.length; i++) {
            int temp = 0;
            for (int j = 0; j < siblingGroups[i].length(); j++) {
                if (siblingGroups[i].charAt(j) == 'Y') temp++;
            }
            siblingSizes[i] = temp;
        }
        boolean[] isUsed = new boolean[siblingSizes.length];
        for (int i = 0; i < siblingSizes.length; i++) {
            int index = -1;
            int size = 0;
            for (int j = 0; j < siblingSizes.length; j++) {
                if (siblingSizes[j] > size && !isUsed[j]) {
                    size = siblingSizes[j];
                    index = j;
                }
            }
            isUsed[index] = true;
            if (isPresent(femaleCompatibility, siblingGroups, index) && isPresent(maleCompatibility, siblingGroups, index)) {
                return siblingSizes[index] + 2;
            }
        }
        return 0;
    }

    private boolean isPresent(String[] parentCompatibility, String[] siblingGroups, int index) {
        for (int j = 0; j < parentCompatibility.length; j++) {
            boolean current = true;
            for (int i = 0; i < siblingGroups[index].length(); i++) {
                char c = siblingGroups[index].charAt(i);
                if (c == 'N') continue;
                if (parentCompatibility[j].charAt(i) == 'N') {
                    current = false;
                    break;
                }
            }
            if (current) return true;
        }
        return false;
    }
}
