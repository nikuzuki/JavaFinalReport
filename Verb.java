class Verb{
  private String midashi;     // 見出し語
  private String translation; // 見出し語に対する説明

  public void set_midashi(String midashi){
    this.midashi = midashi;
  }

  public void set_translation(String translation){
    this.translation = translation;
  }

  public String get_midashi(){
    return this.midashi;
  }

  public String get_translation(){
    return this.translation;
  }
}
