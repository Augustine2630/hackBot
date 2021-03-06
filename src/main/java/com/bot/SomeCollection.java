package com.bot;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class SomeCollection {
    List<String> motivationList = new ArrayList<>();
    {

        motivationList.add("По-моему, лень — это величайший порок. Ты человек — ты практически бог, но лень… Ты мог бы стать выдающимся ученым, программистом, художником или простым слесарем, который досконально знает свою работу и которого ценит начальство, но ты болен и болен ты ленью. Нельзя допустить прогрессирования болезни. Нужно немедленно взяться за ее лечение. \n" +
                "Теперь, осознавая то, что лень — это твоя болезнь, ты можешь сделать первый шаг в борьбе с нею. Так сделай же этот шаг!\n");
        motivationList.add("Представь, что лень — это чудовище, которое медленно пожирает тебя. И чтобы оно окончательно тебя не поглотило, нужно с ним бороться! Бить его, убегать от него. Каждый раз когда хочешь полежать на диване, вместо того, чтобы начать действовать, задумайся... Ты опять хочешь отдаться чудовищу? Ведь чем больше оно тебя пожирает, тем в дальнейшем легче ему.");
        motivationList.add("Так и сидишь сложа руки? Все никак не можешь приступить за работу?\n" +
                "Дам тебе несколько мотивирующих советов:\n" +
                "*Погрузись и действуй!\n" +
                "*Бери ответственность на себя.\n" +
                "*Кидай себя в ситуации, где у тебя нет другого выбора, кроме как действовать.\n" +
                "*Внедри привычку действовать вопреки своим эмоциям.\n" +
                "И чем больше правильных действий ты будешь выполнять вопреки своим эмоциям и действовать как та личность, которой ты хочешь стать, тем быстрее будет трансформация и постепенно твои эмоции начнут тебя подталкивать к этой личности, вместо того, чтобы сдерживать.\n");
        motivationList.add("Победа достаётся тому, кто вытерпит на полчаса больше, чем его противник - японская мудрость. Твой противник - это лень! Кажется, в этот раз она побеждает. Вытерпи на полчаса больше своей лени!");
    }

    List<String> boringList = new ArrayList<>();
    {
        boringList.add("Откладывание дел на будущее — это тоже лень! Вы должны осознать, что откладывая дела на потом, вы их никогда так и не закончите, а лишь соберете огромную кучу дел, которую уже никак нельзя будет разгрести. Делать все необходимо вовремя, а еще лучше — раньше запланированного срока, тогда к прибавится еще один позитивный момент — свободное время!");
        boringList.add("Просто закройте глаза и представьте две вещи:\n" +
                "а) Что будет, если вы справитесь с намеченным?\n" +
                "б) Что будет, если вы дальше будете продолжать валяться?\n");
        boringList.add("«Жить – значит постоянно отталкивать от себя то, что хочет умереть» Ф. Ницше");
        boringList.add("«Обучение — это не зрительский спорт» Д. Блочер");
        boringList.add("«Неграмотными людьми 21 века будут не те, кто не умеет читать и писать, а те, кто не умеет учиться и переучиваться» Алвин Тоффлер");
        boringList.add("«В конце концов имеет значение только то, чему ты научился и что по-настоящему усвоил» Гарри С. Труман\n");

    }
    List<String> studiedList = new ArrayList<>();
    {
        studiedList.add("«Обучение - это не средство достижения цели, это сама цель» Роберт Хайнлайн\n");
        studiedList.add("«Надо много учиться, чтобы знать хоть немного» Шарль Луи Монтескье");
        studiedList.add("«Легко в учении — тяжело в походе, тяжело в учении — легко в походе»\n" +
                "Александр Васильевич Суворов\n");
        studiedList.add("«Будь студентом до тех пор, пока тебе еще есть чему поучиться, и это будет означать всю твою жизнь» Генри Л. Доэрти");

    }
    List<String> boilingList = new ArrayList<>();
    {
        boilingList.add("“Умение отдыхать для некоторых искусство потруднее, чем умение работать.” - И. Шевелев. Сегодня ты отлично поработал(а) - так самое время отлично отдохнуть!\n");
        boilingList.add("“Труд без отдыха - не достоинство, а наказание за неудачное планирование своего времени” - так говорили великие…А я говорю, что ты молодец! Но прислушаемся к мудрецам: самое время отдохнуть и восстановить силы перед новыми победами!\n");
        boilingList.add("Превосходно! С таким усердием ты быстро достигнешь своей цели! Но не забывай, что настоящие победители после очередного достижения ставят перед собой новые цели. А чтобы сил хватало для всех побед, нужно не забывать отдыхать, чтобы как следует этому порадоваться!\n");
    }

    public String getRandomBoiled() {
        int a = 0;
        int b = boilingList.size();
        int randomNumber = a + (int) (Math.random() * b);
        return boilingList.get(randomNumber);
    }
    public String getRandomStudied() {
        int a = 0;
        int b = studiedList.size();
        int randomNumber = a + (int) (Math.random() * b);
        return studiedList.get(randomNumber);
    }
    public String getRandomBoring() {
        int a = 0;
        int b = boringList.size();
        int randomNumber = a + (int) (Math.random() * b);
        return boringList.get(randomNumber);
    }
    public String getRandomMotivation() {
        int a = 0;
        int b = motivationList.size();
        int randomNumber = a + (int) (Math.random() * b);
        return motivationList.get(randomNumber);
    }

}
