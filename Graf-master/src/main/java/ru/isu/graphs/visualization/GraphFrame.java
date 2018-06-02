package ru.isu.graphs.visualization;

import ru.isu.graphs.Main;
import ru.isu.graphs.object.Graph;
import ru.isu.graphs.object.Vertex;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class GraphFrame extends JFrame {

    public GraphPanel panel;
    public Graph graph = Main.graph;
    static BufferedImage[] img=new BufferedImage[6];

    public Vertex getClickedVertex(int mouseX, int mouseY) {
        Vertex vertex;
        for (int i = 0; i < graph.getVertexes().size(); i++) {
            vertex = graph.getVertexes().get(i);
            if (Math.pow(vertex.getx() - mouseX, 2) + Math.pow(vertex.gety() - mouseY, 2) < Math.pow(70, 2)) {
                return vertex;
            }
        }
        return null;
    }

    public Vertex GetVertexByID(int id) {
        Vertex ver = null;
        for (int i = 0; i < graph.getVertexes().size(); i++) {
            if (graph.getVertexes().get(i).id == id) {
                ver = graph.getVertexes().get(i);
                break;
            }
        }
        return ver;
    }

    public GraphFrame(String name) throws HeadlessException {
        super(name);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1200, 800);
        setLocationRelativeTo(null);
        setVisible(true);
        setBackground(Color.white);
        panel = new GraphPanel();
        panel.setOpaque(true);
        panel.addMouseListener(new MouseEvent());
        getContentPane().removeAll();
        setContentPane(panel);/*
        try {
            img[0]= ImageIO.read(new File("orange.png"));
            img[1]=ImageIO.read(new File("blue.png"));
            img[2]=ImageIO.read(new File("red.png"));
            img[3]=ImageIO.read(new File("gren.png"));
            img[4]=ImageIO.read(new File("raskraska-zamok12.jpg"));
            img[5]=ImageIO.read(new File("yellow.png"));

        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "I am happy.");
        }
        catch(IllegalArgumentException e) {
            JOptionPane.showMessageDialog(null, "I am not happy.");
        }*/
    }

    public void SetVertexList(ArrayList<Vertex> vertexes) {
        this.graph.setVertexes(vertexes);
    }

    public void textField(){
        System.out.println("ddd");
        Panel panel = new Panel();
        JTextField textField = new JTextField(10);
        JButton btn = new JButton("Accept");
        panel.add(textField);
        panel.add(btn);
        setContentPane(panel);

    }

}
