/*
  2.(2)
*/

import java.io.*;
import java.util.*;

class VerbDB2{
  private ArrayList<Verb> verbs = new ArrayList<Verb>();  // 動詞辞書

  public VerbDB2(){  // コンストラクタ
    String filename = "doushi.txt";

    try{
      BufferedReader reader = new BufferedReader(new FileReader(filename));
      String line;
      int index1, index2;  // '@'の位置
      int i = 0;           // 文字の位置
      int count = 0;       // verbsの添字
      String str;          // 自動詞他動詞判定用
      String tmp = "";     // 一時的な文字列格納
      char tmpCharAt;

      while((line = reader.readLine()) != null){  // ファイルの終わりまで繰り返す
        Verb tmpVerb = new Verb();  // インスタンスを作成
        i = line.indexOf("@");      // "@"の位置を探す
        // System.out.println("index  " + i);
        tmpVerb.set_midashi(line.substring(0, i - 1)); // @前の見出しを渡す
        // System.out.println("length  " + line.length());

        i++;  // @の後の文字を指すためにインクリメント
        str = line.substring(i, i + 3);
        // System.out.println("str " + str);
        i = i + 4;  // @◯動詞の後の文字を指す
        // ----- ここから自動詞/他動詞判定 -----
        while(i < line.length()){ // 末尾まで繰り返す

          tmpCharAt = line.charAt(i); // iが指している文字を格納
          // System.out.println(tmpCharAt);
          if(tmpCharAt != '@'){     // '@'以外を指してたら
            tmp = tmp + tmpCharAt;  // tmpの後ろに追加
          } else {                  // '@'を指していたら
            // ----- setter -----
            if(str.charAt(0) == '自'){     // strが自動詞なら
              tmpVerb.set_jidoushi(tmp);
              tmp = "";
            } else {
              tmpVerb.set_tadoushi(tmp);
              tmp = "";
            }
            // ----- setter end -----
            i++;                    // 次の文字を指す
            str = line.substring(i, i + 3);
            i = i + 3;

          }
          i++;  // 次の文字へ
          verbs.add(tmpVerb);
        }
        if(tmp != ""){
          if(str.charAt(0) == '自'){
            tmpVerb.set_jidoushi(tmp);
            tmp = "";
          } else {
            tmpVerb.set_tadoushi(tmp);
            tmp = "";
          }
        }

        //System.out.println("tmp : " + tmp);

        // System.out.println("------------\n");
        count++;

      }
      reader.close();
    } catch (FileNotFoundException e){
      System.out.println(filename + " is not found.");
    } catch (IOException e){
      System.out.println(e);
    }

  }

  // ---見出しの検索---
  public String[] search(String midashi){ // 配列で返す

    String str[] = {"", ""};  //[0]自動詞 [1]他動詞
    Verb tmp;

    System.out.println("\n-------searching " + midashi + "-------\n");

    for(int i = 0; i < this.verbs.size(); i++){
      tmp = verbs.get(i);
      if(tmp.get_midashi().indexOf(midashi) == 0){
        System.out.println("match");
        str[0] = tmp.get_jidoushi();
        str[1] = tmp.get_tadoushi();

        break;
      }
    }

    return str;
  }

  // ---見出しから自動詞検索---
  public String search_jidoushi(String midashi){
    String str = "";
    Verb tmp;
    System.out.println("\n-------searching jidoushi [" + midashi + "]-------\n");

    for(int i = 0; i < this.verbs.size(); i++){
      tmp = verbs.get(i);
      if(tmp.get_midashi().indexOf(midashi) == 0){
        System.out.println("match");
        str = tmp.get_jidoushi();
        System.out.println("自動詞 :" + str);

        break;
      }
    }

    return str;
  }

  // ---見出しから他動詞検索---
  public String search_tadoushi(String midashi){
    String str = "";
    Verb tmp;
    System.out.println("\n-------searching tadoushi [" + midashi + "]-------\n");

    for(int i = 0; i < this.verbs.size(); i++){
      tmp = verbs.get(i);
      if(tmp.get_midashi().indexOf(midashi) == 0){
        System.out.println("match");
        str = tmp.get_tadoushi();
        System.out.println("他動詞 :" + str);

        break;
      }
    }
    return str;
  }

}
