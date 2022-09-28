/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.register;
import com.login.Login;
import com.register.conexion.Conexion;
import java.awt.Color;
import java.util.Arrays;
import java.text.SimpleDateFormat;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

/**
 *
 * @author harol
 */
public class Register extends javax.swing.JFrame {

    int xMouse1, yMouse1;
    char sex = 'd';
    String fecha;
    
    
    
    
    
    
    
    
    
    
    /**
     * Creates new form Register
     */
    public Register() {
        initComponents();
        ocultarerror();

    }
    
    
    
    
    
    
    
    
    public static void before(JTextField textInput, String text,JLabel error) {
         if (textInput.getText().isEmpty()) {
            textInput.setText(text);
            textInput.setForeground(Color.gray);
            error.setVisible(false);
        }
    }
    
    public static void beforepass(JPasswordField textInput) {
        if (String.valueOf(textInput.getPassword()).isEmpty()) {
            textInput.setText("**********");
            textInput.setForeground(Color.gray);
        }

    }
    
    public static void runbefore(JTextField textImput,String Text){
        if (textImput.getText().equals(Text)) {
            textImput.setText("");
            textImput.setForeground(Color.black);
        }
    }
    
    public static void verificarError(JTextField textinput,String text,JLabel error){
        if(verficarUsuario(textinput.getText())){
            textinput.setForeground(Color.black);
            error.setVisible(false);
        }
        else{
            textinput.setForeground(Color.red);
            error.setVisible(true);
        }
    }
    
    public static void verificarNombre(JTextField textinput,String text,JLabel error){
        if(verficarNombres(textinput.getText())){
            textinput.setForeground(Color.black);
            error.setVisible(false);
        }
        else{
            textinput.setForeground(Color.red);
            error.setVisible(true);
        }
    }
    
    public static void verificarMail(JTextField textinput,String text,JLabel error){
        if(verficarMail(textinput.getText())){
            textinput.setForeground(Color.black);
            error.setVisible(false);
        }
        else{
            textinput.setForeground(Color.red);
            error.setVisible(true);
        }
    }
    
    public void ocultarerror(){
        nameError.setVisible(false);
        userError.setVisible(false);
        lnameError.setVisible(false);
        mailerror.setVisible(false);
        dateError.setVisible(false);
        sexerror.setVisible(false);
        usernodisponible.setVisible(false);
    }   
    
