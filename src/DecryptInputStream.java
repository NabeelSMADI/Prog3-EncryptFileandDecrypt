import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

public class DecryptInputStream extends FilterInputStream {
    private byte[] key;
    private int pos;

    public DecryptInputStream(InputStream in, byte[] key) {
        super(in);
        this.key = key;
    }


    public int read(byte[] b, int offset, int count) throws IOException {
        int n = super.read(b, offset, count);
        int last = offset + n;
        for (int i = offset; i < last; i++) {
            b[i] = (byte) (b[i] ^ next());
        }
        return n;
    }



    private int next() {
        return key[pos++ % key.length];
    }
}
