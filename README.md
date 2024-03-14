## Warning! Work in progress! :)

## Todo:

Features still needed to be done:

1. **Swagger Documentation**: Add swagger endpoints.

2. **Database**: Create and host database somewhere.

3. **Database**: Fill database with advices.

4. **Backend**: Deploy backend to Azure Cloud.
   
5. **Tests**: Add tests.

6. **Ai**: Generate hairstyle image based on recommendation.

7. **Backend**: Add image to Advice Model.

8. **Database**: Add images to database.

9. **Frontend**: Create simple frontend.


# AI Hair Advise API

Welcome to the AI Hair Advise API! This RESTful API provides a convenient way to generate recommended hairstyles based on human characteristics. Whether you're an individual looking for a fresh style or a hairdresser seeking suggestions for your clients, this application has you covered.

## Technologies Used

- **Java 17**: The core programming language used to build the application.
- **Azure Deployment**: The application is hosted on the Azure cloud platform, ensuring reliability and scalability.
- **PostgreSQL Database**: Human characteristics data is stored securely on ElephantSQL, a PostgreSQL database service.
- **Spring 3**: The backend is built using the Spring framework, providing a robust and flexible architecture.
- **Swagger**: API documentation is powered by Swagger, making it easy for developers to explore and understand the available endpoints.

## How It Works

The API takes human characteristics as input and leverages the power of AI through ChatGPT 3.5 Turbo to recommend suitable hairstyles. It generates personalized responses based on the provided characteristics while utilizing the knowledge of AI to suggest trendy and fitting hairstyles.

## Getting Started

To use the API, follow these steps:

1. **Swagger Documentation**: Explore the API using the Swagger documentation available at [API Documentation](#swagger-url).

2. **Make Requests**: Use Swagger UI or any API testing tool to make requests to the API, providing human characteristics as input.

3. **Get Recommendations**: Receive personalized hairstyle recommendations based on the input characteristics, generated with the help of AI ChatGPT 3.5 Turbo.

## Example request

```json
{
  "hairColor": "brown",
  "faceShape": "oval",
  "sex": "female"
}
```


## Example response

```json
{
  "recommendation": "Consider a layered bob with highlights. It will complement your features and style preferences."
}
```

## Swagger Documentation

Explore and interact with the API using the Swagger documentation available at Swagger UI.

## Release notes

No release currently available

## Note

This is the backend and API version for now. Future versions may include a frontend for a more user-friendly experience.

Feel free to reach out if you have any questions or feedback. Happy hairstyling!



