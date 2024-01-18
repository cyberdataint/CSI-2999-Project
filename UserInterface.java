import java.awt.*;

import javax.swing.*;

public class UserInterface extends JPanel {
    
    UserInterface() {

        //
    }


    public void paint(Graphics g) {

        Graphics2D g2d = (Graphics2D) g;

        g2d.setColor(Color.BLUE);
        
        g2d.fillRect(100, 100, 100, 100);
    
    }

}
