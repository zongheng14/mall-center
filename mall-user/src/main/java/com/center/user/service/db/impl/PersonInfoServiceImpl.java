package com.center.user.service.db.impl;


import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.center.user.dao.entity.PersonInfo;
import com.center.user.dao.mapper.PersonInfoMapper;
import com.center.user.service.db.IPersonInfoService;
import org.springframework.stereotype.Service;

/**
 * <p>
 *   服务实现类
 * </p>
 *
 * @author human
 * @since 2019-08-22
 */
@Service
public class PersonInfoServiceImpl extends ServiceImpl<PersonInfoMapper, PersonInfo> implements IPersonInfoService {
	
}
