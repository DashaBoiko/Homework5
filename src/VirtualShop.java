import java.util.Calendar;
import java.util.Scanner;

public class VirtualShop
{



    private User []users;
    private int usersCount = 0;


    private Product[]products;
    private int productsCount = 0;


    private Basket[]baskets;
    private int basketsCount = 0;



    public VirtualShop()
    {
        int count = 100;
        users = new User[count];
        products = new Product[count];
        baskets = new Basket[count];
    }


    public int getUsersCount()
    {
        return usersCount;
    }

    public int getProductsCount()
    {
        return productsCount;
    }

    public int getBasketsCount()
    {
        return basketsCount;
    }




    public static boolean CompareTo(String str1, String str2)
    {
        if(str1.length()!=str2.length())return false;

        for(int i=0;i<str1.length();i++)
            if(str1.charAt(i)!=str2.charAt(i))
                return false;

        return true;
    }


    public static boolean CheckName(String str)
    {
        for(int i=0;i<str.length();i++)
        {
            if(str.charAt(i)>='0' && str.charAt(i)<='9')
                return false;
        }

        return true;
    }




    public void createUser()
    {

        Scanner scn = new Scanner(System.in);



        int userType;
        do
        {

            System.out.print("Enter user type: 1-employee, 2-client-->");
            userType = scn.nextInt();

            if(userType<1 || userType>2)
            {
                System.out.println("You must enter the numbers 1 or 2!");
            }


        }
        while(userType<1 || userType>2);


        String userFirstName;


        boolean isUserError;

        do
        {
            isUserError=false;
            System.out.print("Enter username: ");
            userFirstName = scn.nextLine();

            if(CheckName(userFirstName)==false)
            {
                isUserError=true;
                System.out.println("Username " + userFirstName + " must not contain numbers!");
            }

        }
        while(isUserError==true);



        String userLastName;

        do
        {
            isUserError=false;
            System.out.print("Enter the user's last name: ");
            userLastName = scn.nextLine();

            if(CheckName(userLastName)==false)
            {
                isUserError=true;
                System.out.println("Last name " + userLastName + "should not consist of numbers!");
            }

        }
        while(isUserError==true);



        String userLogin;

        do
        {
            isUserError=false;
            System.out.print("Enter the login: ");
            userLogin = scn.nextLine();
            for(int i=0;i<usersCount;i++)
            {
                if(CompareTo(userLogin, users[i].getLogin())==true)
                {
                    isUserError = true;
                    break;
                }
            }

            if(isUserError==true)
            {
                System.out.println("User with login " + userLogin + "exists in the virtual store!");
            }

        }
        while(isUserError==true);
        ///////////////////////////////////////////////////////////////////



        String userPassword;

        do
        {
            isUserError=false;
            System.out.print("Enter the password: ");
            userPassword = scn.nextLine();

            if(userPassword.length()<6)
            {
                System.out.println("Password" + userPassword + " must contain at least 6 characters!");
                isUserError=true;
            }


        }
        while(isUserError==true);
        /////////////////////////////////////////////////////////////


        if(userType==1)
        {

            int userEmployeeRank;
            do
            {

                System.out.print("Enter employee rank type:\n" +
                        "1-ordinary, 2-manager, 3-management team member-->");
                userEmployeeRank = scn.nextInt();

                if(userEmployeeRank<1 || userEmployeeRank>3)
                {
                    System.out.println("You must enter numbers from 1 to 3!");
                }


            }
            while(userEmployeeRank<1 || userEmployeeRank>3);


            users[usersCount] = new Employee(userFirstName, userLastName, userLogin, userPassword, userEmployeeRank);
            usersCount++;

        }




        if(userType==2)
        {

            int userMemberOfClubOrNot;
            do
            {

                System.out.print("Are you a club member: 1-yes, 2-no-->");
                userMemberOfClubOrNot = scn.nextInt();

                if(userMemberOfClubOrNot<1 || userMemberOfClubOrNot>2)
                {
                    System.out.println("You must enter the numbers 1 or 2!");
                }


            }
            while(userMemberOfClubOrNot<1 || userMemberOfClubOrNot>2);


            users[usersCount] = new Client(userFirstName, userLastName, userLogin, userPassword, true);
            if(userMemberOfClubOrNot==2)
                ((Client)users[usersCount]).setMemberOfClubOrNot(false);
            usersCount++;

        }

    }



