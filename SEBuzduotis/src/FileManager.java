
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Aneta
 */
public class FileManager {

    
    public String[] getFromFile(String filePath, String fileName) throws IOException{
        
        ArrayList<String> ibansArrayList = new ArrayList<String>() ;

        String currentIbanString;
        FileReader fileLocation = new FileReader(filePath); 
         int i = 0;
         
        try {        
            BufferedReader file = new BufferedReader(fileLocation);
            
            while ((currentIbanString = file.readLine()) != null) {
                ibansArrayList.add(currentIbanString);
                i++;
            }

        } catch (FileNotFoundException ex) {
            Logger.getLogger(FileManager.class.getName()).log(Level.SEVERE, null, ex);
          }
        
        String[] ibansStringArray = ibansArrayList.toArray(new String[]{});
        return ibansStringArray;
    }

    
    public void writeToFile(String[] checkedIbans, String fileName){
        
       BufferedWriter fileWriter = null;
        try {
            fileWriter = new BufferedWriter(new FileWriter(fileName+".out"));

            for(int i =0; i < checkedIbans.length; i++){
                fileWriter.write(checkedIbans[i]);
                fileWriter.newLine();
            }
            
        } catch (IOException ex) {
            Logger.getLogger(FileManager.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                fileWriter.close();
            } catch (IOException ex) {
                Logger.getLogger(FileManager.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
 