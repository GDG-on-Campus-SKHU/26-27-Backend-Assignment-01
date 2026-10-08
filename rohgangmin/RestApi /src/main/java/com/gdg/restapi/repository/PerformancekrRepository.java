package com.gdg.restapi.repository;

import com.gdg.restapi.domain.Performancekr;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class PerformancekrRepository {
    private static final Map<Long, Performancekr> performancekrMap = new HashMap<>();
    private long sequence = 0L;

    public PerformancekrRepository() {
        save(new Performancekr(null, "칸예웨스트", "고양종합운동장", "타달사", "2024 08 23"));
        save(new Performancekr(null, "칸예웨스트", "인천문학경기장", null, "2025 07 26"));
        save(new Performancekr(null, "타일러더크레이터", "고양킨텍스", "파리텍사스", "2025 09 13~2025 09 14"));
        save(new Performancekr(null, "트래비스스캇", "고양종합운동장", null, "2025 10 25"));

    }

    public Performancekr save(Performancekr newPerformancekr) {
        Performancekr performancekr = new Performancekr(++sequence, newPerformancekr.getName(),
                newPerformancekr.getVenue(), newPerformancekr.getGuest(), newPerformancekr.getDate());
        performancekrMap.put(performancekr.getId(), performancekr);
        return performancekr;
    }

    public List<Performancekr> findAll() {
        return new ArrayList<>(performancekrMap.values());
    }

    public Optional<Performancekr> findById(Long id) {
        return Optional.ofNullable(performancekrMap.get(id));
    }

    public boolean delete(Long id) {
        return performancekrMap.remove(id) != null;
    }
}
