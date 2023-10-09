### Creational Design Pattern
##### Singleton Pattern
The singleton pattern restricts the instantiation of a Class and ensures that only one instance of the class exists in the Java Virtual Machine. The implementation of the singleton pattern has always been a controversial topic among developers.


##### Factory Pattern
The factory design pattern is used when we have a superclass with multiple subclasses and based on input, we need to return one of the subclasses. This pattern takes out the responsibility of the instantiation of a Class from the client program to the factory class. We can apply a singleton pattern on the factory class or make the factory method static.

##### Abstract Factory Pattern
The abstract factory pattern is similar to the factory pattern and is a factory of factories. If you are familiar with the factory design pattern in Java, you will notice that we have a single factory class that returns the different subclasses based on the input provided and the factory class uses if-else or switch statements to achieve this. In the abstract factory pattern, we get rid of if-else block and have a factory class for each subclass and then an abstract factory class that will return the subclass based on the input factory class.

##### Builder Pattern
The builder pattern was introduced to solve some of the problems with factory and abstract Factory design patterns when the object contains a lot of attributes. This pattern solves the issue with a large number of optional parameters and inconsistent state by providing a way to build the object step-by-step and provide a method that will actually return the final Object.

##### Prototype Pattern
The prototype pattern is used when the Object creation is costly and requires a lot of time and resources, and you have a similar Object already existing. So this pattern provides a mechanism to copy the original Object to a new Object and then modify it according to our needs. This pattern uses Java cloning to copy the Object. The prototype design pattern mandates that the Object which you are copying should provide the copying feature. It should not be done by any other class. However, whether to use the shallow or deep copy of the object properties depends on the requirements and is a design decision.


### Structural Design Pattern
##### Adapter Pattern
The adapter design pattern is one of the structural design patterns and is used so that two unrelated interfaces can work together. The object that joins these unrelated interfaces is called an adapter.

##### Composite Pattern
The composite pattern is used when we have to represent a part-whole hierarchy. When we need to create a structure in a way that the objects in the structure have to be treated the same way, we can apply the composite design pattern.

##### Proxy Pattern
The proxy pattern provides a placeholder for another Object to control access to it. This pattern is used when we want to provide controlled access to functionality.

##### Flyweight Pattern
The flyweight design pattern is used when we need to create a lot of Objects of a Class. Since every Object consumes memory space that can be crucial for low-memory devices (such as mobile devices or embedded systems), the flyweight design pattern can be applied to reduce the load on memory by sharing Objects.
String pool implementation in Java is one of the best examples of flyweight pattern implementation.

##### Fascade Pattern
The facade pattern is used to help client applications easily interact with the system.

##### Bridge Pattern
When we have interface hierarchies in both interfaces as well as implementations, then the bridge design pattern is used to decouple the interfaces from the implementation and to hide the implementation details from the client programs. The implementation of the bridge design pattern follows the notion of preferring composition over inheritance.

##### Decorator Pattern
The decorator design pattern is used to modify the functionality of an object at runtime. At the same time, other instances of the same class will not be affected by this, so the individual object gets the modified behavior. The decorator design pattern is one of the structural design patterns (such as adapter pattern, bridge pattern, or composite pattern) and uses abstract classes or interface with the composition to implement. We use inheritance or composition to extend the behavior of an object, but this is done at compile-time, and it’s applicable to all the instances of the class. We can’t add any new functionality to remove any existing behavior at runtime – this is when the decorator pattern is useful.

### Behavioral Design Pattern
##### Template Pattern
The template method pattern is a behavioral design pattern and is used to create a method stub and to defer some of the steps of implementation to the subclasses. The template method defines the steps to execute an algorithm, and it can provide a default implementation that might be common for all or some of the subclasses.

##### Mediator Pattern
The mediator design pattern is used to provide a centralized communication medium between different objects in a system. If the objects interact with each other directly, the system components are tightly-coupled with each other which makes maintainability cost higher and not flexible to extend easily. The mediator pattern focuses on providing a mediator between objects for communication and implementing loose-coupling between objects. The mediator works as a router between objects, and it can have its own logic to provide a way of communication.

##### Chain of Responsibility Pattern
The chain of responsibility pattern is used to achieve loose-coupling in software design where a request from the client is passed to a chain of objects to process them. Then the object in the chain will decide who will be processing the request and whether the request is required to be sent to the next object in the chain or not.

##### Observer Pattern
An observer design pattern is useful when you are interested in the state of an Object and want to get notified whenever there is any change. In the observer pattern, the Object that watches the state of another Object is called observer, and the Object that is being watched is called subject.

##### Strategy Pattern
Strategy pattern is used when we have multiple algorithms for a specific task, and the client decides the actual implementation be used at runtime. A strategy pattern is also known as a policy pattern. We define multiple algorithms and let client applications pass the algorithm to be used as a parameter.

##### Command Pattern
The command pattern is used to implement loose-coupling in a request-response model. In this pattern, the request is sent to the invoker and the invoker passes it to the encapsulated command object. The command object passes the request to the appropriate method of receiver to perform the specific action.

##### State Pattern
The state design pattern is used when an Object changes its behavior based on its internal state. If we have to change the behavior of an Object based on its state, we can have a state variable in the Object and use if-else condition block to perform different actions based on the state. The state pattern is used to provide a systematic and loosely-coupled way to achieve this through context and state implementations.

##### Visitor Pattern
The visitor pattern is used when we have to perform an operation on a group of similar kinds of objects. With the help of a visitor pattern, we can move the operational logic from the objects to another class.

##### Interpreter Pattern
The interpreter pattern is used to define a grammatical representation of a language and provides an interpreter to deal with this grammar.

##### Iterator Pattern
The iterator pattern is one of the behavioral patterns and is used to provide a standard way to traverse through a group of objects. The iterator pattern hides the actual implementation of traversal through the Collection and client programs use iterator methods.

##### Memento Pattern
The memento design pattern is used when we want to save the state of an object so that we can restore it later on. This pattern is used to implement this in such a way that the saved state data of the object is not accessible outside of the Object, this protects the integrity of saved state data. Memento pattern is implemented with two Objects – originator and caretaker. The originator is the Object whose state needs to be saved and restored, and it uses an inner class to save the state of Object. The inner class is called “Memento”, and it’s private so that it can’t be accessed from other objects.

