# OO Analysis 041

US041 - As nurse, I want to record the administration of a vaccine to a SNS user. [Priority: Low]

**Roles of People or Organizations**

* Nurse
    - Description: Represents the nurse who wants to record the administration of a vaccine to an SNS user.

**Noteworthy Events**

* VaccineAdministration
    - Description: Represents the action of a nurse recording the administration of a vaccine to an SNS user.

**Product/Service related to a Transaction or Transaction Line Item**

* Vaccine
    - Attributes:
        - Id: Numeric code automatically generated, starting at 1.
        - Name: The name of the vaccine.
        - Brand: The brand of the vaccine.
        - VaccineType: The type of vaccine (selected from a predefined list).

* SNSUser
    - Attributes:
        - Id: Numeric code automatically generated, starting at 1.
        - Name: The name of the SNS user.
        - CitizenCardNumber: The citizen card number of the SNS user.

### Rationale to identify associations between conceptual classes ###

An association is a relationship between instances of objects that indicates a relevant connection and that is worth remembering, or it is derivable from the List of Common Associations:

+ **_A_** is related with a transaction (item) of **_B_**

| Concept (A)      | Association | Concept (B) |
| ----------------- | ----------- | ------------ |
| Nurse             | records     | VaccineAdministration |
| Vaccine           | is of       | VaccineAdministration |
| SNSUser           | is related with a transaction of | VaccineAdministration |

## Domain Model

[domainModel041.puml](domainModel041.puml)
