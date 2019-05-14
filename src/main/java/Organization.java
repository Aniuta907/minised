import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "organization")
@XmlAccessorType(XmlAccessType.FIELD)
public class Organization extends Staff {
    @XmlElement
    String fullTitle; //полное наименование
    @XmlElement
    String shortTitle; //краткое наименование
    @XmlElement
    String director; //директор
    @XmlElement
    String contactTlf; //телефон

    @Override
    public String toString() {
        return "orgID=" + id + ", fullTitle=" + fullTitle +", shortTitle="+shortTitle+", director="+director+", contactTlf="+contactTlf;
    }
}
