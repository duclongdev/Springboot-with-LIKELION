package com.homework.homework_with_likelion_w2_2.designPattern.computer.Impl;

import com.homework.homework_with_likelion_w2_2.designPattern.computer.Computer;

public class Server implements Computer {
    @Override
    public String getType() {
        return "Server";
    }
}
