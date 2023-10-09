package design.patterns.behavioral.chainofresponsibility;

public class Dollar50Dispenser implements DispenseChain {
    private DispenseChain chain;

    @Override
    public void setNextChain(DispenseChain nextChain) {
        this.chain = nextChain;
    }

    @Override
    public void dispense(Currency currency) {
        System.out.println("Dispensing amount: " + currency.getAmount());
        if (currency.getAmount() >= 50) {
            int num = currency.getAmount()/50;
            int remainder = currency.getAmount() % 50;
            System.out.println(num + ": $50 notes dispensed");
            if (remainder > 0) {
                this.chain.dispense(new Currency(remainder));
            }
        } else {
            this.chain.dispense(currency);
        }
    }
}
