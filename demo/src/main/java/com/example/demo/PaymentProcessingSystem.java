package com.example.demo;

public class PaymentProcessingSystem {

    interface PaymentMethod {
        boolean authorize(double amount);

        boolean capture(double amount);
    }

    static class CreditCardPayment implements PaymentMethod {
        private String cardNumber;
        private String expiryDate;
        private String cvv;

        public CreditCardPayment(String cardNumber, String expiryDate, String cvv) {
            this.cardNumber = cardNumber;
            this.expiryDate = expiryDate;
            this.cvv = cvv;
        }

        public boolean authorize(double amount) {
            System.out.println("Authorizing credit card payment of $" + amount);
            return true;
        }

        public boolean capture(double amount) {
            System.out.println("Capturing credit card payment of $" + amount);
            return true;
        }
    }

    static class WalletPayment implements PaymentMethod {
        private String walletId;

        public WalletPayment(String walletId) {
            this.walletId = walletId;
        }

        public boolean authorize(double amount) {
            System.out.println("Authorizing wallet payment of $" + amount);
            return true;
        }

        public boolean capture(double amount) {
            System.out.println("Capturing wallet payment of $" + amount);
            return true;
        }
    }

    static class Payment {
        private double amount;
        private PaymentMethod method;

        public Payment(double amount, PaymentMethod method) {
            this.amount = amount;
            this.method = method;
        }

        public double getAmount() {
            return amount;
        }

        public PaymentMethod getMethod() {
            return method;
        }
    }

    static class PaymentProcessor {
        public void processPayment(Payment payment) {
            System.out.println("Processing payment of $" + payment.getAmount());

            if (payment.getMethod().authorize(payment.getAmount())) {
                System.out.println("Authorization successful.");
                if (payment.getMethod().capture(payment.getAmount())) {
                    System.out.println("Payment captured successfully.");
                } else {
                    System.out.println("Failed to capture payment.");
                }
            } else {
                System.out.println("Authorization failed");
            }

            System.out.println("------------------------");
        }
    }

    public static void main(String[] args) {

        PaymentMethod creditCard = new CreditCardPayment("1234567890123456", "12/26", "123");
        Payment payment1 = new Payment(1000.0, creditCard);

        PaymentMethod wallet = new WalletPayment("WALLET9876");
        Payment payment2 = new Payment(500.0, wallet);

        PaymentProcessor processor = new PaymentProcessor();
        processor.processPayment(payment1);
        processor.processPayment(payment2);
    }
}
