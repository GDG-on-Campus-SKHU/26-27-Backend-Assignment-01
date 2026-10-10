## Postman에서 연주 설정

POST로 설정

URL: http://localhost:8080/scores/{id}/play

## 연주를 위한 Postman에서 JSON 데이터 입력 예시

### 단일 노트 입력 예시

```json
{
    "name": "제목",
    "composer": "작곡가",
    "instrument": 악기번호,
    "melody": [
        {
            "pitches": [
                노트번호
            ],
            "duration": 박자수
        },
        {
            "pitches": [
                노트번호
            ],
            "duration": 박자수
        }
    ]
}
```

### 화음 입력 예시

```json
{
    "name": "제목",
    "composer": "작곡가",
    "instrument": 악기번호,
    "melody": [
        {
            "pitches": [
                노트번호,
                노트번호,
                노트번호
            ],
            "duration": 박자수
        },
        {
            "pitches": [
                노트번호,
                노트번호,
                노트번호
            ],
            "duration": 박자수
        }
    ]
}
```

## General MIDI 악기 전체 목록(instument 값)

### 🎹 피아노 (Piano)

- 0 : Acoustic Grand Piano (어쿠스틱 그랜드 피아노 - 기본값)
- 1 : Bright Acoustic Piano (밝은 음색의 피아노)
- 2 : Electric Grand Piano (일렉트릭 그랜드 피아노)
- 3 : Honky-tonk Piano (홍키통크 피아노 - 낡고 조율이 약간 어긋난 느낌)
- 4 : Electric Piano 1 (일렉트릭 피아노 1)
- 5 : Electric Piano 2 (일렉트릭 피아노 2)
- 6 : Harpsichord (하프시코드)
- 7 : Clavinet (클라비넷)

### 🔔 타악기 / 오르골 (Chromatic Percussion)

- 8 : Celesta (셀레스타)
- 9 : Glockenspiel (글로켄슈필 / 철琴)
- 10 : Music Box (오르골)
- 11 : Vibraphone (비브라폰)
- 12 : Marimba (마림바)
- 13 : Xylophone (실로폰 / 목琴)
- 14 : Tubular Bells (튜블러 벨 / 웅장한 관 형태의 종)
- 15 : Dulcimer (덜시머)

### ⛪ 오르간 (Organ)

- 16 : Drawbar Organ (드로우바 오르간)
- 17 : Percussive Organ (퍼커시브 오르간)
- 18 : Rock Organ (락 오르간)
- 19 : Church Organ (파이프/교회 오르간)
- 20 : Reed Organ (리드 오르간 / 풍금)
- 21 : Accordion (아코디언)
- 22 : Harmonica (하모니카)
- 23 : Tango Accordion (탱고 아코디언)

### 🎸 기타 (Guitar)

- 24 : Acoustic Guitar - Nylon (나일론/클래식 기타)
- 25 : Acoustic Guitar - Steel (스틸/통기타)
- 26 : Electric Guitar - Jazz (일렉 기타 - 재즈 톤)
- 27 : Electric Guitar - Clean (일렉 기타 - 클린 톤)
- 28 : Electric Guitar - Muted (일렉 기타 - 뮤트/끊어치는 소리)
- 29 : Overdriven Guitar (오버드라이브 걸린 기타)
- 30 : Distortion Guitar (디스토션/강렬하게 찢어지는 기타)
- 31 : Guitar harmonics (기타 하모닉스)

### 🎸 베이스 (Bass)

- 32 : Acoustic Bass (어쿠스틱 콘트라베이스)
- 33 : Electric Bass - finger (일렉 베이스 - 손가락 튕김)
- 34 : Electric Bass - pick (일렉 베이스 - 피크 튕김)
- 35 : Fretless Bass (프렛리스 베이스)
- 36 : Slap Bass 1 (슬랩 베이스 1)
- 37 : Slap Bass 2 (슬랩 베이스 2)
- 38 : Synth Bass 1 (신디사이저 베이스 1)
- 39 : Synth Bass 2 (신디사이저 베이스 2)

🎻 **현악기 (Strings)**

- 40 : Violin (바이올린)
- 41 : Viola (비올라)
- 42 : Cello (첼로)
- 43 : Contrabass (콘트라베이스 / 더블 베이스)
- 44 : Tremolo Strings (트레몰로 현악기 - 빠르게 떠는 소리)
- 45 : Pizzicato Strings (피치카토 - 현을 손가락으로 튕기는 소리)
- 46 : Orchestral Harp (오케스트라 하프)
- 47 : Timpani (팀파니)

### 🎻 합주 / 앙상블 (Ensemble)

- 48 : String Ensemble 1 (현악기 앙상블 1)
- 49 : String Ensemble 2 (현악기 앙상블 2)
- 50 : SynthStrings 1 (신스 스트링 1)
- 51 : SynthStrings 2 (신스 스트링 2)
- 52 : Choir Aahs (합창단 '아~' 소리)
- 53 : Voice Oohs (사람 목소리 '우~' 소리)
- 54 : Synth Voice (합성된 목소리)
- 55 : Orchestra Hit (오케스트라 히트 - 웅장하게 한 번에 '쾅' 치는 소리)

