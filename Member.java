package org.example;

import java.util.ArrayList;

public class Member {
    private String Name;
    private int Age;
    private String PhoneNumber;
    private int Fine;

    private int RealtimeDue;
    private ArrayList<Book> BooksBorrowed;

    public Member(String name, int age, String phoneNumber) {
        this.Name = name;
        this.Age = age;
        this.PhoneNumber = phoneNumber;
        this.Fine = 0;
        this.BooksBorrowed = new ArrayList<>();
    }

    public String getName() {
        return Name;
    }
    public ArrayList<Book> getBooksBorrowed() {
        return BooksBorrowed;
    }

    public int getRealtimeDue() {
        return RealtimeDue;
    }

    public void setRealtimeDue(int realtimeDue) {
        RealtimeDue = realtimeDue;
    }

    public void setFine(int fine) {
        Fine = fine;
    }

    public int getFine() {
        return Fine;
    }

    public String getPhoneNumber() {
        return PhoneNumber;
    }
    public int getAge() {
        return Age;
    }
    public void Book_Borrow(Book b){
        if(BooksBorrowed.size()>=2){
            System.out.println("You already have issued 2 books at the moment. Cannot issue further");
            return;
        }

        if(Fine>0){
            System.out.println("You have to pay the fine first before you can issue any more books");
            return;
        }
        if(b.getStatus()==0){
            System.out.println("Book is not available at the moment");
        }

        for(Book b1 : BooksBorrowed ){
            if(b1.getBookId() == b.getBookId()){
                System.out.println("You have already borrowed the same book");
                return;
            }
        }
        BooksBorrowed.add(b);
        //b.reduceAvailableCopies();
        b.setBorrowedTime();
        System.out.println("--------------------------------");
        System.out.println("Book Issued Successfully!");
        System.out.println("--------------------------------");
        b.setStatus(0);
    }
    public void Return_book(Book b){
        if(BooksBorrowed.contains(b)){
            BooksBorrowed.remove(b);
            b.setReturnTime();
            long difference = b.getReturnTime()-b.getBorrowedTime();
            int due = (int)(3*((difference/1000)-10));
            this.Fine+=due;
            System.out.println("--------------------------------");
            System.out.println("Book ID: "+ b.getBookId()+" successfully returned."+due+" Rupees has been charged for a delay of "+((difference/1000)-10)+" days.");
            //b.IncreaseAvailableCopies();

            b.setStatus(1);
        }
        else{
            System.out.println("You have not borrowed this book");
        }
    }
    public void List_My_Books(){
        if(BooksBorrowed.isEmpty()){
            System.out.println("--------------------------------");
            System.out.println("No books borrowed");
            System.out.println("--------------------------------");

        }else{
            System.out.println("--------------------------------");
            System.out.println("Books Borrowed : ");
            for( Book book : BooksBorrowed){
                System.out.println("Book ID - " + book.getBookId());
                System.out.println("Name - " + book.getTitle());
                System.out.println("Author - " + book.getAuthor());

            }
            System.out.println("--------------------------------");
        }
    }
}

