import java.io.PrintWriter;             // to write
import java.io.FileOutputStream;        // to write
import java.io.FileNotFoundException;

import java.util.Scanner;               // to read
import java.io.FileInputStream;         // to read

public class BibliographyFactory {

    public static void main(String[] args) {

        Scanner[] inputStream = new Scanner[10];

        for (int i=0; i<inputStream.length; i++) {
            try {
                inputStream[i] = new Scanner(new FileInputStream("Comp249_W20_Assg3_Files/Latex"+ (i+1) + ".bib"));
            }
            catch (FileNotFoundException e) {
                System.out.println(e);
            }
            catch(Exception e) {
                System.out.println(e);
            }
            finally {
                if (inputStream[i] != null) inputStream[i].close();
                System.out.println("Comp249_W20_Assg3_Files/Latex" + i + ".bib");
            }
        }

    }

}
