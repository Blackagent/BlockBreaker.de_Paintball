package de.blockbreaker.paintball.api;

import de.blockbreaker.paintball.Paintball;
import org.bukkit.entity.Player;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;

/**
 * Created by Lukas on 20.06.2015.
 */
public class PlayerAPI {

    public void connectLobby(Player p) {
        try {
            ByteArrayOutputStream b = new ByteArrayOutputStream();
            DataOutputStream out = new DataOutputStream(b);

            out.writeUTF("Connect");
            out.writeUTF("lobby");

            p.sendPluginMessage(Paintball.getInstance(), "BungeeCord", b.toByteArray());
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
