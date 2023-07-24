package org.steamclone.services.implementations;

import org.springframework.stereotype.Service;
import org.steamclone.dtos.ReviewDTO;
import org.steamclone.services.interfaces.ReviewInterface;

import java.util.List;
@Service
public class ReviewInterfaceImpl implements ReviewInterface {
    @Override
    public int createReviewInterface(ReviewDTO reviewDTO) {
        return 0;
    }

    @Override
    public List<ReviewDTO> listGameReviews(int idGame) {
        return null;
    }

    @Override
    public List<ReviewDTO> listPositiveGameReviews(int idGame) {
        return null;
    }

    @Override
    public List<ReviewDTO> listNegativeGameReviews(int idGame) {
        return null;
    }

    @Override
    public ReviewDTO getReviewDTO(int idReviewDTO) {
        return null;
    }
}
