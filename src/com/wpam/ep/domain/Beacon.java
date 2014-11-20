package com.wpam.ep.domain;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

/**
 * Project: Estimote Profiler
 * User: Mateusz Filipowicz
 * Date: 2014-11-06
 * Time: 13:32
 */
@DatabaseTable(tableName = "ep_beacon")
public class Beacon {

    public static final String ID_COLUMN = "beacon_id";

    @DatabaseField(
            generatedId = true,
            columnName = ID_COLUMN
    )
    private Integer id;

    @DatabaseField(
            columnName = "beacon_uuid",
            canBeNull = false
    )
    private String uuid;

    @DatabaseField(
            columnName = "beacon_name",
            canBeNull = true
    )
    private String name;

    @DatabaseField(
            foreign = true,
            columnName = Profile.ID_COLUMN,
            canBeNull = true
    )
    private Profile profile;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Profile getProfile() {
        return profile;
    }

    public void setProfile(Profile profile) {
        this.profile = profile;
    }
}
