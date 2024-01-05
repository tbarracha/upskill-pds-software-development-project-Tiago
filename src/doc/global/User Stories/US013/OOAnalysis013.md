# OO Analysis 013 #

US013 - As administrator, I want to register a vaccination center to respond to a certain pandemic. [Priority: Medium]

### _Conceptual Class Category List_ ###

**Places**

* VaccinationCenter
    - Attributes:
        - Name: The name of the vaccination center.
        - LocationDetails: Details about the location of the vaccination center.
        - ResponseToPandemic: The specific pandemic the vaccination center is responding to.

**Roles of People or Organizations**

* Administrator
    - Description: Represents the administrator who performs actions related to the system.

### Rationale to identify associations between conceptual classes ###

An association is a relationship between instances of objects that indicates a relevant connection and that is worth remembering, or it is derivable from the List of Common Associations:

+ **_A_** is related with a transaction (item) of **_B_**

| Concept (A)           | Association           | Concept (B)         |
| --------------------- | --------------------- | ------------------- |
| Administrator          | manages               | VaccinationCenter   |

## Domain Model

[domainModel013.puml](domainModel013.puml)
