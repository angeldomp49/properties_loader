package org.makechtec.software.properties_loader;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Optional;

class PropertyFileFinder {

    public Optional<InputStream> resource(String filename) {
        var stream = PropertyFileFinder.class.getClassLoader().getResourceAsStream(filename);

        return (stream != null) ? Optional.of(stream) : Optional.empty();
    }

    public Optional<InputStream> readFromAbsolutePath(String absolutePath){

        try{
            var stream = new FileInputStream(absolutePath);

            return Optional.of(stream);
        }
        catch (FileNotFoundException e) {
            return Optional.empty();
        }

    }



}
