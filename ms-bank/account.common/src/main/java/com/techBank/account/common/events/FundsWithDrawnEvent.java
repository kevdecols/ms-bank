package com.techBank.account.common.events;

import com.techBank.crqrs.core.events.BaseEvent;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public class FundsWithDrawnEvent extends BaseEvent {
    private double amount;
}
