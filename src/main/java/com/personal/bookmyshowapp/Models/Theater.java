package com.personal.bookmyshowapp.Models;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
public class Theater extends BaseModel{
    private String name;
    @OneToOne
    private Region region;
    @OneToMany
    private List<Screen> screens;
}
