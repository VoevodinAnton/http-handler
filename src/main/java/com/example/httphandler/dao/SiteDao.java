package com.example.httphandler.dao;

import com.example.httphandler.model.Site;
import com.example.httphandler.model.URLEntity;

import java.util.List;

public interface SiteDao {
    int createSite(URLEntity urlEntity, String serverInformation, List<String> linkTree);

    Site getSite();
}
