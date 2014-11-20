package com.wpam.ep.utils.constants;

import android.media.AudioManager;

/**
 * Project: Estimote Profiler
 * User: Mateusz Filipowicz
 * Date: 2014-11-06
 * Time: 13:49
 */
public enum StreamType {

    ALARM(AudioManager.STREAM_ALARM),
    MEDIA(AudioManager.STREAM_MUSIC, AudioManager.STREAM_NOTIFICATION),
    RING(AudioManager.STREAM_RING),
    SYSTEM(AudioManager.STREAM_SYSTEM),
    VOICE_CALL(AudioManager.STREAM_VOICE_CALL)
    ;

    private int[] streamIds;
    private StreamType(int... pStreamIds) {
        streamIds = new int[pStreamIds.length];
        for (int i = 0; i < pStreamIds.length; i++) {
            streamIds[i] = pStreamIds[i];
        }
    }

    public int[] getStreams() {
        return streamIds;
    }

    public boolean contains(String value) {
        for (StreamType streamType : values()) {
            if (value.equals(streamType.name())) {
                return true;
            }
        }
        return false;
    }
}
