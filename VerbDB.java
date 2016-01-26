import java.io.*;

class VerbDB{
  private Verb[] verbs = new Verb[1035];  // 動詞辞書

  public VerbDB(){  // コンストラクタ
    String filename = "doushi2.txt";

    try{
      BufferedReader reader = new BufferedReader(new FileReader(filename));
      String line;
      int index1, index2;  // '@'の位置
      int i = 0;           // 文字の位置
      int count = 0;       // verbsの添字
      String str;   // 自動詞他動詞判定用
      String tmp = "";     // 一時的な文字列格納
      char tmpCharAt;

      while((line = reader.readLine()) != null){  // ファイルの終わりまで繰り返す
        System.out.println("No." + count);
        System.out.println(line);
        verbs[count] = new Verb();  // インスタンスを作成
        i = line.indexOf("@");      // "@"の位置を探す
        System.out.println("index  " + i);
        verbs[count].set_midashi(line.substring(0, i)); // @前の見出しを渡す
        System.out.println("length  " + line.length());

        i++;  // @の後の文字を指すためにインクリメント
        str = line.substring(i, i + 3);
        System.out.println("str " + str);
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
              verbs[count].set_jidoushi(tmp);
              tmp = "";
            } else {
              verbs[count].set_tadoushi(tmp);
              tmp = "";
            }
            // ----- setter end -----
            i++;                    // 次の文字を指す
            str = line.substring(i, i + 3);
            i = i + 3;

          }
          i++;  // 次の文字へ
        }
        if(tmp != ""){
          if(str.charAt(0) == '自'){
            verbs[count].set_jidoushi(tmp);
            tmp = "";
          } else {
            verbs[count].set_tadoushi(tmp);
            tmp = "";
          }
        }

        System.out.println("tmp : " + tmp);

        System.out.println("------------\n");
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

    String str[] = {"undefined", "undefined"};  //[0]自動詞 [1]他動詞

    System.out.println("-------search-------\n");
    for(Verb data: verbs){  // 拡張for文
      if((data.get_midashi().indexOf(midashi)) != -1){
        System.out.println("str[0] " + data.get_jidoushi());
        System.out.println("str[1] " + data.get_tadoushi());
        str[0] = data.get_jidoushi();
        str[1] = data.get_tadoushi();

        if(str[0] != "undefined"){

          // System.out.println("way1 : " + str[0]);
        }
        if(str[1] != "undefined"){
          // System.out.println("way2 : " + str[1]);
        }
        break;
      }
    }
    //if(str[0].length() == 0 && str[1].length() == 0)
       // System.out.println(midashi + " is not found.");

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
