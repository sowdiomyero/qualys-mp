package sn.sonatel.dsi.dif.qualys.xml.response;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by ext_sow18 on 10/01/2017.
 */
@XmlRootElement(name = "ServiceResponse")
@XmlAccessorType(XmlAccessType.FIELD)
public class ServiceResponse {

    @XmlElement(name = "count")
    private int count;
    @XmlElement(name = "responseCode")
    private String responseCode;
    @XmlElement(name = "responseErrorDetails")
    private ResponseErrorDetailsElement responseErrorDetails;
    @XmlElement(name = "data")
    private DataElement data;


    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public String getResponseCode() {
        return responseCode;
    }

    public void setResponseCode(String responseCode) {
        this.responseCode = responseCode;
    }

    public DataElement getData() {
        return data;
    }

    public ResponseErrorDetailsElement getResponseErrorDetails() {
        return responseErrorDetails;
    }

    public void setResponseErrorDetails(ResponseErrorDetailsElement responseErrorDetails) {
        this.responseErrorDetails = responseErrorDetails;
    }

    public void setData(DataElement data) {
        this.data = data;
    }
}
