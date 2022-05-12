Narrative:
In order use website
As a user
I want to be able to login on the website

Scenario: Unsuccessful login using wrong e-mail
Given the user is on the LoginPage
When the user enters e-mail 'vasyl@vasyl'
And the user clicks on login button
Then the user should see error response message 'There is no account for the username or email you entered.'

Scenario: Unsuccessful login using wrong e-mail
Given the user is on the LoginPage
When the user enters e-mail 'ostrolutskyy@gmail.com'
And the user clicks on login button
And the user enters password 'password'
And the user clicks on login button
Then the user should see incorrect password message 'Incorrect password. You modified your password 1 day ago.'

Scenario: Successful login using e-mail
Given the user is on the LoginPage
When the user enters e-mail 'ostrolutskyy@gmail.com'
And the user clicks on login button
And the user enters password 'proper_password'
And the user clicks on login button
Then the user is on the HomePage

Scenario: Unsuccessful login using e-mail via api
Given the user have e-mail 'ostrolutskyy@gmail.com' and password 'proper_password'
When the user send a login request
Then the user get a suspicious response