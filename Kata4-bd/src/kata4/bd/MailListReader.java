/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kata4.bd;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author josevicentecabanas
 */
public class MailListReader {
    public static ArrayList<String> read (String name) throws IOException {
        ArrayList <String> mailList= new ArrayList<>();
        
        BufferedReader fileRead = new BufferedReader(new FileReader(new File(name)));
        String mail;
        while ((mail = fileRead.readLine()) != null) {
            if (!mail.contains("@")) continue;
            mailList.add(mail);
        }
        return mailList;
                
    }
    
}
