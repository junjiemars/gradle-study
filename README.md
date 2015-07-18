jtools
============

# Gradle in Practices

## Manifest
The purpose of manifest file is not just let the program to run, when somethings wrong the
most import thing is to find out which the version(the VCS's version not something else)
you made, who build it and when.

Gradle make write Manifest is very easy and flexible, for multiple modules you can write a
basic jar/war manifest section in the root and then override it in sub-modules.

### Jar Manifest
Whatever you make Library or Executable all you can put a 'Main-Class': property in your

jar {
    manifest {
        attributes(
            ...
            'Main-Class': [<nil>|<entry.class>]
        )
    }
}

There is empty 'Main-Class' property if to make Library and it's no problem at all.

### War Manifest