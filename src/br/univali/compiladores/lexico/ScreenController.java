package br.univali.compiladores.lexico;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;

/**
 *
 * @author biankatpas
 */
public class ScreenController {

    public String newFile(JTextArea jtaEdit, JTextArea jtaMessage, JFrame jf, String fileName) {
        if (fileName.equals("sem nome.djt")) {
            if ("".equals(jtaEdit.getText())) {
                fileName = "sem nome.djt";
                jf.setTitle("Compilador - [sem nome.djt]");
                jtaMessage.setText("");
            } else {
                Object[] options
                        = {
                            "Sim", "Não", "Cancelar"
                        };
                int op = JOptionPane.showOptionDialog(null, fileName + " foi alterado, salvar alterações?", "Salvar Alterações?", JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE, null, options, options[2]);
                if (op == 1) //dont save file
                {
                    fileName = "sem nome.djt";
                    jtaEdit.setText("");
                    jtaMessage.setText("");
                    jf.setTitle("Compilador - [sem nome.djt]");
                } else if (op == 0) //save file
                {
                    save(fileName, jtaEdit, jf);
                    fileName = "sem nome.djt";
                    jtaEdit.setText("");
                    jtaMessage.setText("");
                    jf.setTitle("Compilador - [sem nome.djt]");
                }
            }

        } else {
            isEdited(jtaEdit, fileName);
        }
        return fileName;
    }

    public String save(String fileName, JTextArea jta, JFrame jf) {
        try {
            if (fileName.equalsIgnoreCase("sem nome.djt")) {
                String message = "Nome do arquivo: ";
                do {
                    fileName = JOptionPane.showInputDialog(message);
                    fileName += ".djt";
                    if (exists(fileName)) {
                        message = "O arquivo já existe. Informe um novo nome.";
                    }
                } while (exists(fileName));
            }
            BufferedWriter bw = new BufferedWriter(new FileWriter(fileName));
            Scanner reader = new Scanner(jta.getText());
            while (reader.hasNextLine()) {
                bw.write(reader.nextLine());
                bw.newLine();
            }
            bw.close();
            jf.setTitle("Compilador - " + fileName);
        } catch (IOException ex) {
            Logger.getLogger(ScreenController.class.getName()).log(Level.SEVERE, null, ex);
        }

        return fileName;
    }

    public String saveAs(JTextArea jta, String fileName, JFrame jf) {
        try {
            String message = "Nome do arquivo: ";
            do {
                fileName = JOptionPane.showInputDialog(message);
                fileName += ".djt";
                if (exists(fileName)) {
                    message = "O arquivo já existe. Informe um novo nome.";
                }
            } while (exists(fileName));

            BufferedWriter bw = new BufferedWriter(new FileWriter(fileName));
            Scanner reader = new Scanner(jta.getText());
            while (reader.hasNextLine()) {
                bw.write(reader.nextLine());
                bw.newLine();
            }
            bw.close();
            jf.setTitle("Compilador - " + fileName);
        } catch (IOException ex) {
            Logger.getLogger(ScreenController.class.getName()).log(Level.SEVERE, null, ex);
        }

        return fileName;
    }

    //TODO: fazer e colocar essa verificacao nas outras funcoes
    public boolean isEdited(JTextArea jta, String fileName) {
        try {

            FileReader arq = new FileReader(fileName);
            BufferedReader lerArq = new BufferedReader(arq);
            Scanner reader = new Scanner(jta.getText());
            ArrayList<String> jtaLines = new ArrayList<>();
            ArrayList<String> originalFileLines = new ArrayList<>();

            String linha = lerArq.readLine();
            originalFileLines.add(linha);
            while (linha != null) {
                linha = lerArq.readLine();
                originalFileLines.add(linha);
            }
            arq.close();

            for (int i = 0; i < originalFileLines.size(); i++) {
                System.out.println(originalFileLines.get(i));
            }

            while (reader.hasNextLine()) {
                jtaLines.add(reader.nextLine());
            }

            if (originalFileLines.size() != jtaLines.size()) {
                return true;
            } else {

                for (int i = 0; i < originalFileLines.size(); i++) {
                    if (!originalFileLines.get(i).equals(jtaLines.get(i))) {
                        return true;
                    }
                }
            }
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(ScreenController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ScreenController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public boolean exists(String fileName) {
        File file = new File(fileName);
        return file.exists();
    }

    public String openFile(JTextArea jtaEdit, JTextArea jtaMessage, JFrame jf) {
        String fileName = "";
        try {
            fileName = JOptionPane.showInputDialog("Nome do arquivo:");
            fileName += ".djt";
            BufferedReader br = new BufferedReader(new FileReader(fileName));
            jtaEdit.setText(br.readLine());
            jtaMessage.setText("");
            jf.setTitle("Compilador - " + fileName);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(ScreenController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ScreenController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return fileName;
    }

    public void about() {
        JOptionPane.showMessageDialog(null, "Desenvolvido por:\nBianka Passos\nJuliana Sanguinetto");
    }

    public void cut(JTextArea jta) {
        jta.cut();
    }

    public void copy(JTextArea jta) {
        jta.copy();
    }

    public void paste(JTextArea jta) {
        jta.paste();
    }
}
