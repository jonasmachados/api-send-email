# API Send Email

## About

This project is an API for sending emails to clients using Spring Boot. The frontend can utilize the API by making a `POST` request and passing the required information in a JSON format.

To send an email, the frontend needs to include the following fields in the request body:

- `ownerRef`: Reference to the owner of the email.
- `emailFrom`: Sender's email address.
- `emailTo`: Recipient's email address.
- `subject`: Subject of the email.
- `text`: Body of the email.

## Technologies Used

The following technologies were used in this project:

- JDK 15
- Spring Boot
- Maven
- Postman
- PostgreSQL

## Setup

To set up the project, follow these steps:

1. Clone the repository.
2. Open the project in NetBeans or any Java IDE.
3. Build the project using Maven.
4. Configure the PostgreSQL database according to the application.properties file.
5. Run the application.
6. The API will be available at `http://localhost:8080`.

## Deployment

The API is deployed and can be accessed at [https://api-send-email.up.railway.app](https://api-send-email.up.railway.app).

## API Endpoints

- `POST /send-email`: Sends an email to the client.
  - Request body (JSON):
    ```json
    {
      "ownerRef": "owner123",
      "emailFrom": "sender@example.com",
      "emailTo": "recipient@example.com",
      "subject": "Example Subject",
      "text": "This is the body of the email."
    }
    ```

## Testing with Postman

You can test the API using Postman:
1. Make sure the application is running.
2. Open Postman and import the provided collection file: [Postman Collection](https://example.com/postman-collection.json).
3. Use the imported collection to test the API endpoints.

For more details, refer to the [Postman documentation](https://learning.postman.com/docs/getting-started/importing-and-exporting-data/).

