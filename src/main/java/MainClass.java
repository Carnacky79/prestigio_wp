import java.io.*;
import java.nio.file.*;
import java.util.*;

public class MainClass {
    public static void main(String[] args) throws IOException {
        String canonicalPath = new File(".").getCanonicalPath() + "\\listino.xlsx";
        String outputFile = new File(".").getCanonicalPath() + "\\testout.txt";
        HashMap<String, ArrayList<String[]>> fogli = new HashMap<>();

        ExcelClass excel = new ExcelClass(canonicalPath);

        fogli = excel.leggiFogli();

        FileWriter fw = new FileWriter(outputFile, true);
        for(ArrayList<String[]> s : fogli.values()){
            for(String[] c : s){
                String riga = String.join("|", c);
                fw.write(riga);
                fw.write('\n');
            }
            fw.write("-------------------------------------");
        }

        fw.close();

    }
}
