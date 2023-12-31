/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package frames;

import domino.Ficha;
import dto.FichaDTO;
import dto.Orientacion;
import draw.FichaDraw;
import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author HP
 */
public class PanelFichas extends javax.swing.JPanel {

    private FrmPartida frmPartida;
    private FichaDraw fichaDraw;
    private List<FichaDTO> fichasDTO = new ArrayList<>();
    public FichaDTO fichaSeleccionadaTablero;
    public List<Ficha> fichas = new ArrayList<>();

    /**
     * Creates new form NewJPanel
     */
    public PanelFichas(FrmPartida frmPartida, List<Ficha> fichasTablero) {
        initComponents();
        fichaSeleccionadaTablero = null;
        this.frmPartida = frmPartida;
        this.fichas = fichasTablero;

//        //ficha vertical
//        x = 400;
//        y = 400;
//        Ficha ficha2 = fichasTablero.get(1);
//        fichas.add(new FichaDTO(ficha2, x, y, Orientacion.VERTICAL));
//        x = 500;
//        y = 400;
//        Ficha ficha3 = fichasTablero.get(2);
//        fichas.add(new FichaDTO(ficha3, x, y, Orientacion.VERTICAL));
//        x = 350;
//        y = 200;
//        Ficha ficha4 = fichasTablero.get(3);
//        fichas.add(new FichaDTO(ficha4, x, y, Orientacion.HORIZONTAL));
//        x = 550;
//        y = 200;
//        Ficha ficha5 = fichasTablero.get(4);
//        fichas.add(new FichaDTO(ficha5, x, y, Orientacion.HORIZONTAL));
    }

    public void cargarFichas() {
        if (!fichas.isEmpty()) {
            for (int i = 0; i < fichas.size(); i++) {
                if (i==0) {
                    int x = 425;
                    int y = 250;
                    fichasDTO.add(new FichaDTO(fichas.get(i), x, y, Orientacion.VERTICAL));
                }else{
                    int x = 475;
                    int y = 275;
                    fichasDTO.add(new FichaDTO(fichas.get(i), x, y, Orientacion.HORIZONTAL));
                }
                    /*int x = 525;
                    int y = 325;
                    fichasDTO.add(new FichaDTO(fichas.get(i), x, y, Orientacion.HORIZONTAL));*/
                
            }
            
            /*for (Ficha  fichas1: fichas) {
                int x = 425;
                int y = 250;
                fichasDTO.add(new FichaDTO(fichas1, x, y, Orientacion.VERTICAL));
            }*/
           //Ficha ficha = fichas.get(0);
//        //ficha horizontal
            //int x = 425;
            //int y = 250;
            //fichasDTO.add(new FichaDTO(ficha, x, y, Orientacion.VERTICAL));
        }
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        cargarFichas();
        this.fichaDraw = new FichaDraw(50);

        for (int i = 0; i < fichasDTO.size(); i++) {
            fichaDraw.dibujarFicha(fichasDTO.get(i), g);
        }

        if (fichaSeleccionadaTablero != null) {
            int xFichaSeleccionada = fichaSeleccionadaTablero.getX();
            int yFichaSeleccionada = fichaSeleccionadaTablero.getY();
            g.setColor(Color.RED);
            g.drawRoundRect(xFichaSeleccionada, yFichaSeleccionada,
                    fichaDraw.getDimensionCuadrado(), fichaDraw.getDimensionCuadrado(), 6, 6);
            if (fichaSeleccionadaTablero.getOrientacion().equals(Orientacion.HORIZONTAL)) {
                xFichaSeleccionada = fichaSeleccionadaTablero.getX() + 50;
                g.drawRoundRect(xFichaSeleccionada, yFichaSeleccionada,
                        fichaDraw.getDimensionCuadrado(), fichaDraw.getDimensionCuadrado(), 6, 6);
            } else {
                yFichaSeleccionada = fichaSeleccionadaTablero.getY() + 50;
                g.drawRoundRect(xFichaSeleccionada, yFichaSeleccionada,
                        fichaDraw.getDimensionCuadrado(), fichaDraw.getDimensionCuadrado(), 6, 6);
            }

        }
    }

    private void seleccionarFicha(int x, int y) {
        for (FichaDTO ficha : fichasDTO) {
//            int xFicha = 400 + fichas.indexOf(ficha) * 100;
//            int yFicha = 400;
            int xFicha = ficha.getX();
            int yFicha = ficha.getY();

            if (ficha.getOrientacion().equals(Orientacion.HORIZONTAL)) {
                if (y >= yFicha && y <= yFicha + fichaDraw.getDimensionCuadrado()
                        && x >= xFicha && x <= xFicha + 2 * fichaDraw.getDimensionCuadrado()) {
                    fichaSeleccionadaTablero = ficha;
                    repaint();
                    System.out.println("Ficha seleccionada: " + ficha);
                    break;
                }
            } else if (ficha.getOrientacion().equals(Orientacion.VERTICAL)) {
                if (x >= xFicha && x <= xFicha + fichaDraw.getDimensionCuadrado()
                        && y >= yFicha && y <= yFicha + 2 * fichaDraw.getDimensionCuadrado()) {
                    fichaSeleccionadaTablero = ficha;
                    repaint();
                    System.out.println("Ficha seleccionada: " + ficha);
                    break;
                }
            }

        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setBackground(new java.awt.Color(153, 153, 153));
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                formMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 900, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 550, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void formMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseClicked
        seleccionarFicha(evt.getX(), evt.getY());
        frmPartida.validarFichas();

// TODO add your handling code here:
    }//GEN-LAST:event_formMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
