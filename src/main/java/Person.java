import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "person")
@XmlAccessorType(XmlAccessType.FIELD)
public class Person extends Staff {
    @XmlElement
    private String firstname; //имя
    @XmlElement
    private String lastname; //фамилия
    @XmlElement
    private String patronymic; //отчество
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