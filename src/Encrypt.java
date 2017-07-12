import javax.swing.*;
import java.io.*;

public class Encrypt {
    public static void main(String[] args) throws IOException {
        String k ="prog3";
        byte[] key = k.getBytes();
        String inFile = inFile();
        String outFile = outFile();

        try (BufferedInputStream in = new BufferedInputStream(
                new FileInputStream(inFile));
             EncryptOutputStream out = new EncryptOutputStream(

                     new BufferedOutputStream(new FileOutputStream(outFile)),key)) {
            int n;
            byte[] b = new byte[1024];
            while ((n = in.read(b)) != -1) {
                out.write(b, 0, n);
            }
        }
    }

    public static String inFile(){
        JFileChooser fileChooser = new JFileChooser();
        if (fileChooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
            File file = fileChooser.getSelectedFile();
            return file.getPath();
        }
        return null;
    }

    public static String outFile(){
        JFileChooser fileChooser = new JFileChooser();
        if (fileChooser.showSaveDialog(null) == JFileChooser.APPROVE_OPTION) {
            File file = fileChooser.getSelectedFile();
            return file.getPath();
        }
        return null;
    }
}
