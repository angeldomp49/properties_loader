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

---

#### AbsolutePathPropertyLoader ####

Consider a file in the user dir called __forTest.properties__

    foo=bar
    jhon=lennon

And the code

    var path = new PathGenerator();
    var userDir = path.userDir();
    var loader = new AbsolutePathPropertyLoader(userDir + "/forTest.properties");

    var foo = loader.getProperty("foo");
    var jhon = loader.getProperty("jhon");


    assertTrue(foo.isPresent());
    assertEquals("bar", foo.get());
    assertEquals("lennon", jhon.get());


## Releases history ##
- v1.1.0 Added absolute path file load capacity
- v1.0.1 the first release