# OO Analysis US010 #

US010 - As administrator, I intend to specify a new vaccine type. [Priority: High]
- AC010-01: The Vaccine Type should have the following mandatory attributes: Code, Short Description and Vaccine Technology.
- AC010-02: The Code must consist of five alphanumeric characters.
- AC010-03: The Vaccine Technology must be one of six types obtained from: https://www.pfizer.com/news/articles/understanding_six_types_of_vaccine_technologies
- AC010-04: The Code must be unique for each Vaccine Type.

### _Conceptual Class Category List_ ###

**Product/Service related to a Transaction or Transaction Line Item**

* VaccineType
    - Attributes:
        - Code: Alphanumeric code (five characters) uniquely identifying the vaccine type.
        - ShortDescription: A short description of the vaccine type.
        - VaccineTechnology: The technology associated with the vaccine type (selected from a predefined list).

**Roles of People or Organizations**

* Administrator
    - Description: Represents the administrator who performs actions related to the system.

### Rationale to identify associations between conceptual classes ###

An association is a relationship between instances of objects that indicates a relevant connection and is worth remembering, or it is derivable from the List of Common Associations:

+ **_A_** is related to a transaction (item) of **_B_**

| Concept (A)      | Association | Concept (B) |
| ----------------- | ----------- | ------------ |
| Administrator     | manages     | VaccineType  |

## Domain Model

[domainModel010.puml](domainModel010.puml)
