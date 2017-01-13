package sn.sonatel.dsi.dif.qualys.xml.response;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

/**
 * Created by ext_sow18 on 12/01/2017.
 */
@XmlAccessorType(XmlAccessType.FIELD)
public class SummaryElement {

    @XmlElement(name = "resultsStatus")
    private String resultsStatus;
    @XmlElement(name = "authStatus")
    private String authStatus;
    @XmlElement(name = "testDuration")
    private String testDuration;

    public String getResultsStatus() {
        return resultsStatus;
    }

    public void setResultsStatus(String resultsStatus) {
        this.resultsStatus = resultsStatus;
    }

    public String getAuthStatus() {
        return authStatus;
    }

    public void setAuthStatus(String authStatus) {
        this.authStatus = authStatus;
    }

    public String getTestDuration() {
        return testDuration;
    }

    public void setTestDuration(String testDuration) {
        this.testDuration = testDuration;
    }
}
