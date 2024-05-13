package com.Jasmineconnect.DonationSite.Entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Entity
@Table(name = "donation")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Donation extends AbstractEntity {

    @NotNull(message = "Amount is required")
    @PositiveOrZero(message = "Amount must be positive or zero")
    private Double amount;

    @Size(max = 1000, message = "Message must not exceed 1000 characters")
    private String message;

    @ManyToOne
    @JoinColumn(name = "campaign_id")
    private Campaign campaign;
}
