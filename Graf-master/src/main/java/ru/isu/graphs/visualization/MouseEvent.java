package ru.isu.graphs.visualization;

import ru.isu.graphs.Main;
import ru.isu.graphs.object.GameStatus;
import ru.isu.graphs.object.Vertex;

import java.awt.event.MouseListener;

public class MouseEvent implements MouseListener {
    @Override
    public void mouseClicked(java.awt.event.MouseEvent e) {
        GameStatus gs = Main.gameStatus;
        Vertex vertex = Main.frame.getClickedVertex(e.getX(), e.getY());
        if (vertex != null) {
            if ((GameStatus.isFirstTurn && vertex.owner == null) || vertex.CanOccupate(gs.GetCurrentPlayer())) {
                Main.graph.vertexes.get(vertex.getId() - 1).owner = gs.GetCurrentPlayer();
                gs.players.get(gs.GetCurrentPlayer().index).occupiedVertexes.add(vertex); // добавляем занятый элемент
                gs.NextPlayer();
                Main.frame.panel.repaint();
            }
        }
    }

    @Override
    public void mousePressed(java.awt.event.MouseEvent e) {
    }

    @Override
    public void mouseReleased(java.awt.event.MouseEvent e) {
    }

    @Override
    public void mouseEntered(java.awt.event.MouseEvent e) {
    }

    @Override
    public void mouseExited(java.awt.event.MouseEvent e) {
    }
}
