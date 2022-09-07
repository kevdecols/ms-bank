package com.techBank.account.cmd.api.commands;

import com.techBank.crqrs.core.commands.BaseCommand;
import lombok.Data;

@Data
public class WithDrawFundsCommand extends BaseCommand {
    private double amount;
}
