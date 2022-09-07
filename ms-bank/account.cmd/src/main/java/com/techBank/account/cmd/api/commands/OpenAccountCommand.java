package com.techBank.account.cmd.api.commands;

import com.techBank.account.common.dto.AccountType;
import com.techBank.crqrs.core.commands.BaseCommand;

public class OpenAccountCommand extends BaseCommand {
    private String accountHolder;
    private AccountType accountType;
    private double openingBalance;
}
