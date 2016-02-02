package rd.tutorial.ph;

import java.util.Scanner;
import rd.tutorial.ph.view.DisplayView;
import rd.tutorial.ph.view.PrimaryView;
import rd.tutorial.ph.view.SetupAuthView;
import rd.tutorial.ph.view.TestLoginView;

/**
 *
 * @author Raslan Rauff
 */
public class AppMain {
    public static final Scanner sysIn = new Scanner(System.in);
    
    public static void main(String [] args){
        DisplayView curView;
        int viewOut = 0;
        
        while(viewOut != 3){
            curView = new PrimaryView();
            viewOut = curView.displayContent();
            
            switch (viewOut) {
                case 1:
                    curView = new TestLoginView();
                    break;
                case 2:
                    curView = new SetupAuthView();
                    break;
                case 3 :
                    System.out.println("Demo ends.");
                    break;
                default:
                    System.out.println("Invalid option entered.");
                    break;
            }
            
            if(!(curView instanceof PrimaryView))
             viewOut = curView.displayContent();
        }
    }
}
