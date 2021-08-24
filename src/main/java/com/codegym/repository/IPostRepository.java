package com.codegym.repository;

import com.codegym.model.Post;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface IPostRepository extends PagingAndSortingRepository<Post,Long> {
    @Query(value = "from Post where title like :title")
    Iterable<Post>findByName(@Param("title") String title);
}
