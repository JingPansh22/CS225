package model;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class ChemicalEntry {

    private final SimpleStringProperty name;
    private final SimpleStringProperty manufacturer;
    private final SimpleStringProperty unit;
    private final SimpleIntegerProperty quantity;
    private final SimpleStringProperty location;
    private final SimpleStringProperty hazard;
    private final SimpleStringProperty expirationDate;

    public ChemicalEntry(String name, String manufacturer, String unit, int quantity, String location, String hazard, String expirationDate) {
        this.name = new SimpleStringProperty(name);
        this.manufacturer = new SimpleStringProperty(manufacturer);
        this.unit = new SimpleStringProperty(unit);
        this.quantity = new SimpleIntegerProperty(quantity);
        this.location = new SimpleStringProperty(location);
        this.hazard = new SimpleStringProperty(hazard);
        this.expirationDate = new SimpleStringProperty(expirationDate);
    }

    public String getName() { return name.get(); }
    public String getManufacturer() { return manufacturer.get(); }
    public String getUnit() { return unit.get(); }
    public int getQuantity() { return quantity.get(); }
    public String getLocation() { return location.get(); }
    public String getHazard() { return hazard.get(); }
    public String getExpirationDate() { return expirationDate.get(); }
}

