package ru.isu.graphs.object;

import ru.isu.graphs.Main;

import java.util.Arrays;

public class Vertex {
    public int id;
    public int x;
    public int y;
    public Player owner;
    private int[] neighbours;

    public Vertex(String vert) {
        vert = vert.substring(1);
        String[] v = vert.split(",");
        this.id = Integer.parseInt(v[0]);
        this.x = Integer.parseInt(v[1]);
        this.y = Integer.parseInt(v[2]);
        v[4] = v[4].substring(v[4].indexOf("[") + 1, v[4].lastIndexOf("]"));
        this.neighbours = Arrays.stream(v[4].split(" ")).mapToInt(Integer::parseInt).toArray();
        this.owner = null;
    }

    public boolean CanOccupate(Player player) {
        if (this.owner == null) {
            if (this.neighbours != null && this.neighbours.length != 0) {
                for (int i = 0; i < this.neighbours.length; i++) {
                    Vertex vertex = Main.frame.GetVertexByID(this.neighbours[i]);
                    if (vertex.owner != null && vertex.owner.equals(player)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public int getId() {
        return id;
    }

    public int getx() {
        return x;
    }

    public int gety() {
        return y;
    }

    public void setx(int x) {
        this.x = x;
    }

    public void sety(int y) {
        this.y = y;
    }

    public int[] getNeighbours() {
        return neighbours;
    }

    public boolean isNeighbour(Vertex vertex) {
        int vertexId = vertex.getId();
        for (int id : this.neighbours) {
            if (id == vertexId)
                return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return "Vertex{" +
                "id=" + id +
                ", x=" + x +
                ", y=" + y +
                ", owner=" + owner +
                ", neighbours=" + Arrays.toString(neighbours) +
                '}';
    }
}