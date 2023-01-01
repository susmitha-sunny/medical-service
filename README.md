# Medical-Service
Medical service app to manage doctors and patients 

## Running the application:

The application uses openjdk 19.

Make sure you have docker set up in your local system.

### Follow the instructions for setting up docker:

Windows - https://docs.docker.com/desktop/install/windows-install/

Mac - https://docs.docker.com/desktop/install/mac-install/

### We can run the whole application with a single command:

docker-compose up

Docker will build image for the SpringBoot application (medical-service) and will pull the MySQL 8.0 image. Both will be running inside a docker container.

## Stopping the application:

### We can stop all the running containers with a single command:

docker-compose down

## About the application:

Medical service app contains REST calls for managing doctors and patients.
The patient has many to one relationship with doctor.

Application will be running on 8080 port. 

Below are the APIs and payload:

### Doctor:

#### 1) Retrieve details of all doctors
```http
GET /doctor/findAllDoctors
```

Response Body

```json
[
    {
        "doctorId": int,
        "firstName": string,
        "lastName": string,
        "qualification": string,
        "department": string
    }
]
```

#### 2) Retrieve details of doctor with given id
```http
GET /doctor/findDoctor/{id}
```

Response Body

```json
{
    "doctorId": int,
    "firstName": string,
    "lastName": string,
    "qualification": string,
    "department": string
}
```

#### 3) Add a doctor
```http
POST /doctor/addDoctor
```

Request Body

```json
{
    "firstName" : string,
    "lastName" : string,
    "qualification" :string,
    "department" : string
}
```

Response Body

```json
{
    "doctorId": int,
    "firstName": string,
    "lastName": string,
    "qualification": string,
    "department": string
}
```

#### 4) Update a doctor
```http
PUT /doctor/updateDoctor
```

Request Body

```json
{
    "doctorId": int,
    "firstName" : string,
    "lastName" : string,
    "qualification" :string,
    "department" : string
}
```

Response Body

```json
{
    "doctorId": int,
    "firstName" : string,
    "lastName" : string,
    "qualification" :string,
    "department" : string
}
```

#### 5) Delete a doctor
```http
DELETE /doctor/deleteDoctor/{id}
```

Response Body

```
Doctor deleted
```

### Patient

#### 1) Retrieve details of all patients
```http
GET /patient/findAllPatients
```

Response Body

```json
[
    {
        "patientId": int,
        "firstName": string,
        "lastName": string,
        "doctor": {
            "doctorId": int,
            "firstName": string,
            "lastName": string,
            "qualification": string,
            "department": string
        }
    }
]
```

#### 2) Retrieve details of patient with given id
```http
GET /patient/findPatient/{id}
```

Response Body

```json
{
    "patientId": int,
    "firstName": string,
    "lastName": string,
    "doctor": {
        "doctorId": int,
        "firstName": string,
        "lastName": string,
        "qualification": string,
        "department": string
    }
}
```

#### 3) Add a patient
```http
POST /patient/addPatient/{doctorId}
```

Request Body

```json
{
    "firstName" : string,
    "lastName" : string,
}
```

Response Body

```json
{
    "patientId": int,
    "firstName": string,
    "lastName": string,
    "doctor": {
        "doctorId": int,
        "firstName": string,
        "lastName": string,
        "qualification": string,
        "department": string
    }
}
```

#### 4) Update a patient
```http
PUT /patient/updatePatient
```

Request Body

```json
{
    "patientId": int,
    "firstName": string,
    "lastName": string,
    "doctorId": int
}
```

Response Body

```json
{
    "patientId": int,
    "firstName": string,
    "lastName": string,
    "doctor": {
        "doctorId": int,
        "firstName": string,
        "lastName": string,
        "qualification": string,
        "department": string
    }
}
```

#### 5) Delete a patient
```http
DELETE /patient/deletePatient/{id}
```

Response Body

```
Patient deleted
```
