import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

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
