import java.io.*;

public class ReadText{
  public static void main(String[] args){
    /*
    if(args.length != 1){
      System.out.println("java ReadText <FileName>");
      System.exit(0);
    }
    */
    // String filename = args[0];
    
    String filename = "doushi.txt";

    try{
      BufferedReader reader = new BufferedReader(new FileReader(filename));
      String line;
      while((line = reader.readLine()) != null){
        System.out.println(line);
      }
      reader.close();
    } catch (FileNotFoundException e){
      System.out.println(filename + " is not found.");
    } catch (IOException e){
      System.out.println(e);
    }
  }
}
