import java.io.PrintWriter;             // to write
import java.io.FileOutputStream;        // to write
import java.io.FileNotFoundException;

import java.util.Scanner;               // to read
import java.io.FileInputStream;         // to read

import java.io.BufferedReader;
import java.io.FileReader;

import java.io.File;
import java.io.IOException;

import java.util.StringTokenizer;

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

            System.out.println("Processing files");
            String[] invalidFileNums = processFilesForValidation(input, output);

            for (int i=0; i<output.length; i++) {
                if (output[i] != null) output[i].close();
            }

            System.out.println("Deleting invalid files.");
            File f;
            for (int i=0; i<invalidFileNums.length; i++) {
                f = new File("Output_Files/IEEE" + invalidFileNums[i] + ".json");
                if (f.delete()) {
                    System.out.println("Deleted " + f);
                }

                f = new File("Output_Files/ACM" + invalidFileNums[i] + ".json");
                if (f.delete()) {
                    System.out.println("Deleted " + f);
                }

                f = new File("Output_Files/NJ" + invalidFileNums[i] + ".json");
                if (f.delete()) {
                    System.out.println("Deleted " + f);
                }
            }

        }
        catch (FileNotFoundException e) {
            System.out.println("Could not open input file Latex"+ (k+1) + ".bib for reading. Please check if file exists! Program will terminate after closing any opened files.\n");
        }
        finally {
            for (int j=0; j<k; j++) {
                if (input[j] != null) input[j].close();
                System.out.println("Closed Comp249_W20_Assg3_Files/Latex" + (j+1) + ".bib");
            }
        }

        // Scanner in = new Scanner(System.in);
        // BufferedReader reader = null;
        // for (int i=0; i<2; i++) {
        //     try {
        //         System.out.println("Enter a file to display");
        //         reader = new BufferedReader(new FileReader(in.nextLine()));
        //
        //         System.out.println("File is valid.");
        //
        //         if (reader != null) reader.close();
        //         break;
        //     }
        //     catch (FileNotFoundException e) {
        //         if (i==0) System.out.println(e.getMessage() + " Try again.");
        //         if (i==1) System.out.println(e.getMessage() + " Terminating program.");
        //     }
        //     catch (IOException e) {
        //         System.out.println(e.getMessage());
        //     }
        // }

        System.out.println("\nThanks for using the best program.");

    }

    public static String[] processFilesForValidation(Scanner[] input, PrintWriter[] output) {
        String invalidFiles = "";
        for (int i=0; i<input.length; i++) {
            try {
                //boolean valid = true;

                int j=0;
                String article = "";
                while (input[i].hasNextLine()) {
                    String line = input[i].nextLine();

                    if (line.contains("@ARTICLE")) j++;
                    if (line.contains("{}")) {
                        invalidFiles += (i+1) + " ";
                        throw new FileInvalidException("Invalid file at Latex" + (i+1) + " at article " + j);
                    }

                    article += line + "\n";
                }

                String[] toPrint = new String[3];
                toPrint = doStuff(article, j);

                output[3*i + 0].println(toPrint[0]);
                output[3*i + 1].println(toPrint[1]);
                output[3*i + 2].println(toPrint[2]);

                // if (!valid) {
                //     throw new FileInvalidException("just a test");
                // }
            }
            catch (FileInvalidException e) {
                System.out.println(e.getMessage());
                System.out.println("File will not be converted");
            }
        }

        return invalidFiles.split(" ");


    }

    public static String[] doStuff(String s, int j) {
        String[] article = s.split("\n");
        //for (int i=0; i<article.length; i++) System.out.println(article[i]);

        Article[] references = new Article[j];
        for (int i=0; i<references.length; i++) references[i] = new Article();

        int k = 0;
        int numFields = 0;
        String field, ans = null;

        for (int i=0; i<article.length; i++) {
            while (article[i].length() == 0) {
                //System.out.println("article " + article[i]);
                i++;
            }

            StringTokenizer st = null;
            try {
                st = new StringTokenizer(article[i], "=");
            }
            catch (NullPointerException e) {
                System.out.println("Error: " + e);
            }

            field = st.nextToken();
            //System.out.println("field " + field + " field");

            if (st.countTokens() > 0) {
                ans = st.nextToken();
                //System.out.println("ans " + ans + " ans");
                numFields++;
            }

            switch (field) {
                case "author":
                    references[k].setAuthor(ans);
                    break;
                case "journal":
                    references[k].setJournal(ans);
                    break;
                case "title":
                    references[k].setTitle(ans);
                    break;
                case "year":
                    references[k].setYear(ans);
                    break;
                case "volume":
                    references[k].setVolume(ans);
                    break;
                case "number":
                    references[k].setNumber(ans);
                    break;
                case "pages":
                    references[k].setPages(ans);
                    break;
                case "keywords":
                    references[k].setKeywords(ans);
                    break;
                case "doi":
                    references[k].setDoi(ans);
                    break;
                case "ISSN":
                    references[k].setISSN(ans);
                    break;
                case "month":
                    references[k].setMonth(ans);
                    break;

            }

            //System.out.println(numFields);
            if (numFields == 11) {
                numFields = 0;
                // System.out.println("k " + k);
                // System.out.println("field " + field + " field");
                k++;
            }
        }

        String[] cite = {"", "", ""};
        for (int i=0; i<references.length; i++) {
            //System.out.println("REFERENCE IEEE: " + references[i].IEEE());
            cite[0] += "["+(i+1)+"] " + references[i].IEEE() + "\n\n";
            //System.out.println("REFERENCE ACM: " + references[i].ACM());
            cite[1] += "["+(i+1)+"] " + references[i].ACM() + "\n\n";
            //System.out.println("REFERENCE NJ: " + references[i].NJ());
            cite[2] += "["+(i+1)+"] " + references[i].NJ() + "\n\n";
            //System.out.println("\n\n");
        }

        System.out.println("returning");
        return cite;
    }

}
