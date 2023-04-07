package Edytor;

import java.awt.Color;
import java.awt.FileDialog;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import Edytor.Icons.IconDot;
import Edytor.Icons.IconLine;
import Edytor.Service.EditorFacade;


public class Editor{

    EditorFacade editorFacade = new EditorFacade();

    public Editor() {

        editorFacade.configureFrame();

        editorFacade.createAndPackJMenuBar();

        editorFacade.packAndFinishFrame();
    }




}

  

	       