### 🎺 금관악기 (Brass)

- 56 : Trumpet (트럼펫)
- 57 : Trombone (트롬본)
- 58 : Tuba (튜바)
- 59 : Muted Trumpet (뮤트 트럼펫 - 약음기를 낀 소리)
- 60 : French Horn (프렌치 호른)
- 61 : Brass Section (브라스 섹션 / 금관악기 합주)
- 62 : SynthBrass 1 (신스 브라스 1)
- 63 : SynthBrass 2 (신스 브라스 2)

### 🎷 목관악기 - 리드 (Reed)

- 64 : Soprano Sax (소프라노 색소폰)
- 65 : Alto Sax (알토 색소폰)
- 66 : Tenor Sax (테너 색소폰)
- 67 : Baritone Sax (바리톤 색소폰)
- 68 : Oboe (오보에)
- 69 : English Horn (잉글리시 호른)
- 70 : Bassoon (바순)
- 71 : Clarinet (클라리넷)

### 🪈 목관악기 - 파이프 (Pipe)

- 72 : Piccolo (피콜로)
- 73 : Flute (플루트)
- 74 : Recorder (리코더)
- 75 : Pan Flute (팬 플루트)
- 76 : Blown Bottle (유리병 부는 소리)
- 77 : Shakuhachi (샤쿠하치 / 일본식 퉁소)
- 78 : Whistle (휘파람 소리)
- 79 : Ocarina (오카리나)

### 🎛️ 신스 리드 - 주선율용 (Synth Lead)

- 80 : Lead 1 - square (사각파 리드 - 8비트 게임 소리)
- 81 : Lead 2 - sawtooth (톱니파 리드 - 날카로운 전자음)
- 82 : Lead 3 - calliope (칼리오페 리드)
- 83 : Lead 4 - chiff (치프 리드)
- 84 : Lead 5 - charang (차랑 리드)
- 85 : Lead 6 - voice (보이스 리드)
- 86 : Lead 7 - fifths (5도음 중첩 리드)
- 87 : Lead 8 - bass + lead (베이스 + 리드 혼합)

### 🎛️ 신스 패드 - 배경/반주용 (Synth Pad)

- 88 : Pad 1 - new age (뉴에이지 패드)
- 89 : Pad 2 - warm (웜 패드)
- 90 : Pad 3 - polysynth (폴리신스 패드)
- 91 : Pad 4 - choir (콰이어/합창 패드)
- 92 : Pad 5 - bowed (보우드 패드 - 현악기 긁는 느낌)
- 93 : Pad 6 - metallic (메탈릭 패드)
- 94 : Pad 7 - halo (헤일로 패드 - 성스러운 울림)
- 95 : Pad 8 - sweep (스윕 패드)

### 🎛️ 신스 특수 효과 (Synth Effects)

- 96 : FX 1 - rain (비 내리는 소리 형태의 효과음)
- 97 : FX 2 - soundtrack (사운드트랙)
- 98 : FX 3 - crystal (크리스탈)
- 99 : FX 4 - atmosphere (대기/공간감)
- 100 : FX 5 - brightness (밝은 느낌)
- 101 : FX 6 - goblins (고블린/기괴한 소리)
- 102 : FX 7 - echoes (에코/메아리)
- 103 : FX 8 - sci-fi (공상과학 느낌의 소리)

### 🪕 민속 악기 (Ethnic)

- 104 : Sitar (시타르 - 인도 악기)
- 105 : Banjo (밴조)
- 106 : Shamisen (샤미센 - 일본 악기)
- 107 : Koto (코토 - 일본 악기)
- 108 : Kalimba (칼림바)
- 109 : Bag pipe (백파이프)
- 110 : Fiddle (피들 / 민속 바이올린)
- 111 : Shanai (샤나이 - 인도 관악기)

### 🥁 타악기 (Percussive)

- 112 : Tinkle Bell (작은 방울/종)
- 113 : Agogo (아고고 벨)
- 114 : Steel Drums (스틸 드럼)
- 115 : Woodblock (우드블록)
- 116 : Taiko Drum (타이코/큰북)
- 117 : Melodic Tom (멜로딕 탐탐)
- 118 : Synth Drum (신스 드럼)
- 119 : Reverse Cymbal (리버스 심벌즈 - 역재생 효과)

### 🔊 효과음 (Sound Effects)

- 120 : Guitar Fret Noise (기타 프렛 긁히는 노이즈)
- 121 : Breath Noise (숨소리)
- 122 : Seashore (파도 소리)
- 123 : Bird Tweet (새 지저귀는 소리)
- 124 : Telephone Ring (전화 벨소리)
- 125 : Helicopter (헬리콥터 프로펠러 소리)
- 126 : Applause (관중 박수 소리)
- 127 : Gunshot (총소리)

## 노트 번호 표(pitches 값)

