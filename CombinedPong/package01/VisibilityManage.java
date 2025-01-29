package package01;

public class VisibilityManage {

    UI ui;

    public VisibilityManage(UI userInterface){
        ui = userInterface;
    }

    public void showTitleScreen(){
        // show title screen and hide options
        ui.titleNamePanel.setVisible(true);
        ui.startButtonPanel.setVisible(true);

        ui.controlButtonPanel.setVisible(false);
        ui.controlChoicePanel.setVisible(false);

        ui.difficultyChoicePanel.setVisible(false);
        ui.difficultyButtonPanel.setVisible(false);
    }

    public void showControlScreen(){
        ui.titleNamePanel.setVisible(false);
        ui.startButtonPanel.setVisible(false);

        ui.controlButtonPanel.setVisible(true);
        ui.controlChoicePanel.setVisible(true);

        ui.difficultyChoicePanel.setVisible(false);
        ui.difficultyButtonPanel.setVisible(false);
    }

    public void showDificultyScreen(){
        ui.titleNamePanel.setVisible(false);
        ui.startButtonPanel.setVisible(false);

        ui.controlButtonPanel.setVisible(false);
        ui.controlChoicePanel.setVisible(false);

        ui.difficultyChoicePanel.setVisible(true);
        ui.difficultyButtonPanel.setVisible(true);
    }
}
