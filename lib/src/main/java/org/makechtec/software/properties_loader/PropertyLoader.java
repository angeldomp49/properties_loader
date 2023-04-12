package org.makechtec.software.properties_loader;

import lombok.Getter;
import lombok.extern.java.Log;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Properties;

@Log
public class PropertyLoader {

    @Getter
    private final String filename;
    private final PropertyFileFinder finder;
    private final Properties propertiesList;
    private boolean isFileAlreadyLoaded;
    @Getter
    private final List<String> errorMessages;

    public PropertyLoader(String filename) {
        this.filename = filename;
        this.finder = new PropertyFileFinder();
        propertiesList = new Properties();
        isFileAlreadyLoaded = false;
        errorMessages = new ArrayList<>();
    }

    public Optional<String> getProperty(String name){

        if(!isFileAlreadyLoaded){
            loadFile();

            if(!isFileAlreadyLoaded){
                showErrorMessages();
                return Optional.empty();
            }
        }

        var property = propertiesList.getProperty(name);

        if(property == null){
            errorMessages.add("Property not found: " + name);
            showErrorMessages();
            return Optional.empty();
        }

        showErrorMessages();
        return Optional.of(property);

    }

    private void loadFile(){
        var resource = finder.resource(filename);

        try {

            if(resource.isEmpty()){
                errorMessages.add("Not found resource file: " + filename);
                isFileAlreadyLoaded = false;
                return;
            }

            propertiesList.load(resource.get());
            isFileAlreadyLoaded = true;

        } catch (IOException e) {
            errorMessages.add("Failed to load file: " + this.filename);
            isFileAlreadyLoaded = false;
        }

    }

    private void showErrorMessages(){
        errorMessages.forEach(log::severe);
    }
}
