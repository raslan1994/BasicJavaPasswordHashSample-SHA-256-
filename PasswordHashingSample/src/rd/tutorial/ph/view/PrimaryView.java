package rd.tutorial.ph.view;

import rd.tutorial.ph.AppMain;

/**
 *
 * @author Raslan Rauff
 */
public class PrimaryView implements DisplayView{
    @Override
    public int displayContent() {
        int loc = 0;
        
        System.out.println("Password Hash Demo - SHA 256 ");
        System.out.println("*--------*----------------------*");
        System.out.println("|OPTION  | DESCRIPTION          |");
        System.out.println("*--------*----------------------*");
        System.out.println("|    1   | Test Login           |");
        System.out.println("|    2   | Setup Authentication |");
        System.out.println("|    3   | Exit                 |");
        System.out.println("*--------*----------------------*");
        
        System.out.print("Enter an option to continue : ");
        loc = AppMain.sysIn.nextInt();
        
        return loc;
    }
}
