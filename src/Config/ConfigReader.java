package Config;
/*
    Reads config.txt and acts as a collection of global variables
*/

import java.util.HashMap;
import java.util.Scanner;
import java.io.File;
import java.io.FileWriter;
import java.io.FileNotFoundException;
import java.io.IOException;

public class ConfigReader {
    private static HashMap<String, Integer> options = new HashMap<String, Integer>();

    public static void readConfig(){
        try {
            Scanner s = new Scanner(new File("config.txt"));
            while (s.hasNextLine()) {
                String[] line = s.nextLine().split("\\s*=\\s*");
                options.put(line[0], Integer.parseInt(line[1]));
            }
        }
        catch(FileNotFoundException e){
            try {
                File defaultConfig = new File("config.txt");
                defaultConfig.createNewFile();

                FileWriter writer = new FileWriter("config.txt");
                writer.write("width = 600\n");
                writer.write("height = 400\n");
                writer.write("guiPadding = 100\n");
                writer.write("brushSize = 12\n");
                writer.write("bgColor = 0");
                writer.close();

                readConfig();
            } catch (IOException i) {System.out.print(e);}
        }
    }

    public static int getOption(String key){
        return options.get(key);
    }
    public static void setOption(String key, int value){
        options.put(key, value);
    }
}
