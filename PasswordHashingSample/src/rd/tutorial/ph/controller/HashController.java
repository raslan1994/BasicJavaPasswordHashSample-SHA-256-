package rd.tutorial.ph.controller;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import rd.tutorial.ph.model.UserAuth;

/**
 *
 * @author Raslan Rauff
 */
public class HashController {
    
    private static HashController hashController;
    
    public static HashController getInstance(){
        if(hashController == null)
            hashController = new HashController();
        
        //return
        return hashController;        
    }
    
    private static final String FILE_NAME = "hashes.dat";
    
    public void setupAuth(UserAuth userAuth){
        //save auth
        serializeObject(userAuth);
    }
    
    public UserAuth getAuth(){
        //reat auth
        UserAuth data = deserializeObject();
        return data;
    }
    
    private void serializeObject(UserAuth userAuth){
        try{
            FileOutputStream fos = new FileOutputStream(HashController.FILE_NAME);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            
            oos.writeObject(userAuth);
            oos.close();
            
            //GC improvement
            oos = null;
            fos = null;
        }catch(Exception ex){
            ex.printStackTrace();
        }
    }
    
    private UserAuth deserializeObject(){
        UserAuth data = new UserAuth();
        
        try{
            FileInputStream fis = new FileInputStream(HashController.FILE_NAME);
            ObjectInputStream ois = new ObjectInputStream(fis);
            
            data = (UserAuth) ois.readObject();
            
            ois.close();
            
            //GC improvements
            fis = null;
            ois = null;
            
        }catch(Exception ex){
            ex.printStackTrace();
        }
        
        return data;
    }
}
