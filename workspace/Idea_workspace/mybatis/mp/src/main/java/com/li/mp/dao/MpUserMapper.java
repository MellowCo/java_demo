package com.li.mp.dao;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.li.mp.domain.MpUser;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Description:
 * @Author: li
 * @Create: 2020-02-19 20:58
 */
public interface MpUserMapper extends BaseMapper<MpUser> {
    List<MpUser> selectAll(@Param(Constants.WRAPPER) Wrapper<MpUser> wrapper);

    IPage<MpUser> myPage(Page<MpUser> page, @Param(Constants.WRAPPER) Wrapper<MpUser> wrapper);
}
