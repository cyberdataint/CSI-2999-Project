package Games.Chess.Mechanics;

import java.awt.Color;

import Games.Chess.Visuals.border_panels.NorthPanel;
import Games.Chess.Visuals.border_panels.SouthPanel;
import Games.Chess.Visuals.user_interface.GameLog;

public class Game {

    private static Color lightColor = new Color(220, 250, 220);
    private static Color lightShadowColor = new Color(140, 170, 140);

    public static boolean isWhiteTurn;
    
    public Game() {

        // pass

    }

    // only called at startup
    public static void startGame() {

        // starts game clock, highlights turnindicator, places chess pieces, sends game start message in game log, sets isWhite true
        NorthPanel.gameTimer.start();
    
        SouthPanel.whitePanelTop.setBackground(lightColor);
        SouthPanel.whitePanelBottom.setBackground(lightColor);
    
        // GameBoard.intializePieces();
    
        GameLog.textArea.append("[" + NorthPanel.gameClock.getText() + "] " + "Game Start!\n\n");

        isWhiteTurn = true;
    
    }
    
    // called by RestartGameButton
    public static void restartGame() {
    
        // to be called by RestartGameButton
        // restarts game clock, highlights and clears TI, replaces chess pieces, send new game start message in GL, sets isWhite true
        NorthPanel.gameSecondsElapsed = -1;
        NorthPanel.gameTimer.restart();
    
        SouthPanel.whitePanelTop.setBackground(lightColor);
        SouthPanel.whitePanelBottom.setBackground(lightColor);
        SouthPanel.blackPanelTop.setBackground(lightShadowColor);
        SouthPanel.blackPanelBottom.setBackground(lightShadowColor);
    
        // GameBoard.intializePieces();
    
        GameLog.textArea.append("\n\n[" + NorthPanel.gameClock.getText() + "] " + "New Game Start!\n\n\n");
        GameLog.textArea.setCaretPosition(GameLog.textArea.getDocument().getLength());;

        isWhiteTurn = true;
    
    }

    // only occurs when GameBoard updates
    public static void changeTurn() {

        // needs to disable selecting opposing turn's pieces

        if (isWhiteTurn) { // change to black's turn
            SouthPanel.whitePanelTop.setBackground(lightShadowColor);
            SouthPanel.whitePanelBottom.setBackground(lightShadowColor);

            SouthPanel.blackPanelTop.setBackground(lightColor);
            SouthPanel.blackPanelBottom.setBackground(lightColor);

            isWhiteTurn = false;
        }
        else { // change to white's turn
            SouthPanel.whitePanelTop.setBackground(lightColor);
            SouthPanel.whitePanelBottom.setBackground(lightColor);

            SouthPanel.blackPanelTop.setBackground(lightShadowColor);
            SouthPanel.blackPanelBottom.setBackground(lightShadowColor);

            isWhiteTurn = true;
        }

    }

    public static void endGame() {

        // implement procedure for when game is won
        
        // possibly have it linked to the king piece being taken
        // within the king class

    }

}
