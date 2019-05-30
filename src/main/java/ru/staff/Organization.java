package ru.staff;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/** Класс служит для хранения объектов со свойствами
 <b>fullTitle</b>, <b>shortTitle</b>, <b>director</b>, <b>contactTlf</b> **/
@XmlRootElement(name = "organization")
@XmlAccessorType(XmlAccessType.FIELD)
public class Organization extends Staff {
    /** Поле полное наименование*/
    @XmlElement
    String fullTitle; //полное наименование
    @XmlElement
    /** Поле краткое наименование*/
    String shortTitle; //краткое наименование
    /** Поле директор*/
    @XmlElement
    String director; //директор
    /** Поле телефон*/
    @XmlElement
    String contactTlf; //телефон

    @Override
    public String toString() {
        return "orgID=" + id + ", fullTitle=" + fullTitle +", shortTitle="+shortTitle+", director="+director+", contactTlf="+contactTlf;
    }
}
