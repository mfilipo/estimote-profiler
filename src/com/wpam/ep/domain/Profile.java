package com.wpam.ep.domain;

import com.j256.ormlite.dao.ForeignCollection;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.field.ForeignCollectionField;
import com.j256.ormlite.table.DatabaseTable;
import com.wpam.ep.utils.constants.StreamType;

/**
 * Project: Estimote Profiler
 * User: Mateusz Filipowicz
 * Date: 2014-11-06
 * Time: 13:32
 */
@DatabaseTable(tableName = "ep_profile")
public class Profile {

    public static final String ID_COLUMN = "profile_id";

    @DatabaseField(
            generatedId = true,
            columnName = ID_COLUMN
    )
    private Integer id;

    @DatabaseField(
            columnName = "beacon_name",
            canBeNull = false
    )
    private String name;

    @DatabaseField(
            columnName = "beacon_used_flag",
            canBeNull = false
    )
    private boolean isUsed;

    @DatabaseField(
            columnName = "beacon_vibrate_flag",
            canBeNull = false
    )
    private boolean useVibrate;

    @DatabaseField(
            columnName = "beacon_turn_music_flag",
            canBeNull = false
    )
    private boolean turnOffMusicOnActivation;

    private boolean isVisible;

    @ForeignCollectionField(eager = false)
    private ForeignCollection<Beacon> beacons;

    @ForeignCollectionField(eager = true)
    private ForeignCollection<StreamProperties> properties;

    private Integer alarmStreamProperty;
    private Integer musicStreamProperty;
    private Integer ringStreamProperty;
    private Integer systemStreamProperty;
    private Integer voiceCallStreamProperty;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isUsed() {
        return isUsed;
    }

    public void setUsed(boolean isUsed) {
        this.isUsed = isUsed;
    }

    public boolean isUseVibrate() {
        return useVibrate;
    }

    public void setUseVibrate(boolean useVibrate) {
        this.useVibrate = useVibrate;
    }

    public boolean isTurnOffMusicOnActivation() {
        return turnOffMusicOnActivation;
    }

    public void setTurnOffMusicOnActivation(boolean turnOffMusicOnActivation) {
        this.turnOffMusicOnActivation = turnOffMusicOnActivation;
    }

    public boolean isVisible() {
        return isVisible;
    }

    public void setVisible(boolean isVisible) {
        this.isVisible = isVisible;
    }

    public ForeignCollection<Beacon> getBeacons() {
        return beacons;
    }

    public void setBeacons(ForeignCollection<Beacon> beacons) {
        this.beacons = beacons;
    }

    public ForeignCollection<StreamProperties> getProperties() {
        return properties;
    }

    public void setProperties(ForeignCollection<StreamProperties> properties) {
        this.properties = properties;
    }

    public int getStreamProperty(StreamType streamType) {
        if (properties != null) {
            for (StreamProperties property : properties) {
                if (property.getStreamType() == streamType) {
                    return property.getVolume();
                }
            }
        }
        return 0;
    }

    public int getAlarmStreamProperty() {
        if (alarmStreamProperty == null) {
            alarmStreamProperty = getStreamProperty(StreamType.ALARM);
        }
        return alarmStreamProperty;
    }

    public int getMusicStreamProperty() {
        if (musicStreamProperty == null) {
            musicStreamProperty = getStreamProperty(StreamType.MEDIA);
        }
        return musicStreamProperty;
    }

    public int getRingStreamProperty() {
        if (ringStreamProperty == null) {
            ringStreamProperty = getStreamProperty(StreamType.RING);
        }
        return ringStreamProperty;
    }

    public int getSystemStreamProperty() {
        if (systemStreamProperty == null) {
            systemStreamProperty = getStreamProperty(StreamType.SYSTEM);
        }
        return systemStreamProperty;
    }

    public int getVoiceCallStreamProperty() {
        if (voiceCallStreamProperty == null) {
            voiceCallStreamProperty = getStreamProperty(StreamType.VOICE_CALL);
        }
        return voiceCallStreamProperty;
    }
}
