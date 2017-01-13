package sn.sonatel.dsi.dif.qualys;

import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugin.MojoFailureException;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import sn.sonatel.dsi.dif.qualys.mojo.AbstractQualysMojo;
import sn.sonatel.dsi.dif.qualys.mojo.QualysCheckMojo;
import sn.sonatel.dsi.dif.qualys.mojo.QualysScanMojo;
import sn.sonatel.dsi.dif.qualys.xml.response.ServiceResponse;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.File;

/**
 * Created by ext_sow18 on 10/01/2017.
 */
public class QualysCheckMojoTest {


    AbstractQualysMojo checkMojo = new QualysCheckMojo();

    @Before
    public void init(){
        checkMojo.setUrl("https://qualysapi.qualys.com/");
        checkMojo.setAppId(107674200);
        //checkMojo.setPassword("opHi40snev");
        //checkMojo.setUsername("range_bs");
        checkMojo.setSkip(false);
    }


    @Test
    public void checkScan() throws MojoFailureException, MojoExecutionException {
        //checkMojo.execute();
    }

    @Test
    public void check_unmarchall_scan_summary() throws JAXBException {
        JAXBContext jc = JAXBContext.newInstance(ServiceResponse.class);

        Unmarshaller unmarshaller = jc.createUnmarshaller();
        File xml = new File("src/test/java/sn/sonatel/dsi/dif/qualys/check_scan_by_id.xml");
        ServiceResponse response = (ServiceResponse) unmarshaller.unmarshal(xml);
        Assert.assertNotNull(response.getData().getWasScan().getSummary());

        System.out.println("Valeur count recuperée : "+ response.getCount());
        System.out.println("Valeur count response code : "+ response.getResponseCode());
        System.out.println("Valeur RESULT STATUS  : "+ response.getData().getWasScan().getSummary().getResultsStatus());

        Assert.assertEquals(response.getData().getWasScan().getSummary().getResultsStatus(), "SUCCESSFUL");
    }
}
