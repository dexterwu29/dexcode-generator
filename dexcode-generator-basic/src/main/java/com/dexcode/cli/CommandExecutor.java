package com.dexcode.cli;

import com.dexcode.cli.command.ConfigCommand;
import com.dexcode.cli.command.GenerateCommand;
import com.dexcode.cli.command.ListCommand;
import picocli.CommandLine;

/**
 * 命令执行器
 */
@CommandLine.Command(name = "dexcode", mixinStandardHelpOptions = true)
public class CommandExecutor implements Runnable {
    private final CommandLine commandLine;

    {
        commandLine = new CommandLine(this)
                .addSubcommand(new GenerateCommand())
                .addSubcommand(new ConfigCommand())
                .addSubcommand(new ListCommand());
    }

    @Override
    public void run() {
        // 不输入子命令时，给出友好提示
        System.out.println("请输入具体命令，或者输入 --help 查看命令提示");
    }

    /**
     * 执行命令
     *
     * @param args
     * @return
     */
    public Integer doExecute(String[] args) {
        return commandLine.execute(args);
    }
}
