package gr.aueb.cf.schoolapp.validator;

import gr.aueb.cf.schoolapp.dto.TeacherEditDTO;
import gr.aueb.cf.schoolapp.model.Teacher;
import gr.aueb.cf.schoolapp.repository.RegionRepository;
import gr.aueb.cf.schoolapp.repository.TeacherRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
@Slf4j
public class TeacherEditValidator implements Validator {
    TeacherRepository teacherRepository;
    RegionRepository regionRepository;

    public TeacherEditValidator(TeacherRepository teacherRepository, RegionRepository regionRepository) {
        this.teacherRepository = teacherRepository;
        this.regionRepository = regionRepository;
    }

    @Override
    public boolean supports(@NonNull Class<?> clazz) {
        return TeacherEditDTO.class == clazz;
    }

    @Override
    public void validate(@NonNull Object target, @NonNull Errors errors) {
        TeacherEditDTO teacherEditDTO = (TeacherEditDTO) target;

        // First get the existing teacher
//        Teacher existingTeacher = teacherRepository.findByUuid(dto.getUuid())
//                .orElse(null);
//
//        // Only check VAT if it's different from current value
//        if (existingTeacher != null && !dto.getVat().equals(existingTeacher.getVat())) {
//            teacherRepository.findByVat(dto.getVat())
//                    .ifPresent(teacher -> {
//                        errors.rejectValue("vat", "vat.exists", "Το ΑΦΜ του Καθηγητή υπάρχει ήδη.");
//                        log.error("VAT conflict for teacher with vat={}", dto.getVat());
//                    });
//        }

        // Region validation remains the same
//        if (dto.getRegionId() != null && regionRepository.findById(dto.getRegionId()).isEmpty()) {
//            errors.rejectValue("regionId", "region.missing", "Η περιοχή του Καθηγητή δεν μπορεί να είναι κενή.");
//            log.error("Region not found for id={}", dto.getRegionId());
//
//        }}

        Teacher teacher = teacherRepository.findByUuid(teacherEditDTO.getUuid())
                .orElse(null);

        if (teacher != null && !teacher.getVat().equals(teacherEditDTO.getVat())) {
            if (teacherRepository.findByVat(teacherEditDTO.getVat()).isPresent()) {
                log.error("Save failed for teacher with vat={}. Teacher already exists", teacherEditDTO.getVat());
                errors.rejectValue("vat", "vat.teacher.exists");
            }
        }
    }
}