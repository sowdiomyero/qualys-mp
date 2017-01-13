package sn.sonatel.dsi.dif.qualys.xml;

//import com.sun.xml.internal.bind.marshaller.CharacterEscapeHandler;
//import com.sun.xml.bind.marshaller.CharacterEscapeHandler;

import sn.sonatel.dsi.dif.qualys.xml.request.ServiceRequest;
import sn.sonatel.dsi.dif.qualys.xml.response.*;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.StringReader;
import java.io.StringWriter;
import java.nio.file.Paths;

/**
 * Created by ext_sow18 on 11/01/2017.
 */
public class JaxbSerializerUtils {

   /* public static File parseRequest(int webAppId) throws JAXBException {

        JAXBContext jc = JAXBContext.newInstance(ServiceRequest.class);

        Marshaller marshaller = jc.createMarshaller();

        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        marshaller.setProperty(Marshaller.JAXB_ENCODING, "UTF-8");
       *//* marshaller.setProperty("com.sun.xml.internal.bind.characterEscapeHandler",
                new CharacterEscapeHandler() {
                    public void escape(char[] ch, int start, int length,
                                       boolean isAttVal, Writer writer)
                            throws IOException {
                        writer.write(ch, start, length);
                    }
                });*//*

        ServiceRequest request = new ServiceRequest();
        DataElement data = new DataElement();
        TargetElement target = new TargetElement();
        WasScanElement wasScan = new WasScanElement();
        WebAppElement webApp = new WebAppElement();

        wasScan.setName("My Vulnerability Scan");
        wasScan.setType("VULNERABILITY");
        wasScan.setTarget(target);

        webApp.setId(webAppId);

        target.setWebApp(webApp);
        target.setCancelOption("DEFAULT");

        data.setWasScan(wasScan);
        request.setData(data);
        String path = Paths.get("").toAbsolutePath().toString();
        File file = new File(path + File.separator +"qualys_post_new_scan_request.xml");

        marshaller.marshal(request, file);
        //marshaller.marshal(request, System.out);

        return file;
    }*/

    public static String parseRequestToString(int webAppId) throws JAXBException {

        JAXBContext jc = JAXBContext.newInstance(ServiceRequest.class);

        Marshaller marshaller = jc.createMarshaller();

        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        marshaller.setProperty(Marshaller.JAXB_ENCODING, "UTF-8");
       /* marshaller.setProperty("com.sun.xml.internal.bind.characterEscapeHandler",
                new CharacterEscapeHandler() {
                    public void escape(char[] ch, int start, int length,
                                       boolean isAttVal, Writer writer)
                            throws IOException {
                        writer.write(ch, start, length);
                    }
                });*/
        ServiceRequest request = new ServiceRequest();
        DataElement data = new DataElement();
        TargetElement target = new TargetElement();
        WasScanElement wasScan = new WasScanElement();
        WebAppElement webApp = new WebAppElement();

        wasScan.setName("[IC] Continuous Vulnerability Scan");
        wasScan.setType("VULNERABILITY");
        wasScan.setTarget(target);

        webApp.setId(webAppId);

        target.setWebApp(webApp);
        target.setCancelOption("DEFAULT");

        data.setWasScan(wasScan);
        request.setData(data);
        String path = Paths.get("").toAbsolutePath().toString();
        StringWriter  response = new StringWriter();

        marshaller.marshal(request, response);

        return response.toString();
    }

    public static ServiceResponse parseResponse(String xmlResponse) throws JAXBException {

        JAXBContext jc = JAXBContext.newInstance(ServiceResponse.class);
        Unmarshaller unmarshaller = jc.createUnmarshaller();
        StringReader reader = new StringReader(xmlResponse);
        ServiceResponse response = (ServiceResponse) unmarshaller.unmarshal(reader);
        return  response;
    }
}
