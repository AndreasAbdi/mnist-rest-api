package main.datatypes;

import java.util.Base64;

/**
 * //TODO: Fill this in.
 */
public class Image {
    byte[] encoded;
    byte[] decoded;
    public Image(byte[] encoded) {
        this.encoded = encoded;
        this.decoded = Base64.getDecoder().decode(encoded);
    }

    public byte[] getEncodedImage() {
        return encoded;
    }

    public byte[] getDecodedImage() {
        return decoded;
    }
}
