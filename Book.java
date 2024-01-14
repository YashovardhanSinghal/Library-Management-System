package org.example;

public class Book {
    private int BookId;
    private String Author;
    private int TotalCopies;
    private String Title;

    private int Status;

    private long BorrowedTime;

    private long ReturnTime;
    //private int AvailableCopies;

    public Book(int id, String author, int totalCopies, String title) {
        this.BookId = id;
        this.Author = author;
        this.TotalCopies = totalCopies;
        this.Title = title;
        this.Status = 1;
        //this.AvailableCopies = availableBooks;
    }

    public void setStatus(int status) {
        this.Status = status;
    }

    public void setBorrowedTime() {
        BorrowedTime = System.currentTimeMillis();
    }
    public void setReturnTime() {
        ReturnTime = System.currentTimeMillis();
    }

    public long getBorrowedTime() {
        return BorrowedTime;
    }

    public long getReturnTime() {
        return ReturnTime;
    }
    //    public Book(int bookId, String title, String author, int totalCopies) {
//        BookId = bookId;
//        Author = author;
//        TotalCopies = totalCopies;
//        //AvailableCopies= totalCopies;
//        Title = title;
//    }

    public int getBookId(){
        return BookId;
    }
    public String getAuthor(){
        return Author;
    }
    public int getTotalCopies(){
        return TotalCopies;
    }
    public String getTitle(){
        return Title;
    }

    public int getStatus() {
        return Status;
    }

    //    public int getAvailableCopies(){
//        return AvailableCopies;
//    }

//    public void reduceAvailableCopies(){
//        if(AvailableCopies>0){
//            AvailableCopies--;
//        }
//    }
//    public void IncreaseAvailableCopies(){
//        if(AvailableCopies<TotalCopies){
//            AvailableCopies++;
//        }
//    }
}
