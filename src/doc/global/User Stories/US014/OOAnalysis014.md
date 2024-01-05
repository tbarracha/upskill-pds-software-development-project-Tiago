# OO Analysis 014 #

### _Conceptual Class Category List_ ###

**Roles of People or Organizations**

* Employee
    - Attributes:
        - Name: The name of the employee.
        - Role: The role specification of the employee.

* Administrator
    - Description: Represents the administrator who performs actions related to the system.

### Rationale to identify associations between conceptual classes ###

An association is a relationship between instances of objects that indicates a relevant connection and that is worth remembering, or it is derivable from the List of Common Associations:

+ **_A_** is related with a transaction (item) of **_B_**

| Concept (A)   | Association | Concept (B)     |
| ------------- | ----------- | --------------- |
| Administrator  | manages     | Employee        |

## Domain Model

[domainModel014.puml](domainModel014.puml)
