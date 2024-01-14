# Library-Management-System-
The Library Management System is a Java-based application designed using Object-Oriented Programming (OOP) principles to simplify and automate various tasks in a library. It offers functionalities for both librarians and library members. This system allows librarians to manage books, members, and fines efficiently, while members can borrow, return books, and pay fines. It involves designing a menu-driven interface for users to interact with the library system. The interface can be used as a librarian or as a student. A librarian manages members/students and books of the library. A librarian can view, register or remove members. They can also view books, add a book, remove a book, issue a book and collect dues/fines. 

[Project Overview](#project-overview)

 [Features](#features)

`  `- [For Librarians](#for-librarians)

`  `- [For Members](#for-members)

\- [Class Structure](#class-structure)

`  `- [Main Class](#main-class)

`  `- [Book Class](#book-class)

`  `- [Member Class](#member-class)

`  `- [Librarian Class](#librarian-class)

\- [Functionality Overview](#functionality-overview)

`  `- [Main Class Functions](#main-class-functions)

`  `- [Book Class Functions](#book-class-functions)

`  `- [Member Class Functions](#member-class-functions)

`  `- [Librarian Class Functions](#librarian-class-functions)

# Features

# For Librarians

\- Register new library members.

\- Remove library members.

\- Add new books to the library with information like title, author, and number of copies.

\- Remove books from the library.

\- View a list of all members, along with their borrowed books and fines to be paid.

\- List all available books in the library.

# For Members

\- List available books for borrowing.

\- View the list of books they have borrowed.

\- Borrow books from the library, subject to limits and fines.

\- Return books to the library.

\- Pay fines accrued for overdue books.

# Class Structure

# Main Class

The Main class serves as the entry point for the application. It handles user interactions and manages the flow of the library management system.

# Book Class

The Book class represents individual books in the library. It stores information such as the book's title, author, total copies, and status. It also tracks borrowing and return times for fine calculation.

# Member Class

The Member class represents library members. It stores member details like name, age, phone number, and fine. It also maintains a list of books borrowed by the member.


# Functionality Overview

# Main Class Functions

1\. main(String[] args): The main entry point of the application. Handles user interactions and navigates between librarian and member functionalities.

# Book Class Functions

1\. Book(int id, String author, int totalCopies, String title): Constructor to create a book object with specified details.

2\. setStatus(int status): Set the status of the book (available or borrowed).

3\. setBorrowedTime(): Record the time when the book is borrowed.

4\. setReturnTime(): Record the time when the book is returned.

5\. getBorrowedTime(): Get the time when the book was borrowed.

6\. getReturnTime(): Get the time when the book was returned.

# Member Class Functions

1\. Member(String name, int age, String phoneNumber): Constructor to create a member object with personal information.

2\. Book\_Borrow(Book b): Allow a member to borrow a book.

3\. Return\_book(Book b): Allow a member to return a book and calculate fines if overdue.

4\. List\_My\_Books(): List books borrowed by the member.

# Librarian Class Functions

1\. Adding\_Member(Member m): Register a new library member.

2\. Removing\_Member(int MemId): Remove a library member.

3\. Adding\_Book(int BOOK\_ID): Add new books to the library.

4\. Removing\_book(int BookId): Remove books from the library.

5\. listAllBooks(): List all available books in the library.

6\. getMemberIdCounter(): Get the counter for member IDs.

7\. getMemberIdByNameAndPhone(String name, String phoneNumber): Get a member's ID by their name and phone number.

8\. getAgeByNameAndPhone(String name, String phoneNumber): Get a member's age by their name and phone number.

9\. listAvailableBooks(): List all available books in the library.

10\. issueBook(Member member, int bookId): Allow a librarian to lend a book to a member.

11\. viewMembersWithBooksAndFines(): Display a list of members with their borrowed books and fines.

12\. findMember(String name, String phoneNumber): Find a member by name and phone number.

13\. FinePaid(Member member): Allow a member to pay fines.

# Usage

1\. Run the Main class to start the Library Management System.

2\. Choose whether to enter as a librarian or a member.

3\. For librarians, access various library management features.

4\. For members, borrow, return books, and pay fines.


# Assumptions

- Phone number must be 10 digits long.
- Two members with same phone number but different names can be added.
- In order to modify/update any member details, they must delete the old registration and create a new one.
- A name can contain numbers/digits.
