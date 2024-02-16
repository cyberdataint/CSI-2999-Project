package visuals;


import mechanics.Game;

public class Driver {

    public static void main(String[] args) {
            
        Screen screen = new Screen();
        screen.setVisible(true);

        Game.startGame();

    }
    
}