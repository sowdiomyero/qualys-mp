package sn.sonatel.dsi.dif.qualys.mojo;

import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugin.MojoFailureException;
import org.apache.maven.plugins.annotations.Mojo;
import org.apache.maven.plugins.annotations.Parameter;
import sn.sonatel.dsi.dif.qualys.QualysAuthApi;

/**
 * Created by ext_sow18 on 05/01/2017.
 */

/**
 *
 * Un goal pour lancer un scan Qualys.
 *
 */
@Mojo( name = "show-password")
public class QualysShowPasswordMojo extends AbstractMojo {

    public void execute() throws MojoExecutionException, MojoFailureException{

        try{
            getLog().info(" ### Demande de visualisation du user et du mot de passe : \n");
            getLog().info(" ### Username : "+QualysAuthApi.getUsername());
            getLog().info(" ### Password : "+QualysAuthApi.getPassword());

        }catch (Exception e) {
            throw new MojoExecutionException("Une Exception s'est produite pendant l'execution du Goal SCAN ", e);
        }
    }

}
