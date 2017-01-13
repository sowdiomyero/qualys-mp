package sn.sonatel.dsi.dif.qualys.xml.request;

import sn.sonatel.dsi.dif.qualys.xml.response.DataElement;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by ext_sow18 on 10/01/2017.
 */
@XmlRootElement(name = "ServiceRequest")
@XmlAccessorType(XmlAccessType.FIELD)
public class ServiceRequest {

    @XmlElement(name = "data")
    private DataElement data;

    public DataElement getData() {
        return data;
    }

    public void setData(DataElement data) {
        this.data = data;
    }
}
