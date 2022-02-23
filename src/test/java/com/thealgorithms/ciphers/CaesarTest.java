package com.thealgorithms.ciphers;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class CaesarTest {
    @Test
    void testForSuccessfulEncode() {
        String message = "hello";
        String messageEncoded = "ifmmp";
        int shift = 1;

        assertEquals(Caesar.encode(message, shift), messageEncoded);
    }

    @Test
    void testForSuccessfulDecode() {
        String message = "ifmmp";
        String messageDecoded = "hello";
        int shift = 27;

        assertEquals(Caesar.decode(message, shift), messageDecoded);
    }

    @Test
    void testForUnsuccessfulEncode() {
        String message = "hello";
        String wrongEncode = "abcde";
        int shift = 12;

        assertNotEquals(Caesar.encode(message, shift), wrongEncode);
    }

    @Test
    void testForUnsuccessfulDecode() {
        String message = "ifmmp";
        String wrongDecode = "hellp";
        int shift = 1;

        assertNotEquals(Caesar.decode(message, shift), wrongDecode);
    }
}
