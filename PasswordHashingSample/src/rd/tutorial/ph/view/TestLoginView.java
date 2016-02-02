package rd.tutorial.ph.view;

import rd.tutorial.ph.AppMain;
import rd.tutorial.ph.controller.HashController;
import rd.tutorial.ph.model.UserAuth;
import rd.tutorial.ph.util.HashGenerator;

/**
 *
 * @author Raslan Rauff
 */
public class TestLoginView implements DisplayView{
    @Override
    public int displayContent() {
        String username = "", password = "", passwordHash = "";
        UserAuth userAuth = null;
        
        System.out.println("Fill following details to test authentication matches");
        
        System.out.print("\nUsername : ");
        username = AppMain.sysIn.next();
        
        System.out.print("\nPassword : ");
        password = AppMain.sysIn.next();
        
        //generate password hash
        passwordHash = HashGenerator.getSHA256(password);
        
        userAuth = new UserAuth(username, passwordHash);
        
        //verify auth
        if(userAuth.equals(HashController.getInstance().getAuth()))
            System.out.println("Success : Valid username and password entered");
        else
            System.out.println("Error : Invalid username or password entered");
        
        System.out.println("Generated hash is : " + passwordHash);
        
        //GC support
        username = password = passwordHash;
        userAuth = null;
        
        return 0;
    }
    
}