    public User userLogin()
    {
        Scanner scn = new Scanner(System.in);


        int userType;

        System.out.print("Enter user type: 1-employee, 2-client-->");
        userType = scn.nextInt();

        if(userType<1 || userType>2)
        {
            System.out.println("No user type "+userType+"!");
            return null;
        }


        /////////////////////////////////////////////////////////


        String userLogin, userPassword;

        System.out.print("Enter login: ");
        userLogin = scn.nextLine();
        System.out.print("Enter password: ");
        userPassword = scn.nextLine();


        for(int i=0;i<usersCount;i++)
        {

            if(users[i].getType()==userType)
            {
                if(CompareTo(users[i].getLogin(), userLogin) == true &&
                        CompareTo(users[i].getPassword(), userPassword) == true)
                    return users[i];
            }
        }

        System.out.println("The username and/or password is incorrect!");

        return null;
    }



    public void printAllClients ()
    {
        int currentClient = 0;

        for(int i=0;i<this.usersCount;i++)
        {
            if(users[i].getType()==2)
            {
                System.out.println("Client № "+(currentClient+1));
                System.out.println(users[i]);
                currentClient++;
            }
        }

        if(currentClient==0)
            System.out.println("There are no customers in the store!");
    }


    public void printAllClubMembers ()
    {
        int currentClient = 0;

        for(int i=0;i<this.usersCount;i++)
        {
            if(users[i].getType()==2)
            {
                if(((Client)users[i]).getMemberOfClubOrNot()==true)
                {
                    System.out.println("Client № "+(currentClient+1));
                    System.out.println(users[i]);
                    currentClient++;
                }
            }
        }

        if(currentClient==0)
            System.out.println("Missing customers who are members of the club in the store!");
    }


    public void printClientListWithOnePurchase ()
    {
        int currentClient = 0;

        for(int i=0;i<this.basketsCount;i++)
        {
            if(baskets[i].getProductCountForOneClient()>0)
            {
                System.out.println("Client № "+(currentClient+1));
                System.out.println("Purchase date "+ baskets[i].getDayOfPurchase());
                System.out.println(baskets[i].getBuyingUser());
                currentClient++;
            }
        }

        if(currentClient==0)
            System.out.println("There are no customers who bought at least one item in the store in the store!");
    }


    public void theBiggestSumOfPurchase()
    {
        int currentIndexClient = -1;
        double maximalPurchasePrice=0;

        for(int i=0;i<this.basketsCount;i++)
        {
            if(baskets[i].getProductCountForOneClient()>0)
            {
                if(baskets[i].costCalculation()>maximalPurchasePrice)
                {
                    maximalPurchasePrice = baskets[i].costCalculation();
                    currentIndexClient = i;
                }

            }
        }


        if(currentIndexClient==-1)
        {
            System.out.println("There are no customers who bought at least one item in the store in the store!");
            return;
        }

        System.out.println("Client № "+(currentIndexClient+1));
        System.out.println("Date of purchase "+ baskets[currentIndexClient].getDayOfPurchase());
        System.out.println(baskets[currentIndexClient].getBuyingUser());

    }


    public void addingProductToTheShop()
    {
        Scanner scn = new Scanner(System.in);



        String productName;
        System.out.print("Enter product name:");
        productName = scn.nextLine();

        String productCharacteristic;
        System.out.print("Enter product description: ");
        productCharacteristic = scn.nextLine();


        int productQuantity;
        do
        {

            System.out.print("Enter the quantity of goods in stock:");
            productQuantity = scn.nextInt();

            if(productQuantity<0)
            {
                System.out.println("Quantity of goods cannot be less than 0!");
            }


        }
        while(productQuantity<0);



        double productPrice;
        do
        {

            System.out.print("Enter the quantity price of the item: ");
            productPrice = scn.nextDouble();

            if(productPrice<1 || productPrice>500000)
            {
                System.out.println("The price of the goods lies in the range from 1 to 500,000 shekels!");
            }


        }
        while(productPrice<1 || productPrice>500000);
        /////////////////////////////////////////////////


        int salePercent;
        do
        {

            System.out.print("Enter the product discount in %: ");
            salePercent = scn.nextInt();

            if(salePercent<0||salePercent>70)
            {
                System.out.println("The discount on the goods lies in the range from 0 to 70%!");
            }


        }
        while(salePercent<0||salePercent>70);



        products[productsCount] = new Product(productName, productCharacteristic, productQuantity,
                0, productPrice, salePercent);
        productsCount++;
        ///////////////////////////////////////////////
    }


