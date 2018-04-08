package arquisoft.ms.Exercises_2B.controller;
import arquisoft.ms.Exercises_2B.exception.ResourceNotFoundException;
import arquisoft.ms.Exercises_2B.model.Exercise;
import arquisoft.ms.Exercises_2B.repository.ExerciseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/mse")
public class ExerciseController {

    @Autowired
    ExerciseRepository exerciseRepository;

    // Get All 
    @GetMapping("/exercises")
	public List<Exercise> getAllExercises() {
    	return exerciseRepository.findAll();
	}

    // Create 
    @PostMapping("/exercises")

	public Exercise createExercise( @Valid @RequestBody Exercise exercise) {
    	return exerciseRepository.save(exercise);
	}
    // Get a Single 
	@GetMapping("/exercises/{id}")
	public Exercise getExerciseById(@PathVariable(value = "id") Long eId) {
    return exerciseRepository.findById(eId).orElseThrow(() -> new ResourceNotFoundException("Exercise", "id", eId));
}
    // Update 
 	@PutMapping("/exercises/{id}")
    public Exercise updateExercise(@PathVariable(value = "id") Long eId,@Valid @RequestBody Exercise details) {
        Exercise exercise = exerciseRepository.findById(eId).orElseThrow(() -> new ResourceNotFoundException("Exercise", "id", eId));

        exercise.setLeccion(details.getLeccion());
        exercise.setEnunciado(details.getEnunciado());
        exercise.setOpc1(details.getOpc1());
        exercise.setOpc2(details.getOpc2());
        exercise.setOpc3(details.getOpc3());
        exercise.setResouesta(details.getRespuesta());
        Exercise updated = exerciseRepository.save(exercise);
        return updated;
    }

    // Delete 
        @DeleteMapping("/exercises/{id}")
    public ResponseEntity<?> deleteExercise(@PathVariable(value = "id") Long eId) {
        Exercise exercise = exerciseRepository.findById(eId).orElseThrow(() -> new ResourceNotFoundException("Exercise", "id", eId));

        exerciseRepository.delete(exercise);

        return ResponseEntity.ok().build();
    }
}
