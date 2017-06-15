public class TabReader3 {
  public static void print_note (int string, char fret) {
    System.out.print (string + " " + fret);
  }
  public static void main(String[] args) {
    String song = "0^_0^__0 5^_5^__5";
    int string_num = 0;
    for (int note = 0; note < song.length(); note++) {
      if (song.charAt(note) != '_' && Character.isDigit(song.charAt(note))) {
        print_note (6 - string_num, song.charAt(note));
        if (note != song.length() - 1 && song.charAt (note + 1) == '^') {
          System.out.print(" | ");
        } else {
          System.out.println();
        }
        string_num = 0;
      } else if (song.charAt(note) == ' ') {
        System.out.println();
      } else if (song.charAt(note) == '_') {
        string_num++;
      }
    }
  }
}
