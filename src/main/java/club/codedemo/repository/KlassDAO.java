package club.codedemo.repository;

import club.codedemo.thepersistencelayerwithspringdatajpa.Klass;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface KlassDAO extends JpaRepository<Klass, Long> {
}