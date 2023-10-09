package design.patterns.behavioral.chainofresponsibility;

public class Dollar20Dispenser implements DispenseChain {
    private DispenseChain chain;

    @Override
    public void setNextChain(DispenseChain nextChain) {
        this.chain = nextChain;
    }

    @Override
    public void dispense(Currency currency) {
        if (currency.getAmount() >= 20) {
            int num = currency.getAmount()/20;
            int remainder = currency.getAmount() % 20;
            System.out.println(num + ": $20 notes dispensed");
            if (remainder > 0) {
                this.chain.dispense(new Currency(remainder));
            }
        } else {
            this.chain.dispense(currency);
        }
    }
}
