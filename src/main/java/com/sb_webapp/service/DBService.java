package com.sb_webapp.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class DBService {
    private static final Logger log = LoggerFactory.getLogger(DBService.class);

    public void updateVisits(String IP){
        int visits = 0;
        int visitsFromIP = 0;

        try{
            //visits = db.getSiteVisits();
            visits++;
            //db.setSiteVisits(visits);

            //int visitsFromIP = db.getVisitsByIP(IP);
            visitsFromIP++;
            //db.setVisitsForIP(IP, visitsFromIP);
        }catch(Exception e){
            log.error(e.getMessage());
        }
    }

    public void saveMessage(String ip, String name, String msg){
        Date date = new Date();
        //db.saveMessage(ip, name, msg, port, date);
    }


}
