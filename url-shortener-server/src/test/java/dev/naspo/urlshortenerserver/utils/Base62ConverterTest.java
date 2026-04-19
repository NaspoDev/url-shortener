package dev.naspo.urlshortenerserver.utils;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Base62ConverterTest {

    Base62Converter base62Converter;

    @BeforeEach
    void setUp() {
        this.base62Converter = new Base62Converter();
    }

    @Test
    void convertToBase62() {
        assertEquals("4C92", base62Converter.convertToBase62(1000000));
        assertEquals("M", base62Converter.convertToBase62(22));
        assertEquals("z", base62Converter.convertToBase62(61));
        assertEquals("0", base62Converter.convertToBase62(0));
        assertEquals("1UBb", base62Converter.convertToBase62(354367));
        assertEquals("5W", base62Converter.convertToBase62(342));
        assertEquals("rBjkf", base62Converter.convertToBase62(785943289));
    }
}