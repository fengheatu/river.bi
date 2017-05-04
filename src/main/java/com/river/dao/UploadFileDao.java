package com.river.dao;

import com.river.entity.UploadFile;

import java.util.List;

public interface UploadFileDao {
    int deleteByPrimaryKey(String id);

    int insert(UploadFile record);

    int insertSelective(UploadFile record);

    UploadFile selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(UploadFile record);

    int updateByPrimaryKey(UploadFile record);

    /**
     * 查询商品图片
     * @param snacksId
     * @return
     */
    List<UploadFile> listUploadFIleBySnacksId(String snacksId);
}