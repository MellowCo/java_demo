import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class reg {
    public static void main(String[] args) throws IOException {
        InputStream is = null;
        BufferedOutputStream bos = null;
        int i = 0;
        String regex = "https.+\\)";
        List<String> aa = getMatchers(regex);

        System.out.println(aa);
//        for (String s : aa) {
//            is = new URL(s).openStream();
//            bos = new BufferedOutputStream(new FileOutputStream((i++) + ".png"));
//            byte[] datas = new byte[1024 * 2];
//            int len= -1;
//            while ((len = is.read(datas))!=-1){
//                bos.write(datas,0,len);
//            }
//            bos.flush();
//            System.out.println(s);
//        }
    }

    static List<String> getMatchers(String regex) {
        Pattern pattern = Pattern.compile(regex);
        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader("new.txt"));

            List<String> list = new ArrayList<>();
            String s = null;
            while ((s = br.readLine()) != null) {
                Matcher matcher = pattern.matcher(s);
                if (matcher.find()) {
                    String str = matcher.group();
                    str = str.substring(0, str.length() - 1);
                    list.add(str);
                }
            }

            return list;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (br != null) {
                    br.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return null;
    }
}

