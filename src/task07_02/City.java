package task07_02;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlValue;

public class City {
    @XmlValue
    private String nameCity;
    @XmlAttribute
    private String citySize;

    public City() {
    }

    public City(String nameCity, String citySize) {
        this.nameCity = nameCity;
        this.citySize = citySize;
    }

    public String getnameCity() {
        return nameCity;
    }

//    @XmlAttribute
//    public String getcitySize() {
//        return citySize;
//    }

}