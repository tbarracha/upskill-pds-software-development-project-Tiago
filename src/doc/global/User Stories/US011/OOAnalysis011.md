# OO Analysis 011 #

### _Conceptual Class Category List_ ###

US011 - As administrator, I want to register a vaccine. [Priority: High]
- AC011-01: The attributes that should be used to describe a Vaccine are: Id (automatic), Name, Brand and Vaccine Type.
- AC011-02: The Vaccine Type must be selected from a list displayed to the user.
- AC011-03: The attributes Name and Brand must not have special characters.
- AC011-04: The Id is a numeric code that starts at 1 and is generated sequentially.

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

[domainModel011.puml](domainModel011.puml)
