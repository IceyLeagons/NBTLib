package net.iceyleagons.nbtlib.compression;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.zip.*;

/**
 * @author TOTHTOMI
 * @version 1.0.0
 * @since Jul. 31, 2022
 */
@Getter
@AllArgsConstructor
public enum CompressionStrategy {

    NONE(
            new Compressor() {
                @Override
                public InputStream decompress(InputStream input) {
                    return input;
                }

                @Override
                public OutputStream compress(OutputStream out) {
                    return out;
                }
            }
    ),

    GZIP(
            new Compressor() {
                @Override
                public InputStream decompress(InputStream input) throws IOException {
                    return new GZIPInputStream(input);
                }

                @Override
                public OutputStream compress(OutputStream out) throws IOException {
                    return new GZIPOutputStream(out);
                }
            }
    ),

    ZLIB(
            new Compressor() {
                @Override
                public InputStream decompress(InputStream input) throws IOException {
                    return new InflaterInputStream(input);
                }

                @Override
                public OutputStream compress(OutputStream out) throws IOException {
                    return new DeflaterOutputStream(out);
                }
            }
    );

    private final Compressor compressor;
}
