package Laba2;

public class t7 {
    public static void main(String[] args) {
        var bankAccount = new BankAccountClass();

        bankAccount.addMoney(10);
        System.out.println(bankAccount.getMoney());

        bankAccount.reduceMoney(4);
        System.out.println(bankAccount.getMoney());
    }
}

class BankAccountClass implements BankAccount{
    private float money;

    public float getMoney() {
        return money;
    }

    public void addMoney(float delta){
        money += delta;
    }

    public void reduceMoney(float delta){
        money -= delta;
    }
}

interface BankAccount{
    public float getMoney();
    public void addMoney(float delta);
    public void reduceMoney(float delta);
}