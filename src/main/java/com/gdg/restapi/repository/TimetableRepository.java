package com.gdg.restapi.repository;

import com.gdg.restapi.domain.Timetable;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class TimetableRepository {

    private final Map<Long, Timetable> timetables = new HashMap<>();
    private long sequence = 0L;

    public TimetableRepository() {
        save(new Timetable(0L, "월요일", "수업 없음"));

        save(new Timetable(0L, "화요일", "과학기술과 에콜로지, Python 프로그래밍"));

        save(new Timetable(0L, "수요일", "세상을 바꾼 기술,온라인 게임과 종교적 상징"));

        save(new Timetable(0L, "목요일", "Python 프로그래밍"));

        save(new Timetable(0L, "금요일", "인권과 평화, 전공진로세미나, 웹개발입문"));

        save(new Timetable(0L, "토요일", "수업 없음"));

        save(new Timetable(0L, "일요일", "수업 없음"));
    }

    public Timetable save(Timetable newTimetable) {
        Timetable timetable = new Timetable(
                ++sequence,
                newTimetable.getDay(),
                newTimetable.getName()
        );

        timetables.put(timetable.getId(), timetable);
        return timetable;
    }

    public List<Timetable> findAll() {
        return new ArrayList<>(timetables.values());
    }

    public Optional<Timetable> findById(Long id) {
        return Optional.ofNullable(timetables.get(id));
    }

    public boolean delete(Long id) {
        return timetables.remove(id) != null;

    }
}


