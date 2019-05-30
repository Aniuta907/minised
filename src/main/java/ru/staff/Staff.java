package ru.staff;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public abstract class Staff {
    @XmlAttribute
    protected String id; //идентификатор

    public void setID(String id) {
        this.id = id;
    }

    public String getID() {
        return id;
    }

}
