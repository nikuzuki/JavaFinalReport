public class TestIndex{
  public static void main(String[] args){
    String str = "nikuzuki @自動詞 強い @他動詞 イケメン";
    String niku = "";
    int index = str.indexOf("@");

     System.out.println( index );
    // System.out.println( str.substring(0, str.indexOf("@") - 1));

    niku = str + ".";
    // System.out.println(niku);

    String str2 = str.substring(index + 1, index + 4);
    System.out.println(str2);


  }
}
