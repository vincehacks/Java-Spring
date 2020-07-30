# JAVA-SPRING

Created by Vince Chang </br>

Here I used Java Spring to implement RESTful APIs (JAXRS). In addition I have
also used MYSQL database to store data. The best way to test out these projects
is by using Postman.

### BOBA ME

- Description: This is a RESTful API that has been built using Spring Boot. It
  uses Maven as a build and manage the project with Tomcat as its server. The
  project is linked to a MYSQL database.
  ![Final Product](https://github.com/vincehacks/Java-Spring/blob/master/bobame/img/FinalProduct1.png)
  ![Final Product](https://github.com/vincehacks/Java-Spring/blob/master/bobame/img/FinalProduct2.png)
  ![Final Product](https://github.com/vincehacks/Java-Spring/blob/master/bobame/img/FinalProduct3.png)

#### INTRODUCTION TO SPRING

- Spring is a Java Framework that is used for convenience
- A Dependency Injection Container
  - Container in Java: is a runtime environment!
  - Ex. My application will be inside Tomcat Container
  - Dependency Injection allows us to write less code
- Will use proxies, which are intermediaries. It is in the middle layer and
  it just adds things to method calls without people actually realizing it
- Spring uses a TON of **Interfaces**
- Replaces the JavaEE architecture, before you would have to configure a lot
  of things that you needed (almost like doing the same thing more than once),
  this time its more symmetric and flattened out
- Easy to Unit test (because we have an interface) and Mock
- Practice design practices and design problems

- GOALS:
  - Provide consistent infrastructural support
  - Encourage 2 basic design principles:
  1. DRY (**D**on't **R**epeat **Y**ourself)
  2. SoCs (Separation of Concerns)

#### JAVA EE

- Allows distributed programming and is designed to be in large scale
  environments
- Overly complex
- Written for server, not ease of programming
- Difficult to unit test
- Tedious to configure
- Different on each tier

#### REQUIREMENTS

- Version of Java usable by version of Spring
  - Spring 3.x needs Java SE 1.7 or higher
- Core Spring Framework Libraries
  - Consists of about 20 modules

#### SPRING CONTAINER

- Manages life cycles of beans
- Inserts proxies when appropriate
- Inversion of Control (IoC) container is the basis
  - A.K.A Dependency Injection
  - **_Objects define their dependencies, container injects those dependencies
    when bean is created_**
- `org.springframework.context.ApplicationContext`
  - Basis for Spring's IoC

#### DATA ACCESS/INTEGRATION

- `spring-jdbc`
  - JDBC abstraction layer
- `spring-tx`
  - Support for programmatic and declarative transaction management
- `spring-orm`
  - Supports Object/XML mapping
- `spring-jms`
  - Java Messaging Service features

#### WEB LAYER

- `spring-web`
  - Web integration features
  - Uses servlet listeners to initialize IoC
  - Contains HTTP client
- `spring-webmvc`
  - A.K.A Web-Servlet module
  - Module-View-Controller framework for web
  - REST web services
- `spring-websocket`
  - Implementation of RFC 6455 and JSR-356
  - WebSocket protocol defines a two-way, client-server communication that is
    full duplex
- `spring-webmvc-portlet`
  - MVC implementation for a portlet environment
  - Mirrors functionality of - `spring-webmvc`

#### MIDDLE LAYER

- `spring-aop`
  - Aspect-oriented programming (AOP) implementation
  - Based off of AspectJ
- `spring-aspects`
  - Actual integration with AspectJ
    -- `spring-instrument`
  - Automatic discovery of Managed Beans and applications
  - Provides runtime control of container
  - Exposes performance metrics and monitoring
- `spring-messaging`
  - Annotations for mapping messages to methods

#### CORE CONTAINER

- `spring-core` && `spring-beans`
  - The basis of the framework
  - Provides IoC and dependency injection features
  - Allows decoupling of configuration and specification dependencies from
    the business logic
- `spring-context` && - `spring-context-support`
  - Provides access to objects
  - `ApplicationContext` is from here
  - Supports internationalization, event propagation, resource loading and
    creation of contexts
  - Supports EJB, JMX and basic remoting

#### TESTING

- `spring-test`
  - Unit testing and integration testing with Junit or TestNG
  - Provides loading and caching of contexts
  - Provides mock objects

#### DEPENDENCY INJECTION

- Design pattern to reduce coupling between components
- Object are coupled to interfaces
- MVC is 2 patterns connected to each other
- Spring will give you everything you need through Dependency Injection
- The instantiation of the object is done by the Spring Container (Application
  Context), the container will be responsible for injecting information it needs

#### INVERSION OF CONTROL (IoC)

- Design pattern closely related to Dependency Injection
- Object defines its dependencies and container handles injecting those
  dependencies when object is created
- Manages:
  - Bean life cycles
  - Object pooling
  - Bean dependencies via injection

#### DEPENDENCY CONFIGURATION

- 3 Mechanisms
  - Externalized in XML file
  - Internalized as annotations
  - Independent Java Class
- There can be a mix-and-match of these
- Usually uses 3 files:
  1. Managed bean
  2. Interface to the managed bean
  3. Configuration file: Can have multiple (XML, Java, etc.)

#### MANAGED BEAN

- POJO designed to be managed by Spring
- Does not necessarily follow rules of Java Beans
- Should always have an interface
- If was not using spring, would always have to create your object in the main

#### CODING WITH SPRING

- Service and repository are the same
  - Add interfaces if they don't exist
- `main` changes
- Configuration file is added
  - `application-config.xml`
  - `javaConfig.java`
  - Annotations (requires one of the above)
- Beans are the service classes

#### MAIN CLASS

- Main Class will change
  - Create ApplicationContext = is the **container**
  - `.getBean` -> This will be the starting point!
  - This method is overloaded
  - Will look for "library in the `LibraryServiceImpl.class`"

#### application-config.xml

- First parts is copy and paste
- Second, set up a spring bean:
  - id
  - class (the repository; the place where the implementation is)
  - constructor (need a new constructor tag for each argument!)
  - the repository needs to be a bean too that also has an id!
- `config` files can NOT do gets

#### USING PROPERTY

- The properties will define the getter and setter methods

#### USING ANNOTATIONS FOR CONFIGURATION

- Not replacing `config` so don't get confused
- @Component scanning:
  - Using this for the Constructor!
  - By using the @Component, we are saying that it is a bean
  - Ex. @Component name = blah ....name is the id
  - The bean won't be visible in the XML file, because @Component will create
    the bean at RUNTIME
  - @Autowire = the type of parameter will be created as a bean

#### WHY ANOTHER CONFIGURATION METHOD? (THIS IS THE COMMON WAY!!)

- This is a Java Config!
- Removes all XML requirements
  - Can still mix-and-match if you choose
- Removes types
- Removes runtime checks
- Normal Java class with same benefits of only using Java Classes
- This makes our life easy, but we still have XML, because anything can be
  made into Spring!

#### @Configuration

- Annotates a Java class to be the mechanism of bootstrapping
  - In comparison to XML and Annotation methods we have seen
- Can have multiple files annotated, in which all would become config files

#### @Bean

- Defines the method that will return our beans
  - These are the same classes that would have the `<bean>` tag in XML
    config
- Can have multiple beans in a file!
- Spring Beans are singletons, meaning that they if a bean is used multiple
  times, they are all referring to the same reference.
- Spring beans life cycle are determined by the container
- Stateless, meaning that it won't remember who you are from call to call

#### ApplicationContext

- This is the Spring Container!
- Usually use `org.springframework.context.ApplicationContext`
- Child of `org.springframework.beans.factory.BeanFactory`
- Common Implementations:
  - `ClassPathXmlApplicationContext` <- For XML way
  - `AnnotationConfigApplicationContext` <- For Java way

#### CONFIGURATION ANNOTATIONS

- `@Component`
  - Defines this as a Spring Bean
  - Name of bean is name of class with a lower-case first letter
- `@Autowired`
  - Defines how to wire the beans
  - Is a required dependency
  - On constructor, defines that the arguments passed in
  - Allows beans to do dependency injection (where you let the Spring
    container handle everything to import to you and let the container
    instantiate it for you)

#### PREFIXES

- Files are located in different places
  - Can use different ApplicationContext objects
  - `ClassPathXmlApplicationContext`
  - `FileSystemXmlApplicationContext` // Not often
  - Can use prefixes
  - `classpath`
  - `file`
  - `http`
- Prefixes are used anywhere Spring deals with resources

#### SCOPES

- Technically only 3 scopes
  - **singleton** - One instance of bean per application (default)
  - **prototype** - New instance every time bean is referenced (Ex. caches)
  - **custom** - Programmer defines the rules
  - This is where **session** and **request** scopes come in
  - Default is `singleton`

#### Namespaces

- XML - schema's that makes life easier
- Add access to many classes
- Standard
  - aop - adds aspect oriented programming
  - context - helps with the building of application contexts
  - beans - the main namespace for Spring
  - util - extra utilities, such as collections

#### CONTEXT NAMESPACE

- Primarily provides work to help with building context
- Compilation time checks instead of runtime checks

#### COMPONENT SCANNING

- Allows us to limit our search to `@Components`
- It will also know about `@Configuration`
- When using SML, just add
  - `@Component` to the bean class
  - `<context:component-scan>` to the XML file
  - Look only in packages that components that we want
  - Component Scan is looking for `@Component` or sub annotations of this
- When using Java configuration
  - Beans annotated `@Component`
  - Beans not defined in JavaConfig file
  - JavaConfig adds `@ComponentScan`

#### COLLECTIONS

- In JavaConfig, ensure that variable type is that of the interface
- XML understands lists, sets and maps
  - Does not understand specific types
  - Not accessible from ApplicationCOntext
  - Only usable inside of `<property>` or `<constructor-arg>`

# DAY 2

#### BeanFactoryPostProcessor

- These can modify the configuration of any bean
- We can write our own, but usually do not
- BFPPs allow us to:
  - Provide administrators a mechanism to monitor and modify beans
  - Handle tags from XML
  - `<context:component-scan/>`
  - `<context:annotation-config/>`
- In this phase, all beans are loaded and processed at once and all are
  completed before going on to the next phase

#### DEPENDENCY INJECTION FOR BEANS

- Order of loading
  - Call constructors
  - Call field injections (@Value etc)
  - Call set methods
  - Do this one bean at a time and gets ready to go into the processor
- Each bean goes through entire phase at a time

#### CREATION AND INITIALIZATION OF BEANS

- After all beans get through dependency injection
- Actually a `BeanPostPorcessor` before and after initialization
  - Spring uses this, we rarely do
  - `@PostConstruct` called after second set of BPPs
  - Actually modify the bean instance
- Loaded Eagerly
  - Can be loaded lazily, but usually not appropriate

#### DESTRUCTION

- Context is responsible for handling
- Only deals with Singletons not Prototypes
- Order of tear down:
  - Invokes cleanup methods, both those annotated with `@PreDestroy` and those
    defined in `@Bean`
  - Destroys any unreferenced singletons
  - Destroys itself (this context)
- Destruction of a context does NOT destroy
  - Referenced singletons
  - Non-singletons (Prototype Beans will not be handled by the container)
  - Proxies bound to beans in use
- If you have destroy methods, you want to know who will be affected by them

### BEST PRACTICES

#### PREFER CONFIGURATION OVER AUTOWIRED

- Easier to organize
- Larger the application, more difficult it is to manage with autowiring
- Spring is a configuring framework
  - Best practice is to separate configuration from business logic
- If this is best practice, then why have annotations for non-configuration
  files?
  - XML has fallen out of favor
  - Annotations with XML was a step between XML and Java configuration
  - Sometimes configuration is easier at point of need

#### PREFER SETTER INJECTION OVER CONSTRUCTOR INJECTION

- Constructor Injection Makes the bean thread safe
  - Ensures that everything that needs a bean gets its own instance
- Setter Injection
  - Better if there are multiple attributes to be set Allows for attributes to
    be optional
  - `@Autowired` makes them required
  - `@Required` makes them required but you still have
    to call the method
- Usually easier for testing

#### USE MULTIPLE CONFIGURATION FILES

- Easier to maintain, more flexible
- Too many types of beans
  - Business logic
  - Database connectivity
  - Different environments
- One file is poor separation of responsibility
- One file increases probability of error
- Usually easier to test

#### MISCELLANEOUS BEST PRACTICES

- Externalize properties
  - Some change often, so putting them in a property file can make it easier to
    manage
- Use consistent naming conventions Use consistent version of tags
  - Use `@PostConstruct` or `@Bean(initMethod="...")`
- Use interfaces for all Spring beans
- Use short form of tags
- Do not overuse dependency injection
  - Is this a bean to be used by
  - Other beans?
  - Other users?
  - Is this something unique to this one user?
  - Does it have values that are not known until after a user actively interacts
    with it?
- If a spring bean can be stateless, then make it a spring bean
  - Ex. a service class, data base connectivity
- If it is dependent on the user, don't make it a spring bean

### SPRING BOOT

#### WHAT IS SPRING BOOT?

- Faster way to set up Spring applications
- Makes assumptions based on machine's configurations
  - May mean that it brings in things you need but don't have
  - i.e. Tomcat if you are building a web application and don't have a server
    configured for it
- It does not generate code
- Based on 3 major pieces
  - Starter projects
  - Starter parent
  - Auto-configuration
- Could build 'by hand'
- Use Spring's Initializer Found at start.spring.io

#### SPRING BOOT STARTER PROJECTS

- Set of dependency descriptors that can be included in app
  - You don't need to know all of the jar files needed, just these 'starters'
  - `spring-boot-starter` would replace all dependencies currently in our
    pom.xml plus some
  - `spring-boot-starter-web` adds approximately 30 more JARs
  - Is "opinionated" import
  - There are presumptions made, but these presumptions can be overridden

#### SPRING BOOT STARTER PARENT

- The root of all boot starters
- Allows for management of multiple child projects
  - Allows for dependency versioning
  - Default plugin configuration
  - Configuration
- Inherits from `spring-boot-dependencies`
  - Gives us the default dependencies
  - Defaults can be changed in `src/main/resources/application.properties`
  - [Full list of property](https://docs.spring.io/spring-boot/docs/current/reference/html/common-application-properties.html)

#### AUTO-CONFIGURATION

- There are things that will always be needed, so why should we always configure
  them?
  - Let Spring configure them for us
- Auto-configuration can be overridden
  - Frameworks available on CLASSPATH
  - i.e. Default is to use JavaSE 1.6. If it sees 1.8 on your CLASSPATH, then it
    will configure to use 1.8
  - Existing configurations
- Implemented in `spring-boot-autoconfigurer.jar`

#### DEBUGGING AUTO-CONFIGURATION

- Two ways
  - Turn on logging
  - Use Spring Boot Actuator
- To use logging:
  - Add property to `application.properties`
  - `logging.level.org.springframework:DEBUG`
  - Once application restarts, an auto-config report is printed to console
  - Positive matches – what was configured
  - Negative matches – what was not configured

#### SPRING BOOT ACTUATOR

- Gives us runtime information about the application
  - Health, metrics, state, etc.
- Need to have `spring-boot-starter-actuator`
- Needs something to read it
  - Designed to use RESTful services that read or write to it
  - Can use HAL browser
  - groupId: org.springframework.data
  - artifactId: spring-data-rest-hal-browser
  - Results are found at: http://localhost:8080/actuator/#http://localhost:8080/autocoã DevelopIntelligence http://wnwwf.DiegvelopIntelligence.com)

#### @SpringBootApplication

- Annotation that defines this class as the 'starter' class for your application
- A convenience annotation that adds
  - `@Configuration`
    - `@ComponentScan`
    - `@EnableAutoConfiguration`
  - Tells Spring Boot to attempt to configure the application based on what is
    on your classpath
  - `@EnableWebMvc` if `spring-webmvc` is on classpath

#### RUNNING SPRING BOOT APPLICATION

- Spring Initializr gives us class annotated with `@SpringBootApplication`
  - This class also has `main` method
  - `SpringApplication.run()`
  - This method call 'starts' Spring Boot
  - You would then call your own methods if you need to
- ````@SpringBootApplication
  public class LibraryApplication {
  public static void main(String[]args) {
    SpringApplication.run(LibraryApplication.class,args);
    MainApplication.oldMainMethod();
  }```
  ````

### SPRING WebMVC

#### MVC - MODEL VIEW CONTROLLER

- An architectural design pattern
- Means of separating the presentation (view) from the business logic (model)
  with an itermediary (controller)
- Used in most UI situations
- **Model** (Logic)
  - Data that is being modified and used
  - Often service that does the modifying is included
- **View**
  - The code that dynamically define what goes to the user
- **Controller**
  - Maps to view and model
- From an architectural standpoint, these are likely components of classes

### INTRO TO SPRING MVC

#### SPRING MVC

- A framework implementing MVC
  - Can always go around, but should make MVC easier to accomplish
- Comes in two forms
  - @MVC – configuration using annotations (COMMONLY USED)
  - MVC – configuration only uses XML
- @MVC is preferred

#### DispatcherServlet

- Front Controller for SpringMVC
- Delegates to second layer controllers and to view
- Loads `WebApplicationContext`
- Can be initialized without `web.xml` in Servlet 3.0+ environments
- Depends on what servlets we are using

#### CONFIGURATION WITH web.xml

```
<context-param>
<param-name>contextConfigLocation</param-name> <param-value>/WEB-INF/application-config.xml</param-value>
</context-param>
<servlet>
<servlet-name>Spring</servlet-name> <servlet-class>
org.springframework.web.servlet.DispatcherServlet
  </servlet-class>
  <init-param>
<param-name>contextConfigLocation</param-name>
<param-value>/WEB-INF/web-config.xml</param-value> </init-param>
</servlet>
<servlet-mapping>
<servlet-name>Spring</servlet-name>
<url-pattern>/</url-pattern> </servlet-mapping>
```

#### CONFIGURATION WITH JAVA

- Sets up all resolvers (locale, interceptors)
- Needs two additional files
  - MVC configuration file
  - Extends `WebMvcConfigurerAdapter`
  - Register view resolvers
  - Register locale resolvers
  - Register interceptors
  - `DispatcherServlet` configuration file
  - Extends `AbstractAnnotationConfigDispatcherServlet Initializer`
  - Registers all other configuration files
  - Registers servlet mappings
  - Registers `DispatcherServlet`

#### NEEDED DEPENDENCIES

- If we aren't using Spring-Boot need to have these:
- Maven Dependencies
  - groupId: `org.springframework`
  - artifactId: `spring-web`
  - artifactId: `spring-webmvc`
- Actual (additional) JAR files
  - `aopalliance`
  - `spring-webmvc`
  - `spring-aop`
  - `spring-web`

#### CONTROLLER RETURNS

- Three options for returnType
  - void – controller forwards us to the default view
  - String - the name of the view we are delegating to
  - ModelAndView – the model and the name of the view
- String vs. ModelAndView
  - Returning String is newer option
  - Model is already on the HttpRequest object
- ModelAndView is older option
  - Still used, gives us more control over model and view contents

#### REQUEST PROCESSING

- Method annotated with `RequestMapping`
- Can determine if it responds to GET or POST requests
- Can determine where to get input data

#### @RequestMapping

- Basic setup
  `@RequestMapping(value="/allbooks") public ModelAndView getBooks()`
- Pass arguments as added part of URL
  `@RequestMapping(value="/book") public String getBook(@RequestParam("id") Long id, Model model)`
- Pass arguments as part of destination URL
  `@RequestMapping(value="/book/{id}") public ModelAndView getBook(@PathVariable("id") Long id, Model model)`
- Can determine where to get input data

#### "DOUBLE POST" ISSUE

- Accidental resubmission of page
- Use a URL redirect response instead of a forward response
- `return new ModelAndView("redirect:showBooks.jsp", "book", book);`

#### VIEW

- Can be anything
  - Need to have converters
  - Considered to be one of the big advantages of Spring MVC
  - Default is .jsp

#### WebApplicationContext

- Ultimately, `WebApplicationContext` is the object we want when integrating
  Spring with the web tier.
- Usually we use `DispatcherServlet`
- Secondarily we can use our own servlet
  - Need things - `ContextLoaderListener` - `WebApplicationContextUtils`
