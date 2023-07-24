package org.steamclone.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.steamclone.models.entities.PaymentMethod;
import org.steamclone.models.entities.ProfileComment;

import java.util.List;

@Repository
public interface ProfileCommentRepo extends JpaRepository<ProfileComment, Integer> {
    @Query("select p from ProfileComment p where p.profileUser.id = :idUser")
    List<ProfileComment> listProfileCommentByIdUser(int idUser);
}
