package sn.sonatel.dsi.dif.qualys;

import org.junit.Assert;
import org.junit.Test;
import sn.sonatel.dsi.dif.qualys.xml.response.ServiceResponse;

import javax.xml.bind.*;
import java.io.File;

/**
 * Created by sowdiomyero on 10/01/2017.
 */
public class JaxbCheckScanParserTest {

    @Test
    public void check_unmarchall_scan() throws JAXBException {
        JAXBContext jc = JAXBContext.newInstance(ServiceResponse.class);

        Unmarshaller unmarshaller = jc.createUnmarshaller();
        File xml = new File("src/test/java/sn/sonatel/dsi/dif/qualys/get_webapp_last_scan_by_id.xml");
        ServiceResponse response = (ServiceResponse) unmarshaller.unmarshal(xml);

/*
        System.out.println("Valeur count recuperée : "+ response.getCount());
        System.out.println("Valeur count response code : "+ response.getResponseCode());
        System.out.println("Valeur webAppId  : "+ response.getData().getWebApp().getId());
        System.out.println("Valeur webApp Name  : "+ response.getData().getWebApp().getName());
*/

        Assert.assertEquals(response.getData().getWebApp().getId(), 107674200);
        Assert.assertEquals(response.getData().getWebApp().getName(), "DIF_IC_Obelix");
        Assert.assertNull(response.getData().getWasScan());
        Assert.assertEquals(response.getResponseCode(), "SUCCESS");
    }



    @Test
    public void check_marshall_scan_response() throws JAXBException {
        JAXBContext jc = JAXBContext.newInstance(ServiceResponse.class);
        Unmarshaller unmarshaller = jc.createUnmarshaller();
        Marshaller marshaller = jc.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

        //marshaller.marshal(response, System.out);
    }
}
