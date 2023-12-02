package com.dexcode.cli.pattern;

/**
 * （3）遥控器
 */
public class RemoteControl {
    private Command command;

    public void setCommand(Command command) {
        this.command = command;
    }

    public void pressButton() {
        // 按下按钮，执行命令
        command.execute();
    }
}