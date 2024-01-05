# OO Analysis 015

US015 - As administrator, I want to get a list of employees with a given function/role. [Priority: Medium]

**Roles of People or Organizations**

* Administrator
    - Description: Represents the administrator who performs actions related to the system.

* Employee
    - Attributes:
        - FunctionRole: Function or role of the employee.

### Rationale to identify associations between conceptual classes ###

An association is a relationship between instances of objects that indicates a relevant connection and that is worth remembering, or it is derivable from the List of Common Associations:

+ **_A_** is related with a transaction (item) of **_B_**

| Concept (A)   | Association | Concept (B) |
| -------------- | ----------- | ------------ |
| Administrator  | gets list of | Employee      |

## Domain Model

[domainModel015.puml](domainModel015.puml)
