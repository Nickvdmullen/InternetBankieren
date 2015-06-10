/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bank.bankieren;

import bank.internettoegang.Balie;
import bank.internettoegang.IBalie;
import java.rmi.RemoteException;
import junit.framework.Assert;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Mnesymne
 */
public class IBalieTest {

    public IBalieTest() {
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

    @Test
    public void testOpenRekening() throws RemoteException {
        /**
         * creatie van een nieuwe bankrekening; het gegenereerde
         * bankrekeningnummer is identificerend voor de nieuwe bankrekening en
         * heeft een saldo van 0 euro
         *
         * @param naam van de eigenaar van de nieuwe bankrekening
         * @param plaats de woonplaats van de eigenaar van de nieuwe
         * bankrekening
         * @param wachtwoord van het account waarmee er toegang kan worden
         * verkregen tot de nieuwe bankrekening
         * @return null zodra naam of plaats een lege string of wachtwoord
         * minder dan vier of meer dan acht karakters lang is en anders de
         * gegenereerde accountnaam(8 karakters lang) waarmee er toegang tot de
         * nieuwe bankrekening kan worden verkregen
         */

        IBank bank1 = new Bank("ABNAMRO");
        IBank bank2 = new Bank("ING");

        String correctName = "Henk";
        String incorrectName = "Jur";
        String correctPlaats = "Eindhoven";
        String incorrectPlaats = "Gol";
        String kortWachtwoord = "123";
        String langWachtwoord = "123456789";
        String correctWachtwoord = "12345678";

        IBalie ballie = null;
        try {
            ballie = new Balie(bank1);
        } catch (RemoteException ex) {
            System.out.println("remote exception");
        }

       
            if (ballie.openRekening(correctName, correctPlaats, correctWachtwoord) != null) {
                Assert.assertTrue(true);
            } else {
                fail();
            }


        try {
            if (ballie.openRekening(incorrectName, correctPlaats, correctWachtwoord) != null) {
                fail();
            } else {
                Assert.assertTrue(true);
            }
        } catch (Exception ex) {

        }

        try {
            if (ballie.openRekening(correctName, incorrectPlaats, correctWachtwoord) != null) {
                fail();
            } else {
                Assert.assertTrue(true);
            }
        } catch (Exception ex) {

        }

        try {
            if (ballie.openRekening(incorrectName, correctPlaats, langWachtwoord) != null) {
                fail();
            } else {
                Assert.assertTrue(true);
            }
        } catch (Exception ex) {

        }

        try {
            if (ballie.openRekening(incorrectName, correctPlaats, kortWachtwoord) != null) {
                fail();
            } else {
                Assert.assertTrue(true);
            }
        } catch (Exception ex) {

        }

    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
}
