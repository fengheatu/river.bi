package com.river.service;

import com.river.entity.UploadFile;

import java.util.List;

/**
 * Created by River on 2017/4/13.
 */
public interface UploadFileService {

    /**
     * 添加图片
     * @param record
     * @return
     */
    int insertSelective(UploadFile record);


    /**
     * 查询商品图片
     * @param snacksId
     * @return
     */
    List<UploadFile> listUploadFIleBySnacksId(String snacksId);
}
