package se;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Interfaz extends javax.swing.JFrame {
    Scanner sc = new Scanner(System.in);
    List<String> BH = new ArrayList<>();
    c_combinar combinador = new c_combinar();
    List<String> COMB = new ArrayList<>();

    List<Integer> CC = new ArrayList<>();
    String meta, usadas = "";

    public Interfaz() {
        initComponents();
        //estructurar el archivo BC
        //estructurar el archivo Indice
        //generar arbol
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        chk_b = new javax.swing.JCheckBox();
        chk_a = new javax.swing.JCheckBox();
        chk_c = new javax.swing.JCheckBox();
        chk_d = new javax.swing.JCheckBox();
        chk_e = new javax.swing.JCheckBox();
        chk_f = new javax.swing.JCheckBox();
        chk_g = new javax.swing.JCheckBox();
        chk_z = new javax.swing.JCheckBox();
        btn_evaluar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txt_area = new javax.swing.JTextArea();
        cmb_meta = new javax.swing.JComboBox();
        jLabel2 = new javax.swing.JLabel();
        chk_x = new javax.swing.JCheckBox();
        jLabel3 = new javax.swing.JLabel();
        btn_escribir_reglas = new javax.swing.JButton();
        btn_ver_reglas = new javax.swing.JButton();
        btn_otra_regla = new javax.swing.JButton();
        chk_n1 = new javax.swing.JCheckBox();
        chk_n2 = new javax.swing.JCheckBox();
        chk_n3 = new javax.swing.JCheckBox();
        chk_n4 = new javax.swing.JCheckBox();
        chk_n5 = new javax.swing.JCheckBox();
        lbl_usadas = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(809, 663));
        setResizable(false);

        chk_b.setText("b: el plug de tu PC esta roto?");

        chk_a.setText("a: el cable está rasgado");

        chk_c.setText("c: las luces del modem estan apagadas?");

        chk_d.setText("d: modem enchufado");

        chk_e.setText("e: el cable ADSL de entrada de modem está conectado");

        chk_f.setText("f: problema con el modem");

        chk_g.setText("g: problema con el ISP");

        chk_z.setText("z: modem viejo");

        btn_evaluar.setText("Evaluar");
        btn_evaluar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_evaluarMouseClicked(evt);
            }
        });

        jLabel1.setText("FUTURAMA EXPERTO");

        txt_area.setColumns(20);
        txt_area.setRows(5);
        jScrollPane1.setViewportView(txt_area);

        cmb_meta.setModel(new javax.swing.DefaultComboBoxModel(new String[]{"a", "b", "c", "d", "e", "f", "g", "z", "x", "p", "q", "r", "m"}));

        jLabel2.setText("META");

        chk_x.setText("x: llamar ISP");
        chk_x.setEnabled(false);

        jLabel3.setText("SELECCIONA LOS HECHOS");

        btn_escribir_reglas.setText("Escribir en BC");
        btn_escribir_reglas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_escribir_reglasMouseClicked(evt);
            }
        });

        btn_ver_reglas.setText("Ver Reglas");
        btn_ver_reglas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_ver_reglasMouseClicked(evt);
            }
        });

        btn_otra_regla.setText("Añadir Regla");
        btn_otra_regla.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_otra_reglaMouseClicked(evt);
            }
        });

        chk_n1.setText("NR 1");

        chk_n2.setText("NR 2");

        chk_n3.setText("NR 3");

        chk_n4.setText("NR 4");

        chk_n5.setText("NR 5");

        lbl_usadas.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_usadas.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        lbl_usadas.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("REGLAS USADAS");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(215, 215, 215)
                                                .addComponent(jLabel1))
                                        .addGroup(layout.createSequentialGroup()
                                                .addContainerGap()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                        .addComponent(chk_a, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(chk_b, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(chk_c, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(chk_d, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(jLabel3)
                                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                                .addComponent(btn_otra_regla)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                .addComponent(btn_ver_reglas)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(btn_escribir_reglas)
                                                                .addGap(11, 11, 11)))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addComponent(btn_evaluar, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(cmb_meta, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                                        .addComponent(chk_g, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                        .addComponent(chk_z, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                        .addComponent(chk_e, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                        .addComponent(chk_f, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                        .addComponent(chk_x, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                                                .addGap(18, 18, 18)
                                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                        .addComponent(chk_n1)
                                                                        .addComponent(chk_n2)
                                                                        .addComponent(chk_n3)
                                                                        .addComponent(chk_n4)
                                                                        .addComponent(chk_n5)))))
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(4, 4, 4)
                                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 585, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                        .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, 119, Short.MAX_VALUE)
                                                        .addComponent(lbl_usadas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                                .addContainerGap(41, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel1)
                                .addGap(8, 8, 8)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(chk_e)
                                                        .addComponent(chk_n1))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(chk_f)
                                                        .addComponent(chk_a)
                                                        .addComponent(chk_n2))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(chk_g)
                                                        .addComponent(chk_b)
                                                        .addComponent(chk_n3))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(chk_z)
                                                        .addComponent(chk_c)
                                                        .addComponent(chk_n4))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(chk_x)
                                                        .addComponent(chk_d)
                                                        .addComponent(chk_n5))
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addGap(10, 10, 10)
                                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                        .addComponent(btn_evaluar)
                                                                        .addComponent(cmb_meta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                        .addComponent(btn_escribir_reglas)
                                                                        .addComponent(btn_ver_reglas)
                                                                        .addComponent(btn_otra_regla)))
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addGap(18, 18, 18)
                                                                .addComponent(jLabel5))))
                                        .addComponent(jLabel3))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(lbl_usadas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 165, Short.MAX_VALUE))
                                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_evaluarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_evaluarMouseClicked
        try {
            m_EHD();
        } catch (IOException e) {
        }
    }//GEN-LAST:event_btn_evaluarMouseClicked

    private void btn_escribir_reglasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_escribir_reglasMouseClicked
        try {
            m_escribirBC();
        } catch (IOException e) {
        }
    }//GEN-LAST:event_btn_escribir_reglasMouseClicked

    private void btn_ver_reglasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_ver_reglasMouseClicked
        try {
            m_mostrarBC();
        } catch (IOException e) {
        }
    }//GEN-LAST:event_btn_ver_reglasMouseClicked

    private void btn_otra_reglaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_otra_reglaMouseClicked
        try {
            m_agregarRegla_BC();
        } catch (IOException e) {
        }
    }//GEN-LAST:event_btn_otra_reglaMouseClicked

    private void m_EHD() throws IOException {
        int v_regla, v_iteracion = 0;
        char v_usada, v_temp = 'G', v_consecuente;
        String v_antecedentes;
        RandomAccessFile v_archivo;

        m_cargarHechos();   //Añadir a la memoria de trabajo los hechos
        usadas = "";
        txt_area.setText("Meta: " + meta + "\n");
        CC.add(399);        //Añadir cualquier regla
        while (!CC.isEmpty() && !m_verificar_meta()) {
            v_iteracion++;
            System.out.println("---------------------Iteracion " + v_iteracion + "---------------------");
            m_imprimeLista("Hechos ", BH);

            CC.clear();
            COMB.clear();
            COMB = combinador.m_regresaCombinaciones(BH);     //combinar los hechos actuales
            //m_imprimeLista("COMB tiene ", COMB);

            boolean v_localizado;
            for (String comb_i : COMB) {                       //Equiparación
                v_localizado = false;
                v_archivo = new RandomAccessFile("src/SE/bc.dat", "r");

                //recorrer BC hasta encontrar una regla que se pueda aplicar
                while (v_localizado == false && v_archivo.getFilePointer() != v_archivo.length()) {
                    v_antecedentes = "";

                    v_regla = v_archivo.readInt();
                    v_usada = v_archivo.readChar();
                    for (int i = 0; i < 5; i++) {
                        v_temp = v_archivo.readChar();
                        if (v_temp != '-')
                            v_antecedentes += v_temp;
                    }
                    v_consecuente = v_archivo.readChar();

                    //Solo reglas no usadas , no reduntantes y que se puedan aplicar
                    if (v_antecedentes.equals(comb_i) && v_usada == 'N' && !m_existencia(v_consecuente, BH)) {
                        CC.add(v_regla);
                        v_localizado = true;
                        //System.out.println("Se añadio al CC "+v_regla);
                    }
                }//fin de la busqueda en archivo
                v_archivo.close();
            }//Conjunto Conflicto de la Iteracion LISTO

            m_imprimeLista2("Conjunto Conflicto", CC);

            if (!CC.isEmpty()) {//si se encontro al menos una regla que aplicar
                System.out.println("Regla seleccionada: " + CC.get(0));
                txt_area.append("-----------------------------------------------------\n");
                m_actualiza_BC(CC.get(0));  //marcar como Y (utilizada)
                m_actualiza_BH(CC.get(0));  //se utiliza la regla seleccionada
            }
        }

        if (m_verificar_meta()) {
            System.out.println("EXITO");
            txt_area.append("EXITO");
        } else {
            System.out.println("FRACASO");
            txt_area.append("FRACASO");
        }
        m_reiniciarBC();
    }

    private void m_escribirBC() throws IOException {
        RandomAccessFile v_maestro = new RandomAccessFile("src/SE/bc.dat", "rw");
        int v_numReglas, v_llave;
        String v_temp;
        char v_consecuente;

        System.out.print("Numero de reglas: ");
        v_numReglas = sc.nextInt();

        for (int i = 0; i < v_numReglas; i++) {
            System.out.print("\nNum. Regla: ");
            v_llave = sc.nextInt();

            sc.nextLine();      //limpieza teclado
            System.out.print("Antecedentes (sin espacios): ");
            v_temp = sc.nextLine();
            StringBuffer v_buffer = new StringBuffer(v_temp);
            v_buffer.append("-----");
            v_buffer.setLength(5);

            System.out.print("Consecuente: ");
            v_temp = sc.next();
            v_consecuente = v_temp.charAt(0);

            //escritura de archivo BC
            v_maestro.writeInt(v_llave);
            v_maestro.writeChar('N');
            v_maestro.writeChars(v_buffer.toString());
            v_maestro.writeChar(v_consecuente);
        }
        v_maestro.close();
    }

    private void m_mostrarBC() throws IOException {
        RandomAccessFile v_leer_archi = new RandomAccessFile("src/SE/bc.dat", "r");
        int v_regla;
        char v_usada, v_consecuente, v_temp = 'G';
        String v_antecedentes;

        System.out.println("Regla\tUsado\tAntecedentes\tConsecuente");
        while ((v_leer_archi.getFilePointer()) != (v_leer_archi.length())) {
            v_antecedentes = "";

            v_regla = v_leer_archi.readInt();
            v_usada = v_leer_archi.readChar();
            for (int i = 0; i < 5; i++) {
                v_antecedentes += v_leer_archi.readChar();
            }
            v_consecuente = v_leer_archi.readChar();
            System.out.println(v_regla + "\t" + v_usada + "\t" + v_antecedentes + "\t\t" + v_consecuente);
        }
        v_leer_archi.close();
    }

    private void m_reiniciarBC() throws IOException {
        RandomAccessFile v_archivo = new RandomAccessFile("src/SE/bc.dat", "rw");
        int num_reglas = (int) v_archivo.length() / 18;
        for (int i = 0; i < num_reglas; i++) {
            v_archivo.seek(18 * i + 4);         //UN REGISTRO ANTES DEL CAMPO 'USADO'
            v_archivo.writeChar('N');
        }
        v_archivo.close();
    }

    private void m_agregarRegla_BC() throws IOException {
        RandomAccessFile v_maestro = new RandomAccessFile("src/SE/bc.dat", "rw");
        String v_temp;
        char v_consecuente;
        int var_pos;

        var_pos = (int) (v_maestro.length() / 18) + 1;
        v_maestro.seek(v_maestro.length());
        v_maestro.writeInt(var_pos);
        v_maestro.writeChar('N');

        System.out.print("Antecedentes (sin espacios): ");
        v_temp = sc.nextLine();
        StringBuffer v_buffer = new StringBuffer(v_temp);
        v_buffer.append("-----");
        v_buffer.setLength(5);
        v_maestro.writeChars(v_buffer.toString());

        System.out.print("Consecuente: ");
        v_temp = sc.next();
        v_consecuente = v_temp.charAt(0);
        v_maestro.writeChar(v_consecuente);

        v_maestro.close();
    }

    private void m_cargarHechos() {
        BH.clear();//mas de una vez en la misma ejecucion del programa

        if (chk_a.isSelected())
            BH.add("a");
        if (chk_b.isSelected())
            BH.add("b");
        if (chk_c.isSelected())
            BH.add("c");
        if (chk_d.isSelected())
            BH.add("d");
        if (chk_e.isSelected())
            BH.add("e");
        if (chk_f.isSelected())
            BH.add("f");
        if (chk_g.isSelected())
            BH.add("g");
        if (chk_z.isSelected())
            BH.add("z");
        if (chk_x.isSelected())
            BH.add("x");

        //TAMBIEN AÑADIR A LAS METAS
        if (chk_n1.isSelected())//p
            BH.add("p");
        if (chk_n2.isSelected())//q
            BH.add("q");
        if (chk_n3.isSelected())//r
            BH.add("r");
        if (chk_n4.isSelected())//m
            BH.add("m");

        meta = cmb_meta.getSelectedItem().toString();
    }

    private void m_actualiza_BC(int p_regla_seleccionada) throws IOException {
        //marcar las reglas utilizadas        
        RandomAccessFile v_archivo = new RandomAccessFile("src/SE/bc.dat", "rw");
        v_archivo.seek(18 * (p_regla_seleccionada - 1) + 4);
        v_archivo.writeChar('Y');
        v_archivo.close();
    }

    private void m_actualiza_BH(int p_regla_seleccionada) throws IOException {
        //aplicar el consecuente
        char v_temp;
        String v_antec = "", v_consec = "";
        RandomAccessFile v_archivo = new RandomAccessFile("src/SE/bc.dat", "r");
        v_archivo.seek(18 * (p_regla_seleccionada - 1) + 6);  //COMENZAR EN EL ANTECEDENTE

        for (int i = 0; i < 5; i++) {
            v_temp = v_archivo.readChar();
            if (v_temp != '-')
                v_antec += v_temp;
        }

        v_consec += v_archivo.readChar();

        //m_imprimeLista("Hechos actualizados",BH);
        v_archivo.close();

        //SALIDA EN PANTALLA
        String cad = "BH= [ ";
        for (String var : BH) {
            cad += var + " ";
        }
        usadas += "✓ " + p_regla_seleccionada + " \n";
        lbl_usadas.setText(usadas);
        txt_area.append(cad + "]\n");
        txt_area.append(p_regla_seleccionada + ": " + v_antec + " ⇒ " + v_consec + "\n");

        BH.add(v_consec);
        Collections.sort(BH);
    }

    private void m_imprimeLista(String p_titulo, List<String> p_lista) {
        String v_cadena = "";
        for (String cad : p_lista)
            v_cadena += cad + ", ";
        System.out.println(p_titulo + ": " + v_cadena);
    }

    private void m_imprimeLista2(String p_titulo, List<Integer> p_lista) {
        //imprime el conjunto conflicto (Enteros)
        String v_cadena = "";
        for (int cad : p_lista)
            v_cadena += cad + ", ";
        System.out.println(p_titulo + ": " + v_cadena);
    }

    private boolean m_verificar_meta() {
        //false=no esta en la BH
        for (int i = 0; i < BH.size(); i++) {
            if (BH.get(i).equals(meta))
                return true;
        }
        return false;
    }

    private boolean m_existencia(char p_hecho, List<String> p_lista) {
        String v_temp = "" + p_hecho;
        for (String var : p_lista) {
            if (var.equals(v_temp))
                return true;
        }
        return false;
    }

    private void m_leer_registro_BC(int p_num_regla) throws IOException {
        RandomAccessFile v_leer_archi = new RandomAccessFile("src/SE/bc.dat", "r");
        int v_regla;
        char v_usada, v_consecuente, v_temp = '@';
        String v_antecedentes = "";

        v_leer_archi.seek(18 * p_num_regla);
        v_regla = v_leer_archi.readInt();
        v_usada = v_leer_archi.readChar();
        for (int i = 0; i < 5; i++) {
            v_temp = v_leer_archi.readChar();
            if (v_temp != '-')
                v_antecedentes += v_temp;
        }
        v_consecuente = v_leer_archi.readChar();
        v_leer_archi.close();
        System.out.println("LECTURA DE REGISTRO");
        System.out.println("Regla\tUsado\tAntecedentes\tConsecuente");
        System.out.println(v_regla + "\t" + v_usada + "\t" + v_antecedentes + "\t\t" + v_consecuente);
    }

    public static void main(String args[]) {
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
            java.util.logging.Logger.getLogger(Interfaz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Interfaz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Interfaz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Interfaz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Interfaz().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_escribir_reglas;
    private javax.swing.JButton btn_evaluar;
    private javax.swing.JButton btn_otra_regla;
    private javax.swing.JButton btn_ver_reglas;
    private javax.swing.JCheckBox chk_a;
    private javax.swing.JCheckBox chk_b;
    private javax.swing.JCheckBox chk_c;
    private javax.swing.JCheckBox chk_d;
    private javax.swing.JCheckBox chk_e;
    private javax.swing.JCheckBox chk_f;
    private javax.swing.JCheckBox chk_g;
    private javax.swing.JCheckBox chk_n1;
    private javax.swing.JCheckBox chk_n2;
    private javax.swing.JCheckBox chk_n3;
    private javax.swing.JCheckBox chk_n4;
    private javax.swing.JCheckBox chk_n5;
    private javax.swing.JCheckBox chk_x;
    private javax.swing.JCheckBox chk_z;
    private javax.swing.JComboBox cmb_meta;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbl_usadas;
    private javax.swing.JTextArea txt_area;
    // End of variables declaration//GEN-END:variables
}
