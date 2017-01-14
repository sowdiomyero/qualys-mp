package sn.sonatel.dsi.dif.qualys.xml.response;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

/**
 * Created by sowdiomyero on 10/01/2017.
 */
@XmlAccessorType(XmlAccessType.FIELD)
public class WebAppElement {

    @XmlElement(name = "id")
    private int id;
    @XmlElement(name = "name")
    private String name;
    @XmlElement(name = "url")
    private String url;
    @XmlElement(name = "lastScan")
    private GenericIdNameElement lastScan;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public GenericIdNameElement getLastScan() {
        return lastScan;
    }

    public void setLastScan(GenericIdNameElement lastScan) {
        this.lastScan = lastScan;
    }
}
