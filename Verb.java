class Verb{
  private String midashi;     // 見出し語
  private String jidoushi;    // 自動詞
  private String tadoushi;    // 他動詞

  public void set_midashi(String midashi){
    this.midashi = midashi;
  }

  public void set_jidoushi(String jidoushi){
    this.jidoushi = jidoushi;
  }

  public void set_tadoushi(String tadoushi){
    this.tadoushi = tadoushi;
  }

  public String get_midashi(){
    return this.midashi;
  }

  public String get_tadoushi(){
    return this.tadoushi;
  }

  public String get_jidoushi(){
    return this.jidoushi;
  }
}
