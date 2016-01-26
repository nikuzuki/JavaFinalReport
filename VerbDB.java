import java.io.*;

class VerbDB{
  private Verb[] verbs = new Verb[1035];  // 動詞辞書

  public VerbDB(){  // コンストラクタ
    String filename = "doushi.txt";

    try{
      BufferedReader reader = new BufferedReader(new FileReader(filename));
      String line;
      int index1, index2;  // '@'の位置
      int i = 0;
      String str1, str2;  // 自動詞他動詞判定用

      while((line = reader.readLine()) != null){
        str1 = "";
        str2 = "";
        verbs[i] = new Verb();

        // @の前まで切り取り見出しへ
        index1 = line.indexOf("@");
        verbs[i].set_midashi(line.substring(0, index1 - 1));

        // 自動詞か他動詞か調べる
        index2 = line.indexOf("@", index1 + 1);

        str1 = line.substring(index1 + 1, index1 + 4);
        // System.out.println("str1: " + str1);
        if (index2 == -1){
          str2 = "empty";
        } else {
          str2 = line.substring(index2 + 1, index2 + 4);
        }
        // System.out.println("str2: " + str2);

        if(str1.indexOf("自動") == 0){  // 先頭に自動詞が来ている場合
          if(str2.indexOf("他動") == 0){  // 他動詞がある場合
            // System.out.println("jidou -> tadou");
            verbs[i].set_jidoushi(line.substring(index1 + 1, index2 - 1));
            verbs[i].set_tadoushi(line.substring(index2 + 1, line.length()));
          } else {
            // System.out.println("way1");
            verbs[i].set_jidoushi(line.substring(index1 + 1));
            verbs[i].set_tadoushi("undefined");
          }
        } else {              // 先頭に他動詞が来ている場合
          if(str2.indexOf("自動") == 0){  // 自動詞がある場合
            // System.out.println("tadou -> jidou");
            verbs[i].set_tadoushi(line.substring(index1 + 1, index2 - 1));
            verbs[i].set_jidoushi(line.substring(index2 + 1, line.length()));
          } else {
            // System.out.println("way2");
            verbs[i].set_tadoushi(line.substring(index1 + 1));
            verbs[i].set_jidoushi("undefined");
          }
        }
        System.out.println("--------------\n");
        // verbs[i].set_translation(line.substring(index + 1, line.length()));

        i++;
      }
      reader.close();
    } catch (FileNotFoundException e){
      System.out.println(filename + " is not found.");
    } catch (IOException e){
      System.out.println(e);
    }

  }
  
  // ---見出しの検索---
  public String[] search(String midashi){

    String str[] = new String[2];
    for(String x: str){
      x = "";
    }
    for(Verb data: verbs){  // 拡張for文
      if((data.get_midashi().indexOf(midashi)) != -1){
        str[0] = data.get_jidoushi();
        str[1] = data.get_tadoushi();

        if(str[0] != "undefined"){
          // System.out.println(str[0]);
        }
        if(str[1] != "undefined"){
          // System.out.println(str[1]);
        }
        break;
      }
    }
    if(str[0].length() == 0 && str[1].length() == 0)
       System.out.println(midashi + " is not found.");

    return str;


  }

  // ---見出しから自動詞検索---
  public String search_jidoushi(String midashi){
    String str = "";
    for(Verb data: verbs){
      if((data.get_midashi().indexOf(midashi)) != -1){
        str = data.get_jidoushi();
        break;
      }
    }
    return str;
  }
  */

  // ---見出しから他動詞検索---
  public String search_tadoushi(String midashi){
    String str = "";
    for(Verb data: verbs){
      if((data.get_midashi().indexOf(midashi)) != -1){
        str = data.get_tadoushi();
        break;
      }
    }
    return str;
  }
}
