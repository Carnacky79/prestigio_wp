import java.io.*;
import java.nio.file.*;

public class MainClass {
    public static void main(String[] args) throws IOException {
        String canonicalPath = new File(".").getCanonicalPath() + "\\listino.xlsx";

        ExcelClass excel = new ExcelClass(canonicalPath);

    }
}
