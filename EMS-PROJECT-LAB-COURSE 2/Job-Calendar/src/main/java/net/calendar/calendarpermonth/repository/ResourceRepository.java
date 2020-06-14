package net.calendar.calendarpermonth.repository;

import net.calendar.calendarpermonth.domain.Resource;
import org.springframework.data.repository.CrudRepository;

public interface ResourceRepository extends CrudRepository<Resource, Long> {
}