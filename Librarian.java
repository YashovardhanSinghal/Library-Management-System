package org.example;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Librarian {
    Scanner input = new Scanner(System.in);
    private HashMap<Integer, Member> members;
    private HashMap<Integer, Book> books;
    private int memberIdCounter;
    //private int bookIdCounter;

    public Book getBookById(int BookId) {
        return books.get(BookId);
    }

    public Librarian() {
        members = new HashMap<>();
        books = new HashMap<>();
        memberIdCounter = 100000;
        //bookIdCounter = 1;
    }

    public void Adding_Member(Member m) {
        int MemberId = memberIdCounter++;
        members.put(MemberId, m);
        System.out.println("--------------------------------");
        System.out.println("Member Successfully Registered with Member Id - " + "<"+MemberId+"> " +"!");
        System.out.println("--------------------------------");
    }

    public void Removing_Member(int MemId) {
        if (members.containsKey(MemId)) {
            members.remove(MemId);
            System.out.println("Member with Member Id " + MemId + " has been removed.");
        } else {
            System.out.println("Member with Member Id " + MemId + " does not exist.");
        }
    }


    public int Adding_Book(int BOOK_ID) {
        System.out.println("--------------------------------");
        System.out.print("1.    Book title : ");

        String title= input.nextLine();

        System.out.print("2.    Author : ");
        String Author = input.nextLine();
        System.out.print("3.    Copies : ");
        int copies = input.nextInt();
        input.nextLine();
        //int BookId = bookIdCounter++;
        for(int i=0;i<copies;i++){
            Book b = new Book(BOOK_ID,Author,copies,title);
            books.put(BOOK_ID, b);
            BOOK_ID++;
        }
        //System.out.println(books.size());
        System.out.println("--------------------------------");
        System.out.println("Book Added Successfully!");
        return BOOK_ID;
    }
    public void Removing_book(int BookId ){
        Book b1 = getBookById(BookId);
        if (books.containsKey(BookId)) {
            if(b1.getStatus()==0){
                System.out.println("Book currently in use");
            }else {

                books.remove(BookId);
                //bookIdCounter--;
                System.out.println("Book with Book Id " + BookId + " has been removed.");
            }
        } else {
            System.out.println("Book with Book Id " + BookId + " does not exist.");
        }


    }
    public void listAllBooks() {
        if (books.isEmpty()) {

            System.out.println("No books available in the library.");
        } else {
            //System.out.println(books.size());
            int x=0;
            for (Map.Entry<Integer, Book> entry : books.entrySet()) {
                int BookId = entry.getKey();
                Book book = entry.getValue();
                x++;
                System.out.print(x+". ");
                System.out.println("Book ID - " + BookId);
                System.out.println("Name - " + book.getTitle());
                System.out.println("Author - " + book.getAuthor());
                System.out.println();
            }
        }
    }
    public int getMemberIdCounter(){
        return memberIdCounter;

    }
    public int getMemberIdByNameAndPhone(String name, String phoneNumber) {
        for (Map.Entry<Integer, Member> entry : members.entrySet()) {
            int memberId = entry.getKey();
            Member member = entry.getValue();

            if (member.getName().equals(name) && member.getPhoneNumber().equals(phoneNumber)) {
                return memberId;
            }
        }
        return -1; // Return -1 if member not found
    }

    public int getAgeByNameAndPhone(String name, String phoneNumber) {
        for (Member member : members.values()) {
            if (member.getName().equalsIgnoreCase(name) && member.getPhoneNumber().equals(phoneNumber)) {
                return member.getAge();
            }
        }
        return -1; // Return -1 if member not found
    }

    public void listAvailableBooks() {
        System.out.println("--------------------------------");
        System.out.println("Available Books:");

        boolean AvailableBooksExist = false; // Initialize a flag to check if any available books exist

        for (Book book : books.values()) {
            if (book.getStatus()==1) {
                AvailableBooksExist = true; // Set the flag to true if at least one available book is found

                System.out.println("Book ID: " + book.getBookId());
                System.out.println("Title: " + book.getTitle());
                System.out.println("Author: " + book.getAuthor());
                //System.out.println("Available Copies: " + book.getAvailableCopies());
                System.out.println("--------------------------------");
            }
        }

        if (!AvailableBooksExist) {
            System.out.println("None at the moment");
            System.out.println("--------------------------------");
        }

    }
    public void issueBook(Member member, int bookId) {
        if (books.containsKey(bookId)) {
            Book book = books.get(bookId);

            if (book != null) {

                member.Book_Borrow(book);

            }
        } else {
            System.out.println("Invalid Book ID.");
        }
    }


    public void viewMembersWithBooksAndFines() {
        System.out.println("--------------------------------");
        System.out.println("Members and Their Borrowed Books:");
        System.out.println(" ");
        int a=1;

        for (Map.Entry<Integer, Member> entry : members.entrySet()) {
            int MemberId = entry.getKey();
            Member member = entry.getValue();
            System.out.print(a+". ");
            a++;
            System.out.println("Member ID: " + MemberId);
            System.out.println("Name: " + member.getName());
            System.out.println("Phone Number: " + member.getPhoneNumber());
            System.out.println("Age: " + member.getAge());
            ArrayList<Book> BorrowedBooks = member.getBooksBorrowed();

            System.out.println(("Fine due Rs: "+member.getFine()));

            if (!BorrowedBooks.isEmpty()) {
                System.out.println("Books Borrowed : ");
                for( Book book : BorrowedBooks){
                    book.setReturnTime();
                    int difference = (int)((book.getReturnTime()-book.getBorrowedTime())/1000);
                    if(difference>10){
                        int due = (int)(3*(difference-10));
                        int CurrentFinetobePaid=member.getFine();
                        member.setRealtimeDue(due+CurrentFinetobePaid);
                    }
                    System.out.println("Book ID - " + book.getBookId());
                    System.out.println("Name - " + book.getTitle());
                    System.out.println("Author - " + book.getAuthor());


                }
                System.out.println("Real time fine being calculated : "+member.getRealtimeDue());


            }else{
                System.out.println("No books borrowed");
                System.out.println(" ");
            }

//            double finesDue = member.getFineDue();
//            if (finesDue > 0) {
//                System.out.println("Fines Due: $" + finesDue);
//            }

            System.out.println("--------------------------------");
        }
    }
    public Member findMember(String name, String phoneNumber) {
        for (Member member : members.values()) {
            if (member.getName().equalsIgnoreCase(name) && member.getPhoneNumber().equals(phoneNumber)) {
                return member;
            }
        }
        return null;
    }
    public void FinePaid(Member member){
        int f = member.getFine();
        member.setFine(0);
        System.out.println("You had a total fine of Rs. "+f+". It has been paid successfully!");

    }


}