    public void verificacionFinal(){
        boolean completo = true;
        
        ////////////////////////////////////////////////////////////////////////
        
        fecha = new SimpleDateFormat("yyyy/MM/dd").format(nacimientodata.getDate());
        String[] dateparts = fecha.split("/");
        String año = dateparts[0],
               mes = dateparts[1],
               dia = dateparts[2];
        
        
        String fechaGuardar = año+"/"+mes+"/"+dia;
        String año_actual = Date_Register.fecha_actual();
        
        LocalDate fecha_actual = LocalDate.now();
        final DateTimeFormatter dtf = DateTimeFormatter.ofPattern("uuuu/MM/dd", Locale.ENGLISH);
        String output = dtf.format(fecha_actual);
        
        int edad;
        
        edad = Integer.parseInt(año_actual) - Integer.parseInt(año);
        if (edad <= 12) {
            dateError.setVisible(true);
            JOptionPane.showMessageDialog(null, "La fecha de nacimiento\n     es muy actual.");
            completo = false;
        }else if(edad > 80){
            dateError.setVisible(true);
            JOptionPane.showMessageDialog(null, "La fecha de nacimiento\n es demasiado antigua.");
            completo = false;
        }
        
        ////////////////////////////////////////////////////////////////////////
        
        if(userError.isShowing() == true || usernametxt.getText().isEmpty()){
            completo = false;
            JOptionPane.showMessageDialog(null, "                Ingrese el usuario\n"
                    + "valide que el usuario no contenga simbolos");
        }else if(sex == 'd'){
            sexerror.setVisible(true);
            completo = false;
             JOptionPane.showMessageDialog(null, "Ingrese el gendero");
        }else if(nameError.isShowing() == true || nametxt.getText().isEmpty()){
            completo = false;
             JOptionPane.showMessageDialog(null, "                 Ingrese el nombre\n"
                     + "valide que el nombre no tenga numeros o simbolos.");
        }else if(lnameError.isShowing() == true || lastnametxt.getText().isEmpty()){
            completo = false;
            JOptionPane.showMessageDialog(null, "                  Ingrese el apellido\n"
                     + "valide que el apellido no tenga numeros o simbolos.");
        }else if(mailerror.isShowing() == true || mailtxt.getText().isEmpty()){
            completo = false;
        }else if(termcb.isSelected() == false){
            termcb.setForeground(Color.red);
            completo = false;
        }else if(Arrays.equals(passtxt.getPassword(), vpasstxt.getPassword()) == false){
            JOptionPane.showMessageDialog(null, "Verifica las contraseñas por favor.");
            completo = false;
        }else if((verificaraPass(passtxt) == false)||(verificaraPass(vpasstxt) == false)){
            JOptionPane.showMessageDialog(null, "La contraseña/s es menor de 6 digitos");
            completo = false;
        }else if(usernodisponible.isVisible()){
            completo = false;
        }
        ////////////////////////////////////////////////////////////////////////
        if (edad > 12) {
            dateError.setVisible(false);
        }
        if(termcb.isSelected()){
            termcb.setForeground(Color.black);
        }
        ////////////////////////////////////////////////////////////////////////
        
//        System.out.println(completo);
        
        String s = new String(passtxt.getPassword());
        
        if(completo == true){
            int input = JOptionPane.showConfirmDialog(null, "CONFIRMAR REGISTRO:"
                    + "\nUsuario: "+usernametxt.getText()
                    + "\nNombre/s: "+nametxt.getText()
                    + "\nApellido/s "+lastnametxt.getText()
                    + "\nGenero: " +sex
                    + "\nCorreo: "+mailtxt.getText()
                    + "\nFecha Nacimiento: "+dia+"/"+mes+"/"+año);
            
            if(input == 0){
                
                
                
                Conexion conn = new Conexion("user_db");
                conn.connect();
                
                String query = "INSERT INTO `user` (`user`, `name`, `last_name`, `gender`, `email`, `birthday`, `registerdate`,"
                        + " `password`) VALUES ('"+usernametxt.getText()+"', '"+nametxt.getText()+"', '"+lastnametxt.getText()
                        +"', '"+sex+"', '"+mailtxt.getText()+"', '"+fechaGuardar+"', '"+output+"', '"+s+"')";
                conn.stament(query);
                
                
                Login a = new Login();
                
                JOptionPane.showMessageDialog(null, "Usuario registrado exitosamente\n"
                    + "   Click en Ok para continuar.");
                
                a.setVisible(true);
                dispose();
                
                
            }
            
        }
        
    }
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        bg = new javax.swing.JPanel();
        cyan = new javax.swing.JLabel();
        mailerror = new javax.swing.JLabel();
        sexerror = new javax.swing.JLabel();
        lnameError = new javax.swing.JLabel();
        dateError = new javax.swing.JLabel();
        userError = new javax.swing.JLabel();
        nameError = new javax.swing.JLabel();
        titilename = new javax.swing.JLabel();
        nametxt = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        titilelastname = new javax.swing.JLabel();
        lastnametxt = new javax.swing.JTextField();
        jSeparator3 = new javax.swing.JSeparator();
        titleusername = new javax.swing.JLabel();
        usernametxt = new javax.swing.JTextField();
        titilepass = new javax.swing.JLabel();
        logoname1 = new javax.swing.JLabel();
        jSeparator4 = new javax.swing.JSeparator();
        jSeparator5 = new javax.swing.JSeparator();
        titlevpass = new javax.swing.JLabel();
        favicon = new javax.swing.JLabel();
        header1 = new javax.swing.JPanel();
        closebtn1 = new javax.swing.JPanel();
        closebtn1txt = new javax.swing.JLabel();
        titileMail = new javax.swing.JLabel();
        mailtxt = new javax.swing.JTextField();
        jSeparator6 = new javax.swing.JSeparator();
        nacimientotitle = new javax.swing.JLabel();
        title = new javax.swing.JLabel();
        gendertitle = new javax.swing.JLabel();
        gendermbtn = new javax.swing.JPanel();
        gendermbtntxt = new javax.swing.JLabel();
        genderfbtn = new javax.swing.JPanel();
        genderfbtntxt = new javax.swing.JLabel();
        volverbtn = new javax.swing.JPanel();
        volverbtntxt = new javax.swing.JLabel();
        registerbtn = new javax.swing.JPanel();
        registerbtntxt = new javax.swing.JLabel();
        termcb = new javax.swing.JCheckBox();
        questionbtn = new javax.swing.JPanel();
        questionbtntxt = new javax.swing.JLabel();
        passtxt = new javax.swing.JPasswordField();
        vpasstxt = new javax.swing.JPasswordField();
        usernodisponible = new javax.swing.JLabel();
        nacimientodata = new com.toedter.calendar.JDateChooser();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBounds(new java.awt.Rectangle(0, 0, 800, 500));
        setUndecorated(true);
        setResizable(false);

        bg.setBackground(new java.awt.Color(255, 255, 255));
        bg.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        cyan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/images/cyan.gif"))); // NOI18N
        cyan.setText("jLabel1");
        bg.add(cyan, new org.netbeans.lib.awtextra.AbsoluteConstraints(-140, 0, 360, 500));

