package com.crayon.youcanpass.service.impl;

import com.crayon.youcanpass.common.utils.JwtTokenUtil;
import com.crayon.youcanpass.component.SecurityUserHelper;
import com.crayon.youcanpass.dao.ImsDepartmentDao;
import com.crayon.youcanpass.dao.UmsUserRoleRelationDao;
import com.crayon.youcanpass.dto.UmsUserDetailDto;
import com.crayon.youcanpass.mapper.UmsUserMapper;
import com.crayon.youcanpass.model.UmsPermission;
import com.crayon.youcanpass.model.UmsUser;
import com.crayon.youcanpass.model.UmsUserExample;
import com.crayon.youcanpass.service.UmsUserService;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UmsUserServiceImpl implements UmsUserService {

    private static final Logger LOGGER = LoggerFactory.getLogger(UmsUserServiceImpl.class);
    @Autowired
    private UserDetailsService userDetailsService;
    @Autowired
    private JwtTokenUtil jwtTokenUtil;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private UmsUserMapper userMapper;
    @Autowired
    private UmsUserRoleRelationDao userRoleRelationDao;
    @Autowired
    private ImsDepartmentDao imsDepartmentDao;

    @Value("${jwt.tokenHead}")
    private String tokenHead;

    @Override
    public UmsUser getUserByUserName(String username) {
        UmsUserExample userExample = new UmsUserExample();
        userExample.createCriteria().andUsernameEqualTo(username);
        List<UmsUser> userList = userMapper.selectByExample(userExample);
        if(userList != null && userList.size() > 0){
            return userList.get(0);
        }
        return null;
    }

    @Override
    public UmsUserDetailDto getUserLoginInfo() {
        UmsUserDetailDto userDetailDto = new UmsUserDetailDto();
        //获取当前登陆用户信息
        UmsUser user = this.getUserByUserName(SecurityUserHelper.getLoginUserName());
        userDetailDto.setUsername(user.getUsername());
        userDetailDto.setRealName(user.getRealName());
        userDetailDto.setDepartmentChains(imsDepartmentDao.getDepartmentRoot(user.getDepartmentId()));
        userDetailDto.setRoleNames(userRoleRelationDao.listRoleNameByUserId(user.getId()));
        return userDetailDto;
    }

    @Override
    public String login(String username, String password) {
        String token = null;
        try{
            UserDetails userDetails = userDetailsService.loadUserByUsername(username);
            if(!passwordEncoder.matches(password, userDetails.getPassword())){
                throw new BadCredentialsException("密码错误");
            }
            UsernamePasswordAuthenticationToken authentication =
                    new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
            SecurityContextHolder.getContext().setAuthentication(authentication);
            token = jwtTokenUtil.generateToken(userDetails);
        }catch (AuthenticationException e){
            LOGGER.warn("登录异常:{}", e.getMessage());
        }
        return token;
    }

    @Override
    public Integer update(Long id, UmsUser umsUser) {
        umsUser.setId(id);
        if(umsUser.getPassword() != null){
            //密码加密
            String encodePassword = passwordEncoder.encode(umsUser.getPassword());
            umsUser.setPassword(encodePassword);
        }
        return userMapper.updateByPrimaryKeySelective(umsUser);
    }

    @Override
    public List<UmsPermission> listPermissionByUserId(Long userId, Integer permissionType, Integer permissionStatus) {
        return userRoleRelationDao.listPermissionsByUserId(userId, permissionType, permissionStatus);
    }
}
