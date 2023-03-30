package org.makechtec.software.properties_loader;

import java.io.InputStream;
import java.util.Optional;

public class PropertyFileFinder {

    public Optional<InputStream> resource(String filename) {
        var stream = PropertyFileFinder.class.getClassLoader().getResourceAsStream(filename);

        return (stream != null) ? Optional.of(stream) : Optional.empty();
    }



}
