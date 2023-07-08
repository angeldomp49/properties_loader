package org.makechtec.software.properties_loader;

import org.junit.jupiter.api.Test;
import org.makechtec.path_generator.PathGenerator;

import static org.junit.jupiter.api.Assertions.*;

public class AbsolutePathPropertyLoaderTest {

    @Test
    public void testPropertyReading(){
        var path = new PathGenerator();
        var userDir = path.userDir();
        var loader = new AbsolutePathPropertyLoader(userDir + "/forTest.properties");

        var foo = loader.getProperty("foo");
        var jhon = loader.getProperty("jhon");


        assertTrue(foo.isPresent());
        assertEquals("bar", foo.get());
        assertEquals("lennon", jhon.get());
    }

    @Test
    public void testPropertyReading_notFoundProperty(){
        var path = new PathGenerator();
        var userDir = path.userDir();
        var loader = new AbsolutePathPropertyLoader(userDir + "/forTest.properties");

        var noExist = loader.getProperty("no_exist");


        assertFalse(noExist.isPresent());
    }

    @Test
    public void testPropertyReading_notFoundFile(){
        var path = new PathGenerator();
        var userDir = path.userDir();
        var loader = new AbsolutePathPropertyLoader(userDir + "/not_existing_file.properties");

        var noExist = loader.getProperty("foo");


        assertFalse(noExist.isPresent());
    }

}
