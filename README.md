# TestApplication (online shop)
The application has written as an implementation of the test task, which describes by: 
- https://docs.google.com/document/d/1X92XL_aIOJzmk87Tg2rqqE836jHXjR-M/edit - task description file;
- https://www.figma.com/file/H0SE8wvK5kIhQlZVxp0BNj/Online-Shop-Satria-Adhi-Pradana-(Community)?type=design&node-id=1-130 - figma project.


The application provides functionality of online marketplace.

SignIn and LogIn screens:
- the function of users authentication, with data storage in local database;
- the function of users entered data correctness verification;
- hiding/displaying of the entered password;
- checking the uniqueness of the registering users;
- verifying the existence of the user, presented to the system, in the database;

Screen Page1:
- the main screen of the marketplace, downloading information about various product categories from a remote resource and displaying it;
- the product search field by keyword (in 1 second after the user completes typing, it sends a request to the server, receiving in response a list of products that matches the symbols entered by the user, and displays it as a prompt for input)

Screen Page2:
- the screen with detail information of user selected product;
- total amount calculation of the purchase if user has changed the number of items placed in the cart;
- changing the size of the TabLayout tabs if user clicked on them;
- visual framing of the selected color icon if user clicked on them;

Screen Profile:
- screen with user profile management functionality;
- ability to change the profile photo when clicking on it;
- exit from the authorized profile by clicking on the Log out button


This is a mutlimodule project, which uses:
- clean architecture as the app layers organization principle;
- MVVM as a model for data exchanging between app layers;
- Dagger2 as a dependency injection;
- Retrofit2 + RxJava2 + Picasso for making and handling network requests;
- Room for a database;
- Android jetpack for navigation, view/data binding.

![screens](https://github.com/Pryadk0/OnlineShop/assets/100865876/008b614c-ade3-490e-8d9f-8f6d7e5480d3)
