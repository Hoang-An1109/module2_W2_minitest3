package mini_Test_3;

import java.time.LocalDate;

public class CrispyFlour extends Material {
    private int quantity;   //Số lượng

    public CrispyFlour() {
    }

    public CrispyFlour(int quantity) {
        this.quantity = quantity;
    }

    public CrispyFlour(String id, String name, LocalDate manufacturingDate, int cost, int quantity) {
        super(id, name, manufacturingDate, cost);
        this.quantity = quantity;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public double getAmount() {
        double getAmount = quantity * getCost();
        return getAmount;
    }

    @Override
    public LocalDate getExpiryDate() {
        LocalDate getExpiryDate = getManufacturingDate().plusYears(1);
        return getExpiryDate;
    }


    @Override
    public String toString() {
        return "CrispyFlour{" +
                "quantity=" + quantity +
                "} " + super.toString();
    }

    @Override
    public double getRealMoney() {
        return getAmount() * 0.94;
    }

    @Override
    public double costAfterDiscount() {
        return getRealMoney() * getQuantity();
    }
}
