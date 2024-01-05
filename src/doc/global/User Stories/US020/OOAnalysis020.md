# OO Analysis 020

US020 - As receptionist, I want to register a SNS user. [Priority: High]
- AC020-01: The attributes that should be used to describe a SNS user are: Name, Birth Date, Sex, Postal Address, Phone Number, E-mail Address, Citizen Card Number and SNS User Number. The Sex attribute is optional. All other fields are required.
- AC020-02: The Phone Number and the Citizen Card Number must have a “portuguese format”.
- AC020-03: The Phone Number, E-mail Address, Citizen Card Number and SNS User Number should be unique for each SNS user.

**Product/Service related to a Transaction or Transaction Line Item**

* SNSUser
    - Attributes:
        - Name: Name of the SNS user.
        - BirthDate: Date of birth of the SNS user.
        - Sex: Gender of the SNS user (optional).
        - PostalAddress: Postal address of the SNS user.
        - PhoneNumber: Phone number of the SNS user (must have Portuguese format).
        - EmailAddress: Email address of the SNS user.
        - CitizenCardNumber: Citizen card number of the SNS user (must have Portuguese format).
        - SNSUserNumber: SNS user number (must be unique).

**Roles of People or Organizations**

* Receptionist
    - Description: Represents the receptionist who performs actions related to registering SNS users.

### Rationale to identify associations between conceptual classes ###

An association is a relationship between instances of objects that indicates a relevant connection and that is worth remembering, or it is derivable from the List of Common Associations:

+ **_A_** is related with a transaction (item) of **_B_**

| Concept (A)   | Association | Concept (B) |
| -------------- | ----------- | ------------ |
| Receptionist  | registers    | SNSUser      |

## Domain Model

[domainModel020.puml](domainModel020.puml)