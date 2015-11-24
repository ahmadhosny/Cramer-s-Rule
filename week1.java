/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package week1;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ahmed.hosny
 */
public class Week1 {

    static int noOfInverts = 0;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        FileReader in = null;
        ArrayList<Integer> intArray = new ArrayList<>();
        int doLoopCounter = 0, intArraySize = 0;
        String tempStr = "";
        try {
            // create the file reader
            in = new FileReader("C:\\Users\\ahmed.hosny\\Documents\\Algo\\IntegerArray.txt");
            // read all the characters
            int tempChar;
            do {
                doLoopCounter++;
                //read a character
                tempChar = in.read();
                if (tempChar >= 0) {
                    // convert int to char
                    char theChar = (char) tempChar;
                    // process each character here
                    if (48 <= tempChar && tempChar <= 57) {
                        tempStr += theChar;
                    } else {
                        if (tempStr.isEmpty()) {
                            continue;
                        }
                        intArray.add(intArraySize, Integer.parseInt(tempStr));
                        tempStr = "";
                    }
                }
            } while (tempChar != -1);
            System.out.println(countInversions(intArray));
        } catch (IOException ex) {
            Logger.getLogger(Week1.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if (in != null) {
                    in.close();
                }
            } catch (IOException ex) {
                Logger.getLogger(Week1.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    private static int countInversions(List<Integer> array) {
        int arrSize = array.size();
//        System.out.println("Entering count inversions method. Array size is: " + arrSize);
//        int noOfInverts = 0;
        int tempB = 0;
        int tempC = 0;
        List<Integer> b;
        List<Integer> c;
        List<Integer> d = new ArrayList<>();
//        int i = 0;
//        int j = 0;

        if (arrSize >= 2) {
            b = array.subList(0, arrSize / 2);
            c = array.subList(arrSize / 2, arrSize);

            tempB = countInversions(b);
            tempC = countInversions(c);
            d = merge(b, c);
        }
        return noOfInverts;
    }

    private static List<Integer> merge(List<Integer> b, List<Integer> c) {
        List<Integer> result = new ArrayList<>();
        int k = 0, i = 0, j = 0;
        while (i + j < b.size() + c.size()) {
            if (i < b.size() && b.get(i) < c.get(j)) {
                result.add(b.get(i));
                i++;
            } else {
                result.add(c.get(j));
                j++;
                noOfInverts++;
            }
            k++;
        }
        System.out.println("i=" + i + ", j=" + j + ", k=" + k);
        System.out.println("Exiting the loop with the merged array size is " + result.size() + "...");
        return result;
    }
}
