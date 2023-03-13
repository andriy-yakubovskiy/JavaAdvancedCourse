package task07_02;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "addresses")
public class Addresses {
    @XmlElement
    private City city;
    @XmlElement
    private String street;
    @XmlElement
    private int house;

    public Addresses() {
    }

    public Addresses(String city, String citySize, String street, int house) {
        this.city = new City(city, citySize);
        this.street = street;
        this.house = house;
    }
}