        mailerror.setFont(new java.awt.Font("Roboto Light", 0, 10)); // NOI18N
        mailerror.setForeground(new java.awt.Color(255, 0, 0));
        mailerror.setText("*Verifique el correo electronico");
        bg.add(mailerror, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 400, 140, 20));

        sexerror.setFont(new java.awt.Font("Roboto Light", 0, 10)); // NOI18N
        sexerror.setForeground(new java.awt.Color(255, 0, 0));
        sexerror.setText("*Verifique el genero");
        bg.add(sexerror, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 180, 90, 20));

        lnameError.setFont(new java.awt.Font("Roboto Light", 0, 10)); // NOI18N
        lnameError.setForeground(new java.awt.Color(255, 0, 0));
        lnameError.setText("*Verifique el apellido/s");
        bg.add(lnameError, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 250, 110, 20));

        dateError.setFont(new java.awt.Font("Roboto Light", 0, 10)); // NOI18N
        dateError.setForeground(new java.awt.Color(255, 0, 0));
        dateError.setText("*Verifique la fecha");
        bg.add(dateError, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 400, 90, 20));

        userError.setFont(new java.awt.Font("Roboto Light", 0, 10)); // NOI18N
        userError.setForeground(new java.awt.Color(255, 0, 0));
        userError.setText("*Verififique el usuario");
        bg.add(userError, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 180, 110, 20));

        nameError.setFont(new java.awt.Font("Roboto Light", 0, 10)); // NOI18N
        nameError.setForeground(new java.awt.Color(255, 0, 0));
        nameError.setText("*Verifique el nombre/s");
        bg.add(nameError, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 250, 110, 20));
        nameError.getAccessibleContext().setAccessibleName("*Verifique el nombre");

        titilename.setFont(new java.awt.Font("Roboto Light", 1, 14)); // NOI18N
        titilename.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        titilename.setText("NOMBRE");
        bg.add(titilename, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 190, 160, 30));

        nametxt.setForeground(new java.awt.Color(102, 102, 102));
        nametxt.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        nametxt.setText("Ingrese su nombre/s");
        nametxt.setBorder(null);
        nametxt.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                nametxtMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                nametxtMouseEntered(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                nametxtMousePressed(evt);
            }
        });
        nametxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nametxtActionPerformed(evt);
            }
        });
        nametxt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                nametxtKeyReleased(evt);
            }
        });
        bg.add(nametxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 220, 180, 30));
        bg.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 250, 180, 10));
        bg.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 250, 180, 10));

        titilelastname.setFont(new java.awt.Font("Roboto Light", 1, 14)); // NOI18N
        titilelastname.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        titilelastname.setText("APELLIDO");
        bg.add(titilelastname, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 190, 140, 30));

        lastnametxt.setForeground(new java.awt.Color(102, 102, 102));
        lastnametxt.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        lastnametxt.setText("Ingrese su apellido/s");
        lastnametxt.setBorder(null);
        lastnametxt.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lastnametxtMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lastnametxtMouseEntered(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                lastnametxtMousePressed(evt);
            }
        });
        lastnametxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lastnametxtActionPerformed(evt);
            }
        });
        lastnametxt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                lastnametxtKeyReleased(evt);
            }
        });
        bg.add(lastnametxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 220, 160, 30));
        bg.add(jSeparator3, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 180, 180, 10));

        titleusername.setFont(new java.awt.Font("Roboto Light", 1, 14)); // NOI18N
        titleusername.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        titleusername.setText("USUARIO");
        bg.add(titleusername, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 120, 110, 30));

        usernametxt.setForeground(new java.awt.Color(102, 102, 102));
        usernametxt.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        usernametxt.setText("Ingrese su nombre de usuario");
        usernametxt.setBorder(null);
        usernametxt.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                usernametxtMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                usernametxtMouseEntered(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                usernametxtMousePressed(evt);
            }
        });
        usernametxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                usernametxtActionPerformed(evt);
            }
        });
        usernametxt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                usernametxtKeyReleased(evt);
            }
        });
        bg.add(usernametxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 150, 180, 30));

        titilepass.setFont(new java.awt.Font("Roboto Light", 1, 14)); // NOI18N
        titilepass.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        titilepass.setText("CONTRASEÑA");
        bg.add(titilepass, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 270, 150, 30));

        logoname1.setFont(new java.awt.Font("Roboto Medium", 0, 18)); // NOI18N
        logoname1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        logoname1.setText("DMIN");
        bg.add(logoname1, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 60, 70, 40));
        bg.add(jSeparator4, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 330, 180, 10));
        bg.add(jSeparator5, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 330, 180, 10));

        titlevpass.setFont(new java.awt.Font("Roboto Light", 1, 14)); // NOI18N
        titlevpass.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        titlevpass.setText("VERIFICAR CONTRASEÑA");
        bg.add(titlevpass, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 270, 180, 30));

        favicon.setFont(new java.awt.Font("Roboto", 0, 24)); // NOI18N
        favicon.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        favicon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/images/tr.png"))); // NOI18N
        bg.add(favicon, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 10, -1, 90));

        header1.setBackground(new java.awt.Color(255, 255, 255));
        header1.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                header1MouseDragged(evt);
            }
        });
        header1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                header1MousePressed(evt);
            }
        });

        closebtn1.setBackground(new java.awt.Color(255, 255, 255));

        closebtn1txt.setBackground(new java.awt.Color(255, 255, 255));
        closebtn1txt.setFont(new java.awt.Font("Lato", 0, 18)); // NOI18N
        closebtn1txt.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        closebtn1txt.setText("X");
        closebtn1txt.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        closebtn1txt.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                closebtn1txtMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                closebtn1txtMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                closebtn1txtMouseExited(evt);
            }
        });

        javax.swing.GroupLayout closebtn1Layout = new javax.swing.GroupLayout(closebtn1);
        closebtn1.setLayout(closebtn1Layout);
        closebtn1Layout.setHorizontalGroup(
            closebtn1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, closebtn1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(closebtn1txt, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        closebtn1Layout.setVerticalGroup(
            closebtn1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, closebtn1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(closebtn1txt, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout header1Layout = new javax.swing.GroupLayout(header1);
        header1.setLayout(header1Layout);
        header1Layout.setHorizontalGroup(
            header1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, header1Layout.createSequentialGroup()
                .addGap(0, 783, Short.MAX_VALUE)
                .addComponent(closebtn1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        header1Layout.setVerticalGroup(
            header1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(header1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(closebtn1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        bg.add(header1, new org.netbeans.lib.awtextra.AbsoluteConstraints(-20, 0, 820, 40));

        titileMail.setFont(new java.awt.Font("Roboto Light", 1, 14)); // NOI18N
        titileMail.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        titileMail.setText("CORREO ELECTRONICO");
        bg.add(titileMail, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 340, 180, 30));

        mailtxt.setForeground(new java.awt.Color(102, 102, 102));
        mailtxt.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        mailtxt.setText("Ingrese su correo electronico");
        mailtxt.setBorder(null);
        mailtxt.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                mailtxtMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                mailtxtMouseEntered(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                mailtxtMousePressed(evt);
            }
        });
        mailtxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mailtxtActionPerformed(evt);
            }
        });
        mailtxt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                mailtxtKeyReleased(evt);
            }
        });
        bg.add(mailtxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 370, 180, 30));
        bg.add(jSeparator6, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 400, 180, 10));

        nacimientotitle.setFont(new java.awt.Font("Roboto Light", 1, 14)); // NOI18N
        nacimientotitle.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        nacimientotitle.setText("FECHA DE NACIMIENTO");
        bg.add(nacimientotitle, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 340, 170, 30));

        title.setFont(new java.awt.Font("Roboto Medium", 1, 24)); // NOI18N
        title.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        title.setText("REGISTRATE CON");
        bg.add(title, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 60, 290, 30));

        gendertitle.setFont(new java.awt.Font("Roboto Light", 1, 14)); // NOI18N
        gendertitle.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        gendertitle.setText("GENERO");
        bg.add(gendertitle, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 120, 160, 30));

        gendermbtn.setBackground(new java.awt.Color(0, 255, 255));
        gendermbtn.setForeground(new java.awt.Color(255, 255, 255));

        gendermbtntxt.setFont(new java.awt.Font("Roboto Condensed", 1, 12)); // NOI18N
        gendermbtntxt.setForeground(new java.awt.Color(255, 255, 255));
        gendermbtntxt.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        gendermbtntxt.setText("MASCULINO");
        gendermbtntxt.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        gendermbtntxt.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                gendermbtntxtMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                gendermbtntxtMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                gendermbtntxtMousePressed(evt);
            }
        });

        javax.swing.GroupLayout gendermbtnLayout = new javax.swing.GroupLayout(gendermbtn);
        gendermbtn.setLayout(gendermbtnLayout);
        gendermbtnLayout.setHorizontalGroup(
            gendermbtnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(gendermbtntxt, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        gendermbtnLayout.setVerticalGroup(
            gendermbtnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(gendermbtntxt, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
        );

        bg.add(gendermbtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 150, 80, 30));

        genderfbtn.setBackground(new java.awt.Color(0, 255, 255));

        genderfbtntxt.setFont(new java.awt.Font("Roboto Condensed", 1, 12)); // NOI18N
        genderfbtntxt.setForeground(new java.awt.Color(255, 255, 255));
        genderfbtntxt.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        genderfbtntxt.setText("FEMENINO");
        genderfbtntxt.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        genderfbtntxt.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                genderfbtntxtMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                genderfbtntxtMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                genderfbtntxtMousePressed(evt);
            }
        });

        javax.swing.GroupLayout genderfbtnLayout = new javax.swing.GroupLayout(genderfbtn);
        genderfbtn.setLayout(genderfbtnLayout);
        genderfbtnLayout.setHorizontalGroup(
            genderfbtnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(genderfbtntxt, javax.swing.GroupLayout.DEFAULT_SIZE, 80, Short.MAX_VALUE)
        );
        genderfbtnLayout.setVerticalGroup(
            genderfbtnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(genderfbtntxt, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
        );

        bg.add(genderfbtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 150, 80, -1));

        volverbtn.setBackground(new java.awt.Color(51, 255, 204));

        volverbtntxt.setFont(new java.awt.Font("Roboto Condensed", 1, 14)); // NOI18N
        volverbtntxt.setForeground(new java.awt.Color(255, 255, 255));
        volverbtntxt.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        volverbtntxt.setText("VOLVER");
        volverbtntxt.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        volverbtntxt.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                volverbtntxtMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                volverbtntxtMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                volverbtntxtMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                volverbtntxtMousePressed(evt);
            }
        });

        javax.swing.GroupLayout volverbtnLayout = new javax.swing.GroupLayout(volverbtn);
        volverbtn.setLayout(volverbtnLayout);
        volverbtnLayout.setHorizontalGroup(
            volverbtnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, volverbtnLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(volverbtntxt, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        volverbtnLayout.setVerticalGroup(
            volverbtnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, volverbtnLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(volverbtntxt, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        bg.add(volverbtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 450, 180, -1));

        registerbtn.setBackground(new java.awt.Color(51, 255, 204));

        registerbtntxt.setFont(new java.awt.Font("Roboto Condensed", 1, 14)); // NOI18N
        registerbtntxt.setForeground(new java.awt.Color(255, 255, 255));
        registerbtntxt.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        registerbtntxt.setText("REGISTRARSE");
        registerbtntxt.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        registerbtntxt.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                registerbtntxtMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                registerbtntxtMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                registerbtntxtMouseExited(evt);
            }
        });

        javax.swing.GroupLayout registerbtnLayout = new javax.swing.GroupLayout(registerbtn);
        registerbtn.setLayout(registerbtnLayout);
        registerbtnLayout.setHorizontalGroup(
            registerbtnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, registerbtnLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(registerbtntxt, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        registerbtnLayout.setVerticalGroup(
            registerbtnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, registerbtnLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(registerbtntxt, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        bg.add(registerbtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 450, -1, -1));

        termcb.setText("He leído y acepto los términos y condiciones de Admin.");
        termcb.setToolTipText("");
        termcb.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        termcb.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                termcbMouseEntered(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                termcbMousePressed(evt);
            }
        });
        termcb.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                termcbActionPerformed(evt);
            }
        });
        bg.add(termcb, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 420, -1, -1));

        questionbtn.setBackground(new java.awt.Color(153, 153, 153));

        questionbtntxt.setFont(new java.awt.Font("Roboto Condensed", 1, 14)); // NOI18N
        questionbtntxt.setForeground(new java.awt.Color(255, 255, 255));
        questionbtntxt.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        questionbtntxt.setText("?");
        questionbtntxt.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        questionbtntxt.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                questionbtntxtMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                questionbtntxtMouseExited(evt);
            }
        });

        javax.swing.GroupLayout questionbtnLayout = new javax.swing.GroupLayout(questionbtn);
        questionbtn.setLayout(questionbtnLayout);
        questionbtnLayout.setHorizontalGroup(
            questionbtnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, questionbtnLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(questionbtntxt, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        questionbtnLayout.setVerticalGroup(
            questionbtnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, questionbtnLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(questionbtntxt, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        bg.add(questionbtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 420, 20, 20));

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
        passtxt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                passtxtKeyReleased(evt);
            }
        });
        bg.add(passtxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 300, 180, 30));

        vpasstxt.setFont(new java.awt.Font("Tahoma", 0, 11)); // NOI18N
        vpasstxt.setForeground(new java.awt.Color(102, 102, 102));
        vpasstxt.setText("**********");
        vpasstxt.setBorder(null);
        vpasstxt.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                vpasstxtMousePressed(evt);
            }
        });
        vpasstxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                vpasstxtActionPerformed(evt);
            }
        });
        vpasstxt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                vpasstxtKeyReleased(evt);
            }
        });
        bg.add(vpasstxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 300, 180, 30));

        usernodisponible.setFont(new java.awt.Font("Roboto Light", 0, 10)); // NOI18N
        usernodisponible.setForeground(new java.awt.Color(255, 0, 0));
        usernodisponible.setText("*Usuario no disponible");
        bg.add(usernodisponible, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 130, 120, -1));
        bg.add(nacimientodata, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 370, 180, 30));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bg, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void nametxtMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_nametxtMouseClicked

    }//GEN-LAST:event_nametxtMouseClicked

    private void nametxtMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_nametxtMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_nametxtMouseEntered

    private void nametxtMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_nametxtMousePressed
        runbefore(nametxt,"Ingrese su nombre/s");
        before(usernametxt, "Ingrese su nombre de usuario",userError);
        before(mailtxt, "Ingrese su correo electronico",mailerror);
        before(lastnametxt, "Ingrese su apellido/s",lnameError);
        beforepass(passtxt);
        beforepass(vpasstxt);
        dateError.setVisible(false);
        sexerror.setVisible(false);
    }//GEN-LAST:event_nametxtMousePressed

    private void nametxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nametxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nametxtActionPerformed

    private void lastnametxtMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lastnametxtMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_lastnametxtMouseClicked

    private void lastnametxtMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lastnametxtMouseEntered

    }//GEN-LAST:event_lastnametxtMouseEntered

    private void lastnametxtMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lastnametxtMousePressed
        runbefore(lastnametxt,"Ingrese su apellido/s");
        before(usernametxt,"Ingrese su nombre de usuario",userError);
        before(nametxt,"Ingrese su nombre/s",nameError);
        before(mailtxt,"Ingrese su correo electronico",mailerror);
        beforepass(passtxt);
        beforepass(vpasstxt);
        dateError.setVisible(false);
        sexerror.setVisible(false);
    }//GEN-LAST:event_lastnametxtMousePressed

    private void lastnametxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lastnametxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_lastnametxtActionPerformed

    private void usernametxtMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_usernametxtMouseClicked
