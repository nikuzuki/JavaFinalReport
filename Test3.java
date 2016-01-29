/*
  2.(3)test
*/

class Test3{
  public static void main(String[] args){
    VerbDB3 test = new VerbDB3();

    String out[] = test.search(args[0]);

    for(int i = 0; i < out.length; i++){
      System.out.println(out[i]);
    }


    String jidoushi = test.search_jidoushi(args[0]);
    System.out.println(jidoushi);
    String tadoushi = test.search_tadoushi(args[0]);
    System.out.println(tadoushi);
    
   }
}
