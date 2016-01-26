class Verb{
  private String midashi = "";     // 見出し語
  private String jidoushi = "";    // 自動詞
  private String tadoushi = "";    // 他動詞

  public void set_midashi(String midashi){
    this.midashi = midashi;
    System.out.println("SET見出し : " + this.midashi);
  }

  public void set_jidoushi(String jidoushi){
    this.jidoushi = this.jidoushi + jidoushi;
    System.out.println("SET自動詞 : " + this.jidoushi);
  }

  public void set_tadoushi(String tadoushi){
    this.tadoushi = this.tadoushi + tadoushi;
    System.out.println("SET他動詞 : " + this.tadoushi);
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
