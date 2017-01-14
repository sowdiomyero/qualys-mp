package sn.sonatel.dsi.dif.qualys;

import com.sun.istack.NotNull;
import com.sun.istack.Nullable;

import javax.ws.rs.client.WebTarget;
import java.util.Map;
import java.util.prefs.Preferences;

/**
 * Created by sowdiomyero on 06/01/2017.
 */
public class QualysAuthApi {

    static Preferences preferences = Preferences.userRoot().node("sn/sonatel/dsi/dif/qualys/mojo");


    public static void setCredentials(@NotNull final String username, @NotNull final String password) {

        preferences.put("qualys_username", EncryptorUtils.encrypt(username));
        preferences.put("qualys_password", EncryptorUtils.encrypt(password));
    }

    @Nullable
    public static String getUsername() {
        String username =preferences.get("qualys_username", null);
        if(username != null )
             username = EncryptorUtils.decrypt(username);
        return username;
    }

    @Nullable
    public static String getPassword() {
        String password =preferences.get("qualys_password", null);
        if(password != null )
            password = EncryptorUtils.decrypt(password);
        return password;
    }


}
