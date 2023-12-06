package com.personal.bookmyshowapp.Models;
import com.personal.bookmyshowapp.Models.Enum.Feature;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
public class Screen extends BaseModel{
    private String name;
    @OneToMany
    private List<Seat> seats;
    @Enumerated(EnumType.ORDINAL)
    @ElementCollection //Mapping table for enums
    private List<Feature> features;
}
