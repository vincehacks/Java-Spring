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


#### DEPENDENCIES FOR BUILDING A JAR WITH MAVEN

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



