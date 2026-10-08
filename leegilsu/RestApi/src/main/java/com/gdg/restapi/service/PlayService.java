package com.gdg.restapi.service;

import com.gdg.restapi.dto.Note;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import javax.sound.midi.MidiChannel;
import javax.sound.midi.MidiSystem;
import javax.sound.midi.MidiUnavailableException;
import javax.sound.midi.Synthesizer;
import java.util.List;

@Service
@Slf4j
public class PlayService {
    private static final int DEFAULT_VELOCITY = 80; // 기본 볼륨 세기

    // id로 악보 재생
    @Async // 비동기화
    public void play(Integer instrument, List<Note> melody) {

        // 멜로디 없을 시 바로 종료
        if (melody == null || melody.isEmpty()) {
            log.warn("재생할 멜로디 데이터가 없습니다.");
            return;
        }

        Synthesizer synthesizer = null;
        try {
            synthesizer = MidiSystem.getSynthesizer();
            synthesizer.open();
            log.info("신디사이저 실행(악기 번호: {})", instrument);
            MidiChannel channel = synthesizer.getChannels()[0]; // 트랙 지정(0~15)

            // 악기 선택
            channel.programChange(instrument);

            // 노트 진행
            for (Note note : melody) {
                List<Integer> pitches = note.getPitches();
                Integer duration = note.getDuration();

                if (pitches != null && !pitches.isEmpty()) {
                    pitches.forEach(pitch -> channel.noteOn(pitch, DEFAULT_VELOCITY)); // 건반 누르기
                    Thread.sleep(duration); // 박자만큼 스레드 대기(누른 건반 소리 그동안 나옴)
                    pitches.forEach(channel::noteOff); // 건반 떼기
                } else {
                    Thread.sleep(duration); // 쉼표
                }
            }
        } catch (MidiUnavailableException e) { // MIDI 장치를 쓸 수 없음
            log.error("오디오 장치를 열 수 없습니다.", e);
        } catch (InterruptedException e) { // 재생이 강제로 멈춤
            log.info("음악 재생이 강제 중단되었습니다.");
            Thread.currentThread().interrupt();
        } catch (Exception e) { // 그 외 예외
            log.error("알 수 없는 에러가 발생했습니다.", e);
        } finally {
            if (synthesizer != null && synthesizer.isOpen()) {
                synthesizer.close();
                log.info("신디사이저 종료");
            }
        }
    }
}
