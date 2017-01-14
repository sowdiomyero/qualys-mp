package sn.sonatel.dsi.dif.qualys;

import javax.ws.rs.client.WebTarget;
import java.util.Map;
import java.util.prefs.Preferences;

/**
 * Created by sowdiomyero on 06/01/2017.
 */
public class QualysAuthApi {

    static Preferences preferences = Preferences.userRoot().node("sn/sonatel/dsi/dif/qualys/mojo");

    public static void setCredentials(final String username, final String password) {

        preferences.put("qualys_username", EncryptorUtils.encrypt(username));
        preferences.put("qualys_password", EncryptorUtils.encrypt(password));
    }

    public static String getUsername() {
        return preferences.get("qualys_username", null);
    }

    public static String getPassword() {
        String password =preferences.get("qualys_password", null);
        if(password != null )
            return password = EncryptorUtils.decrypt(password);

        return password;
    }


}
