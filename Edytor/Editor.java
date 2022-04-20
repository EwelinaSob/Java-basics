package Edytor;

import java.awt.Color;
import java.awt.Dimension;
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
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.KeyStroke;

public class Editor implements ActionListener {

    JFrame frame;
    JTextArea text;

    String[] buttonFile = {"Open", "Save", "Save as...", "", "Exit"};
    String[] buttonEdit = {"Praca", "Szkoła", "Dom"};

    Icon icon = new IconLine(Color.red);
    Icon[] icons = {new IconDot(Color.blue), new IconDot(Color.yellow), new IconDot(Color.orange),
            new IconDot(Color.red), new IconDot(Color.white), new IconDot(Color.black), new IconDot(Color.green)};
    String[] colorsName = {"Blue", "Yellow", "Orange", "Red", "White", "Black", "Green"};
    Color[] colorObject = {Color.blue, Color.yellow, Color.orange, Color.red, Color.white, Color.black, Color.green};
    Font[] fontSize = {
            new Font("Dialog", Font.PLAIN, 8), new Font("Dialog", Font.PLAIN, 10),
            new Font("Dialog", Font.PLAIN, 12), new Font("Dialog", Font.PLAIN, 14),
            new Font("Dialog", Font.PLAIN, 16), new Font("Dialog", Font.PLAIN, 18),
            new Font("Dialog", Font.PLAIN, 20), new Font("Dialog", Font.PLAIN, 22),
            new Font("Dialog", Font.PLAIN, 24)};
    String[] fontSizeName = {"8 pts", "10 pts", "12 pts", "14 pts", "16 pts", "18 pts", "20 pts", "22 pts", "24 pts"};


    public Editor() {

        frame = new JFrame();
        frame.setTitle("Prosty edytor - bez tytułu");
        text = new JTextArea(400, 100);
        JScrollPane scroll = new JScrollPane(text);
        scroll.setPreferredSize(new Dimension(600, 600));
        frame.getContentPane().add(scroll);


        JMenu menu = new JMenu("File");

        for (String elt : buttonFile) {
            JMenuItem buttonFile = itemMnemno(elt);
            buttonFile.setBorder(BorderFactory.createRaisedBevelBorder());
            buttonFile.addActionListener(this);
            menu.add(buttonFile);
        }
        JMenu menuEdit = new JMenu("Edit");
        JMenu adresy = new JMenu("Adresy");
        adresy.setBorder(BorderFactory.createRaisedBevelBorder());

        for (String elt : buttonEdit) {
            JMenuItem buttonEdit = itemMnemno(elt);
            buttonEdit.setBorder(BorderFactory.createRaisedBevelBorder());
            buttonEdit.addActionListener(this);
            adresy.add(buttonEdit);
        }
        menuEdit.add(adresy);

        JMenu menuOptions = new JMenu("Options");
        JMenu fore = new JMenu("Foreground");
        fore.setBorder(BorderFactory.createRaisedBevelBorder());
        for (int i = 0; i < icons.length; i++) {
            JMenuItem itF = new JMenuItem(colorsName[i]);
            int finalI = i;
            itF.setIcon(icons[i]);
           // itF.setPreferredSize(new Dimension(90, 20));
            itF.setBorder(BorderFactory.createRaisedBevelBorder());
            itF.addActionListener(e -> text.setForeground(colorObject[finalI]));
            fore.add(itF);
        }
        menuOptions.add(fore);

        JMenu back = new JMenu("Background");
        back.setBorder(BorderFactory.createRaisedBevelBorder());
        for (int i = 0; i < icons.length; i++) {
            JMenuItem itB = new JMenuItem(colorsName[i]);
            int finalI = i;
            itB.setIcon(icons[i]);
            itB.setBorder(BorderFactory.createRaisedBevelBorder());
            itB.addActionListener(e -> text.setBackground(colorObject[finalI]));
            back.add(itB);
        }
        menuOptions.add(back);

        JMenu font = new JMenu("Font size");
        font.setBorder(BorderFactory.createRaisedBevelBorder());
        for (int i = 0; i < fontSizeName.length; i++) {
            JMenuItem it = new JMenuItem(fontSizeName[i]);
            it.setBorder(BorderFactory.createRaisedBevelBorder());
            int finalI = i;
            it.addActionListener(e -> text.setFont(fontSize[finalI]));
            font.add(it);
        }
        menuOptions.add(font);

        JMenuBar mb = new JMenuBar();
        mb.add(menu);
        mb.add(menuEdit);
        mb.add(menuOptions);

        frame.setJMenuBar(mb);
        frame.setDefaultCloseOperation(frame.DISPOSE_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    public void addAdress(String item) {
        String address;

        switch (item) {
            case "Praca" -> {
                address = "Schneider Electric\nKonstruktorska 12\n02-673 Warszawa\n";
                text.insert(address, text.getCaretPosition());
            }
            case "Szkoła" -> {
                address = "PJATK\nKoszykowa 86\n02-008 Warszawa\n";
                text.insert(address, text.getCaretPosition());
            }
            case "Dom" -> {
                address = "Ewelina Sob\nObrońców Tobruku\n01-494 Warszawa\n";
                text.insert(address, text.getCaretPosition());
            }
        }
    }
    public void writeFile() {
        FileDialog fd = new FileDialog(frame, "Zapisz", FileDialog.SAVE);
        fd.setVisible(true);
        String catalog = fd.getDirectory();
        String file = fd.getFile();

        if (fd.getFile() != null) frame.setTitle("Prosty edytor  - " + catalog + file);
        else frame.setTitle("Prosty edytor - bez tytułu");

        try {
            PrintWriter pw = new PrintWriter(catalog + file);
            Scanner scan = new Scanner(text.getText());
            while (scan.hasNextLine())
                pw.println(scan.nextLine());
            pw.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void readFile() {
        FileDialog fd = new FileDialog(frame, "Otwórz", FileDialog.LOAD);
        fd.setVisible(true);

        String catalog = fd.getDirectory();
        String file = fd.getFile();

        if (fd.getFile() != null)
            frame.setTitle("Prosty edytor  - " + catalog + file);
        else
            frame.setTitle("Prosty edytor - bez tytułu");

        StringBuffer sb = new StringBuffer();
        Scanner scan = null;
        try {
            scan = new Scanner(new File(catalog + file));
        } catch (FileNotFoundException exc) {
            System.out.println("***");
            System.exit(1);
        }
        while (scan.hasNextLine()) {
            sb.append(scan.nextLine()).append('\n');
        }
        text.setText(sb.toString());
    }

    public void saveFile() {

        if (frame.getTitle().equals("Prosty edytor - bez tytułu")) {

            FileDialog fd = new FileDialog(frame, "Zapisz", FileDialog.SAVE);
            fd.setVisible(true);
            String catalog = fd.getDirectory();
            String file = fd.getFile();

            if (fd.getFile() != null)
                frame.setTitle("Prosty edytor - " + catalog + file);
            else
                frame.setTitle("Prosty edytor - bez tytułu");

            String[] lines = text.getText().split("\\n");
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(catalog + file))) {
                for (String line : lines)
                    writer.write(line + "\n");
            } catch (IOException i) {
                System.out.println("Cannot write file...");
            }
        } else {
            String title = frame.getTitle();
            String regex = "Prosty edytor - ";
            Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher(title);

            String sciezka = matcher.replaceFirst("");
            String[] lines = text.getText().split("\\n");
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(sciezka))) {
                for (String line : lines)
                    writer.write(line + "\n");
            } catch (IOException i) {
                System.out.println("Cannot write file...");
            }
        }
    }

