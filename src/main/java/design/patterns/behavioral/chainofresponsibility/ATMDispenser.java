package design.patterns.behavioral.chainofresponsibility;

public class ATMDispenser {
    private DispenseChain chain1;

    public ATMDispenser() {
        this.chain1 = new Dollar50Dispenser();
        DispenseChain chain2 = new Dollar20Dispenser();
        DispenseChain chain3 = new Dollar10Dispenser();
        chain1.setNextChain(chain2);
        chain2.setNextChain(chain3);
    }

    public static void main(String[] args) {
        ATMDispenser atmDispenser = new ATMDispenser();
        int[] amounts = {29, 60, 100, 125, 40};
        for (int amount : amounts) {
            System.out.println();
            if (amount % 10 != 0) {
                System.out.println("Enter amount in multiples of 10...");
                continue;
            }
            atmDispenser.chain1.dispense(new Currency(amount));
        }
    }
}
