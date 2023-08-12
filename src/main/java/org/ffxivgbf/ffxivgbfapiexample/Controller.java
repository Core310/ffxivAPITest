package org.ffxivgbf.ffxivgbfapiexample;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import ffxivWikiFinder.ListFinder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")//TODO 12/8/2023
public class Controller {

    @GetMapping("/{requestedItem}")
    public ResponseEntity<Object> findById(@PathVariable String requestedItem) {
        try {
            ListFinder.addItem(requestedItem);
            String json = new ObjectMapper().writeValueAsString(ListFinder.formatGroupedZones());
            return ResponseEntity.ok(json);

        }
        catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
}