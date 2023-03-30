package org.makechtec.software.properties_loader;

import lombok.Getter;
import lombok.extern.java.Log;

import java.io.IOException;
import java.util.Optional;
import java.util.Properties;

@Log
public class PropertyLoader {

    @Getter
    private final String filename;
    private final PropertyFileFinder finder;
    private final Properties propertiesList;
    private boolean isFileAlreadyLoaded;

    public PropertyLoader(String filename) {
        this.filename = filename;
        this.finder = new PropertyFileFinder();
        propertiesList = new Properties();
        isFileAlreadyLoaded = false;
    }

    public Optional<String> getProperty(String name){

        if(!isFileAlreadyLoaded){
            loadFile();

            if(!isFileAlreadyLoaded){
                return Optional.empty();
            }
        }

        var property = propertiesList.getProperty(name);

        if(property == null){
            log.info("Property not found: " + name);
            return Optional.empty();
        }

        return Optional.of(property);

    }

    private void loadFile(){
        var resource = finder.resource(filename);

        try {

            if(resource.isEmpty()){
                throw new IOException();
            }

            propertiesList.load(resource.get());
            log.info("Loaded file: " + this.filename);
            isFileAlreadyLoaded = true;

        } catch (IOException e) {
            log.warning("Failed to load file: " + this.filename);
            isFileAlreadyLoaded = false;
        }

    }

}
