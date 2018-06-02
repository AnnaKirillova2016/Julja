package ru.isu.graphs;

import ru.isu.graphs.object.GameStatus;
import ru.isu.graphs.object.Graph;
import ru.isu.graphs.object.Player;
import ru.isu.graphs.object.Vertex;
import ru.isu.graphs.visualization.GraphFrame;

import java.awt.*;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;


public class Main {


    public static GameStatus gameStatus = new GameStatus();
    public static Graph graph;
    public static GraphFrame frame;

    public static  BufferedImage redCustle;
    public static  BufferedImage blueCustle;
    public static  BufferedImage greenCustle;
    public static  BufferedImage yellowCustle;
    public static  BufferedImage orangeCustle;
    public static  BufferedImage fiolCustle;

    public static void main(String[] args) throws FileNotFoundException, IOException, InterruptedException {

        int playersCount = GetPlayersCount();
        // считываем картинки замков
        blueCustle = ImageIO.read(new File("blue.png"));
        redCustle = ImageIO.read(new File("red.png"));
        greenCustle = ImageIO.read(new File("gren.png"));
        yellowCustle = ImageIO.read(new File("yellow.png"));
        orangeCustle = ImageIO.read(new File("orange.png"));
        fiolCustle = ImageIO.read(new File("fioletov.png"));


        gameStatus.players = new ArrayList<Player>();
        for (int i = 0; i < playersCount; i ++)
        {
            String name = GetPlayerName(i+1);
            BufferedImage img = SelectColor(name);
            Player player = new Player(img, name, i);
            gameStatus.players.add(player);
            if ( gameStatus.curPlayer == null)
            {
                gameStatus.curPlayer = player;
            }
        }
        gameStatus.isFirstTurn = true; // индикатор первого хода



        ArrayList<Vertex> Vertexes = new ArrayList<>(); // список вершин графа
        int n = (int) (Math.random() * 2) + 2;
        System.out.println(n);
        n=3;
        Scanner in = new Scanner(new FileReader("src/main/resources/graphs/graph" + n + ".txt"));


        while (in.hasNextLine()) {
            Vertexes.add(new Vertex(in.nextLine()));
        }
        in.close();

        graph = new Graph(Vertexes);

        frame = new GraphFrame("test");
       // frame.textField();
        frame.SetVertexList(Vertexes);

    }

    // ввести кол-во игроков
    public static int GetPlayersCount()
    {
        String input = JOptionPane.showInputDialog(null, "Введите количество игроков ", "Количество игроков", JOptionPane.PLAIN_MESSAGE);
        int count = Integer.parseInt(input);
        return count;
    }

    // ввести имя игрока
    public static  String GetPlayerName(int playerNumber)
    {
        String name = JOptionPane.showInputDialog (null, "Введите имя игрока " + playerNumber, "Имя игрока", JOptionPane.PLAIN_MESSAGE);
        return name;
    }

    // выбрать цвет игрока
    public static BufferedImage SelectColor(String playerName)
    {
        String col = "";
        String[] colors = new String[] {"Красный", "Зелёный", "Жёлтый", "Синий", "Фиолетовый"};
        col = (String) JOptionPane.showInputDialog (null, "Выберите цвет игрока " +playerName, "Цвет",
                JOptionPane.PLAIN_MESSAGE,
                null,
                colors,
                colors[0]);
        if (col == "Красный")
            return redCustle;
        if (col == "Зелёный")
            return greenCustle;
        if (col == "Жёлтый")
            return yellowCustle;
        if (col == "Синий")
            return blueCustle;
        if (col == "Фиолетовый")
            return fiolCustle;
        return  null;
    }
}

