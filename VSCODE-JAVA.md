# VSCODE-JAVA

Created by Vince Chang </br>

This file will contain common knowledge while working with Java in VSCode.

#### SWITCHING JAVA VERSIONS

[How to Switch Java Versions](https://medium.com/@devkosal/switching-java-jdk-versions-on-macos-80bc868e686a)

1. Open Terminal: `/usr/libexec/java_home -V`
2. Output will be

```bash
vincechang@Vinces-MacBook-Pro Java-Spring % /usr/libexec/java_home -V
Matching Java Virtual Machines (2):
    11.0.8, x86_64:     "AdoptOpenJDK 11"       /Library/Java/JavaVirtualMachines/adoptopenjdk-11.jdk/Contents/Home
    9.0.1, x86_64:      "Java SE 9.0.1" /Library/Java/JavaVirtualMachines/jdk-9.0.1.jdk/Contents/Home

/Library/Java/JavaVirtualMachines/adoptopenjdk-11.jdk/Contents/Home
```

3. Switch to the desired version (above I can choose from Java 9 or 11)

```bash
export JAVA_HOME=`/usr/libexec/java_home -v 9.0`
```

4. Confirm the switch `java -version`

#### HOW TO SET UP JDK

[Download JDK from here](https://adoptopenjdk.net/)

1. Go through installation instructions

- Should be downloaded here `/Library/Java/JavaVirtualMachines/`

2. Go to vscode settings and search for `java.home`
3. Place this line (comment out the old path or uncomment the path you want)
   `"java.home": "/Library/Java/JavaVirtualMachines/adoptopenjdk-11.jdk/Contents/Home",`
4. Restart VSCode
5. Confirm with `java -version`

#### GENERATE GETTERS AND SETTER METHODS

1. Highlight the fields you want to create getter and setter methods for
2. Go to command pallet (`cmd + shift + p`)
3. Search for **Generate get and set methods**
