import java.util.Scanner;
public class Main{
    private static Scanner myObj = new Scanner(System.in);
    private static int choose;
    private static boolean ok = false;
    public static String[] loginMenuOpt = {
        "Main menu: ",
        "1. Login as librarian",
        "2. Login as partner",
        "3. Login as user",
        "4. Exit"
    };
    public static String[] librarianMenuOpt = {
        "Librarian menu: ",
        "1. Add new section",
        "2. Add new partner",
        "3. Add new user",
        "4. Lend new book",
        "5. Return book",
        "6. View sections",
        "7. View all books from section",
        "8. View partners",
        "9. View books added by partner",
        "10. View users",
        "11. View books lent by user",
        "12. View all issued books",
        "13. View all available books",
        "14. Remove book",
        "15. Remove section",
        "16. Remove partner",
        "17. Remove user",
        "18. Logout"
    };

    public static String[] partnerMenuOpt = {
        "Partner menu: ",
        "1. Add new book",
        "2. View the books you added",
        "3. Logout"
    };

    public static String[] userMenuOpt = {
        "User menu: ",
        "1. View all available books",
        "2. View the books you lent",
        "3. Logout"
    };

    public static void displayLoginMenu(String[] options){
        for (String option : options){
            System.out.println(option);
        }
        System.out.print("Choose an option between 1 and 4: ");
    }
    public static void displayPartnerMenu(String[] options){
        for (String option : options){
            System.out.println(option);
        }
        System.out.print("Choose an option between 1 and 3: ");
    }
    public static void displayLibrarianMenu(String[] options){
        for (String option : options){
            System.out.println(option);
        }
        System.out.print("Choose an option between 1 and 18: ");
    }
    public static void displayUserMenu(String[] options){
        for (String option : options){
            System.out.println(option);
        }
        System.out.print("Choose an option between 1 and 3: ");
    }
    public static void clearConsole(){
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
    public static void main(String[] args) {
        clearConsole();
        displayLoginMenu(loginMenuOpt);
        choose = myObj.nextInt();
        myObj.nextLine();
        while (true) {
            switch (choose) {
                case 1:
                {
                    clearConsole();
                    LibrarianService librarianService = new LibrarianService();
                    try {
                        librarianService.loginInformation();
                    } catch (UsernameNotFoundException ex) {
                        System.err.print(ex);
                        System.exit(1);
                    } catch (IncorrectPasswordException ex1) {
                        System.err.print(ex1);
                        System.exit(1);
                    }
                    clearConsole();
                    displayLibrarianMenu(librarianMenuOpt);
                    choose = myObj.nextInt();
                    myObj.nextLine();
                    while (choose != 18){
                        switch (choose) {
                            case 1:
                            {
                                clearConsole();
                                try {
                                    librarianService.addNewSection();
                                } catch (AlreadyUsedNameException ex) {
                                    System.err.print(ex);
                                    System.exit(1);
                                }
                                break;
                            }
                            case 2:
                            {
                                clearConsole();
                                try {
                                    librarianService.addNewPartner();
                                } catch (AlreadyUsedNameException ex) {
                                    System.err.print(ex);
                                    System.exit(1);
                                } catch (AlreadyUsedEmailException ex1) {
                                    System.err.print(ex1);
                                    System.exit(1);
                                } catch (IncorrectMailFormatException ex2) {
                                    System.err.print(ex2);
                                    System.exit(1);
                                } catch (IncorrectPassFormatException ex3) {
                                    System.err.print(ex3);
                                    System.exit(1);
                                }
                                break;
                            }
                            case 3:
                            {
                                clearConsole();
                                try {
                                    librarianService.addNewUser();
                                } catch (BookNotFoundException ex) {
                                    System.err.print(ex);
                                    System.exit(1);
                                } catch (AlreadyUsedNameException ex1) {
                                    System.err.print(ex1);
                                    System.exit(1);
                                } catch (AlreadyUsedEmailException ex2) {
                                    System.err.print(ex2);
                                    System.exit(1);
                                } catch (IncorrectPasswordException ex3) {
                                    System.err.print(ex3);
                                    System.exit(1);
                                } catch (IncorrectMailFormatException ex4) {
                                    System.err.print(ex4);
                                    System.exit(1);
                                } catch (IncorrectPassFormatException ex5) {
                                    System.err.print(ex5);
                                    System.exit(1);
                                }
                                break;
                            }
                            case 4:
                            {
                                clearConsole();
                                try {
                                    librarianService.lendNewBook();
                                } catch (BookNotFoundException ex) {
                                    System.err.print(ex);
                                    System.exit(1);
                                } catch (BookAlreadyLentException ex1) {
                                    System.err.print(ex1);
                                    System.exit(1);
                                } catch (UserNotFoundException ex2) {
                                    System.err.print(ex2);
                                    System.exit(1);
                                } catch (IncorrectDateFormatException ex3) {
                                    System.err.print(ex3);
                                    System.exit(1);
                                } catch (MaxNumOfDaysException ex4) {
                                    System.err.print(ex4);
                                    System.exit(1);
                                } catch (WrongInputException ex5) {
                                    System.err.print(ex5);
                                    System.exit(1);
                                }
                                break;
                            }
                            case 5:
                            {
                                clearConsole();
                                try {
                                    librarianService.returnBook();
                                } catch (UserNotFoundException ex) {
                                    System.err.print(ex);
                                    System.exit(1);
                                } catch (BookNotFoundException ex1) {
                                    System.err.print(ex1);
                                    System.exit(1);
                                } catch (IncorrectDateFormatException ex2) {
                                    System.err.print(ex2);
                                    System.exit(1);
                                } catch (BookNotLentException ex3) {
                                    System.err.print(ex3);
                                    System.exit(1);
                                } catch (NoLentBooksException ex4) {
                                    System.err.print(ex4);
                                    System.exit(1);
                                } catch (WrongInputException ex5) {
                                    System.err.print(ex5);
                                    System.exit(1);
                                }
                                break;
                            }
                            case 6:
                            {
                                clearConsole();
                                librarianService.printSections();
                                break;
                            }
                            case 7:
                            {
                                clearConsole();
                                try {
                                    librarianService.printSectionBooks();
                                } catch (SectionNotFoundException ex) {
                                    System.err.print(ex);
                                    System.exit(1);
                                }
                                break;
                            }
                            case 8:
                            {
                                clearConsole();
                                librarianService.printPartners();
                                break;
                            }
                            case 9:
                            {
                                clearConsole();
                                try {
                                    librarianService.printPartnerBooks();
                                } catch (PartnerNotFoundException ex) {
                                    System.err.print(ex);
                                    System.exit(1);
                                }
                                break;
                            }
                            case 10:
                            {
                                clearConsole();
                                librarianService.printUsers();
                                break;
                            }
                            case 11:
                            {
                                clearConsole();
                                try {
                                    librarianService.printUserLentBooks();
                                } catch (UserNotFoundException ex) {
                                    System.err.print(ex);
                                    System.exit(1);
                                }
                                break;
                            }
                            case 12:
                            {
                                clearConsole();
                                librarianService.printIssuedBooks();
                                break;
                            }
                            case 13:
                            {
                                clearConsole();
                                librarianService.printBooks();
                                break;
                            }
                            case 14:
                            {
                                clearConsole();
                                try {
                                    librarianService.deleteBook();
                                } catch (BookNotFoundException ex) {
                                    System.err.print(ex);
                                    System.exit(1);
                                } catch (BookCurrentlyLentException ex1) {
                                    System.err.print(ex1);
                                    System.exit(1);
                                }
                                break;
                            }
                            case 15:
                            {
                                clearConsole();
                                try {
                                    librarianService.deleteSections();
                                } catch (SectionNotFoundException ex) {
                                    System.err.print(ex);
                                    System.exit(1);
                                } catch (BookCurrentlyLentException ex1) {
                                    System.err.print(ex1);
                                    System.exit(1);
                                }
                                break;
                            }
                            case 16:
                            {
                                clearConsole();
                                try {
                                    librarianService.deletePartners();
                                } catch (PartnerNotFoundException ex) {
                                    System.err.print(ex);
                                    System.exit(1);
                                } catch (BookCurrentlyLentException ex1) {
                                    System.err.print(ex1);
                                    System.exit(1);
                                }
                                break;
                            }
                            case 17:
                            {
                                clearConsole();
                                try {
                                    librarianService.deleteUsers();
                                } catch (UserNotFoundException ex) {
                                    System.err.print(ex);
                                    System.exit(1);
                                } catch (BookCurrentlyLentException ex1) {
                                    System.err.print(ex1);
                                    System.exit(1);
                                }
                                break;
                            }
                            default:
                            {
                                clearConsole();
                                System.out.println("Incorrect selection. Try again!");
                                ok = true;
                                break;
                            }
                        }
                        if(!ok) {
                            System.out.println("If you want to return to the previous menu type 0");
                            choose = myObj.nextInt();
                            myObj.nextLine();
                            if (choose == 0) {
                                clearConsole();
                                displayLibrarianMenu(librarianMenuOpt);
                                choose = myObj.nextInt();
                                myObj.nextLine();
                            }
                        }
                        else {
                            displayLibrarianMenu(librarianMenuOpt);
                            choose = myObj.nextInt();
                            myObj.nextLine();
                            ok = false;
                        }
                    }
                    break;
                }
                case 2: {
                    clearConsole();
                    PartnerService partnerService = new PartnerService();
                    if(LibrarianService.getPartners().size() == 0) {
                        System.out.println("There are no partners! ");
                        System.out.println("If you want to return to the previous menu type 0");
                        choose = myObj.nextInt();
                        myObj.nextLine();
                        if(choose == 0) {
                            choose = 3;
                            clearConsole();
                        }
                    }
                    else {
                        try {
                            partnerService.loginInformation();
                        } catch (EmailNotFoundException ex) {
                            System.err.print(ex);
                            System.exit(1);
                        } catch (IncorrectPasswordException ex1) {
                            System.err.print(ex1);
                            System.exit(1);
                        } catch (IncorrectPassFormatException ex2) {
                            System.err.print(ex2);
                            System.exit(1);
                        }
                        clearConsole();
                        displayPartnerMenu(partnerMenuOpt);
                        choose = myObj.nextInt();
                        myObj.nextLine();
                        clearConsole();
                    }
                    while (choose != 3) {
                        switch (choose) {
                            case 1:
                            {
                                clearConsole();
                                try {
                                    partnerService.addNewBook();
                                } catch (SectionNotFoundException ex) {
                                    System.err.print(ex);
                                    System.exit(1);
                                } catch (BookAlreadyAddedException ex1) {
                                    System.err.print(ex1);
                                    System.exit(1);
                                }
                                break;
                            }
                            case 2:
                            {
                                clearConsole();
                                partnerService.printPartnerBooks();
                                break;
                            }
                            default:
                            {
                                clearConsole();
                                System.out.println("Incorrect selection. Try again!");
                                ok = true;
                                break;
                            }
                        }
                        if(!ok) {
                            System.out.println("If you want to return to the previous menu type 0");
                            choose = myObj.nextInt();
                            myObj.nextLine();
                            if (choose == 0) {
                                clearConsole();
                                displayPartnerMenu(partnerMenuOpt);
                                choose = myObj.nextInt();
                                myObj.nextLine();
                            }
                        }
                        else {
                            displayPartnerMenu(partnerMenuOpt);
                            choose = myObj.nextInt();
                            myObj.nextLine();
                            ok = false;
                        }
                    }
                    break;
                }
                case 3:
                {
                    clearConsole();
                    UserService userService = new UserService();
                    if(LibrarianService.getUsers().size() == 0) {
                        System.out.println("There are no users! ");
                        System.out.println("If you want to return to the previous menu type 0");
                        choose = myObj.nextInt();
                        myObj.nextLine();
                        if(choose == 0) {
                            choose = 3;
                            clearConsole();
                        }
                    }
                    else {
                        try {
                            userService.loginInformation();
                        } catch (EmailNotFoundException ex) {
                            System.err.print(ex);
                            System.exit(1);
                        } catch (IncorrectPasswordException ex1) {
                            System.err.print(ex1);
                            System.exit(1);
                        } catch (IncorrectPassFormatException ex2) {
                            System.err.print(ex2);
                            System.exit(1);
                        }
                        clearConsole();
                        displayUserMenu(userMenuOpt);
                        choose = myObj.nextInt();
                        myObj.nextLine();
                        clearConsole();
                    }
                    while (choose != 3) {
                        switch (choose) {
                            case 1:
                            {
                                clearConsole();
                                userService.printAvailableBooks();
                                break;
                            }
                            case 2:
                            {
                                clearConsole();
                                userService.printLentBooks();
                                break;
                            }
                            default:
                            {
                                clearConsole();
                                System.out.println("Incorrect selection. Try again!");
                                ok = true;
                                break;
                            }
                        }
                        if(!ok) {
                            System.out.println("If you want to return to the previous menu type 0");
                            choose = myObj.nextInt();
                            myObj.nextLine();
                            if (choose == 0) {
                                clearConsole();
                                displayUserMenu(userMenuOpt);
                                choose = myObj.nextInt();
                                myObj.nextLine();
                            }
                        }
                        else {
                            displayUserMenu(userMenuOpt);
                            choose = myObj.nextInt();
                            myObj.nextLine();
                            ok = false;
                        }
                    }
                    break;
                }
                case 4:
                {
                    clearConsole();
                    System.exit(0);
                    break;
                }
                default:
                {
                    clearConsole();
                    System.out.println("Incorrect selection. Try again!");
                    ok = true;
                    break;
                }
            }
            if(!ok) {
                clearConsole();
            }
            displayLoginMenu(loginMenuOpt);
            choose = myObj.nextInt();
            myObj.nextLine();
            ok = false;
        }
    }
}
