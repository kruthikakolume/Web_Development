The database has 
-> create users from sigup page
-> get one user for validating login
-> get all users

-> server has database code wherein
   - server.js is entry point
   - routes.js has the api calls
   - data structure is in test.js

Using nodejs, expressjs and mongodb, the following apis are created.

/user/create 
-> To create an user having username, email and password where validations are done such that
     username has only letters
     email has letters, numbers and underscore followed by northeastern.edu
     password has letters and numbers between 8-20 characters
-> The password is encrypted using bcrypt library. It is stored as hash value in database.

/user/getAll
-> All the users created are displayed.

/user/edit/:email
-> Taking email as parameter, name and password can be changed. The changed user is displayed.
-> If the email entered as parameter does not exist, it will throw error.	
/user/delete/:email
-> Taking email as parameter, user can be deleted. The deleted user name is displayed.
-> If the email entered as parameter does not exist, it will throw error.		
The file structure is such that
-> server.js is the file that connects to the database
-> app folder has routes.js where all api routes are present
-> app has models folder which has test.js where the schema is there

Running the project:
-> Install node, express, mongodb
-> npm install
-> npm start
-> It is running in localhost:3001