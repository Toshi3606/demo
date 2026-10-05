package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.User;
import com.example.demo.repository.UserRepository;

@Service
public class LoginService {

    @Autowired
    private UserRepository userRepository;

    public User authenticate(String loginId, String password) {

        System.out.println("===== ログイン開始 =====");
        System.out.println("入力 loginId : " + loginId);
        System.out.println("入力 password: " + password);

        User user = userRepository.findByLoginId(loginId);

        if (user == null) {
            System.out.println("ユーザーが見つかりません");
            return null;
        }

        System.out.println("DB loginId   : " + user.getLoginId());
        System.out.println("DB password  : " + user.getPassword());

        if (!user.getPassword().equals(password)) {
            System.out.println("パスワード不一致");
            return null;
        }

        System.out.println("認証成功");

        return user;
    }
}