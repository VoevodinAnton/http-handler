package com.example.httphandler.api;

import com.example.httphandler.model.Site;
import com.example.httphandler.model.URLEntity;
import com.example.httphandler.service.SiteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RequestMapping("api/v1/url")
@RestController
public class HTTPHandlerController {
    private final SiteService siteService;

    @Autowired
    public HTTPHandlerController(SiteService siteService) {
        this.siteService = siteService;
    }


    @PostMapping
    public void createSite(@RequestBody URLEntity urlEntity){
        siteService.createSite(urlEntity);
    }

    @GetMapping
    public Site getSite(){
        return siteService.getSite();
    }
}
