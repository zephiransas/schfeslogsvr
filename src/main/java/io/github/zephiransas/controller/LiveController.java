package io.github.zephiransas.controller;

import io.github.zephiransas.LiveResultBean;
import io.github.zephiransas.model.LiveResult;
import io.github.zephiransas.repository.LiveResultRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;

@RestController
@RequestMapping("live")
public class LiveController {

    @Autowired
    LiveResultRepository repository;

    @Value("${password}")
    String password;

    @RequestMapping(value = "result", method = RequestMethod.POST, consumes = "application/json")
    public void result(@RequestBody LiveResultBean result) throws PasswordUnmatchException {
        if(!Objects.equals(password, result.getPassword())) throw new PasswordUnmatchException();

        LiveResult liveResult = LiveResult.builder()
                .songId(result.getSongId())
                .songName(result.getSongName())
                .score(result.getScore())
                .maxCombo(result.getMaxCombo())
                .perfect(result.getPerfect())
                .great(result.getGreat())
                .good(result.getGood())
                .bad(result.getBad())
                .miss(result.getMiss())
                .build();

        repository.save(liveResult);
    }


    @ExceptionHandler(PasswordUnmatchException.class)
    @ResponseStatus(code = HttpStatus.FORBIDDEN)
    public void errorHandler() {}

    class PasswordUnmatchException extends Exception {}
}
