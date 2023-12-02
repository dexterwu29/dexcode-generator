package com.dexcode.cli.pattern;

/**
 * （4）客户端，发起请求
 */
public class Client {
    public static void main(String[] args) {
        // 创建接收者对象
        Device tv = new Device("TV");
        Device stereo = new Device("Stereo");

        // 创建具体的命令对象，不同的设备可以执行不同的命令
        TurnOnCommand turnOn = new TurnOnCommand(tv);
        TurnOffCommand turnOff = new TurnOffCommand(stereo);

        // 创建调用者
        RemoteControl remoteControl = new RemoteControl();

        // 执行命令
        remoteControl.setCommand(turnOn);
        remoteControl.pressButton();

        remoteControl.setCommand(turnOff);
        remoteControl.pressButton();
    }
}