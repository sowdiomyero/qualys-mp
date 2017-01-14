package sn.sonatel.dsi.dif.qualys.mojo;

import com.sun.jersey.api.client.WebResource;
import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugin.MojoFailureException;
import org.apache.maven.plugins.annotations.Mojo;

/**
 * Created by sowdiomyero on 05/01/2017.
 */

/**
 *
 * Un goal pour lancer un scan Qualys.
 *
 */
@Mojo( name = "report")
public class QualysReportMojo extends AbstractQualysMojo {


    @Override
    public void handle(WebResource.Builder builder) throws MojoExecutionException, MojoFailureException{

        try{
            getLog().info("Demande de scan reçu avec les parametres suivants : URL [ "+url+" ] , USERNAME : [ "+getUsername()+" ]");

        }catch (Exception e) {
            throw new MojoExecutionException("Une Exception s'est produite pendant l'execution du Goal SCAN ", e);
        }
    }

    @Override
    public String getBaseResourceUrl() {
        return "";
    }
}
