public class CreditCardPayment extends Payment implements SecureTransaction{
    public CreditCardPayment(double amount) {
        super(amount);
    }

    @Override
    public void processPayment() {
        if(authenticate()){
            System.out.println("Credit Card Payment done Successfully");
            logTransaction();
        }
        else{
            System.out.println("Credit Card Payment failed, Couldn't authenticate user");
        }
    }

    @Override
    public boolean authenticate() {
        return false;
    }
}
