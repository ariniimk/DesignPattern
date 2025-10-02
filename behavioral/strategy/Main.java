import java.util.logging.*;

// Strategy Pattern with Logging and Exception Handling
interface PaymentStrategy {
    void pay(int amount) throws PaymentException;
}

class CreditCardPayment implements PaymentStrategy {
    private static final Logger logger = Logger.getLogger(CreditCardPayment.class.getName());
    private String cardNumber;
    private String name;

    public CreditCardPayment(String cardNumber, String name) {
        if (cardNumber == null || cardNumber.isEmpty()) {
            throw new IllegalArgumentException("Card number cannot be null or empty.");
        }
        this.cardNumber = cardNumber;
        this.name = name;
    }

    @Override
    public void pay(int amount) throws PaymentException {
        if (amount <= 0) {
            throw new PaymentException("Invalid payment amount.");
        }
        logger.info("Paid " + amount + " using Credit Card: " + cardNumber);
    }
}

class PayPalPayment implements PaymentStrategy {
    private static final Logger logger = Logger.getLogger(PayPalPayment.class.getName());
    private String emailId;
    private String password;

    public PayPalPayment(String email, String pwd) {
        if (email == null || !email.contains("@")) {
            throw new IllegalArgumentException("Invalid email provided.");
        }
        this.emailId = email;
        this.password = pwd;
    }

    @Override
    public void pay(int amount) throws PaymentException {
        if (amount <= 0) {
            throw new PaymentException("Invalid payment amount.");
        }
        // Simulate transient error handling with retry
        int retries = 3;
        while (retries > 0) {
            try {
                logger.info("Paid " + amount + " using PayPal: " + emailId);
                return;
            } catch (Exception e) {
                retries--;
                logger.warning("Retrying PayPal payment... Attempts left: " + retries);
                if (retries == 0) throw new PaymentException("PayPal payment failed after retries.");
            }
        }
    }
}

class PaymentException extends Exception {
    public PaymentException(String message) {
        super(message);
    }
}

public class Main {
    private static final Logger logger = Logger.getLogger(Main.class.getName());

    public static void main(String[] args) {
        try {
            PaymentStrategy creditCard = new CreditCardPayment("1234567890123456", "John Doe");
            creditCard.pay(250);

            PaymentStrategy paypal = new PayPalPayment("john@example.com", "securepass");
            paypal.pay(450);
        } catch (IllegalArgumentException | PaymentException ex) {
            logger.log(Level.SEVERE, "Error occurred: " + ex.getMessage(), ex);
        }
    }
}