package MiPresentacion;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.*;

public class GUI_Presentacion extends JFrame {
    //atributos

    private JLabel labelImagen;
    private JPanel panelInstrucciones, panelDatos;
    private Titulos titulo;
    private Escucha escucha;
    private JTextArea textoExpectativas, yo, textoHobby, instrucciones;

    //metodos
    public GUI_Presentacion() {
        initGUI();
        //configuracion base de la ventana
        this.setTitle("Mi presentacion");
        this.setSize(500, 500);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private void initGUI() {
        //define container y layout del JFrame

        //crear objetos escucha
        escucha = new Escucha();

        //configurar Jcomponentes
        titulo = new Titulos("Hola, soy Santiago. Lee las instrucciones!!", Color.BLACK);
        this.add(titulo, BorderLayout.NORTH);

        //botones

        //texto
        yo = new JTextArea(10, 12);
        textoHobby = new JTextArea(4, 10);
        textoExpectativas = new JTextArea(8, 12);
        instrucciones = new JTextArea(4,18);


        //Panel datos
        panelDatos = new JPanel();
        panelDatos.addKeyListener(escucha);
        panelDatos.setFocusable(true);
        panelDatos.addMouseListener(escucha);

        panelDatos.setBorder(BorderFactory.createTitledBorder(null, "acerca de mi",
                TitledBorder.CENTER, TitledBorder.DEFAULT_POSITION,
                new Font("calibri", Font.PLAIN, 20), Color.BLACK));

        this.add(panelDatos, BorderLayout.CENTER);

        //Panel de Instrucciones
        panelInstrucciones = new JPanel();
        panelInstrucciones.setBorder(BorderFactory.createTitledBorder(null, "Instrucciones",
                TitledBorder.CENTER, TitledBorder.DEFAULT_POSITION,
                new Font("calibri", Font.PLAIN, 20), Color.BLACK));

        instrucciones.setFont(new Font("SansSerif",Font.BOLD, 12));
        instrucciones.setText("Un click arriba para: mi presentacion \n"+
                              "Doble click arriba para: mi hobby \n"+
                              "Presione la tecla 'm' para: mis expectativas");
        instrucciones.setEditable(false);
        instrucciones.setBackground(null);
        panelInstrucciones.add(instrucciones);

        this.add(panelInstrucciones, BorderLayout.SOUTH);

        //imagenes
        labelImagen = new JLabel();







    }

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                GUI_Presentacion miGUIPresentacion = new GUI_Presentacion();
            }
        });
    }

    private class Escucha extends MouseAdapter implements KeyListener {
        private ImageIcon image;

        @Override
        public void mouseClicked(MouseEvent e) {
            if(e.getClickCount() == 1) {
                panelDatos.removeAll();
                image = new ImageIcon(getClass().getResource("/recursos/yo.jpeg"));
                labelImagen.setIcon(image);
                panelDatos.add(labelImagen);

                yo.setFont(new Font("SansSerif", Font.BOLD, 12));
                yo.setText("Hola, mi nombre es Santiago Casanas");
                yo.setEditable(false);
                yo.setBackground(null);
                panelDatos.add(yo);

            }else{
                if(e.getClickCount() == 2) {
                    panelDatos.removeAll();
                    image = new ImageIcon(getClass().getResource("/recursos/hobby.jpeg"));
                    labelImagen.setIcon(image);
                    panelDatos.add(labelImagen);

                    textoHobby.setFont(new Font("SansSerif",Font.BOLD, 12));
                    textoHobby.setText("No diría que es mi hobby, pero me gusta \n" +
                            "jugar RocketLeague en mis tiempos libres");
                    textoHobby.setEditable(false);
                    textoHobby.setBackground(null);
                    panelDatos.add(textoHobby);
                }
            }

            revalidate();
            repaint();


        }

        @Override
        public void keyTyped(KeyEvent e) {
            if(e.getKeyChar() == 'm' || e.getKeyChar() == 'M') {
                panelDatos.removeAll();
                image = new ImageIcon(getClass().getResource("/recursos/cerebrito.jpg"));
                labelImagen.setIcon(image);

                textoExpectativas.setFont(new Font("SansSerif",Font.BOLD, 12));
                textoExpectativas.setText("Muy bien, amm... Creo que mi principal expectativa, \n" +
                        "por obvia que parezca, sería lograr entender bien este \n" +
                        "curso, ya que lo vi el semestre pasado, pero con lo del paro \n" +
                        "y en general mucho descuido de mi parte, no logré \n" +
                        "desempeñarme como me habria gustado en este, pero espero \n" +
                        "ahora, con mas dedicacion, obtener unas buenas bases \n" +
                        "de este lenguaje, en especial por saber lo importante que es \n" +
                        "de cara al mundo de la programacion");
                textoExpectativas.setBackground(null);
                textoExpectativas.setEditable(false);
                panelDatos.add(textoExpectativas);
                panelDatos.add(labelImagen);

            }
            revalidate();
            repaint();
        }

        @Override
        public void keyPressed(KeyEvent e) {

        }

        @Override
        public void keyReleased(KeyEvent e) {

        }

       /* public void actionPerformed(ActionEvent e) {
            panelDatos.removeAll();
            if(e.getSource()==miFoto) {
                image = new ImageIcon(getClass().getResource("/recursos/yo.jpeg"));
                labelImagen.setIcon(image);
                panelDatos.add(labelImagen);

                yo.setFont(new Font("SansSerif",Font.BOLD, 12));
                yo.setText("Hola, mi nombre es Santiago Casanas");
                yo.setBackground(null);
                panelDatos.add(yo);

            }else{
                if(e.getSource()==miHobby) {
                    image = new ImageIcon(getClass().getResource("/recursos/hobby.jpeg"));
                    labelImagen.setIcon(image);
                    panelDatos.add(labelImagen);

                    textoHobby.setFont(new Font("SansSerif",Font.BOLD, 12));
                    textoHobby.setText("No diría que es mi hobby, pero me gusta \n" +
                            "jugar RocketLeague en mis tiempos libres");
                    textoHobby.setBackground(null);
                    panelDatos.add(textoHobby);

                }else{
                    image = new ImageIcon(getClass().getResource("/recursos/cerebrito.jpg"));
                    labelImagen.setIcon(image);

                    textoExpectativas.setFont(new Font("SansSerif",Font.BOLD, 12));
                    textoExpectativas.setText("Muy bien, amm... Creo que mi principal expectativa, \n" +
                            "por obvia que parezca, sería lograr entender bien este \n" +
                            "curso, ya que lo vi el semestre pasado, pero con lo del paro \n" +
                            "y en general mucho descuido de mi parte, no logré \n" +
                            "desempeñarme como me habria gustado en este, pero espero \n" +
                            "ahora, con mas dedicacion, obtener unas buenas bases \n" +
                            "de este lenguaje, en especial por saber lo importante que es \n" +
                            "de cara al mundo de la programacion");
                    textoExpectativas.setBackground(null);
                    panelDatos.add(textoExpectativas);
                    panelDatos.add(labelImagen);
                }
            }
            revalidate();
            repaint();

        }*/

    }


}
