 Hospital & Pharmacy Management System


A hospital wants to digitize its operations through a set of REST APIs. 
You are required to build a secure , production-ready backend system using
Spring Boot that manages patients, pharmacy stock and prescriptions.

Requirements
1. Patient Module
A patient has the basic details withpatientType (INPATIENT or OUTPATIENT)
InPatient additionally has numberOfDaysAdmitted and dailyCharge
OutPatient additionally has consultationFee and numberOfVisits
Bill for InPatient = numberOfDaysAdmitted × dailyCharge
Bill for OutPatient = consultationFee × numberOfVisits

Build the following APIs:
POST Register a new patient
    GET Get all patients
GET Get a specific patient
GET Get the calculated bill for a patient
GET Get all INPATIENT or OUTPATIENT patients
DELETE Discharge a patient

2. Medicine Module

POST Add a new medicine
GET Get all medicines
GET Get a specific medicine
PUT Reduce stock by given units
GET Get all medicines where stock is below a given threshold

3. Prescription Module
A prescription links a patient to a list of medicines with quantity for each

POST Create a new prescription
GET Get all prescriptions
GET Get a specific prescription with full patient and medicine details
GET Get all prescriptions for a specific patient
GET Get all prescriptions written by a specific doctor
DELETE Cancel a prescription

4. Doctor Module
A doctor can be linked to multiple patients and can author multiple prescriptions
POST Register a new doctor
GET Get all doctors
GET Get a specific doctor with their linked patients
GET Get all prescriptions written by a specific doctor
DELETE Remove a doctor

5. Security

Implement role-based access control with two roles: ADMIN and DOCTOR
Store users and their roles in the database, not in memory or application properties
Passwords must never be stored in plain text
The following access rules must be enforced:

ADMIN Full access to all modules
DOCTOR Can view patients, create and view prescriptions, view medicines
DOCTOR Cannot register or discharge patients, cannot add or dispense medicines
Both Cannot access endpoints outside their permission scope

Any unauthenticated request must receive an appropriate HTTP response
Any authenticated but unauthorized request must receive a different and appropriate HTTP response

6. Database Design

All data must be persisted in a MySQL database
Design your tables to correctly reflect the following relationships:
A doctor has many patients
A patient belongs to one doctor
A prescription belongs to one patient and one doctor
A prescription contains many medicines, and the same medicine can appear in many prescriptions

All relationships must be implemented using proper JPA annotations
Cascading must be configured thoughtfully — deleting a doctor must not delete patient records

7. Additional Conditions

Registering a patient or doctor with an ID that already exists must return an appropriate HTTP response
Dispensing medicine where requested units exceed available stock must return an appropriate HTTP 
response with a meaningful message
Creating a prescription for a non-existing patient, doctor, or medicine must return an appropriate 
HTTP response
All validation errors, business errors, and not-found cases must be handled globally in one place
All API responses must follow a consistent JSON structure
Sensitive endpoints must be tested with both authorized and unauthorized users in Postman