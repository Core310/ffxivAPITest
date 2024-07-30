package org.ffxivgbf.ffxivgbfapiexample;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import ffxivWikiFinder.ListFinder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/search")
public class Controller {
    /**
     * @param requestedItem String format item searching for
     * @return json format in java map style.
     */
    @GetMapping("/search/{requestedItem}")
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