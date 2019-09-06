package com.nchu.shop.config;

import com.alibaba.dubbo.config.annotation.Reference;
import com.nchu.model.Seller;
import com.nchu.sellergoods.service.SellerService;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;


@Component("userDetailsService")
public class UserDetailsServiceImpl implements UserDetailsService {
    @Reference
    private SellerService sellerService;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        List<GrantedAuthority> authorities = new ArrayList<>();
        // 从数据库中取出用户信息
        Seller seller = sellerService.findOne(username);

        // 判断用户是否存在
        if(seller == null) {
            throw new UsernameNotFoundException("用户名不存在");
        }
        authorities.add(new SimpleGrantedAuthority("ROLE_SELLER"));

        // 返回UserDetails实现类
        return new User(seller.getSellerId(), seller.getPassword(), authorities);
    }

}
