import java.io.*;
import java.util.*;

class VerbDB2{
  ArrayList<Verb> verbs = new ArrayList<Verb>();  // 動詞辞書

  public VerbDB2(){  // コンストラクタ
    String filename = "doushi.txt";

    try{
      BufferedReader reader = new BufferedReader(new FileReader(filename));
      String line;
      int index;  // '@'の位置

      while((line = reader.readLine()) != null){
        // @の前まで切り取り見出しへ
        Verb tmp = new Verb();
        index = line.indexOf("@");
        tmp.set_midashi(line.substring(0, index - 1));
        tmp.set_translation(line.substring(index + 1, line.length()));
        verbs.add(tmp); // verbsに追加
      }
      reader.close();
    } catch (FileNotFoundException e){
      System.out.println(filename + " is not found.");
    } catch (IOException e){
      System.out.println(e);
    }

  }

  public String search(String midashi){
    String str = "";
    Verb tmp;

    for(int i = 0; i < verbs.size(); i++){  // upgrade
      tmp = verbs.get(i);
      if(tmp.get_midashi().indexOf(midashi) != -1){
        str = tmp.get_translation();
      }
    }

    if(str.length() == 0)
      str = midashi + " is not Found.";

    return str;

  }
}
