package greedy;

public class integerToRoma {
    public String intToRoman(int num) {
      int values[]={1000,900,500,400,100,90,50,40,10,9,5,4,1};
      String resps[]={"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};
      String res="";
      for (int i=0;i<13;i++){
        while (values[i]<=num){
          num-=values[i];
          res+=resps[i];
        }
      }
      return res;

    }

  public static void main(String[] args) {
    return ;
  }
  }

