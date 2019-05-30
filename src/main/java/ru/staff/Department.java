package ru.staff;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/** Класс служит для хранения объектов со свойствами
 <b>fullTitle</b>, <b>shortTitle</b>, <b>director</b>, <b>contactTlf</b> **/
@XmlRootElement(name = "department")
@XmlAccessorType(XmlAccessType.FIELD)
public class Department extends Staff {
    @XmlElement
    /** Поле полное наименование*/
    private String fullTitle;
    @XmlElement
    /** Поле краткое наименование*/
    private String shortTitle;
    @XmlElement
    /** Поле директор*/
    private String director;
    @XmlElement
    /** Поле телефон*/
    private String contactTlf;
}
