package rd.tutorial.ph.view;

import rd.tutorial.ph.AppMain;
import rd.tutorial.ph.controller.HashController;
import rd.tutorial.ph.model.UserAuth;
import rd.tutorial.ph.util.HashGenerator;

/**
 *
 * @author Raslan Rauff
 */
public class SetupAuthView implements DisplayView{

    public int displayContent() {
        String username = "", password = "", passwordHash = "";
        UserAuth userAuth;
        
        System.out.println("Please enter following details to create / update" +
                " User Auth details.");
        System.out.print("\nUsername : ");
        username = AppMain.sysIn.next();
        
        System.out.print("\nPassword : ");
        password = AppMain.sysIn.next();
        
        //get password hash
        passwordHash = HashGenerator.getSHA256(password);
        
        //initialize user atuh
        userAuth = new UserAuth(username, passwordHash);
        
        //setup password
        HashController.getInstance().setupAuth(userAuth);
        
        System.out.println("Password successfully updated.");
        System.out.println("Generated hash is : " + passwordHash);
        
        //GC support
        username = password = passwordHash = null;
        userAuth = null;
        
        return 0;
    }
    
}
