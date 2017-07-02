public class TabReader6 {
  public static void print_note (int string, char fret) {
    System.out.print (string + " " + fret);
  }
  public static int print_repeat (String song, int curr_note) {
    int note = curr_note;
    int string_num = 0;
    while (song.charAt(note) != '*') {
      note++;
    }
    int to_repeat = Character.getNumericValue (song.charAt(note+1));
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
          int offset = print_repeat (song, note + 1);
          if (offset >= song.length()) {
            break;
          }
          note = offset;
          continue;
        }
        note++;
      }
      if (i != to_repeat - 1) {
        note = curr_note;
      }
    }
    return note + 3;
  }
  public static boolean check_operator (char op) {
    if (op == '^' || op == 'v' || op == '>') {
      return true;
    }
    return false;
  }
  public static void main (String[] args) {
    String song = "1.2__1.3";
    int string_num = 0;
    for (int note = 0; note < song.length(); note++) {
      if (note < song.length() - 2) {
        if (song.charAt(note + 1) == '.') {
          if (note > 2) {
            if (Character.isDigit(song.charAt(note)))
              System.out.println();
          }
          System.out.print ((6 - string_num) + " " + song.charAt(note) + song.charAt(note+2));
          note += 2;
          string_num = 0;
          continue;
        } 
      }
      if (song.charAt(note) != '_' && Character.isDigit(song.charAt(note))) {
        print_note (6 - string_num, song.charAt(note));
        if (note != song.length() - 1 && check_operator(song.charAt (note + 1))) {
          System.out.print(" " + song.charAt (note + 1) + " ");
        } else {
          System.out.println();
        }
        string_num = 0;
      } else if (song.charAt(note) == ' ') {
        System.out.println("\n");
      } else if (song.charAt(note) == '_') {
        string_num++;
      } else if (song.charAt(note) == '/') {
        int offset = print_repeat (song, note + 1);
        if (offset >= song.length()) {
          break;
        }
        note = offset;
        continue;
      }
    }
  }
}
