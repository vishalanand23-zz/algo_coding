package SUBMATRI;

public class InputGenerator {

    public static void main(String[] args) {
        String s = "";
        for (int len = 0; len <= 100000; len++) {
            int rand = (int) Math.ceil(Math.random() * 2);
            if(rand == 1) s+='a';
            else if(rand ==2) s+='b';
            else s+='c';
        }
        System.out.println(s);
    }
}
