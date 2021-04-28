package presentation;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class Log { // singleton
    private PrintWriter pw ;
    private File file ;
    private static Log instance ;
    private static Object obj = new Object();

    private Log() throws FileNotFoundException {
        file = new File("text.txt");
        pw = new PrintWriter(file);
    }
    public static Log getInstance() throws FileNotFoundException {
        if (instance == null){
            synchronized (obj){
                if (instance == null){
                    instance = new Log();
                }
            }
        }
        return instance;
    }
    public void writeToFile(String textLine)
    {
        pw.println(textLine);
    }
    public void closeFile(){
        pw.close();
    }
}