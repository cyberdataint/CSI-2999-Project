package mechanics;

import visuals.border_panels.NorthPanel;
import visuals.user_interface.GameLog;

public class Messenger {
    
    public static void sendMessage(boolean isValid) {

        if (isValid) {

            // implement a getIsAttacking and a getIsTransforming
            String message = GameLog.formatMessage();
        
            GameLog.textArea.append(message);
            GameLog.textArea.setCaretPosition(GameLog.textArea.getDocument().getLength());

        }
        else {

            String message = "[" + NorthPanel.gameClock.getText() + "] Sorry! Your move was invalid! Try Again!\n";

            GameLog.textArea.append(message);
            GameLog.textArea.setCaretPosition(GameLog.textArea.getDocument().getLength());

        }

    }

    public static boolean getIsAttacking() {

        // checks to see if its a valid move and opposing square is an opposing color

        // implement

        return false;

    }

    public static boolean getIsTransforming() {

        // checks to see if its a valid move and its the opposing row of selected color

        // implement

        return false;

    }


}
