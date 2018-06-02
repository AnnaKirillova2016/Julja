package ru.isu.graphs.object;

import ru.isu.graphs.Main;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class Player {

  //  public Color color;
    public BufferedImage image;
    public int index;
    public String name;
    public  boolean inGame;
    public ArrayList<Vertex> occupiedVertexes;


    public Player(BufferedImage image, String name,int index) {
        this.image = image;
        this.name = name;
        this.index  = index;
        this.inGame = true;
        occupiedVertexes = new ArrayList<Vertex>();
    }

    public  boolean CanPlay()
    {
        if (Main.gameStatus.isFirstTurn) // на первом ходу всегда true
            return  true;
        for (int i = 0; i < occupiedVertexes.size(); i ++) {
            int[] neigbrsIds =  occupiedVertexes.get(i).getNeighbours();
            for (int j = 0 ; j<neigbrsIds.length; j++)
            {
                if (Main.frame.GetVertexByID(neigbrsIds[j]).owner == null)
                {
                    return  true;
                }
            }
        }
        return  false;
    }
    /*
    public Player(Color color, String name,int index) {
        this.color = color;
        this.name = name;
        this.index=index;
        occupiedVertexes = new ArrayList<Vertex>();
    }
*/
    // public ArrayList<Vertex> getOccupiedVertexes() {
  //      return occupiedVertexes;
  //  }

    @Override
    public String toString() {
        return "Player{" +
                "image=" + image +
                ", name='" + name + '\'' +
                ", occupiedVertexes=" + occupiedVertexes +
                '}';
    }
}
