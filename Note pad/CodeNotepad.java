import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;

public class CodeNotepad extends JFrame implements ActionListener {

    // Components
    JTextArea textArea;
    JScrollPane scrollPane;
    JMenuBar menuBar;
    JMenu fileMenu, editMenu, viewMenu;
    JMenuItem newFile, openFile, saveFile, exitApp, cutText, copyText, pasteText, darkMode, lightMode;

    // Constructor
    public CodeNotepad() {
        setTitle("Code Notepad - by Mahesh");
        setSize(900, 600);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Text area
        textArea = new JTextArea();
        textArea.setFont(new Font("Consolas", Font.PLAIN, 16));
        textArea.setBackground(Color.white);
        textArea.setForeground(Color.black);
        textArea.setCaretColor(Color.black);

        scrollPane = new JScrollPane(textArea);
        add(scrollPane);

        // Menu bar
        menuBar = new JMenuBar();

        // File menu
        fileMenu = new JMenu("File");
        newFile = new JMenuItem("New");
        openFile = new JMenuItem("Open");
        saveFile = new JMenuItem("Save");
        exitApp = new JMenuItem("Exit");

        fileMenu.add(newFile);
        fileMenu.add(openFile);
        fileMenu.add(saveFile);
        fileMenu.addSeparator();
        fileMenu.add(exitApp);

        // Edit menu
        editMenu = new JMenu("Edit");
        cutText = new JMenuItem("Cut");
        copyText = new JMenuItem("Copy");
        pasteText = new JMenuItem("Paste");

        editMenu.add(cutText);
        editMenu.add(copyText);
        editMenu.add(pasteText);

        // View menu
        viewMenu = new JMenu("View");
        darkMode = new JMenuItem("Dark Mode");
        lightMode = new JMenuItem("Light Mode");

        viewMenu.add(darkMode);
        viewMenu.add(lightMode);

        // Add menus to bar
        menuBar.add(fileMenu);
        menuBar.add(editMenu);
        menuBar.add(viewMenu);

        setJMenuBar(menuBar);

        // Add Action Listeners
        newFile.addActionListener(this);
        openFile.addActionListener(this);
        saveFile.addActionListener(this);
        exitApp.addActionListener(this);
        cutText.addActionListener(this);
        copyText.addActionListener(this);
        pasteText.addActionListener(this);
        darkMode.addActionListener(this);
        lightMode.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == newFile) {
            textArea.setText("");
            setTitle("Untitled - Code Notepad");
        } 
        else if (e.getSource() == openFile) {
            JFileChooser fileChooser = new JFileChooser();
            int option = fileChooser.showOpenDialog(this);
            if (option == JFileChooser.APPROVE_OPTION) {
                File file = fileChooser.getSelectedFile();
                try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
                    textArea.read(reader, null);
                    setTitle(file.getName() + " - Code Notepad");
                } catch (IOException ex) {
                    JOptionPane.showMessageDialog(this, "Error opening file!");
                }
            }
        } 
        else if (e.getSource() == saveFile) {
            JFileChooser fileChooser = new JFileChooser();
            int option = fileChooser.showSaveDialog(this);
            if (option == JFileChooser.APPROVE_OPTION) {
                File file = fileChooser.getSelectedFile();
                try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
                    textArea.write(writer);
                    setTitle(file.getName() + " - Code Notepad");
                } catch (IOException ex) {
                    JOptionPane.showMessageDialog(this, "Error saving file!");
                }
            }
        } 
        else if (e.getSource() == exitApp) {
            System.exit(0);
        } 
        else if (e.getSource() == cutText) {
            textArea.cut();
        } 
        else if (e.getSource() == copyText) {
            textArea.copy();
        } 
        else if (e.getSource() == pasteText) {
            textArea.paste();
        } 
        else if (e.getSource() == darkMode) {
            textArea.setBackground(new Color(30, 30, 30));
            textArea.setForeground(Color.WHITE);
            textArea.setCaretColor(Color.WHITE);
        } 
        else if (e.getSource() == lightMode) {
            textArea.setBackground(Color.WHITE);
            textArea.setForeground(Color.BLACK);
            textArea.setCaretColor(Color.BLACK);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new CodeNotepad().setVisible(true);
        });
    }
}