| **계이름 (한국어)** | **C3 (낮은 음역)** | **C4 (가온 음역 - 기준)** | **C5 (높은 음역)** | **C6 (매우 높은 음역)** |
| --- | --- | --- | --- | --- |
| **도 (C)** | 48 | **60** | 72 | 84 |
| 도# (C#) | 49 | 61 | 73 | 85 |
| **레 (D)** | 50 | **62** | 74 | 86 |
| 레# (D#) | 51 | 63 | 75 | 87 |
| **미 (E)** | 52 | **64** | 76 | 88 |
| **파 (F)** | 53 | **65** | 77 | 89 |
| 파# (F#) | 54 | 66 | 78 | 90 |
| **솔 (G)** | 55 | **67** | 79 | 91 |
| 솔# (G#) | 56 | 68 | 80 | 92 |
| **라 (A)** | 57 | **69** | 81 | 93 |
| 라# (A#) | 58 | 70 | 82 | 94 |
| **시 (B)** | 59 | **71** | 83 | 95 |

## 기본 박자표(duration 값)

| **음표 이름** | **박자 수** | **duration 값 (ms)** |
| --- | --- | --- |
| **온음표** (Whole note) | 4박자 | **2000** |
| **점2분음표** (Dotted half) | 3박자 | **1500** |
| **2분음표** (Half note) | 2박자 | **1000** |
| **점4분음표** (Dotted quarter) | 1.5박자 | **750** |
| **4분음표** (Quarter note) | 1박자 | **500** |
| **점8분음표** (Dotted eighth) | 0.75박자 | **375** |
| **8분음표** (Eighth note) | 0.5박자 | **250** |
| **16분음표** (Sixteenth note) | 0.25박자 | **125** |
| **32분음표** | 0.125박자 | **62** (또는 63) |

## Javax.sound.midi 설명

Javax.sound.midi는 JDK에 기본적으로 탑재되어 있는 패키지로 Soundbank의 MIDI 데이터를 다루고 소리를 합성하여 스피커로 출력해 주는 역할을 합니다.

### **Javax.sound.midi가 JDK에 기본 탑재된 이유**

자바가 처음 설계되던 1990년대 후반 ~ 2000년대 초반의 시대적 배경과 자바의 핵심 철학인 “Write Once, Run Anywhere”로 기본 탑재하게 되었습니다.(JS2E 1.3 버전부터 Java Sound API라는 이름으로 통합됨)

- **인터넷 환경과 용량의 한계 (Applet 시대)**
    
    당시는 인터넷 속도가 매우 느렸던 모뎀 시절이었습니다. 웹 브라우저에서 실행되는 자바 애플릿(Applet)이나 데스크톱 프로그램에 배경음악을 넣기 위해 수십 MB에 달하는 WAV나 MP3 파일을 포함하는 것은 불가능에 가까웠습니다. 반면 MIDI 파일은 실제 소리가 아닌 '연주 악보(데이터)'만 담고 있어 용량이 몇 KB에 불과했습니다. 따라서 적은 용량으로도 음악을 재생할 수 있는 MIDI 엔진을 JDK 자체에 내장하는 것이 필수적이었습니다.
    
- **플랫폼 독립성 (Write Once, Run Anywhere):**
자바의 슬로건인 "한 번 작성하면 어디서든 실행된다"를 오디오 영역에도 적용하기 위함이었습니다. 운영체제(Windows, Mac, Linux)마다 사운드 카드를 다루는 방식과 내장된 기본 신디사이저가 달랐습니다. 자바는 자체적인 소프트웨어 신디사이저와 MIDI API를 표준화하여 JDK에 포함시킴으로써, 개발자가 OS 환경을 신경 쓰지 않고도 동일한 코드로 음악을 재생할 수 있도록 만들었습니다.
- **멀티미디어 플랫폼으로의 확장:**
당시 Sun Microsystems(자바의 원작자)는 자바를 단순한 백엔드 언어가 아니라, 게임과 멀티미디어까지 포괄하는 종합 플랫폼으로 만들고자 했기 때문에 오디오 처리(Java Sound API)를 핵심 기능으로 편입시켰습니다.

### Javax.sound.midi의 핵심 구성 요소

- **Synthesizer (신디사이저)**
    - 악보 데이터를 받아서 실제 오디오 소리로 변환해 주는 '가상 악기 모듈'입니다.
    - 자바는 내장 신디사이저(주로 Gervill)를 제공하며, 기본적으로 128가지의 General MIDI 악기 소리를 품고 있습니다.
- **MidiChannel (미디 채널)**
    - 신디사이저 내부에 있는 '독립적인 연주 트랙'입니다. 총 16개(0~15번)의 채널이 있습니다.
- **Sequencer (시퀀서)**
    - 이미 만들어져 있는 MIDI 파일(`.mid`)을 통째로 읽어 들여 재생, 정지, 템포 조절 등을 할 수 있는 '카세트테이프 플레이어'입니다.
- **MidiMessage (미디 메시지)**
    - "몇 번 악기로 바꿔라", "가운데 도(60)를 80의 세기로 쳐라" 등의 **실제 명령 데이터**입니다. 컴퓨터 시스템 간에 음악 정보를 주고받을 때 사용되는 아주 가벼운 숫자들의 조합입니다.
