package Stream;

import java.io.*;

public class DataStream {

    static void input() {

        File file = new File("dest.text");

        try {
            DataInputStream dis = new DataInputStream(new BufferedInputStream(new FileInputStream(file)));
            System.out.println(dis.readInt());
            //System.out.println(dis.readFloat());
            System.out.println(dis.readUTF());
            System.out.println(dis.readChar());

            dis.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    static void output() {
        File file = new File("dest.text");

        try {
            DataOutputStream dos = new DataOutputStream(new BufferedOutputStream(new FileOutputStream(file)));
            dos.writeInt(1111);
            //dos.writeFloat(11.00454500f);
            dos.writeUTF("分手的距离副科级吉林省的房间里");
            dos.writeChar('a');
            dos.flush();
            dos.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        output();
        input();
    }
}

