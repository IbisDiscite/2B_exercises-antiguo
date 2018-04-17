package arquisoft.ms.Exercises_2B.repository;

import arquisoft.ms.Exercises_2B.model.Exercise;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExerciseRepository extends JpaRepository<Exercise, Long> {

}