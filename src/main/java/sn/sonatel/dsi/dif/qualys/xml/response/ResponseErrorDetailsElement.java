package sn.sonatel.dsi.dif.qualys.xml.response;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

/**
 * Created by ext_sow18 on 11/01/2017.
 */
@XmlAccessorType(XmlAccessType.FIELD)
public class ResponseErrorDetailsElement {

    @XmlElement(name = "errorMessage")
    private String errorMessage;
    @XmlElement(name = "errorResolution")
    private String errorResolution;

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getErrorResolution() {
        return errorResolution;
    }

    public void setErrorResolution(String errorResolution) {
        this.errorResolution = errorResolution;
    }
}
