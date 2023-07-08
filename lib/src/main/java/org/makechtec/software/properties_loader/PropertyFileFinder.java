package org.makechtec.software.properties_loader;

import lombok.extern.java.Log;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Objects;

@Log
class PropertyFileFinder {

    public void resource(String filename, InputStreamConsumer consumer) {
        try(var stream = PropertyFileFinder.class.getClassLoader().getResourceAsStream(filename)){

            if(Objects.isNull(stream)){
                log.warning("File not found: " + filename);
                return;
            }

            consumer.consume(stream);
        } catch (IOException e) {
            log.warning("Failed to load resource file: " + filename);
        }
    }

    public void readFromAbsolutePath(String absolutePath, InputStreamConsumer consumer){

        try(var stream = new FileInputStream(absolutePath)){
            consumer.consume(stream);
        } catch (FileNotFoundException e) {
            log.warning("File not found: " + absolutePath);
        } catch (IOException e) {
            log.warning("Failed to load resource file: " + absolutePath);
        }

    }

}
