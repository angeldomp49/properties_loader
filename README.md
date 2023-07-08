## Requirement ##

- Java 17+

## Dependency ##

Maven

    <dependency>
        <groupId>org.makechtec.software</groupId>
        <artifactId>properties_loader</artifactId>
        <version>1.0.1</version>
    </dependency>

Gradle

    implementation 'org.makechtec.software:properties_loader:1.0.1'

## Usage ##

Consider a file __test.properties__ with content located in resource directory

    name=jhon

And the code

    var loader = new PropertyLoader("test.properties");

    assertTrue(loader.getProperty("name").isPresent());
    assertEquals("jhon", loader.getProperty("name").get());


## Releases history ##

- [v1.0.1](/docs/v1.0.1.md)