    public JMenuItem itemMnemno(String t) {

        JMenuItem mi = new JMenuItem(t);

        switch (t) {
            case "Open":
                mi.setMnemonic('o');
                if (text.getInputMap((JComponent.WHEN_FOCUSED)) != null) {
                    mi.setAccelerator(KeyStroke.getKeyStroke("control O"));
                }
                break;
            case "Save":
                mi.setMnemonic('s');
                if (text.getInputMap((JComponent.WHEN_FOCUSED)) != null) {
                    mi.setAccelerator(KeyStroke.getKeyStroke("control S"));
                }
                break;
            case "Save as...":
                mi.setMnemonic('a');
                if (text.getInputMap((JComponent.WHEN_FOCUSED)) != null) {
                    mi.setAccelerator(KeyStroke.getKeyStroke("control A"));
                }
                break;
            case "":
                mi.setIcon(icon);
                break;

            case "Exit":
                mi.setMnemonic('x');
                if (text.getInputMap((JComponent.WHEN_FOCUSED)) != null) {
                    mi.setAccelerator(KeyStroke.getKeyStroke("control X"));
                }
                break;
            case "Szkoła":
                mi.setMnemonic('s');
                if (text.getInputMap((JComponent.WHEN_FOCUSED)) != null) {
                    mi.setAccelerator(KeyStroke.getKeyStroke("control shift S"));
                }
                break;
            case "Dom":
                mi.setMnemonic('d');
                if (text.getInputMap((JComponent.WHEN_FOCUSED)) != null) {
                    mi.setAccelerator(KeyStroke.getKeyStroke("control shift D"));
                }
                break;
            case "Praca":
                mi.setMnemonic('p');
                if (text.getInputMap((JComponent.WHEN_FOCUSED)) != null) {
                    mi.setAccelerator(KeyStroke.getKeyStroke("control shift P"));
                }
                break;
        }
        return mi;
    }

    public void actionPerformed(ActionEvent e) {
        String name = e.getActionCommand();
        switch (name) {
            case "Open":
                readFile();
                break;
            case "Save":
                saveFile();
                break;
            case "Save as...":
                writeFile();
                break;
            case "":
                break;
            case "Exit":
                frame.dispose();
                System.exit(0);
            case "Praca":
                addAdress("Praca");
                break;
            case "Dom":
                addAdress("Dom");
                break;
            case "Szkoła":
                addAdress("Szkoła");
                break;
        }
    }


}

  

	       


