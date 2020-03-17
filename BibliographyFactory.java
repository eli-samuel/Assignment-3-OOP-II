import java.io.PrintWriter;             // to write
import java.io.FileOutputStream;        // to write
import java.io.FileNotFoundException;

import java.util.Scanner;               // to read
import java.io.FileInputStream;         // to read

import java.io.BufferedReader;
import java.io.FileReader;

import java.io.File;
import java.io.IOException;

public class BibliographyFactory {

    public static void main(String[] args) {

        Scanner[] input = new Scanner[10];
        PrintWriter[] output = new PrintWriter[30];

        System.out.println("Welcome to Bibliography Factory\n");

        int k=0;
        try {
            for (k=0; k<input.length; k++) {
                input[k] = new Scanner(new FileInputStream("Comp249_W20_Assg3_Files/Latex" + (k+1) + ".bib"));
            }
            // All files have been opened

            // Create ouput files
            try {
                for (int i=0; i<input.length; i++) {
                    output[3*i + 0] = new PrintWriter(new FileOutputStream("Output_Files/IEEE" + (i+1) + ".json"));
                    output[3*i + 1] = new PrintWriter(new FileOutputStream("Output_Files/ACM" + (i+1) + ".json"));
                    output[3*i + 2] = new PrintWriter(new FileOutputStream("Output_Files/NJ" + (i+1) + ".json"));
                }
            }
            catch (FileNotFoundException e) {

                System.out.println("Could not open output file " + e.getMessage());

                System.out.println("Closing output files before deleting");

                for (int i=0; i<output.length; i++) {
                    if (output[i] != null) output[i].close();
                }

                File f;
                for (int i=1; i<=input.length; i++) {
                    f = new File("Output_Files/IEEE" + i + ".json");
                    if (f.delete()) {
                        System.out.println("Deleted " + f);
                    }

                    f = new File("Output_Files/ACM" + i + ".json");
                    if (f.delete()) {
                        System.out.println("Deleted " + f);
                    }

                    f = new File("Output_Files/NJ" + i + ".json");
                    if (f.delete()) {
                        System.out.println("Deleted " + f);
                    }
                }

                for (int j=0; j<k; j++) {
                    if (input[j] != null) input[j].close();
                    System.out.println("Closed Comp249_W20_Assg3_Files/Latex" + (j+1) + ".bib");
                }

                System.out.println("All files closed and deleted. Exiting program.");
                System.exit(0);
            }

            processFilesForValidation(input, output);

        }
        catch (FileNotFoundException e) {
            System.out.println("Could not open input file Latex"+ (k+1) + ".bib for reading. Please check if file exists! Program will terminate after closing any opened files.\n");
        }
        catch(Exception e) {
            System.out.println(e);
        }
        finally {
            for (int j=0; j<k; j++) {
                if (input[j] != null) input[j].close();
                System.out.println("Closed Comp249_W20_Assg3_Files/Latex" + (j+1) + ".bib");
            }
        }

        Scanner in = new Scanner(System.in);
        BufferedReader reader = null;
        for (int i=0; i<2; i++) {
            try {
                System.out.println("Enter a file to display");
                reader = new BufferedReader(new FileReader(in.nextLine()));

                System.out.println("File is valid.");

                if (reader != null) reader.close();
                break;
            }
            catch (FileNotFoundException e) {
                if (i==0) System.out.println(e.getMessage() + " Try again.");
                if (i==1) System.out.println(e.getMessage() + " Terminating program.");
            }
            catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }

    }

    public static void processFilesForValidation(Scanner[] input, PrintWriter[] output) {
        try {
            for (int i=0; i<input.length; i++) {
                boolean valid = true;






                if (valid) {
                    throw new FileInvalidException("just a test");
                }
            }
        }
        catch (FileInvalidException e) {
            System.out.println(e.getMessage());
        }
    }

}
