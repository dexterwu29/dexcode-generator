package com.dexcode.cli.pattern;

/**
 * （2.2）命令接口的实现类，打开命令
 */
public class TurnOnCommand implements Command {
    private Device device;

    public TurnOnCommand(Device device) {
        this.device = device;
    }

    public void execute() {
        device.turnOn();
    }
}