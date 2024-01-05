# OO Analysis 021

US020 - As receptionist, I want to register a SNS user. [Priority: High]
- AC020-01: The attributes that should be used to describe a SNS user are: Name, Birth Date, Sex, Postal Address, Phone Number, E-mail Address, Citizen Card Number and SNS User Number. The Sex attribute is optional. All other fields are required.
- AC020-02: The Phone Number and the Citizen Card Number must have a “portuguese format”.
- AC020-03: The Phone Number, E-mail Address, Citizen Card Number and SNS User Number should be unique for each SNS user.

**Roles of People or Organizations**

* Receptionist
    - Description: Represents the receptionist who performs actions related to scheduling vaccinations.

**Noteworthy Events**

* VaccinationSchedule
    - Attributes:
        - ScheduleDate: Date and time for the scheduled vaccination.

### Rationale to identify associations between conceptual classes ###

An association is a relationship between instances of objects that indicates a relevant connection and that is worth remembering, or it is derivable from the List of Common Associations:

+ **_A_** is related with a transaction (item) of **_B_**

| Concept (A)      | Association | Concept (B) |
| ----------------- | ----------- | ------------ |
| Receptionist      | schedules   | VaccinationSchedule  |

## Domain Model

[domainModel021.puml](domainModel021.puml)
