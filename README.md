# Mapstruct Wither support

Mapstruct plugin to support `withX` methods in POJOs.

## Usage

The library needs to be added to the annotation processor
classpath. With Maven, this can be done by configuring the
compiler plugin as follows.

```xml
<plugin>
    <artifactId>maven-compiler-plugin</artifactId>
    <configuration>
        <annotationProcessorPaths>
            <path>
                <groupId>dev.nullzwo</groupId>
                <artifactId>mapstruct-wither-support</artifactId>
                <version>1.0.0</version>
            </path>
        </annotationProcessorPaths>
    </configuration>
</plugin>
```

## Problem

[Mapstruct](https://mapstruct.org/) is a library to map instances
of one class to another similar class.

The library has to support many different styles of writing such
POJOs. Sadly, one common style is not supported.

### Withers

Withers are methods that can be used to change a single field
of an immutable POJO, by creating a copy.

See for example Lomboks
[@With](https://projectlombok.org/features/With).

### Mapstruct default behavior

Mapstruct will issue warning by default when this pattern is
used.

```
java: Unmapped target properties: "withName".
```

The reason is that Mapstruct does not understand how to parse
the property name from a `withX` method.

### Solution

This library provides a small
[AccessorNamingStrategy](https://mapstruct.org/documentation/stable/reference/html/#using-spi)
that adds the capability to parse the correct property name from
`withX` methods.