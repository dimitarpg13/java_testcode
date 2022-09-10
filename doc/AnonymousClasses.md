# Anonymous Classes

Anonymous classes enable you to make your code more concise. They enable you to declare and instantiate a class at the same time. 
They are like local classes except that they do not have a name. They can be used if need arise to use a local class only once.

## Declaring Anonymous Classes

While local classes are class declarations, anonymous classes are expressions, which means that you define the class in another 
expression. The following example, HelloWorldAnonymousClasses, uses anonymous classes in the initialization statements of the local 
variables `frenchGreeting` and `spanishGreeting`, but uses a local class for the initialization of the variable `englishGreeting`:

```java
public class HelloWorldAnonymousClasses {
    interface HelloWorld {
        public void greet();
        public void greetSomeone(String someone);
    }

    public void sayHello() {
        
        class EnglishGreeting implements HelloWorld {
            String name = "world";
            public void greet() {
                greetSomeone("world");
            }
            public void greetSomeone(String someone) {
                name = someone;
                System.out.println("Hello" + name);
            }
        }

        HelloWorld englishGreeting = new EnglishGreeting();

        HelloWorld frenchGreeting = new HelloWorld() {
            String name = "tout le monde";
            public void greet() {
                greetSomeone("tout le monde");
            }
            public void greetSomeone(String someone) {
                name = someone;
                System.out.println("Salut " + name);
            }
        };

        HelloWorld spanishGreeting = new HelloWorld() {
            String name = "mundo";
            public void greet() {
                greetSomeone("mundo");
            }
            public void greetSomeone(String someone) {
                name = someone;
                System.out.println("Hola, " + name);
            }
        };
        englishGreeting.greet();
        frenchGreeting.greetSomeone("Fred");
        spanishGreeting.greet();
    }
    ...
}
```

## Syntax of Anonymous Classes

As mentioned previously, an anonymous class is an expression. The syntax of an anonymous class expression is like the invocation of a constructor,
except that there is a class definition container in a block of code. Consider the instantiation of the `frenchGreeting` object:

```java
HelloWorld frenchGreeting = new HelloWorld() {
   String name = "tout le monde";
   public void greet() {
      greetSomeone("tout le monde");
   }
   public void greetSomeone(String someone) {
      name = someone;
      System.out.println("Salut " + name);
   }
};
```

The anonymous class expression consists of the following:

  * The `new` operator
  * The name of the interface to implement or a class to extend. In this example, the anonymous class is implementing the iface `HelloWorld`.
  * The parenthesis that contain the arguments to a constructor, just like a normal class creation expression. 
  **Note**: when you implement an interface there is no constructor, use empty set of parentheses.
  * a class declaration body. Method declarations are allowed but statements are not.

Because an anonymous class definition is an expression, it must be part of a statement. 

## Accessing Local Variables of the Enclosing Scope, and Declaring and Accessing Members of the Anonymous Class

Like local classes, anonymous classes can capture variables; they have the same access to local variables of the enclosing scope:

  * An anonymous class has access to the members of its enclosing class
  * An anonymous class cannot access local variables in its enclosing scope that are not declared as `final` or effectively final
  * Like a nested class, a declaration of a type (such as a variable) in an anonymous class shadows any other declarations in the 
enclosing scope that have the same name. 

Anonymous classes also have the same restrictions as local classes with respect to their members:

  * You cannot declare static initializers of member interfaces in an anonymous class.
  * An anonymous class can have static members provided that they are constant variables

Note that you can declare the following in anonymous classes:

  * Fields
  * Extra methods (even if they do not implement any methods of the supertype)
  * Instance initializers
  * Local classes

However you cannot declare constructors in an anonymous class.


