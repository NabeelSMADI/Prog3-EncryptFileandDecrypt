import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class EncryptOutputStream extends FilterOutputStream {
    private byte[] key;
    private int pos;

    public EncryptOutputStream(OutputStream out, byte[] key) {
        super(out);
        this.key = key;
    }



    public void write(byte[] b, int offset, int count) throws IOException {
        for (int i = 0; i < count; i++){
            super.write(b[offset + i] ^ next());
        }
    }



    private int next() {
        return key[pos++ % key.length];
    }
}
