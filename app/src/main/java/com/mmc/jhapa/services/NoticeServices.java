package com.mmc.jhapa.services;

import androidx.annotation.NonNull;

import com.mmc.jhapa.classes.models.adapters.NoticeModel;

import java.util.ArrayList;
import java.util.List;

public class NoticeServices {
    @NonNull
    public static List<NoticeModel> getNotices(int limit){
        List<NoticeModel> result = new ArrayList<>();
        for(int x = 0; x < limit; x++){
            result.add(new NoticeModel("Demo Notice Title","2022-02-27","Demo Notice Body"));
        }
        return result;
    }
}
