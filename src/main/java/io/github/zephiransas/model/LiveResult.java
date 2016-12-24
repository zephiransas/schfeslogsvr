package io.github.zephiransas.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "live_results")
public class LiveResult {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "song_id")
    private int songId;

    @Column(name = "song_name")
    private String songName;

    private int score;

    @Column(name = "max_combo")
    private int maxCombo;

    private int prefect;

    private int great;

    private int good;

    private int bad;

    private int miss;

    @Column(name = "created_at", insertable = false, updatable = false)
    private Date createdAt;

}
