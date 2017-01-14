package sn.sonatel.dsi.dif.qualys.xml.response;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

/**
 * Created by sowdiomyero on 10/01/2017.
 */
@XmlAccessorType(XmlAccessType.FIELD)
public class DataElement {

    @XmlElement(name = "WebApp")
    private WebAppElement webApp;

    @XmlElement(name = "WasScan")
    private WasScanElement wasScan;




    public WebAppElement getWebApp() {
        return webApp;
    }

    public void setWebApp(WebAppElement webApp) {
        this.webApp = webApp;
    }

    public WasScanElement getWasScan() {
        return wasScan;
    }



    public void setWasScan(WasScanElement wasScan) {
        this.wasScan = wasScan;
    }
}
