Roaster
=======

Roaster (formerly known as java-parser) is a library that allows easy parsing of java source files, introducing a fluent interface to manipulate Java source files, like adding fields, methods, annotations and so on.

Usage
=====

Parser
------

Example:
```java
Roaster.parse(JavaClassSource.class, "public class HelloWorld {}");
```

Writer
------

Roaster provides a fluent API to generate java classes. Here an example:

```java
final JavaClassSource javaClass = Roaster.create(JavaClassSource.class);
javaClass.setPackage("com.company.example").setName("Person");

javaClass.addInterface(Serializable.class);
javaClass.addField()
  .setName("serialVersionUID")
  .setType("long")
  .setLiteralInitializer("1L")
  .setPrivate
  .setStatic(true)
  .setFinal(true);

javaClass.addProperty("Integer", "id").setMutable(false);
javaClass.addProperty("String", "fistName");
javaClass.addProperty("String", "lastName");

javaClass.addMethod().setConstructor(true).setPublic().setBody("this.id = id;").addParameter(Integer.class, "id");
```

Will produce:
```java
package com.company.example;

import java.io.Serializable;
import java.lang.Integer;

public class Person implements Serializable
{

   private static final long serialVersionUID = 1L;
   private final Integer id;
   private String fistName;
   private String lastName;

   public Integer getId()
   {
      return id;
   }

   public String getFistName()
   {
      return fistName;
   }

   public void setFistName(String fistName)
   {
      this.fistName = fistName;
   }

   public String getLastName()
   {
      return lastName;
   }

   public void setLastName(String lastName)
   {
      this.lastName = lastName;
   }

   public Person(Integer id)
   {
      this.id = id;
   }
}
```

Modifying Java Source
---------------------

```java
JavaClassSource javaClass = Roaster.parse(JavaClassSource.class, "public class SomeClass {}");
javaClass.addMethod()
  .setPublic()
  .setStatic(true)
  .setName("main")
  .setReturnTypeVoid()
  .setBody("System.out.println(\"Hello World\");")
  .addParameter("java.lang.String[]", "args");
System.out.println(javaClass);
```

Download
========
Of course it is possible to mix both approaches (parser and writer) to modify Java code programmatically:

Download [the latest .jar][1] or depend via Maven:

```xml
<dependency>
  <groupId>org.jboss.forge.roaster</groupId>
  <artifactId>roaster-api</artifactId>
  <version>${version.roaster}</version>
</dependency>
<dependency>
  <groupId>org.jboss.forge.roaster</groupId>
  <artifactId>roaster-jdt</artifactId>
  <version>${version.roaster}</version>
</dependency>
```

Issue tracker
=============

[ROASTER on JBossDeveloper][2]. You might need to log in, in order to view the issues.


Get in touch
============

Roaster uses the same forum and mailing lists as the [JBoss Forge][3] project. See the [JBoss Forge Community][4] page.

* [User forums][5] 
* [Developer forums][6] 


Related / Similar projects
==========================

For the writer part:

* [square/javawriter][7] 


License
=======
[Eclipse Public License - v 1.0][8]


  [1]: http://search.maven.org/#search%7Cga%7C1%7Cg:%22org.jboss.forge.roaster%22
  [2]: https://issues.jboss.org/browse/ROASTER
  [3]: http://forge.jboss.org/
  [4]: http://forge.jboss.org/community
  [5]: https://developer.jboss.org/en/forge
  [6]: https://developer.jboss.org/en/forge/dev
  [7]: https://github.com/square/javawriter
  [8]: http://www.eclipse.org/legal/epl-v10.html