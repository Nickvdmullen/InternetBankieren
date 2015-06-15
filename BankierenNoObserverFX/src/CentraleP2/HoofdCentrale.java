/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CentraleP2;

import bank.bankieren.Bank;
import bank.bankieren.Money;
import fontys.util.NumberDoesntExistException;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

/**
 *
 * @author Mnesymne
 */
public class HoofdCentrale extends UnicastRemoteObject implements ICentraleToBank {

    private ArrayList<IBankToCentrale> allBanks;
    private Registry reg;

    public HoofdCentrale() throws RemoteException, MalformedURLException {
        int port = 1090;
        reg = java.rmi.registry.LocateRegistry.createRegistry(port);
        reg.rebind("Centrale", this);
        allBanks = new ArrayList();
    }

    @Override
    public int RegisterBank(String Bank, Bank myBank) throws RemoteException {
        boolean contains = true;
        for (IBankToCentrale b : allBanks) {
            if (b.getName().equals(myBank.getName())) {
                contains = true;
            } else {
                contains = false;
            }
        }

        if (!contains) {
            allBanks.add(myBank);
            return allBanks.indexOf(myBank);
        }
        return -1;

    }

    @Override
    public boolean maakOver(int RekeningNR, Money saldo) throws RemoteException, NumberDoesntExistException {
        int bankNR = RekeningNR / 10000000;
        IBankToCentrale b = allBanks.get(bankNR);
        if (b != null) {
            return b.muteerVanCentrale(RekeningNR, saldo);
        }
        return false;
    }
}
