package br.univali.compiladores.sintatico;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JEditorPane;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.event.CaretEvent;
import java.awt.Color;
import javax.swing.JFileChooser;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.text.BadLocationException;
import javax.swing.text.JTextComponent;
import javax.swing.text.Utilities;

/**
 *
 * @author biankatpas
 */
public class ScreenController {

    public String newFile(JEditorPane jtaEdit, JTextArea jtaMessage, JFrame jf, String fileName, String filePath) {
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
                    save(fileName, filePath, jtaEdit, jf);
                    fileName = "sem nome.djt";
                    jtaEdit.setText("");
                    jtaMessage.setText("");
                    jf.setTitle("Compilador - [sem nome.djt]");
                }
            }

        } else {
//            System.out.println(fileName);
//            System.out.println(filePath);
            if (isEdited(jtaEdit, filePath) == true) {
                Object[] options
                        = {
                            "Sim", "Não", "Cancelar"
                        };
                int op = JOptionPane.showOptionDialog(null, fileName + " foi alterado, salvar alterações?", "Salvar Alterações?", JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE, null, options, options[2]);
                if (op == 0) {//save file
                    save(fileName, filePath, jtaEdit, jf);
                    fileName = "sem nome.djt";
                    filePath = ("");
                    jtaEdit.setText("");
                    jtaMessage.setText("");
                    jf.setTitle("Compilador - [sem nome.djt]");
                } else if (op == 1) //dont save file
                {
                    fileName = "sem nome.djt";
                    filePath = ("");
                    jtaEdit.setText("");
                    jtaMessage.setText("");
                    jf.setTitle("Compilador - [sem nome.djt]");
                }
            } else {
                fileName = "sem nome.djt";
                filePath = ("");
                jtaEdit.setText("");
                jtaMessage.setText("");
                jf.setTitle("Compilador - [sem nome.djt]");
            }
        }
        return fileName;
    }

    public String save(String fileName, String filePath, JEditorPane jta, JFrame jf) {
        String dir = getPath(filePath);

        try {
            if (fileName.equalsIgnoreCase("sem nome.djt")) {
                String res = saveAs(jta, fileName, filePath, jf);
                String array[] = new String[2];
                array = res.split(",");
                fileName = array[0];
                filePath = array[1];
            } else {
                BufferedWriter bw = new BufferedWriter(new FileWriter(dir));
                Scanner reader = new Scanner(jta.getText());
                while (reader.hasNextLine()) {
                    bw.write(reader.nextLine());
                    bw.newLine();
                }
                bw.close();
                jf.setTitle("Compilador - " + fileName);
            }
        } catch (IOException ex) {
            Logger.getLogger(ScreenController.class.getName()).log(Level.SEVERE, null, ex);
        }

        return fileName + "," + filePath;
    }

    public String saveAs(JEditorPane jta, String fileName, String filePath, JFrame jf) {
        JFileChooser fileChooser = new JFileChooser();
        String originalPath = filePath;
        String originalName = fileName;
        FileNameExtensionFilter djt = new FileNameExtensionFilter("DJT (*.djt)", "djt");

        String dir = getPath(filePath);
        fileChooser.setSelectedFile(new File(dir));
        fileChooser.setFileFilter(djt);
        fileChooser.setSelectedFile(new File(filePath));

        try {
            if (fileChooser.showSaveDialog(fileChooser) == JFileChooser.APPROVE_OPTION) {
                File file = fileChooser.getSelectedFile();
                filePath = file.getPath();
                if (!filePath.contains(".djt")) {
                    filePath += ".djt";
                }

                File selectedFile = new File(filePath);
                fileName = selectedFile.getName();

                if (selectedFile.exists()) {
                    Object[] options
                            = {
                                "Sim", "Não", "Cancelar"
                            };
                    int op = JOptionPane.showOptionDialog(null, fileName + " já existe, Deseja substituí-lo?", "Confirmar Salvar Como", JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE, null, options, options[0]);

                    // save
                    if (op == 0) {
                        BufferedWriter bw = new BufferedWriter(new FileWriter(selectedFile));
                        Scanner reader = new Scanner(jta.getText());
                        while (reader.hasNextLine()) {
                            bw.write(reader.nextLine());
                            bw.newLine();
                        }
                        bw.close();
                        jf.setTitle("Compilador - " + fileName);
                    } else { // dont save
                        filePath = originalPath;
                        fileName = originalName;
                    }

                } else {
                    BufferedWriter bw = new BufferedWriter(new FileWriter(selectedFile));
                    Scanner reader = new Scanner(jta.getText());
                    while (reader.hasNextLine()) {
                        bw.write(reader.nextLine());
                        bw.newLine();
                    }
                    bw.close();
                    jf.setTitle("Compilador - " + fileName);
                }

            }
        } catch (IOException ex) {
            Logger.getLogger(MainScreen.class.getName()).log(Level.SEVERE, null, ex);
        }

        return fileName + "," + filePath;
//        return fileName;
    }

    public boolean isEdited(JEditorPane jta, String fileName) {
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
                if (linha != null) {
                    originalFileLines.add(linha);
                }
            }
            arq.close();
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

    private String getPath(String filePath) {
        File exeFile = new File(".");
        String path = "";
        if (filePath.equals("")) {
            path = exeFile.getAbsolutePath();
        } else {
            exeFile = new File(filePath);
            path = exeFile.getAbsolutePath();
        }
        return path;
    }

    public String openFile(JEditorPane jtaEdit, JTextArea jtaMessage, String fileName, String filePath, JFrame jf) {
        String newFileName = fileName;
        String dir = "";
        String res = "";

        final JFileChooser fc = new JFileChooser();
        FileNameExtensionFilter djt = new FileNameExtensionFilter("DJT (*.djt)", "djt");
        FileFilter defaultFilter = fc.getFileFilter();
        dir = getPath(filePath);
        System.out.println(dir);
        fc.setSelectedFile(new File(dir));
        fc.setFileFilter(djt);

        try {
            if (fileName.equals("sem nome.djt")) {
                if ("".equals(jtaEdit.getText())) {
                    if (fc.showOpenDialog(fc) == JFileChooser.APPROVE_OPTION) {
                        if (fc.getSelectedFile() != null) {
                            dir = fc.getSelectedFile().getAbsolutePath();
                            filePath = fc.getSelectedFile().toString();
                            File selectedFile = new File(filePath);
                            newFileName = selectedFile.getName();
                            readFileText(selectedFile.toString(), jtaEdit);
                            jtaMessage.setText("");
                            jf.setTitle("Compilador - " + newFileName);
                        }
                    }
                } else {
                    Object[] options
                            = {
                                "Sim", "Não", "Cancelar"
                            };
                    int op = JOptionPane.showOptionDialog(null, fileName + " foi alterado, salvar alterações?", "Salvar Alterações?", JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE, null, options, options[2]);

                    if (op == 1) //dont save file
                    {
                        if (fc.showOpenDialog(fc) == JFileChooser.APPROVE_OPTION) {
                            if (fc.getSelectedFile() != null) {

                                dir = fc.getSelectedFile().getAbsolutePath();
                                filePath = fc.getSelectedFile().toString();
                                File selectedFile = new File(filePath);
                                newFileName = selectedFile.getName();
                                readFileText(selectedFile.toString(), jtaEdit);
                                jtaMessage.setText("");
                                jf.setTitle("Compilador - " + newFileName);
                            }
                        }
                    } else if (op == 0) //save file
                    {
                        save(dir + fileName, filePath, jtaEdit, jf);
                        if (fc.showOpenDialog(fc) == JFileChooser.APPROVE_OPTION) {
                            if (fc.getSelectedFile() != null) {
                                dir = fc.getSelectedFile().getAbsolutePath();
                                filePath = fc.getSelectedFile().toString();
                                File selectedFile = new File(filePath);
                                newFileName = selectedFile.getName();
                                readFileText(selectedFile.toString(), jtaEdit);
                                jtaMessage.setText("");
                                jf.setTitle("Compilador - " + newFileName);
                            }
                        }
                    }
                }
            } else {
                if (isEdited(jtaEdit, dir) == true) {
                    Object[] options
                            = {
                                "Sim", "Não", "Cancelar"
                            };
                    int op = JOptionPane.showOptionDialog(null, fileName + " foi alterado, salvar alterações?", "Salvar Alterações?", JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE, null, options, options[2]);
                    if (op == 0) //save file
                    {
                        save(dir, filePath, jtaEdit, jf);
                        if (fc.showOpenDialog(fc) == JFileChooser.APPROVE_OPTION) {
                            if (fc.getSelectedFile() != null) {
                                dir = fc.getSelectedFile().getAbsolutePath();
                                filePath = fc.getSelectedFile().toString();
                                File selectedFile = new File(filePath);
                                newFileName = selectedFile.getName();
                                readFileText(selectedFile.toString(), jtaEdit);
                                jtaMessage.setText("");
                                jf.setTitle("Compilador - " + newFileName);
                            }
                        }
                    } else if (op == 1) //dont save file
                    {
                        if (fc.showOpenDialog(fc) == JFileChooser.APPROVE_OPTION) {
                            if (fc.getSelectedFile() != null) {
                                dir = fc.getSelectedFile().getAbsolutePath();
                                filePath = fc.getSelectedFile().toString();
                                File selectedFile = new File(filePath);
                                newFileName = selectedFile.getName();
                                readFileText(selectedFile.toString(), jtaEdit);
                                jtaMessage.setText("");
                                jf.setTitle("Compilador - " + newFileName);
                            }
                        }
                    }
                } else {
                    if (fc.showOpenDialog(fc) == JFileChooser.APPROVE_OPTION) {
                        if (fc.getSelectedFile() != null) {
                            dir = fc.getSelectedFile().getAbsolutePath();
                            filePath = fc.getSelectedFile().toString();
                            File selectedFile = new File(filePath);
//                            System.out.println(selectedFile);
                            newFileName = selectedFile.getName();
                            readFileText(selectedFile.toString(), jtaEdit);
                            jtaMessage.setText("");
                            jf.setTitle("Compilador - " + newFileName);
                        }
                    }
                }
            }

        } catch (FileNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "Arquivo não encontrado.");
            newFileName = fileName;
        } catch (IOException ex) {
            Logger.getLogger(ScreenController.class.getName()).log(Level.SEVERE, null, ex);
        }

        return newFileName + "," + dir;
    }

    private void readFileText(String fileName, JEditorPane jta) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(fileName));
        try {
            StringBuilder sb = new StringBuilder();
            String line = br.readLine();

            while (line != null) {
                sb.append(line);
                sb.append("\n");
                line = br.readLine();
            }
            jta.setText(sb.toString());
        } finally {
            br.close();
        }

    }

    public void exit(JEditorPane jta, String fileName, String filePath, JFrame jf) {
        if (fileName.equals("sem nome.djt")) {
            if ("".equals(jta.getText())) {
                System.exit(0);
            } else {
                Object[] options
                        = {
                            "Sim", "Não", "Cancelar"
                        };
                int op = JOptionPane.showOptionDialog(null, fileName + " foi alterado, salvar alterações?", "Salvar Alterações?", JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE, null, options, options[2]);
                if (op == 1) //dont save file
                {
                    System.exit(0);
                } else if (op == 0) //save file
                {
                    saveAs(jta, fileName, filePath, jf);
                    System.exit(0);
                }
            }
        } else {
            if (isEdited(jta, fileName) == true) {
                Object[] options
                        = {
                            "Sim", "Não", "Cancelar"
                        };
                int op = JOptionPane.showOptionDialog(null, fileName + " foi alterado, salvar alterações?", "Salvar Alterações?", JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE, null, options, options[2]);
                if (op == 1) //dont save file
                {
                    System.exit(0);
                } else if (op == 0) //save file
                {
                    save(fileName, filePath, jta, jf);
                    System.exit(0);
                }
            } else {
                System.exit(0);
            }
        }
    }

    public void about() {
        JOptionPane.showMessageDialog(null, "Desenvolvido por:\nBianka Passos\nJuliana Sanguinetto");
    }

    public void cut(JEditorPane jta) {
        jta.cut();
    }

    public void copy(JEditorPane jta) {
        jta.copy();
    }

    public void paste(JEditorPane jta) {
        jta.paste();
    }

    public void getPosition(CaretEvent evt, JLabel lb) {
//        int row = jta.getDocument().getRootElements()[0].getElementIndex(jta.getCaretPosition());
//        int col = jta.getCaretPosition() - jta.getDocument().getRootElements()[0].getElement(row).getStartOffset();
        int x = getRow(evt.getDot(), (JTextComponent) evt.getSource());
        int y = getColumn(evt.getDot(), (JTextComponent) evt.getSource());
        lb.setText("Linha: " + x + ", Coluna:" + y);
    }

    private int getRow(int pos, JTextComponent editor) {
        int rn = (pos == 0) ? 1 : 0;
        try {
            int offs = pos;
            while (offs > 0) {
                offs = Utilities.getRowStart(editor, offs) - 1;
                rn++;
            }
        } catch (BadLocationException e) {
            e.printStackTrace();
        }
        return rn;
    }

    private int getColumn(int pos, JTextComponent editor) {
        try {
            return pos - Utilities.getRowStart(editor, pos) + 1;
        } catch (BadLocationException e) {
            e.printStackTrace();
        }
        return -1;
    }

    public void setFeedback(JLabel lb, JLabel lbErr, boolean status, int error, int errorLex, int errorSint) {
        lbErr.setText("");
        if (!status) {
            lb.setText("Compilado com sucesso...");
            lb.setForeground(Color.black);
        } else {
            lb.setText("Contem " + error + " erro(s)...");
            lb.setForeground(Color.RED);
            if (errorLex > 0){
                lbErr.setText("Erros Lexicos: "+errorLex);
            }
            else if (errorSint > 0){
                lbErr.setText("Erros Sintaticos: "+errorSint);
            }
        }
    }

    public void compile(JEditorPane jtaEdit, JTextArea jtaMessage, JLabel lbErr, JLabel lbErr2) {
        Parser p = new Parser();
        int sint_error_counter = 0, lex_error_counter = 0;
        if (!jtaEdit.getText().equals("")) {
            String output = "";
            jtaMessage.setText("");
            List<Message> lexicalOutput = p.lexicalAnalizer(jtaEdit.getText());
            lex_error_counter = lexicalOutput.size();
            if (lex_error_counter > 0) {
                for (int i = 0; i < lex_error_counter; i++) {
                    if (lexicalOutput.get(i).isError()) {
                        output += lexicalOutput.get(i).getMessage() + "\n";
                    } else {
                        output += lexicalOutput.get(i).getMessage() + "\n";
                    }
                }
            } else {
                List<Message> sintaticalOutput = p.sintaticalAnalizer(jtaEdit.getText());
                List<Message> gambiarraOutput = new ArrayList<>();
                List<String> gambiarraMessages = new ArrayList<>();
                sint_error_counter = sintaticalOutput.size();
                if (sint_error_counter > 0) {
                    for (int i = 0; i < sint_error_counter; i++) {
                        String[] m = sintaticalOutput.get(i).getMessage().split("Estava");
                        String m2 = m[0];
//                        System.out.println(m2);
                        if (!gambiarraMessages.contains(m2)) {
                            gambiarraMessages.add(m2);
//                            System.out.println(m2);
                            gambiarraOutput.add(sintaticalOutput.get(i));
                        } 
                    }
                    sint_error_counter = gambiarraOutput.size();
                    for (int i = 0; i < gambiarraOutput.size(); i++) {
                        if (gambiarraOutput.get(i).isError()) {
                            output += gambiarraOutput.get(i).getMessage() + "\n";
                        } else {
                            output += gambiarraOutput.get(i).getMessage() + "\n";
                        }
                    }
                }
            }
            jtaMessage.setText(output);
            setFeedback(lbErr, lbErr2, (sint_error_counter + lex_error_counter) > 0, (sint_error_counter + lex_error_counter), lex_error_counter, sint_error_counter);
        } else {
            JOptionPane.showMessageDialog(null, "Um arquivo vazio não pode ser compilado.");
        }
    }
}
