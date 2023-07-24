package org.steamclone.services.interfaces;

import org.springframework.stereotype.Repository;
import org.steamclone.dtos.ProfileCommentDTO;
import org.steamclone.dtos.ReviewDTO;

import java.util.List;

public interface ReviewInterface {

    public int createReviewInterface(ReviewDTO reviewDTO);

    public List<ReviewDTO> listGameReviews(int idGame);

    public List<ReviewDTO> listPositiveGameReviews(int idGame);

    public List<ReviewDTO> listNegativeGameReviews(int idGame);

    public ReviewDTO getReviewDTO(int idReviewDTO);


}
