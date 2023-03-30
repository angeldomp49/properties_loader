package org.makechtec.software.properties_loader;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PropertyLoaderTest {

    @Test
    void testGetProperty() {

        var loader = new PropertyLoader("test.properties");

        assertTrue(loader.getProperty("name").isPresent());
        assertEquals("jhon", loader.getProperty("name").get());

    }

    @Test
    void testGetProperty_noExistProperty() {

        var loader = new PropertyLoader("test.properties");

        assertFalse(loader.getProperty("lastName").isPresent());

    }

    @Test
    void testGetProperty_noExistFile() {

        var loader = new PropertyLoader("noExist.properties");

        assertFalse(loader.getProperty("lastName").isPresent());

    }


}