//        Conexion conn = new Conexion("user_db");
//        conn.connect();
//        
//        conn.verificar(usernametxt.getText(), usernodisponible);
    }//GEN-LAST:event_usernametxtMouseClicked

    private void usernametxtMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_usernametxtMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_usernametxtMouseEntered

    private void usernametxtMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_usernametxtMousePressed
        runbefore(usernametxt,"Ingrese su nombre de usuario");
        before(nametxt, "Ingrese su nombre/s",nameError);
        before(lastnametxt,"Ingrese su apellido/s",lnameError);
        before(mailtxt,"Ingrese su correo electronico",mailerror);
        beforepass(passtxt);
        beforepass(vpasstxt);
        dateError.setVisible(false);
        sexerror.setVisible(false);
    }//GEN-LAST:event_usernametxtMousePressed

    private void usernametxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_usernametxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_usernametxtActionPerformed

    private void closebtn1txtMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_closebtn1txtMouseClicked
        System.exit(0);
    }//GEN-LAST:event_closebtn1txtMouseClicked

    private void closebtn1txtMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_closebtn1txtMouseEntered
        closebtn1.setBackground(Color.red);
        closebtn1txt.setForeground(Color.white);
    }//GEN-LAST:event_closebtn1txtMouseEntered

    private void closebtn1txtMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_closebtn1txtMouseExited
        closebtn1.setBackground(Color.white);
        closebtn1txt.setForeground(Color.black);
    }//GEN-LAST:event_closebtn1txtMouseExited

    private void header1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_header1MousePressed
        xMouse1 = evt.getX();
        yMouse1 = evt.getY();
    }//GEN-LAST:event_header1MousePressed

    private void header1MouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_header1MouseDragged
        int x = evt.getXOnScreen();
        int y = evt.getYOnScreen();
        this.setLocation(x - xMouse1, y - yMouse1);
    }//GEN-LAST:event_header1MouseDragged

    private void mailtxtMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_mailtxtMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_mailtxtMouseClicked

    private void mailtxtMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_mailtxtMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_mailtxtMouseEntered

    private void mailtxtMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_mailtxtMousePressed
        runbefore(mailtxt,"Ingrese su correo electronico");
        before(usernametxt,"Ingrese su nombre de usuario",userError);
        before(nametxt, "Ingrese su nombre/s",nameError);
        before(lastnametxt,"Ingrese su apellido/s",lnameError);
        beforepass(passtxt);
        beforepass(vpasstxt);
        dateError.setVisible(false);
        sexerror.setVisible(false);
    }//GEN-LAST:event_mailtxtMousePressed

    private void mailtxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mailtxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_mailtxtActionPerformed

    private void termcbActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_termcbActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_termcbActionPerformed

    private void gendermbtntxtMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_gendermbtntxtMouseEntered
        gendermbtn.setBackground(new Color(0, 230, 230));
    }//GEN-LAST:event_gendermbtntxtMouseEntered

    private void gendermbtntxtMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_gendermbtntxtMouseExited
        
        if (sex == 'f' || sex == 'd') {
            gendermbtn.setBackground(Color.cyan);
        }
    }//GEN-LAST:event_gendermbtntxtMouseExited

    private void genderfbtntxtMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_genderfbtntxtMouseEntered
        genderfbtn.setBackground(new Color(0, 230, 230));
    }//GEN-LAST:event_genderfbtntxtMouseEntered

    private void genderfbtntxtMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_genderfbtntxtMouseExited
        
        if (sex == 'm' || sex == 'd') {
            genderfbtn.setBackground(Color.cyan);
        }
    }//GEN-LAST:event_genderfbtntxtMouseExited

    private void registerbtntxtMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_registerbtntxtMouseEntered
        registerbtn.setBackground(new Color(0, 230, 230));
    }//GEN-LAST:event_registerbtntxtMouseEntered

    private void registerbtntxtMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_registerbtntxtMouseExited
        registerbtn.setBackground(Color.cyan);
    }//GEN-LAST:event_registerbtntxtMouseExited

    private void volverbtntxtMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_volverbtntxtMouseEntered
        volverbtn.setBackground(new Color(0, 230, 230));
    }//GEN-LAST:event_volverbtntxtMouseEntered

    private void volverbtntxtMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_volverbtntxtMouseExited
        volverbtn.setBackground(Color.cyan);
    }//GEN-LAST:event_volverbtntxtMouseExited

    private void questionbtntxtMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_questionbtntxtMouseEntered
        questionbtn.setBackground(new Color(0, 230, 230));
    }//GEN-LAST:event_questionbtntxtMouseEntered

    private void questionbtntxtMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_questionbtntxtMouseExited
        questionbtn.setBackground(Color.gray);
    }//GEN-LAST:event_questionbtntxtMouseExited

    private void gendermbtntxtMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_gendermbtntxtMousePressed
        sex = 'm';
        gendermbtn.setBackground(new Color(0, 230, 230));
        genderfbtn.setBackground(Color.cyan);
        
        before(mailtxt,"Ingrese su correo electronico",mailerror);
        before(usernametxt,"Ingrese su nombre de usuario",userError);
        before(nametxt, "Ingrese su nombre/s",nameError);
        before(lastnametxt,"Ingrese su apellido/s",lnameError);
        beforepass(passtxt);
        beforepass(vpasstxt);
        dateError.setVisible(false);
        sexerror.setVisible(false);
    }//GEN-LAST:event_gendermbtntxtMousePressed

    private void genderfbtntxtMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_genderfbtntxtMousePressed
        sex = 'f';
        genderfbtn.setBackground(new Color(0, 230, 230));
        gendermbtn.setBackground(Color.cyan);

        before(mailtxt,"Ingrese su correo electronico",mailerror);
        before(usernametxt,"Ingrese su nombre de usuario",userError);
        before(nametxt, "Ingrese su nombre/s",nameError);
        before(lastnametxt,"Ingrese su apellido/s",lnameError);
        beforepass(passtxt);
        beforepass(vpasstxt);
        dateError.setVisible(false);
        sexerror.setVisible(false);
    }//GEN-LAST:event_genderfbtntxtMousePressed

    private void passtxtMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_passtxtMousePressed

        if (String.valueOf(passtxt.getPassword()).equals("**********")) {
            passtxt.setText("");
            passtxt.setForeground(Color.black);
        }
        
        before(mailtxt,"Ingrese su correo electronico",mailerror);
        before(usernametxt,"Ingrese su nombre de usuario",userError);
        before(nametxt, "Ingrese su nombre/s",nameError);
        before(lastnametxt,"Ingrese su apellido/s",lnameError);
        beforepass(vpasstxt);
        dateError.setVisible(false);
        sexerror.setVisible(false);
    }//GEN-LAST:event_passtxtMousePressed

    private void passtxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_passtxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_passtxtActionPerformed

    private void vpasstxtMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_vpasstxtMousePressed

        if (String.valueOf(vpasstxt.getPassword()).equals("**********")) {
            vpasstxt.setText("");
            vpasstxt.setForeground(Color.black);
        }

        before(mailtxt,"Ingrese su correo electronico",mailerror);
        before(usernametxt,"Ingrese su nombre de usuario",userError);
        before(nametxt, "Ingrese su nombre/s",nameError);
        before(lastnametxt,"Ingrese su apellido/s",lnameError);
        beforepass(passtxt);
        dateError.setVisible(false);
        sexerror.setVisible(false);
    }//GEN-LAST:event_vpasstxtMousePressed

    private void vpasstxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_vpasstxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_vpasstxtActionPerformed

    private void termcbMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_termcbMousePressed

    }//GEN-LAST:event_termcbMousePressed

    private void volverbtntxtMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_volverbtntxtMouseClicked
