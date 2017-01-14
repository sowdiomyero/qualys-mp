package sn.sonatel.dsi.dif.qualys.xml.response;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

/**
 * Created by sowdiomyero on 10/01/2017.
 */
@XmlAccessorType(XmlAccessType.FIELD)
public class TargetElement {

    @XmlElement(name = "webApp")
    private WebAppElement webApp;
    @XmlElement(name = "cancelOption")
    private String cancelOption = "DEFAULT";

    public TargetElement() {
    }

    public WebAppElement getWebApp() {
        return webApp;
    }

    public void setWebApp(WebAppElement webApp) {
        this.webApp = webApp;
    }

    public String getCancelOption() {
        return cancelOption;
    }

    public void setCancelOption(String cancelOption) {
        this.cancelOption = cancelOption;
    }
}
