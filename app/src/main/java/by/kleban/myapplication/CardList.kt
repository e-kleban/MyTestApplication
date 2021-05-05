package by.kleban.myapplication


class CardList {

    companion object {
        fun createList(): MutableList<Card> {
            return mutableListOf(
                Card(
                    "Праздник радостный и светлый\n" +
                            "Отмечает вся страна.\n" +
                            "Пусть всем мирно солнце светит\n" +
                            "Миру не нужна война.\n" +
                            "\n" +
                            "С Днем Победы всех поздравим,\n" +
                            "Слава павшим и живым.\n" +
                            "Подвиг ваш великий славим\n" +
                            "И «спасибо» говорим.",
                    "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRb" +
                            "_0R-n_JWQk5Z_kpHfPa-RezqsuL8sMeR_Q&usqp=CAU"
                ),
                Card(
                    "9 Мая — праздник великий!\n" +
                            "Никто не забыт и ничто не забыто!\n" +
                            "Живым ветеранам — низкий поклон!\n" +
                            "А тех, что ушли — не забудем имен!\n" +
                            "\n" +
                            "Они ушли, оставив память,\n" +
                            "Оставив честь нам и свободу,\n" +
                            "Осталось красное их знамя,\n" +
                            "Перенесенное сквозь годы!\n" +
                            "\n" +
                            "Великий подвиг сохраним\n" +
                            "Мы в наших душах и сердцах\n" +
                            "И об ушедших помолчим\n" +
                            "Мы со слезами на глазах!\n",
                    "https://encrypted-tbn0.gstatic.com/images?q=tbn:" +
                            "ANd9GcS2LaAIC8q_lpHfGx0wqsr4Lg7VJHMigWNUMg&usqp=CAU"
                ),
                Card(
                    "Поздравляю с Днем Победы\n" +
                            "И желаю в этот день\n" +
                            "Море радости и света,\n" +
                            "И здоровья, как кремень!\n" +
                            "\n" +
                            "Не забыт великий праздник,\n" +
                            "Хоть прошли уже года.\n" +
                            "Желаю вам добра и счастья,\n" +
                            "Неба мирного всегда!",
                    "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcS" +
                            "4LbNB9_z07_hNuIrnE7owh8fdjbSvvhej0A&usqp=CAU"
                )
            )
        }
    }
}