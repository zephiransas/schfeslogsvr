package io.github.zephiransas.controller;


import com.fasterxml.jackson.databind.ObjectMapper;
import io.github.zephiransas.LiveResultBean;
import io.github.zephiransas.model.LiveResult;
import io.github.zephiransas.repository.LiveResultRepository;
import org.hamcrest.core.Is;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import javax.transaction.Transactional;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
@Transactional
public class LiveControllerTest {

    @Autowired
    private MockMvc mvc;

    @Autowired
    private LiveResultRepository repository;

    @Test
    public void test() throws Exception {
        ObjectMapper mapper = new ObjectMapper();

        LiveResultBean bean = LiveResultBean.builder()
                .songId(100)
                .songName("青空Jumping Heart")
                .score(12345)
                .maxCombo(123)
                .perfect(1)
                .great(2)
                .good(3)
                .bad(4)
                .miss(5)
                .build();

        MockHttpServletRequestBuilder request = MockMvcRequestBuilders
                .post("/live/result")
                .content(mapper.writeValueAsString(bean))
                .contentType(MediaType.APPLICATION_JSON);

        mvc.perform(request)
                .andExpect(status().isOk());

        LiveResult actual = repository.findAll().get(0);

        assertThat(actual.getSongId(), is(100));
        assertThat(actual.getSongName(), is("青空Jumping Heart"));
        assertThat(actual.getScore(), is(12345));
        assertThat(actual.getMaxCombo(), is(123));
        assertThat(actual.getPerfect(), is(1));
        assertThat(actual.getGreat(), is(2));
        assertThat(actual.getGood(), is(3));
        assertThat(actual.getBad(), is(4));
        assertThat(actual.getMiss(), is(5));
    }

}
