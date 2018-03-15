import javax.sound.midi.*;

import static java.lang.Thread.sleep;

public class MiniMusicApp
{
    private boolean def = true;
    private int instr = 1;
    private int note = 44;
    private int length = 8; // ticks
    private int sleepTime = 2; // seconds

    public static void main(String[] args)
    {
        MiniMusicApp miniPlayer = new MiniMusicApp();
        if (args.length != 2)
        {
            System.out.println("Подсказка: Для смены инструмента и ноты используйте " +
                    "следующий формат запуска:");
            System.out.println("> java MiniMusicApp <инструмент> <нота>");
            System.out.println("...");
            System.out.println("По-умолчанию запускаю Acoustic Grand Piano c нотой 44...");
        } else
        {
            try
            {
                miniPlayer.instr = Integer.parseInt(args[0]);
                miniPlayer.note = Integer.parseInt(args[1]);
                miniPlayer.def = false;
            } catch (NumberFormatException e)
            {
                System.out.println("ОШИБКА ФОРМАТА! <инструмент> и <нота> " +
                        "должны быть числами от 0 до 127.");
                // e.printStackTrace();
                System.out.println("...");
                System.out.println("По-умолчанию запускаю Acoustic Grand Piano c нотой 44...");
            }
        }
        if (miniPlayer.instr >= 0 && miniPlayer.instr <= 127
                && miniPlayer.note >= 0 && miniPlayer.note <= 127 )
        {
            miniPlayer.play();
        }
        else
        {
            System.out.println("ОШИБКА РАЗМЕРА! <инструмент> и <нота> " +
                    "должны быть числами от 0 до 127.");
        }
        System.out.println("Программа завершена.");
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

            if (!def)
            {
                ShortMessage first = new ShortMessage();
                first.setMessage(192, 1, instr, 0);
                MidiEvent changeInstrument = new MidiEvent(first, 1);
                t.add(changeInstrument);
                System.out.println("На дорожку добавлена смена инструмента.");
            }

            ShortMessage a = new ShortMessage();
            a.setMessage(144, 1, note, 100);
            MidiEvent noteOn = new MidiEvent(a, 1);
            t.add(noteOn);
            System.out.println("На дорожку добавлено звучание ноты.");

            ShortMessage b = new ShortMessage();
            b.setMessage(128, 1, note, 100);
            MidiEvent noteOff = new MidiEvent(b, length);
            t.add(noteOff);
            System.out.println("На дорожку добавлено выключение звучания ноты.");

            sequencer.setSequence(seq);
            System.out.println("В секвенсер загружена созданная последовательность.");

            sequencer.start();
            System.out.println("Секвенсер запущен.");

            System.out.println("Слушаем музыку и отдыхаем " + (sleepTime) + " (сек.)...");
            try
            {
                sleep(sleepTime * 1000);
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
