
import bowling.MultiPlayerGame;
import bowling.SinglePlayerGame;
import java.util.ArrayList;
import java.util.HashMap;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author pedago
 */
public class InsMultiPlayerGame implements MultiPlayerGame {

    private String[] names;
    private int currentPlayer = 0;
    public boolean gameOn = false;
    
    protected HashMap <Integer, SinglePlayerGame> players;
    
    /**
	 * Démarre une nouvelle partie pour un groupe de joueurs
	 * @param playerName un tableau des noms de joueurs (il faut au moins un joueur)
	 * @return une chaîne de caractères indiquant le prochain joueur,
	 * de la forme "Prochain tir : joueur Bastide, tour n° 5, boule n° 1"
	 * @throws java.lang.Exception si le tableau est vide ou null
	 */
    @Override
    public String startNewGame(String[] playerNames) throws Exception {
        gameOn = true;
        players = new HashMap<>();
        names=playerNames;
        if (playerNames.length < 1) {
            throw new IllegalArgumentException("Pas assez de joueurs");
        }
        else {
            for (int i=0;i<playerNames.length;i++) {
                SinglePlayerGame sg = new SinglePlayerGame();
                players.put(i,sg);
            }
        }
        return "Prochain tir : joueur " + names[currentPlayer] + ", tour n° " + players.get(currentPlayer).getCurrentFrame().getFrameNumber() + ", boule n° " + players.get(currentPlayer).getCurrentFrame().getBallsThrown();
    }

    /**
	 * Enregistre le nombre de quilles abattues pour le joueur courant, dans le frame courant, pour la boule courante
	 * @param nombreDeQuillesAbattues : nombre de quilles abattue à ce lancer
	 * @return une chaîne de caractères indiquant le prochain joueur,
	 * de la forme "Prochain tir : joueur Bastide, tour n° 5, boule n° 1",
	 * ou bien "Partie terminée" si la partie est terminée.
	 * @throws java.lang.Exception si la partie n'est pas démarrée, ou si elle est terminée.
	 */
    @Override
    public String lancer(int nombreDeQuillesAbattues) throws Exception {
        players.get(currentPlayer).lancer(nombreDeQuillesAbattues);
        if (currentPlayer==names.length-1 && players.get(currentPlayer).getCurrentFrame().getFrameNumber()==10 && players.get(currentPlayer).getCurrentFrame().isFinished()) {
            gameOn = false;
            return "Partie terminée";
        }
        if (gameOn==false) {
            throw new Exception("Partie non démarrée ou terminée");
        }
        else {
            if (players.get(currentPlayer).getCurrentFrame().isFinished()) {
                if (currentPlayer==names.length-1) {
                    currentPlayer=0;
                }
                else {
                    currentPlayer++;
                }
        }
        return "Prochain tir : joueur " + names[currentPlayer] + ", tour n° " + players.get(currentPlayer).getCurrentFrame().getFrameNumber() + ", boule n° " + players.get(currentPlayer).getCurrentFrame().getBallsThrown();
        }
    }


    /**
	 * Donne le score pour le joueur playerName
	 * @param playerName le nom du joueur recherché
	 * @return le score pour ce joueur
	 * @throws Exception si le playerName ne joue pas dans cette partie
	 */
    @Override
    public int scoreFor(String playerName) throws Exception {
        for (int i=0;i<names.length;i++) {
            if (names[i].equals(playerName)) {
                return players.get(i).score();
            }
        }
        throw new Exception("Ce joueur ne joue pas dans cette partie");
    }
    
}
