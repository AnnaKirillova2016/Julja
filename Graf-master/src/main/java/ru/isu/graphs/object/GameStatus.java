package ru.isu.graphs.object;

import javax.swing.*;
import java.util.ArrayList;

// класс состояния игры
public class GameStatus {


    public static ArrayList<Player> players; // список игроков
    public static Player curPlayer;     // текущий игрок
    public static boolean isFirstTurn;  // индикатор первого хода

    // переключение на след. игрока
    public  void NextPlayer(){
        if (players != null && players.size() != 0)  {
            if (players.indexOf(curPlayer) != players.size()-1) {
                curPlayer =players.get(players.indexOf(curPlayer)+1);
            }
            else {
                if (isFirstTurn){
                    isFirstTurn = false;
                }
                curPlayer = players.get(0);
            }
        }

        if (curPlayer.inGame == false) // если текущий игрок не в игре
        {
            if (!isEndGame()) // и это не конец игры
            {
                NextPlayer(); // то активируем следущего
            }
            else // иначе пишем что конец
            {
                // если победитель пустой, значит выбили одновременно => ничья
                if (GetWinner() != null) {
                    JOptionPane.showMessageDialog(null, "Игра завершена! Победил игрок " + GetWinner().name, "Game Over!", JOptionPane.PLAIN_MESSAGE);
                }
                else
                    JOptionPane.showMessageDialog(null, "Игра завершена! Ничья!", "Game Over!", JOptionPane.PLAIN_MESSAGE);

            }
        }
        else if (curPlayer.inGame && !curPlayer.CanPlay()) // если у текущего игрока статус "в игре" и нет возможности сходить
        {
            JOptionPane.showMessageDialog (null, "Выбывает игрок " + curPlayer.name, "Game Over!", JOptionPane.PLAIN_MESSAGE);
            players.get(curPlayer.index).inGame = false;
            NextPlayer();
        }
    }

    // проверка на конец игры
    public boolean isEndGame()
    {
        int playersinGame = 0;
        for (int i =0;i<players.size();i++)
        {
            if (players.get(i).inGame)
                playersinGame++;
        }
        if (playersinGame >1) // если в игре больше 1 - то не конец
            return  false;
        else
            return  true;
    }
    // получить победителя
    public  Player GetWinner()
    {
        for (int i =0;i<players.size();i++)
        {
            if (players.get(i).inGame)
                return players.get(i);
        }
        return null;
    }
    public  Player GetCurrentPlayer()
    {
        return  curPlayer;
    }
}
