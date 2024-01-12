package com.spring.repository;

import org.springframework.data.mongodb.repository.Query;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.repository.MongoRepository;

import com.spring.models.InfoAnnonce;

public interface InfoAnnonceRepository extends MongoRepository<InfoAnnonce, String> {
    @Query("{ 'annonce_id' : ?0 }")
    InfoAnnonce findByAnnonceId(String idAnnonce);

    @Query("{ 'statut' : 2 }")
    List<InfoAnnonce> findByStatutEquals(int statut);

    @Query("{ 'auteur_id' : ?0 }")
    List<InfoAnnonce> findByAuteurId(String idauteur);

    @Query("{ 'favoris' : { $all : [ ?0] } }")
    List<InfoAnnonce> findUserFavoris(String userId);
}
