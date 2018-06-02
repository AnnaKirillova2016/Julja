package ru.isu.graphs.visualization;

import ru.isu.graphs.Main;
import ru.isu.graphs.object.Graph;
import ru.isu.graphs.object.Vertex;
import javax.imageio.*;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;


public class GraphPanel extends JPanel {

    public int radius = 30;


public void paint(Graphics g){
        super.paint(g);
        Graph graph = Main.graph;

        Font currentFont = g.getFont();
        Font newFont = currentFont.deriveFont(currentFont.getSize() * 1.9F);
        g.setFont(newFont);
        g.drawString("Сейчас ходит игрок: " + Main.gameStatus.GetCurrentPlayer().name, 550, 80);
        g.setColor(Color.ORANGE);

        for (Vertex vertex : graph.getVertexes())
            for (Vertex vertex1 : graph.getVertexes()) {
                if (vertex.isNeighbour(vertex1)) {
                    g.drawLine(vertex.getx(), vertex.gety(), vertex1.getx(), vertex1.gety());
                }
            }

        /*  if(GraphFrame.img[0]!=null){
              System.out.println(77687);
              for (Vertex vertex : graph.getVertexes()) {
                  int num;
                  if (vertex.owner != null)
                    g.setColor(vertex.owner.color);
                  else
                      g.setColor(Color.ORANGE);

                  g.fillOval(vertex.getx() - radius / 2, vertex.gety() - radius / 2, radius, radius);

              }
            }
                else{*/


        for (Vertex vertex : graph.getVertexes()) {
            BufferedImage img = Main.orangeCustle; // по умолчанию - оранж
            if (vertex.owner != null)
                img = vertex.owner.image;
            g.drawImage(img,vertex.getx() - 25, vertex.gety() - 37, 50 ,75, this); // рисуем замок
          //  g.fillOval(vertex.getx() - radius / 2, vertex.gety() - radius / 2, radius, radius);
            }
     //  }
    }
}
