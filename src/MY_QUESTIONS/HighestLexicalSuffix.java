package MY_QUESTIONS;

public class HighestLexicalSuffix {

    public static void main(String[] args) {
        System.out.println(new HighestLexicalSuffix().findSuffix("zczazbzczazd"));
    }

    public String findSuffix(String input) {
        char[] charArray = input.toCharArray();
        char highest = highestChar(charArray);
        int tempIndex = -1;
        int comIndex = -1;
        boolean comparison = false;
        for (int i = 0; i < charArray.length; i++) {
            if (!(charArray[i] == highest) && tempIndex == -1) continue;
            if (charArray[i] == highest) {
                if (tempIndex == -1) tempIndex = i;
                else {
                    comparison = true;
                    comIndex = i;
                }
            } else {
                if (comparison) {
                    if (charArray[i] > charArray[i - comIndex + tempIndex]){
                        tempIndex = comIndex;
                        comparison = false;
                    }
                    else if(charArray[i] < charArray[i - comIndex + tempIndex]){
                        comparison = false;
                    }
                }
            }
        }
        return input.substring(tempIndex, input.length());
    }

    private char highestChar(char[] charArray) {
        char a = 'a';
        for (char c : charArray) {
            if (a < c) a = c;
        }
        return a;
    }
}