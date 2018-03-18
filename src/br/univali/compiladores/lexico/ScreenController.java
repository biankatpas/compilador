package br.univali.compiladores.lexico;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
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
public class ScreenController
{

    public void newFile(JTextArea jtaEdit, JTextArea jtaMessage, JFrame jf, String fileName)
    {
        if (jtaEdit.getText().equals(""))
        {
            fileName = "sem nome.djt";
            jf.setTitle("Compilador - [sem nome.djt]");
            jtaMessage.setText("");
        }
        else
        {
            Object[] options = {"Sim", "Não", "Cancelar"};
            int op = JOptionPane.showOptionDialog(null, fileName + " foi alterado, salvar alterações?", "Salvar Alterações?", JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE, null, options, options[2]);
            if (op == 1)
            {
                fileName = "sem nome.djt";
                jtaEdit.setText("");
                jtaMessage.setText("");
                jf.setTitle("Compilador - [sem nome.djt]");
            }else if (op == 0)
                    {
                       save(fileName, jtaEdit);
                       fileName = "sem nome.djt";
                       jtaEdit.setText("");
                       jtaMessage.setText("");
                       jf.setTitle("Compilador - [sem nome.djt]");
                    }
        }
    }
    
    public void save(String fileName, JTextArea jta)
    {
        try
        {   
            if (fileName.equalsIgnoreCase("sem nome.djt"))
            {
                 fileName = JOptionPane.showInputDialog("Nome do arquivo:");
                 fileName+=".djt";
            }
            BufferedWriter bw = new BufferedWriter(new FileWriter(fileName));
            Scanner reader = new Scanner(jta.getText());
            while(reader.hasNextLine())
            {
                bw.write(reader.nextLine());
                bw.newLine();
            }
            bw.close();
        } catch (IOException ex)
        {
            Logger.getLogger(ScreenController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void saveAs(JTextArea jta)
    {
        try
        {
            String fileName = JOptionPane.showInputDialog("Nome do arquivo:");
            fileName+=".djt";
            BufferedWriter bw = new BufferedWriter(new FileWriter(fileName));
            Scanner reader = new Scanner(jta.getText());
            while(reader.hasNextLine())
            {
                bw.write(reader.nextLine());
                bw.newLine();
            }
            bw.close();
        }catch (IOException ex)
        {
            Logger.getLogger(ScreenController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
