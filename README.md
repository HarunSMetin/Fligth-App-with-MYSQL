This is a *NetBeans* **Java Swing** Project Connected with **MYSQL** Database

# How to run
Run the jar file from this path :JavaApplication1/dist/flightApp.jar

# GUI Pages

 The desktop application I wrote using Java Swing accesses the Database on MYSQL using JDBC and applies (CRUD) Create, Read, Update, Delete operations to the database within the user's authorizations.


## Login Page

Program starts with the Login page when first opened. If you are not a user, you can create an account on the application, if you are a user, according to your ID number, it understands whether you are a **Manager** or **User** and redirects to other windows.
<img
  src="Page/loginPage.PNG"
  alt="Alt text"
  style="display: inline-block; margin: 0 auto; max-width: 300px">


##  Create User 

When you click the Create User button, you are directed to another window. After entering the missing information there, the account is created.

<img
  src="Page/kaydolPage.PNG"
  alt="Alt text"
  style="display: inline-block; margin: 0 auto; max-width: 300px">

## User Page

After creating an account, you can log in by returning to the login page. When you log in as a user, your upcoming flights are listed on the left. On the right, you can search for another passenger.


#### Search Passengers
<img
  src="Page/userPageYolcuAra.PNG"
  alt="Alt text"
  style="display: inline-block; margin: 0 auto; max-width: 300px">
#### Flight Search
Or you can list the flights on the specified date by switching from the menu bar.
<img
  src="Page/userPageUçuşAra.PNG"
  alt="Alt text"
  style="display: inline-block; margin: 0 auto; max-width: 300px">


## Manager Page

If you have access as a Manager, you have 3 options. 
- ### User Info Panel
	>You can see all users in the User Info panel. You can filter, search or delete these users or add users.
	><img
	  src="Page/managerUserPage.PNG"
	  alt="Alt text"
	  style="display: inline-block; margin: 0 auto; max-width: 300px">
- ### Crew Info Panel
	>You can see all aircraft and all cabin crews in the Crew Info panel. You can search for these employees by filtering them.
	><img
	  src="Page/managerCrew.PNG"
	  alt="Alt text"
	  style="display: inline-block; margin: 0 auto; max-width: 300px">
- ### Query Panel
	>You can send a query to the Database from the Query panel and see the output from the Result section below.
	><img
	  src="Page/managerQuery.PNG"
	  alt="Alt text"
	  style="display: inline-block; margin: 0 auto; max-width: 300px">
	
# Database Adaptation:

You can use **flightapp.sql** file to create your schema and tables

## *Table images taken from MYSQL Workbench:*

### Airplane Table
<img
	  src="Table/airplaneTable.PNG"
	  alt="Alt text"
	  style="display: inline-block; margin: 0 auto; max-width: 300px">

### Airport Table
<img
	  src="Table/airportTable.PNG"
	  alt="Alt text"
	  style="display: inline-block; margin: 0 auto; max-width: 300px">

### Flight Info Table
<img
	  src="Table/flightInfoTable.PNG"
	  alt="Alt text"
	  style="display: inline-block; margin: 0 auto; max-width: 300px">

### Ticket Table
<img
	  src="Table/ticketTable.PNG"
	  alt="Alt text"
	  style="display: inline-block; margin: 0 auto; max-width: 300px">

### User Table
<img
	  src="Table/userTable.PNG"
	  alt="Alt text"
	  style="display: inline-block; margin: 0 auto; max-width: 300px">

### Seat Table
<img
	  src="Table/seatTable.PNG"
	  alt="Alt text"
	  style="display: inline-block; margin: 0 auto; max-width: 300px">


