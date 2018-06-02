package ru.isu.graphs.object;

import java.util.ArrayList;

public class Graph {

    public ArrayList<Vertex> vertexes;

    public Graph(ArrayList<Vertex> vertexes) {
        this.vertexes = vertexes;
    }

    public ArrayList<Vertex> getVertexes() {
        return vertexes;
    }

    public void setVertexes(ArrayList<Vertex> vertexes) {
        this.vertexes = vertexes;
    }

    public boolean isRepeatedId() {
        for (int i = 0; i < vertexes.size(); i++)
            for (int j = i + 1; j < vertexes.size(); j++)
                if (vertexes.get(i).getId() == vertexes.get(j).getId())
                    return true;
        return false;
    }

    @Override
    public String toString() {
        return "Graph{" +
                "vertexes=" + vertexes +
                '}';
    }
}
