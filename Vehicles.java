import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.NumberFormat;

public abstract class Vehicles {
    private BigDecimal fuelQuantity;
    private BigDecimal fuelConsumptionL;

    protected Vehicles(BigDecimal fuelQuantity, BigDecimal fuelConsumptionL) {
        this.setFuelQuantity(fuelQuantity);
        this.setFuelConsumptionL(fuelConsumptionL);

    }

    protected void setFuelQuantity(BigDecimal fuelQuantity) {
        if(validate(fuelQuantity)) {
            this.fuelQuantity = fuelQuantity;
        }
    }

    public BigDecimal getFuelQuantity() {
        return fuelQuantity;
    }

    protected void setFuelConsumptionL(BigDecimal fuelConsumptionL) {
        if(validate(fuelConsumptionL)) {
            this.fuelConsumptionL = fuelConsumptionL;
        }
    }

    public BigDecimal getFuelConsumptionL() {
        return fuelConsumptionL;
    }


    protected String driving(BigDecimal distance){
        //DecimalFormat df = new DecimalFormat("0.00########")
        //String formatted = df.format(bigDecimal.stripTrailingZeros())
        NumberFormat formatter = new DecimalFormat("0.##");
        if(fuelQuantity.compareTo(fuelConsumptionL.multiply(distance)) >0){
            this.setFuelQuantity(this.getFuelQuantity().subtract(fuelConsumptionL.multiply(distance)));
            return String.format("%s travelled %s km", this.getClass().getName(), formatter.format(distance));
        }
        return String.format("%s needs refueling", this.getClass().getName());
    }

    protected void refueling(BigDecimal refuelL){
            this.setFuelQuantity(this.fuelQuantity.add(refuelL));
    }

    private boolean validate(BigDecimal number){
        if(number.compareTo(BigDecimal.valueOf(0)) > 0){
            return true;
        }else{
            throw new IllegalArgumentException("Invalid input");
        }


    }
}
