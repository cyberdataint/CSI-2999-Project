package mechanics;

import java.awt.Color;

import visuals.border_panels.*;
import visuals.user_interface.*;

public class Game {

    private static Color lightColor = new Color(220, 250, 220);
    private static Color lightShadowColor = new Color(140, 170, 140);

    public static boolean isWhite;
    
    public Game() {

        // pass

    }

    public static void startGame() {

        // starts game clock, highlights turnindicator, places chess pieces, sends game start message in game log, sets isWhite true
        NorthPanel.gameTimer.start();
    
        SouthPanel.whitePanelTop.setBackground(lightColor);
        SouthPanel.whitePanelBottom.setBackground(lightColor);
    
        // Board.intializePieces();
    
        GameLog.textArea.append("[" + NorthPanel.gameClock.getText() + "] " + "Game Start!\n\n");

        isWhite = true;
    
    }
    
    public static void restartGame() {
    
        // to be called by RestartGameButton
        // restarts game clock, highlights and clears TI, replaces chess pieces, send new game start message in GL, sets isWhite true
        NorthPanel.gameSecondsElapsed = -1;
        NorthPanel.gameTimer.restart();
    
        SouthPanel.whitePanelTop.setBackground(lightColor);
        SouthPanel.whitePanelBottom.setBackground(lightColor);
        SouthPanel.blackPanelTop.setBackground(lightShadowColor);
        SouthPanel.blackPanelBottom.setBackground(lightShadowColor);
    
        // Board.intializePieces();
    
        GameLog.textArea.append("\n\n[" + NorthPanel.gameClock.getText() + "] " + "New Game Start!\n\n\n");
        GameLog.textArea.setCaretPosition(GameLog.textArea.getDocument().getLength());;

        isWhite = true;
    
    }

    public static void changeTurn() {

        if (isWhite) { // change to black's turn
            SouthPanel.whitePanelTop.setBackground(lightShadowColor);
            SouthPanel.whitePanelBottom.setBackground(lightShadowColor);

            SouthPanel.blackPanelTop.setBackground(lightColor);
            SouthPanel.blackPanelBottom.setBackground(lightColor);

            isWhite = false;
        }
        else { // change to white's turn
            SouthPanel.whitePanelTop.setBackground(lightColor);
            SouthPanel.whitePanelBottom.setBackground(lightColor);

            SouthPanel.blackPanelTop.setBackground(lightShadowColor);
            SouthPanel.blackPanelBottom.setBackground(lightShadowColor);

            isWhite = true;
        }

    }

}
