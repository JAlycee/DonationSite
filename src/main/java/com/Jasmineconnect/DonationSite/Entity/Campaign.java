package com.Jasmineconnect.DonationSite.Entity;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;
import java.util.Date;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "campaign")
@Accessors(chain = true)
public class Campaign extends AbstractEntity {
    @NotBlank(message = "Campaign name is required")  // NotBlank automatically implies NotNull
    @Size(max = 255, message = "Campaign name must not exceed 255 characters")
    private String name;

    @NotBlank(message = "Campaign description is required") // NotBlank implies non-null and non-empty
    @Size(max = 1000, message = "Description must not exceed 1000 characters")
    private String description;

    @NotNull(message = "Goal amount is required")
    @DecimalMin(value = "0.01", message = "Goal amount must be at least 0.01")
    private Double goalAmount;  // Use Double for consistent validation with DecimalMin

    @NotNull(message = "Start date is required")
    @FutureOrPresent(message = "Start date must be today or in the future")
    private Date startDate;

    @NotNull(message = "End date is required")
    @Future(message = "End date must be after the start date")
    private Date endDate;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @OneToMany(mappedBy = "campaign", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Donation> donations;

    private double totalDonations; // Store total donations directly

    public Campaign() {
        this.donations = new ArrayList<>();
    }

    // This method adds the donation amount to the total donations
    public void addToDonationTotal(double amount) {
        this.totalDonations += amount;
    }
}
//    // Dynamically calculate total donations from the list of donations
//    public double calculateTotalDonations() {
//        return donations.stream().mapToDouble(Donation::getAmount).sum();
//    }
//}