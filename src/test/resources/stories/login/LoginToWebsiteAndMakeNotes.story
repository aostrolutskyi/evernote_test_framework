Narrative:
In order use website
As a user
I want to be able to login on the website and make notes

Scenario: Login and write a note followed by a logout
Given the user is on the LoginPage
When the user enters e-mail 'ostrolutskyy@gmail.com'
And the user clicks on login button
And the user enters password 'proper_password'
And the user clicks on login button
Then the user is on the HomePage
When the user creates a note with text 'Simple text'
And the user clicks on logout
Then the user follows by a logout

Scenario: Login again and make sure a last note created
Given the user is on the LoginPage
When the user enters e-mail 'ostrolutskyy@gmail.com'
And the user clicks on login button
And the user enters password 'proper_password'
And the user clicks on login button
Then the user is on the HomePage
And a note with text 'Simple text' has been created
