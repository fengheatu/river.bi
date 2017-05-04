package com.river.service.impl;

import com.river.dao.UploadFileDao;
import com.river.entity.UploadFile;
import com.river.service.UploadFileService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by River on 2017/4/13.
 */
@Service
public class UploadFileServiceImpl implements UploadFileService {


    @Resource
    UploadFileDao uploadFileDao;

    /**
     * 添加图片
     * @param record
     * @return
     */
    @Override
    @Transactional
    public int insertSelective(UploadFile record) {
        return uploadFileDao.insertSelective(record);
    }


    /**
     * 查询商品图片
     *
     * @param snacksId
     * @return
     */
    @Override
    public List<UploadFile> listUploadFIleBySnacksId(String snacksId) {
        return uploadFileDao.listUploadFIleBySnacksId(snacksId);
    }
}
