package InputHandling;

import javax.swing.JButton;

public class HandleInput {
    
    //New Function to add ActionListener to buttons that are currently set up



private void addButtonListener(){

    //use nested loop to iterate over each button in chessboard
    for(int y = 0; y < 8; y++){
        for(int x = 0; x < 8; x++){

            //obtains the Jbutton at current position (x,y)
            //add ActionListener to each button
            JButton button = squares[x][y];
            button.addActionListener(new ActionListener(){
                @Override
                public void ActionPerformed(ActionEvent e){
                    
                    //pass coordinates in call to this method
                    handleButtonPress(x, y);
                }
            });
        }
    }
}

//New Function to handle button press events

private void handleButtonPress(int x, int y){

    //add logic for handling button press event
}
}
