public class ECommerceApp {

    Database database;
    Cart cart;
    //Boolean adminMode;

    private void clearScreen(){

        for (int i = 0; i < 100; i++) {
            System.out.println();
        }
    }

    public ECommerceApp(){

        database=new Database();

        boolean flag=true;

        while(flag){

            cart=new Cart(database);

            IO.println("1. Admin login.");
            IO.println("2. Customer login.");
            IO.println("3. Exit the program.");

            int choice=IO.nextInt();

            User user;

            switch (choice){

                case 1:

                    user=new Administrator(database);
                    user.runSession();
                    break;

                case 2:

                    user=new Customer(cart);
                    user.runSession();
                    break;

                case 3:
                    IO.println("Revenue generated by Amacon: "+database.getRevenue());
                    IO.println("Exiting the program...");
                    flag=false;
                    break;

                default:
                    IO.println("Invalid input. Try again.");
            }
        }
    }
}
