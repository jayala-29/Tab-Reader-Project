public class TabReader4 {
  public static void print_note (int string, char fret) {
    System.out.print (string + " " + fret);
  }
  public static int print_repeat (String song, int curr_note) {
    int note = curr_note;
    int string_num = 0;
    while (song.charAt(note) != '*') {
      note++;
    }
    int to_repeat = Character.getNumericValue(song.charAt(note+1));
    note = curr_note;
    for (int i = 0; i < to_repeat; i++) {
      while (song.charAt(note) != '*') {
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
        } else if (song.charAt(note) == '/') {
          print_repeat (song, note + 1);
        }
        note++;
      }
      if (i != to_repeat - 1) {
        note = curr_note;
      }
    }
    return note + 3;
  }
  public static void main(String[] args) {
    String song = "0 /000 *2/";
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
      } else if (song.charAt(note) == '/') {
        int offset = print_repeat (song, note + 1);
        if (offset >= song.length() - 1) {
          break;
        }
      }
    }
  }
}
