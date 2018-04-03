# Java-Spring

Created by Vince Chang </br>

Instructor: Marnie Knue </br>
Hours: 930am - 430pm 4/2-4/4 </br>
Breaks: ~1030am & 230pm </br>


#### Questions
 	1.
	2. 


#### Introduction to Spring
- Spring is a Java Framework that is used for convenience
- A Dependency Injection Container
	- Container in Java: is a runtime environment!
	- Ex. My application will be inside Tomcat Container
	- Dependency Injection allows us to write less code
- Will use proxies, which are intermediaries. It is in the middle layer and
it just adds things to method calls without people actually realizing it
- Spring uses a TON of **Interfaces**

- GOALS:
	- Provide consistent infrastructural support
	- Encourage 2 basic design principles:
		1. DRY (**D**on't **R**epeat **Y**ourself)
		2. SoCs (Separation of Concerns)


#### Java EE
- Allows distributed programming and is designed to be in large scale
environments
- Overly complex
- Written for server, not ease of programming
- Difficult to unit test
- Tedious to configure
- Different on each tier


#### Requirements
- Version of Java usable by version of Spring
	- Spring 3.x needs Java SE 1.7 or higher
- Core Spring Framework Libraries
	- Consists of about 20 modules


#### Spring Container
- Manages life cycles of beans
- Inserts proxies when appropriate
- Inversion of Control (IoC) container is the basis
	- A.K.A Dependency Injection
	- ***Objects define their dependencies, container injects those dependencies when bean is created***
- `org.springframework.context.ApplicationContext`
	- Basis for Spring's IoC


#### Data Access/Integration
- `spring-jdbc`
	- JDBC abstraction layer
- `spring-tx`
	- Support for programmatic and declarative transaction management
- `spring-orm`
	- Supports Object/XML mapping
- `spring-jms`
	- Java Messaging Service features


#### Web Layer
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


#### Middle Layer
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


#### Core Container
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


#### Testing
- `spring-test`
	- Unit testing and integration testing with Junit or TestNG
	- Provides loading and caching of contexts
	- Provides mock objects


#### Dependency Injection
- Design pattern to reduce coupling between components
- Object are coupled to interfaces
- MVC is 2 patterns connected to each other
- Spring will give you everything you need through Dependency Injection


#### Inversion of Control (IoC)
- Design pattern closely related to Dependency Injection
- Object defines its dependencies and container handles injecting those
dependencies when object is created
- Manages:
	- Bean lifecycles
	- Object pooling
	- Bean dependencies via injection


#### Dependency Configuration
- 3 Mechanisms
	- Externalized in XML file
	- Internalized as annotations
	- Independent Java Class
- There can be a mix-and-match of these
- Usually uses 3 files:
	1. Managed bean
	2. Interface to the managed bean
	3. Configuration file: Can have multiple (XML, Java, etc.)


#### Managed Bean
- POJO designed to be managed by Spring
- Does not necessarily follow rules of Java Beans
- Should always have an interface
- If was not using spring, would always have to create your object in the main


#### Coding With Spring
- Service and repository are the same
	- Add interfaces if they don't exist
- `main` changes
- Configuration file is added
	- `application-config.xml`
	- `javaConfig.java`
	- Annotations (requires one of the above)
- Beans are the service classes


#### Main Class
- Main Class will change
	- Create ApplicationContext = is the **container**
	- .getBean -> This will be the starting point!
		- This method is overloaded
		- Will look for "library in the LibraryServiceImpl.class"


#### application-config.xml
- First parts is copy and paste
- Second, set up a spring bean:
	- id
	- class (the repository; the place where the implementation is)
	- constructor (need a new constructor tag for each argument!)
	- the repository needs to be a bean too that also has an id!
- `config` files can NOT do gets


#### Using property
- The properties will define the getter and setter methods


#### Using Annotations for Configuration
- Not replacing `config` so don't get confused
- @Component scanning:
	- Using this for the Constructor!
	- By using the @Component, we are saying that it is a bean
	- Ex. @Component name = blah ....name is the id
	- The bean won't be visible in the XML file, because @Component will create
	the bean at RUNTIME
	- @Autowire = the type of parameter will be created as a bean


#### Why Another Configuration Method? (THIS IS THE COMMON WAY!!)
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


#### ApplicationContext
- This is the Spring Container!
- Usually use `org.springframework.context.ApplicationContext`
- Child of `org.springframework.beans.factory.BeanFactory`
- Common Implementations:
	- `ClassPathXmlApplicationContext` <- For XML way
	- `AnnotationConfigApplicationContext`  <- For Java way


#### Configuration Annotations
- @Component
	- Defines this as a Spring Bean
	- Name of bean is name of class with a lower-case first letter
- @Autowired
	- Defines how to wire the beans
	- Is a required dependency
	- On constructor, defines that the arguments passed in 


#### Prefixes
- Files are located in different places
	- Can use different ApplicationContext objects
		- `ClassPathXmlApplicationContext`
		- `FileSystemXmlApplicationContext`
	- Can use prefixes
		- `classpath`
		- `file`
		- `http`
- Prefixes are used anywhere Spring deals with resources


#### Scopes
- Technically only 3 scopes
	- **singleton** - One instance of bean per application
	- **prototype** - New instance every time bean is referenced
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


#### Context Namespace
- Primarily provides work to help with building context
- Compilation time checks instead of runtime checks


#### Component Scanning
- When using SML, just add
	- `@Component` to the bean class
	- `<context:component-scan>` to the XML file
- When using Java configuration
	- Beans annotated `@Component`
	- Beans not defined in JavaConfig file
	- JavaConfig adds `@ComponentScan`








