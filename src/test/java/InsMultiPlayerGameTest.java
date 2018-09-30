/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author pedago
 */
public class InsMultiPlayerGameTest {
    
    public InsMultiPlayerGameTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    @org.junit.Test
    public void testStartMethod() throws Exception {
        String[] joueurs = {"Fred", "Didier", "Marcel", "Roger", "Gérard"};
        InsMultiPlayerGame multi = new InsMultiPlayerGame();
        assertEquals("Prochain tir : joueur Fred, tour n° 1, boule n° 0",multi.startNewGame(joueurs));
    }
    
    @org.junit.Test
    public void testLancerMethod() throws Exception {
        String[] joueurs = {"Fred", "Didier", "Marcel", "Roger", "Gérard"};
        InsMultiPlayerGame multi = new InsMultiPlayerGame();
        multi.startNewGame(joueurs);
        assertEquals("Prochain tir : joueur Fred, tour n° 1, boule n° 1",multi.lancer(7));
    }
    
    @org.junit.Test
    public void testScoreForMethod() throws Exception {
        String[] joueurs = {"Fred", "Didier", "Marcel", "Roger", "Gérard"};
        InsMultiPlayerGame multi = new InsMultiPlayerGame();
        multi.startNewGame(joueurs);
    }
}
