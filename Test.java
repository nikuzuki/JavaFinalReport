public class Test{
  public static void main(String[] args){
    VerbDB test = new VerbDB();

    String output[];
    System.out.println("args " + args[0]);
    output = test.search(args[0]);
    System.out.println("自動詞 : " + output[0]);
    System.out.println("他動詞 : " + output[1]);

    System.out.println(test.search_tadoushi(args[0]));
    System.out.println(test.search_jidoushi(args[0]));

  }
}
