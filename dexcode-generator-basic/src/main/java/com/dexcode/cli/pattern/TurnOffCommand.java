package com.dexcode.cli.pattern;

/**
 * （2.1）命令接口的实现类，关闭命令
 */
public class TurnOffCommand implements Command {
    private Device device;

    public TurnOffCommand(Device device) {
        this.device = device;
    }

    public void execute() {
        device.turnOff();
    }
}