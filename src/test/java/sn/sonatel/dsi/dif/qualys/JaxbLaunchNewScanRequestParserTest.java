package sn.sonatel.dsi.dif.qualys;

//import com.sun.xml.internal.bind.marshaller.CharacterEscapeHandler;
import org.junit.Assert;
import org.junit.Test;
import sn.sonatel.dsi.dif.qualys.xml.request.ServiceRequest;
import sn.sonatel.dsi.dif.qualys.xml.response.*;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.io.IOException;
import java.io.Writer;
import java.nio.file.Paths;

/**
 * Created by sowdiomyero on 10/01/2017.
 */
public class JaxbLaunchNewScanRequestParserTest {

    @Test
    public void generate_marshall_scan_request() throws JAXBException {

        JAXBContext jc = JAXBContext.newInstance(ServiceRequest.class);

        Marshaller marshaller = jc.createMarshaller();

        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        marshaller.setProperty(Marshaller.JAXB_ENCODING, "UTF-8");

        ServiceRequest request = new ServiceRequest();
        DataElement data = new DataElement();
        TargetElement target = new TargetElement();
        WasScanElement wasScan = new WasScanElement();
        WebAppElement webApp = new WebAppElement();

        wasScan.setName("My Vulnerability Scan");
        wasScan.setType("VULNERABILITY");
        wasScan.setTarget(target);

        webApp.setId(107674200);

        target.setWebApp(webApp);
        target.setCancelOption("DEFAULT");

        data.setWasScan(wasScan);
        request.setData(data);
        String path = Paths.get("").toAbsolutePath().toString();
        File file = new File(path + File.separator + "qualys_post_new_scan_request.xml");

        marshaller.marshal(request, file);
        marshaller.marshal(request, System.out);

    }
}
