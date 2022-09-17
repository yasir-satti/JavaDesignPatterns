# Design Patterns using JAVA
## Contents

1. What is a design pattern

2. Patterns

    - Behavioural
      - Observer

## 1. What is a design pattern


A design pattern is solution for a problem, it helps you to design a solution and derive an implementation for the
solution. Design patterns are common solutions for common problems found in software design.

Design patterns is all about designing maintainable and extensible object-oriented software

A deisgn pattern usually is described having:

 - Intent
    this describes the problem and the solution

  - Motivations
    Provides more detail on the problem and how the pattern makes the solution possible

   - Structure
    Provides the classes that make the pattern solution and how they relate to each other

   - Code example
    Sample example using a language to make it easier to grasp how the pattern works

## 2. Patterns

### 2.1 Observer (behavioural)

        - Intent
a behavioral design pattern that lets you define a subscription mechanism to notify multiple objects about any events 
that happen to the object they’re observing.

        - Problem
A COSTOMER is interested in a specific item a STORE is about to lanuch. So either the CUSTOMER wastes time checking the 
avaialbility of the item or STORE wastes resources notifying wrong customers.

        - Solution
Observer pattern provides a PUBLISHER class and  a SUBSCRIBERS class. Publisher class ( in this case STORE ) sends 
regular stream events recieved by subscribes (in this case CUSTOMER )

