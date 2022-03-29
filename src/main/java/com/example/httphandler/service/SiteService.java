package com.example.httphandler.service;

import com.example.httphandler.dao.SiteDao;
import com.example.httphandler.model.Site;
import com.example.httphandler.model.URLEntity;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Collections;
import java.util.List;

@Service
public class SiteService {
    private final SiteDao siteDao;

    @Autowired
    public SiteService(@Qualifier("dao") SiteDao siteDao) {
        this.siteDao = siteDao;
    }

    public int createSite(URLEntity urlEntity) {
        String serverInformation = getServerInformation(urlEntity);
        List<String> linkTree = getLinkTree(urlEntity);
        return siteDao.createSite(urlEntity, serverInformation, linkTree);
    }

    public Site getSite() {
        return siteDao.getSite();
    }

    private String getServerInformation(URLEntity urlEntity) {
        HttpURLConnection connection = getConnection(urlEntity);
        return connection.getHeaderField("Server");
    }

    private List<String> getLinkTree(URLEntity urlEntity){
        HttpURLConnection connection = getConnection(urlEntity);
        Document document = null;
        try {
            InputStream responseStream = connection.getInputStream();
            document = Jsoup.parse(responseStream, "UTF-8", urlEntity.getName());
        } catch (IOException ex){
            ex.printStackTrace();
        }
        Elements links = document.select("a[href]");
        return links.eachAttr("href");
    }

    private HttpURLConnection getConnection(URLEntity urlEntity) {
        HttpURLConnection connection = null;
        try {
            URL obj = new URL(urlEntity.getName());
            connection = (HttpURLConnection) obj.openConnection();

            connection.setRequestMethod("GET");
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return connection;
    }
}
