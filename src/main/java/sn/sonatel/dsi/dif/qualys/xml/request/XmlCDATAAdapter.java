package sn.sonatel.dsi.dif.qualys.xml.request;

import javax.xml.bind.annotation.adapters.XmlAdapter;

/**
 * Created by ext_sow18 on 10/01/2017.
 */
public class XmlCDATAAdapter extends XmlAdapter<String, String> {

    @Override
    public String marshal(String value) throws Exception {
        return "<![CDATA[" + value + "]]>";
    }

    @Override
    public String unmarshal(String value) throws Exception {
        return value;
    }

}
