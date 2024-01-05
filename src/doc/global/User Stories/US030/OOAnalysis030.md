# OO Analysis 030

US030 - As SNS user, I intend to use the application to schedule a vaccination. [Priority: Medium]

**Roles of People or Organizations**

* SNSUser
    - Description: Represents the SNS user who intends to use the application to schedule a vaccination.

**Noteworthy Events**

* VaccinationScheduling
    - Attributes:
        - DesiredVaccinationDateTime: Date and time for the desired vaccination.

### Rationale to identify associations between conceptual classes ###

An association is a relationship between instances of objects that indicates a relevant connection and that is worth remembering, or it is derivable from the List of Common Associations:

+ **_A_** is related with a transaction (item) of **_B_**

| Concept (A)      | Association | Concept (B) |
| ----------------- | ----------- | ------------ |
| SNSUser           | schedules   | VaccinationScheduling |

## Domain Model

[domainModel030.puml](domainModel030.puml)
