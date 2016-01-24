import java.io.*;

class VerbDB{
  private Verb[] verbs = new Verb[1035];  // 動詞辞書

  public VerbDB(){  // コンストラクタ
    String filename = "doushi.txt";

    try{
      BufferedReader reader = new BufferedReader(new FileReader(filename));
      String line;
      int index;  // '@'の位置
      int i = 0;

      while((line = reader.readLine()) != null){
        // @の前まで切り取り見出しへ
        verbs[i] = new Verb();
        index = line.indexOf("@");
        verbs[i].set_midashi(line.substring(0, index - 1));
        verbs[i].set_translation(line.substring(index + 1, line.length()));
        // System.out.println(verbs[i].get_midashi());
        // System.out.println(verbs[i].get_translation());

        i++;
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
    for(Verb data: verbs){  // 拡張for文
      if( (data.get_midashi().indexOf(midashi)) != -1 ){
        str = data.get_translation();
        break;
      }
    }
    if(str.length() == 0)
      str = midashi + " is not Found.";

    return str;

  }
}
