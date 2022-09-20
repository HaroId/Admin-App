
package com.login;

import java.awt.Color;

public class Login extends javax.swing.JFrame {
    
    int xMouse,yMouse;
    
    public Login() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        bg = new javax.swing.JPanel();
        x = new javax.swing.JLabel();
        logoname = new javax.swing.JLabel();
        h = new javax.swing.JLabel();
        logoname1 = new javax.swing.JLabel();
        logofondo = new javax.swing.JLabel();
        title = new javax.swing.JLabel();
        user = new javax.swing.JLabel();
        usertxt = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        password = new javax.swing.JLabel();
        passtxt = new javax.swing.JPasswordField();
        loginbtn = new javax.swing.JPanel();
        loginbtntxt = new javax.swing.JLabel();
        header = new javax.swing.JPanel();
        closebtn = new javax.swing.JPanel();
        closebtntxt = new javax.swing.JLabel();
        regbtn = new javax.swing.JPanel();
        regbtntxt = new javax.swing.JLabel();
        forgotbtn = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setAlwaysOnTop(true);
        setBounds(new java.awt.Rectangle(0, 0, 800, 500));
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setUndecorated(true);
        setPreferredSize(new java.awt.Dimension(800, 500));
        setResizable(false);

        bg.setBackground(new java.awt.Color(255, 255, 255));
        bg.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        bg.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        x.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        x.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/images/x (1).png"))); // NOI18N
        bg.add(x, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 110, 240, 140));

        logoname.setFont(new java.awt.Font("Roboto Medium", 0, 18)); // NOI18N
        logoname.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        logoname.setText("ADMIN");
        bg.add(logoname, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 230, 270, 50));

        h.setFont(new java.awt.Font("Roboto", 0, 24)); // NOI18N
        h.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        h.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/images/tr.png"))); // NOI18N
        bg.add(h, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 60, 100, 90));

        logoname1.setFont(new java.awt.Font("Roboto Medium", 0, 18)); // NOI18N
        logoname1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        logoname1.setText("DMIN");
        bg.add(logoname1, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 110, 70, 40));

        logofondo.setBackground(new java.awt.Color(0, 0, 0));
        logofondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/images/1.gif"))); // NOI18N
        bg.add(logofondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 0, 270, 520));

        title.setFont(new java.awt.Font("Roboto Medium", 1, 24)); // NOI18N
        title.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        title.setText("INICIAR SESIÓN");
        bg.add(title, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 170, 290, 30));

        user.setFont(new java.awt.Font("Roboto Light", 1, 14)); // NOI18N
        user.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        user.setText("USUARIO");
        bg.add(user, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 230, 110, 30));

        usertxt.setForeground(new java.awt.Color(102, 102, 102));
        usertxt.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        usertxt.setText("Ingrese su nombre de usuario");
        usertxt.setBorder(null);
        usertxt.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                usertxtMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                usertxtMouseEntered(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                usertxtMousePressed(evt);
            }
        });
        usertxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                usertxtActionPerformed(evt);
            }
        });
        bg.add(usertxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 260, 370, 30));
        bg.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 290, 380, 10));
        bg.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 380, 380, 10));

        password.setFont(new java.awt.Font("Roboto Light", 1, 14)); // NOI18N
        password.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        password.setText("CONTRASEÑA");
        bg.add(password, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 320, 110, 30));

        passtxt.setFont(new java.awt.Font("Tahoma", 0, 11)); // NOI18N
        passtxt.setForeground(new java.awt.Color(102, 102, 102));
        passtxt.setText("**********");
        passtxt.setBorder(null);
        passtxt.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                passtxtMousePressed(evt);
            }
        });
        passtxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                passtxtActionPerformed(evt);
            }
        });
        bg.add(passtxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 350, 380, 30));

        loginbtn.setBackground(new java.awt.Color(0, 255, 255));

        loginbtntxt.setFont(new java.awt.Font("Roboto Condensed", 1, 14)); // NOI18N
        loginbtntxt.setForeground(new java.awt.Color(255, 255, 255));
        loginbtntxt.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        loginbtntxt.setText("ENTRAR");
        loginbtntxt.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        loginbtntxt.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                loginbtntxtMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                loginbtntxtMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                loginbtntxtMouseExited(evt);
            }
        });

        javax.swing.GroupLayout loginbtnLayout = new javax.swing.GroupLayout(loginbtn);
        loginbtn.setLayout(loginbtnLayout);
        loginbtnLayout.setHorizontalGroup(
            loginbtnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(loginbtntxt, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        loginbtnLayout.setVerticalGroup(
            loginbtnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(loginbtntxt, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        bg.add(loginbtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 420, 110, 30));

        header.setBackground(new java.awt.Color(255, 255, 255));
        header.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                headerMouseDragged(evt);
            }
        });
        header.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                headerMousePressed(evt);
            }
        });

        closebtn.setBackground(new java.awt.Color(255, 255, 255));

        closebtntxt.setBackground(new java.awt.Color(255, 255, 255));
        closebtntxt.setFont(new java.awt.Font("Lato", 0, 18)); // NOI18N
        closebtntxt.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        closebtntxt.setText("X");
        closebtntxt.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        closebtntxt.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                closebtntxtMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                closebtntxtMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                closebtntxtMouseExited(evt);
            }
        });

        javax.swing.GroupLayout closebtnLayout = new javax.swing.GroupLayout(closebtn);
        closebtn.setLayout(closebtnLayout);
        closebtnLayout.setHorizontalGroup(
            closebtnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(closebtnLayout.createSequentialGroup()
                .addComponent(closebtntxt, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        closebtnLayout.setVerticalGroup(
            closebtnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, closebtnLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(closebtntxt, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout headerLayout = new javax.swing.GroupLayout(header);
        header.setLayout(headerLayout);
        headerLayout.setHorizontalGroup(
            headerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(headerLayout.createSequentialGroup()
                .addComponent(closebtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        headerLayout.setVerticalGroup(
            headerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(closebtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        bg.add(header, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 800, 40));

        regbtn.setBackground(new java.awt.Color(0, 255, 255));

        regbtntxt.setFont(new java.awt.Font("Roboto Condensed", 1, 14)); // NOI18N
        regbtntxt.setForeground(new java.awt.Color(255, 255, 255));
        regbtntxt.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        regbtntxt.setText("REGISTRARME");
        regbtntxt.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        regbtntxt.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                regbtntxtMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                regbtntxtMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                regbtntxtMouseExited(evt);
            }
        });

        javax.swing.GroupLayout regbtnLayout = new javax.swing.GroupLayout(regbtn);
        regbtn.setLayout(regbtnLayout);
        regbtnLayout.setHorizontalGroup(
            regbtnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, regbtnLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(regbtntxt, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        regbtnLayout.setVerticalGroup(
            regbtnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, regbtnLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(regbtntxt, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        bg.add(regbtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 420, -1, 30));

        forgotbtn.setForeground(new java.awt.Color(102, 102, 102));
        forgotbtn.setText("Olvidaste tu contraseña?");
        forgotbtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        forgotbtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                forgotbtnMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                forgotbtnMouseExited(evt);
            }
        });
        bg.add(forgotbtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 460, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(bg, javax.swing.GroupLayout.PREFERRED_SIZE, 800, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bg, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void usertxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_usertxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_usertxtActionPerformed

    private void passtxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_passtxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_passtxtActionPerformed

    private void headerMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_headerMousePressed
        xMouse = evt.getX();
        yMouse = evt.getY();
    }//GEN-LAST:event_headerMousePressed

    private void headerMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_headerMouseDragged
        int x = evt.getXOnScreen();
        int y = evt.getYOnScreen();
        this.setLocation(x - xMouse,y - yMouse);
    }//GEN-LAST:event_headerMouseDragged

    private void closebtntxtMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_closebtntxtMouseClicked
        System.exit(0);
    }//GEN-LAST:event_closebtntxtMouseClicked

    private void closebtntxtMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_closebtntxtMouseEntered
        closebtn.setBackground(Color.red);
        closebtntxt.setForeground(Color.white);
    }//GEN-LAST:event_closebtntxtMouseEntered

    private void closebtntxtMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_closebtntxtMouseExited
        closebtn.setBackground(Color.white);
        closebtntxt.setForeground(Color.black);
    }//GEN-LAST:event_closebtntxtMouseExited

    private void loginbtntxtMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_loginbtntxtMouseEntered
        loginbtn.setBackground(new Color(0,230,230));
    }//GEN-LAST:event_loginbtntxtMouseEntered

    private void loginbtntxtMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_loginbtntxtMouseExited
        loginbtn.setBackground(Color.CYAN);
    }//GEN-LAST:event_loginbtntxtMouseExited

    private void usertxtMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_usertxtMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_usertxtMouseEntered

    private void usertxtMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_usertxtMouseClicked
        
    }//GEN-LAST:event_usertxtMouseClicked

    private void usertxtMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_usertxtMousePressed
        if(usertxt.getText().equals("Ingrese su nombre de usuario")){
            usertxt.setText("");
            usertxt.setForeground(Color.black);
        }
        
        if (String.valueOf(passtxt.getPassword()).isEmpty()){
            passtxt.setText("**********");
            passtxt.setForeground(Color.gray);
        }
        

    }//GEN-LAST:event_usertxtMousePressed

    private void passtxtMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_passtxtMousePressed
                
        if (String.valueOf(passtxt.getPassword()).equals("**********")){
            passtxt.setText("");
            passtxt.setForeground(Color.black);
        }
        
        if(usertxt.getText().isEmpty()){
            usertxt.setText("Ingrese su nombre de usuario");
            usertxt.setForeground(Color.gray);
        }


    }//GEN-LAST:event_passtxtMousePressed

    private void loginbtntxtMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_loginbtntxtMouseClicked
        javax.swing.JOptionPane.showMessageDialog(this, "Intento de login con los datos:\nUsuario: "+ usertxt.getText()+"\nContraseña: "+String.valueOf(passtxt.getPassword()), "LOGIN", HEIGHT);
    }//GEN-LAST:event_loginbtntxtMouseClicked

    private void regbtntxtMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_regbtntxtMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_regbtntxtMouseClicked

    private void regbtntxtMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_regbtntxtMouseEntered
         regbtn.setBackground(new Color(0,230,230));
    }//GEN-LAST:event_regbtntxtMouseEntered

    private void regbtntxtMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_regbtntxtMouseExited
         regbtn.setBackground(Color.cyan);
    }//GEN-LAST:event_regbtntxtMouseExited

    private void forgotbtnMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_forgotbtnMouseEntered
        forgotbtn.setForeground(Color.cyan);
    }//GEN-LAST:event_forgotbtnMouseEntered

    private void forgotbtnMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_forgotbtnMouseExited
        forgotbtn.setForeground(Color.gray);
    }//GEN-LAST:event_forgotbtnMouseExited

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
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
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Login().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel bg;
    private javax.swing.JPanel closebtn;
    private javax.swing.JLabel closebtntxt;
    private javax.swing.JLabel forgotbtn;
    private javax.swing.JLabel h;
    private javax.swing.JPanel header;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JPanel loginbtn;
    private javax.swing.JLabel loginbtntxt;
    private javax.swing.JLabel logofondo;
    private javax.swing.JLabel logoname;
    private javax.swing.JLabel logoname1;
    private javax.swing.JPasswordField passtxt;
    private javax.swing.JLabel password;
    private javax.swing.JPanel regbtn;
    private javax.swing.JLabel regbtntxt;
    private javax.swing.JLabel title;
    private javax.swing.JLabel user;
    private javax.swing.JTextField usertxt;
    private javax.swing.JLabel x;
    // End of variables declaration//GEN-END:variables
}
