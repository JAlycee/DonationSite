package com.Jasmineconnect.DonationSite.Entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "donation")
public class Donation extends AbstractEntity {

    @NotNull(message = "Amount cannot be null")
    @Min(value = 0, message = "Amount must be at least 0")
    private Double amount;

    @NotNull(message = "Message cannot be null")
    @Size(min = 5, max = 200, message = "Message must be between 5 and 200 characters")
    private String message;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "campaign_id", nullable = false)
    private Campaign campaign;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

//    public void incrementDonationCount() {
//        if (this.donationCount == null) {
//            this.donationCount = 0L;
//        }
//        this.donationCount++;
//    }
}