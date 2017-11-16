/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package profiler.wrks;

import java.util.Scanner;

/**
 *
 * @author skyid
 */
public class Wrk {

    private WrkDB wrkDB;
    private WrkQR wrkQR;

    public void getCommand() {
        wrkDB = new WrkDB();
        wrkQR = new WrkQR();

        Scanner scanner = new Scanner(System.in);
        interpretCommand(scanner.nextLine());
    }

    private void interpretCommand(String cmd) {
        switch (cmd) {
            case "quit":
                System.exit(0);
                break;
            case "info":
                System.out.println(wrkDB.getCompte(2));
                break;
            case "contacts":
                wrkDB.getContacts(4);
                break;
            case "add":
                System.out.println(wrkDB.addFriend(4, 3));
                break;
            case "createQR":
                wrkQR.generateQR(wrkDB.getCompte(4));
                break;
        }
    }

}