    public void quantityChange()
    {

        if(productsCount==0)
        {
            System.out.println("Items out of stock!");
            return;
        }

        Scanner scn = new Scanner(System.in);


        int i;
        for(i=0;i<productsCount;i++)
        {
            System.out.println((i+1)+". " + products[i].getProductName()+
                    ".Count: "+products[i].getProductQuantity());
        }



        int numberProduct;
        do
        {

            System.out.print("Enter items in stock from 1 to" + productsCount);
            numberProduct = scn.nextInt();

            if(numberProduct<1||numberProduct>productsCount)
            {
                System.out.println("Error. Item number in the range from 1 to" + productsCount);
            }


        }
        while(numberProduct<1||numberProduct>productsCount);
        /////////////////////////////////////////////////


        int productQuantity;
        do
        {

            System.out.print("Enter the updated stock quantity: ");
            productQuantity = scn.nextInt();

            if(productQuantity<0)
            {
                System.out.println("Quantity of goods cannot be less than 0!");
            }


        }
        while(productQuantity<0);

        products[numberProduct-1].setProductQuantity(productQuantity);
    }


    public void clientPurchase(Client client)
    {

        String greeting = "Hello "+client.getFirstName()+" "
                +client.getLastName();

        if(client.getMemberOfClubOrNot()==true)
            greeting+=" (VIP)";

        greeting+="!";

        System.out.println(greeting);
        //////////////////////////////////////////////

        int currentProduct = 0;


        int i;
        for(i=0;i<productsCount;i++)
        {
            if(products[i].getProductQuantity()>0)
            {
                System.out.println((currentProduct+1)+". " + products[i].getProductName()+
                        ". Count: "+products[i].getProductQuantity());
                currentProduct++;
            }
        }

        if(currentProduct==0)
        {
            System.out.println("Items out of stock!");
            return;
        }

        Scanner scn = new Scanner(System.in);




        Basket clientBusket = new Basket();


        while(true)
        {


            int numberProduct;

            do
            {

                System.out.print("Enter items in stock from 1 to " + currentProduct);
                numberProduct = scn.nextInt();


                if(numberProduct==-1)
                {
                    System.out.println("Purchase completed!");
                    break;
                }

                if(numberProduct<1||numberProduct>currentProduct)
                {
                    System.out.println("Error. Item number in the range from 1 to" + currentProduct);
                }


            }
            while(numberProduct<1||numberProduct>currentProduct);
            /////////////////////////////////////////////////


            if(numberProduct==-1)
            {

                if(clientBusket.getProductCountForOneClient()>0)
                {
                    clientBusket.setDayOfPurchase(Calendar.getInstance().getTime());
                    clientBusket.setBuyingUser(client);

                    baskets[basketsCount] = clientBusket;
                    basketsCount++;

                    System.out.println("Purchase completed. Total cart value: " + clientBusket.getPurchasePrice());

                }


                return;
            }


            int indexProduct = 0;
            currentProduct = 0;
            for(i=0;i<productsCount;i++)
            {
                if(products[i].getProductQuantity()>0)
                {
                    currentProduct++;
                    if(currentProduct==numberProduct)
                    {
                        indexProduct = i;
                        break;
                    }
                }
            }
            ////////////////////////////////////////////




            int quantityOfPurchasedProducts;
            do
            {

                System.out.print("Enter the quantity of goods from 1 to "+products[indexProduct].getProductQuantity());
                quantityOfPurchasedProducts = scn.nextInt();

                if(quantityOfPurchasedProducts<1 || quantityOfPurchasedProducts>products[indexProduct].getProductQuantity())
                {
                    System.out.println("The quantity of the product must be in the range from 1 to" + products[indexProduct].getProductQuantity()+"!");
                }


            }
            while(quantityOfPurchasedProducts<1 || quantityOfPurchasedProducts>products[indexProduct].getProductQuantity());

            products[indexProduct].setProductQuantity(products[indexProduct].getProductQuantity()-quantityOfPurchasedProducts);


            clientBusket.addProduct(products[indexProduct]);


            for(i=0;i<clientBusket.getProductCountForOneClient();i++)
            {
                System.out.println(clientBusket.getArrayOfProducts()[i]);
            }

            System.out.println("Current basket value: " + clientBusket.getPurchasePrice());

        }


    }

}
