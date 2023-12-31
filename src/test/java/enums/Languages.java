package enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor

public enum Languages {
    ENGLISH("English"),
    RUSSIAN("Russian"),
    GERMAN("German"),
    UKRAINE("Ukraine");

    public final String value;

}
