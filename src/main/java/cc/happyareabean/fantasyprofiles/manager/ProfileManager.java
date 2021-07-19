package cc.happyareabean.fantasyprofiles.manager;

import cc.happyareabean.fantasyprofiles.FantasyProfiles;
import cc.happyareabean.fantasyprofiles.enums.ScoreBoardKitPVP;
import cc.happyareabean.fantasyprofiles.utils.AsyncUtils;
import org.bson.Document;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import java.util.UUID;

public class ProfileManager {

	private FantasyProfiles plugin = FantasyProfiles.getInstance();
	private ScoreBoardKitPVP scoreboardKitPVP;
	private Boolean joinAnnounce;

	public ProfileManager(Player player) {
		UUID playerUUID = player.getUniqueId();
		if (getProfile(playerUUID)) {
			this.scoreboardKitPVP = getScoreboardKitPVPDoc(playerUUID);
			this.joinAnnounce = getProfileDocument(playerUUID).getBoolean("joinannounce");
			plugin.debugLog(player.getName() + ": " + this.scoreboardKitPVP + " & " + this.joinAnnounce);
		} else {
			this.scoreboardKitPVP = ScoreBoardKitPVP.ALL;
			this.joinAnnounce = true;
			handleProfileCreation(player);
		}
	}

	public boolean getProfile(UUID uuid) {
		Document document = FantasyProfiles.getInstance().getMongoDB().getServerCollection().find(new Document("uuid", uuid.toString())).first();
		if (document != null) {
			return true;
		} else {
			return false;
		}
	}

	public Document getProfileDocument(UUID uuid) {
		Document document = FantasyProfiles.getInstance().getMongoDB().getServerCollection().find(new Document("uuid", uuid.toString())).first();
		if (document != null) {
			return document;
		} else {
			return null;
		}
	}

	public void handleProfileCreation(Player player) {
		Document playerDoc = new Document();
		playerDoc.put("uuid", player.getUniqueId().toString());
		playerDoc.put("name", player.getName());
		playerDoc.put("scoreboardkitpvp", getScoreboardKitPVPString());
		playerDoc.put("joinannounce", joinAnnounce);
		AsyncUtils.runAsync(() -> plugin.getMongoDB().getServerCollection().insertOne(playerDoc));
	}

	public String getScoreboardKitPVPString() {
		switch (this.scoreboardKitPVP) {
			case ALL:
				return "ALL";
			case ONLY_MAIN:
				return "ONLY_MAIN";
			case OFF:
				return "OFF";
		}
		return null;
	}

	public ScoreBoardKitPVP getScoreboardKitPVPDoc(UUID uuid) {
		switch (getProfileDocument(uuid).getString("scoreboardkitpvp")) {
			case "ALL":
				return ScoreBoardKitPVP.ALL;
			case "ONLY_MAIN":
				return ScoreBoardKitPVP.ONLY_MAIN;
			case "OFF":
				return ScoreBoardKitPVP.OFF;
		}
		return null;
	}
}
