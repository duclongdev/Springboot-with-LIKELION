package com.homework.homework_with_likelion_w2_2.designPattern.factory;

import com.homework.homework_with_likelion_w2_2.designPattern.computer.Computer;
import com.homework.homework_with_likelion_w2_2.designPattern.computer.Impl.Server;
import com.homework.homework_with_likelion_w2_2.designPattern.computer.Impl.PC;
import org.springframework.stereotype.Component;

@Component
public class ComputerFactory {
    public Computer getComputer(String type){
        if(type.equalsIgnoreCase("PC"))
            return new PC();
        else if (type.equalsIgnoreCase("Server"))
            return new Server();
        return null;
    }
}
