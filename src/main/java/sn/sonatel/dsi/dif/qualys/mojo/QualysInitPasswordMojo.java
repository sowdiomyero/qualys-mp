package sn.sonatel.dsi.dif.qualys.mojo;

import com.sun.jersey.api.client.WebResource;
import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugin.MojoFailureException;
import org.apache.maven.plugins.annotations.Mojo;
import org.apache.maven.plugins.annotations.Parameter;
import sn.sonatel.dsi.dif.qualys.QualysAuthApi;

import java.io.IOException;
import java.io.OutputStream;
import java.util.prefs.BackingStoreException;
import java.util.prefs.NodeChangeListener;
import java.util.prefs.PreferenceChangeListener;
import java.util.prefs.Preferences;

/**
 * Created by ext_sow18 on 05/01/2017.
 */

/**
 *
 * Un goal pour lancer un scan Qualys.
 *
 */
@Mojo( name = "init")
public class QualysInitPasswordMojo extends AbstractMojo {

    @Parameter( property = "qualys.username", required = true)
    protected String username;

    @Parameter( property = "qualys.password", required = true)
    protected String password;

    public void execute() throws MojoExecutionException, MojoFailureException{

        try{
            getLog().info("Demande d'initialisation du user "+username+" et du mot de passe : "+ password);
            if(username==null || password ==null){
                getLog().error("Vous devez initialiser le mot de passe et le user Qualys avant toute utilisation");
                throw new MojoExecutionException("Aucun User et Mot de Passe n'ont été initialisé/ Executez mvn qualys:init avec les bons parametres");
            }
            QualysAuthApi.setCredentials(username, password);

        }catch (Exception e) {
            throw new MojoExecutionException("Une Exception s'est produite pendant l'execution du Goal SCAN ", e);
        }
    }

    public String getBaseResourceUrl() {
        return "";
    }
}
