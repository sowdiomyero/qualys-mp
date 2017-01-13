package sn.sonatel.dsi.dif.qualys;

import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugin.MojoFailureException;
import org.junit.Before;
import org.junit.Test;
import sn.sonatel.dsi.dif.qualys.mojo.AbstractQualysMojo;
import sn.sonatel.dsi.dif.qualys.mojo.QualysCheckMojo;

/**
 * Created by sowdiomyero on 10/01/2017.
 */
public class QualysCheckWebAppTest {

    AbstractQualysMojo checkMojo = new QualysCheckMojo();

    @Before
    public void init(){
        checkMojo.setUrl("https://qualysapi.qualys.com/");
        checkMojo.setAppId(107674200);
        checkMojo.setSkip(false);
    }
    @Test
    public void checkWebApp() throws MojoFailureException, MojoExecutionException {
        //checkMojo.execute();
    }
}
