package package01;

import java.awt.event.*;

public class Game{

    ChoiceHandler cHandle = new ChoiceHandler();
    UI ui = new UI();
    VisibilityManage vm = new VisibilityManage(ui);

    public static void main(String[] args){
        new Game();
    }

    public Game(){
        ui.createUI(cHandle);
        vm.showTitleScreen();
    }

    public class ChoiceHandler implements ActionListener{
        public void actionPerformed(ActionEvent event){
            String yourChoice = event.getActionCommand();

            switch(yourChoice){
                case "1p": vm.showControlScreen(); break;
                case "2p": break;

                case "mouse": vm.showDificultyScreen(); break;
                case "keyboard": break;

                case "easy": break;
                case "hard": break;
            }
        }
    }

    
}