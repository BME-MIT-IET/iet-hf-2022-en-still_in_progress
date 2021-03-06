package main.java.com.InProgress.GUI;

import main.java.com.InProgress.Model.Game;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.util.ArrayList;

public class StartWindow extends javax.swing.JFrame {

    /**
     * Creates new form StartMenu
     */
    public StartWindow() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">
    private void initComponents() {
        this.setLocationRelativeTo(null);

        // instantiate components
        numberOfPlayersButtonGroup = new javax.swing.ButtonGroup();
        jPanel2 = new javax.swing.JPanel();
        readyButton = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jRadioButton3 = new javax.swing.JRadioButton();
        jLabel1 = new javax.swing.JLabel();
        jRadioButton2 = new javax.swing.JRadioButton();
        jPanel1 = new javax.swing.JPanel();
        xTextField = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        yTextField = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        zTextField = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jRadioButton1 = new javax.swing.JRadioButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        menuMenu = new javax.swing.JMenu();
        helpMenu = new javax.swing.JMenuItem();
        exit = new javax.swing.JMenuItem("Exit");

        // window settings
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Start Menu");
        setBackground(new java.awt.Color(102, 102, 102));
        setForeground(java.awt.Color.darkGray);
        setResizable(false);

        jPanel2.setBackground(new java.awt.Color(102, 102, 102));

        // set up labels
        jLabel1.setFont(new java.awt.Font("Consolas", 0, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(51, 204, 0));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Ready to explore the Asteroid Belt?");

        jLabel2.setFont(new java.awt.Font("Consolas", 0, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(51, 204, 0));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Enter the Dimensions of the Belt:");

        jLabel3.setFont(new java.awt.Font("Consolas", 0, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(51, 204, 0));
        jLabel3.setText("X:");

        jLabel4.setFont(new java.awt.Font("Consolas", 0, 24)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(51, 204, 0));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Y:");

        jLabel5.setFont(new java.awt.Font("Consolas", 0, 24)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(51, 204, 0));
        jLabel5.setText("Z:");

        jLabel6.setFont(new java.awt.Font("Consolas", 0, 24)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(51, 204, 0));
        jLabel6.setText("Choose number of Players:");

        // set up Text fields
        xTextField.setFont(new java.awt.Font("Consolas", 0, 24)); // NOI18N
        xTextField.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        xTextField.setText("10");

        yTextField.setFont(new java.awt.Font("Consolas", 0, 24)); // NOI18N
        yTextField.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        yTextField.setText("10");

        zTextField.setFont(new java.awt.Font("Consolas", 0, 24)); // NOI18N
        zTextField.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        zTextField.setText("10");

        // set up buttons
        readyButton.setFont(new java.awt.Font("Consolas", 0, 24)); // NOI18N
        readyButton.setText("Ready to Play");
        readyButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                readyButtonActionPerformed(evt);
            }
        });

        // set up radio buttons
        jRadioButton1.setBackground(new java.awt.Color(102, 102, 102));
        numberOfPlayersButtonGroup.add(jRadioButton1);
        jRadioButton1.setFont(new java.awt.Font("Consolas", 0, 24)); // NOI18N
        jRadioButton1.setForeground(new java.awt.Color(51, 204, 0));
        jRadioButton1.setText("1");
        jRadioButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        jRadioButton2.setBackground(new java.awt.Color(102, 102, 102));
        numberOfPlayersButtonGroup.add(jRadioButton2);
        jRadioButton2.setFont(new java.awt.Font("Consolas", 0, 24)); // NOI18N
        jRadioButton2.setForeground(new java.awt.Color(51, 204, 0));
        jRadioButton2.setText("2");

        jRadioButton3.setBackground(new java.awt.Color(102, 102, 102));
        numberOfPlayersButtonGroup.add(jRadioButton3);
        jRadioButton3.setFont(new java.awt.Font("Consolas", 0, 24)); // NOI18N
        jRadioButton3.setForeground(new java.awt.Color(51, 204, 0));
        jRadioButton3.setText("3");

        // set up menu bar
        jMenuBar1.setBackground(new java.awt.Color(102, 102, 102));

        menuMenu.setText("Menu");
        menuMenu.setFont(new java.awt.Font("Consolas", 0, 24)); // NOI18N
        jMenuBar1.add(menuMenu);
        menuMenu.add(exit);

        exit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitActionPerformed(evt);
            }
        });

        helpMenu.setText("Help");
        helpMenu.setFont(new java.awt.Font("Consolas", 0, 24)); // NOI18N
        jMenuBar1.add(helpMenu);
        helpMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                helpMenuActionPerformed(evt);
            }
        });

        setJMenuBar(jMenuBar1);

        //<editor-fold desc="Placing components">
        jPanel1.setBackground(new java.awt.Color(102, 102, 102));
        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(43, 43, 43)
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(xTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(109, 109, 109)
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(yTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(zTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(34, 34, 34))
        );
        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(xTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel3)
                                        .addComponent(yTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel4)
                                        .addComponent(zTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel5))
                                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
                jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(62, 62, 62)
                                .addComponent(jLabel6)
                                .addGap(37, 37, 37)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jRadioButton3)
                                        .addComponent(jRadioButton2)
                                        .addComponent(jRadioButton1))
                                .addGap(0, 52, Short.MAX_VALUE))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(readyButton)
                                .addGap(169, 169, 169))
        );
        jPanel2Layout.setVerticalGroup(
                jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel2)
                                .addGap(32, 32, 32)
                                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(37, 37, 37)
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 108, Short.MAX_VALUE)
                                .addComponent(readyButton)
                                .addGap(24, 24, 24))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jRadioButton1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jRadioButton2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jRadioButton3)
                                .addGap(71, 71, 71))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        //</editor-fold>

        pack();

    }
    // </editor-fold>

    /**
     * Creates an infobox to display information to the user.
     *
     * @param message Text of the message to the user
     * @param title Title of the window
     */
    public static void infobox(String message,String title)
    {
        JOptionPane.showMessageDialog(null,message,title, JOptionPane.INFORMATION_MESSAGE);
    }

    /**
     * Initializes StartWindow window and makes it visible.
     */
    public void initialize() {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(StartWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(StartWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(StartWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(StartWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new StartWindow().setVisible(true);
            }
        });
    }


    //<editor-fold desc="ActionListeners">

     /**
     * Close the game application
      *
     * @param evt click event
     */
	private void exitActionPerformed(ActionEvent evt) {

        System.exit(0);
    }

    /**
     * Creates infobox window to display a help message for the user when "Help" is clicked in the menubar.
     *
     * @param evt click event
     */
    private void helpMenuActionPerformed(ActionEvent evt) {
        StartWindow.infobox("Nobody can hear you scream in space","You are on your own!");
    }

    /**
     * Calls Game.controllerExternal() method to set up the asteroid belt and starts the game.
     *
     * @param evt click event
     */
    private void readyButtonActionPerformed(java.awt.event.ActionEvent evt) {

        int x = Integer.parseInt(xTextField.getText());
        int y = Integer.parseInt(yTextField.getText());
        int z = Integer.parseInt(zTextField.getText());

        ArrayList<String> input = new ArrayList<>(4);

        if((x<5 || x>10) || (y<5 || y>10) || (z<5 || z>10))
        {
            StartWindow.infobox("Asteroid belt too large/small","Invalid input");
            return;
        }

        if(jRadioButton1.isSelected()) {
            setVisible(false);

            input.add(0, Integer.toString(1));
            input.add(1, xTextField.getText());
            input.add(2, yTextField.getText());
            input.add(3, zTextField.getText());
            Game.controllerExternal(0, input);

            System.out.println("Game created");
        }

        else if(jRadioButton2.isSelected()) {
            setVisible(false);

            input.add(0, Integer.toString(2));
            input.add(1, xTextField.getText());
            input.add(2, yTextField.getText());
            input.add(3, zTextField.getText());
            Game.controllerExternal(0, input);

            System.out.println("Game created");
        }
        else if(jRadioButton3.isSelected()) {
            setVisible(false);

            input.add(0, Integer.toString(3));
            input.add(1, xTextField.getText());
            input.add(2, yTextField.getText());
            input.add(3, zTextField.getText());
            Game.controllerExternal(0, input);

            System.out.println("Game created");
        }
        else {
            infobox("Please select number of players", "Insufficient Input");
            return;
        }

        dispose();
    }
    //</editor-fold>


    //<editor-fold desc="Variables">
    // Variables declaration - do not modify
    private javax.swing.JMenuItem helpMenu;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JRadioButton jRadioButton2;
    private javax.swing.JRadioButton jRadioButton3;
    private javax.swing.JMenu menuMenu;
    private javax.swing.ButtonGroup numberOfPlayersButtonGroup;
    private javax.swing.JButton readyButton;
    private javax.swing.JTextField xTextField;
    private javax.swing.JTextField yTextField;
    private javax.swing.JTextField zTextField;
    private javax.swing.JMenuItem exit;
    //</editor-fold>
}
