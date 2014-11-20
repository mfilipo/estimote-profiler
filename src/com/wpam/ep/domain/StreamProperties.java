package com.wpam.ep.domain;

import com.j256.ormlite.field.DataType;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;
import com.wpam.ep.utils.constants.StreamType;

/**
 * Project: Estimote Profiler
 * User: Mateusz Filipowicz
 * Date: 2014-11-06
 * Time: 13:55
 */
@DatabaseTable(tableName = "ep_stream_prop")
public class StreamProperties {

    public static final String ID_COLUMN = "stream_prop_id";

    @DatabaseField(
            generatedId = true,
            columnName = ID_COLUMN
    )
    private Integer id;

    @DatabaseField(
            columnName = "stream_type",
            canBeNull = false,
            unique = true,
            dataType = DataType.ENUM_STRING
    )
    private StreamType streamType;

    @DatabaseField(
            columnName = "stream_volume",
            canBeNull = false
    )
    private int volume;

    @DatabaseField(
            foreign = true,
            columnName = Profile.ID_COLUMN,
            canBeNull = false,
            unique = true
    )
    private Profile profile;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public StreamType getStreamType() {
        return streamType;
    }

    public void setStreamType(StreamType streamType) {
        this.streamType = streamType;
    }

    public int getVolume() {
        return volume;
    }

    public void setVolume(int volume) {
        this.volume = volume;
    }

    public Profile getProfile() {
        return profile;
    }

    public void setProfile(Profile profile) {
        this.profile = profile;
    }
}
