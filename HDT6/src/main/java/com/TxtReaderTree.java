package com;
import java.util.TreeMap;
import java.io.BufferedReader;
import java.io.FileReader;


public class TxtReaderTree {
    private TreeMap<String, String> map = new TreeMap<String, String>();

    public TreeMap<String, String>  readTxt(String path) {

        
        try {
            BufferedReader br = new BufferedReader(new FileReader(path));
            String line = br.readLine();
            while (line != null) {
                String[] parts = line.split("|");
                map.put(parts[0], parts[1]);
                line = br.readLine();
            }
            br.close();
        return map;
        
        
        }
        catch (Exception e) {
            System.out.println("Error: " + e);
            return null;
        }
}
}
