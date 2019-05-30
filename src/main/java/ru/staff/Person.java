package ru.staff;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/** Класс служит для хранения объектов со свойствами
 <b>firstname</b>, <b>lastname</b>, <b>patronymic</b>, <b>post</b> **/
@XmlRootElement(name = "person")
@XmlAccessorType(XmlAccessType.FIELD)
public class Person extends Staff {
    /** Поле имя*/
    @XmlElement
    private String firstname; //имя
    /** Поле фамилия*/
    @XmlElement
    private String lastname; //фамилия
    /** Поле отчество*/
    @XmlElement
    private String patronymic; //отчество
    /** Поле должность*/
    @XmlElement
    private String post; //должность


    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public void setPost(String post) {
        this.post = post;
    }

    public String getPersonFirstName(){
        return firstname;
    }

    public String getPersonLastName(){
        return lastname;
    }

    @Override
    public String toString() {
        return "personID=" + id + ", firstname=" + firstname +", lastname="+lastname+", patronymic="+patronymic+", post="+post;
    }

}