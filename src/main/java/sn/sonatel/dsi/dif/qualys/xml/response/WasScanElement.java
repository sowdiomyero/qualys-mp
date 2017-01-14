package sn.sonatel.dsi.dif.qualys.xml.response;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

/**
 * Created by sowdiomyero on 10/01/2017.
 */
@XmlAccessorType(XmlAccessType.FIELD)
public class WasScanElement {

    @XmlElement(name = "id")
    private Integer id;
    //@XmlJavaTypeAdapter(XmlCDATAAdapter.class)
    @XmlElement(name = "name")
    private String name;
    @XmlElement(name = "type")
    private String type;
    @XmlElement(name = "target")
    private TargetElement target;

    @XmlElement(name = "status")
    private String status;
    @XmlElement(name = "summary")
    private SummaryElement summary;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public TargetElement getTarget() {
        return target;
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setTarget(TargetElement target) {
        this.target = target;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public SummaryElement getSummary() {
        return summary;
    }

    public void setSummary(SummaryElement summary) {
        this.summary = summary;
    }
}
