package net.catenax.explorer.core;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import net.catenax.explorer.core.submodel.twinregistry.SubmodelResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("v1/assets/")
@RequiredArgsConstructor
@Slf4j
public class ExplorerController {

  final ExplorerService explorerService;

  @GetMapping("{query}")
  public ResponseEntity<SubmodelResponse> retrieve(@PathVariable final String query) {
    log.info("Querying for Asset by PartNumber: " + query);
    return ResponseEntity.ok(explorerService.search(query));
  }
}