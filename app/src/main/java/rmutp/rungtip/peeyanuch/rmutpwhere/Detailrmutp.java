package rmutp.rungtip.peeyanuch.rmutpwhere;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by WINDOWS on 7/3/2560.
 */

public class Detailrmutp {
    private String title;
    private String description;
    private int resID;
    private List<Detailrmutp> detailrmutpList = new ArrayList<>();


    Detailrmutp(int resID,String title,String description){
        this.resID = resID;
        this.title = title;
        this.description = description;

    }


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getResID() {
        return resID;
    }

    public void setResID(int resID) {
        this.resID = resID;
    }

    public List<Detailrmutp> getDetailrmutpList() {
        return detailrmutpList;
    }

    public void setDetailrmutpList(List<Detailrmutp> detailrmutpList) {
        this.detailrmutpList = detailrmutpList;
    }
}



