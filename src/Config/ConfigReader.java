package Config;
/*
    Reads config.txt and acts as a collection of global variables
*/

import java.util.HashMap;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class ConfigReader {
    private static HashMap<String, Integer> options = new HashMap<String, Integer>();

    public static void readConfig(){
        try {
            Scanner s = new Scanner(new File("src/config.txt"));
            while (s.hasNextLine()) {
                String[] line = s.nextLine().split("\\s*=\\s*");
                options.put(line[0], Integer.parseInt(line[1]));
            }
        }
        catch(FileNotFoundException e){
            // TODO: Implement default config
        }
    }

    public static int getOption(String key){
        return options.get(key);
    }
    public static void setOption(String key, int value){
        options.put(key, value);
    }
}
