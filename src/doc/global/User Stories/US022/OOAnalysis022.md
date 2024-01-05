# OO Analysis 022

US022 - As receptionist, I want to register the arrival of a SNS user to take the vaccine. [Priority: Low]

**Roles of People or Organizations**

* Receptionist
    - Description: Represents the receptionist who performs actions related to registering the arrival of SNS users.

**Noteworthy Events**

* SNSUserArrival
    - Attributes:
        - ArrivalDateTime: Date and time for the arrival of the SNS user.

### Rationale to identify associations between conceptual classes ###

An association is a relationship between instances of objects that indicates a relevant connection and that is worth remembering, or it is derivable from the List of Common Associations:

+ **_A_** is related with a transaction (item) of **_B_**

| Concept (A)      | Association | Concept (B) |
| ----------------- | ----------- | ------------ |
| Receptionist      | registers   | SNSUserArrival  |

## Domain Model

[domainModel022.puml](domainModel022.puml)
