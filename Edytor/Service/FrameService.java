package Edytor.Service;

import java.awt.*;
import javax.swing.*;

public class FrameService {

    private JFrame frame;
    private JTextArea text;
    public FrameService(JFrame frame, JTextArea text){
        this.frame = frame ;
        this.text = text;
    };

    public void configureFrameUnsaved(){
        frame.setTitle("Prosty edytor - bez tytułu");
        JScrollPane scroll = new JScrollPane(text);
        scroll.setPreferredSize(new Dimension(600, 600));
        frame.getContentPane().add(scroll);
    }

    public void packAndFinishFrame(){
        frame.setDefaultCloseOperation(frame.DISPOSE_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

}
