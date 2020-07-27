# MAVEN
Created by Vince Chang </br>


Setting up a Maven Project in VSCode and in general


#### RESOURCES

-  [Maven in VSCode](https://stackoverflow.com/questions/46671308/how-to-create-a-java-maven-project-that-works-in-visual-studio-code#:~:text=Open%20the%20Maven%20project%20folder,Executes%20common%20Maven%20commands%22)
-  [Add a jar to Maven Project](https://www.moreofless.co.uk/executable-jar-netbeans-maven-no-main-manifest-attribute/#:~:text=you%20get%20%E2%80%9Cno%20main%20manifest,is%20but%20Maven%20doesn't.)
-  [Other ways to build a Jar](https://www.baeldung.com/executable-jar-with-maven)

#### INSTRUCTIONS
1. Open VSCode
2. Pull up the pallet `cmd + shift + p` and choose **Java Overview** 
3. Select **Create a Maven Project**
4. Select `maven-archetype-quickstart`
5. Select latest version Ex. 1.4
6. Follow terminal questions to set up project
7. Test out by running `App.java` to print 'Hello World' 

#### MAVEN-ASSEMBLY-PLUGIN TO CREATE A FAT JAR

- This plugin allows for a FAT jar to be created, a FAT jar is needed because it
  will be able to package the dependencies into a jar
- The regular jar does not do this! So FAT jar is required!!!
- **IMPORTANT TO REMOVE `<PluginManagements></PluginManagements>` wrapper**,
  if kept with this plugin, it WILL NOT create the jar under target! Need to
  remove this!
- Will need to change `<mainClass>package.className</mainClass>`
- After below code is added run `mvn clean package` for `pom.xml` to be updated

```xml
<plugin>
  <groupId>org.apache.maven.plugins</groupId>
  <artifactId>maven-assembly-plugin</artifactId>
  <version>2.4.1</version>
  <configuration>
    <!-- get all project dependencies -->
    <descriptorRefs>
      <descriptorRef>jar-with-dependencies</descriptorRef>
    </descriptorRefs>
    <!-- MainClass in manifest make a executable jar -->
    <archive>
      <manifest>
      <mainClass>redfin.App</mainClass>
      </manifest>
    </archive>

  </configuration>
  <executions>
    <execution>
    <id>make-assembly</id>
    <!-- bind to the packaging phase -->
    <phase>package</phase>
    <goals>
      <goal>single</goal>
    </goals>
    </execution>
  </executions>
</plugin>
```
#### HOW TO RUN THE PROJECT

Requirements:
Apache Maven will need to be installed if not already installed, can use this
link:

https://maven.apache.org/install.html

#### STEPS

1. From the root directory, you can build and install all dependencies by
   running this Maven command from the terminal:

`mvn clean package`

This will generate a `redfin-1.0-SNAPSHOT-jar-with-dependencies.jar`
file under `redfin/target`

2. Run the program by using the jar with this command

NOTE: Need to be running this from the root (redfin), NOT inside /target

`java -jar target/redfin-1.0-SNAPSHOT-jar-with-dependencies.jar`

The output will be displayed to the terminal

#### DEPENDENCIES FOR BUILDING A REGULAR JAR WITH MAVEN

-   The jar will be an executable for the end user. The end user will need to
    build your Maven project and run the jar with all its dependencies already
    intact.
-   **Common problems**: `no main manifest attribute` This happens because the
    project is being built by Maven and the Main Class that is specified in the
    properties file is not exported to this project's `pom.xml`
-   **Fix**: Add `maven-jar-plugin` dependency to `pom.xml`

```xml
<build>
    <plugins>
        <plugin>
            <groupId>org.apache.maven.plugins</groupId>
            <artifactId>maven-jar-plugin</artifactId>
            <version>2.4</version>
            <configuration>
                <archive>
                    <manifest>
                        <addClasspath>true</addClasspath>
                        <mainClass>MAIN CLASS GOES HERE</mainClass>
                    </manifest>
                </archive>
            </configuration>
        </plugin>
    </plugins>
</build>
```

For this project it looked like this

```xml
<build>
    <plugins>
        <plugin>
            <groupId>org.apache.maven.plugins</groupId>
            <artifactId>maven-jar-plugin</artifactId>
            <version>2.4</version>
            <configuration>
                <archive>
                    <manifest>
                        <addClasspath>true</addClasspath>
                        <mainClass>afterpay.Afterpay</mainClass>
                    </manifest>
                </archive>
            </configuration>
        </plugin>
    </plugins>
</build>
```

#### HOW TO RUN THE PROJECT

1. From the root directory clean the project and install dependencies

```bash
mvn clean package
```

2. This will generate a `.jar` file under `/target`

3) Need to be running this from the root, NOT inside /target

```bash
java -jar target/afterpay-1.jar
```

The other way to run the project is to use the IDE's feature to run the project



