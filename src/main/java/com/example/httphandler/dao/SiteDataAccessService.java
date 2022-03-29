package com.example.httphandler.dao;

import com.example.httphandler.model.Site;
import com.example.httphandler.model.URLEntity;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("dao")
public class SiteDataAccessService implements SiteDao{
    private static Site site;
    @Override
    public int createSite(URLEntity urlEntity, String serverInformation, List<String> linkTree) {
        site = new Site(urlEntity, serverInformation, linkTree);
        return 1;
    }

    @Override
    public Site getSite() {
        return site;
    }
}
