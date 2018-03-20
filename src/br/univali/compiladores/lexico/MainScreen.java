package br.univali.compiladores.lexico;

import javax.swing.JOptionPane;

/**
 *
 * @author biankatpas
 */
public class MainScreen extends javax.swing.JFrame
{

     /**
     * Creates new form Screen
     */
    public MainScreen()
    {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents()
    {

        jtbToolBar = new javax.swing.JToolBar();
        btNew = new javax.swing.JButton();
        btOpen = new javax.swing.JButton();
        btSave = new javax.swing.JButton();
        jsToolBarSeparator1 = new javax.swing.JToolBar.Separator();
        btCut = new javax.swing.JButton();
        btCopy = new javax.swing.JButton();
        btPaste = new javax.swing.JButton();
        jsToolBarSeparator2 = new javax.swing.JToolBar.Separator();
        btCompile = new javax.swing.JButton();
        btRun = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JToolBar.Separator();
        btAbout = new javax.swing.JButton();
        jspEdit = new javax.swing.JScrollPane();
        jtaEdit = new javax.swing.JTextArea();
        jspMessage = new javax.swing.JScrollPane();
        jtaMessage = new javax.swing.JTextArea();
        jsTextAreaSeparator = new javax.swing.JSeparator();
        jmbMenuBar = new javax.swing.JMenuBar();
        jmFile = new javax.swing.JMenu();
        jmiNew = new javax.swing.JMenuItem();
        jmiOpen = new javax.swing.JMenuItem();
        jmiSave = new javax.swing.JMenuItem();
        jmiSaveAs = new javax.swing.JMenuItem();
        jmiExit = new javax.swing.JMenuItem();
        jmEdit = new javax.swing.JMenu();
        jmiCopy = new javax.swing.JMenuItem();
        jmiPaste = new javax.swing.JMenuItem();
        jmiCut = new javax.swing.JMenuItem();
        jmCompile = new javax.swing.JMenu();
        jmiCompile = new javax.swing.JMenuItem();
        jmiRun = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Compilador");

        jtbToolBar.setFloatable(false);

        btNew.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/new.png"))); // NOI18N
        btNew.setToolTipText("Novo");
        btNew.setFocusable(false);
        btNew.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btNew.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btNew.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                btNewActionPerformed(evt);
            }
        });
        jtbToolBar.add(btNew);

        btOpen.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/open.png"))); // NOI18N
        btOpen.setToolTipText("Abrir");
        btOpen.setFocusable(false);
        btOpen.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btOpen.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btOpen.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                btOpenActionPerformed(evt);
            }
        });
        jtbToolBar.add(btOpen);

        btSave.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/save.png"))); // NOI18N
        btSave.setToolTipText("Salvar");
        btSave.setFocusable(false);
        btSave.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btSave.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btSave.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                btSaveActionPerformed(evt);
            }
        });
        jtbToolBar.add(btSave);
        jtbToolBar.add(jsToolBarSeparator1);

        btCut.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/cut.png"))); // NOI18N
        btCut.setToolTipText("Recortar");
        btCut.setFocusable(false);
        btCut.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btCut.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btCut.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                btCutActionPerformed(evt);
            }
        });
        jtbToolBar.add(btCut);

        btCopy.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/copy.png"))); // NOI18N
        btCopy.setToolTipText("Copiar");
        btCopy.setFocusable(false);
        btCopy.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btCopy.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btCopy.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                btCopyActionPerformed(evt);
            }
        });
        jtbToolBar.add(btCopy);

        btPaste.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/paste.png"))); // NOI18N
        btPaste.setToolTipText("Colar");
        btPaste.setFocusable(false);
        btPaste.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btPaste.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btPaste.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                btPasteActionPerformed(evt);
            }
        });
        jtbToolBar.add(btPaste);
        jtbToolBar.add(jsToolBarSeparator2);

        btCompile.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/compile.png"))); // NOI18N
        btCompile.setToolTipText("Compilar");
        btCompile.setFocusable(false);
        btCompile.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btCompile.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btCompile.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                btCompileActionPerformed(evt);
            }
        });
        jtbToolBar.add(btCompile);

        btRun.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/run.png"))); // NOI18N
        btRun.setToolTipText("Executar");
        btRun.setFocusable(false);
        btRun.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btRun.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btRun.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                btRunActionPerformed(evt);
            }
        });
        jtbToolBar.add(btRun);
        jtbToolBar.add(jSeparator1);

        btAbout.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/help.png"))); // NOI18N
        btAbout.setToolTipText("Sobre");
        btAbout.setFocusable(false);
        btAbout.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btAbout.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btAbout.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                btAboutActionPerformed(evt);
            }
        });
        jtbToolBar.add(btAbout);

        jtaEdit.setColumns(20);
        jtaEdit.setLineWrap(true);
        jtaEdit.setRows(5);
        jspEdit.setViewportView(jtaEdit);

        jtaMessage.setColumns(20);
        jtaMessage.setLineWrap(true);
        jtaMessage.setRows(5);
        jspMessage.setViewportView(jtaMessage);

        jmFile.setText("Arquivo");

        jmiNew.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/new.png"))); // NOI18N
        jmiNew.setText("Novo");
        jmiNew.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                jmiNewActionPerformed(evt);
            }
        });
        jmFile.add(jmiNew);

        jmiOpen.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/open.png"))); // NOI18N
        jmiOpen.setText("Abrir");
        jmiOpen.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                jmiOpenActionPerformed(evt);
            }
        });
        jmFile.add(jmiOpen);

        jmiSave.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/save.png"))); // NOI18N
        jmiSave.setText("Salvar");
        jmiSave.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                jmiSaveActionPerformed(evt);
            }
        });
        jmFile.add(jmiSave);

        jmiSaveAs.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/save-as.png"))); // NOI18N
        jmiSaveAs.setText("Salvar como...");
        jmiSaveAs.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                jmiSaveAsActionPerformed(evt);
            }
        });
        jmFile.add(jmiSaveAs);

        jmiExit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/exit.png"))); // NOI18N
        jmiExit.setText("Sair");
        jmFile.add(jmiExit);

        jmbMenuBar.add(jmFile);

        jmEdit.setText("Edição");

        jmiCopy.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/copy.png"))); // NOI18N
        jmiCopy.setText("Copiar");
        jmiCopy.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                jmiCopyActionPerformed(evt);
            }
        });
        jmEdit.add(jmiCopy);

        jmiPaste.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/paste.png"))); // NOI18N
        jmiPaste.setText("Colar");
        jmiPaste.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                jmiPasteActionPerformed(evt);
            }
        });
        jmEdit.add(jmiPaste);

        jmiCut.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/cut.png"))); // NOI18N
        jmiCut.setText("Recortar");
        jmiCut.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                jmiCutActionPerformed(evt);
            }
        });
        jmEdit.add(jmiCut);

        jmbMenuBar.add(jmEdit);

        jmCompile.setText("Compilação");

        jmiCompile.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/compile.png"))); // NOI18N
        jmiCompile.setText("Compilar");
        jmCompile.add(jmiCompile);

        jmiRun.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/run.png"))); // NOI18N
        jmiRun.setText("Executar");
        jmCompile.add(jmiRun);

        jmbMenuBar.add(jmCompile);

        setJMenuBar(jmbMenuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jspEdit)
            .addComponent(jspMessage)
            .addComponent(jsTextAreaSeparator)
            .addComponent(jtbToolBar, javax.swing.GroupLayout.DEFAULT_SIZE, 1014, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jtbToolBar, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jspEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 487, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(4, 4, 4)
                .addComponent(jsTextAreaSeparator, javax.swing.GroupLayout.PREFERRED_SIZE, 8, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jspMessage, javax.swing.GroupLayout.DEFAULT_SIZE, 187, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jmiNewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiNewActionPerformed
        fileName = control.newFile(jtaEdit, jtaMessage, this, fileName);
    }//GEN-LAST:event_jmiNewActionPerformed

    private void btNewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btNewActionPerformed
        fileName = control.newFile(jtaEdit, jtaMessage, this, fileName);
    }//GEN-LAST:event_btNewActionPerformed

    private void jmiSaveActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_jmiSaveActionPerformed
    {//GEN-HEADEREND:event_jmiSaveActionPerformed
        fileName = control.save(fileName, jtaEdit, this);
    }//GEN-LAST:event_jmiSaveActionPerformed

    private void jmiSaveAsActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_jmiSaveAsActionPerformed
    {//GEN-HEADEREND:event_jmiSaveAsActionPerformed
        fileName = control.saveAs(jtaEdit, fileName, this);
    }//GEN-LAST:event_jmiSaveAsActionPerformed

    private void btSaveActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_btSaveActionPerformed
    {//GEN-HEADEREND:event_btSaveActionPerformed
        fileName = control.save(fileName, jtaEdit, this);
    }//GEN-LAST:event_btSaveActionPerformed

    private void btAboutActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_btAboutActionPerformed
    {//GEN-HEADEREND:event_btAboutActionPerformed
        control.about();
    }//GEN-LAST:event_btAboutActionPerformed

    private void btOpenActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_btOpenActionPerformed
    {//GEN-HEADEREND:event_btOpenActionPerformed
        fileName = control.openFile(jtaEdit, jtaMessage, this);
    }//GEN-LAST:event_btOpenActionPerformed

    private void jmiOpenActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_jmiOpenActionPerformed
    {//GEN-HEADEREND:event_jmiOpenActionPerformed
        // TODO add your handling code here:
        fileName = control.openFile(jtaEdit, jtaMessage, this);
    }//GEN-LAST:event_jmiOpenActionPerformed

    private void jmiCopyActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_jmiCopyActionPerformed
    {//GEN-HEADEREND:event_jmiCopyActionPerformed
        control.copy(jtaEdit);
    }//GEN-LAST:event_jmiCopyActionPerformed

    private void jmiPasteActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_jmiPasteActionPerformed
    {//GEN-HEADEREND:event_jmiPasteActionPerformed
        control.paste(jtaEdit);
    }//GEN-LAST:event_jmiPasteActionPerformed

    private void jmiCutActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_jmiCutActionPerformed
    {//GEN-HEADEREND:event_jmiCutActionPerformed
        control.cut(jtaEdit);
    }//GEN-LAST:event_jmiCutActionPerformed

    private void btCutActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_btCutActionPerformed
    {//GEN-HEADEREND:event_btCutActionPerformed
        control.cut(jtaEdit);
    }//GEN-LAST:event_btCutActionPerformed

    private void btCopyActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_btCopyActionPerformed
    {//GEN-HEADEREND:event_btCopyActionPerformed
        control.copy(jtaEdit);
    }//GEN-LAST:event_btCopyActionPerformed

    private void btPasteActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_btPasteActionPerformed
    {//GEN-HEADEREND:event_btPasteActionPerformed
        control.paste(jtaEdit);
    }//GEN-LAST:event_btPasteActionPerformed

    private void btRunActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_btRunActionPerformed
    {//GEN-HEADEREND:event_btRunActionPerformed
        JOptionPane.showMessageDialog(null, "TODO");
    }//GEN-LAST:event_btRunActionPerformed

    private void btCompileActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_btCompileActionPerformed
    {//GEN-HEADEREND:event_btCompileActionPerformed
        control.compile(jtaEdit, jtaMessage);
    }//GEN-LAST:event_btCompileActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[])
    {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try
        {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels())
            {
                if ("Nimbus".equals(info.getName()))
                {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex)
        {
            java.util.logging.Logger.getLogger(MainScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex)
        {
            java.util.logging.Logger.getLogger(MainScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex)
        {
            java.util.logging.Logger.getLogger(MainScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex)
        {
            java.util.logging.Logger.getLogger(MainScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable()
        {
            public void run()
            {
                new MainScreen().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btAbout;
    private javax.swing.JButton btCompile;
    private javax.swing.JButton btCopy;
    private javax.swing.JButton btCut;
    private javax.swing.JButton btNew;
    private javax.swing.JButton btOpen;
    private javax.swing.JButton btPaste;
    private javax.swing.JButton btRun;
    private javax.swing.JButton btSave;
    private javax.swing.JToolBar.Separator jSeparator1;
    private javax.swing.JMenu jmCompile;
    private javax.swing.JMenu jmEdit;
    private javax.swing.JMenu jmFile;
    private javax.swing.JMenuBar jmbMenuBar;
    private javax.swing.JMenuItem jmiCompile;
    private javax.swing.JMenuItem jmiCopy;
    private javax.swing.JMenuItem jmiCut;
    private javax.swing.JMenuItem jmiExit;
    private javax.swing.JMenuItem jmiNew;
    private javax.swing.JMenuItem jmiOpen;
    private javax.swing.JMenuItem jmiPaste;
    private javax.swing.JMenuItem jmiRun;
    private javax.swing.JMenuItem jmiSave;
    private javax.swing.JMenuItem jmiSaveAs;
    private javax.swing.JSeparator jsTextAreaSeparator;
    private javax.swing.JToolBar.Separator jsToolBarSeparator1;
    private javax.swing.JToolBar.Separator jsToolBarSeparator2;
    private javax.swing.JScrollPane jspEdit;
    private javax.swing.JScrollPane jspMessage;
    private javax.swing.JTextArea jtaEdit;
    private javax.swing.JTextArea jtaMessage;
    private javax.swing.JToolBar jtbToolBar;
    // End of variables declaration//GEN-END:variables
    private ScreenController control = new ScreenController();
    private String fileName = "sem nome.djt";
}
