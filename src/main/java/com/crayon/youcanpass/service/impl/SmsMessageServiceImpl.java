package com.crayon.youcanpass.service.impl;

import com.crayon.youcanpass.common.constant.SmsMessageConstant;
import com.crayon.youcanpass.common.exception.ServiceException;
import com.crayon.youcanpass.component.SecurityUserHelper;
import com.crayon.youcanpass.dao.SmsMessageDao;
import com.crayon.youcanpass.dto.SmsMessageDto;
import com.crayon.youcanpass.mapper.SmsMessageMapper;
import com.crayon.youcanpass.model.SmsMessage;
import com.crayon.youcanpass.model.SmsMessageExample;
import com.crayon.youcanpass.service.SmsMessageService;
import com.crayon.youcanpass.service.UmsUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * @Classname SmsMessageServiceImpl
 * @Description 消息通知业务层接口实现
 * @Date 2020/3/29 18:11
 * @Created by Crayon
 */
@Service
public class SmsMessageServiceImpl implements SmsMessageService {
    @Autowired
    private SmsMessageDao messageDao;
    @Autowired
    private SmsMessageMapper messageMapper;
    @Autowired
    private UmsUserService umsUserService;

    @Override
    @Deprecated
    public SmsMessage get(Long id) {
        return null;
    }

    @Override
    @Deprecated
    public List<SmsMessage> list() {
        return null;
    }

    @Override
    public SmsMessageDto getById(Long id) {
        return messageDao.get(id);
    }

    @Override
    public List<SmsMessageDto> listAll() {
        return messageDao.list();
    }

    @Override
    public int insert(SmsMessage smsMessage) {
        Long userId = umsUserService.
                getUserByUserName(SecurityUserHelper.getLoginUserName()).getId();
        smsMessage.setUserId(userId);
        smsMessage.setUpdateDate(new Date());
        smsMessage.setCommitDate(new Date());
        //默认发布
        smsMessage.setStatus(SmsMessageConstant.OPEN);
        return messageMapper.insert(smsMessage);
    }

    @Override
    public int delete(Long id) {
        return messageMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int update(Long id, SmsMessage smsMessage) {
        Long userId = umsUserService.
                getUserByUserName(SecurityUserHelper.getLoginUserName()).getId();
        SmsMessageExample messageExample = new SmsMessageExample();
        messageExample.createCriteria()
                .andIdEqualTo(id)
                .andUserIdEqualTo(userId);
        int cnt = messageMapper.selectByExample(messageExample).size();
        if(cnt <= 0) throw ServiceException.forbidden("无更改权限");

        smsMessage.setCommitDate(null);
        smsMessage.setUserId(null);
        smsMessage.setUpdateDate(new Date());
        smsMessage.setId(id);
        return messageMapper.updateByPrimaryKeySelective(smsMessage);
    }
}
