package com.personal.bookmyshowapp.Models;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class Theater extends BaseModel{
    private String name;
    private Region region;
    private List<Screen> screens;
}
