package Model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record Authors(
        @JsonAlias("name")
        String name,
        @JsonAlias("birth_year")
        String birthDate,
        @JsonAlias("death_year")
        String deathYear



) {

        @Override
        public String toString() {
                return " Autores->"+
                        " Nombre: " + name +
                        " Fecha nacimiento: " + birthDate +
                        " Fallecimiento " + deathYear+" ";
        }
}
