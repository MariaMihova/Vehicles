import java.math.BigDecimal;

public class Truck extends Vehicles{

    protected Truck(BigDecimal fuelQuantity, BigDecimal fuelConsumptionL) {
        super(fuelQuantity, fuelConsumptionL);
    }

    @Override
    protected void setFuelConsumptionL(BigDecimal fuelConsumptionL){
        super.setFuelConsumptionL(fuelConsumptionL.add(BigDecimal.valueOf(1.6)));
    }
    @Override
    protected void refueling(BigDecimal refuelL){
        this.setFuelQuantity(this.getFuelQuantity().add((refuelL.multiply(BigDecimal.valueOf(0.95)))));
    }

    @Override
    public String toString(){
        return String.format("Truck: %.2f", getFuelQuantity());
    }
}
