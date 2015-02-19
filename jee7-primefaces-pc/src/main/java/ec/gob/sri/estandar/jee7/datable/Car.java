package ec.gob.sri.estandar.jee7.datable;

public class Car {
	
	private String id;
	private String model;
    private int year;
    private String manufacturer;
    private String color;
    
    public Car(String model, int year, String manufacturer, String color) {
            this.model = model;
            this.year = year;
            this.manufacturer = manufacturer;
            this.color = color;
    }

    public Car(String randomId, String randomBrand, int randomYear,
			String randomColor, int randomPrice, boolean randomSoldState) {
		this.id=randomId;
		this.model=randomBrand;
		this.year=randomYear;
		this.color=randomColor;
	}

	public String getModel() {
            return model;
    }

    public void setModel(String model) {
            this.model = model;
    }

    public int getYear() {
            return year;
    }

    public void setYear(int year) {
            this.year = year;
    }

    public String getManufacturer() {
            return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
            this.manufacturer = manufacturer;
    }

    public String getColor() {
            return color;
    }

    public void setColor(String color) {
            this.color = color;
    }

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
}
