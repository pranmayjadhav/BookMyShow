package com.personal.bookmyshowapp.Models;
import com.personal.bookmyshowapp.Models.Enum.Feature;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@Entity
public class Show extends BaseModel{
    @OneToOne
    private Movie movie;
    private Date startTime;
    private Date endTime;
    @OneToOne
    private Screen screen;
    @Enumerated(EnumType.ORDINAL)
    private List<Feature> features;

}
