package com.dexcode.cli.example;

import picocli.CommandLine;
import picocli.CommandLine.Option;

import java.util.concurrent.Callable;

/**
 * 第二个，密码和确认密码交互
 */
class Login implements Callable<Integer> {
    @Option(names = {"-u", "--user"}, description = "User name")
    String user;

    @Option(names = {"-p", "--password"}, description = "Passphrase", interactive = true)
    String password;

    @Option(names = {"-cp", "--checkPassword"}, description = "Check Password", interactive = true)
    String checkPassword;

    public Integer call() throws Exception {
        // 打印出密码
        System.out.println("密码是：" + password);
        System.out.println("确认密码是：" + checkPassword);
        return 0;
    }

    public static void main(String[] args) {
        new CommandLine(new Login()).execute("-u", "user123", "-p", "xxx", "-cp");
    }
}