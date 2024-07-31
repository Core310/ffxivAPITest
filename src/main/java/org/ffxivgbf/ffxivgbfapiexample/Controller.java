package org.ffxivgbf.ffxivgbfapiexample;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import ffxivWikiFinder.ListFinder;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/")
public class Controller {
    /**
     * @param requestedItem String format item searching for
     * @return json format in java map style.
     */
    @GetMapping("/singleItem/{requestedItem}")
    public ResponseEntity<Object> requestItem(@PathVariable String requestedItem) throws JsonProcessingException {
        ListFinder.addItem(requestedItem);
        String json = new ObjectMapper().writeValueAsString(ListFinder.formatGroupedZones());
        ListFinder.clearQueries();
        return ResponseEntity.ok(json);
    }
    @GetMapping("/addItem/{requestedItem}")
    public void addItemQuery(@PathVariable String requestedItem) {
        ListFinder.addItem(requestedItem);
    }

    @GetMapping("/displayItemQueries")
    public ResponseEntity<String> displayQuery() throws JsonProcessingException {
        String json = new ObjectMapper().writeValueAsString(ListFinder.outPut());
        return ResponseEntity.ok(json);
    }
    }