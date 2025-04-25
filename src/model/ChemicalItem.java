package model;

import javafx.beans.property.SimpleStringProperty;

public class ChemicalItem {
    private final SimpleStringProperty name;
    private final SimpleStringProperty manufacturer;
    private final SimpleStringProperty unit;
    private final SimpleStringProperty quantity;
    private final SimpleStringProperty location;
    private final SimpleStringProperty hazard;
    private final SimpleStringProperty expiry;

    public ChemicalItem(String name, String manufacturer, String unit,
                        String quantity, String location, String hazard, String expiry) {
        this.name = new SimpleStringProperty(name);
        this.manufacturer = new SimpleStringProperty(manufacturer);
        this.unit = new SimpleStringProperty(unit);
        this.quantity = new SimpleStringProperty(quantity);
        this.location = new SimpleStringProperty(location);
        this.hazard = new SimpleStringProperty(hazard);
        this.expiry = new SimpleStringProperty(expiry);
    }

    public String getName() { return name.get(); }
    public String getManufacturer() { return manufacturer.get(); }
    public String getUnit() { return unit.get(); }
    public String getQuantity() { return quantity.get(); }
    public String getLocation() { return location.get(); }
    public String getHazard() { return hazard.get(); }
    public String getExpiry() { return expiry.get(); }
}
