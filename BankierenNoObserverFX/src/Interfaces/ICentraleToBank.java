/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces;

import bank.bankieren.Bank;
import java.rmi.RemoteException;

/**
 *
 * @author Mnesymne
 */
public interface ICentraleToBank {
    
    
    /**
     * Geeft naam van de Bank mee, en de Bank zelf. Wordt een check gedaan of de bank nog niet aangemeld is bij de centrale, zo niet word 
     * deze aan de lijst toegevoegd. 
     * @param Bank De instantie van de Bank, deze is nodig voor acties te kunnen doen
     * @param myBank De naam van de Bank, word meegegeven om te checked of deze al aangemeld is, en gebruikt om in de hashmap te zoeken.
     * @return int Nummer waar alle rekeningen van de bank mee moeten beginnen.
     * @throws RemoteException 
     */
    public int getBeginNR(String Bank, Bank myBank) throws RemoteException;
}
