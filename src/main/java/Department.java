import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "department")
@XmlAccessorType(XmlAccessType.FIELD)
public class Department extends Staff {
    @XmlElement
    private String fullTitle; //полное наименование
    @XmlElement
    private String shortTitle; //краткое наименование
    @XmlElement
    private String director; //директор
    @XmlElement
    private String contactTlf; //телефон
}
