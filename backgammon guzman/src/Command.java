/* Name: Guzman Sanchez
 * Class: COP3252
 * Instructor: Dr. Katie Brodhead
 * Title: BoardPanel.java
 * Description: contains a user entered command
 * */
public class Command {
    

    private String input;
    private boolean valid, move, quit;
    private Play play;

    Command() {
        input = "";
        valid = true;
        move = false;
        quit = false;
    }

    Command(String input, Plays possiblePlays) {
        // regex examples: "[a-f]", "[a-z]|a[a-g]", "[a-z]|a[a-z]|b[a-n]"
        int numberOfFirstLetters = (possiblePlays.number()-1)/26;
        char finalLetterLimit = (char) ((possiblePlays.number()-1)%26 + (int) 'a');
        String regex = "";
        char firstChar = 'a';
        for (int i=0; i<numberOfFirstLetters; i++) {
            regex = regex + "[a-z]|" + firstChar;
            firstChar++;
        }
        regex = regex + "[a-" + finalLetterLimit + "]";
        this.input = input;
        String text = input.toLowerCase().trim();
        if (text.equals("quit")) {
            valid = true;
            move = false;
            quit = true;
        } else if (text.matches(regex)) {
            int option = 0;
            if (text.length()==1) {
                option = (int) text.charAt(0) - (int) 'a';
            } else if (text.length()==2) {
                option = ((int) text.charAt(0) - (int) 'a' + 1) * 26 + (int) text.charAt(1) - (int) 'a';
            }
            play = possiblePlays.get(option);
            valid = true;
            move = true;
        }
    else {
            valid = false;
        }
    }

    public Play getPlay() {
        return play;
    }

    public boolean isValid() {
        return valid;
    }

    public boolean isMove() {
        return move;
    }

    public boolean isQuit() {
        return quit;
    }

    public String toString() {
        return input;
    }
}
