import java.io.*;
import java.nio.file.*;
import java.util.*;

public class MainClass {
    public static void main(String[] args) throws IOException {
        String inputFile = new File(".").getCanonicalPath() + "\\testout.txt";
        FileReader fileReader = new FileReader(inputFile);
        String[] riga;
        ArrayList<String[]> righe = new ArrayList<>();

        try (BufferedReader bufferedReader = new BufferedReader(fileReader)) {
            String line;
            while((line = bufferedReader.readLine()) != null) {
                riga = new String[6];
                riga = line.split("\\|");
                righe.add(riga);
            }
        }


    }
}