//        Login a = new Login();
//        a.setVisible(true);
//        dispose();
    }//GEN-LAST:event_volverbtntxtMouseClicked

    private void volverbtntxtMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_volverbtntxtMousePressed
        Login a = new Login();
        a.setVisible(true);
        dispose();
    }//GEN-LAST:event_volverbtntxtMousePressed

    private void usernametxtKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_usernametxtKeyReleased
        verificarError(usernametxt, "Ingrese su nombre de usuario", userError);
    }//GEN-LAST:event_usernametxtKeyReleased

    private void nametxtKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_nametxtKeyReleased
        verificarNombre(nametxt,"Ingrese su nombre/s", nameError);
    }//GEN-LAST:event_nametxtKeyReleased

    private void lastnametxtKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_lastnametxtKeyReleased
        verificarNombre(lastnametxt,"Ingrese su nombre/s", lnameError);
    }//GEN-LAST:event_lastnametxtKeyReleased

    private void mailtxtKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_mailtxtKeyReleased
        verificarMail(mailtxt, "Ingrese su correo electronico", mailerror);
    }//GEN-LAST:event_mailtxtKeyReleased

    private void registerbtntxtMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_registerbtntxtMouseClicked
        Conexion conn = new Conexion("user_db");
        conn.connect();
        conn.verificar(usernametxt.getText(), usernodisponible);
        
        verificacionFinal();
    }//GEN-LAST:event_registerbtntxtMouseClicked

    private void passtxtKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_passtxtKeyReleased
        if(verificaraPass(passtxt) == false){
            passtxt.setForeground(Color.red);
        }else{
            passtxt.setForeground(Color.black);
        }
    }//GEN-LAST:event_passtxtKeyReleased

    private void vpasstxtKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_vpasstxtKeyReleased
        if(verificaraPass(vpasstxt) == false){
            vpasstxt.setForeground(Color.red);
        }else{
            vpasstxt.setForeground(Color.black);
        }
    }//GEN-LAST:event_vpasstxtKeyReleased

    private void termcbMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_termcbMouseEntered

    }//GEN-LAST:event_termcbMouseEntered

    public static boolean verificaraPass(JPasswordField pass){
        char passArray[] = pass.getPassword();
        if(passArray.length < 6){
            return false;
        }else{
            return true;
        }
    }
    
    public static boolean verficarMail(String usuario){
        String regex = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
                        + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
        Pattern errorUsuario = Pattern.compile(regex);
        
        Matcher mat = errorUsuario.matcher(usuario);
        
        return mat.find();
    }
    
    public static boolean verficarNombres(String usuario){
        String regex = "^[a-zA-Z_ ]{3,20}$";
        Pattern errorUsuario = Pattern.compile(regex);
        
        Matcher mat = errorUsuario.matcher(usuario);
        
        return mat.find();
    }
        
    public static boolean verficarUsuario(String usuario){
        String regex = "^[A-Za-z/s]\\w{3,20}$";
        Pattern errorUsuario = Pattern.compile(regex);
        
        Matcher mat = errorUsuario.matcher(usuario);
        
        return mat.find();
    }
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
            java.util.logging.Logger.getLogger(Register.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Register.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Register.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Register.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>


        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Register().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel bg;
    private javax.swing.JPanel closebtn1;
    private javax.swing.JLabel closebtn1txt;
    private javax.swing.JLabel cyan;
    private javax.swing.JLabel dateError;
    private javax.swing.JLabel favicon;
    private javax.swing.JPanel genderfbtn;
    private javax.swing.JLabel genderfbtntxt;
    private javax.swing.JPanel gendermbtn;
    private javax.swing.JLabel gendermbtntxt;
    private javax.swing.JLabel gendertitle;
    private javax.swing.JPanel header1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JSeparator jSeparator6;
    private javax.swing.JTextField lastnametxt;
    private javax.swing.JLabel lnameError;
    private javax.swing.JLabel logoname1;
    private javax.swing.JLabel mailerror;
    private javax.swing.JTextField mailtxt;
    private com.toedter.calendar.JDateChooser nacimientodata;
    private javax.swing.JLabel nacimientotitle;
    private javax.swing.JLabel nameError;
    private javax.swing.JTextField nametxt;
    private javax.swing.JPasswordField passtxt;
    private javax.swing.JPanel questionbtn;
    private javax.swing.JLabel questionbtntxt;
    private javax.swing.JPanel registerbtn;
    private javax.swing.JLabel registerbtntxt;
    private javax.swing.JLabel sexerror;
    private javax.swing.JCheckBox termcb;
    private javax.swing.JLabel titileMail;
    private javax.swing.JLabel titilelastname;
    private javax.swing.JLabel titilename;
    private javax.swing.JLabel titilepass;
    private javax.swing.JLabel title;
    private javax.swing.JLabel titleusername;
    private javax.swing.JLabel titlevpass;
    private javax.swing.JLabel userError;
    private javax.swing.JTextField usernametxt;
    private javax.swing.JLabel usernodisponible;
    private javax.swing.JPanel volverbtn;
    private javax.swing.JLabel volverbtntxt;
    private javax.swing.JPasswordField vpasstxt;
    // End of variables declaration//GEN-END:variables
}
