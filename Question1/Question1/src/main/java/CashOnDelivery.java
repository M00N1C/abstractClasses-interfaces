public class CashOnDelivery extends Payment {
    public CashOnDelivery(double amount, String address) {
        super(amount);
        this.address = address;
    }
    private String address;
    @Override
    public void processPayment() {
        System.out.println("Cash On Delivery Payment Done in " + address);
        logTransaction();
    }
}
