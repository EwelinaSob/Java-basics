package Edytor.Service;

import javax.swing.*;

public class EditorFacade {

    private JFrame frame = new JFrame();
    private JTextArea text = new JTextArea(400, 100);
    private FrameService frameService = new FrameService(frame, text);
    private MenuService menuCreationService = new MenuService(frame, text);


    public void configureFrame() {
        frameService.configureFrameUnsaved();
    }
    public void createAndPackJMenuBar() {
        JMenuBar menuBar = new JMenuBar();
        menuBar.add(createMenuFile());
        menuBar.add(createMenuEdit());
        menuBar.add(createMenuOptions());
        frame.setJMenuBar(menuBar);
    }
    public void packAndFinishFrame() {
        frameService.packAndFinishFrame();
    }

    public JMenu createMenuFile(){ return menuCreationService.createAndConfigureFileMenu();};
    public JMenu createMenuEdit(){
        return menuCreationService.createAndConfigureEditMenu();
    };
    public JMenu createMenuOptions(){
        return menuCreationService.createAndConfigureOptionsMenu();
    };



}
