package io.github.zephiransas;


import lombok.Data;
import lombok.ToString;

import java.io.Serializable;

@Data
@ToString
public class LiveResultBean implements Serializable {

    private int songId;

    private String songName;

    private int score;

    private int maxCombo;

    private int perfect;

    private int great;

    private int good;

    private int bad;

    private int miss;

}
