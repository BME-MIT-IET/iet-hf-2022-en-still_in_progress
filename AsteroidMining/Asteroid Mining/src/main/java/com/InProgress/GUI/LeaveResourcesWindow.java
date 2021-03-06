package main.java.com.InProgress.GUI;

import main.java.com.InProgress.Model.Game;
import java.util.ArrayList;

public class LeaveResourcesWindow extends javax.swing.JFrame {
    GameWindow previous;

    /**
     * Creates new form LeaveResourceMessage
     *
     * @param game Game window from which this window was called
     */
    public LeaveResourcesWindow(GameWindow game) {
        this.previous = game;
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

        // instantiate the components
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        resourceTextField = new javax.swing.JTextField();
        cancelButton = new javax.swing.JButton();
        okButton1 = new javax.swing.JButton();

        // window settings
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Leave a Resource Message");
        setResizable(false);

        // set up labels
        jLabel1.setFont(new java.awt.Font("Consolas", 0, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(51, 204, 0));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Which Resource should be left on the Asteroid?");

        // set up text fields
        resourceTextField.setFont(new java.awt.Font("Consolas", 0, 24)); // NOI18N
        resourceTextField.setForeground(new java.awt.Color(51, 204, 0));
        resourceTextField.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        resourceTextField.setText("Iron");

        // set up the buttons
        okButton1.setFont(new java.awt.Font("Consolas", 0, 24)); // NOI18N
        okButton1.setText("OK");
        okButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                okButton1ActionPerformed(evt);
            }
        });

        cancelButton.setFont(new java.awt.Font("Consolas", 0, 24)); // NOI18N
        cancelButton.setText("Cancel");
        cancelButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelButtonActionPerformed(evt);
            }
        });

        // <editor-fold desc="Grouping the components">
        jPanel1.setBackground(new java.awt.Color(102, 102, 102));
        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 680, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(270, 270, 270)
                                .addComponent(resourceTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(118, 118, 118)
                                .addComponent(okButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(cancelButton, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(110, 110, 110))
        );
        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(57, 57, 57)
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(42, 42, 42)
                                .addComponent(resourceTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 48, Short.MAX_VALUE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(okButton1)
                                        .addComponent(cancelButton))
                                .addGap(19, 19, 19))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
        );
        // </editor-fold>

        pack();
    }
    // </editor-fold>

    // <editor-fold desc="Action Listeners">
    
	/**
     * Calls the Game.controllerExternal() to store a Resource from the Inventory on the Asteroid.
     * Updates game window.
     *
     * @param evt click event
     */
	private void okButton1ActionPerformed(java.awt.event.ActionEvent evt) {

        ArrayList<String> input = new ArrayList<>();
        input.add(0, resourceTextField.getText());
        Game.controllerExternal(5, input);

        setVisible(false);
        dispose();

        GameWindow game = new GameWindow();
        game.initialize();
        this.previous.setVisible(false);
        this.previous.dispose();
    }

    /**
     * Closes the window when the "Cancel" is clicked.
     *
     * @param evt click event
     */
    private void cancelButtonActionPerformed(java.awt.event.ActionEvent evt) {
       setVisible(false);
       dispose();
    }
    // </editor-fold>

    /**
     * Initializes LeaveResourceWindow window and makes it visible.
     *
     * @param game current Game window
     */
    public void initialize(GameWindow game) {
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
        } catch (ClassNotFoundException|InstantiationException|IllegalAccessException|javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LeaveResourcesWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } 
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LeaveResourcesWindow(game).setVisible(true);
            }
        });
    }


    // <editor-fold desc="Variables">
    // Variables declaration - do not modify
    private javax.swing.JButton cancelButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField resourceTextField;
    private javax.swing.JButton okButton1;
    // </editor-fold>
}
