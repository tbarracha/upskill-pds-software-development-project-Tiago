# OO Analysis 012 #

US012 - As administrator, I want to get a list of all vaccines. [Priority: High]
- AC012-01: The vaccines should be grouped by type and then listed alphabetically by name.

### _Conceptual Class Category List_ ###

**Product/Service related to a Transaction or Transaction Line Item**

* Vaccine
    - Attributes:
        - Id: Numeric code automatically generated, starting at 1.
        - Name: The name of the vaccine.
        - Brand: The brand of the vaccine.
        - VaccineType: The type of vaccine (selected from a predefined list).

**Roles of People or Organizations**

* Administrator
    - Description: Represents the administrator who performs actions related to the system.

### Rationale to identify associations between conceptual classes ###

An association is a relationship between instances of objects that indicates a relevant connection and that is worth remembering, or it is derivable from the List of Common Associations:

+ **_A_** is related with a transaction (item) of **_B_**

| Concept (A)   | Association | Concept (B) |
| -------------- | ----------- | ------------ |
| Administrator  | manages     | Vaccine      |

## Domain Model

[domainModel012.puml](domainModel012.puml)
