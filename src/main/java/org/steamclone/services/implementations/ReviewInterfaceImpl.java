package org.steamclone.services.implementations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.steamclone.dtos.ReviewDTO;
import org.steamclone.models.entities.PuntuationReview;
import org.steamclone.models.entities.Review;
import org.steamclone.repositories.ReviewRepo;
import org.steamclone.services.interfaces.GameInterface;
import org.steamclone.services.interfaces.ReviewInterface;
import org.steamclone.services.interfaces.UserInterface;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ReviewInterfaceImpl implements ReviewInterface {

    @Autowired
    ReviewRepo reviewRepo;
    @Autowired
    UserInterface userInterface;

    @Autowired
    GameInterface gameInterface;

    @Override
    public int createReviewInterface(ReviewDTO reviewDTO) throws Exception {
        Review review = new Review();

        review.setDate(LocalDate.now());
        review.setReview(reviewDTO.getReview());
        review.setUser(userInterface.getUser(reviewDTO.getIdUser()));
        review.setPuntuation(reviewDTO.getPuntuation());
        review.setGame(gameInterface.getGame(reviewDTO.getIdGame()));

        reviewRepo.save(review);

        return review.getId();
    }

    @Override
    public List<ReviewDTO> listGameReviews(int idGame) {
        List<Review> listReview = reviewRepo.findByIdGame(idGame);
        List<ReviewDTO> listReviewDTO = new ArrayList<>();

        for (Review review: listReview) {
            listReviewDTO.add(convertToDTO(review));
        }

        return listReviewDTO;
    }

    @Override
    public List<ReviewDTO> listPositiveGameReviews(int idGame) {
        List<Review> listReview = reviewRepo.findByPuntuationAndIdGame(PuntuationReview.POSITIVE, idGame);
        List<ReviewDTO> listReviewDTO = new ArrayList<>();

        for (Review review: listReview) {
            listReviewDTO.add(convertToDTO(review));
        }

        return listReviewDTO;
    }

    @Override
    public List<ReviewDTO> listNegativeGameReviews(int idGame) {

        List<Review> listReview = reviewRepo.findByPuntuationAndIdGame(PuntuationReview.NEGATIVE, idGame);
        List<ReviewDTO> listReviewDTO = new ArrayList<>();

        for (Review review: listReview) {
            listReviewDTO.add(convertToDTO(review));
        }

        return listReviewDTO;
    }

    @Override
    public ReviewDTO getReviewDTO(int idReviewDTO) throws Exception {
        Optional<Review> review = reviewRepo.findById(idReviewDTO);

        if(review.isEmpty()){
            throw new Exception("No existe una review con el id " + idReviewDTO);
        }

        return convertToDTO(review.get());
    }

    private ReviewDTO convertToDTO(Review review) {

        ReviewDTO reviewDTO = new ReviewDTO(
                review.getId(),
                review.getUser().getId(),
                review.getGame().getId(),
                review.getPuntuation(),
                review.getDate(),
                review.getReview()
        );

        return reviewDTO;
    }
}
