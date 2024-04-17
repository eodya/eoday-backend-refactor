package com.eodya.backend.recommendation.domain;

import com.eodya.backend.common.entity.BaseEntity;
import com.eodya.backend.place.domain.Place;
import com.eodya.backend.review.domain.Review;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Entity
@Table(name = "recommendation")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Recommendation extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "review_id")
    private Review review;

    @Column(nullable = false)
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "place_id")
    private Place place;

    @Builder
    private Recommendation(
            Review review,
            Place place
    ) {
        this.review = review;
        this.place = place;
    }
}
