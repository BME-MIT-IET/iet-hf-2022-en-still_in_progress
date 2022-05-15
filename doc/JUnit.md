# JUnit Tests for Backend Classes

We implemented unit tests for the following classes

- Asteroid (10 tests)
- Settler
- Robot (4 tests)

## Description
The unit tests were created with the JUnit pluggin in of IntelliJ. Only methods with importance for the game flow were tested; getter/setter methods are not tests explicitly.
Whenever it was useful tests for different use cases of a method were implemented, i.e. a successful or unsuccessful method call.


## Main Results
The test `perihelionChanger_WaterIceAsteroidUT_NoSublimation()` actually revealed an error in the `perihelionChanger()` method. The error was immediately fixed.

The project had no unit tests before, therefore the code coverage was **0%**.

The implemented tests achieve a code coverage of **...**.


**ADD PITCURE OF CODE COVERAGE HERE**



## Lessons learnt

- implementing tests requires deep understanding of the control flow of the tested method
- initializing objects for internal checks 
- using IDE supported tools for better and similar results
- during development it is important to desing method with testability in mind. Too many dependencies between methods make testing harder
