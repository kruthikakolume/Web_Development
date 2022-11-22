The frontend has 
-> login page where credentials are matched using database.
-> signup page where new user is created in database.
-> Once logged in, there are four pages which has info in cards
  - Home having some information and also list of users from database which is displayed using map()
  - About page giving some more info
  - Jobs showing available job info
  - Contact page where user can fill in details to be contacted

The folder structure is in such a way that
-> src has frontend code wherein 
   - index.js is entry point which redirects to App.js which uses react-router to route with Login.js as its default page
   - Once logged in, all the pages in pages folder are visible through navigation bar

Steps to run the project:
-> You need to have node installed
-> npm install
-> To run frontend, npm start in the folder, it will run in 3000