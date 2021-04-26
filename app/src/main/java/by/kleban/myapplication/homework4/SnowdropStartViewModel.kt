package by.kleban.myapplication.homework4

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel


class SnowdropStartViewModel : ViewModel() {

    val screenLiveData = MutableLiveData(Screen.START)
    val snowdropLiveData = MutableLiveData<MutableList<Snowdrop>>(
        mutableListOf(
            Snowdrop(
                "Подснежник обыкновенный (Galanthus nivalis)",
                "https://rozisad.ru/wp-content/uploads/2019/02/galanthus-nivalis.jpg",
                "произрастает комфортно в зонах с 3 по 7. Высота растения – 15 — 30 см. " +
                        "Зацветает он в феврале. Цветок белый с зеленой V-образной каймой на " +
                        "внутренних лепестках. Предпочитает солнце или легкую полутень. " +
                        "Обладает ароматом с нотками меда."
            ),
            Snowdrop(
                "Гигантский подснежник (Galanthus elwesii)",
                "https://rozisad.ru/wp-content/uploads/2019/02/galanthus-elwesii-giant.jpg",
                "растет в зонах с 4 по 7. Высота – 15 — 30 см. Цветет с февраля по март. " +
                        "Окраска – белая, внутренние лепестки имеют v-образную зеленую кайму. " +
                        "Участок для посадки – солнечный или с легкой полутенью."
            ),
            Snowdrop(
                "Подснежник крымский (Galanthus plicatus)",
                "https://rozisad.ru/wp-content/uploads/2019/02/galanthus-plicatus-crimean.jpg",
                "растет в зонах с 3 по 8. Высота – от 17 см до 30 см. " +
                        "Время цветения – с февраля по март. Верхние лепестки – белые, внутренние " +
                        "имеют зеленую кайму в виде сердца. Солнце или небольшая полутень – " +
                        "оптимальное место для посадки."
            )
        )
    )

    fun changeScreen(screen: Screen) {
        screenLiveData.value = screen
    }

    fun addSnowdrop(snowdrop: Snowdrop) {
        val snowdrops = snowdropLiveData.value ?: mutableListOf()
        snowdrops.add(snowdrop)
        snowdropLiveData.value = snowdrops
    }
}