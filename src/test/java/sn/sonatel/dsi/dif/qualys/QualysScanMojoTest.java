package sn.sonatel.dsi.dif.qualys;

import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugin.MojoFailureException;
import org.junit.Before;
import org.junit.Test;
import sn.sonatel.dsi.dif.qualys.mojo.AbstractQualysMojo;
import sn.sonatel.dsi.dif.qualys.mojo.QualysScanMojo;

/**
 * Created by ext_sow18 on 10/01/2017.
 */
public class QualysScanMojoTest {

    AbstractQualysMojo scanMojo = new QualysScanMojo();

    @Before
    public void init(){
        scanMojo.setUrl("https://qualysapi.qualys.com/");
        scanMojo.setAppId(107674200);
        //scanMojo.setPassword("opHi40snev");
        //scanMojo.setUsername("range_bs");
        scanMojo.setSkip(false);
    }

    @Test
    public void launchScan(){
        try {
            scanMojo.execute();
        } catch (MojoExecutionException e) {
            e.printStackTrace();
        } catch (MojoFailureException e) {
            e.printStackTrace();
        }
    }
}
