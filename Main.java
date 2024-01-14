package org.example;

import java.util.Scanner;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {


    public static void main(String[] args) {
        int BOOK_ID = 1;
        Scanner input = new Scanner(System.in);
        Librarian librarian = new Librarian();
        int Choose=0;

        System.out.println(" #### <<<LIBRARY PORTAL INITIALISED>>> ####");
        while(true){
            System.out.println("--------------------------------");
            System.out.println("1.  Enter as a librarian");
            System.out.println("2.  Enter as a member");
            System.out.println("3.  Exit");
            System.out.println("--------------------------------");
            Choose=input.nextInt();
            if(Choose==1) {
                LibrarianLoop:
                while(true) {
                    System.out.println("--------------------------------");
                    System.out.println("1.  Register a member");
                    System.out.println("2.  Remove a member");
                    System.out.println("3.  Add a book");
                    System.out.println("4.  Remove a book");
                    System.out.println("5.  View all members along with their books and fines to be paid");
                    System.out.println("6.  View all books");
                    System.out.println("7.  Back");
                    System.out.println("--------------------------------");
                    int C1 = 0;
                    C1 = input.nextInt();
                    switch (C1) {
                        case 1:
                            System.out.println("--------------------------------");
                            System.out.print("Name: ");
                            input.nextLine();
                            String name = input.nextLine();
                            System.out.print("Age: ");
                            int age = input.nextInt();
                            System.out.print("Phone No: ");
                            input.nextLine();
                            String phoneNumber = input.nextLine();

                            Member New_Member = new Member(name, age, phoneNumber);
                            librarian.Adding_Member(New_Member);
                            break;


                        case 2:
                            System.out.println("--------------------------------");
                            System.out.print("Enter member ID to remove : ");
                            int MemberId_to_remove = input.nextInt();
                            librarian.Removing_Member(MemberId_to_remove);
                            break;
                        case 3:


                            //Book New_Book = new Book(BOOK_ID,title,Author,copies);
                            BOOK_ID=librarian.Adding_Book(BOOK_ID);

                            break;
                        case 4:
                            System.out.println("--------------------------------");
                            System.out.print("Enter Book ID to remove : ");
                            int BookId_to_remove = input.nextInt();
                            librarian.Removing_book(BookId_to_remove);
                            //BOOK_ID--;
                            break;
                        case 5:
                            librarian.viewMembersWithBooksAndFines();
                            break;
                        case 6:
                            System.out.println("--------------------------------");
                            librarian.listAllBooks();
                            System.out.println("--------------------------------");
                            break;
                        case 7:
                            break LibrarianLoop;
                    }
                }
            }
            else if(Choose==2) {
                System.out.print("Name : ");
                input.nextLine();
                String Mem_Name = input.nextLine();

                System.out.print("Phone No: ");
                String Mem_PhoneNo = input.nextLine();
                Member member = librarian.findMember(Mem_Name, Mem_PhoneNo);
                if (member!=null) {
                    System.out.println("Welcome " + Mem_Name + ". Member ID: " + librarian.getMemberIdByNameAndPhone(Mem_Name, Mem_PhoneNo));
                    //Member mem1= new Member(Mem_Name, librarian.getAgeByNameAndPhone(Mem_Name,Mem_PhoneNo),Mem_PhoneNo );

                    MemberLoop:
                    while (true) {
                        System.out.println("1.  List Available Books");
                        System.out.println("2.  List My Books");
                        System.out.println("3.  Issue book");
                        System.out.println("4.  Return book");
                        System.out.println("5.  Pay Fine");
                        System.out.println("6.  Back");
                        int C2 = 0;
                        C2 = input.nextInt();
                        switch (C2) {
                            case 1:
                                librarian.listAvailableBooks();
                                break;
                            case 2:
                                member.List_My_Books();

                                break;
                            case 3:
                                System.out.println("--------------------------------");
                                System.out.print("Book ID: ");
                                int bid = input.nextInt();
                                System.out.print("Book Name: ");
                                input.nextLine();
                                String bname = input.nextLine();

                                //Member member = librarian.getMemberByNameAndPhone(Mem_Name, Mem_PhoneNo);
                                librarian.issueBook(member,bid);
                                break;
                            case 4:
                                System.out.print("Enter Book ID: ");
                                int bid1 = input.nextInt();
                                Book book = librarian.getBookById(bid1);
                                member.Return_book(book);

                                break;
                            case 5:
                                librarian.FinePaid(member);
                                break;
                            case 6:
                                break MemberLoop;
                        }
                    }
                } else {
                    System.out.println("Member with Name: " + Mem_Name + " and Phone No: " + Mem_PhoneNo + " doesn't exist");
                    continue; // Return to the beginning of the main loop
                }
            }
            else if(Choose ==3) {
                System.out.println("--------------------------------");
                System.out.println("Thanks for Visiting!");
                System.out.println("--------------------------------");
                break;
            }
            else{
                System.out.println("Wrong Input. Please Enter Again");
            }



        }


    }
}