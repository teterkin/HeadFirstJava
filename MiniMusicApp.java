import javax.sound.midi.*;

import static java.lang.Thread.sleep;

public class MiniMusicApp
{
    public static void main(String[] args)
    {
        MiniMusicApp miniPlayer = new MiniMusicApp();
        miniPlayer.play();
    }

    private void play()
    {
        try
        {
            Sequencer sequencer = MidiSystem.getSequencer();
            System.out.println("MIDI секвенсер подключен.");
            sequencer.open();
            System.out.println("Секвенсер открыт.");

            Sequence seq = new Sequence(Sequence.PPQ, 4);
            System.out.println("Создана новая последовательность.");

            Track t = seq.createTrack();
            System.out.println("Создана дорожка (запись).");

            ShortMessage a = new ShortMessage();
            a.setMessage(144, 1, 44, 100);
            MidiEvent noteOn = new MidiEvent(a, 1);
            t.add(noteOn);
            System.out.println("На дорожку добавлено звучание ноты.");

            ShortMessage b = new ShortMessage();
            b.setMessage(128, 1, 44, 100);
            MidiEvent noteOff = new MidiEvent(b, 16);
            t.add(noteOff);
            System.out.println("На дорожку добавлено выключение звучания ноты.");

            sequencer.setSequence(seq);
            System.out.println("В секвенсер загружена созданная последовательность.");

            sequencer.start();
            System.out.println("Секвенсер запущен.");

            System.out.println("Слушаем музыку. Отдыхаем 5 секунд...");
            try
            {
                sleep(5000);
                System.out.println("Ожиание завершено. \n" +
                        "(Надеюсь вся музыка проиграна к этому моменту.)");
            }
            catch (InterruptedException e)
            {
                System.out.println("ОШИБКА! Ожидание прервано.\n" +
                        "Посмотрите трассировку ниже:");
                e.printStackTrace();
            }
            sequencer.stop();
            System.out.println("Секвенсер остановлен.");
            sequencer.close();
            System.out.println("Секвенсер закрыт.");
            System.out.println("Пока.");
        }
        catch (MidiUnavailableException e)
        {
            System.out.println("ОШИБКА! Не удалось подключить MIDI секвенсер.\n" +
                    "Посмотрите трассировку ниже:");
            e.printStackTrace();
        }
        catch (InvalidMidiDataException e)
        {
            System.out.println("ОШИБКА! Получены некоректные MIDI данные.\n" +
                    "Посмотрите трассировку ниже:");
            e.printStackTrace();
        }
    }

}
