package com.vsu.dsrproject.component;

import com.vsu.dsrproject.app.Launcher;
import com.vsu.dsrproject.data.Languages;
import com.vsu.dsrproject.entity.Language;
import com.vsu.dsrproject.entity.Training;
import com.vsu.dsrproject.entity.Word;
import com.vsu.dsrproject.repository.LanguageRepository;
import com.vsu.dsrproject.repository.TrainingRepository;
import com.vsu.dsrproject.repository.WordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;
import java.util.List;

@Component
public class DbInit {


    @Autowired
    private WordRepository wordRepository;

    @Autowired
    private LanguageRepository languageRepository;

    @Autowired
    private TrainingRepository trainingRepository;

    @PostConstruct
    @Transactional
    public void init() {
        Languages.languageRu = new Language();
        Languages.languageRu.setName("Russian");
        Languages.languageRu.setCode("RU");
        languageRepository.save(Languages.languageRu);

        Languages.languageEn = new Language();
        Languages.languageEn.setName("English");
        Languages.languageEn.setCode("EN");
        languageRepository.save(Languages.languageEn);

        Word word = new Word();
        word.setWord("head");
        word.setLanguage(Languages.languageRu.getCode());
        word.setTranslate("голова");
        word.setCallCount(0);
        word.setTrueCount(0);
        wordRepository.save(word);

        Training training = new Training();
        training.setName("Random");
        training.setCallCount(0);
        training.setBestResult(0);
        training.setWorstResult(10);
        training.setPoints(0);
        trainingRepository.save(training);

        Training trainingH = new Training();
        trainingH.setName("Hard");
        trainingH.setCallCount(0);
        trainingH.setBestResult(0);
        trainingH.setWorstResult(10);
        trainingH.setPoints(0);
        trainingRepository.save(trainingH);
        String rus = "эффективно, контроля, ваш, герой, в то время как, сбор, информация, от, интернет, игры, мире, вокруг, вы, это, важно, для, обеспечение, ваш, команда, имеет, интернет, верхний, руку, в, его, квест, для, уничтожить, интернет, врага, древние, с, интернет, дебют, из, а, полностью, переработана, внутриигровой, интерфейс, игроков, выигрыш, возросла, видения, из, интернет, карте, и, несколько, новый, способами, для, см, детали, из, что, происходит, в, каждый, игры, использовать, интернет, новый, упрощенный, фоне, вариант, для, помочь, разобрать, интернет, миникарты, больше, быстро, шкале, интернет, миникарты, для, а, Размер, из, ваш, вкусу, мы, также, добавил, АН, индикатор, из, что, дружелюбный, структура, или, блок, будет, быть, целевые, прежде чем, вы, телепортироваться";
        String en = "efficiently, controlling, your, hero, while, gathering, information, from, the, game, world, around, you, is, crucial, to, ensuring, your, team, has, the, upper, hand, in, its, quest, to, destroy, the, enemy, ancient, with, the, debut, of, a, completely, redesigned, ingame, interface, players, gain, increased, vision, of, the, map, and, multiple, new, ways, to, see, details, of, whats, happening, in, each, game, use, the, new, simplified, background, option, to, help, parse, the, minimap, more, quickly, scale, the, minimap, to, a, size, of, your, liking, weve, also, added, an, indicator, of, which, friendly, structure, or, unit, will, be, targeted, before, you, teleport";
        String rusArr[] = rus.split(", ");
        String enArr[] = en.split(", ");
        for(int i = 0; i< rusArr.length;i++){
            Word w = new Word();
            w.setWord(enArr[i]);
            w.setLanguage(Languages.languageRu.getCode());
            w.setTranslate(rusArr[i]);
            w.setCallCount(0);
            w.setTrueCount(0);
            wordRepository.save(w);
        }
    }
}
