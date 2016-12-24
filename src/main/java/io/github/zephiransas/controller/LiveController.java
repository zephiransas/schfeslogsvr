package io.github.zephiransas.controller;

import io.github.zephiransas.LiveResultBean;
import io.github.zephiransas.model.LiveResult;
import io.github.zephiransas.repository.LiveResultRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("live")
public class LiveController {

    @Autowired
    LiveResultRepository repository;

    @RequestMapping(value = "result", method = RequestMethod.POST, consumes = "application/json")
    public void result(@RequestBody LiveResultBean result) {
        System.out.println(result.toString());

        LiveResult liveResult = LiveResult.builder()
                .songId(result.getSongId())
                .songName(result.getSongName())
                .score(result.getScore())
                .maxCombo(result.getMaxCombo())
                .prefect(result.getPrefect())
                .great(result.getGreat())
                .good(result.getGood())
                .bad(result.getBad())
                .miss(result.getMiss())
                .build();

        repository.save(liveResult);
    }
}
