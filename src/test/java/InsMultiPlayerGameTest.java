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
    
    String[] joueurs = {"Fred","Didier", "Marcel", "Roger", "Gérard"};
    InsMultiPlayerGame multi = new InsMultiPlayerGame();
    
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
        assertEquals("Prochain tir : joueur Fred, tour n° 1, boule n° 0",multi.startNewGame(joueurs));
    }
    
    @org.junit.Test
    public void testLancerMethod() throws Exception {
        multi.startNewGame(joueurs);
        assertEquals("Prochain tir : joueur Fred, tour n° 1, boule n° 1",multi.lancer(7));
        assertEquals("Prochain tir : joueur Didier, tour n° 1, boule n° 0",multi.lancer(3));
        assertEquals("Prochain tir : joueur Marcel, tour n° 1, boule n° 0",multi.lancer(10));
    }
    
    @org.junit.Test
    public void testScoreForMethod() throws Exception {
        multi.startNewGame(joueurs);
        
        multi.lancer(5);
        assertEquals(5,multi.scoreFor("Fred")); //Fred fait 5 au 1er lancé
        multi.lancer(2);
        assertEquals(7,multi.scoreFor("Fred")); //Fred fait 2 au second (5+2=7)
        
        multi.lancer(10); //Didier fait un strike
        assertEquals(10,multi.scoreFor("Didier"));
        
        multi.lancer(7);
        multi.lancer(3); //Marcel fait un spare
        
        multi.lancer(0);
        multi.lancer(0); //Roger fait 0
        
        multi.lancer(0);
        multi.lancer(0); //Gérard fait 0
        
        assertEquals(0,multi.scoreFor("Roger"));
        assertEquals(0,multi.scoreFor("Gérard"));
        
        multi.lancer(5);
        multi.lancer(0);
        
        assertEquals(12,multi.scoreFor("Fred"));
        
        multi.lancer(5);
        multi.lancer(2);
        
        assertEquals(24,multi.scoreFor("Didier")); //strike donc 10 + 5*2 + 2*2 = 24
        
        multi.lancer(5);
        multi.lancer(2);
        
        assertEquals(22,multi.scoreFor("Marcel")); //spare donc 10 + 5*2 + 2 = 22
    }
    
}
