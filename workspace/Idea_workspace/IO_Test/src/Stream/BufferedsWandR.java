package Stream;

import java.io.*;

public class BufferedsWandR {
    public static void main(String[] args) {
        test t = new test();
        t.copyText();
    }
}

class test {


    public void copyText() {
        BufferedReader br = null;
        BufferedWriter bw = null;

        try {
            br = new BufferedReader(new FileReader("li.text"));
            bw = new BufferedWriter(new FileWriter("li-copy.text",true));
            String s = null;
            while ((s = br.readLine()) != null) {
                bw.append(s);
                bw.newLine();
                bw.flush();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (br != null) {
                    br.close();
                }
                if (bw != null) {
                    bw.close();
                }

            } catch (IOException e) {
                e.printStackTrace();
            }


        }

    }


}

