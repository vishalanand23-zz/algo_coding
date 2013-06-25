package TC250;

public class ColorfulBricks{
   public int countLayouts(String bricks){
      char c = bricks.charAt(0);
      int num=1;
      char d = 'a';
      for(int i=1;i<bricks.length();i++){
          char a = bricks.charAt(i);
          if(a != c){
      	  	if(d == 'a') {
      	  		d = a;
      	  		num++;
      	  	}
      	  	else if(a != d) return 0;
      	  }
      }
      return num;
   }
}