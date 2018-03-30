package br.univali.compiladores.lexico;

import java.awt.Color;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JEditorPane;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.event.CaretEvent;
import javax.swing.text.BadLocationException;
import javax.swing.text.JTextComponent;
import javax.swing.text.Utilities;

/**
 *
 * @author biankatpas
 */
public class ScreenController
{

    public String newFile(JEditorPane jtaEdit, JTextArea jtaMessage, JFrame jf, String fileName)
    {
        if (fileName.equals("sem nome.djt"))
        {
            if ("".equals(jtaEdit.getText()))
            {
                fileName = "sem nome.djt";
                jf.setTitle("Compilador - [sem nome.djt]");
                jtaMessage.setText("");
            } else
            {
                Object[] options
                        =
                        {
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

        } else
        {
            if (isEdited(jtaEdit, fileName) == true)
            {
                Object[] options
                        =
                        {
                            "Sim", "Não", "Cancelar"
                        };
                int op = JOptionPane.showOptionDialog(null, fileName + " foi alterado, salvar alterações?", "Salvar Alterações?", JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE, null, options, options[2]);
                if (op == 0)
                {//save file
                    save(fileName, jtaEdit, jf);
                    fileName = "sem nome.djt";
                    jtaEdit.setText("");
                    jtaMessage.setText("");
                    jf.setTitle("Compilador - [sem nome.djt]");
                } else if (op == 1) //dont save file
                {
                    fileName = "sem nome.djt";
                    jtaEdit.setText("");
                    jtaMessage.setText("");
                    jf.setTitle("Compilador - [sem nome.djt]");
                }
            } else
            {
                fileName = "sem nome.djt";
                jtaEdit.setText("");
                jtaMessage.setText("");
                jf.setTitle("Compilador - [sem nome.djt]");
            }
        }
        return fileName;
    }

    public String save(String fileName, JEditorPane jta, JFrame jf)
    {
        try
        {
            if (fileName.equalsIgnoreCase("sem nome.djt"))
            {
                String message = "Nome do arquivo: ";
                String aux = "";
                do
                {
                    aux = JOptionPane.showInputDialog(message);
                    if (aux != null)
                    {
                        fileName = aux;
                        fileName += ".djt";
                        if (exists(fileName))
                        {
                            message = "O arquivo já existe. Informe um novo nome.";
                        }
                    } else
                    {
                        break;
                    }
                } while (exists(fileName));
            }
            BufferedWriter bw = new BufferedWriter(new FileWriter(fileName));
            Scanner reader = new Scanner(jta.getText());
            while (reader.hasNextLine())
            {
                bw.write(reader.nextLine());
                bw.newLine();
            }
            bw.close();
            jf.setTitle("Compilador - " + fileName);
        } catch (IOException ex)
        {
            Logger.getLogger(ScreenController.class.getName()).log(Level.SEVERE, null, ex);
        }

        return fileName;
    }

    public String saveAs(JEditorPane jta, String fileName, JFrame jf)
    {
        try
        {
            String message = "Nome do arquivo: ";
            String aux = "";
            do
            {
                aux = JOptionPane.showInputDialog(message);
                if (aux != null)
                {
                    fileName = aux;
                    fileName += ".djt";
                    if (exists(fileName))
                    {
                        message = "O arquivo já existe. Informe um novo nome.";
                    }
                } else
                {
                    break;
                }
            } while (exists(fileName));

            BufferedWriter bw = new BufferedWriter(new FileWriter(fileName));
            Scanner reader = new Scanner(jta.getText());
            while (reader.hasNextLine())
            {
                bw.write(reader.nextLine());
                bw.newLine();
            }
            bw.close();
            jf.setTitle("Compilador - " + fileName);
        } catch (IOException ex)
        {
            Logger.getLogger(ScreenController.class.getName()).log(Level.SEVERE, null, ex);
        }

        return fileName;
    }

    public boolean isEdited(JEditorPane jta, String fileName)
    {
        try
        {

            FileReader arq = new FileReader(fileName);
            BufferedReader lerArq = new BufferedReader(arq);
            Scanner reader = new Scanner(jta.getText());
            ArrayList<String> jtaLines = new ArrayList<>();
            ArrayList<String> originalFileLines = new ArrayList<>();

            String linha = lerArq.readLine();
            originalFileLines.add(linha);
            while (linha != null)
            {
                linha = lerArq.readLine();
                if (linha != null)
                {
                    originalFileLines.add(linha);
                }
            }
            arq.close();
            while (reader.hasNextLine())
            {
                jtaLines.add(reader.nextLine());
            }

            if (originalFileLines.size() != jtaLines.size())
            {
                System.out.println("bostaaaaaaa");
                return true;
            } else
            {

                for (int i = 0; i < originalFileLines.size(); i++)
                {
                    if (!originalFileLines.get(i).equals(jtaLines.get(i)))
                    {
                        return true;
                    }
                }
            }

        } catch (FileNotFoundException ex)
        {
            Logger.getLogger(ScreenController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex)
        {
            Logger.getLogger(ScreenController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public boolean exists(String fileName)
    {
        File file = new File(fileName);
        return file.exists();
    }

    public String openFile(JEditorPane jtaEdit, JTextArea jtaMessage, String fileName, JFrame jf)
    {
        String newFileName = fileName;
        String aux = "";
        try
        {
            if (fileName.equals("sem nome.djt"))
            {
                if ("".equals(jtaEdit.getText()))
                {
                    aux = JOptionPane.showInputDialog("Nome do arquivo:");
                    if (aux != null)
                    {
                        newFileName = aux;
                        newFileName += ".djt";
                        readFileText(newFileName, jtaEdit);
                        jtaMessage.setText("");
                        jf.setTitle("Compilador - " + newFileName);
                    }
                } else
                {
                    Object[] options
                            =
                            {
                                "Sim", "Não", "Cancelar"
                            };
                    int op = JOptionPane.showOptionDialog(null, fileName + " foi alterado, salvar alterações?", "Salvar Alterações?", JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE, null, options, options[2]);

                    if (op == 1) //dont save file
                    {
                        aux = JOptionPane.showInputDialog("Nome do arquivo:");
                        if (aux != null)
                        {
                            newFileName = aux;
                            newFileName += ".djt";
                            readFileText(newFileName, jtaEdit);
                            jtaMessage.setText("");
                            jf.setTitle("Compilador - " + newFileName);
                        }
                    } else if (op == 0) //save file
                    {
                        save(fileName, jtaEdit, jf);
                        aux = JOptionPane.showInputDialog("Nome do arquivo:");
                        if (aux != null)
                        {
                            newFileName = aux;
                            newFileName += ".djt";
                            readFileText(newFileName, jtaEdit);
                            jtaMessage.setText("");
                            jf.setTitle("Compilador - " + newFileName);
                        }
                    }
                }
            } else
            {
                if (isEdited(jtaEdit, fileName) == true)
                {
                    Object[] options
                            =
                            {
                                "Sim", "Não", "Cancelar"
                            };
                    int op = JOptionPane.showOptionDialog(null, fileName + " foi alterado, salvar alterações?", "Salvar Alterações?", JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE, null, options, options[2]);
                    if (op == 0) //save file
                    {
                        save(fileName, jtaEdit, jf);
                        aux = JOptionPane.showInputDialog("Nome do arquivo:");
                        if (aux != null)
                        {
                            newFileName = aux;
                            newFileName += ".djt";
                            readFileText(newFileName, jtaEdit);
                            jtaMessage.setText("");
                            jf.setTitle("Compilador - " + newFileName);
                        }
                    } else if (op == 1) //dont save file
                    {
                        aux = JOptionPane.showInputDialog("Nome do arquivo:");
                        if (aux != null)
                        {
                            newFileName = aux;
                            newFileName += ".djt";
                            readFileText(newFileName, jtaEdit);
                            jtaMessage.setText("");
                            jf.setTitle("Compilador - " + newFileName);
                        }
                    }
                } else
                {
                    aux = JOptionPane.showInputDialog("Nome do arquivo:");
                    if (aux != null)
                    {
                        newFileName = aux;
                        newFileName += ".djt";
                        readFileText(newFileName, jtaEdit);
                        jtaMessage.setText("");
                        jf.setTitle("Compilador - " + newFileName);
                    }
                }
            }

        } catch (FileNotFoundException ex)
        {
            JOptionPane.showMessageDialog(null, "Arquivo não encontrado.");
            newFileName = fileName;
        } catch (IOException ex)
        {
            Logger.getLogger(ScreenController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return newFileName;
    }

    private void readFileText(String fileName, JEditorPane jta) throws IOException
    {

        BufferedReader br = new BufferedReader(new FileReader(fileName));
        try
        {
            StringBuilder sb = new StringBuilder();
            String line = br.readLine();

            while (line != null)
            {
                sb.append(line);
                sb.append("\n");
                line = br.readLine();
            }
            jta.setText(sb.toString());
        } finally
        {
            br.close();
        }

    }

    public void exit(JEditorPane jta, String fileName, JFrame jf)
    {
        if (fileName.equals("sem nome.djt"))
        {
            if ("".equals(jta.getText()))
            {
                System.exit(0);
            } else
            {
                Object[] options
                        =
                        {
                            "Sim", "Não", "Cancelar"
                        };
                int op = JOptionPane.showOptionDialog(null, fileName + " foi alterado, salvar alterações?", "Salvar Alterações?", JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE, null, options, options[2]);
                if (op == 1) //dont save file
                {
                    System.exit(0);
                } else if (op == 0) //save file
                {
                    save(fileName, jta, jf);
                    System.exit(0);
                }
            }
        } else
        {
            if (isEdited(jta, fileName) == true)
            {
                Object[] options
                        =
                        {
                            "Sim", "Não", "Cancelar"
                        };
                int op = JOptionPane.showOptionDialog(null, fileName + " foi alterado, salvar alterações?", "Salvar Alterações?", JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE, null, options, options[2]);
                if (op == 1) //dont save file
                {
                    System.exit(0);
                } else if (op == 0) //save file
                {
                    save(fileName, jta, jf);
                    System.exit(0);
                }
            } else
            {
                System.exit(0);
            }
        }
    }

    public void about()
    {
        JOptionPane.showMessageDialog(null, "Desenvolvido por:\nBianka Passos\nJuliana Sanguinetto");
    }

    public void cut(JEditorPane jta)
    {
        jta.cut();
    }

    public void copy(JEditorPane jta)
    {
        jta.copy();
    }

    public void paste(JEditorPane jta)
    {
        jta.paste();
    }

    public void getPosition(CaretEvent evt, JLabel lb)
    {
//        int row = jta.getDocument().getRootElements()[0].getElementIndex(jta.getCaretPosition());
//        int col = jta.getCaretPosition() - jta.getDocument().getRootElements()[0].getElement(row).getStartOffset();
        int x = getRow(evt.getDot(), (JTextComponent) evt.getSource());
        int y = getColumn(evt.getDot(), (JTextComponent) evt.getSource());
        lb.setText("Linha: " + x + ", Coluna:" + y);
    }

    private int getRow(int pos, JTextComponent editor)
    {
        int rn = (pos == 0) ? 1 : 0;
        try
        {
            int offs = pos;
            while (offs > 0)
            {
                offs = Utilities.getRowStart(editor, offs) - 1;
                rn++;
            }
        } catch (BadLocationException e)
        {
            e.printStackTrace();
        }
        return rn;
    }

    private int getColumn(int pos, JTextComponent editor)
    {
        try
        {
            return pos - Utilities.getRowStart(editor, pos) + 1;
        } catch (BadLocationException e)
        {
            e.printStackTrace();
        }
        return -1;
    }

    public void setFeedback(JLabel lb, boolean status, int error)
    {
        if (!status)
        {
            lb.setText("Compilado com sucesso...");
            lb.setForeground(Color.black);
        } else
        {
            lb.setText("Contem " + error + " erros...");
            lb.setForeground(Color.RED);
        }
    }

    public void compile(JEditorPane jtaEdit, JTextArea jtaMessage, JLabel lb)
    {
        Parser p = new Parser();
        if (!jtaEdit.getText().equals(""))
        {
            String output = "";
            jtaMessage.setText("");
            List<Message> parserOutput = p.lexicalAnalizer(jtaEdit.getText());
            int error_counter = 0;
            for (int i = 0; i < parserOutput.size(); i++)
            {
                if (parserOutput.get(i).isError())
                {
                    output += parserOutput.get(i).getMessage() + "\n";
                    error_counter++;
                } else
                {
                    output += parserOutput.get(i).getMessage() + "\n";
                }
            }
            jtaMessage.setText(output);
            setFeedback(lb, error_counter > 0, error_counter);
        } else
        {
            JOptionPane.showMessageDialog(null, "Um arquivo vazio não pode ser compilado.");
        }
    }
}
