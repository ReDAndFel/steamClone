package org.steamclone.dtos;

import jakarta.persistence.ElementCollection;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.steamclone.models.entities.Business;
import org.steamclone.models.entities.Tag;
import org.steamclone.models.entities.TransactionDetail;
import org.steamclone.models.entities.User;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

@AllArgsConstructor
@Getter
@Setter
public class ImageDTO {
    private String id;
    private String url;

}
