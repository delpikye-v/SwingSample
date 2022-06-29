
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author ASUC-PC
 */
public class Main {

    public static void main(String[] args) throws FileNotFoundException {
        BufferedReader reader;
        String[] txt= new String[]{"eci_", "earfcn_", "pci_", "lte_cell_flag_", "rsrp_", "rsrq_"};
//        try {
//            
//            List<String> list = new ArrayList<>();
//            list.addAll(Arrays.asList(txt));
//
//            int i = 0;
//            reader = new BufferedReader(new FileReader(
//                    "C:\\Users\\ASUC-PC\\Documents\\NetBeansProjects\\SwingSample\\newfile.txt"));
//            String line = reader.readLine();
//            while (line != null) {
//                i++;
//                boolean isExist = false;
//                for (String string : list) {
//                    if (line.startsWith(string)) {
//                        isExist = true;
//                    }
//                }
//                
//                if (isExist) {
//                    System.out.println(line + ": " + i + ",");
//                }
//                // read next line
//                line = reader.readLine();
//            }
//            reader.close();
//        } catch (IOException e) {
//        }
        // 28, 29, 30, 31, 32, 33

        int start = 28;
        int index = 28;
        for (int i = 0; i < 26; i++) {
            for (String txt1 : txt) {
                System.out.println(txt1 + start + " : " + (index));
                index++;
            }
            start++;
        }
    }

}
