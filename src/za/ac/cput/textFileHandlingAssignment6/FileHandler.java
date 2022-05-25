/* Byron Young
   Text File Handling With GUI Assignment 6
   218155077 
 */
package za.ac.cput.textFileHandlingAssignment6;

import java.awt.event.ActionEvent;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class FileHandler {

    FileWriter fw;
    BufferedWriter bw;

    //opens a text file for writing or appending
    public void openFile() {
        try {
            String filename = "Output6.txt";
            fw = new FileWriter(filename,true);
            bw = new BufferedWriter(fw);

        } catch (IOException e) {
            System.out.println("File writing error");
        }
    }

    //writes a string to the file
    public void processFile(String record) {

        try {
            bw.write(record);
        } catch (IOException e) {
            System.out.println("File writing error");
        }

    }

    //closes the file
    public void closeFile() {
        try {
            bw.close();
        } catch (IOException e) {
            System.out.println("Closing error");
        }
    }

}
