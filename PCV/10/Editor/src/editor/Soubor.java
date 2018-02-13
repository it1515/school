/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package editor;

import java.io.*;
/**
 *
 * @author student
 */
public class Soubor {
    
    private String data;
    Soubor() {
    }
    
    public String getData() {
        return data;
    }
    
    public void setData(String data) {
        this.data = data;
    }
    
    public Boolean nactiZeSouboru(File soubor, String charset)
            throws FileNotFoundException {
        data = "";
    try {
        InputStream inputStream = new FileInputStream(soubor);
        Reader reader = new InputStreamReader(inputStream,charset);
        int znak;
        do{
            znak = reader.read();
            if(znak != -1) data += (char) znak;
        } while(znak != -1);
    } catch (IOException e) {
        return false;
    }
    return true;
    }
    
    public Boolean ulozDoSouboru(File soubor, String charset)
            throws FileNotFoundException {
    try {
        OutputStream outputStream = new FileOutputStream(soubor);
        Writer writer = new OutputStreamWriter(outputStream,charset);
        writer.write(data);
    } catch (IOException e) {
        return false;
    }
    return true;
    }
}
