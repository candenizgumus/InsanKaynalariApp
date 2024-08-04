package com.humanresourcesapp.repositories;

import com.humanresourcesapp.entities.Offer;
import com.humanresourcesapp.views.VwGetAllOffer;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.awt.print.Pageable;
import java.util.List;
import java.util.Optional;

public interface OfferRepository extends JpaRepository<Offer, Long>
{
    @Query("select new com.humanresourcesapp.views.VwGetAllOffer(o.id,o.name,o.surname,o.email,o.phone,o.companyName,o.title,o.numberOfEmployee,o.userType,o.sector,o.approvalText) from Offer o  where o.status = 'PENDING'")
    List<VwGetAllOffer> getAllOffer(PageRequest pageRequest);
    @Query("select new com.humanresourcesapp.views.VwGetAllOffer(o.id,o.name,o.surname,o.email,o.phone,o.companyName,o.title,o.numberOfEmployee,o.userType,o.sector,o.approvalText) from Offer o  where o.status = 'PENDING' AND o.email like %?1%")
    List<VwGetAllOffer> getAllOfferByEmailSearch(String email ,PageRequest pageRequest);

    Optional<Offer> findByEmail (String email);
}
