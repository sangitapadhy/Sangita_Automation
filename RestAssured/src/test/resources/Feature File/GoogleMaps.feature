Feature: Validate the GoogleMap API

Scenario: To validate the POST Method to add a Place
Given Add place Payload to validate
When User calls "AddplaceAPI" with Post HTTP Request
Then The API call got success with Status Code
And "scope" in Response body is "APP"
