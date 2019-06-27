package nl.zwennesm.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/metrics")
public class VersionController {

    @Value("${flux.project.version}")
    private String version;
    
    @GetMapping(path = "/version")
    public String version() { return version; }
}
