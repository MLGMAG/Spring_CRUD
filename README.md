# Spring_CRUD
Task:

You need to create a web application that allows you to:

1. Perform user registration

2. Authorize users

3. Perform CRUD operations on the following objects:

==========================

Product:

UUID id;

String name;

BigDecimal price;

Manufacturer manufacturer;

==========================

Manufacturer

UUID id;

String name;

Set<Product> products;

==========================

Role

UUID id;

String name;

==========================

User

UUID id;

String email;

String password;

String firstName;

String lastName;

Set<Authority> authorities;

==========================

User authorities:

1. Admin - has the ability to perform all CRUD operations

2. User - has read-only access

The database stores data on manufacturers (Manufacturer) and products (Product).

Each product has a single manufacturer, and each manufacturer has a set of products.

Pages:
1. Manufacturers (the list of manufacturers + the ability to create new, edit and delete created manufacturers)

2. Products (the list of products + the ability to create new, edit and delete created goods).

3. Users (list of all users of the application and the ability to create new ones, edit and delete the created users) - ONLY for ADMIN (and reading and editing).


When creating a product, select the manufacturer using the drop-down menu.


Technologies:
Java, SQL, Spring (MVC, Data, Security), JSP, Maven, Tomcat, Git, PosgeSQL
