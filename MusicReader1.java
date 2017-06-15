public class MusicReader1 {
  public static void main(String[] args) {
    String song = "0 000 000 000 000 000 000 0023";
    int string_num = 0;
    for (int note = 0; note < song.length(); note++) {
      if (song.charAt(note) != '_' && Character.isDigit(song.charAt(note))) {
        System.out.print((6 - string_num) + " " + song.charAt(note) + "\n");
        string_num = 0;
      } else if (song.charAt(note) == ' ') {
        System.out.println();
      }
    }
  }
}
