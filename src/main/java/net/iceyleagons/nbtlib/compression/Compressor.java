package net.iceyleagons.nbtlib.compression;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * @author TOTHTOMI
 * @version 1.0.0
 * @since Jul. 31, 2022
 */
public interface Compressor {

    InputStream decompress(InputStream input) throws IOException;
    OutputStream compress(OutputStream out) throws IOException;


}
