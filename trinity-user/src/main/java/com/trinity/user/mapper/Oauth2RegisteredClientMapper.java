package com.trinity.user.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.trinity.user.entity.Oauth2RegisteredClient;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface Oauth2RegisteredClientMapper extends BaseMapper<Oauth2RegisteredClient> {
}
